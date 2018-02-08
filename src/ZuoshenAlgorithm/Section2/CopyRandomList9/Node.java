package ZuoshenAlgorithm.Section2.CopyRandomList9;

import java.util.HashMap;

public class Node {

    public int value;
    public Node next;
    public Node rand;

    public Node(int data){
        this.value = data;
    }

    public Node copyListWithRand1(Node head){
        HashMap<Node,Node> map = new HashMap<Node,Node>();
        Node cur = head;
        while(cur != null){
            map.put(cur,new Node(cur.value));
            cur = cur.next;
        }
        cur = head;
        while(cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).rand = map.get(cur.rand);
            cur = cur.next;
        }
        return map.get(head);
    }

    public Node copyListWithRand2(Node head){
        if(head == null){
            return null;
        }
        Node cur = head;
        Node next = null;
        //复制并链接每一个节点
        while(cur != null){
            next = cur.next;
            cur.next = new Node(cur.value);
            cur.next.next = next;
            cur = next;
        }
        cur = head;
        Node curCopy = null;
        //设置复制节点的rand指针
        while (cur != null){
            next = cur.next.next;
            curCopy = cur.next;
            curCopy.rand = cur.rand != null ? cur.rand.next:null;
            cur = next;
        }
        Node res = head.next;
        cur = head;
        while (cur != null){
            next = cur.next.next;
            curCopy = cur.next;
            cur.next = next;
            curCopy.next = next != null ? next.next:null;
            cur = next;
        }
        return res;
    }


}
