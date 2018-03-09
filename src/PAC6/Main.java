package PAC6;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args){
        List<Integer> products = new ArrayList<>();
        ReentrantLock lock = new ReentrantLock();
        int maxCapacity = 5;
        int minCapacity = 0;
        Producer producer = new Producer(products,maxCapacity,lock);
        Customer customer = new Customer(products,minCapacity,lock);

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
