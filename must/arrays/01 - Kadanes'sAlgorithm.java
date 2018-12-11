/*
https://practice.geeksforgeeks.org/problems/kadanes-algorithm/0

Given an array containing both negative and positive integers. Find the contiguous sub-array with maximum sum.
*/

class Solution {
    public int kadaneAlgorithm(int[] arr) {
        int max = arr[0];
        int prevWindowSum = max;

        for (int i = 1; i < arr.length; i++) {
            prevWindowSum = Math.max(prevWindowSum + arr[i], arr[i]);
            max = Math.max(max, prevWindowSum);
        }

        return max;
    }
}
