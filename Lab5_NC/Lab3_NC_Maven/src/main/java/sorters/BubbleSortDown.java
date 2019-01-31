package sorters;


/**
 * <h1>BubbleSortDown</h1>
 * <p>The class sorts array using BubbleSortDown.</p>
 * <p>BubbleSortDown extends BubbleSorter.</p>
 * <p>This class has override method - public int[] sort(int[] arr)</p>
 * @author Khomenko Olexandr
 * @version 1.3
 */
public class BubbleSortDown extends BubbleSorter {

    /**
     * <p>This method sort array using BubbleSortDown</p>
     * @param arr - start array
     * @return int[] - sorted array
     * {@link sorters.AbstarctSorter#sort(int[])}
     * <pre>
     * {@code
     * public int[] sort(int[] arr) {
     *         //int[] arr=obj.fillArray();
     *         int temp = 0;
     *
     *         for (int i = 0; i < arr.length; i++) {
     *             for (int j = arr.length - 1; j > i; j--) {
     *                 if (arr[j] < arr[j - 1]) {
     *                     temp = arr[j];
     *                     arr[j] = arr[j - 1];
     *                     arr[j - 1] = temp;
     *                 }
     *             }
     *         }
     *         return arr;
     *     }
     * }
     * </pre>
     */
    @Override
    @Description(name = "BubbleSortDown",
            args = "int[] arr",
            desc = "Sort array using BubbleSortDown",
            aliases = {""})
    public int[] sort(int[] arr) {
        //int[] arr=obj.fillArray();
        if (arr.length == 0)
            throw new IllegalArgumentException();

        int temp = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
        return arr;
    }

}
