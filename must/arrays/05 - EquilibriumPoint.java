/*
https://www.geeksforgeeks.org/equilibrium-index-of-an-array/
https://www.geeksforgeeks.org/find-element-array-sum-left-array-equal-sum-right-array/

Equilibrium index of an array is an index such that the sum of elements at lower indexes is equal
to the sum of elements at higher indexes.

Example :
Input : A[] = {-7, 1, 5, 2, -4, 3, 0}
Output : 3 because: A[0] + A[1] + A[2]  =  A[4] + A[5] + A[6]

Write a function int equilibrium(int[] arr, int n);
that given a sequence arr[] of size n, returns an equilibrium index (if any) or -1 if no equilibrium indexes exist.
*/

class Solution {
    public int pivotIndex(int[] nums) {
        int total = 0;
        for (int i : nums) {
            total += i;
        }

        int left = 0;
        int right = total;

        for (int i = 0; i < nums.length; i++) {
            if (i > 0) {
                left += nums[i - 1];
            }
            right -= nums[i];
            if (left == right) {
                return i + 1;
            }
        }

        return -1;
    }
}
