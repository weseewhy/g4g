/*
https://practice.geeksforgeeks.org/problems/missing-number-in-array/0

Given an array C of size N-1 and given that there are numbers from 1 to N
with one element missing, the missing number is to be found.
*/

class Solution {
    int missingNumber(int[] arr) {
        int numberOfElements = arr.length + 1;
        int missing = 0;

        for (int i = 1; i <= numberOfElements; i++) {
            missing ^= i;
        }

        for (int i : arr) {
            missing ^= i;
        }

        return missing;
    }
}
