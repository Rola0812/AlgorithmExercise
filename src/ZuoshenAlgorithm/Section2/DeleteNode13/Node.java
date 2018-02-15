package ZuoshenAlgorithm.Section2.DeleteNode13;

import java.util.HashSet;

public class Node {

    public int value;

    public Node next;

    public Node (int data){
        this.value = data;
    }

    public void removeRep1(Node head){
        if(head == null){
            return;
        }
        HashSet<Integer> set = new HashSet<Integer>();
        Node pre = head;
        Node cur = pre.next;
        set.add(head.value);
        while(cur != null){
            if(!set.add(cur.value)){
                pre.next = cur.next;
            }else{
                set.add(cur.value);
                pre = cur;
            }
            cur = cur.next;
        }
    }

    public static void removeRep2(Node head){
        Node cur = head;
        Node pre = cur;
        while(cur != null){
            int value = cur.value;
            Node tmp = cur.next;
            while(tmp != null){
                if(tmp.value == cur.value){
                    pre.next = tmp.next;
                    tmp = tmp.next;
                }else {
                    pre = pre.next;
                    tmp = tmp.next;
                }
                System.out.println("------");
            }
            cur = cur.next;
            pre = cur;
            System.out.println("---------------");
        }
        while (null != head) {
            System.out.print(head.value + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(4);
        Node node6 = new Node(2);
        Node node7 = new Node(1);
        Node node8 = new Node(1);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;

        removeRep2(head);


    }
}
