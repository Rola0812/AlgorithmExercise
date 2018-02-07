package ZuoshenAlgorithm.Section2.DeleteNode3.DeleteMiddleNode;

public class Node {
    public int value;
    public Node next;

    public Node(int data){
        this.value = data;
    }
    /*
    * 链表长度每增加2，要删除的节点就后移一个节点
    * */
    public Node removeMiddleNode(Node head){
        if(head == null || head.next == null){
            return head;
        }
        if(head.next.next == null){
            return head.next;
        }
        Node pre = head;
        Node cur = head.next.next;
        while(cur.next!=null && cur.next.next!=null){
            pre = pre.next;
            cur = cur.next.next;
        }
        pre.next = pre.next.next;
        return head;
    }
}
