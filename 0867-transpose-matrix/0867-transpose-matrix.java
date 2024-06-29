class Solution {
    public int[][] transpose(int[][] matrix) {
      int rowCount = matrix.length;
    int colCount = matrix[0].length;
    int[][] transposedMatrix = new int[colCount][rowCount];
    
    for (int i = 0; i < rowCount; i++) {
        for (int j = 0; j < colCount; j++) {
            transposedMatrix[j][i] = matrix[i][j];
        }
    }
    
    return transposedMatrix;
    }
}