/*
https://www.geeksforgeeks.org/longest-even-length-substring-sum-first-second-half/

Given a string ‘str’ of digits, find the length of the longest substring of ‘str’, 
such that the length of the substring is 2k digits and sum of left k digits is equal to the sum of right k digits.

Examples :
Input: str = "123123"
Output: 6
The complete string is of even length and sum of first and second half digits is same

Input: str = "1538023"
Output: 4
The longest substring with same first and second half sum is "5380"
*/

class Solution {
    public String calculateLength(String s) {
        int[] arr = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i) - '0';
        }

        // For all possible midpoints, expand to left and right to find equal sums
        int maxLength = 0;
        int maxStartsAt = -1;
        for (int i = 0; i < arr.length - 1; i++) {
            int left = i;
            int right = left + 1;
            int leftSum = 0;
            int rightSum = 0;

            while (left >= 0 && right < arr.length) {
                leftSum += arr[left];
                rightSum += arr[right];

                if (leftSum == rightSum && right - left + 1 > maxLength) {
                    maxLength = right - left + 1;
                    maxStartsAt = left;
                }

                left--;
                right++;
            }
        }

        return maxLength > 0 ? s.substring(maxStartsAt, maxStartsAt + maxLength) : "-";
    }
}
