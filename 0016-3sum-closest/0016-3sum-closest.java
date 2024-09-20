class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
        int n = nums.length;
        Arrays.sort(nums);
               int closestsum=100000;
        for(int k=0;k<n;k++){
            int n1 = nums[k];
            int i=k+1 , j=n-1;
            while(i<j){
                int sum = n1 + nums[i]+nums[j];
             int a=Math.abs(target-sum);
             int b=Math.abs(target-closestsum);
                if(a<b)
                closestsum = sum;

                if(sum>target) 
                j--;
                
                 else
                 i++;


            }
        }

        return closestsum;

    }
}


