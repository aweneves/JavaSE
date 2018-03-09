package PAC3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        List<Integer> products = new ArrayList<>();
        int maxCapacity = 5;
        int minCapacity = 0;
        Producer producer = new Producer(products,maxCapacity);
        Customer customer = new Customer(products,minCapacity);

        for(int i=0; i<3; i++){
            Thread tp = new Thread(producer);
            tp.setName("tp" + i);
            tp.start();
        }
        for(int i=0; i<3; i++){
            Thread tc = new Thread(customer);
            tc.setName("tc" + i);
            tc.start();
        }
    }

}
