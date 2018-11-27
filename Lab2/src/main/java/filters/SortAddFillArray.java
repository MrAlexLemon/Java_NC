package filters;

import java.util.Arrays;
import java.util.Random;

public class SortAddFillArray extends FillArray{

    public SortAddFillArray(int size,int bound){
        super(size,bound);
    }

    public SortAddFillArray(FillArray fa){
        arr=Arrays.copyOf(fa.arr, fa.arr.length);
    }

    public int[] fillArray(){
        int[] cArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(cArr);

        Random random = new Random();
        int[] arr1 = Arrays.copyOf(cArr, cArr.length + 1);
        arr1[cArr.length] = random.nextInt(100);

        return arr1;
    }
}
