package app.CodingProblems.Trees;

import java.util.ArrayList;

public class SumOfBSTCodingProblem {
    public static void main(String[] args){
        startProblem();
    }

    public static void startProblem(){
        BinaryTree.BinaryTreeNode root = BinaryTree.createSampleOrderedTree();
        Integer sum = 0;
        ArrayList<BinaryTree.BinaryTreeNode> checkedNodes = new ArrayList<BinaryTree.BinaryTreeNode>();
        System.out.println(getSum(4,9,root, sum, checkedNodes));
    }

    public static Integer getSum(Integer a, Integer b, BinaryTree.BinaryTreeNode node, Integer sum, ArrayList<BinaryTree.BinaryTreeNode> checkedNodes){

        if(node == null){
            return sum;
        }

        
        if(!checkedNodes.contains(node) && (node.getValue() >= a && node.getValue() <= b)){
            sum += node.getValue();
            checkedNodes.add(node);
        }

        sum = getSum(a,b, node.getLeftTree(), sum, checkedNodes);
        sum = getSum(a, b, node.getRightTree(), sum, checkedNodes);
        
        return sum;
    }
}