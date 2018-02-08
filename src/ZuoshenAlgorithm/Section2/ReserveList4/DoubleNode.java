package ZuoshenAlgorithm.Section2.ReserveList4;

public class DoubleNode {

    public int value;
    public DoubleNode next;
    public DoubleNode pre;

    public DoubleNode(int value){
        this.value = value;
    }

    public static DoubleNode reserveList(DoubleNode head){
        DoubleNode pre = null;
        DoubleNode next = null;

        while(head != null){
            next = head.next;
            head.pre = next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        DoubleNode head = new DoubleNode(0);
        DoubleNode node1 = new DoubleNode(1);
        DoubleNode node2 = new DoubleNode(2);
        DoubleNode node3 = new DoubleNode(3);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;

        node1.pre = head;
        node2.pre = node1;
        node3.pre = node2;

        // 打印反转前的链表
        DoubleNode h = head;
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
