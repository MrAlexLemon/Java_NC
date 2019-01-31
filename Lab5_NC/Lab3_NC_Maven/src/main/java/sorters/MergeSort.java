package sorters;

/**
 * <h1>MergeSort</h1>
 * <p>This class uses for define and realized common methods for hybrid merge classes.</p>
 * @author Khomenko Olexandr
 * @version 1.3
 */
public class MergeSort extends Thread{

    private int[] internal;

    /**
     * <p>This method grants access to private field internal.</p>
     * @return int[] - return input array.
     * @see MergeSort#getInternal()
     */
    public int[] getInternal() {
        return internal;
    }


    /**
     * <p>This method merges left and right parts of array.</p>
     * <p>Then it merge both parts of array.</p>
     * @param array - input array
     * @see MergeSort#mergeSort(int[] array)
     */
    public void mergeSort(int[] array) {
        if (array.length > 1) {
            int[] left = leftHalf(array);
            int[] right = rightHalf(array);

            mergeSort(left);
            mergeSort(right);

            merge(array, left, right);
        }
    }

    /**
     * <p>This method copies left-half of array.</p>
     * @param array - input array
     * @return int[] left - return left-half of array.
     * @see MergeSort#leftHalf(int[] array)
     */
    public int[] leftHalf(int[] array) {
        int size1 = array.length / 2;
        int[] left = new int[size1];
        for (int i = 0; i < size1; i++) {
            left[i] = array[i];
        }
        return left;
    }

    /**
     * <p>This method copies right-half of array.</p>
     * @param array - input array
     * @return int[] right - return right-half of array.
     * @see MergeSort#rightHalf(int[] array)
     */
    public int[] rightHalf(int[] array) {
        int size1 = array.length / 2;
        int size2 = array.length - size1;
        int[] right = new int[size2];
        for (int i = 0; i < size2; i++) {
            right[i] = array[i + size1];
        }
        return right;
    }

    /**
     * <p>This method merges left and right parts of array.</p>
     * <p>Then it merges both parts of array into result array.</p>
     * @param result - sorted array
     * @param left - left part of array
     * @param right - right part of array
     * @see MergeSort#merge(int[] result, int[] left, int[] right)
     */
    public void merge(int[] result, int[] left, int[] right) {
        int i1 = 0;
        int i2 = 0;

        for (int i = 0; i < result.length; i++) {
            if (i2 >= right.length || (i1 < left.length && left[i1] <= right[i2])) {
                result[i] = left[i1];
                i1++;
            } else {
                result[i] = right[i2];
                i2++;
            }
        }
    }

    /**
     * <p>Constructor, which initializes.</p>
     * @param arr - input array
     * @see MergeSort#MergeSort(int[] arr)
     */
    public MergeSort(int[] arr) {
        internal = arr;
    }


    /**
     * <p>Run mergeSort. Entry point for the thread.</p>
     * @see MergeSort#run()
     */
    public void run() {
        mergeSort(internal);
    }
}
