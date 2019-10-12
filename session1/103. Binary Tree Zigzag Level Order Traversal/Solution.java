/**
103. Binary Tree Zigzag Level Order Traversal
Medium

1151

68

Favorite

Share
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root ==null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 1;
        while(!q.isEmpty()) {
            int levelSize = q.size();
            List<Integer> record = new ArrayList<>();
            for (int i = 0;i<levelSize;i++) {
                TreeNode n = q.poll();
                if (level%2 == 1) {
                    record.add(n.val);
                }
                else {
                    record.add(0,n.val);
                }
                if (n.left!=null) {
                    q.offer(n.left);
                }
                if (n.right!=null) {
                    q.offer(n.right);
                }
            }
            res.add(record);
            level++;
        }
        return res;

    }
}
