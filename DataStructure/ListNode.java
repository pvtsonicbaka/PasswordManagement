
//  Definition for singly-linked list.

import java.io.PrintStream;
public class ListNode {
      int val;
      public static PrintStream out = new  PrintStream(System.out);
      public static void main(String[] args) {
        // System.out.println("\u001b[31mhi");
        String s="sqq";
        // out.println("\u001b[H"+"NewWord\n");
        System.out.print("\u0013\n");

        System.out.println(""+"sjikjqkj");
      }
    //    Color s = 
      ListNode next;
      ListNode(int x) { val = x; }
  }
 

class Solution {
    ListNode head;
    public void deleteNode(ListNode node) {
        if(head.val == node.val  && head.next == null){
            head = null;
        }
        else if(head.val == node.val){
            head = head.next;
        }
        else{
            ListNode temp = head;
            while (temp.next.val != node.val ) {
                temp = temp.next;
            }
            temp.next =temp.next.next;
        }
    }
}