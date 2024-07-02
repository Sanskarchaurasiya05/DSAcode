/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
       PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        inOrderTraversal(root, pq, k);
        return pq.peek();
    }
     private void inOrderTraversal(TreeNode node, PriorityQueue<Integer> pq, int k) {
        if (node == null) {
            return;
        }

        inOrderTraversal(node.left, pq, k);

        pq.add(node.val);
        if (pq.size() > k) {
            pq.poll();
        }

        inOrderTraversal(node.right, pq, k);
    }
}