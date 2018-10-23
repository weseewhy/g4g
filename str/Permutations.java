/*
https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/

Given a string, return all permutations of that string
*/

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> permute(String s) {
        List<String> permutations = new ArrayList<>();
        permute(s.toCharArray(), 0, permutations);
        return permutations;
    }

    private void permute(char[] c, int index, List<String> out) {
        if (index == c.length - 1) {
            out.add(new String(c));
            return;
        }

        for (int i = index; i < c.length; i++) {
            swap(c, i, index);
            permute(c, index + 1, out);
            swap(c, i, index);
        }
    }

    private void swap(char[] c, int i, int j) {
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }
}
