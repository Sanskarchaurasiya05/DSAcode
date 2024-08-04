class Coordinate {
    int value;
    int x;
    int y;

    Coordinate(int value, int x, int y) {
        this.value = value;
        this.x = x;
        this.y = y;
    }

     public int getValue() {
        return value;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Value: " + value + ", Coordinates: (" + x + ", " + y + ")";
    }
}

// Define the Comparator for the PriorityQueue
class CoordinateComparator implements Comparator<Coordinate> {
    @Override
    public int compare(Coordinate o1, Coordinate o2) {
        return Integer.compare(o1.value, o2.value);
    }
}

class Solution {
    // Define the Coordinate Class: This class will hold the integer value and the (x, y) coordinate.

// Implement the Comparator for the PriorityQueue: The comparator will define how the elements are compared to maintain the min-heap property.

// Create and Use the PriorityQueue.
    public int shortestPathBinaryMatrix(int[][] grid) {
          
            // Edge case: Check if start or end cell is blocked
     

        int[][] direction = {{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,-1},{1,1}};
        int n = grid.length;
        int m = grid[0].length;

           if (grid[0][0] == 1 || grid[n-1][m-1] == 1) {
            return -1;
        }
        
        //  create a corresponding 2d result array to store the distant from the source
        int[][] result=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                result[i][j]=Integer.MAX_VALUE;
            }
        }
        // once priorityqueue is created we push the source into the pq with it's own distant is 0. 
         PriorityQueue<Coordinate> pq = new PriorityQueue<>(new CoordinateComparator());
        
          pq.add(new Coordinate(1,0,0));
          result[0][0]=1;

          while(!pq.isEmpty()){
            Coordinate current=pq.poll();
              int d=current.getValue();
              int x=current.getX();
              int y=current.getY();
               // If we reached the bottom-right corner
            if (x == n - 1 && y == m - 1) {
                return d; // +1 to include the destination cell
            }
        // Explore the 8 possible directions
              for(int[] dir : direction){
                int x_=x+dir[0];
                int y_=y+dir[1];

                int dist=1;
  if(isSafe(x_,y_,n,m) && grid[x_][y_]==0 && d+dist<result[x_][y_]){
                  pq.add(new Coordinate(d+dist,x_,y_));
                  result[x_][y_]=d+dist;
                                  }             
                     }
          }

        return -1;

    }
     private boolean isSafe(int x, int y, int n, int m) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}