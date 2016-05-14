package leetcode_295;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Jason on 2016/5/13.
 */

/**
 * Problem definition:
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

 * Examples:
 * [2,3,4] , the median is 3

 * [2,3], the median is (2 + 3) / 2 = 2.5

 * Design a data structure that supports the following two operations:

 * void addNum(int num) - Add a integer number from the data stream to the data structure.
 * double findMedian() - Return the median of all elements so far.
 * For example:

 * add(1)
 * add(2)
 * findMedian() -> 1.5
 * add(3)
 * findMedian() -> 2
 */

/**
 * Answer:
 * basic method
 * use an array to keep numbers, when add a new element, insert it into the right position to keep the array ordered
 * get the middle value from the array. 0(n^2)
 *
 * advanced method
 * use two heaps, one is the minHeap another is maxHeap
 * minHeap stores the half large values and maxHeap stores stores the half small values
 * int this case, the top value of minHeap and maxHeap may be the median value
 *
 * when insert a new element, let the top of minHeap is minHeapTop, maxHeap is maxHeapTop
 * if element > minHeap, insert to the minHeap
 * else maxHeapTop < element < minHeapTop, insert to any one heap
 * else element < maxHeapTop, insert to the maxHeapTop
 *
 * when to get the median value,
 * if minHeap.size() < maxHeap.size() return maxHeap.peek()
 * else minHeap.size() > maxHeap.size() return minHeap.peek()
 * else return (minHeap.peek()+maxHeap.peek())/2.0
 *
 * simplify advanced method
 * first add the num into the max heap
 * then the min heap add the peek value from the max heap
 * make sure the maxHeap.size()>=minHeap.size()
 */

public class Solution {
/*
basic method
    private ArrayList<Integer> list = new ArrayList<Integer>();

    // Adds a number into the data structure.
    public void addNum(int num) {
        list.add(num);
        int len = list.size(), i = len - 1;
        while (i >= 1) {
            if (list.get(i-1) > num) {
                list.set(i,list.get(i-1));
                i--;
            } else {
                break;
            }
        }
        list.set(i, num);
    }

    // Returns the median of current data stream
    public double findMedian() {
        int len = list.size();
        if (len%2==1) {
            return list.get(len/2);
        } else {
            return (list.get(len/2-1) + list.get(len/2)) * 1.0 / 2;
        }
    }*/

    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(),
    maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    });

    /* advanced method
    public void addNum(int num) {
        if (maxHeap.size()==0||num<=maxHeap.peek()) {
            if (maxHeap.size()>minHeap.size()) {
                minHeap.add(maxHeap.poll());
            }
            maxHeap.add(num);
        } else if (minHeap.size()==0||num>minHeap.peek()) {
            if (minHeap.size()>maxHeap.size()) {
                maxHeap.add(minHeap.poll());
            }
        } else {
            if (maxHeap.size()<=minHeap.size()) {
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }
        }
    }

    public double findMedian() {
        int min = minHeap.size(), max = maxHeap.size();
        if (min==0&&max==0) {
            return 0;
        } else if (min<max) {
            return maxHeap.peek();
        } else if (min==max) {
            return (minHeap.peek()+maxHeap.peek())*1.0/2;
        } else {
            return minHeap.peek();
        }
    }*/

    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if (maxHeap.size()<minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        return maxHeap.size()==minHeap.size()?(maxHeap.peek()+minHeap.peek())/2.0:maxHeap.peek();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.addNum(2);
        System.out.println(solution.findMedian());
        solution.addNum(3);
        System.out.println(solution.findMedian());
    }


}
