//Given an m x n 2D binary grid grid which represents a map of '1's (land) and '
//0's (water), return the number of islands. 
//
// An island is surrounded by water and is formed by connecting adjacent lands h
//orizontally or vertically. You may assume all four edges of the grid are all sur
//rounded by water. 
//
// 
// Example 1: 
//
// 
//Input: grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//Output: 1
// 
//
// Example 2: 
//
// 
//Input: grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//Output: 3
// 
//
// 
// Constraints: 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] is '0' or '1'. 
// 
// Related Topics Array Depth-First Search Breadth-First Search Union Find Matri
//x 
// 👍 12239 👎 308


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null && grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    bfs(grid, visited, i, j, m, n);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private void bfs(char[][] grid, boolean[][] visited, int i, int j, int m, int n) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(i*n + j);
        visited[i][j] = true;
        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int[] dir : new int[][]{{1,0},{-1,0},{0,1},{0,-1}}) {
                int x = curr/n + dir[0];
                int y = curr%n + dir[1];
                if (0 <= x && x < m && 0 <= y && y < n && !visited[x][y] && grid[x][y] == '1') {
                    q.offer(x*n + y);
                    visited[x][y] = true;
                }
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
