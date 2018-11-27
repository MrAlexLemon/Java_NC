package sorters;

public class BubbleSortUp extends BubbleSorter {

    @Override
    public int[] sort(int[] arr){
        //int[] arr=obj.fillArray();
        int temp = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j] < arr[j - 1]) {
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
        return arr;

    }
}
