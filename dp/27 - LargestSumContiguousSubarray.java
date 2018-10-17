/*
https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/

Find the sum of contiguous subarray within a one-dimensional array of numbers which has the largest sum.

Example: {-2, -3, 4, -1, -2, 1, 5, -3}
Output: 7 for array {4, -1, -2, 1, 5}
*/

import java.util.Arrays;

class Solution {
    public int largestContiguousSum(int[] arr) {
        int max = arr[0];
        int windowMax = arr[0];

        for (int i = 1; i < arr.length; i++) {
            windowMax = Math.max(arr[i], windowMax + arr[i]);
            if (windowMax > max) {
                max = windowMax;
            }
        }

        return max;
    }

    public int[] arrayWithLargestSum(int[] arr) {
        int wLeft = 0;
        int wRight;
        int windowMax = arr[0];

        int max = arr[0];
        int left = 0;
        int right = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > windowMax + arr[i]) {
                wLeft = i;
                wRight = i;
                windowMax = arr[i];
            } else {
                wRight = i;
                windowMax = windowMax + arr[i];
            }

            if (windowMax > max) {
                max = windowMax;
                left = wLeft;
                right = wRight;
            }
        }

        return Arrays.copyOfRange(arr, left, right + 1);
    }
}
