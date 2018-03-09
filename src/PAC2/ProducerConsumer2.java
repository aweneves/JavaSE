package PAC2;
public class ProducerConsumer2{
    public static void main(String[] args){
        SyncStack ss = new SyncStack();
        Producer p = new Producer(ss);
        Consumer c = new Consumer(ss);
        new Thread(p).start();
        new Thread(c).start();
    }
}
class ManTou{
    int id;
    ManTou(int id){
        this.id = id;
    }
    public String toString(){
        return "ManTou: " + this.id;
    }
}
class SyncStack{
    ManTou[] m = new ManTou[6];
    int index = 0;
    public synchronized void push(ManTou mt){
        while(index == m.length){
            try{
                this.wait();
            }catch(InterruptedException ie) {}
        }
        m[index] = mt;
        index ++;
        this.notifyAll();
    }

    public synchronized ManTou pop(){
        while(index == 0){
            try{
                this.wait();
            }catch(InterruptedException ie) {}
        }

        index --;
        this.notifyAll();
        return m[index];
    }
}
class Producer implements Runnable{
    SyncStack ss = null;
    Producer(SyncStack ss){
        this.ss = ss;
    }
    public void run(){
        for(int i=0;i<6;i++){
            ManTou m = new ManTou(i);
            ss.push(m);
            System.out.println("Producer" + m);
            try {
                Thread.sleep((int)(Math.random() * 200));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable{
    SyncStack ss = null;
    Consumer(SyncStack ss){
        this.ss = ss;
    }
    public void run(){
        for(int i=0;i<6;i++){
            System.out.println("Consumer" + ss.pop());
            try {
                Thread.sleep((int)(Math.random() * 500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}