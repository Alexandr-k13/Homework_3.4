package geekbrains;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Flowcontrol {
    private static String i;

    public static void main(String[] args) {
        ExecutorService serv = Executors.newFixedThreadPool(5);
        for( int i = 0; i < 20; i++);
        String q = "#" + i;
        serv.submit(()-> {
            System.out.println(Thread.currentThread().getName() + "-" + q);
            for (int j = 0; j < 20; j++) ;
            Thread.sleep(200);
        }catch (InterruptedException e) {
            e.PrintStackTrace();

        }


    }
}



