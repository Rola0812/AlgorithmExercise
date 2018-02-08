package ZuoshenAlgorithm.Section2.HuiwenList7.O1Solution;

public class Node {

    public int value;
    public Node next;

    public Node(int data){
        this.value = data;
    }

    public boolean isPalindrome(Node head){
        if(head == null || head.next == null){
            return true;
        }
        Node n1 = head;
        Node n2 = head;
        while(n2.next != null && n2.next.next != null){//查找中间节点
            n1 = n1.next;//n1:中部
            n2 = n2.next.next;//n2:结尾
        }
        n2 = n1.next;
        n1.next = null;
        Node n3 = null;
        while(n2 != null){//右半区反转
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }
        n3 = n1; //n3:保存最后一个节点
        n2 = head; //n2:左边第一个节点

        boolean res = true;
        while(n1 != null && n2 != null){
            if(n1.value != n2.value){
                res = false;
                break;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        n1 = n3.next;
        n3.next = null;
        while(n1 !=null){
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return res;
    }

    public Node reserve(Node head){

        Node pre = null;
        Node next = null;

        while(head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
