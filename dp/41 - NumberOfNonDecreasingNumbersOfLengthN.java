/*
https://www.geeksforgeeks.org/total-number-of-non-decreasing-numbers-with-n-digits/

A number is non-decreasing if every digit (except the first one) is greater than or equal to previous digit.
For example, 223, 4455567, 899, are non-decreasing numbers.
So, given the number of digits n, you are required to find the count of total non-decreasing numbers with n digits.

Hint:
Count of n digit numbers = (Count of (n-1) digit numbers Ending with digit 9) +
                           (Count of (n-1) digit numbers Ending with digit 8) +
                           .............................................+
                           .............................................+
                           (Count of (n-1) digit numbers Ending with digit 0)
*/

class Solution {
    public int numberOfNonDecreasingNumbersOfLengthN(int n) {
        // [ending digit][length of number]
        int[][] cnt = new int[10][n + 1];

        // for single digit numbers
        for (int endingDigit = 0; endingDigit <= 9; endingDigit++) {
            cnt[endingDigit][1] = 1;
        }

        for (int endDigit = 0; endDigit <= 9; endDigit++) {
            for (int len = 2; len <= n; len++) {
                for (int i = 0; i <= endDigit; i++) {
                    cnt[endDigit][len] += cnt[i][len - 1];
                }
            }
        }

        int total = 0;
        for (int endDigit = 0; endDigit <= 9; endDigit++) {
            total += cnt[endDigit][n];
        }

        return total;
    }
}
