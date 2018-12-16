package LeetCode;

import org.junit.Test;

import java.util.Arrays;

/**
 * Leetcode-252-Meeting Rooms
 *
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 * determine if a person could attend all meetings.
 *
 * For example,
 * Given [[0, 30],[5, 10],[15, 20]],
 * return false.
 * */
public class MeetingRooms {
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

    public boolean canAttendMeeting(Interval[] intervals) {
        if (intervals == null || intervals.length < 1) {
            return false;
        }

        Arrays.sort(intervals, (a, b) -> a.start - b.start);

        int start = intervals[0].start;
        int end = intervals[0].end;
        for (int i=1;i<intervals.length;i++) {
            if (intervals[i].start <= end) {
                return false;
            } else {
                start = intervals[i].start;
                end = intervals[i].end;
            }
        }

        return true;
    }

    @Test
    public void Test(){
        Interval a = new Interval(0,10);
        Interval b = new Interval(5,10);
        Interval c = new Interval(15,20);



        Interval[] intervals={a,b,c};
        System.out.println(canAttendMeeting(intervals));
    }
}
