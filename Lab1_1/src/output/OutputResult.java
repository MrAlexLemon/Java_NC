package output;

import analyzer.AnalyzerSort;
import filters.*;
import sorters.*;

public class OutputResult {

    private AnalyzerSort ansor;

    private FillArray[] fa;// = {new RandomFillArray(size, 100),
    //new SortAddFillArray(size, 100), new SortBackFillArray(size, 100), new SortFillArray(size, 100)};
    private SortArray[] as;// = {new BubbleSortUp(),
    //new BubbleSortDown(), new DefaultSort(), new QuickSort()};
    private String[] str = {"Random data", "Sort + add element data", "Sort back data", "Sort data"};


    public OutputResult(FillArray[] fa, SortArray[] sa) {
        ansor = new AnalyzerSort();

        this.fa = fa;
        this.as = sa;
    }

    public void showResult() {

        System.out.println("1) BubbleSortUp\n" + "2) BubbleSortDown\n" + "3) QuickSort\n" + "4) DefaultSort\n"
                + "5) MergeSortBubbleUp\n" + "6) MergeSortBubbleDown\n"
                + "7) MergeSortQuickSort\n" + "8) MergeSortDefaultSort\n");

        for (int i = 0; i < fa.length; i++) {
            System.out.print(str[i] + ": ");
            for (int j = 0; j < as.length; j++) {
                System.out.print(ansor.analyzeSort(fa[i], as[j]) + " ");
            }
            System.out.println();
        }

    }

}
