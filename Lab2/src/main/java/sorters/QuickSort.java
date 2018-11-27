package sorters;

import filters.FillArray;

public class QuickSort extends SortArray {

    private void quicksort(int[] arr, int low, int high) {

        if (low < high) {
            int pi = partition(arr, low, high);
            quicksort(arr, low, pi - 1);
            quicksort(arr, pi + 1, high);
        }

    }

    public int[] sortArray(int[] arr){
        //int[] arr= obj.fillArray();

        quicksort(arr, 0, arr.length-1);

        return arr;
    }
}
