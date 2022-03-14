//There are n cities. Some of them are connected, while some are not. If city a 
//is connected directly with city b, and city b is connected directly with city c,
// then city a is connected indirectly with city c. 
//
// A province is a group of directly or indirectly connected cities and no other
// cities outside of the group. 
//
// You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the 
//ith city and the jth city are directly connected, and isConnected[i][j] = 0 othe
//rwise. 
//
// Return the total number of provinces. 
//
// 
// Example 1: 
//
// 
//Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
//Output: 3
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 200 
// n == isConnected.length 
// n == isConnected[i].length 
// isConnected[i][j] is 1 or 0. 
// isConnected[i][i] == 1 
// isConnected[i][j] == isConnected[j][i] 
// 
// Related Topics Depth-First Search Breadth-First Search Union Find Graph 
// 👍 4818 👎 229


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int m = isConnected.length;
        int n = isConnected[0].length;

        Map<Integer, Set<Integer>> map = new HashMap<>();
        init(isConnected, map, m, n);

        int cnt = 0;
        boolean[] visited = new boolean[m];
        for (int i = 0; i < m; i++) {
            if (!visited[i]) {
                bfs(i, map, visited);
                cnt++;
            }
        }
        return cnt;
    }

    private void bfs(int i, Map<Integer, Set<Integer>> map, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(i);
        visited[i] = true;
        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int next : map.get(curr)) {
                if (!visited[next]) {
                    q.offer(next);
                    visited[next] = true;
                }
            }
        }
    }

    private void init(int[][] M, Map<Integer, Set<Integer>> map, int m, int n) {
        for (int i = 0; i < m; i++) {
            map.putIfAbsent(i, new HashSet<>());
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (M[i][j] == 1) {
                    map.get(i).add(j);
                    map.get(j).add(i);
                }
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
