package ZuoshenAlgorithm.Section2.Yuesefu6;

public class Node {

    public int value;
    public Node next;

    public Node(int data){
        this.value = data;
    }

    public static Node josephusKill1(Node head,int m){
        if(head ==null || head.next == head || m<1){
            return head;
        }
        int n = 1;
        Node pre = null;
        while(head.next != head){
                if(n == m-1){
                    pre = head;
                    head = head.next;
                    n++;
                }else if(n == m){
                    pre.next = head.next;
                    System.out.println("此次自杀的人为："+head.value);
                    head = head.next;
                    n = 1;
                }else {
                    head = head.next;
                    n++;
                }
        }
        System.out.println("存活的人为："+head.value);
        return head;
    }

    public static Node init(Node head){
        for (int i = 2; i < 20; i++){
            head.next = new Node(i);
            head = head.next;
        }
        return head;
    }
    public static void print(Node head){
        Node cur = head;

        while (cur != null || cur.next != cur) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.print(" \n");
    }

    public static void main(String[] args) {
        Node test = new Node(1);
        init(test).next = test;
        System.out.println("Before testing");
        josephusKill1(test, 3);
        System.out.println("After testing");
    }
}
