package app.CodingProblems.NodeStuff;

import java.util.Collection;

public abstract class LinkedList {

    public Node head;
    protected int size;

    public LinkedList(){
        this.size = 0;
    }

    public abstract void addNode(Node node);
    public abstract void removeNode(Node node);
    public abstract void addNodes(Collection<Node> nodes);
    

    public Integer getSize(){
        return this.size;
    }

    public String toString(){

        String listString = "";

        Node curr = head;

        do{
            listString += curr + " ";
            curr = curr.next;
        }while(curr != null);

        return listString;
    }

}