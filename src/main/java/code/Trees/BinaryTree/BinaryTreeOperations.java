package code.Trees.BinaryTree;

public class BinaryTreeOperations {
    public static BinaryTree root = null;

    public static boolean createTree(int value){
        if(root != null)
            return false;

        root = new BinaryTree(value, null, null);
        return true;
    }

    public static BinaryTree insert(BinaryTree root, BinaryTree leaf){
        if(root == null)
            root = leaf;

        if(root.getValue() > leaf.getValue()) root.left = insert(root.getLeft(), leaf);
        else root.right = insert(root.getRight(), leaf);

        return root;
    }
}
