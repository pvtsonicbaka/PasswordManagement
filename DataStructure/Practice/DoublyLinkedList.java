import java.util.Scanner;

public class DoublyLinkedList {
    Node head;

    class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = -1;
        DoublyLinkedList dll = new DoublyLinkedList();
        
        while (n != 99) {
            System.out.println("\u001b[96m---------type-------------\u001b[00m");
            n = sc.nextInt();
            switch (n) {
                case 1:
                    System.out.println("Enter data  ");
                    int data=sc.nextInt();
                    dll.addFirst(data);
                    break;
                    case 2:
                    System.out.println("Enter data  ");
                    int data1=sc.nextInt();
                    dll.addLast(data1);
                    
                    break;
                    case 3:
                    dll.delFirst();
                    
                    break;
                    case 4:
                    dll.delLast();
                    break;
                    case 5:
                    dll.display();
                    
                    break;
                    case 6:
                    System.out.println("Enter value to Delete");
                    int val = sc.nextInt();
                    dll.delValue(val);
                    break;
                    case 7:
                    System.out.println("Enter value to Delete and befor data");
                    int data0 = sc.nextInt();
                    int val0= sc.nextInt();
                    dll.addBeforeValue(data0,val0);
                    break;
                    case 8:
                    System.out.println("Enter value to Delete and befor data");
                    int datax = sc.nextInt();
                    int valx= sc.nextInt();
                    dll.addAfter(datax, valx);
                    break;
                    case 9:
                    System.out.println("Enter data in order");
                    int sex = sc.nextInt();
                    dll.insertInOrder(sex);
                    break;
                    case 10:
                    dll.delDuplicates();
                    break;
                    case 11:
                    dll.reverseWithourRecursion();
                    break;
                    case 12:
                    dll.delEven();
                    break;
                    case 13:
                    dll.delOdd();
                default:
                    break;
            }
        }
    }

    void addFirst(int data) {
        Node n = new Node(data);
        if (head == null) {
            head = n;
        } else {
            n.next = head;
            head.prev = n;
            head = n;
        }

    }
    void addLast(int data){
        Node n  = new Node(data);
        if(head == null){
            head = n ;
            return;
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = n;
        n.prev = temp;

    }
    void delFirst(){
        if (head==null) {
            System.out.println("nukk");
            return;
        }
        else if(head.next==null){
            head =null;
            return;
        }
        head = head.next;
        head.prev=null;

    }
    void delLast(){
        if (head==null) {
            System.out.println("nukk");
            return;
        }
        else if(head.next ==null){
            head =null;
            return;
        }
        Node temp = head;
        while (temp.next.next!=null) {
            temp=temp.next;
        }
        temp.next=null;

    }
    boolean isPresent(int val){
        if(head==null){
            return false;
        }
        Node temp = head;

        while (temp!=null) {
            if(temp.data==val){
                return true;
            }
            temp=temp.next;

        }
        return false;
    }
    void delDuplicates(){
        if(head ==null){
            System.out.println("nul");
        }
        else if(head.next==null){
            return;
        }
        else{
            Node temp1 = head;
            while (temp1!=null) {
                Node temp2= temp1.next;
                while (temp2!=null) {
                    if(temp2.data == temp1.data){
                        temp2.prev.next=temp2.next;
                        if(temp2.next==null){
                            temp2.prev=null;
                        }
                        else{
                            temp2.next.prev=temp2.prev;
                        }
                        
                    }
                    temp2 = temp2.next;
                }
                temp1 = temp1.next;
                
            }
        }
    }
    void delValue(int val){
        if(isPresent(val)){
            if(head.next==null){
                head=null;
            }
            else{
                Node temp = head;
                while (temp.data!=val) {
                    temp=temp.next;
                }
                if(temp ==head){
                    head=head.next;
                    head.prev=null;
                    temp.next=null;
                }
                else if(temp.next==null){
                    temp.prev.next=null;
                    temp.prev=null;
                }
                else{
                    Node prev = temp.prev;
                    Node nxt = temp.next;
                    prev.next= nxt;
                    nxt.prev=prev;
                    temp.prev=null;
                    temp.next=null;

                }
                
            }
        }
        else{
            System.out.println("niga");
        }
    }
    void insertInOrder(int data){
        Node n = new Node(data);
        if(head==null){
            head = n;
        }
        else if (head.data > data){
            n.next=head;
            head.prev = n;
            head=n;
        }
        else{
            Node temp = head;
            while (temp.next!=null && temp.next.data<data) {
                temp=temp.next;
            }
            n.next=temp.next;
            if (temp.next!=null) {
                temp.next.prev=n;
            }   
            temp.next=n;
            n.prev =temp;


        }
    }
    void addBeforeValue(int data,int val){
        Node n = new Node(data);
        if(isPresent(val)){
            if(head.data==val ){
                addFirst(data);
                return;
            }   
            else {
                Node temp = head;
                while (temp.data !=val) {
                    temp=temp.next;
                }
                Node prev = temp.prev;
                prev.next  = n ;
                n.prev = prev;
                n.next=temp;
                temp.prev = n;
            }
        }
        else{
            System.out.println("niger");
        }
    }
    void addAfter(int data,int value){
        if (isPresent(value)) {
            Node n = new Node(data);
            Node temp =  head;
            while (temp.data!=value) {
                temp=temp.next;     
            }
            if(temp.next==null){
                temp.next=n;
                n.prev = temp;
                return;
            }
            Node nxt=temp.next;
            nxt.prev=n;
            n.next=nxt;
            temp.next=n;
            n.prev=temp;
        }
        else{
            System.out.println("niqghgq");
        }
    }
    void reverseWithourRecursion(){
        if(head ==null || head.next ==null){
            System.out.println("NULL");
            return;
        }
        Node nextNode = head.next;
        Node prev = null;
        Node curr = head;
        while (curr!=null) {
            curr.next=prev;
            curr.prev=nextNode;
            prev=curr;
            curr=nextNode;
            if(nextNode!=null){
                nextNode = nextNode.next;
            }
            if(true){
                System.out.println("jhshs"); 
            }
        }
        head=prev;
        

    }
    void delEven(){
        int i = 1;
        if(head==null){
            return;
        }
        Node temp = head;

        while (temp!=null) {
           
        }
    }
    void delOdd(){
        int i = 1;
        if(head==null){
            return;
        }
        if(head.next==null){
            head=null;
            return ;
        }
        Node temp = head;
        Node prev = null;
        while (temp!=null) {

            if( i%2!=0){
                if(prev!=null){
                    prev.next=temp.next;
                    
                }
                else{
                    head=temp.next;
                }
                if(temp.next != null){
                    temp.next.prev=prev;
                }
            }
            else{
                prev = temp;
            }
            temp=temp.next;i++;
        }
    }
    void display() {

        if (head == null) {
            System.out.println("NUll");
        
            return;
        }
        System.out.println("using next Pointer");
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println();
                System.out.println("using prev Pointer");
        temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        while (temp != null) {
            System.out.print(temp.data + " <- ");
            temp = temp.prev;
        }
        System.out.println();

    }

}
