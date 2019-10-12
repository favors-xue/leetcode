/**
Given a binary tree, return the postorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [3,2,1]
Follow up: Recursive solution is trivial, could you do it iteratively?
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root==null) return res;
        Stack<TreeNode> cache = new Stack<>()
        travel(node,cache);
        while(!cache.isEmpty()) {
            right = cache.peek().right;
            while (right!=null && right!=root) {
                travel(right,cache);
                right = cache.peek().right;
            }
            root = cache.pop();
            res.add(root.val);

        }
        return res;

    }

    private void travel(TreeNode node, Stack<TreeNode> cache) {
        while(node!=null) {
            cache.push(node);
            node = node.left;
        }
    }
}
