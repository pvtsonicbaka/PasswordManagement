import java.util.Scanner;

class CircularLL{
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    Node head = null;
    public static void main(String[] args) {
        CircularLL s = new CircularLL();
        Scanner sc  = new Scanner(System.in);
        int n =0;
        while (n!=10) {
            System.out.println("enyer");
            n = sc.nextInt();
            switch (n) {
                case 1 :
                    int data = sc.nextInt();
                    s.addFirst(data);
                    break;
                case 2 :
                    int data1 = sc.nextInt();
                    s.addLast(data1);
                    break;
                case 3 : 
                    s.deleteFirst();
                    break;
                case 4 :
                    
                    s.display();break;
                case 5 :

                
                    
            
                default : System.out.println("sknan");
            }
        }


    }
    void addFirst(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            newNode.next = head;
        }
        else{
            Node temp = head;
            while(temp.next != head){
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next=head;
            head = newNode;
        }
    }
    void addLast(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            newNode.next = head;
        }
        else{
            Node temp = head;
            while(temp.next != head){
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next=head;
        }
    }
    void deleteFirst(){
        if(head == null){
            System.out.println("List is empty");
        }
        else{
            Node temp = head;
            while(temp.next != head){
                temp = temp.next;
            }
            temp.next = head.next;
            head = head.next;



        }
    }
    void display(){
        if(head ==null){
            System.out.println("empty");
            return;
        }
        Node temp = head;
        System.out.print("--->");
        while(temp.next != head){
            System.out.print(temp.data+" -> ");
            temp = temp.next;
            }
            System.out.println(temp.data+"---");

    }

    

}