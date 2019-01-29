/*
https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/

Given an array A[] consisting 0s, 1s and 2s, write a function that sorts A[]. 
The functions should put all 0s first, then all 1s and all 2s in last.

Examples:

Input :  {0, 1, 2, 0, 1, 2}
Output : {0, 0, 1, 1, 2, 2}

Input :  {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1}
Output : {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2}
*/

class Solution {
    public void sort012s(int[] a) {
        int low = 0;
        int cur = 0;
        int high = a.length - 1;

        while (cur <= high) {
            if (a[cur] == 0) {
                swap(a, low, cur);
                low++;
                cur++;
            } else if (a[cur] == 2) {
                swap(a, cur, high);
                high--;
            } else {
                cur++;
            }
        }
    }

    private void swap(int[] a, int i, int j) {
        if (i != j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }
}
