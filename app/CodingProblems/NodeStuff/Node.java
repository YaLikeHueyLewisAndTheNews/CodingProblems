package app.CodingProblems.NodeStuff;

public class Node{

    public int value;
    public Node prev;
    public Node next;

    public Node(int value){
        this.value = value;
    }

    public String toString(){
        return String.valueOf(value);
    }

}