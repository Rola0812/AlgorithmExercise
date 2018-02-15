package ZuoshenAlgorithm.Section2.MergeList19;

public class Node {

    public int data;
    public Node next;

    public Node (int data){
        this.data = data;
    }

    public static Node merge(Node head1,Node head2){
        if(head1 == null || head2 == null){
            return head1==null?head2:head1;
        }
        Node head = head1.data<head2.data?head1:head2;
        Node cur = head;
        Node pre = head;
        Node cur1 = head == head1?head1.next:head1;
        System.out.println("cur1="+cur1.data);
        Node cur2 = head == head2?head2.next:head2;
        System.out.println("cur2="+cur2.data);
        while(cur1 != null && cur2 != null){
            cur = cur.next;
            cur = cur1.data<cur2.data?cur1:cur2;
            if(cur == cur1){
                cur1 = cur1.next;
            }else {
                cur2 = cur2.next;
            }
            pre.next = cur;
            pre = pre.next;
            System.out.println(cur.data);
        }
        System.out.println(cur);

        cur.next = (cur1 == null)?cur2:cur1;
        return head;
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        Node node11 = new Node(2);
        Node node12 = new Node(4);
        Node node13 = new Node(5);


        Node head2= new Node(0);
        Node node21 = new Node(5);
        Node node22 = new Node(8);
        Node node23 = new Node(9);
        Node node24 = new Node(10);

        head1.next = node11;
        node11.next = node12;
        node12.next = node13;


        head2.next = node21;
        node21.next = node22;
        node22.next = node23;
        node23.next = node24;

        Node head = merge(head1, head2);
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
    }

}
