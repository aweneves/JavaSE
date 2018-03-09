package PAC5;

import java.util.List;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{
    private BlockingQueue<Integer> products;
    private int maxCapacity;
    private int id;
    public Producer(BlockingQueue products, int maxCapacity){
        this.products = products;
        this.maxCapacity = maxCapacity;
        this.id = 0;
    }

    @Override
    public void run() {
        try {
            while(true) {
                if (products.size() == this.maxCapacity) {
                    System.out.println("已达到最大容量");
                } else {
                    products.offer(++id);
                    System.out.println("P生产： " + id);
                }
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
                    e.printStackTrace();
        }
    }
}
