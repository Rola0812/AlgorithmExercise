package ZuoshenAlgorithm.Section2.AddList10;

import java.util.Stack;

public class Node {

    public int value;
    public Node next;

    public Node(int data){
        this.value = data;
    }

    public static Node addList1(Node head1,Node head2){
        int value1 = listToNum(head1);
        int value2 = listToNum(head2);
        int sum = value1+value2;
        System.out.println("sum==="+sum);
        Stack<Integer> stack  = new Stack<Integer>();
        while(sum>0){
            stack.push(sum%10);
            System.out.println("stack.push="+stack.peek());
            sum = sum/10;
        }
        Node head = new Node(stack.pop());
        Node cur = head;
        while(!stack.isEmpty()){
            System.out.println("----------");
            Node node = new Node(stack.pop());
            cur.next = node;
            cur = cur.next;
        }
        return head;
    }

    public static int listToNum(Node head){
        Node cur = head;
        int sum = 0;

        while(cur != null){
            sum = sum*10+cur.value;
            cur = cur.next;
        }
        System.out.println("sum="+sum);
        return sum;
    }

    public static void main(String[] args) {
        Node head = new Node(9);
        Node node1 = new Node(3);
        Node node2 = new Node(7);

        head.next = node1;
        node1.next = node2;

        Node head21 = new Node(6);
        Node node21 = new Node(3);

        head21.next = node21;

        addList1(head,head21);

        Node h = addList1(head,head21);
        while (null != h) {
            System.out.print(h.value + " ");
            h = h.next;
        }

    }
}
