import java.util.concurrent.atomic.AtomicInteger;

public class Shop {
    @SuppressWarnings("removal")
    public static void main(String[] args) {
        Connection c = new Connection();
        Consumer s = new Consumer(c);
        Producer p = new Producer(c);
        // s.start();
        s.checkAccess();
        AtomicInteger a = new AtomicInteger();
    }

}
/**
class Consumer extends
 */
class Consumer extends Thread {
    Connection c ;
    Consumer(Connection c){
        this.c = c;
        start();
    }
    public void run(){
        ;
        for(int i = 0 ; i<4;i++){
            System.out.println("consumer "+i);
            c.consume(i);
        }
    }

}
class Producer extends Thread {
    Connection c ;
    Producer(Connection c){
        this.c = c;
        start();
    }
    public void run(){
        ;
        for(int i = 0 ; i<4;i++){
            // System.out.println("Producer  "+i);
            c.produce(i);
        }
    }

}
/**
 *  Connection
 */
class  Connection {
    Boolean b = false;
    synchronized void consume(int n){
        if(!b){
            try{
                wait();
            }
            catch(Exception e){

            }
            System.out.println("consume"+ n);
            b=false;
            notify();
        }
    }
    synchronized void produce(int n){
        // boolean b = false;
        if(b){
            try{
                wait();
            }
            catch(Exception e){

            }
            System.out.println("cpr"+ n);
            b=true;
            notify();
        }
    }    
    
}