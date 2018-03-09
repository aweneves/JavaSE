package PAC5;

import java.util.List;
import java.util.concurrent.BlockingQueue;

public class Customer implements Runnable{
    private BlockingQueue<Integer> products;
    private int minCapacity;
    public Customer(BlockingQueue products, int minCapacity){
        this.products = products;
        this.minCapacity = minCapacity;
    }
    @Override
    public void run() {
        try {
            while(true) {
                if (products.size() == 0) {
                    System.out.println("已达到最小容量");
                }else {
                    int id = products.take();
                    System.out.println("C消费： " + id);
                }
                Thread.sleep(1000);
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
