package sorters;

public class MergeSortDefaultSort extends AbstarctSorter {
    private DefaultSort bs= new DefaultSort();
    //private FillArray fa = new RandomFillArray(7,100);

    private void sortMerge1(int[] arr, int l, int r) {

        if (Math.abs(l - r) < arr.length / 2) { //use bubble sort when array size<half
            arr=bs.sort(arr);
        }
        //if (l < r) {
        else {
            // Find the middle point
            int m = (l + r) / 2;

            // Sort first and second halves
            sortMerge1(arr, l, m);
            sortMerge1(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }

    }

    @Override
    public int[] sort(int[] arr) {
        //int[] arr= obj.fillArray();

        sortMerge1(arr, 0, arr.length-1);

        return arr;
    }
}
