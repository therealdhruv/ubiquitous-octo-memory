package PhaseTwo;
import java.util.*;

public class vertical {

    public static List<Character> verticalView(TreeNode root) {

        List<Character> ans = new ArrayList<>();
        if (root == null) return ans;

        Map<Integer, List<Character>> map = new TreeMap<>();
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> hdQueue = new LinkedList<>();

        nodeQueue.offer(root);
        hdQueue.offer(0);

        while (!nodeQueue.isEmpty()) {
            TreeNode temp = nodeQueue.poll();
            int hd = hdQueue.poll();

            map.computeIfAbsent(hd, k -> new ArrayList<>()).add(temp.val);

            if (temp.left != null) {
                nodeQueue.offer(temp.left);
                hdQueue.offer(hd - 1);
            }

            if (temp.right != null) {
                nodeQueue.offer(temp.right);
                hdQueue.offer(hd + 1);
            }


        }

        for (List<Character> v: map.values()) ans.addAll(v);

        return ans;

    }


    public static void main(String[] args) {

        TreeNode root = new TreeNode('A');
        root.left = new TreeNode('B');
        root.right = new TreeNode('C');
        root.left.left = new TreeNode('D');
        root.right.left = new TreeNode('E');
        root.right.right = new TreeNode('F');

        List<Character> verticalViewResult = verticalView(root);

        // Printing the Vertical View
        System.out.print("Vertical View: ");
        for (char node : verticalViewResult) System.out.print(node + " ");

    }



}
