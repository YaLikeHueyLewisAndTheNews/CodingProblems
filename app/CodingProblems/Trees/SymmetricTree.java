package app.CodingProblems.Trees;

import java.util.*;

public class SymmetricTree{

    private static final int maxNumOfChildren = 3;

    public static ArrayList<KaryTreeNode> convertTreeToArrayListUsingBFS(KaryTreeNode node, ArrayList<KaryTreeNode> treeList, Queue<KaryTreeNode> queue){

        treeList.add(node);

        if(node == null){
            return treeList;
        }

        KaryTreeNode[] children = node.getChildren();
        queue.add(Arrays.asList(children));
        while(!queue.isEmpty()){
            convertTreeToArrayListUsingBFS(queue.remove(), treeList, queue);
        }

        return treeList;
    }

    public static void preorderTraversal(KaryTreeNode node){
        if(node == null){
            return;
        }

        KaryTreeNode[] children = node.getChildren();
        
        System.out.println(node.getValue());

        if(children != null){
            for(int i = 0; i < children.length; i ++){
                KaryTreeNode child = children[i];
                preorderTraversal(child);
            }
        }
    }

    public static void postorderTraversal(KaryTreeNode node){
        if(node == null){
            return;
        }

        KaryTreeNode[] children = node.getChildren();

        if(children != null){
            for(int i = 0; i < children.length; i ++){
                KaryTreeNode child = children[i];
                postorderTraversal(child);
            }
        }
        System.out.println(node.getValue());
    }

    public static void inorderTraversal(KaryTreeNode node){
        if(node == null){
            return;
        }


        KaryTreeNode[] children = node.getChildren();

        if(children != null){
            for(int i = 0; i < children.length - 1; i ++){
                KaryTreeNode child = children[i];
                inorderTraversal(child);
            }
            System.out.println(node.getValue());
            inorderTraversal(children[children.length-1]);
        }else{
            System.out.println(node.getValue());
        }

    }

    public static void iterativeBFS(){
        KaryTreeNode root = createSampleTree();
        Queue<KaryTreeNode> queue = new Queue<KaryTreeNode>();
        queue.add(root);

        while(!queue.isEmpty()){
            KaryTreeNode node = queue.remove();
            System.out.println(node);
            queue.add(Arrays.asList(node.getChildren()));
        }

    }

    public static void main(String[] args) throws Exception {
        iterativeBFS();
    }

    public static void runConvertTreeToArrayList(){
        KaryTreeNode root = createSampleTree();
        ArrayList<KaryTreeNode> a = convertTreeToArrayListUsingBFS(root, new ArrayList<KaryTreeNode>(), new Queue<KaryTreeNode>());
        for(KaryTreeNode b : a){
            if(b != null){
                System.out.println(b.getValue());
            }else{
                System.out.println("null");
            }
        }
    }

    public static void runTraversalCode(){
        KaryTreeNode root = createSampleTree();
        System.out.println("Inorder Traversal: ");
        inorderTraversal(root);
        System.out.println("Pre-order Traversal: ");
        preorderTraversal(root);
        System.out.println("Post-order Traversal: ");
        postorderTraversal(root);
    }

    public static KaryTreeNode createSampleTree(){

        KaryTreeNode root = new KaryTreeNode(1)
        .withChildren(
            new KaryTreeNode[]{
                new KaryTreeNode(2)
                .withChildren(
                    new KaryTreeNode[]{
                        new KaryTreeNode(5),
                        new KaryTreeNode(6),
                        new KaryTreeNode(7)
                    }
                ),
                new KaryTreeNode(3),
                new KaryTreeNode(4)
            }
        );


        return root;
    }

    public static class Queue<T>{

        private ArrayList<T> queue;

        public Queue(){
            queue = new ArrayList<T>();
        }

        public void add(T item){
            queue.add(item);
        }

        public void add(List<T> items){
            queue.addAll(items);
        }

        public T remove(){
            return queue.remove(0);
        }

        public Boolean isEmpty(){
            return this.queue.isEmpty();
        }

        public int size(){
            return this.queue.size();
        }
    }

    public static class KaryTreeNode{

        private KaryTreeNode parent;
        private KaryTreeNode[] children;
        private int value;

        public KaryTreeNode(int value){
            this.value = value;
            this.children = new KaryTreeNode[maxNumOfChildren];
        }

        public KaryTreeNode withParent(KaryTreeNode parent){
            this.parent = parent;
            return this;
        }

        public KaryTreeNode withChildren(KaryTreeNode[] children){
            this.children = children;
            return this;
        }

        public KaryTreeNode[] getChildren(){
            return this.children;
        }

        public int getValue(){
            return this.value;
        }

        public String toString(){
            return String.valueOf(this.value);
        }

    }

}