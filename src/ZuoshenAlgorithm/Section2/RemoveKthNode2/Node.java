package ZuoshenAlgorithm.Section2.RemoveKthNode2;

public class Node {

    public int value;
    public Node next;

    public Node(int data){
        this.value = data;
    }

    public Node removeLastKthNode(Node head,int lastKth){
        if(head == null || lastKth <1){
            return null;
        }
        Node cur = head;
        while(cur !=null){
            cur = cur.next;
            lastKth--;
        }
        if(lastKth==0){
            head = head.next;
        }else if(lastKth<0){
            cur = head;
            while(++lastKth !=0){
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }

}
