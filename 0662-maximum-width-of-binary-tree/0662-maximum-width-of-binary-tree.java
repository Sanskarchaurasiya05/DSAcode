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
    public int widthOfBinaryTree(TreeNode root) {
        // /first we create a queue to store a each node and it's index
        Queue<Pair<TreeNode,Integer>>q=new LinkedList<>();
        q.offer(new Pair<>(root,0));
        // here we create a maxwidth bcz at each level we have a width but we don't know which is maximum
        int maxwidth=0;
                
        while(!q.isEmpty()){
                //  now here we intialize startindex to achive result and it's changes at each level
                int startindex = q.peek().getValue();
                // now we intialze the endindex which is responsible for changing the index of next node , it's work as a index of prev node.
                int endindex=0;
                // here we intialize levelsize ===> of size of queue ==>jab tak queue me ele hoge tab tak ye chalega
                int levelsize=q.size();

                for(int i=0;i<levelsize;i++){
                    // queue ke top par jo pair node hai usse hum nikal lege  kuyki hume endindx and node ko extract krna hai for further process ke liye hai.

                    Pair<TreeNode,Integer>pair=q.poll();
                    endindex=pair.getValue();
                    TreeNode node=pair.getKey();
                    if(node.left!=null){
                        q.offer(new Pair<>(node.left,2 * endindex + 1));
                    }

                     if(node.right!=null){
                        q.offer(new Pair<>(node.right,2 * endindex + 2));
                    }
                }

                // now we campare with maxwidth
                maxwidth=Math.max(maxwidth,endindex-startindex+1);
        }

        return maxwidth;
    }
}