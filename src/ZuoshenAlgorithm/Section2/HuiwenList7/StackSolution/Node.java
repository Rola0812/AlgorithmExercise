package ZuoshenAlgorithm.Section2.HuiwenList7.StackSolution;

import java.util.Stack;

public class Node {

    public int value;
    public Node next;

    public Node(int data){
        this.value = data;
    }

    public boolean isPalindrome1(Node head){
        Stack<Node> stack  = new Stack<Node>();
        Node cur = head;
        while(cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        while(head != null && stack !=null){
            if(head.value != stack.pop().value){
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public static boolean isPalindrome2(Node head){
        if(head == null || head.next == null){
            return true;
        }
        Node cur = head;
        int length = 0;
        while(cur != null){
            length++;
            cur = cur.next;
        }
        int startPush = (int)Math.ceil(length/2.0);
        System.out.println("startPush="+startPush);
        int index = 0;
        Stack<Node> stack = new Stack<Node>();
        cur = head;
        while(index!=startPush){
            cur = cur.next;
            index++;
        }
        while(cur!=null){
            stack.push(cur);
            cur = cur.next;
        }
        while(!stack.isEmpty()){
            if(head.value != stack.pop().value){
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public static void print(Node head){
        Node cur = head;

        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.print(" \n");
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

        print(head);
        System.out.println(isPalindrome2(head));
    }

}
