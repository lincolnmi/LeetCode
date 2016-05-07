package leetcode_133;

import java.util.HashMap;

/**
 * Created by Jason on 2016/5/7.
 */

/**
 * Problem definition:
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


 * OJ's undirected graph serialization:
 * Nodes are labeled uniquely.

 * We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
 * As an example, consider the serialized graph {0,1,2#1,2#2,2}.

 * The graph has a total of three nodes, and therefore contains three parts as separated by #.

 * First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
 * Second node is labeled as 1. Connect node 1 to node 2.
 * Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
 * Visually, the graph looks like the following:

           1
          / \
         /   \
        0 --- 2
             / \
             \_/
 *
 */

/**
 * Answer:
 * DFS method
 * use a map to justify whether current node has been visited
 * if visited return it, else continue to transverse its neighbors
 */
public class Solution {

    HashMap<Integer,UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node==null) {
            return null;
        } if (map.containsKey(node.label)) {
            return map.get(node.label);
        } else {
            UndirectedGraphNode cloneNode = new UndirectedGraphNode(node.label);
            map.put(cloneNode.label,cloneNode);
            for (UndirectedGraphNode neighbor : node.neighbors) {
                cloneNode.neighbors.add(cloneGraph(neighbor));
            }
            return cloneNode;
        }
    }

}
