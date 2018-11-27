package filters;

import java.util.Arrays;
import java.util.Random;

public class SortFillArray extends FillArray{
    public SortFillArray(int size,int bound){
        super(size,bound);
    }

    public SortFillArray(FillArray fa){
        arr=Arrays.copyOf(fa.arr, fa.arr.length);
    }

    public int[] fillArray(){
        int[] cArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(cArr);
        return cArr;
    }
}
