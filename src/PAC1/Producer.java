package PAC1;

import java.util.List;

public class Producer implements Runnable{
    private List<Integer> products;
    private int maxCapacity;
    private int id;
    public Producer(List products, int maxCapacity){
        this.products = products;
        this.maxCapacity = maxCapacity;
        this.id = 0;
    }

    @Override
    public synchronized void run() {
        try {
            while(true) {
                if (products.size() == this.maxCapacity) {
                    wait();
                    System.out.println("已达到最大容量");
                }
                products.add(++id);
                System.out.println("P生产： " + id);
//                System.out.println("P容量" + products.size());

                notifyAll();
//                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
                    e.printStackTrace();
        }
    }
}
