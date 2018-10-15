/*
https://www.geeksforgeeks.org/minimum-number-of-squares-whose-sum-equals-to-given-number-n/

A number can always be represented as a sum of squares of other numbers.
Note that 1 is a square and we can always break a number as (1*1 + 1*1 + 1*1 + …).
Given a number n, find the minimum number of squares that sum to X.

Examples :
Input:  n = 100
Output: 1
100 can be written as 10^2.

Note that 100 can also be written as 5^2 + 5^2 + 5^2 + 5^2,
but this representation requires 4 squares.

Input:  n = 6
Output: 3
*/

class Solution {
    public int minSquareCountWithSumN(int n) {
        int[] minSum = new int[n + 1];

        // worst case for any digit = sum of all 1squares
        for (int i = 0; i <= n; i++) {
            minSum[i] = i;
        }

        for (int i = 4; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                minSum[i] = Math.min(minSum[i], 1 + minSum[i - j * j]);
            }
        }

        return minSum[n];
    }
}
