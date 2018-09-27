/*
https://www.geeksforgeeks.org/edit-distance-dp-5/

Given two strings str1 and str2 and below operations that can performed on str1.
Find minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.
   - Insert
   - Remove
   - Replace
All of the above operations are of equal cost.

Examples:
Input:   str1 = "geek", str2 = "gesek"
Output:  1
We can convert str1 into str2 by inserting a 's'.

Input:   str1 = "cat", str2 = "cut"
Output:  1
We can convert str1 into str2 by replacing 'a' with 'u'.

Input:   str1 = "sunday", str2 = "saturday"
Output:  3
Last three and first characters are same.  We basically need to convert "un" to "atur".
This can be done using below three operations.
Replace 'n' with 'r', insert t, insert a
*/

public class Solution {
    public int minEditDistanceRecursive(String s, String t) {
        return minEditDistanceRecursiveHelper(s, t, s.length() - 1, t.length() - 1);
    }

    private int minEditDistanceRecursiveHelper(String s, String t, int i, int j) {
        if (i < 0 || j < 0) {
            return 0;
        } else if (s.charAt(i) == t.charAt(j)) {
            return minEditDistanceRecursiveHelper(s, t, i - 1, j - 1);
        } else {
            return 1 + min(
                    minEditDistanceRecursiveHelper(s, t, i, j - 1),  // Insert
                    minEditDistanceRecursiveHelper(s, t, i - 1, j),  // Remove
                    minEditDistanceRecursiveHelper(s, t, i - 1, j - 1)  // Replace
            );
        }
    }

    private int min(int... nums) {
        int min = Integer.MAX_VALUE;
        for (int i : nums) {
            if (i < min) {
                min = i;
            }
        }

        return min;
    }

    public int minEditDistanceIterative(String s, String t) {
        int[][] cache = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j <= t.length(); j++) {
                if (i == 0) {
                    cache[i][j] = j;
                } else if (j == 0) {
                    cache[i][j] = i;
                } else if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    cache[i][j] = cache[i - 1][j - 1];
                } else {
                    cache[i][j] = 1 + min(cache[i - 1][j], cache[i][j - 1], cache[i - 1][j - 1]);
                }
            }
        }

        return cache[s.length()][t.length()];
    }
}
