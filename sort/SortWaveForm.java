/*
https://www.geeksforgeeks.org/sort-array-wave-form-2/

Given an unsorted array of integers, sort the array into a wave like array.
An array ‘arr[0..n-1]’ is sorted in wave form if arr[0] >= arr[1] <= arr[2] >= arr[3] <= arr[4] >= …..
*/

public class SortWaveForm {

    public void sort(int[] input) {
        for (int i = 0; i < input.length; i = i + 2) {
            if (i > 0 && input[i - 1] > input[i]) {
                swap(input, i - 1, i);
            }

            if (i < input.length - 1 && input[i + 1] > input[i]) {
                swap(input, i, i + 1);
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
