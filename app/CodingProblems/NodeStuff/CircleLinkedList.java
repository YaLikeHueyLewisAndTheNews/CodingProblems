package app.CodingProblems.NodeStuff;

import java.util.Collection;

public class CircleLinkedList extends LinkedList {

    Node lastNode;
    
    public CircleLinkedList(){}

    public void addNode(Node node){

        if(head == null){
            lastNode = node;
        }else{
            node.next = head;
        }

        head = node;
        lastNode.next = head;
        this.size += 1;
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
            lastNode.next = this.head;
            this.size -= 1;
        }else if(lastNode.equals(node)){
            
        }else{
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

    @Override
    public String toString(){
        String listString = "";

        Node curr = head;

        do{
            listString += curr + " ";
            curr = curr.next;
        }while(curr.next != head);

        return listString;
    }
}