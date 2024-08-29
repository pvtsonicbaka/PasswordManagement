/**
 * LinkedLists
 */
public class LinkedLists {

    public static void main(String[] args) {
        List l = new List();
        l.addFirst(100);
        l.deleteVAlue(100);
        l.display();

    }
}
class List{
  Node  head = null;
    class  Node {
        Node    next;
        int data;
        Node(int data){
            next = null;
            this.data = data;
        } 
   }
   void addFirst(int data){
    Node n = new Node(data);
    if(head == null){
        head = n;
    }else{
        n.next= head;
        head = n;

    }
   }

   void addLast(int data){
    Node n = new Node(data);
        if(head == null){
        head = n;

        }
        else{
            Node temp = head;
            while (temp.next!=null) {
                temp=temp.next;
            }
            temp.next = n;
        }
   }
   void display(){
    if(head == null){
        System.out.println("emty list");
    }
    else{
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data+"-->");
            temp=temp.next;
        }
        System.out.println("null");
    }
   }
   void deleteFirst(){
    if(head == null){
        System.out.println("list empty");
    }
    else{
        System.out.println(head.data+"-is removed");
        head = head.next;
        
    }
   }
   void deleteLast(){
    if(head == null){
        System.out.println("list empty");
    }
    else{
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        System.out.println(temp.next.data+"is removed");
        temp.next = null;
    }
   }
   void insertBeforeValue(int data,int value){
     boolean flag =false;
     Node temp = head;
        while (temp !=null) {
            if(temp.data == value){
                flag = true;
                break;  
            }
            temp = temp.next;
        }
        if(flag){
            Node n = new Node(data);
            if(head.data == value || head.next==null){
                addFirst(data);
            }
            else  {
                Node temp1 = head;
                while (temp1.next.data != value) {
                    temp1 = temp1.next;
                }
                n.next= temp1.next;
                temp1.next = n;
            }

        }
        else{
            System.out.println("elemtn not exist");
        }
   }
   void insertAfterValue(int data,int value){
        boolean b = false;
        Node tNode = head;
        while (tNode!= null) {
            if(tNode.data == value){
                b= true;
            }
            tNode = tNode.next;
            
        }
        if(b)   {
            Node  n = new Node(data);
            if(head.data == value && head.next == null){
                head.next = n;
            }
            else if(head.data == value){
                n.next = head.next;
                head.next = n;

            }
            else{
                Node temp = head;
                while (temp.data != value) {
                    temp=temp.next;
                }   
                n.next = temp.next;
                temp.next = n;
            }
        }
        else{
            System.out.println("elemt not found ");
        }
   }  
   void deleteVAlue( int value){
        if(head == null){
            System.out.println("empty");
        }
        else{
            boolean b = false;
        Node tNode = head;
        while (tNode!= null) {
            if(tNode.data == value){
                b= true;
            }
            tNode = tNode.next;
            
        }
        if(b){
            if( head.next == null&& head.data == value){
                head =null;
            }
            else if(head.data == value){
                head = head.next;
            }
            else{   
                Node temp  = head;
                while (temp.next.data != value) {
                    temp= temp.next;
                }   
                System.out.println(temp.next.data+"is rmoved");
                temp.next=temp.next.next; 
            }   
        }
        else{
            System.out.println("elemt not found");
        }

        }
   }  

}