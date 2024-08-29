//i aint giving class name 
public class Q_151 {
        public static void main(String[] args) {
        Bowler b = new Bowler("yorker");;
        Bowler b2 = new Bowler("googly");

        b.start();
        try {
                b.join();
        } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
        b2.start();
        }
}

/**
 *  Bowler extends Thread
 */
 class  Bowler extends Thread {
        Bowler(String s){
                super(s);
        }
        public void run(){
                Thread t = Thread.currentThread();
                if(t.getName().equalsIgnoreCase("yorker")){
                        System.out.println("sixer");
                }
                else if(t.getName().equalsIgnoreCase("googly")){
                        System.out.println("wicket");
                }
                else{
                        System.out.println("?? idk ");
                }
        }
    
}