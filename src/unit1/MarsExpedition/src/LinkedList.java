public class LinkedList {
    Node head = new Node();

    public void add(){
        head.nextNode = new Node();
    }

    private class Node{
        Node nextNode;
        int data;
    }
}
