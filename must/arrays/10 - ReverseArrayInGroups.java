/*
https://www.geeksforgeeks.org/reverse-an-array-in-groups-of-given-size/

Given an array, reverse every sub-array formed by consecutive k elements.

Examples:

Input: arr = [1, 2, 3, 4, 5, 6, 7, 8, 9] k = 3
Output: [3, 2, 1, 6, 5, 4, 9, 8, 7]

Input: arr = [1, 2, 3, 4, 5, 6] k = 1
Output: [1, 2, 3, 4, 5, 6]

Input: arr = [1, 2, 3, 4, 5, 6, 7, 8] k = 10
Output: [8, 7, 6, 5, 4, 3, 2, 1]
*/

class Solution {
    public void reverseInGroups(int[] a, int k) {
        if (a == null || a.length == 0) {
            return;
        }

        int start = 0;
        while (start < a.length - 1) {
            int end = Math.min(a.length - 1, start + k - 1);
            reverse(a, start, end);
            start += k;
        }
    }

    private void reverse(int[] a, int start, int end) {
        while (start < end) {
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;
            start++;
            end--;
        }
    }
}
