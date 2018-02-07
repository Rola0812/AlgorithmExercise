package ZuoshenAlgorithm.Section2.RemoveKthNode2;

public class DoubleNode {

    public int value;
    public DoubleNode last;
    public DoubleNode next;

    public DoubleNode(int data){
        this.value = data;
    }

    public DoubleNode removeLastKthNode(DoubleNode head,int lastKth){
        if(lastKth < 1 && head == null){
            return null;
        }
        DoubleNode cur = head;
        while(cur!=null){
            cur = cur.next;
            lastKth--;
        }
        if(lastKth == 0){
            head = head.next;
            head.last = null;
        }else if(lastKth < 0){
            while(++lastKth < 0){
                cur = cur.next;
            }
            DoubleNode newNext = cur.next.next;
            cur.next = newNext;
            if(newNext != null){
                newNext.last = cur;
            }
        }
        return head;
    }
}
