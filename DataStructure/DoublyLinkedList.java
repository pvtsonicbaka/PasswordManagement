import java.util.Scanner;





/**
 * DoublyLinkedList
 * @author  sajjad
 *
 */
public class DoublyLinkedList {
    class Node{
        Node next;
        Node prev;
        int data;
        Node(int data){
            this.data = data;
        }

    }
    Node head=null;
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        Scanner sc = new Scanner(System.in);
        int n=-1;
        do {
            System.out.println("---------------Type--------------------");
            n=sc.nextInt();
            switch (n) {
                    case 1:
                        System.out.println("type number to add");
                        int k = sc.nextInt();
                        list.addFirst(k);
                        break;
                    case 2:
                        System.out.println("type number to add");
                        int k2 = sc.nextInt();
                        list.addLast(k2);
                        break;
                    case 3:
                        list.deleteFirst();
                        break;
                    case 4:
                        list.deleteLast();
                    break;
                    case 5:
                        list.display();
                    
                    break;
                    case 6:
                        System.out.println("enter value to delte");
                        int value = sc.nextInt();
                        list.deleteParticular(value);
                    
                    break;
                    case 7:
                        System.out.println("enter data and Value insert Before");
                        int data = sc.nextInt();
                        System.out.println("value??");
                        int value1 = sc.nextInt();
                        list.inserBeforeValue(data, value1);
                    break;
                    case 8:
                        System.out.println("enter data and Value insert After ");
                        int data1 = sc.nextInt();
                        System.out.println("value??");
                        int value2= sc.nextInt();
                        list.insertAfterValue(data1, value2);
                        
                    
                    break;
                    case 9:
                        System.out.println("enter del Before Element");
                        int delBeforeValueElement = sc.nextInt();
                        list.delBeforeValue(delBeforeValueElement);
                    break;
                    case 10:
                        System.out.println("enter del Before Element");
                        int deleteAfterValue= sc.nextInt();
                        list.deleteAfterValue(deleteAfterValue);
                        break;
                    case 11:
                        System.out.println("del Odd ");
                        list.delOdd();
                        break;
                    case 12:
                        list.midPoint();
                    case 13 :
                        System.out.println("enter data in orderly lined list");
                        int data9 = sc.nextInt();
                        list.addOrderly(data9);
                        break;
                    case 14:
                        list.findMax();

                    case 15:
                        list.reverse(list.head);
                        break;
                    default:

                    break;
            }
            
        } while (n!=99);
    }
    void addFirst(int data){
        Node n = new Node(data);
        if(head==null){
            head=n;

        }
        else {
            n.next=head;
            head.prev =n;
            head=n;
        }
    }
    void addLast(int data){
        Node n = new Node(data);
        if(head==null){
            head=n;

        }
        else{
            Node tNode = head;
            while (tNode.next!=null) {
                tNode=tNode.next;
            }
            tNode.next=n;
            n.prev=tNode;
        }
    }
    
    void display(){
        if(head==null){
            System.out.println("empty  ");
        }
        else{
            Node temp = head;
            Node temp2 = head;

            while (temp!=null) {
                System.out.print(temp.data+"->");
                temp=temp.next;
            }
            System.out.println();
            while (temp2.next!=null) {
                temp2=temp2.next;
            }
            while (temp2!=null) {
                System.out.print("<-"+temp2.data);
                temp2 = temp2.prev;
            }
            System.out.println();
            
        }
    }
    void deleteFirst(){
        if(head==null){
            System.out.println("empty");
        }
        else if(head.next==null){
            
            head =null;
        }
        else{
            Node temp = head;
            head =head.next;
            temp.next=null;
            head.prev=null;
            temp =null;
        }
    }
    void deleteLast(){
        if(head==null){
            System.out.println("empty");
        }
        else if(head.next==null){
            head=null;
        }
        else{
            Node temp = head;
            while (temp.next!=null) {
                temp=temp.next;
            }
            Node LastSecond= temp.prev;
            LastSecond.next=null;
            temp.prev=null;
            temp=null;
        }
    }
    boolean isPresent(int val){
        if(head==null)return false;
        Node tNode = head;
        while (tNode!=null) {
            if(tNode.data==val){
                return true;
            }
            tNode = tNode.next;
        }
        return false;
    }
    void deleteParticular(int val){
        if(isPresent(val)){
            if(head.data==val && head.next!=null){
                Node temp = head;
                head=head.next;
                temp.next=null;
                head.prev=null;
                temp =null;
            }
            else if(head.next ==null){
                head=null;
            }
            else{
                Node tNode = head;
                while (tNode.data!=val) {
                    tNode = tNode.next;
                }
                if(tNode.next==null){
                    Node prevOftemp = tNode.prev;
                    prevOftemp.next=null;
                    tNode.prev =null;
                    tNode=null;
                    return;
                }
                Node previous = tNode.prev;
                Node nextNode = tNode.next;
                previous.next = nextNode;
                nextNode.prev = previous;
                tNode.next=null;
                tNode.prev=null;
                tNode=null;
            }
        }
        else{
            System.out.println("elemtn not found");
        }
    }
    void inserBeforeValue(int data,int val){

        if(isPresent(val)){                  
            if(head.data==val){
                addFirst(data);
                return;
            }     

            Node temp = head;
            while (temp.data!=val) {
                temp=temp.next;
            }
            Node n = new Node(data);
            Node prevNode = temp.prev;
            prevNode.next=n;
            temp.prev=n;
            n.next=temp;
            n.prev=prevNode;

        }
        else{
            System.out.println("balls");
        }
    }
    void insertAfterValue(int data,int val){
        if(isPresent(val)){
            Node n = new Node(data);
            Node temp = head;
            while (temp.data!=val) {
                temp = temp.next;
            }
            if(temp.next==null){
                temp.next = n;
                n.prev = temp;
                return;
            }
            Node nextNode = temp.next;
            nextNode.prev = n;
            temp.next=n;
            n.prev = temp;
            n.next=nextNode;
             
        }
        else{
            System.out.println("not found");
        }
    }
    void delBeforeValue(int val){
        if(isPresent(val)){
            Node temp = head;
            if(head.data==val){
                System.out.println("cant cus first elemtnt ");
                return;
            }
            while (temp.data!=val) {
                temp=temp.next;
            }
            deleteParticular(temp.prev.data);
        }
        else{
            System.out.println("Bommb");
        }
    }
    void deleteAfterValue(int val){
        if(isPresent(val)){
            
                Node temp = head;
                while (temp.data!=val) {
                    temp= temp.next;

                }
                if(temp.next==null){
                    System.out.println("how could i delete if next elemtn is nukk");
                    return;
                }        

                deleteParticular(temp.next.data);
            
        }
        else{
            System.out.println("\u001b[96mlmaoo\u001b[100m");
        }
    }
    void delOdd(){
        if(head==null){
            System.out.println("empty");
            return;
        }  
        Node temp = head;
        int i =0;
        while (temp!=null) {
            Node next = temp.next;
            if(i%2==0){
                System.out.println("jii");
                deleteParticular(temp.data);
            }
            i++;
            temp=next;
        }
          
        
    }
    void midPoint(){
        if(head ==null){
            System.out.println("nig");
            return;
        }
        Node temp1 =head;
        Node temp2 =head;
        while ( temp2.next.next!=null&&temp2.next!=null&&temp2!=null &&temp2.next!=null ) {
            temp1 = temp1.next;
            temp2 = temp2.next.next;
        }
        System.out.println("->>"+temp1.data+"<--");

        
    }
    void addOrderly(int data){
        Node n =new Node(data);
        if(head==null){
            head=n;
            return;

        }
        if(head.data >data){
            addFirst(data);
            return;
        }
        Node temp =head;
        while (temp.next!=null && temp.next.data<data) {
                temp=temp.next;

        }   
        n.next=temp.next;
        if(temp.next!=null){
            temp.next.prev = n ;
        }
        temp.next= n;
        n.prev =temp;
        
    }
    void findMax(){
        if(head ==null){
            System.out.println("snjjsn");return;
        }
        Node temp = head;
        int max = head.data;
        while (temp!=null) {
            if(max< temp.data){
                max= temp.data;
            }
            temp=temp.next;   
        }
        System.out.println("maxxxx "+max);

    }
    void reverse(Node tNode){
        if(tNode==null){
            return;
        }
        reverse(tNode.next);
        System.out.print(tNode.data+" ");

    }
    
}

