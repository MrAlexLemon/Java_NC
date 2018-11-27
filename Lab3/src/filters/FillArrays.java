package filters;

import com.sun.deploy.util.ArrayUtil;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.Random;

public class FillArrays {

    @DescFill(name = "fillRandom",
            args = "int size, int bound",
            desc = "fill array by random numbers",
            aliases = {""})
    public static int[] fillRandom(int size, int bound) {
        Random random = new Random();
        int[] arr = new int[size];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(bound);//(int)Math.random();
        }
        return arr;
    }

    @DescFill(name = "fillSort",
            args = "int[] arr",
            desc = "fill array by sorted numbers",
            aliases = {""})
    public static int[] fillSort(int[] arr){
        int[] carr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(carr);
        return carr;
    }

    @DescFill(name = "fillSortBack",
            args = "int[] arr",
            desc = "fill array by sorted numbers in back way",
            aliases = {""})
    public static int[] fillSortBack(int[] arr) {
        //int[]arr1=Arrays.copyOf(arr,arr.length);
        int[] carr = fillSort(arr);
        for (int i = 0; i < carr.length / 2; i++) {
            int temp = carr[i];
            carr[i] = carr[carr.length - i - 1];
            carr[carr.length - i - 1] = temp;
        }
        return carr;
    }

    @DescFill(name = "fillSortAdd",
            args = "int[] arr",
            desc = "fill array by sorted numbers and add random number in the end   ",
            aliases = {""})
    public static int[] fillSortAdd(int[] arr) {
        int[] carr = fillSort(arr);
        int[] ccarr = Arrays.copyOf(carr, arr.length + 1);
        Random random = new Random();
        ccarr[carr.length] = random.nextInt(11);
        return ccarr;
    }
}

