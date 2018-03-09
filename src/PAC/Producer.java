package PAC;

import java.util.List;

public class Producer {
    private Object obj;
    private List<Integer> products;
    private int maxCapacity;
    private int id;
    public Producer(Object obj, List products, int maxCapacity){
        this.obj = obj;
        this.products = products;
        this.maxCapacity = maxCapacity;
        this.id = 0;
    }
    public synchronized void produce(){
        System.out.println("容量" + products.size());
        if(products.size()==this.maxCapacity){
            System.out.println("已达到最大容量");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("生产" + (++id));
        products.add(id);
        notifyAll();
    }
}
