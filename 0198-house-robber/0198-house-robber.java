// 3.DP
class Solution {
    public int rob(int[] nums) {
       int n = idea(nums,0);
        return n;
    }
    
    public static  int idea(int[] nums , int i){
        if(i>=nums.length)
            return 0;
        
        int[] dp=new int[nums.length+1];
//         dp[i]=max stolen money till house i
      dp[0]=0;
        dp[1]=nums[0];
        
       for(int i1=2;i1<nums.length+1;i1++){
        int stole=nums[i1-1]+dp[i1-2];
        int skip=dp[i1-1];
           
           dp[i1]=Math.max(skip,stole);
    }
        return dp[nums.length];
    }
}


// *************************************************************************************************************
// 2.memo+rec

// class Solution {
//     public int rob(int[] nums) {
//        int n = idea(nums,0);
//         return n;
//     }
    
//     public static  int idea(int[] nums , int i){
//         if(i>=nums.length)
//             return 0;
        
//         int[] memo=new int[nums.length+1];
//         Arrays.fill(memo,-1);
        
//         if(memo[i]!=-1)
//             return memo[i];
        
//         int stole=nums[i]+idea(nums,i+2);
//         int skip=idea(nums,i+1);
        
//         return memo[i]=Math.max(stole,skip);
//     }
// }


//************************************************************************************************************
// 1. Recursion
// class Solution {
//     public int rob(int[] nums) {
//        int n = idea(nums,0);
//         return n;
//     }
    
//     public static  int idea(int[] nums , int i){
//         if(i>=nums.length)
//             return 0;
        
//         int stole=nums[i]+idea(nums,i+2);
//         int skip=idea(nums,i+1);
        
//         return Math.max(stole,skip);
//     }
// }