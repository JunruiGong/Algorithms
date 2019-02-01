package LeetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Leetcode-56-Merge Intervals
 *
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * Example 1:
 *
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 *
 * Example 2:
 *
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * */
public class MergeIntervals {

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


    public List<Interval> merge(List<Interval> intervals) {

        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }

        Collections.sort(intervals, Comparator.comparingInt(a -> a.start));  // 后面是比较器

        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        List<Interval> result = new ArrayList<>();

        for (Interval interval : intervals) {

            // 后一个interval的起点比前一个interval的终点要小，说明存在overlapping
            // 更新end
            if (interval.start <= end) {
                end = Math.max(end, interval.end);
            } else {
                // 否则，保存interval，更新start和end
                result.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }

        result.add(new Interval(start, end));
        return result;
    }

    @Test
    public void test(){



    }
}
