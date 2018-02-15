package ZuoshenAlgorithm.Section2.SortList16;

public class Node {

    public int value;
    public Node next;

    public Node(int data){
        this.value = data;
    }

    public static Node selectionSort(Node head){
        Node startNode = head;
        Node small = head;
        Node cur = head;
        while(cur != null){
            System.out.println(cur.value);
            small = cur;
            while(cur != null){
                if(cur.value < small.value){
                    small = cur;
                }
                cur = cur.next;
            }
            int temp = small.value;
            small.value = startNode.value;
            startNode.value = temp;
            startNode = startNode.next;
            cur = startNode;
            Node h = head;
            while (null != h) {
                System.out.print(h.value + " ");
                h = h.next;
            }
            System.out.println("-------------");
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node node1 = new Node(7);
        Node node2 = new Node(8);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        Node node5 = new Node(0);
        Node node6 = new Node(6);
        Node node7 = new Node(2);
        Node node8 = new Node(9);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;

        head = selectionSort(head);

        while (null != head) {
            System.out.print(head.value + " ");
            head = head.next;
        }
    }
}
