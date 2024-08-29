import java.util.Scanner;

public class Queue1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       

        
    }

}
class Q{
    public int r=-1;
    public int f = -1;
    public int size =1000000 ;
    public int a[]  = new int[size];

    public void enQueue(int n){
        if(r>size-1){
            System.out.println("Overflow");
            return;
        }
        else{
        if(f==-1){
            f=0;
            r=0;
        }
        else{
            r++;
        }
        a[r]=n;
        System.out.println(n+"is inserted");
        }
    }
    public void displayTwoQueues(){
        
    }   
    public void deQueue(){
        if(f==-1){
            System.out.println("Underflow");
        }
        else{
            int  y = a[f];
            if(f==r){
                f=-1;
                r=-1;
            }
            else{
                f++;
            }
            System.out.println(y+"is deleted");
        }

    }
    public void display(){
        if(f==-1){
            System.out.println("Queue is empty");
        }
        else{
            for(int i = f;i<=r;i++){
                System.out.print(a[i]+" ");
            }
            System.out.println();
        }
    }
    
}
