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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>>ans=new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode>q=new LinkedList<>();
         
        q.add(root);
        boolean flag=true;
        while(!q.isEmpty()){
            int levelsize=q.size();
             List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < levelsize; i++) {
            TreeNode node = q.poll();
            
            if (flag) {
                levelList.add(node.val); // Left to Right
            } else {
                levelList.add(0, node.val); // Right to Left, insert at the beginning
            }

            if (node.left != null) {
                q.add(node.left);
            }
            
            if (node.right != null) {
                q.add(node.right);
            }
        }
            
             ans.add(levelList);
           flag = !flag;
        }
        
        return ans;
    }
}