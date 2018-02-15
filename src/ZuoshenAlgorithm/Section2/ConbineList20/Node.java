package ZuoshenAlgorithm.Section2.ConbineList20;

public class Node {

    public int value;
    public Node next;

    public Node (int data){
        this.value = data;
    }

    public void relocated(Node head){
        if(head == null || head.next == null){
            return;
        }
        Node mid = head;
        Node right = head.next;
        while(right.next != null && right.next.next != null){
            mid = mid.next;
            right = right.next.next;
        }
        right = mid.next;
        mid.next = null;
        mergeLR(head,right);

    }

    private void mergeLR(Node left, Node right) {
        Node next = null;
        Node tmp = null;
        while(left !=null){
            next = left.next;
            left.next = right;
            tmp = right.next;
            left = tmp;
            right = right.next;
        }
        if(right != null){

        }
    }

}
