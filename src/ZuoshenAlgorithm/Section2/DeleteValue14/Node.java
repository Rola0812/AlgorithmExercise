package ZuoshenAlgorithm.Section2.DeleteValue14;

public class Node {

    public int value;
    public Node next;

    public Node(int data){
        this.value = data;
    }

    public static Node removeValue1(Node head,int num){
        while(head != null){
            if(head.value != num){
                break;
            }
            head = head.next;
        }
        Node pre = head;

        Node cur = head.next;

        while(cur != null){
            if(cur.value == num){
                pre.next = cur.next;
                cur = cur.next;
            }else{
                pre = pre.next;
                cur = cur.next;
            }
        }
        return head;
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

        head = removeValue1(head,1);

        while (null != head) {
            System.out.print(head.value + " ");
            head = head.next;
        }
    }

}
