package app.CodingProblems.Trees;

public class BinaryTree{

    public static void preorderTraversal(BinaryTreeNode node){
        if(node == null){
            return;
        }
        System.out.println(node.getValue());
        preorderTraversal(node.getLeftTree());
        preorderTraversal(node.getRightTree());
    }

    public static void postorderTraversal(BinaryTreeNode node){
        if(node == null){
            return;
        }
        postorderTraversal(node.getLeftTree());
        postorderTraversal(node.getRightTree());
        System.out.println(node.getValue());

    }

    public static void inorderTraversal(BinaryTreeNode node){
        if(node == null){
            return;
        }
        inorderTraversal(node.getLeftTree());
        System.out.println(node.getValue());
        inorderTraversal(node.getRightTree());
    }

    public static void main(String[] args) throws Exception {
        BinaryTreeNode root = createSampleTree();
        System.out.println("Inorder Traversal: ");
        inorderTraversal(root);
        System.out.println("Post-order Traversal: ");
        postorderTraversal(root);
        System.out.println("Pre-order Traversal: ");
        preorderTraversal(root);

    }

    public static BinaryTreeNode createSampleTree(){
        BinaryTreeNode root = new BinaryTreeNode(1)
        .withLeftTree(
                new BinaryTreeNode(2)
                .withLeftTree(new BinaryTreeNode(4))
                .withRightTree(new BinaryTreeNode(5))
            )
        .withRightTree(new BinaryTreeNode(3));

        return root;
    }
    
    public static BinaryTreeNode createSampleOrderedTree(){
        BinaryTreeNode root = new BinaryTreeNode(5)
        .withLeftTree(
                new BinaryTreeNode(3)
                    .withLeftTree(new BinaryTreeNode(2))
                    .withRightTree(new BinaryTreeNode(4))
            )
        .withRightTree(
            new BinaryTreeNode(8)
                .withLeftTree(new BinaryTreeNode(6))
                .withRightTree(new BinaryTreeNode(10))
        );

        return root;
    }

    public static class BinaryTreeNode{

        private BinaryTreeNode parent;
        private BinaryTreeNode left;
        private BinaryTreeNode right;
        private int value;

        public BinaryTreeNode(int value){
            this.value = value;
        }

        public BinaryTreeNode withParent(BinaryTreeNode parent){
            this.parent = parent;
            return this;
        }

        public BinaryTreeNode withLeftTree(BinaryTreeNode left){
            this.left = left;
            return this;
        }

        public BinaryTreeNode withRightTree(BinaryTreeNode right){
            this.right = right;
            return this;
        }

        public BinaryTreeNode getLeftTree(){
            return this.left;
        }

        public BinaryTreeNode getRightTree(){
            return this.right;
        }

        public int getValue(){
            return this.value;
        }

    }

}