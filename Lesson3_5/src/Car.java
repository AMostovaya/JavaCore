import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable {
    private static int CARS_COUNT;

    private static CyclicBarrier startBarrier;
    private static CountDownLatch cdlFinish;
    private static CountDownLatch cdlReady;

    static {
        CARS_COUNT = 0;
        cdlFinish = MainClass.countDownLatchFinish;
        cdlReady = MainClass.countDownLatchReady;
        startBarrier = MainClass.startBarrier;
    }
    private Race race;
    private int speed;
    private String name;
    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;


    }
    @Override
    public void run() {
        try {

            System.out.println(this.name + " готовится");
            Thread.sleep(100 + (int)(Math.random() * 800));
            // уменьшаем количество операций
            cdlReady.countDown();
            System.out.println(this.name + " готов");
            // запускаем режим ожидания
            startBarrier.await();

        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        cdlFinish.countDown();
    }
}
