//There are a total of numCourses courses you have to take, labeled from 0 to nu
//mCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai,
// bi] indicates that you must take course bi first if you want to take course ai.
// 
//
// 
// For example, the pair [0, 1], indicates that to take course 0 you have to fir
//st take course 1. 
// 
//
// Return true if you can finish all courses. Otherwise, return false. 
//
// 
// Example 1: 
//
// 
//Input: numCourses = 2, prerequisites = [[1,0]]
//Output: true
//Explanation: There are a total of 2 courses to take. 
//To take course 1 you should have finished course 0. So it is possible.
// 
//
// Example 2: 
//
// 
//Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
//Output: false
//Explanation: There are a total of 2 courses to take. 
//To take course 1 you should have finished course 0, and to take course 0 you s
//hould also have finished course 1. So it is impossible.
// 
//
// 
// Constraints: 
//
// 
// 1 <= numCourses <= 105 
// 0 <= prerequisites.length <= 5000 
// prerequisites[i].length == 2 
// 0 <= ai, bi < numCourses 
// All the pairs prerequisites[i] are unique. 
// 
// Related Topics Depth-first Search Breadth-first Search Graph Topological Sort
// 
// 👍 5370 👎 219


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 为了统计未来入度的长度, 大小为课程大小
        int[] inDegree = new int[numCourses];
        // 生成一个HashMap, 以每个课程的数字为key, 以每个课的前置课为value
        Map<Integer,Set<Integer>> graph = new HashMap<>();
        // 循环遍历前置课程
        for (int[] prerequisite : prerequisites) {
            // 这个是用lamda表达式, 当prerequisite[1]没有value的话, 就new 一个hashSet, 然后再加prerequsite[0]进HashSet. 如果已经有了hashSet, 直接加进去就好了.
            // 这里的目的是把课程完成后, 之后可以解绑的课程都放到hashset里
            graph.computeIfAbsent(prerequisite[1],k -> new HashSet<>()).add(prerequisite[0]);
            // 统计课程的入度. 这里要注意, 统计课程prerequisite[0]而不统计课程prerequisite[1].
            // 这里要思考几个问题, 1. 谁是前置课.答: 显然是[1]是[0]的前置课 2. 有前置课的[0]必有入度, 而[1]有可能没有入读, 当有向图没有环的话, 只需要找到最后一个[1], 这个就是课程的起点
            inDegree[prerequisite[0]]++;
        }
        // 为了使用BFS, new 一个queue出来
        Queue<Integer> queue = new ArrayDeque<>();
        // 当入度为0时就让他入queue, 意味着可以作为起始课程了, 然后根据这个起始课程找到其他的课程
        for (int i=0; i<inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
            // 当queue不为空, 则拿出一个入度为0的课, 并且课程总数减一, 当queue为空, 则跳到return
            // 这里如果有环, 也就意味着入度不可能为0, 这样的话, 会出现当queue里没有东西了, 但是课程还没有poll完, 这样numCourses!= 0, return肯定是false
            while(!queue.isEmpty()){
                int course = queue.poll();
                numCourses--;
                // 当graph中没有这个key, 就跳出本次循环, 这里要以queue中有没有课程为结束条件, 不能以有没有退出循环来设定结束条件
                if (!graph.containsKey(course)){
                    continue;
                }
                // 拿出每一次课程的后面可选的课, 这里的目的是把每个课程的入度减一, 并且把入度为0的课程加入queue
                for (int relatedCourse: graph.get(course)){
                    // 后面的课程入度减一, 因为这个课程的一个前置被移除了
                    inDegree[relatedCourse]--;
                    // 如果入度为0, 则这个课程可以加入queue
                    if (inDegree[relatedCourse] == 0){
                        queue.offer(relatedCourse);
                    }
                }
            }
            // 如果numCourse为0则为真, 如果不为0则为假
            return numCourses == 0;
        }
}
//leetcode submit region end(Prohibit modification and deletion)


