/**
Given a binary tree, return the inorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> cache = new Stack<>();
        traval(root,cache);
        while(!cache.isEmpty()) {
            TreeNode n = cache.pop();
            res.add(n.val);
            if(n.right!=null) {
                cache.push(n.right);
                travel(n.right,cache);
            }
        }
        return res;
    }

    private void traval(TreeNode node, Stack<TreeNode> cache) {
        while(node.left!=null) {
            cache.push(node);
            node = node.left;
        }
    }
}
