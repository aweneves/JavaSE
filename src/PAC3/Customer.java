package PAC3;

import java.util.List;

public class Customer implements Runnable{
    private List<Integer> products;
    private int minCapacity;
    public Customer(List products, int minCapacity){
        this.products = products;
        this.minCapacity = minCapacity;
    }
    @Override
    public void run() {
      //      System.out.println(products.size() + "-----" + this.minCapacity);
        try {
            while(true) {
                if (products.size() == 0) {
                    System.out.println("已达到最小容量");
                }
//            System.out.println("C容量" + products.size());
                int id = products.remove(0);
                System.out.println("C消费： " + id);
                Thread.sleep(1000);
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
