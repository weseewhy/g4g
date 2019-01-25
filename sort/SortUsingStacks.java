/*
https://www.geeksforgeeks.org/sort-stack-using-temporary-stack/

Given a stack of integers, sort it in ascending order using another temporary stack.

Examples:
Input : [34, 3, 31, 98, 92, 23]
Output : [3, 23, 31, 34, 92, 98]

Input : [3, 5, 1, 4, 2, 8]
Output : [1, 2, 3, 4, 5, 8]
*/

import java.util.Stack;

public class Solution {

    public Stack<Integer> sort(Stack<Integer> input) {
        if (input == null || input.size() <= 1) {
            return input;
        }

        Stack<Integer> temp = new Stack<>();
        while (!input.isEmpty()) {
            Integer cur = input.pop();
            while (!temp.isEmpty() && temp.peek() < cur) {
                input.push(temp.pop());
            }

            temp.push(cur);
        }

        return temp;
    }
}
