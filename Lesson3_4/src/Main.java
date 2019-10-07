public class Main {

    public static void main(String[] args) throws InterruptedException {

        // Task 1 Создать три потока,
        // каждый из которых выводит определенную букву (A, B и C) 5 раз
        // (порядок – ABСABСABС). Используйте wait/notify/notifyAll.
        new Letters().go();
        System.out.println();
        // Task 2 Создать три потока, каждый из которых выводит
        // определенную букву (A, B и C) 5 раз (порядок – AАBССAАBСС).
        // Используйте wait/notify/notifyAll
       //new Letters2().go();
    }
}

