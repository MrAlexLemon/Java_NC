package sorters;

/**
 * <h1>BubbleSortUp</h1>
 * <p>This class sorts array using BubbleSortUp.</p>
 * <p>BubbleSortUp extends BubbleSorter.</p>
 * <p>This class has override method - public int[] sort(int[] arr)</p>
 * @author Khomenko Olexandr
 * @version 1.3
 */
public class BubbleSortUp extends BubbleSorter {

    /**
     * <p>This method sort array using BubbleSortUp</p>
     * @param arr - start array
     * @return int[] - sorted array
     * {@link sorters.AbstarctSorter#sort(int[])}
     * <pre>{@code
     * public int[] sort(int[] arr){
     *         //int[] arr=obj.fillArray();
     *         int temp = 0;
     *
     *         for (int i = 0; i < arr.length; i++) {
     *             for (int j = 1; j < arr.length - i; j++) {
     *                 if (arr[j] < arr[j - 1]) {
     *                     temp = arr[j];
     *                     arr[j] = arr[j - 1];
     *                     arr[j - 1] = temp;
     *                 }
     *             }
     *         }
     *         return arr;
     *
     *     }
     * }</pre>
     */
    @Override
    @Description(name = "BubbleSortUp",
            args = "int[] arr",
            desc = "Sort array using BubbleSortUp",
            aliases = {""})
    public int[] sort(int[] arr){
        //int[] arr=obj.fillArray();
        if (arr.length == 0)
            throw new IllegalArgumentException();

        int temp = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
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
