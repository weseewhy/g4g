/*
https://www.geeksforgeeks.org/kth-largest-element-in-a-stream/

Given an infinite stream of integers, find the k’th largest element at any point of time.

Example:
Input:
stream[] = {10, 20, 11, 70, 50, 40, 100, 5, ...}
k = 3
Output:    {_,   _, 10, 11, 20, 40, 50,  50, ...}

Extra space allowed is O(k).
*/

import java.util.PriorityQueue;

class GFG {
    public static int[] kthLargestElement(int[] arr, int k) {
        int[] out = new int[arr.length];
        KthLargestFinder finder = new KthLargestFinder(k);
        for (int i = 0; i < arr.length; i++) {
            finder.add(arr[i]);
            out[i] = finder.getKthLargestFinder();
        }

        return out;
    }

    private static void print(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i != arr.length - 1) {
                sb.append(" ");
            }
        }

        System.out.println(sb.toString());
    }

    static class KthLargestFinder {
        private int k;
        private PriorityQueue<Integer> minHeap;

        public KthLargestFinder(int k) {
            this.k = k;
            this.minHeap = new PriorityQueue<>();
        }

        private void add(int i) {
            if (minHeap.size() < k) {
                minHeap.add(i);
            } else if (i > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(i);
            }
        }

        private int getKthLargestFinder() {
            if (minHeap.size() < k) {
                return -1;
            }

            return minHeap.peek();
        }
    }
}
