package filters;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
public class FillArrays {

    //private static int[] arr;
    private static int size;
    private static int bound;
    private static int[] arr;

    private static boolean check(int[] arr){
        if(arr.length!=0)
            return true;
        else {
            arr=fillRandom(size, bound);
            return false;
        }
    }

    public static int[] fillRandom(int size, int bound) {
        Random random = new Random();
        int[] arr = new int[size];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(bound);//(int)Math.random();
        }
        FillArrays.size=size;
        FillArrays.bound=bound;
        return arr;
    }

    public static int[] fillSortRandom(int[] arr) {
        check(arr);
        Arrays.sort(arr);
        return arr;
    }
}
*/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DescFill
{
    String name(); //The command for which the function will answer

    String args(); //Function arguments

    int minArgs() default 0; //Minimum number of arguments

    String desc(); //Description

    int maxArgs() default Integer.MAX_VALUE; //The maximum number of arguments

    boolean showInHelp() default true; //Show the command in the list

    String[] aliases(); //Which command will be considered equivalent to ours

}
