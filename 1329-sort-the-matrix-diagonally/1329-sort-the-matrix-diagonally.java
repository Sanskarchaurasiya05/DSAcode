class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        HashMap<Integer,List<Integer>> mp = new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int key = i-j;
                if(!mp.containsKey(key)){
                mp.put(key , new ArrayList<>());
                }
                mp.get(key).add(mat[i][j]);
            }
        }
           
        for(List<Integer>l:mp.values()){
        Collections.sort(l);
        }

        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                int key = i-j;
                int lastele = 0;
                List<Integer> al = mp.get(key);
                if(al!=null && !al.isEmpty())
                 lastele = al.remove(al.size() - 1);

                mat[i][j] = lastele;

            }
        }
          

      return mat;

    }
    
}