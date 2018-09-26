/*
https://www.geeksforgeeks.org/longest-increasing-subsequence-dp-3/

The Longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence
of a given sequence such that all elements of the subsequence are sorted in increasing order.
For example, the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and LIS is {10, 22, 33, 50, 60, 80}.
*/

class Solution {
    public int lengthLIS(int[] arr) {
        int[] lengths = new int[arr.length];
        lengths[0] = 1;

        for (int i = 1; i < arr.length; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] <= arr[i] && lengths[j] + 1 > max) {
                    max = lengths[j] + 1;
                }
            }
            lengths[i] = max;
        }

        int max = 0;
        for (int i : lengths) {
            if (i > max) {
                max = i;
            }
        }

        return max;
    }
}
