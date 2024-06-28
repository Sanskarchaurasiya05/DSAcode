class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res=new int[2];
        res[0]=first(nums,target);
        res[1]=last(nums,target);

        return res;
    }

    private static int first(int[] arr , int t){
        int s=0;
        int e=arr.length-1;
              int f=-1;
        while(s<=e){
            int mid=(s+e)/2;
            if(arr[mid]==t){
                   f=mid;
                   e=mid-1;
            }

           else if(arr[mid]<t)
            s=mid+1;

            else
            e=mid-1;
        }

      return f;
    }

     private static int last(int[] arr , int t){
        int s=0;
        int e=arr.length-1;
              int l=-1;
        while(s<=e){
            int mid=(s+e)/2;
            if(arr[mid]==t){
                   l=mid;
                   s=mid+1;
            }

           else if(arr[mid]<t)
            s=mid+1;
        
        else{
            e=mid-1;
        }
        }

       return l;
    }
}