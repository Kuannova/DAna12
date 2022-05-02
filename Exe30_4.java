package Week13;

import java.util.concurrent.*;
public class Exe30_4 {
    private static Integer sum = new Integer();
    public static void main(String[] args) {
        for(int j=0;j<10;j++) {
            sum=new Integer();
            ExecutorService executor = Executors.newFixedThreadPool(1000);
            for(int i = 0;i < 1000;i++){
                executor.execute(new AddOne());
            }
            executor.shutdown();
            while (!executor.isTerminated()) {
            }
            System.out.println(sum.get());
        }
    }
    public static class Integer {
        private int sum = 0 ;
        public void add(int x) {
            sum += x;
        }
        public int get(){
            return  sum;
        }
    }
    public static class AddOne implements Runnable{
        public void run() {
            sum.add(1);
        }

    }

}