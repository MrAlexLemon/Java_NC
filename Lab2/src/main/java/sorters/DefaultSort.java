package sorters;

import filters.FillArray;

import java.util.Arrays;

public class DefaultSort extends  SortArray {
    public int[] sortArray(int[] arr){
        //int[] arr = obj.fillArray();
        Arrays.sort(arr);
        return arr;
    }
}
