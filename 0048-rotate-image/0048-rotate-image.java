class Solution {
    public void rotate(int[][] matrix) {
        
        int n=matrix.length;
        int m=matrix[0].length;
// transpose if a matrix

        for(int i=0;i<n;i++){
            for(int j=i;j<m;j++){ 
                swap(matrix, i, j, j, i);
            }
        }
        //   now we reverse a each row
//    we reverse a row using two pointer approach , here we simple pass the row and it's size.
        for(int i=0;i<n;i++){
          reverse(matrix[i] , m);
            }
        
       return;
}

         public static void reverse(int[] row, int length) {
        int start = 0;
        int end = length - 1;
        while (start < end) {
            int temp = row[start];
            row[start] = row[end];
            row[end] = temp;
            start++;
            end--;
        }
    }

     public static void swap(int[][] matrix, int row1, int col1, int row2, int col2) {
        int temp = matrix[row1][col1];
        matrix[row1][col1] = matrix[row2][col2];
        matrix[row2][col2] = temp;
    
    }

}
