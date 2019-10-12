/**
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayLIst<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        Queue<Integer> l = new LinkedList<>();
        l.offer(0)
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            int level = l.poll();
            if (level+1>res.length) {
                List<Integer> record = new ArrayList<>();
                res.add(record);
            }
            res.get(level).add(node.val);
            if (node.left!=null) {
                q.offer(node.left);
                l.offer(level+1);
            }
            if (node.right!=null) {
                q.offer(node.right);
                l.offer(level+1);
            }

        }
        return res;
    }
}
