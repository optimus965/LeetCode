class Solution {
    public int swimInWater(int[][] grid) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int ans = 0;
        for(int i =0;i < grid.length;i++) {
            for(int j = 0;j < grid[0].length;j++) {
                min = Math.min(min,grid[i][j]);
                max = Math.max(max,grid[i][j]);
            }
        }
        while(min <= max) {
            int mid = (min + max) >> 1;
            boolean[][] visited = new boolean[grid.length][grid[0].length];
            boolean visited1 = dfs(grid,0,0,mid,visited);
            if(visited1) {
                max = mid - 1;
                ans = mid;
            }
            else {
                min  = mid + 1;
            }
        }
        return ans;
    }
    int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    public boolean dfs(int[][] grid,int row, int col,int value,boolean[][] visited) {
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return false;
        }
        if(row == grid.length - 1 && col == grid[0].length - 1) {
            if(grid[row][col] <= value) {
                return true;
            }
            return false;
        }
        if(visited[row][col]) {
            return false;
        }
         visited[row][col] = true;
         boolean up =  grid[row][col] <= value && dfs(grid,row - 1, col, value,visited);
         if(up) {
             return up;
         }
         boolean down  = grid[row][col] <= value && dfs(grid,row + 1, col, value,visited);
         if(down) {
             return true;
         }
         boolean left  =grid[row][col] <= value && dfs(grid,row, col - 1, value,visited);
         if(left) {
             return true;
         }
         boolean right =grid[row][col] <= value && dfs(grid,row, col + 1, value,visited);
         if(right) {
             return true;
         }
        
         return false;
    }
}

