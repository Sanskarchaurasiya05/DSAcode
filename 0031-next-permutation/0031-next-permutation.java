class Solution {
    public void nextPermutation(int[] arr) {
        int n=arr.length;
     int gola_idx=-1;
         for(int i=n-1;i>0;i--){
             if(arr[i]>arr[i-1]){
                   gola_idx=i-1;
                   break;
                }
         }

         int swap_idx=-1;
         if(gola_idx!=-1){
            for(int j=n-1;j>gola_idx;j--){
                if(arr[gola_idx]<arr[j]){
                        swap_idx=j;
                        break;
                }
            }

            swap(arr,gola_idx,swap_idx);
         } 

         reverse(arr , gola_idx+1 , n-1);
           
    }

      public static void swap(int[] arr, int index1, int index2) {
       
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

     public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }
}