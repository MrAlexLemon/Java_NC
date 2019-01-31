package sorters;
import  java.util.Arrays;

/**
 * <h1>DefaultSort</h1>
 * <p>This class sorts array using DefaultSort.</p>
 * <p>DefaultSort extends AbstarctSorter.</p>
 * <p>This class has override method - public int[] sort(int[] arr)</p>
 * @author Khomenko Olexandr
 * @version 1.3
 */
public class DefaultSort extends AbstarctSorter {
    /**
     * <p>This method sort array using DefaultSort</p>
     * @param arr - start array
     * @return int[] - sorted array
     * {@link sorters.AbstarctSorter#sort(int[])}
     * <pre>{@code
     * public int[] sort(int[] arr){
     *         //int[] arr = obj.fillArray();
     *         Arrays.sort(arr);
     *         return arr;
     *     }
     * }
     * </pre>
     */
    @Override
    @Description(name = "DefaultSort",
            args = "int[] arr",
            desc = "Sort array using DefaultSort",
            aliases = {""})
    public int[] sort(int[] arr){
        //int[] arr = obj.fillArray();
        if (arr.length == 0)
            throw new IllegalArgumentException();
        Arrays.sort(arr);
        return arr;
    }
}
