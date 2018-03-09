package PAC6;

import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Customer implements Runnable{
    private List<Integer> products;
    private int minCapacity;
    private ReentrantLock lock;
    private Condition condition;
    public Customer(List products, int minCapacity, ReentrantLock lock){
        this.products = products;
        this.minCapacity = minCapacity;
        this.lock = lock;
        this.condition = lock.newCondition();
    }
    @Override
    public void run() {
        lock.lock();
        try {
            while(true) {
                if (products.size() == 0) {
                    System.out.println("已达到最小容量");
                    condition.await();
                }else {
                    int id = products.remove(0);
                    System.out.println("C消费： " + id);
                }
                condition.signalAll();
                Thread.sleep(1000);
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
    }
}
