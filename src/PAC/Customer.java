package PAC;

import java.util.List;

public class Customer {
    private Object obj;
    private List<Integer> products;
    private int minCapacity;
    public Customer(Object obj, List products, int minCapacity){
        this.obj = obj;
        this.products = products;
        this.minCapacity = minCapacity;
    }
    public synchronized void custom(){
        System.out.println("容量" + products.size());
        if(products.size()==this.minCapacity){
            System.out.println("已达到最小容量");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int id = products.remove(0);
        System.out.println("消费： " + id);
        notifyAll();
    }
}
