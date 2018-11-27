package filters;

import java.util.Arrays;
import java.util.Random;

public class RandomFillArray extends FillArray {

    //public RandomFillArray() {}
    public RandomFillArray(int size, int bound) {
        super(size,bound);
    }

    public RandomFillArray(FillArray fa) {
        arr=Arrays.copyOf(fa.arr, fa.arr.length);
    }

    public int[] fillArray() {
        int[] cArr = Arrays.copyOf(arr, arr.length);
        return cArr;
    }
}
