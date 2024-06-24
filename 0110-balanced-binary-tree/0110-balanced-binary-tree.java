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
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;;
        int l=helper(root.left);
        int r=helper(root.right);
               if(Math.abs(l-r)>1)
              return false;

           boolean left=isBalanced(root.left);
              boolean right=isBalanced(root.right);
            
            if(!left || !right)
            return false;
          
          return true;
          
    }

    private static int helper(TreeNode root){
        if(root==null)
        return 0;
        int l=helper(root.left);
        int r =helper(root.right);

        return 1+(Math.max(l,r));
    }
}