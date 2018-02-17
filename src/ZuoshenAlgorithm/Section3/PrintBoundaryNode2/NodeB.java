package ZuoshenAlgorithm.Section3.PrintBoundaryNode2;

public class NodeB {


    public static void printEdge(NodeA head){

        if(head == null){
            return;
        }
        System.out.print(head.value+" ");
        if(head.left != null && head.right != null){
            printLeftEdge(head.left,true);
            printRightEdge(head.right,true);
        }else {
            printEdge(head.left != null ? head.left : head.right);
        }
        System.out.println();
    }

    public static void printLeftEdge(NodeA h,boolean print){
        if(h == null){
            return;
        }
        if(print || (h.left == null && h.right == null)){
            System.out.print(h.value + " ");
        }
        printLeftEdge(h.left,print);
        printLeftEdge(h.right,print && h.left == null ? true:false);
    }

    public static void printRightEdge(NodeA h,boolean print){
        if(h == null){
            return;
        }
        printRightEdge(h.left,print && h.right == null ? true:false);
        printRightEdge(h.right,print);

        if(print || (h.left == null && h.right == null)){
            System.out.print(h.value + " ");
        }
    }

    public static void main(String[] args) {
        NodeA nodeA1 = new NodeA(1);
        NodeA nodeA2 = new NodeA(2);
        NodeA nodeA3 = new NodeA(3);
        NodeA nodeA4 = new NodeA(4);
        NodeA nodeA5 = new NodeA(5);
        NodeA nodeA6 = new NodeA(6);
        NodeA nodeA7 = new NodeA(7);
        NodeA nodeA8 = new NodeA(8);
        NodeA nodeA9 = new NodeA(9);
        NodeA nodeA10 = new NodeA(10);
        NodeA nodeA11 = new NodeA(11);
        NodeA nodeA12 = new NodeA(12);
        NodeA nodeA13 = new NodeA(13);
        NodeA nodeA14 = new NodeA(14);
        NodeA nodeA15 = new NodeA(15);
        NodeA nodeA16 = new NodeA(16);
        nodeA1.left = nodeA2;
        nodeA1.right = nodeA3;
        nodeA2.right = nodeA4;
        nodeA3.left = nodeA5;
        nodeA3.right = nodeA6;
        nodeA4.left = nodeA7;
        nodeA4.right = nodeA8;
        nodeA5.left = nodeA9;
        nodeA5.right = nodeA10;
        nodeA8.right = nodeA11;
        nodeA9.left = nodeA12;
        nodeA11.left = nodeA13;
        nodeA11.right = nodeA14;
        nodeA12.left = nodeA15;
        nodeA12.right = nodeA16;
        printEdge(nodeA1);
    }

}
