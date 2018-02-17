package ZuoshenAlgorithm.Section3.Print9;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Node {

    public int value;
    public Node left;
    public Node right;

    public Node(int data){
        this.value = data;
    }

    public static void levelPrint(Node head){
        if(head == null){
            return;
        }
        Queue<Node> queue = new LinkedList<Node>();
        //last表示正在打印的当前行的最右节点
        //nlast表示下一行的最右节点
        //如果发现遍历到的节点等于last,说明该换行了，换行之后只要另last=nlast，就可以继续下一行的打印过程
        Node last = head;
        Node nlast = null;
        int level = 0;
        queue.offer(head);
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            System.out.print(cur.value+" ");
            if(cur.left != null){
                queue.offer(cur.left);
                nlast = cur.left;
            }
            if(cur.right != null){
                queue.offer(cur.right);
                nlast = cur.right;
            }
            if(cur == last){
                level++;
                last = nlast;
                System.out.println();
            }
        }
    }

    public static void ZigZagPrint(){

    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        Node node10 = new Node(10);
        Node node11 = new Node(11);
        Node node12 = new Node(12);
        Node node13 = new Node(13);
        Node node14 = new Node(14);
        Node node15 = new Node(15);
        Node node16 = new Node(16);
        node1.left = node2;
        node1.right = node3;
        node2.right = node4;
        node3.left = node5;
        node3.right = node6;
        node4.left = node7;
        node4.right = node8;
        node5.left = node9;
        node5.right = node10;
        node8.right = node11;
        node9.left = node12;
        node11.left = node13;
        node11.right = node14;
        node12.left = node15;
        node12.right = node16;
        levelPrint(node1);
    }

}
