/*
Given an array of n positive integers.
Write a program to find the sum of maximum sum subsequence of the given array
such that the integers in the subsequence are sorted in increasing order.

For example,
if the input array is {1, 101, 2, 3, 100, 4, 5}, then output should be 106 (1 + 2 + 3 + 100),
if the input array is {3, 4, 5, 10}, then output should be 22 (3 + 4 + 5 + 10)
if the input array is {10, 5, 4, 3}, then output should be 10
*/

class Solution {
    public int maxSumOfIncreasingSubSequence(int[] a) {
        if (a == null || a.length == 0) {
            return 0;
        }

        int[] cache = new int[a.length];
        cache[0] = a[0];
        int maxSum = cache[0];

        for (int i = 1; i < a.length; i++) {
            int curSum = a[i];
            for (int j = i - 1; j >= 0; j--) {
                if (a[j] <= a[i]) {
                    curSum += cache[j];
                    break;
                }
            }

            maxSum = Math.max(curSum, maxSum);
            cache[i] = curSum;
        }

        return maxSum;
    }
}
