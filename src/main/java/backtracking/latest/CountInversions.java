package backtracking.latest;

import java.util.ArrayList;
import java.util.List;

/*
https://www.geeksforgeeks.org/problems/inversion-of-array-1587115620/1
Given an array of integers arr[]. You have to find the Inversion Count of the array.
 Note : Inversion count is the number of pairs of elements (i, j) such that i < j and arr[i] > arr[j].
*/
public class CountInversions {

    public static void main(String[] args) {
        int arr[] = {2, 4, 1, 3, 5};
        System.out.println(inversionCount(arr));

    }

    public static int inversionCount(int[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    private static int mergeSort(int arr[], int low, int high) {
        int count = 0;
        if (low < high) {
            int mid = (low + high) / 2;
            count += mergeSort(arr, low, mid);
            count += mergeSort(arr, mid + 1, high);
            count += merge(arr, low, mid, high);
        }
        return count;
    }

    private static int merge(int[] arr, int low, int mid, int high) {
        List<Integer> list = new ArrayList<>();

        int count = 0;
        int left = low;
        int right = mid + 1;
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                list.add(arr[left++]);
            } else {
                count += (mid - left + 1);
                list.add(arr[right++]);
            }
        }

        while (left <= mid) {
            list.add(arr[left++]);
        }
        while (right <= high) {
            list.add(arr[right++]);
        }

        for (int i = low; i <= high; i++) {
            arr[i] = list.get(i - low);
        }

        return count;
    }
}
