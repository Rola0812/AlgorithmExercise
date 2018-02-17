package ZuoshenAlgorithm.Section3.PrintBinaryTree;

import java.util.Stack;

public class Node {

    public int value;
    public Node left;
    public Node right;

    public Node(int data){
        this.value = data;
    }

    //以下方法是递归方法
    public void preOrderRecur(Node head){
        if(head == null){
            return;
        }
        System.out.print(head.value+" ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    public void inOrderRecur(Node head){
        if(head == null){
            return;
        }
        inOrderRecur(head.left);
        System.out.print(head.value+" ");
        inOrderRecur(head.right);
    }

    public void posOrderRecur(Node head){
        if(head == null){
            return;
        }
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.print(head.value);
    }

    //以下方法是非递归方法
    public void preOrderUnRecur(Node head){
        System.out.println("pre-order:");
        if(head != null){
            Stack<Node> stack = new Stack<Node>();
            stack.add(head);
            while(!stack.isEmpty()){
                head = stack.pop();
                System.out.print(head.value);
                if(head.right != null){
                    stack.push(head.right);
                }
                if(head.left != null){
                    stack.push(head.left);
                }
            }
        }
        System.out.println();
    }

    public void inOrderUnRecur(Node head){
        System.out.println("in-order:");
        if(head != null){
            Stack<Node> stack = new Stack<Node>();
            Node cur = head;
            while(!stack.isEmpty() || cur != null){
                if(cur != null){
                    stack.push(cur);
                    cur = cur.left;
                }else {
                    cur = stack.pop();
                    System.out.print(head.value + " ");
                    cur = cur.right;
                }
            }
        }
    }

    public void posOrderUnRecur1(Node head){
        System.out.println("pos-order");
        if(head != null){
            Stack<Node> s1 = new Stack<Node>();
            Stack<Node> s2 = new Stack<Node>();

            s1.push(head);
            while(!s1.isEmpty()){
                head = s1.pop();
                s2.push(head);
                if(head.left != null){
                    s1.push(head.left);
                }
                if(head.right != null){
                    s1.push(head.right);
                }
            }
            while(!s2.isEmpty()){
                System.out.print(s2.pop().value+ " ");
            }
        }
        System.out.println();
    }
}
