import java.util.Scanner;

import javax.naming.spi.NamingManager;

/**
 * CircularLL
 */
public class CircularLL {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = -1;
        CircularLL cl = new CircularLL();
        while (n != 99) {
            System.out.println("\u001b[96m---------type-------------\u001b[00m");
            n = sc.nextInt();
            switch (n) {
                case 1:
                    System.out.println("Enter data for First");
                    int data = sc.nextInt();
                    cl.addFirst(data);
                    ;
                    break;
                case 2:
                    System.out.println("Enter data for Last");
                    int data1 = sc.nextInt();
                    cl.addLast(data1);
                    ;

                    break;
                case 3:
                    cl.delFirst();
                    break;
                case 4:
                    cl.delLast();
                    break;
                case 5:
                    cl.display();
                    break;
                case 6:
                    System.out.println("Enter value to del");
                    int value = sc.nextInt();
                    cl.deleteParticular(value);
                    break;
                case 7:
                    System.out.println("Enter value to befor and data");
                    int value2 = sc.nextInt();
                    int data2 = sc.nextInt();
                    cl.inserBeforeValue(data2, value2);
                    break;
                case 8:
                    System.out.println("Enter value to After and data");
                    int value3 = sc.nextInt();
                    int data4 = sc.nextInt();
                    cl.insertAfterValue(data4, value3);
                    break;

                case 9:
                    System.out.println("Insert Orderly thing");
                    int order =sc.nextInt();
                    cl.insertInOrder(order);;
                    break;
                case 10:
                    cl.reverseWithoutRecursion();
                    break
                    ;
                case 11:
                    cl.delOdd();
                default:
                    break;
            }
        }
    }

    Node head;

    void addFirst(int data) {
        Node n = new Node(data);
        if (head == null) {
            head = n;
            n.next = n;
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = n;  
            n.next = head;
            head = n;
        }

    }

    void addLast(int data) {
        Node n = new Node(data);
        if (head == null) {
            head = n;
            n.next = head;
        } else {
            Node temp = getLastNode();
            temp.next = n;
            n.next = head;
        }

    }

    void delFirst() {
        if (head == null) {
            System.out.println("nigga");
            return;
        }
        if (head.next == head) {
            head = null;
            System.out.println("List is Now Empty");
        } else {
            Node temp = getLastNode();
            Node del = head;
            head = head.next;
            temp.next = head;
            del.next = null;
        }
    }

    void delLast() {
        if (head == null) {
            System.out.println("nigga");
            return;
        }
        if (head.next == head) {
            head = null;
            System.out.println("List is Now Empty");
        } else {
            Node temp = head;
            while (temp.next.next != head) {
                temp = temp.next;
            }
            Node del = temp.next;
            temp.next = head;
            del.next = null;

        }
    }

    Node getLastNode() {
        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        return temp;
    }

    boolean isPresent(int val) {
        if (head == null) {
            return false;
        }
        Node temp = head;
        do {
            if (temp.data == val) {
                return true;
            }
            temp = temp.next;
        } while (temp != head);
        return false;

    }

    void deleteParticular(int val) {
        if (isPresent(val)) {
            if (head.next == head) {
                head = null;
                System.out.println("List is now empty ");
            } else if (head.data == val) {
                Node temp = getLastNode();
                head = head.next;
                temp.next = head;

            } else {
                Node temp = head;
                while (temp.next.data != val) {
                    temp = temp.next;
                }
                Node del = temp.next;
                temp.next = del.next;
                del.next = null;

            }
        } else {
            System.out.println("NIgga");
        }
        
    }

    void inserBeforeValue(int data, int val) {
        if (isPresent(val)) {
            Node n = new Node(data);
            if (head.data == val) {
                Node temp = getLastNode();
                n.next = head;
                head = n;
                temp.next = head;
            } else {
                Node temp = head;
                while (temp.next.data != val) {
                    temp = temp.next;

                }
                n.next = temp.next;
                temp.next = n;
            }
        } else {
            System.out.println("niga");
        }
    }

    void insertAfterValue(int data, int val) {
        if (isPresent(val)) {
            Node n = new Node(data);
            Node temp = head;
            while (temp.data != val) {
                temp = temp.next;
            }
            n.next = temp.next;
            temp.next = n;
        } else {
            System.out.println("nis");
        }
    }
    void insertInOrder(int data){
        Node n = new Node(data);
        if(head ==null){
            head=n;
            n.next=n;
        }
        else if(head.data > data){
            addFirst(data);
        }
        else{
            Node temp = head;
            while (temp.next!=head && temp.next.data < data) {
                temp= temp.next;
            }
            n.next=temp.next;
            temp.next=n;

        }
    }
    void reverseWithoutRecursion(){
        if(head ==null && head.next==head){
            return;
        }
        Node prevNode = head;
        while (prevNode.next!=head) {
            prevNode=prevNode.next;
        }
        Node nextNode = head.next;
        Node curr =head;

        do {
            curr.next= prevNode;
            prevNode=curr;
            curr = nextNode;
            nextNode=nextNode.next;

            
        } while (curr!=head);
        head=prevNode;
    }
    void findMidpoint(){
        if(head.next==head){
            System.out.println(head.data+"is mdeian");
        }
        else{
            Node slow = head;
            Node fast = head;
            while (fast.next!=head && fast.next.next!=head) {
                slow=slow.next;
                fast=fast.next.next;
                }
                System.out.println(slow.data+"is median");
        }
    }
    void delOdd(){
        Node temp = head;
        head= head.next;

        Node temp2 =head;
        while (temp2.next!=temp && temp2.next.next!=temp) {
            temp2.next =temp2.next.next;
            temp2=temp2.next;
            System.out.println("ks");
        }
        temp2.next =head;

    }
    void display() {
        if (head == null) {
            System.out.println("nigga");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;

        } while (temp != head);
        System.out.println();

    }
    void reverseWithRecursion(Node current  ,Node start ){
        
        if (current.next == start) {
            start.next = current;
            return;
        }
        reverseWithRecursion(current.next, start);
        current.next.next = current;
        current.next = start;
    }
}