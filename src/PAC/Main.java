package PAC;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        Object obj = new Object();
        List<Integer> products = new ArrayList<>();
        int maxCapacity = 10;
        int minCapacity = 0;
        Producer producer = new Producer(obj,products,maxCapacity);
        Customer customer = new Customer(obj,products,minCapacity);
        for(int i=0; i<11; i++){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            new Thread(new Runnable() {
                @Override
                public void run() {
                    producer.produce();
                }
            }).start();
        }
        for(int i=0; i<11; i++){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            new Thread(new Runnable() {
                @Override
                public void run() {
                    customer.custom();
                }
            }).start();
        }
    }

}
