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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null || root.val == p.val || root.val == q.val) 
        return root;

        TreeNode a=null,b=null;

        if(root.val>p.val && root.val>q.val)
               a=lowestCommonAncestor(root.left,p,q);
        else if(root.val<p.val && root.val<q.val)
            b= lowestCommonAncestor(root.right,p,q);
            else{
                  a=lowestCommonAncestor(root.left,p,q);
                    b= lowestCommonAncestor(root.right,p,q);
            }

             if(a==null && b==null)
            return null;
        
        
        if(a!=null && b==null)
            return a;
        
         if(a==null && b!=null)
            return b;
        
        
         if(a!=null && b!=null)
        return root;
        
        return root;
    }
}