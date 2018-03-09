package PAC6;

import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Producer implements Runnable{
    private List<Integer> products;
    private int maxCapacity;
    private int id;
    private ReentrantLock lock;
    private Condition condition;
    public Producer(List products, int maxCapacity, ReentrantLock lock){
        this.products = products;
        this.maxCapacity = maxCapacity;
        this.id = 0;
        this.lock = lock;
        this.condition = lock.newCondition();
    }

    @Override
    public void run() {
        lock.lock();
        try {
            while(true) {
                if (products.size() == this.maxCapacity) {
                    condition.await();
                    System.out.println("已达到最大容量");
                } else {
                    products.add(++id);
                    System.out.println("P生产： " + id);
                }
                condition.signalAll();
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
                    e.printStackTrace();
        }
        lock.unlock();
    }
}
