//You have a graph of n nodes labeled from 0 to n - 1. You are given an integer 
//n and a list of edges where edges[i] = [ai, bi] indicates that there is an undir
//ected edge between nodes ai and bi in the graph. 
//
// Return true if the edges of the given graph make up a valid tree, and false o
//therwise. 
//
// 
// Example 1: 
//
// 
//Input: n = 5, edges = [[0,1],[0,2],[0,3],[1,4]]
//Output: true
// 
//
// Example 2: 
//
// 
//Input: n = 5, edges = [[0,1],[1,2],[2,3],[1,3],[1,4]]
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 2000 
// 0 <= edges.length <= 5000 
// edges[i].length == 2 
// 0 <= ai, bi < n 
// ai != bi 
// There are no self-loops or repeated edges. 
// 
// Related Topics Depth-First Search Breadth-First Search Union Find Graph 
// 👍 2238 👎 57


//leetcode submit region begin(Prohibit modification and deletion)
// clarification
// 1. if root == null, return false?
// 2. so here I only need to return true or false right?
class Solution {

    public boolean validTree(int n, int[][] edges) {
        // two conditions need to be satisfied with for a valid tree
        // 1. number of nodes == number of edges + 1; too make sure that not a loop, no ring
        // 2. only on connected component

        if (edges.length + 1 != n) {
            return false;
        }

        Map<Integer, Set<Integer>> map = new HashMap<>();
        init(n, edges, map);

        int cnt = 0;
        boolean[] visited = new boolean[n];
        // to make sure this graph is is a connected graph
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, map, visited);
                cnt++;
            }
        }
        return cnt == 1;
    }

    private void dfs(int curr, Map<Integer, Set<Integer>> map, boolean[] visited) {
        visited[curr] = true;
        for (int next : map.get(curr)) {
            if (!visited[next]) {
                dfs(next, map, visited);
            }
        }
    }

    private void init(int n, int[][] edges, Map<Integer, Set<Integer>> map) {
        // since some nodes might not appear in the edges so it must be initialized first
        // like course schedule problem
        for (int i = 0; i < n; i++) {
            map.put(i, new HashSet<>());
        }
        for (int[] e : edges) {
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
