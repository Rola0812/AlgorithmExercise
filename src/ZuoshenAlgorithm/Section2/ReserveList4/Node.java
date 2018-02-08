package ZuoshenAlgorithm.Section2.ReserveList4;

public class Node {

    public int value;
    public Node next;
    public Node(int data){
        this.value = data;
    }

    public static Node reserveList(Node head){
        Node pre = null;
        Node next = null;

        while(head !=null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        Node head = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;

        // 打印反转前的链表
        Node h = head;
        while (null != h) {
            System.out.print(h.value + " ");
            h = h.next;
        }
        // 调用反转方法
        // head = reverse1(head);
        head = reserveList(head);

        System.out.println("\n**************************");
        // 打印反转后的结果
        while (null != head) {
            System.out.print(head.value + " ");
            head = head.next;
        }
    }
}
