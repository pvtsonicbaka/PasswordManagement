import java.util.Scanner;

 class Queue1 {
    static int a[];
    static int f=-1;
    static int r=-1;
    static  int size;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        size= sc.nextInt();
        a = new int[size];
        boolean b = true;
        while (b) {
            System.out.println("enter 1 to enQueu \nenter 2 to deQueue\nenter 3 to display \nenter 4 to exit");
            int n = sc.nextInt();
            switch (n) {
                case 1:
                    System.out.println("enter element");
                    int s = sc.nextInt();
                    enQueue(s);
                    break;
                case 2 :
                deQueue(); break;
                case 3: display(); break;
                case 4: 
                    b= false;
                    break;
                default:
                System.out.println("invalid");
                    break;
            }

        }
        sc.close();

    }
    static void enQueue(int y){
        if(r >=size-1){
            System.out.println("overflow");
        }
        else{
            if( r==-1 ){
                r=0;f=0;
            }
            else{
                r++;
            }
            a[r] = y;
        }
    }
    static void deQueue(){
        int k;
        if(f==-1){
            System.out.println("underflow");
        }
        else{
            k = a[f] ;
            if(f==r){
                // f=-1;
                r=-1;
            }
            f++;
            System.out.println(k+"element deleted");
        }
    }
    static  void display(){
        if( f>0)
        for(int i =f;i<=r;i++){
            System.out.println(a[i]);
        }
    }

}

