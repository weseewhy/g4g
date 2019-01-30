/*
https://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station/

Given arrival and departure times of all trains that reach a railway station,
find the minimum number of platforms required for the railway station so that no train waits.
We are given two arrays which represent arrival and departure times of trains that stop

Examples:
Input:  arr[]  = {9:00,  9:40, 9:50,  11:00, 15:00, 18:00}
        dep[]  = {9:10, 12:00, 11:20, 11:30, 19:00, 20:00}
Output: 3
There are at-most three trains at a time (time between 11:00 to 11:20)
*/

import java.util.Arrays;

class Solution {
    public int maxNumberOfStations(int[] arrivals, int[] departures) {
        Arrays.sort(arrivals);
        Arrays.sort(departures);

        int i = 0;
        int j = 0;
        int cnt = 0;
        int max = 0;

        while (i < arrivals.length && j < departures.length) {
            if (arrivals[i] < departures[j]) {
                cnt++;
                i++;
                if (cnt > max) {
                    max = cnt;
                }
            } else if (departures[j] < arrivals[i]) {
                cnt--;
                j++;
            } else {
                i++;
                j++;
            }
        }

        return max;
    }
}
