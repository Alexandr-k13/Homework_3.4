package geekbrains;

public class Flow {
    static String str = "A";

    public static void main(String[] args) {
        Object lock = new Object();

        class MyFlow implements Runnable {

            private String b;
            private String nextB;

            public MyFlow(String b, String nextB) {
                this.b = b;
                this.nextB = nextB;

            }

            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    synchronized (lock) {
                        try {
                            while (str.equals(b))
                            lock.wait();
                            System.out.print(b);
                            str = nextB;
                            Thread.sleep(2);
                            lock.notifyAll();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }

            }
        }

        new Thread(new MyFlow("A", "B")).start();
        new Thread(new MyFlow("B", "C")).start();
    }
}