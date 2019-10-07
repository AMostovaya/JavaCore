 class Letters {

    Runnable A, B, C;

    void go() {

        Object lock = new Object();

        A = () -> {
            synchronized (lock) {
                for (int i = 0; i < 5; i++) {

                    System.out.print("A");
                    try {
                        Thread.sleep(1000);

                        lock.notifyAll();
                        lock.wait();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }


        };

        B = () -> {
            synchronized (lock) {
                for (int i = 0; i < 5; i++) {

                    System.out.print("B");
                    try {
                        Thread.sleep(1000);


                        lock.notifyAll();
                        lock.wait();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }


        };

        C = () -> {
            synchronized (lock) {

                for (int i = 0; i < 5; i++) {

                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.print("C");

                    try {

                        Thread.sleep(1000);


                        lock.notifyAll();
                        lock.wait();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }


        };

        new Thread(A).start();
        new Thread(B).start();
        new Thread(C).start();

    }
}

    // Task 2
     class Letters2 {

        Runnable A, B, C;
         private Thread MyThread;

         void go() throws InterruptedException {

            Object lock = new Object();

            A = () -> {

                synchronized (lock) {

                    for (int i = 0; i < 5; i++) {
                        System.out.print("A");
                        try {
                            Thread.sleep(1000);

                            lock.notifyAll();
                            lock.wait();

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                   
                }
            };

             Thread myThread = new Thread(A,"A");
             myThread.start();
           // myThread.notifyAll();


            B = () -> {
                synchronized (lock) {
                    for (int i = 0; i < 5; i++) {

                        System.out.print("B");
                        try {
                            Thread.sleep(1000);
                            lock.notifyAll();
                            lock.wait();

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }


            };

            C = () -> {
                synchronized (lock) {

                    for (int i = 0; i < 5; i++) {

                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        System.out.print("C");

                        try {
                            Thread.sleep(1000);


                            lock.notifyAll();
                            lock.wait();

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }


            };
            new Thread(A).start();
            new Thread(B).start();
            new Thread(C).start();


        }


    }



