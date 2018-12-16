package LeetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode-57-Insert Interval
 *
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 *
 * You may assume that the intervals were initially sorted according to their start times.
 *
 * Example 1:
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 *
 * Example 2:
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 * */
public class InsertInterval {

    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {

        if (newInterval == null) {
            return intervals;
        }

        List<Interval> result = new ArrayList<>();

        int i = 0;

        while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
            result.add(intervals.get(i++));
        }

        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
            newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
            i++;
        }

        result.add(newInterval);

        while (i < intervals.size()) {
            result.add(intervals.get(i));
            i++;
        }

        return result;
    }

    @Test
    public void Test(){
        Interval a = new Interval(1,3);
        Interval b = new Interval(6,9);
//        Interval c = new Interval(15,20);

        Interval newInterval = new Interval(2,5);

        List<Interval> list = new ArrayList<>();
        list.add(a);
        list.add(b);
//        list.add(c);
        System.out.println(insert(list,newInterval));
    }
}
