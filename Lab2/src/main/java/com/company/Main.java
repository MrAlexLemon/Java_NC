package com.company;

import analyzer.AnalyzerSort;
import filters.*;
import output.OutputResult;
import sorters.*;

public class Main {

    public static void main(String[] args) {

        FillArray q = new RandomFillArray(10000,100);

        FillArray[] fa = new FillArray[]{q,
                new SortAddFillArray(q), new SortBackFillArray(q), new SortFillArray(q)};

        SortArray[] sa = new SortArray[]{new BubbleSortUp(),
                new BubbleSortDown(), new QuickSort(), new DefaultSort(), new MergeSortBubbleUp(), new MergeSortBubbleDown(),
                new MergeSortQuickSort(),new MergeSortDefaultSort()};

        OutputResult out = new OutputResult(fa,sa);
        out.showResult();

    }
}
