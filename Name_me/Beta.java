import java.io.*;
public class Beta {
    public static void main(String args[]) throws InterruptedException{

        int n = Integer.parseInt(args[0]);
        if(n<=50){
            for(int i = 1;i<=n;i++){
                if(i%2 !=0){MyThread mt = new MyThread(i);
                mt.start();}

            }
            
        }else{
            
            for(int i = 1;i<=50;i++){
                if(i%2 !=0){MyThread mt2 = new MyThread(i);
                mt2.start();
            mt2.join();}
            }
            for(int i = 51;i<=n;i++ ){
                if(i%2 !=0){MyThread mt3 = new MyThread(i);
                mt3.start();}

            }
        }
    }

}

class MyThread extends Thread{
    int n;
    public MyThread(int n) {
        this.n = n;
    }

    PrintStream p = new PrintStream(System.out);
    public void run(){
            p.println(n);
    }
}