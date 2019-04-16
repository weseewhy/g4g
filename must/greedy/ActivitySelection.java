/*
https://www.geeksforgeeks.org/activity-selection-problem-greedy-algo-1/

Given N activities with their start and finish times.
Select the maximum number of activities that can be performed by a single person,
assuming that a person can only work on a single activity at a time.

Note : The start time and end time of two activities may coincide.
*/

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int maxNumberOfActivities(int[] start, int[] end) {
        List<Interval> intervals = new ArrayList<>();
        for (int i = 0; i < start.length; i++) {
            intervals.add(new Interval(start[i], end[i]));
        }

        intervals.sort((i1, i2) -> i1.end != i2.end ? Integer.compare(i1.end, i2.end) : Integer.compare(i1.start, i2.start));

        int cnt = 1;
        Interval prev = intervals.get(0);

        for (int i = 1; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if (cur.start > prev.end) {
                cnt++;
                prev = cur;
            }
        }

        return cnt;
    }
}

class Interval {
    int start;
    int end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
