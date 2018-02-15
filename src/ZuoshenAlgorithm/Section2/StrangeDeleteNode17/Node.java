package ZuoshenAlgorithm.Section2.StrangeDeleteNode17;

public class Node {

    public int value;
    public Node next;

    public Node(int data){
        this.value = data;
    }

    public void removeNodeWired(Node node){
        if(node == null){
            return;
        }
        Node next = node.next;
        if(next == null){
            throw new RuntimeException("can't remove last node");
        }
        node.value = next.value;
        node.next = next.next;
    }


}
