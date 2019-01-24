package sorters;

/**
 * <h1>QuickSort</h1>
 * <p>This class sorts array using QuickSort.</p>
 * <p>QuickSort extends AbstarctSorter.</p>
 * <p>This class has override method - public int[] sort(int[] arr)</p>
 *
 * @author Khomenko Olexandr
 * @version 1.3
 */
public class QuickSort extends AbstarctSorter {

    /**
     * <p>Use Quick sort</p>
     *
     * @param arr  - start array
     * @param low  - low border
     * @param high - high border
     *             <pre>{@code
     *              private void quicksort(int[] arr, int low, int high) {
     *
     *                     if (low < high) {
     *                         int pi = partition(arr, low, high);
     *                         quicksort(arr, low, pi - 1);
     *                         quicksort(arr, pi + 1, high);
     *                     }
     *
     *                 }
     *             }
     *             </pre>
     */
    private void quicksort(int[] arr, int low, int high) {

        if (low < high) {
            int pi = partition(arr, low, high);
            quicksort(arr, low, pi - 1);
            quicksort(arr, pi + 1, high);
        }

    }

    /**
     * <p>This method sort array using Quicksort</p>
     *
     * @param arr - start array
     * @return int[] - sorted array
     * {@link sorters.AbstarctSorter#sort(int[])}
     * <pre>{@code
     * public int[] sort(int[] arr){
     *         //int[] arr= obj.fillArray();
     *
     *         quicksort(arr, 0, arr.length-1);
     *
     *         return arr;
     *     }
     * }
     * </pre>
     */
    @Override
    @Description(name = "QuickSort",
            args = "int[] arr",
            desc = "Sort array using QuickSort",
            aliases = {""})
    public int[] sort(int[] arr) {
        //int[] arr= obj.fillArray();
        if (arr.length == 0)
            throw new IllegalArgumentException();
        quicksort(arr, 0, arr.length - 1);

        return arr;
    }
}
