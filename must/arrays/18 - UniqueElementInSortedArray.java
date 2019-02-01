/*
https://www.geeksforgeeks.org/find-the-element-that-appears-once-in-a-sorted-array/

Given a sorted array in which all elements appear twice (one after one) and one element appears only once.
Find that element in O(log n) complexity.

Example:
Input: {1, 1, 3, 3, 4, 5, 5, 7, 7, 8, 8}
Output: 4
Input: {1, 1, 3, 3, 4, 4, 5, 5, 7, 7, 8}
Output: 8
*/

class Solution {
    public int findUnique(int[] a) {
        int start = 0;
        int end = a.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mid % 2 == 0) {
                if (a[mid] == a[mid - 1]) {
                    end = mid - 2;
                } else if (a[mid] == a[mid + 1]) {
                    start = mid + 2;
                } else {
                    return a[mid];
                }
            } else {
                if (a[mid] == a[mid - 1]) {
                    start = mid + 1;
                } else if (a[mid] == a[mid + 1]) {
                    end = mid - 1;
                } else {
                    return a[mid];
                }
            }
        }

        return a[start];
    }
}
