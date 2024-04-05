package PhaseTwo;

public class BoundaryTraversal {

    public static void printLeaves(TreeNode root) {
        if (root != null) {
            printLeaves(root.left);
            if (root.left == null && root.right == null) System.out.println(root.val + " ");
            printLeaves(root.right);
        }
    }

    public static void boundaryTraversal(TreeNode root) {
        if (root != null) {
            System.out.println(root.val + " ");
            printLeaves(root.left);
            printLeaves(root.right);
        }
    }

    public static void main(String[] args) {
        // Constructing the example tree
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);
        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(13);
        // Calling the boundaryTraversal function
        boundaryTraversal(root);
    }



}
