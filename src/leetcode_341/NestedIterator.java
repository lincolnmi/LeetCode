package leetcode_341;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

/**
 * Created by Jason on 2016/5/15.
 */

/**
 * Problem definition:
 * Given a nested list of integers, implement an iterator to flatten it.

 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.

 * Example 1:
 * Given the list [[1,1],2,[1,1]],

 * By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].

 * Example 2:
 * Given the list [1,[4,[6]]],

 * By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].
 */

/**
 * Answer:
 * use a stack to store nestedInteger
 * split the list into each element and put it into the stack
 */
public class NestedIterator implements Iterator<Integer> {

    private Stack<NestedInteger> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<NestedInteger>();
        for (int i=nestedList.size()-1;i>=0;i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.empty()) {
            NestedInteger value = stack.peek();
            if (value.isInteger()) {
                return true;
            }
            stack.pop();
            List<NestedInteger> values = value.getList();
            for (int i=values.size()-1;i>=0;i--) {
                stack.push(values.get(i));
            }
        }
        return false;
    }

}
