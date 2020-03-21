package app.CodingProblems.NodeStuff;

import java.util.Collection;

public class DoublyLinkedList extends LinkedList {

    public DoublyLinkedList(){}

    public void addNode(Node node){
        node.next = head;
        head.prev = node;
        head = node;
    }

    public void addNodes(Collection<Node> nodes){
        for(Node node : nodes){
            addNode(node);
        }
    }

    public void removeNode(Node node){
        Node prev = null;
        Node x = head;

        if(head.equals(node)){
            this.head = head.next;
            node.next = null;
            this.size -= 1;
            return;
        }

        do{
            if(x.equals(node)){
                prev.next = x.next;
                x.next = null;
                this.size -= 1;
                break;
            }
            prev = x;
            x = x.next;
        }while(x !=null);
    }
}