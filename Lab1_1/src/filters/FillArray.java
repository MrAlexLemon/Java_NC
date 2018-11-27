package filters;


import java.util.Random;

public abstract class FillArray {
    protected int[] arr;

    public FillArray() {
    }

    public FillArray(int size, int bound) {
        Random random = new Random();
        arr = new int[size];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(bound);//(int)Math.random();
        }

    }

    /*public void generateArray(int size,int bound){
        Random random = new Random();
        arr = new int[size];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(bound);//(int)Math.random();
        }
    }*/

    abstract public int[] fillArray();

    public void showArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
