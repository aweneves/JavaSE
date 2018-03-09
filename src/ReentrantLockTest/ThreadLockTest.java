package ReentrantLockTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadLockTest {
    public static void main(String[] args) throws InterruptedException {

        final ExecutorService exec = Executors.newFixedThreadPool(4);

        final Object obj = new Object();

        final Runnable add = new Runnable() {

            public void run() {

                System.out.println("Pre " + this.toString());

                synchronized (obj) {

                    try {

//                    con.await(time, TimeUnit.SECONDS);
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {

                        e.printStackTrace();

                    } finally {

                        System.out.println("Post " + this.toString());

                    }
                }

            }

        };

        for(int index = 0; index < 4; index++)

            exec.submit(add);

        exec.shutdown();

    }
}
