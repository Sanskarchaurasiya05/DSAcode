class Solution {
    public int longestSubarray(int[] nums) {
       int n = nums.length;
       int last_idx = -1;
       int l=0,r=0;
       int mxm = Integer.MIN_VALUE;
       while(r<n){
           if(nums[r]==0){
            l=last_idx+1;
            last_idx=r;
           }
                   mxm=Math.max(mxm,r-l);
                   r++;
       }
        
              return mxm;
        }
    }
