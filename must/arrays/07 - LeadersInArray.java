/*
https://www.geeksforgeeks.org/leaders-in-an-array/

Write a program to print all the LEADERS in the array.
An element is leader if it is greater than all the elements to its right side.
And the rightmost element is always a leader.

For example in the array {16, 17, 4, 3, 5, 2}, leaders are 17, 5 and 2.
*/

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] leadersInArray(int[] input) {
        List<Integer> leaders = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int i = input.length - 1; i >= 0; i--) {
            if (input[i] >= max) {
                leaders.add(input[i]);
                max = input[i];
            }
        }

        int[] out = new int[leaders.size()];
        for (int i = 0; i < leaders.size(); i++) {
            out[leaders.size() - i - 1] = leaders.get(i);
        }

        return out;
    }
}
