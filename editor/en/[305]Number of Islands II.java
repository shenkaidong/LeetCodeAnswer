//You are given an empty 2D binary grid grid of size m x n. The grid represents 
//a map where 0's represent water and 1's represent land. Initially, all the cells
// of grid are water cells (i.e., all the cells are 0's). 
//
// We may perform an add land operation which turns the water at position into a
// land. You are given an array positions where positions[i] = [ri, ci] is the pos
//ition (ri, ci) at which we should operate the ith operation. 
//
// Return an array of integers answer where answer[i] is the number of islands a
//fter turning the cell (ri, ci) into a land. 
//
// An island is surrounded by water and is formed by connecting adjacent lands h
//orizontally or vertically. You may assume all four edges of the grid are all sur
//rounded by water. 
//
// 
// Example 1: 
//
// 
//Input: m = 3, n = 3, positions = [[0,0],[0,1],[1,2],[2,1]]
//Output: [1,1,2,3]
//Explanation:
//Initially, the 2d grid is filled with water.
//- Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land. We ha
//ve 1 island.
//- Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land. We st
//ill have 1 island.
//- Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land. We ha
//ve 2 islands.
//- Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land. We ha
//ve 3 islands.
// 
//
// Example 2: 
//
// 
//Input: m = 1, n = 1, positions = [[0,0]]
//Output: [1]
// 
//
// 
// Constraints: 
//
// 
// 1 <= m, n, positions.length <= 104 
// 1 <= m * n <= 104 
// positions[i].length == 2 
// 0 <= ri < m 
// 0 <= ci < n 
// 
//
// 
// Follow up: Could you solve it in time complexity O(k log(mn)), where k == pos
//itions.length? 
// Related Topics Array Union Find 
// 👍 1361 👎 42


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        boolean[][] exist = new boolean[m][n];
        UF uf = new UF(m*n);
        for (int[] p : positions) {
            if (!exist[p[0]][p[1]]) {
                exist[p[0]][p[1]] = true;
                uf.cnt++; // a new land added
                for (int[] dir : new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}}) {
                    int x = p[0] + dir[0];
                    int y = p[1] + dir[1];
                    if (0 <= x && x < m && 0 <= y && y < n && exist[x][y]) {
                        uf.union(p[0] * n + p[1], x * n + y);
                    }
                }
            }
            res.add(uf.cnt);
        }
        return res;
    }
    private static class UF {
        int n;
        int[] parent;
        int cnt;
        UF(int n) {
            this.n = n;
            this.cnt = 0;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }
        void union(int p, int q) {
            int rp = find(p);
            int rq = find(q);
            if (rp == rq) return;
            parent[rq] = rp;
            cnt--;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
