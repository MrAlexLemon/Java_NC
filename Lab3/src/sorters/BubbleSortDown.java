package sorters;

public class BubbleSortDown extends BubbleSorter {

    @Override
    public int[] sort(int[] arr) {
        //int[] arr=obj.fillArray();
        int temp = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j > i; j--) {
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
