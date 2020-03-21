package app.CodingProblems.Trees;

public class SecondLargestNode{
    

    public static void main(String args[]){

        System.out.println(getSecondLargestNode(BinaryTree.createSampleOrderedTree()));

    }

    public static BinaryTree.BinaryTreeNode getSecondLargestNode(BinaryTree.BinaryTreeNode root){


        BinaryTree.BinaryTreeNode[] array = new BinaryTree.BinaryTreeNode[2];
        array[0] = root;
        array[1] = null;
        inorderTraversal(root, array);
        return array[1];
    }

    public static void inorderTraversal(BinaryTree.BinaryTreeNode node, BinaryTree.BinaryTreeNode[] array){

        if(node == null){
            return;
        }

        inorderTraversal(node.getLeftTree(), array);
        if(node.getValue() > array[0].getValue()){
            array[1] = array[0];
            array[0] = node;
        }

        inorderTraversal(node.getRightTree(), array);

    }

}