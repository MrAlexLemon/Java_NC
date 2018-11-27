package filters;

import java.util.Arrays;
import java.util.Random;

public class SortBackFillArray extends FillArray {
    public SortBackFillArray(int size, int bound) {
        super(size, bound);
    }

    public SortBackFillArray(FillArray fa) {
        arr=Arrays.copyOf(fa.arr, fa.arr.length);
    }

    public int[] fillArray() {
        int[] cArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(cArr);

        for (int i = 0; i < cArr.length / 2; i++) {
            int temp = cArr[i];
            cArr[i] = cArr[cArr.length - i - 1];
            cArr[cArr.length - i - 1] = temp;
        }
        return cArr;
    }
}
