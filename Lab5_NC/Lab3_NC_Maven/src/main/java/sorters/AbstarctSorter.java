package sorters;

/**
 * <h1>AbstarctSorter</h1>
 * <p>This class is abstract.It is used for declaring public abtract method -sort.</p>
 * <p>This method will be Overrided in descendant classes</p>
 * @author Khomenko Olexandr
 * @version 1.3
 */
public abstract class AbstarctSorter{

    /**
     * <p>This method sort array using different sorters</p>
     * @param arr - array
     * @return int[] - return sorted array.
     * @see AbstarctSorter#sort(int[])
     */
    public abstract int[] sort(int[] arr);

    /**
     * <p>Divide an array into smaller pieces.</p>
     * @param arr - start array
     * @param low - Starting index
     * @param high - Ending index
     * @return int
     * @see AbstarctSorter#partition(int[],int,int)
     * <pre>
     * {@code
     * protected int partition(int[] arr, int low, int high) {
     *         int pivot = arr[high];
     *         int i = (low - 1); // index of smaller element
     *         for (int j = low; j < high; j++) {
     *             // If current element is smaller than or
     *             // equal to pivot
     *             if (arr[j] <= pivot) {
     *                 i++;
     *
     *                 // swap arr[i] and arr[j]
     *                 int temp = arr[i];
     *                 arr[i] = arr[j];
     *                 arr[j] = temp;
     *             }
     *         }
     *
     *         // swap arr[i+1] and arr[high] (or pivot)
     *         int temp = arr[i + 1];
     *         arr[i + 1] = arr[high];
     *         arr[high] = temp;
     *
     *         return i + 1;
     *     }
     * }
     * </pre>
     */
    @Description(name = "partition",
            args = "int[] arr, int low, int high",
            desc = "Divide an array into smaller pieces. arr-start array,S low  --> Starting index,  high  --> Ending index",
            aliases = {""})
    protected int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }


    /**
     * <p>Merge 2 sorted arrays.</p>
     * @param a - array sorted in 1 thread
     * @param b - array sorted in 2 thread
     * @return int[] result - sorted array
     * @see AbstarctSorter#finalMerge(int[] a, int[] b)
     */
    public int[] finalMerge(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int i=0;
        int j=0;
        int r=0;
        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                result[r]=a[i];
                i++;
                r++;
            } else {
                result[r]=b[j];
                j++;
                r++;
            }
            if (i==a.length) {
                while (j<b.length) {
                    result[r]=b[j];
                    r++;
                    j++;
                }
            }
            if (j==b.length) {
                while (i<a.length) {
                    result[r]=a[i];
                    r++;
                    i++;
                }
            }
        }


        return result;
    }


}
