package leetcode_210;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Jason on 2016/5/10.
 */

/**
 * Problem definition:
 * There are a total of n courses you have to take, labeled from 0 to n - 1.

 Some courses may have prerequisites, for example to take course 0 you have to first take course 1,
 which is expressed as a pair: [0,1]

 Given the total number of courses and a list of prerequisite pairs, return the ordering of courses
 you should take to finish all courses.

 There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses,
 return an empty array.

 For example:

 2, [[1,0]]
 There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]

 4, [[1,0],[2,0],[3,1],[3,2]]
 There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2.
 Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].
 */

/**
 * Answer:
 * BFS + topological algorithm + LinkedMatrix
 */

public class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        int[] result = new int[numCourses];
        int len = prerequisites.length;
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        for (int i=0;i<numCourses;i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for (int i=0;i<len;i++) {
            int pre = prerequisites[i][0];
            int ready = prerequisites[i][1];
            ArrayList<Integer> nodes = graph[ready];
            nodes.add(pre);
            indegree[pre]++;
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        int count = 0;
        for (int i=0;i<numCourses;i++) {
            if (indegree[i]==0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int node = queue.poll();
            result[count++] = node;
            for (int i=0;i<graph[node].size();i++) {
                if (--indegree[graph[node].get(i)]==0) {
                    queue.offer(graph[node].get(i));
                }
            }
        }
        return count==numCourses?result:new int[0];
    }

}
