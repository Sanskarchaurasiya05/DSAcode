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
    TreeMap<Integer,TreeMap<Integer,ArrayList<Integer>>>mp=new TreeMap<>();
    public List<List<Integer>> verticalTraversal(TreeNode root) {
       List<List<Integer>>res=new ArrayList<>();
    //    mapping====>>  [col=>level=>[list]]
        //  TreeMap<Integer,TreeMap<Integer,ArrayList<Integer>>>mp=new TreeMap<>();
        //   now we fill the map
          dfs(root,0,0);

        // take care of sorting and fill the result
        // first we sort the column

        for(Map.Entry<Integer,TreeMap<Integer,ArrayList<Integer>>>entry:mp.entrySet()){
            TreeMap<Integer,ArrayList<Integer>>levelmap=entry.getValue();
            ArrayList<Integer>list=new ArrayList<>();
            for(Map.Entry<Integer,ArrayList<Integer>>subentry:levelmap.entrySet()){
                ArrayList<Integer>sublist = subentry.getValue();
                Collections.sort(sublist);
                list.addAll(sublist);
            }
            res.add(list);
        }
        return res;
    }


    
    private  void dfs(TreeNode root ,  int col ,int level){
        if(root==null)
        return;

        if(!mp.containsKey(col))
        mp.put(col,new TreeMap<>());

          if(!mp.get(col).containsKey(level))
        mp.get(col).put(level,new ArrayList<>());

        mp.get(col).get(level).add(root.val);

        dfs(root.left,col-1,level+1);

         dfs(root.right,col+1,level+1);

    }
}