/*
Given a word and a text, return the count of the occurrences of anagrams of the word in the text.

Example:
Input: forxxorfxdofr, for
Output: 3

Input: aabaabaa, aaba
Output: 4
*/

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int countAnagrams(String s, String sub) {
        if (s.length() < sub.length()) {
            return 0;
        }

        Map<Character, Integer> defaultCnt = new HashMap<>();
        for (int i = 0; i < sub.length(); i++) {
            defaultCnt.put(sub.charAt(i), defaultCnt.getOrDefault(sub.charAt(i), 0) + 1);
        }

        int res = 0;
        Map<Character, Integer> cnt = new HashMap<>();
        int start = 0;
        int end = sub.length() - 1;

        for (int i = start; i <= end; i++) {
            cnt.put(s.charAt(i), cnt.getOrDefault(s.charAt(i), 0) + 1);
        }

        if (countsSame(cnt, defaultCnt)) {
            res++;
        }
        start++;
        end++;

        while (end < s.length()) {
            cnt.put(s.charAt(start - 1), cnt.get(s.charAt(start - 1)) - 1);
            cnt.put(s.charAt(end), cnt.getOrDefault(s.charAt(end), 0) + 1);

            if (countsSame(cnt, defaultCnt)) {
                res++;
            }

            start++;
            end++;
        }

        return res;
    }

    private boolean countsSame(Map<Character, Integer> cnt, Map<Character, Integer> defaultCnt) {
        for (char c : defaultCnt.keySet()) {
            if (!cnt.containsKey(c) || cnt.get(c).compareTo(defaultCnt.get(c)) != 0) {
                return false;
            }
        }

        return true;
    }
}
