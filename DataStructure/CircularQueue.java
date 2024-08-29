import java.util.Scanner;

/**
 * CircularQueue
 */
public class CircularQueue {

    static int a[];
    static int f=-1;
    static int r=-1;
    static  int size;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        a = new int[size];
        int n=0;
        boolean b  = true;
        while(b){
            System.out.println("enter");
            n = sc.nextInt();

       switch ( n) {
        
        
        case 1:int s = sc.nextInt();
            rearAdd(s);
            break;
       
        case 2:
        frontDelte();
        break;
        case 3:
        int k = sc.nextInt();
        frontAdd(k);
        // display();
        break;
        case 4:
        frontDelte();;
        case 5:
        display();
        case 6:


        b = false;
        break;
        default:
            break;
       }}
    }
    static void rearAdd(int y){
        if((r==size-1 && f==0 )|| f==r+1){
            System.out.println("overflow");
        }
        else{
            if(r==-1){
                r++;
                f++;
            }
            else if(r==size -1 && f>0){
                r=0;
            }
            else{
                r++;
            }
            a[r] = y;
            System.out.println(a[r]+ " is inserted");
        }
    }
    static void frontDelte(){
        // int *x;
        if(f==-1){
            System.out.println("underflow ");
        }else{
            int y = a[f];
            if(f==r){
                f=-1;r=-1;

            }
            else{
                if(f==size-1){
                    f=0;
                }
                else{
                    f++;
                }
            }
            System.out.println(y+"is deleted");
        }
    }
    static void frontAdd(int y){
        if((f==0 && r==(size-1)) && f==r+1 ){
            System.out.println("overflow");
        }
        else{
            if(f==-1){
                r++;
                f++;
            }
            else{
                f=(f+1 % size);
            }
            a[f] =y;
            System.out.println(y+" is inserted ");


        }
    }
    static void rearDeelet(){
        if(f==-1 || r==-1){
            System.out.println("ober");
        }
        else{
            int y = a[r];
            if(r==f){
                r=-1;
                f=-1;

            }
            else if(r==0 ){ 
                r=size-1;
            }
            else{
                r--;
            }
            System.out.println(y +"is inserted");
        }

    }
    static void display(){
        int i =f ;
        System.out.println("wuee");
        while (i!=r) {

            System.out.println((a[i]));
            i=i+1%size;
        }
        System.out.println(a[i]);
    }


}