/*
https://www.geeksforgeeks.org/sort-array-according-order-defined-another-array/

Given two arrays A1[] and A2[], sort A1 in such a way that the relative order among the elements
will be same as those are in A2. For the elements not present in A2, append them at last in sorted order.

Example:
Input: A1[] = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8}
       A2[] = {2, 1, 8, 3}
Output: A1[] = {2, 2, 1, 1, 8, 8, 3, 5, 6, 7, 9}

The code should handle all cases like number of elements in A2[] may be more or less compared to A1[].
A2[] may have some elements which may not be there in A1[] and vice versa is also possible.
*/

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public void relativeSort(Integer[] a, Integer[] b) {
        RelativeSortComparator comparator = new RelativeSortComparator(b);
        Arrays.sort(a, comparator);
    }
}

class RelativeSortComparator implements Comparator<Integer> {
    private final Map<Integer, Integer> map;

    RelativeSortComparator(Integer[] arr) {
        this.map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
    }

    @Override
    public int compare(Integer i, Integer j) {
        if (map.containsKey(i) && map.containsKey(j)) {
            return map.get(i) - map.get(j);
        } else if (map.containsKey(i)) {
            return -1;
        } else if (map.containsKey(j)) {
            return 1;
        } else {
            return i - j;
        }
    }
}
