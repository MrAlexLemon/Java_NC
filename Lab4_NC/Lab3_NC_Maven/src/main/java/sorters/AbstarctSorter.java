package sorters;

/**
 * <h1>AbstarctSorter</h1>
 * <p>This class is abstract.It is used for declaring public abtract method -sort.</p>
 * <p>This method will be Overrided in descendant classes</p>
 * @author Khomenko Olexandr
 * @version 1.3
 */
public abstract class AbstarctSorter {

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
     * <p>Merge small arrays into big.</p>
     * @param arr - start array
     * @param l - left border
     * @param m - middle
     * @param r - right border
     * @see AbstarctSorter#merge(int[],int,int,int)
     */
    @Description(name = "merge",
            args = "int[] arr, int l, int m, int r. l-left border, m -middle, r-right border",
            desc = "Merge small arrays into big",
            aliases = {""})
    protected void merge(int[] arr, int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

}
