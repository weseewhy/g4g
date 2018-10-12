/*
https://www.geeksforgeeks.org/longest-palindromic-subsequence-dp-12/

Given a sequence, find the length of the longest palindromic subsequence in it.

If the given sequence is “BBABCBCAB”, then the output should be 7 as “BABCBAB” 
is the longest palindromic subseuqnce in it. “BBBBB” and “BBCBB” are also palindromic 
subsequences of the given sequence, but not the longest ones.
*/

class Solution {
    public int lengthLpsRecursive(String s) {
        return lengthLpsRecursive(s, 0, s.length() - 1);
    }

    private int lengthLpsRecursive(String s, int start, int end) {
        if (start > end) {
            return 0;
        } else if (end == start) {
            return 1;
        }

        if (s.charAt(start) == s.charAt(end)) {
            return 2 + lengthLpsRecursive(s, start + 1, end - 1);
        } else {
            return Math.max(lengthLpsRecursive(s, start, end - 1),
                    lengthLpsRecursive(s, start + 1, end - 1));
        }
    }

    public int lengthLpsIterative(String s) {
        int n = s.length() - 1;
        int[][] lcs = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            lcs[i][i] = 1;
        }

        for (int len = 2; len <= s.length(); len++) {
            for (int i = 0; i <= n - len + 1; i++) {
                int j = i + len - 1;

                if (s.charAt(i) == s.charAt(j)) {
                    lcs[i][j] = 2 + lcs[i + 1][j - 1];
                } else {
                    lcs[i][j] = Math.max(lcs[i][j - 1], lcs[i + 1][j]);
                }
            }
        }

        return lcs[0][n];
    }
}
