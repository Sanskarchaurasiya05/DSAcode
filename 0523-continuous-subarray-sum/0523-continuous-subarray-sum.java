class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums.length<2) return false;
        HashMap<Integer,Integer> mp = new HashMap<>();
        int sum=0;
        mp.put(0,-1); //(value,index)
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            int modulo = sum%k;
            
           
            if(mp.containsKey(modulo) || modulo==0){
                if(i-mp.get(modulo)>=2)
                return true;
            }else{
           mp.put(modulo,i);
            }
        }

return false;

    }
}