/*
https://www.geeksforgeeks.org/find-subarray-with-given-sum/

Given an unsorted array of nonnegative integers, find a continous subarray which adds to a given number.
Examples :
Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
Ouptut: Sum found between indexes 2 and 4

Input: arr[] = {1, 4, 0, 0, 3, 10, 5}, sum = 7
Ouptut: Sum found between indexes 1 and 4

Input: arr[] = {1, 4}, sum = 0
Output: No subarray found
*/

class Solution {
    public int[] subArrayWithGivenSum(int[] arr, int sum) {
        int[] out = new int[]{-1, -1};
        int start = 0;
        int curSum = 0;

        for (int i = 0; i < arr.length; i++) {
            curSum += arr[i];
            while (curSum > sum && start <= i) {
                curSum -= arr[start];
                start++;
            }

            if (curSum == sum) {
                out[0] = start + 1;
                out[1] = i + 1;
                return out;
            }
        }

        return out;
    }
}
