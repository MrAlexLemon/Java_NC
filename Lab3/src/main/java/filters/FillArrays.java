package filters;

import java.util.Arrays;
import java.util.Random;

/**
 * <h1>FillArrays</h1>
 *<p>The class serves to fill the array with the corresponding values.</p>
 * <p>This class has 4 methods which are annotated by "DescFill"</p>
 * @author Khomenko Olexandr
 * @version 1.3
 */
public class FillArrays {

    private static int[] arr;

    /**
     * <p>This method fills array with random numbers</p>
     * @param size - arrays size
     * @param bound - numbers bound
     * @return int[] carr, Array which is filled by random numbers
     * @see FillArrays#fillRandom(int, int)
     * <pre>
     * {@code
     *      public static int[] fillRandom(int size, int bound) {
     *         Random random = new Random();
     *         arr = new int[size];
     *
     *         for (int i = 0; i < arr.length; i++) {
     *             arr[i] = random.nextInt(bound);//(int)Math.random();
     *         }
     *         //System.out.println("LOl");
     *         int[] carr = Arrays.copyOf(arr, arr.length);
     *         return carr;
     *     }
     * }
     * </pre>
     */
    @DescFill(name = "fillRandom",
            args = "int size, int bound",
            desc = "fill array by random numbers",
            aliases = {""})
    public static int[] fillRandom(int size, int bound) {

        if (size <= 0 || bound<=1)
            throw new IllegalArgumentException();

        Random random = new Random();
        arr = new int[size];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(bound);//(int)Math.random();
        }
        //System.out.println("LOl");
        int[] carr = Arrays.copyOf(arr, arr.length);
        return carr;
    }

    /**
     * <p>This method fills array with sorted numbers</p>
     * @param size - arrays size
     * @param bound - numbers bound
     * @return int[] carr, Array which is filled by sorted numbers
     * @see FillArrays#fillSort(int, int)
     * <pre>
     * {@code
     *      public static int[] fillSort(int size, int bound) {
     *         int[] carr;
     *         if (arr == null)
     *             fillRandom(size, bound);
     *         carr = Arrays.copyOf(arr, arr.length);
     *         Arrays.sort(carr);
     *         return carr;
     *     }
     * }
     * </pre>
     */
    @DescFill(name = "fillSort",
            args = "int[] arr",
            desc = "fill array by sorted numbers",
            aliases = {""})
    public static int[] fillSort(int size, int bound) {
        int[] carr;

        if (size <= 0 || bound<=1)
            throw new IllegalArgumentException();

        if (arr == null)
            fillRandom(size, bound);
        carr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(carr);
        return carr;
    }

    /**
     * <p>This method fills array with sorted_back numbers</p>
     * @param size - arrays size
     * @param bound - numbers bound
     * @return int[] carr, Array which is filled by sorted_back numbers
     * @see FillArrays#fillSortBack(int, int)
     * <pre>
     * {@code
     * public static int[] fillSortBack(int size, int bound) {
     *         //int[]arr1=Arrays.copyOf(arr,arr.length);
     *         int[] carr;
     *         if (arr == null)
     *             fillRandom(size, bound);
     *         carr = fillSort(size,bound);
     *         for (int i = 0; i < carr.length / 2; i++) {
     *             int temp = carr[i];
     *             carr[i] = carr[carr.length - i - 1];
     *             carr[carr.length - i - 1] = temp;
     *         }
     *         return carr;
     *     }
     * }
     * </pre>
     */
    @DescFill(name = "fillSortBack",
            args = "int[] arr",
            desc = "fill array by sorted numbers in back way",
            aliases = {""})
    public static int[] fillSortBack(int size, int bound) {
        //int[]arr1=Arrays.copyOf(arr,arr.length);
        int[] carr;

        if (size <= 0 || bound<=1)
            throw new IllegalArgumentException();

        if (arr == null)
            fillRandom(size, bound);
        carr = fillSort(size,bound);
        for (int i = 0; i < carr.length / 2; i++) {
            int temp = carr[i];
            carr[i] = carr[carr.length - i - 1];
            carr[carr.length - i - 1] = temp;
        }
        return carr;
    }

    /**
     * <p>This method fills array with sorted numbers + one num int the end</p>
     * @param size - arrays size
     * @param bound - numbers bound
     * @return int[] carr, Array which is filled by sorted numbers + one added num in the end
     * @see FillArrays#fillSortAdd(int, int)
     * <pre>
     *{@code
     * public static int[] fillSortAdd(int size, int bound) {
     *         int[] carr;
     *         if (arr == null)
     *             fillRandom(size, bound);
     *         carr = fillSort(size,bound);
     *         int[] ccarr = Arrays.copyOf(carr, arr.length + 1);
     *         Random random = new Random();
     *         ccarr[carr.length] = random.nextInt(11);
     *         return ccarr;
     *     }
     * }
     * </pre>
     */
    @DescFill(name = "fillSortAdd",
            args = "int[] arr",
            desc = "fill array by sorted numbers and add random number in the end   ",
            aliases = {""})
    public static int[] fillSortAdd(int size, int bound) {
        int[] carr;

        if (size <= 0 || bound<=1)
            throw new IllegalArgumentException();

        if (arr == null)
            fillRandom(size, bound);
        carr = fillSort(size,bound);
        int[] ccarr = Arrays.copyOf(carr, arr.length + 1);
        Random random = new Random();
        ccarr[carr.length] = random.nextInt(11);
        return ccarr;
    }
}

