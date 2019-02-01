package Algorithm2;

/**
 * Leetcode-253-Meeting Rooms II
 *
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 * find the minimum number of conference rooms required.
 *
 * For example,
 * Given [[0, 30],[5, 10],[15, 20]],
 * return 2.
 * */

public class MeetingRoomsII {
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


    /**
     *
     * start：
     *  |   |    |  |
     *
     *  end：
     *        |   |   | |
     *
     * 如果一个会议的开始时间比前一个会议的结束时间要早，就意味着需要再开一个房间
     */

    public int minMeetingRooms(Interval[] intervals) {

        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }

        int result = 0;
        int end = 0;

        for (int i = 1; i < intervals.length; i++) {
            if (starts[i] < ends[end]) {
                result++;
            } else {
                end++;
            }
        }

        return result;
    }
}
