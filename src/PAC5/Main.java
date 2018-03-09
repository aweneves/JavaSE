package PAC5;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {
    public static void main(String[] args){
        BlockingQueue<Integer> products = new ArrayBlockingQueue<Integer>(5);
        int maxCapacity = 5;
        int minCapacity = 0;
        Producer producer = new Producer(products,maxCapacity);
        Customer customer = new Customer(products,minCapacity);

        for(int i=0; i<3; i++){
            Thread tc = new Thread(customer);
            tc.setName("tc" + i);
            tc.start();
        }
        for(int i=0; i<3; i++){
            Thread tp = new Thread(producer);
            tp.setName("tp" + i);
            tp.start();
        }
    }

}
