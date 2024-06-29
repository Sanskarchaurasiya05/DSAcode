class Solution {
    public int search(int[] nums, int target) {
        int start=0;
        int end=nums.length-1;
        int index=minindex(nums,nums.length);
      int a=  search(nums,start,index-1,target);
        int b = search(nums,index,end ,target);
              if(a==-1)
              return b;

              return a;
    }

     private static int minindex(int[] arr ,int n){
        int s=0;
        int e=n-1;
        while(s<=e){
                        // If the array is already sorted 
            if (arr[s] <= arr[e]) {
                return s;
            }

            int mid=s+(e-s)/2;
            if(arr[mid]<arr[(mid+n-1)%n] && arr[mid]<arr[(mid+1)%n])
            return mid;
            
            if(arr[s]<=arr[mid])
            s=mid+1;
            else if(arr[e]>=arr[mid])
            e=mid-1;
        }
        
        return -1;
    }

    private static int search(int[] arr , int s , int e , int k){
        while(s<=e){
            int mid=s+(e-s)/2;

            if(arr[mid]==k)
            return mid;

            if(arr[mid]>k)
            e=mid-1;
            else if(arr[mid]<k)
            s=mid+1;
        }
        return -1;
    }
}