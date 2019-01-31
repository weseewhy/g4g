/*
https://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array/
https://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array-set-2-expected-linear-time/
https://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array-set-3-worst-case-linear-time/

Given an array and a number k where k is smaller than size of array,
we need to find the k’th smallest element in the given array. It is given that ll array elements are distinct.

Examples:
Input: arr[] = {7, 10, 4, 3, 20, 15}, k = 3
Output: 7

Input: arr[] = {7, 10, 4, 3, 20, 15}, k = 4
Output: 10
*/

import java.util.PriorityQueue;

class Solution {

    // O(Nlog(k)) time, O(k) space
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k);
        for (int i = 0; i < k; i++) {
            maxHeap.offer(nums[k]);
        }

        for (int i = k; i < nums.length; i++) {
            if (nums[i] < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.offer(nums[i]);
            }
        }

        return maxHeap.peek();
    }

    // O(N) average and O(N^2) worst case time complexity, O(1) space complexity
    private int findKthSmallest(int[] arr, int k) {
        int indexOfKthSmallest = findKthSmallest(arr, 0, arr.length - 1, k);
        return arr[indexOfKthSmallest];
    }

    private int findKthSmallest(int[] arr, int start, int end, int k) {
        int pivotIndex = select(arr, start, end);
        if (pivotIndex == k - 1) {
            return pivotIndex;
        } else if (pivotIndex < k - 1) {
            return findKthSmallest(arr, pivotIndex + 1, end, k);
        } else {
            return findKthSmallest(arr, start, pivotIndex - 1, k);
        }
    }

    private int select(int[] arr, int start, int end) {
        int lastSmallerAt = start - 1;
        for (int cur = start; cur < end; cur++) {
            if (arr[cur] <= arr[end]) {
                lastSmallerAt++;
                swap(arr, cur, lastSmallerAt);
            }
        }

        lastSmallerAt++;
        swap(arr, end, lastSmallerAt);
        return lastSmallerAt;
    }

    private void swap(int[] arr, int i, int j) {
        if (i != j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
