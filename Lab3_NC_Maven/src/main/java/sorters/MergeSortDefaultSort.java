package sorters;

/**
 * <h1>MergeSortDefaultSort</h1>
 * <p>This class sorts array using MergeSortDefaultSort.</p>
 * <p>MergeSortDefaultSort extends AbstarctSorter.</p>
 * <p>This class has override method - public int[] sort(int[] arr)</p>
 * @author Khomenko Olexandr
 * @version 1.3
 */
public class MergeSortDefaultSort extends AbstarctSorter {
    private DefaultSort bs= new DefaultSort();
    //private FillArray fa = new RandomFillArray(7,100);

    /**
     * <p>Use hybrid. Merge sort + DefaultSort</p>
     * @param arr - start array
     * @param l - left border
     * @param r - right border
     * <pre>{@code
     *          private void sortMerge1(int[] arr, int l, int r) {
     *
     *         if (Math.abs(l - r) < arr.length / 2) { //use bubble sort when array size<half
     *             arr=bs.sort(arr);
     *         }
     *         //if (l < r) {
     *         else {
     *             // Find the middle point
     *             int m = (l + r) / 2;
     *
     *             // Sort first and second halves
     *             sortMerge1(arr, l, m);
     *             sortMerge1(arr, m + 1, r);
     *
     *             // Merge the sorted halves
     *             merge(arr, l, m, r);
     *         }
     *
     *     }
     * }
     * </pre>
     */
    private void sortMerge1(int[] arr, int l, int r) {

        if (Math.abs(l - r) <= arr.length / 2) { //use bubble sort when array size<half
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

    /**
     * <p>This method sort array using MergeSortDefaultSort</p>
     * @param arr - start array
     * @return int[] - sorted array
     * {@link sorters.AbstarctSorter#sort(int[])}
     * <pre>{@code
     * public int[] sort(int[] arr) {
     *         //int[] arr= obj.fillArray();
     *
     *         sortMerge1(arr, 0, arr.length-1);
     *
     *         return arr;
     *     }
     * }
     * </pre>
     */
    @Override
    public int[] sort(int[] arr) {
        //int[] arr= obj.fillArray();

        if (arr.length == 0)
            throw new IllegalArgumentException();

        sortMerge1(arr, 0, arr.length-1);

        return arr;
    }
}
