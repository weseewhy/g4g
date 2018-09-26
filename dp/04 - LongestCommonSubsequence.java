/*
https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/

Given two sequences, find the length of longest subsequence present in both of them.
A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous.
Examples:
LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.
*/

class Solution {
    public int findLCSRecursive(String a, String b) {
        return findLCS(a.toCharArray(), b.toCharArray(), a.length() - 1, b.length() - 1);
    }

    private int findLCS(char[] a, char[] b, int i, int j) {
        if (i < 0 || j < 0) {
            return 0;
        }

        if (a[i] == b[j]) {
            return findLCS(a, b, i - 1, j - 1) + 1;
        } else {
            return Math.max(findLCS(a, b, i - 1, j), findLCS(a, b, i, j - 1));
        }
    }

    public int findLCSIterative(String a, String b) {
        int m = a.length();
        int n = b.length();
        int[][] len = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    len[i][j] = 0;
                } else if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    len[i][j] = len[i - 1][j - 1] + 1;
                } else {
                    len[i][j] = Math.max(len[i][j - 1], len[i - 1][j]);
                }
            }
        }

        return len[a.length()][b.length()];
    }
}
