package ZuoshenAlgorithm.Section2.InsertNode18;

public class Node {

    public int value;
    public Node next;

    public Node(int data)
    {
        this.value = data;
    }

    public Node insertNum(Node head, int num){
        Node node = new Node(num);
        boolean inserted = false;
        if(head == null){
            head = node;
            head.next = node;
            inserted = true;
        }
        Node pre = head;
        Node cur = head.next;
        if(num<pre.value){
            System.out.println("插入最小值");
            pre.next = node;
            node.next = cur;
            node.value = pre.value;
            pre.value = num;
            return head;
        }
        while(cur != head){
            if(cur.value>num && pre.value<num){
                pre.next = node;
                node.next = cur;
                inserted = true;
            }
            pre = pre.next;
            cur = cur.next;
        }
        if(inserted == false){
            pre.next = node;
            node.next = cur;
            inserted = true;
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(4);
        Node node3 = new Node(5);
        Node node4 = new Node(6);
        Node node5 = new Node(7);
        Node node6 = new Node(8);
        Node node7 = new Node(9);
        Node node8 = new Node(10);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = head;

        head = head.insertNum(head,0);
        Node cur = head;
        while (true) {
            System.out.print(cur.value + " ");
            cur = cur.next;
            if(cur == head){
                break;
            }
        }
    }

}
