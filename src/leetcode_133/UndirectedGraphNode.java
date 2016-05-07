package leetcode_133;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jason on 2016/5/7.
 */
public class UndirectedGraphNode {
    int label;

    List<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
        label = x; neighbors = new ArrayList<UndirectedGraphNode>();
    }

}
