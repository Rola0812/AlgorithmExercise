package ZuoshenAlgorithm.Section3.PrintBoundaryNode2;

public class NodeA {
    
    public int value;
    public NodeA left;
    public NodeA right;
    
    public NodeA(int data){
        this.value = data;
    }
    
    public static void printEdge(NodeA head){
        if(head == null){
            return;
        }
        int height = getHeight(head,0);
        NodeA[][] edgeMap = new NodeA[height][2];
        setEdgeMap(head,0,edgeMap);

        //打印左边界
        for(int i = 0; i !=edgeMap.length;i++){
            System.out.print(edgeMap[i][0].value + " ");
        }

        printLeafNotInMap(head,0,edgeMap);

        for(int i = edgeMap.length-1;i != -1;i--){
            if(edgeMap[i][0] != edgeMap[i][1]){
                System.out.print(edgeMap[i][1].value + " ");
            }
        }
    }

    private static void printLeafNotInMap(NodeA h, int l, NodeA[][] m) {

        if(h == null){
            return;
        }
        if(h.left == null && h.right == null && h != m[l][0] && h != m[l][1]){
            System.out.print(h.value + " ");
        }
        printLeafNotInMap(h.left,l+1,m);
        printLeafNotInMap(h.right,l+1,m);

    }

    private static void setEdgeMap(NodeA h, int l, NodeA[][] edgeMap) {

        if(h==null){
            return;
        }
        edgeMap[l][0] = edgeMap[l][0] == null ? h : edgeMap[l][0];
        edgeMap[l][1] = h;
        System.out.println("此时h="+h.value+",l="+l);
        System.out.println("edgeMap["+l+"][0]的值为："+edgeMap[l][0].value);
        System.out.println("edgeMap["+l+"][1]的值为："+edgeMap[l][1].value);

        setEdgeMap(h.left,l+1,edgeMap);
        setEdgeMap(h.right,l+1,edgeMap);

    }

    private static int getHeight(NodeA head, int i) {
        if(head == null){
            return i;
        }
        return Math.max(getHeight(head.left,i+1),getHeight(head.right,i+1));
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
