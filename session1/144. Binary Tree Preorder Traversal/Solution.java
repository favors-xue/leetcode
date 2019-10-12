/**
iven a binary tree, return the preorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,2,3]
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> h = new Stack<>();
        h.push(root);
        while(!h.isEmpty()) {
            TreeNode n = h.pop();
            res.add(n.val);
            if (n.right!=null) {
                h.push(n.right);
            }
            if (n.left!=null) {
                h.push(n.left);
            }


        }
        return res;
    }
}
