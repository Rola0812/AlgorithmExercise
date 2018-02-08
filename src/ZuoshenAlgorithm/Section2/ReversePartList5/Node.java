package ZuoshenAlgorithm.Section2.ReversePartList5;

public class Node {

    public int value;
    public Node next;

    public Node (int data){
        this.value = data;
    }

    public static Node reversePart(Node head,int from,int to){
        if(from > to || from <1){
            return head;
        }
        int start = 0;
        int end = 0;
        Node cur = head;
        while(++start != from-1){
            cur = cur.next;
        }
        Node startNode = cur;
        System.out.println("开始节点的前一个节点的value值为："+startNode.value);
        cur = head;
        while(++end != to+1){
            cur = cur.next;
        }
        Node endNode = cur;
        System.out.println("结束节点的后一个节点的value值为："+endNode.value);

        Node reverseNodeStart = reverseList(startNode.next,to-from+1);
        System.out.println("reverseNodeStart的值为："+reverseNodeStart.value);
        int i = 0;
        cur = reverseNodeStart;
        while(++i<to-from+1){
            cur = cur.next;
        }
        Node reverseNodeEnd = cur;
        System.out.println("reverseNodeEnd的值为："+reverseNodeEnd.value);
        startNode.next = reverseNodeStart;
        reverseNodeEnd.next = endNode;
        return head;

    }

    public static Node reverseList(Node head,int length){
        Node pre = null;
        Node next = null;

        while(head != null && length !=0){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
            length--;
        }
        head = pre;
        System.out.print("反转部分变为: ");
        while (null != head) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        return pre;
    }

    //书上的做法，更简单
    public Node reversePart2(Node head,int from,int to){
        int len = 0;
        Node node1 = head;
        Node fPre = null;//第from-1个节点
        Node tPos = null;//第to+1个节点
        while(node1 != null){
            len++;
            fPre = len == from-1?node1:fPre;
            tPos = len == to+1?node1:tPos;
            node1 = node1.next;
        }

        if(from>to || from<1 || to>len){
            return head;
        }
        //如果fPre是null，说明反转部分包含头结点，则返回新的头结点
        node1 = fPre==null?head:fPre.next;
        Node node2 = node1.next;
        node1.next = tPos;
        Node next = null;
        while(node2 != tPos){
            next = node2.next;
            node2.next = node1;
            node1 = node2;
            node2 = next;
        }

        if(fPre != null){
            fPre.next = node1;
            return head;
        }
        return node1;

    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;

        // 打印反转前的链表
        Node h = head;
        while (null != h) {
            System.out.print(h.value + " ");
            h = h.next;
        }
        // 调用反转方法
        // head = reverse1(head);
        head = reversePart(head,2,3);

        System.out.println("\n**************************");
        // 打印反转后的结果
        while (null != head) {
            System.out.print(head.value + " ");
            head = head.next;
        }
    }
}
