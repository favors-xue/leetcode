import java.util.List;

public class MainClass {
    public static void main(String... args) {
        Solution s = new Solution();
        TreeNode n = new TreeNode(5);
        TreeNode n1 = new TreeNode(6);
        TreeNode n2 = new TreeNode(7);
        TreeNode n3 = new TreeNode(8);
        TreeNode n4 = new TreeNode(9);
        TreeNode n5 = new TreeNode(10);
        n.left = n1;
        n.right = n2;
        n1.left = n3;
        n2.right = n4;
        n4.right = n5;
        List<List<Integer>> result = s.zigzagLevelOrder(n);
    }
}
