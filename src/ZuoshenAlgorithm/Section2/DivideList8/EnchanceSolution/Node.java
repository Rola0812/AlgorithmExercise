package ZuoshenAlgorithm.Section2.DivideList8.EnchanceSolution;

public class Node {
    public int value;
    public Node next;

    public Node(int data){
        this.value = data;
    }

    public static Node listPartition(Node head,int pivot){
        Node sH = null;
        Node sT = null;
        Node eH = null;
        Node eT = null;
        Node bH = null;
        Node bT = null;

        Node next = null;//保存下一个节点

        while(head != null){
            next = head.next;
            head.next = null;
            if(head.value <pivot){
                if(sH == null){
                    sH = head;
                    sT = head;
                }else {
                    sT.next = head;
                    sT = head;
                }
            }else if(head.value == pivot){
                if(eH == null){
                    eH = head;
                    eT = head;
                }else {
                    eT.next = head;
                    eT = head;
                }
            }else {
                if(bH == null){
                    bH = head;
                    bT = head;
                }else {
                    bT.next = head;
                    bT = head;
                }
            }
            head = next;
        }
        if(sT!=null){
            sT.next = eH;
            eT = eT == null?sT:eT;
        }
        if(eT != null){
            eT.next = bH;
        }
        return sH != null ? sH:eH!=null?eH:bH;
    }
}
