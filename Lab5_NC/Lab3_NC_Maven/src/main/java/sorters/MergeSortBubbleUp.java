package sorters;

/**
 * <h1>MergeSortBubbleUp</h1>
 * <p>This class sorts array using MergeSortBubbleUp.</p>
 * <p>MergeSortBubbleUp extends AbstarctSorter.</p>
 * <p>This class has override method - public int[] sort(int[] arr)</p>
 * @author Khomenko Olexandr
 * @version 1.3
 */
public class MergeSortBubbleUp extends AbstarctSorter {

    /**
     * <p>This method sort array using MergeSortBubbleUp</p>
     * @param arr - start array
     * @return int[] - sorted array
     * {@link sorters.AbstarctSorter#sort(int[])}
     * <pre>{@code
     * public int[] sort(int[] arr) {
     *    if (arr.length == 0)
     *          throw new IllegalArgumentException();
     *
     *    int[] temp=new int[0];
     *         try {
     *              temp=tempSort(arr);
     *         }
     *         catch (Exception ex)
     *         {
     *             ex.printStackTrace();
     *         }
     *         System.arraycopy (temp, 0, arr, 0, arr.length);
     *         return arr;
     *     }
     *  }
     * </pre>
     */
    @Override
    @Description(name = "MergeSortBubbleUp",
            args = "int[] arr",
            desc = "Sort array using MergeSortBubbleUp",
            aliases = {""})
    public int[] sort(int[] arr) {

        if (arr.length == 0)
            throw new IllegalArgumentException();

        int[] temp=new int[0];
        try {
            temp=tempSort(arr);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        System.arraycopy (temp, 0, arr, 0, arr.length);
        return arr;
    }


    /**
     * <p>This method sort array using MergeSortBubbleUp</p>
     * @param arr - start array
     * @return int[] - sorted array
     */
    public int[] tempSort(int[] arr) throws InterruptedException{
        long threadCount = Math.round(-(1 - Math.pow(2, 1)));
        int[] tempArr;//=new int[0];
        if(Runtime.getRuntime().availableProcessors()>=threadCount) {
            int[] subArr1 = new int[arr.length / 2];
            int[] subArr2 = new int[arr.length - arr.length / 2];
            System.arraycopy(arr, 0, subArr1, 0, arr.length / 2);
            System.arraycopy(arr, arr.length / 2, subArr2, 0, arr.length - arr.length / 2);

            MergeSort runner1 = new MergeSort(subArr1);
            MergeSort runner2 = new MergeSort(subArr2);
            runner1.start();
            runner2.start();
            runner1.join();
            runner2.join();

            tempArr=finalMerge(runner1.getInternal(), runner2.getInternal());
        }
        else{
            BubbleSortUp bsd = new BubbleSortUp();
            bsd.sort(arr);
            tempArr=arr;
        }
        return  tempArr;
    }
}
