package ZuoshenAlgorithm.Section2.DeleteNode3.DeleteRatioNode;

public class Node {

    public int value;
    public Node next;

    public Node(int data){
        this.value = data;
    }

    public static Node removeByRatio(Node head,int a,int b){
        if(a<1 || a>b){
            return null;
        }
        int n = 1;
        Node cur = head;
        while(cur.next!=null){
            n++;
            cur = cur.next;
        }
        n = (int)Math.ceil((double)(a*n)/(double) b);
        if(n == 1){
            head = head.next;
        }
        if(n>1){
            cur = head;
            while(--n !=1){
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }
    public static Node init(Node head){
        for (int i = 2; i < 20; i++){
            head.next = new Node(i);
            head = head.next;
        }
        return head;
    }
    public static void print(Node head){
        Node cur = head;

        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.print(" \n");
    }
    public static void main(String[] args){
        Node test = new Node(1);
        init(test);
        System.out.println("Before removeing:");
        print(test);
        removeByRatio(test, 3, 7);
        System.out.println("After removeing:");
        print(test);

    }
}
