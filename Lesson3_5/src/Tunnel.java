import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    static Semaphore smp;
    public Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }
    static {
        // ограничиваем количество потоков при работе с ресурсами
        smp = new Semaphore(MainClass.CARS_COUNT / 2);
    }
    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
               // захватываем ресурс
                smp.acquire();
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                // освобождаем ресурс для других потоков
                smp.release();
                System.out.println(c.getName() + " закончил этап: " + description);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
