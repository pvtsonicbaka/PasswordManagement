import java.util.Scanner;

public class LL {
    public static void main(String[] args) {
        SingleLinkedList l = new SingleLinkedList();
        Scanner sc = new Scanner(System.in);
        int n;
        
        StackUsingSLL s = new StackUsingSLL();
        QueueUsingLL q = new QueueUsingLL();
        // q.enqueue(10);
        l.addFirst(10);
        l.addFirst(130);
        l.addFirst(320);
        l.addFirst(1410);
        l.addFirst(23);
        l.printList();
        l.printOddList();
        l.endPrint(l.Head);
        // q.enqueue(20);
        // q.enqueue(30);
        // q.enqueue(40);
        // q.printQueue();
        // q.dequeue();
        // q.dequeue();
        // q.dequeue();
        // q.dequeue();
        
        // s.add(10);
        // s.add(02);
        // s.add(30);
        // s.add(40);
        // s.add(50);
        // s.add(10);
        // s.printStack();
        // s.delete();
        // s.delete();
        // s.delete();
        // s.delete();
        // s.delete();
        // s.delete();
        // s.printStack();
        // s.delete();
        // do{
        //     System.out.println("n??");
        //      n = sc.nextInt();
        //      switch (n) {
        //        case 1-> {int i = sc.nextInt();
        //         l.addFirst(i);}
        //        case 2->{int i = sc.nextInt();
        //         l.addLast(i);;}
        //        case 3->{
        //         System.out.println("data? then value?");
        //         int x = sc.nextInt();
        //         int y = sc.nextInt();
        //         l.insertAfter(x,y);
        //        }
        //        case 4->{
        //         System.out.println("data? then value?");
        //         int x = sc.nextInt();
        //         int y = sc.nextInt();
        //         l.insertBefore(x,y);
        //        }
        //        case 5->{
        //         l.deletFirst();
        //        }
        //        case 6->l.deletLast();
        //        case 7->{
        //         System.out.println("value??");
        //         int x = sc.nextInt();
        //         l.delete(x);
        //        }
        //        case 8->l.printList();
        //        default->System.out.println("Nigga");
        //      }
        // }
        // while(n!=10);
        
    }
}
class SingleLinkedList{
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
        Node Head = null;
        void addFirst(int data){
            Node newNode = new Node(data);
            if(Head == null){
                Head = newNode;
            }
            else{
                newNode.next = Head;
                Head = newNode;
            }
            
        }
        void addLast(int data){
            Node newNode = new Node(data);
            if(Head == null){
                Head = newNode;
            }
            else{
                Node temp = Head;
                while(temp.next!=null){
                    temp = temp.next;
                }
                temp.next = newNode;
                
            }
        }
        void deletFirst(){
            if(Head ==null){
                System.out.println("Underflow");
            }
            else{
                Node temp = Head;
                Head = Head.next;
                temp = null;

            }

        }
        void deletLast(){
            if(Head == null){
                System.out.println("Underflow");
            }
            else if( Head.next == null){
                Head = null;
            }
            else{
                Node temp = Head;
                while(temp.next.next!=null){
                    temp = temp.next;
                }
                temp.next = null;
                    
            }
        }  
        
        void endPrint(Node x){
            if(x==null){
                return;
            }
            endPrint(x.next);
            System.out.print("<-"+x.data);
        }
        boolean elementPresent(int value){
            Node temp = Head;
            while (temp!=null) {
                if(temp.data == value){
                    return true;
                }
                temp= temp.next;
            }
            return false;
        }
        void insertBefore(int data,int value) {
            if(elementPresent(value)){
                if(Head.data == value){
                    addFirst(data);
                }
                else {
                    Node temp = Head;
                    while(temp.next.data != value){
                        temp = temp.next;
                        }
                        Node newNode = new Node(data);
                        newNode.next = temp.next;
                        temp.next = newNode;

                }
            }
            else{
                System.out.println("elemt not found");
            }
        }       
        void insertAfter(int data,int value){
            if(elementPresent(value)){
                Node newNode  = new Node(data);
                if(Head.data == value){
                    newNode.next = Head.next;
                    Head.next = newNode;

                }
                else{
                    Node temp = Head;
                    while(temp.data!=value){
                        temp = temp.next;
                    }
                    
                    newNode.next = temp.next;
                    temp.next = newNode;

                        
                }
            }
            else{
                System.out.println("element not found");
            }
            
        }     
        void delete(int value){
            if(elementPresent(value)){
                if(Head.data == value){
                    Head = Head.next;
                }
                else if(Head.next.data == value){
                    Head.next = Head.next.next;
                }
                else{
                    Node temp = Head;
                    while(temp.next.data != value){
                        temp = temp.next;
                    }
                    temp.next = temp.next.next;
                    
                }
            }
            else{
                System.out.println("elemtn not found ");
            }
            
        }
        void printOddList(){
            if(Head==null){
                System.out.println("Empty");
            }
            else{
                Node temp = Head;

                int count = 1;
                while(temp!=null){
                    if(count%2!=0){
                    System.out.print(temp.data+" ->");
                    }
                    count++;
                    temp = temp.next;
                }
                System.out.println("null");
            }
        }
        void printList(){
            if(Head==null){
                System.out.println("Empty");
            }
            else{
                Node temp = Head;
                int count = 0;
                while(temp!=null){
                    count++;
                    System.out.print(temp.data+" ->");
                    temp = temp.next;
                }
                System.out.println("null");
                System.out.println(count+"<< count");
            }
        }
        

    
}
class StackUsingSLL{
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    Node top;
    void add(int data){
        Node newNode = new Node(data);
        if(top == null){
            top = newNode;
        }
        else{
            newNode.next = top;
            top = newNode;
            
        }
    }
    void delete(){
        if(top == null){
            System.out.println("Stack is empty");
        }
        else{
            Node temp = top;
            top = top.next;
            temp = null;
        }
    }
    void printStack(){
        if(top == null){
            System.out.println("Stack is empty");
        }
        else{
            Node temp = top;
            while(temp!=null){
                System.out.print(temp.data+"->");
                temp = temp.next;
            }
            System.out.println("null");
        }
    }
}
class QueueUsingLL{
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    Node front;
    Node rear;
    void enqueue(int data){
        Node newNode = new Node(data);
        if(front == null){
            front = newNode;
            rear = newNode;
        }
        else{
            rear.next = newNode;
            rear = newNode;

        }
    }
    void dequeue(){
        if(front == null){
            System.out.println("undeflwo");
        }
        else{
            Node temp = front;
            front = front.next; 
            temp = null;
        }
    }
    void printQueue(){
        if(front == null){
            System.out.println("Queue is empty");
        }
        else{
            Node temp = front;
            while (temp!=null) {
                System.out.print(temp.data +" -> ");
                temp = temp.next;
            }
            System.out.println("null");
        }
    }
}
