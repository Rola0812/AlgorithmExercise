package ZuoshenAlgorithm.Section2.ReverseKList12;

import java.util.Stack;

public class Node {

    public int value;
    public Node next;

    public Node(int data){
        this.value = data;
    }

    public static Node reverseKNodes1(Node head,int k){
        if(head == null || k<2){
            return head;
        }
        Node cur = head;
        int i = 0;
        Node lastTail  = null;
        Stack<Integer> stack = new Stack<Integer>();
        Node headReturn = null;
        Node tmp = null;
        while(cur != null){
           if(i == k+1){
               System.out.println("i="+i);
               while(--i>0) {
                   System.out.print("此次翻转的节点为："+stack.peek()+" ");
                   Node node = new Node(stack.pop());
                   if (headReturn == null) {
                       headReturn = node;
                       tmp = headReturn;
                   } else {
                       tmp.next = node;
                   }
               }
               i = 0;
           }
           stack.push(cur.value);
           cur = cur.next;
           i++;
        }

        return headReturn;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node node1 = new Node(6);
        Node node2 = new Node(5);
        Node node3 = new Node(2);
        Node node4 = new Node(1);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        Node h = reverseKNodes1(head,2);
        while (null != h) {
            System.out.print(h.value + " ");
            h = h.next;
        }
    }
}
