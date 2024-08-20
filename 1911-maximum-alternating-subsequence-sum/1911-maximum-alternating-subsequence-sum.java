class Solution {
     static long[][] t=new long[100001][2];
    
    public Solution() {
        for (int i = 0; i < t.length; i++) {
            Arrays.fill(t[i], -1);
        }
    }
    
    public long maxAlternatingSum(int[] nums) {
     long ans = solve(nums,0,true);
        return ans;
    }
    
    public static long solve(int[] arr , int idx , boolean flag){
 
         if(idx>arr.length-1)return 0;
              
        if(t[idx][flag ? 1 : 0]!=-1)
            return t[idx][flag?1:0];
        
       
         long skip=solve(arr,idx+1,flag);
        
         long value=arr[idx];
        if(flag==false)
            value=-value;
        
         long take = solve(arr,idx+1,!flag)+value;
        
        return t[idx][flag?1:0]=Math.max(skip,take);
    }
}

// ******************************************************************************************************************
// class Solution {
//     public long maxAlternatingSum(int[] nums) {
//      int ans = solve(nums,0,true);
//         return ans;
//     }
    
//     public static int solve(int[] arr , int idx , boolean flag){
        
//         if(idx>arr.length-1)return 0;
//         int skip=solve(arr,idx+1,flag);
        
//         int value=arr[idx];
//         if(flag==false)
//             value=-value;
        
//         int take = solve(arr,idx+1,!flag)+value;
        
//         return Math.max(skip,take);
//     }
// }