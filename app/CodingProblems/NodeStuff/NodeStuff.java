package app.CodingProblems.NodeStuff;

import java.util.*;

public class NodeStuff{

    public static void main(String[] args) throws Exception {
        CircleLinkedList a = new CircleLinkedList();
        Node n = new Node(1);
        Node o = new Node(2);
        Node p = new Node(3);
        Node x = new Node(4);
        Node y = new Node(5);

        a.addNode(n);
        a.addNode(o);
        a.addNode(p);
        a.addNode(x);
        a.addNode(y);

        System.out.println(a);


        //System.out.println(a);

    }

}