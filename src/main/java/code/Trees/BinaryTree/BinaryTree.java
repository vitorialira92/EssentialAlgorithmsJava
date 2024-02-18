package code.Trees.BinaryTree;

public class BinaryTree{
     public int value;
     public BinaryTree left;
     public BinaryTree right;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public BinaryTree getLeft() {
        return left;
    }

    public void setLeft(BinaryTree left) {
        this.left = left;
    }

    public BinaryTree getRight() {
        return right;
    }

    public void setRight(BinaryTree right) {
        this.right = right;
    }

    public BinaryTree(int value, BinaryTree left, BinaryTree right){
         this.value = value;
         this.left = left;
         this.right = right;
     }

}
