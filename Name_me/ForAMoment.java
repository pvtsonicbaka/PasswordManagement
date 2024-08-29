public class ForAMoment {
    public static void main(String[] args) {
        StarBucks s = new StarBucks();
        Customer c1 = new Customer("Student 1", s);
        Chef a1 = new Chef("Chef 1", s);
        a1.start();
        c1.start();

    }
}
class StarBucks{
    int Order;
    boolean isReady;

    public StarBucks() {
        isReady = false;
    }
    synchronized void drink(){
        if(!isReady){
            try {
                wait();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        System.out.println("drinking :"+Order);
        isReady = false;
        notify();


    }
    synchronized void makeDrink(int NewOrder){
        if(isReady){
            try {
                wait();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        Order = NewOrder;
        System.out.println("prepared Order"+ Order);
        isReady = true;
        notify();
    }
}
class Customer extends Thread{
    StarBucks sb;
    Customer(String s,StarBucks sb){
        super(s);
        this.sb = sb;


    }
    public void run(){
        Thread t = Thread.currentThread();
        System.out.println(t+"is tacking chef ");
        for(int i =0;i<3;i++){
        sb.drink();
            try {   
                sleep(3000);
        } catch (Exception e) {
            // TODO: handle exception
        }

        }

    }
}
class Chef extends Thread{
    StarBucks sb;

    Chef(String s,StarBucks sb){
        super(s);
        this.sb = sb;

    }
    public void run(){
        Thread t = Thread.currentThread();
        System.out.println(t+"is tacking chef ");
        for(int i =0 ;i<5;i++){
            sb.makeDrink(i);
            try {   
                    sleep(3000);
            } catch (Exception e) {
                // TODO: handle exception
            }
        }

    }
}
