package sorters;
import  java.util.Arrays;

public class DefaultSort extends AbstarctSorter {
    @Override
    public int[] sort(int[] arr){
        //int[] arr = obj.fillArray();
        Arrays.sort(arr);
        return arr;
    }
}
