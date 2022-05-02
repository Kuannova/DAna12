package Week13;

public class Exe30_11 {
    public static void main(String[] args) {
        final String resource1 = "nkjn";
        final String resource2 = "lll";

        Thread t3 = new Thread() {
            public void run() {
                synchronized (resource1) {
                    System.out.println("Thread 1: заблокированный ресурс 1");
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                    }

                    synchronized (resource2) {
                        System.out.println("Thread 1: заблокированный ресурс 2");
                    }
                }
            }
        };
        Thread t9 = new Thread() {
            public void run() {
                synchronized (resource2) {
                    System.out.println("Thread 2: заблокированный ресурс 2");
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                    }
                    synchronized (resource1) {
                        System.out.println("Thread 2: заблокированный ресурс 1");
                    }
                }
            }
        };
        t3.start();
        t9.start();
    }
}
