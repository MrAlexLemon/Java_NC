package sorters;

public class QuickSort extends AbstarctSorter {

    private void quicksort(int[] arr, int low, int high) {

        if (low < high) {
            int pi = partition(arr, low, high);
            quicksort(arr, low, pi - 1);
            quicksort(arr, pi + 1, high);
        }

    }

    @Override
    public int[] sort(int[] arr){
        //int[] arr= obj.fillArray();

        quicksort(arr, 0, arr.length-1);

        return arr;
    }
}
