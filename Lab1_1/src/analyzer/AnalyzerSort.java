package analyzer;

import filters.FillArray;
import filters.RandomFillArray;
import sorters.SortArray;

public class AnalyzerSort {

    public long analyzeSort(FillArray fa, SortArray sa) {
        //fa.generateArray(10000,100);
        int[] arr=fa.fillArray();
        //fa.showArray(fa.fillArray());
        long begin = System.currentTimeMillis();

        sa.sortArray(arr);

        long end = System.currentTimeMillis();
        long result = end - begin;
        //fa.showArray(sa.sortArray(fa));
        return result;
    }

}
