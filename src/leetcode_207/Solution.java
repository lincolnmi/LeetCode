package leetcode_207;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Jason on 2016/5/9.
 */

/**
 * Problem definition:
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is
 * expressed as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

 * For example:
 * 2, [[1,0]]
 * There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

 * 2, [[1,0],[0,1]]
 * There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0
 * you should also have finished course 1. So it is impossible.
 */

/**
 * Solution:
 * BFS topological sort
 * use a queue to record the node which indegree is 0
 * poll a node from the queue, remove the edge which stars from the node, that means minus the indegree of its point node
 */

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] adjacentMatrix = new int[numCourses][numCourses];
        int[] indegree = new int[numCourses];

        for (int i=0,len=prerequisites.length;i<len;i++) {
            int ready = prerequisites[i][0];
            int pre = prerequisites[i][1];
            if (adjacentMatrix[pre][ready]==0) {
                indegree[ready]++;
            }
            adjacentMatrix[pre][ready] = 1;
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        int count = 0;
        for (int i=0;i<numCourses;i++) {
            if (indegree[i]==0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            count++;
            int node = queue.poll();
            for (int i=0;i<numCourses;i++) {
                if (adjacentMatrix[node][i]!=0) {
                    if (--indegree[i]==0) {
                        queue.offer(i);
                    }
                }
            }
        }
        return count==numCourses;
    }

}
