package com.company;

import filters.FillArrays;
import reflection.*;
import sorters.AbstarctSorter;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;


/**
 * <h1>Main</h1>
 * <p>It is main class.</p>
 * @author Khomenko Olexandr
 * @version 1.3
 */
public class Main {

    /**
     * <p>main function.</p>
     * @param args - input params
     */
    public static void main(String[] args) {

        Analyzer an = new Analyzer(7,11);
        //testAnalyzer an = new testAnalyzer();
        //an.analyzeFillSort(7,11);
        ArrayList<Method> method = new ArrayList<Method>();
        ArrayList<AbstarctSorter> abstrsort = new ArrayList<AbstarctSorter>();
        method.addAll(an.getFillers()); //get fillers
        abstrsort.addAll(an.getSorts()); //get all sort methods

        ArrayList<Long> timeWork = new ArrayList<Long>();

        for(Method m:method) {
            for(AbstarctSorter as:abstrsort) {
                //an.getResult(m,as);
                timeWork.add(an.getResult(m,as));
                //System.out.print(an.getResult(m,as)+" ");
            }
            //System.out.println();
        }
    }
}
