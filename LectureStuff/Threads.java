

public class Threads extends Thread {
    public static void main(String[] args) {
        Threads t = new Threads();
        // Threads t2= new Threads();
        si ssi = new si();
        t.setDaemon(true);
        unsi
        t.start();
        
            // @SuppressWarnings

            // t.join();
            
        
            // ssi.start();
        // t2.start();
        System.out.println("ss");
    }
   public void run(){
    for(int i=0;i<10;i++)
    System.out.println("running"+this.getName()+" "+i); 
    }
}

 class  si extends Thread {
     
     public void run(){
        for(int i=0;i<10;i++)
        System.out.println("si "+ this.getName()+i);
    }
}
