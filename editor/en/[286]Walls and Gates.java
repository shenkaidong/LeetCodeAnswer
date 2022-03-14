//You are given an m x n grid rooms initialized with these three possible values
//. 
//
// 
// -1 A wall or an obstacle. 
// 0 A gate. 
// INF Infinity means an empty room. We use the value 231 - 1 = 2147483647 to re
//present INF as you may assume that the distance to a gate is less than 214748364
//7. 
// 
//
// Fill each empty room with the distance to its nearest gate. If it is impossib
//le to reach a gate, it should be filled with INF. 
//
// 
// Example 1: 
//
// 
//Input: rooms = [[2147483647,-1,0,2147483647],[2147483647,2147483647,2147483647
//,-1],[2147483647,-1,2147483647,-1],[0,-1,2147483647,2147483647]]
//Output: [[3,-1,0,1],[2,2,1,-1],[1,-1,2,-1],[0,-1,3,4]]
// 
//
// Example 2: 
//
// 
//Input: rooms = [[-1]]
//Output: [[-1]]
// 
//
// 
// Constraints: 
//
// 
// m == rooms.length 
// n == rooms[i].length 
// 1 <= m, n <= 250 
// rooms[i][j] is -1, 0, or 231 - 1. 
// 
// Related Topics Array Breadth-First Search Matrix 
// 👍 2151 👎 34


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        int n = rooms[0].length;

        Queue<Tuple> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    q.offer(new Tuple(i, j, 0));
                }
            }
        }

        while (!q.isEmpty()) {
            Tuple curr = q.poll();
            for (int[] dir : new int[][]{{0,1},{0,-1},{1,0},{-1,0}}) {
                int x = curr.x + dir[0];
                int y = curr.y + dir[1];
                if (0 <= x && x < m && 0 <= y && y < n && rooms[x][y] > curr.d + 1) {
                    rooms[x][y] = curr.d + 1;
                    q.offer(new Tuple(x,y,rooms[x][y]));
                }
            }
        }
    }

    private class Tuple {
        int x;
        int y;
        int d;
        Tuple(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
