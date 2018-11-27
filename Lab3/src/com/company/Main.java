package com.company;

import filters.*;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import sorters.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.lang.*;
import org.reflections.Reflections;
import java.util.Arrays;
import java.util.Set;
import java.lang.reflect.*;
public class Main {

    public static void runAllAnnotatedWith(Class<? extends Annotation> annotation)
            throws Exception {
        Reflections reflections = new Reflections(new ConfigurationBuilder()
                .setUrls(ClasspathHelper.forJavaClassPath())
                .setScanners(new MethodAnnotationsScanner()));
        Set<Method> methods = reflections.getMethodsAnnotatedWith(annotation);

        for (Method m : methods) {
            // for simplicity, invokes methods as static without parameters
            m.invoke(Array.class);
        }
    }

    public static void main(String[] args) {
        /*
         *//*FillArrays.fillSortRandom(7,11);
        for (int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println();
        int[] arr = FillArrays.fillRandom(7, 11);
        for (int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println();*//*


        int[] arr = FillArrays.fillRandom(7, 11);
        for (int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println();
        arr = FillArrays.fillSortBack(arr);
        for (int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println();
        arr = FillArrays.fillSort(arr);
        for (int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println();
        arr = FillArrays.fillSortAdd(arr);
        for (int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println();*/
        try {
            runAllAnnotatedWith(DescFill.class);
        } catch (Exception ex) {
        }

        /*String sClassName = "sorters.ImplClass";
        String sMethodName = "someMethod";
        Class c = Class.forName(sClassName);
        c.newInstance();
        Method method = c.getDeclaredMethod(sMethodName);
        method.invoke(c.newInstance());

        try {
            Class mClassObject = QuickSort.class
            Method method = mClassObject.getDeclaredMethod("sayHello", Array.class);
            method.invoke(objectToInvokeOn, params);
        } catch (Exception ex) {
        }*/

        /*FillArray q = new RandomFillArray(10000, 100);

        FillArray[] fa = new FillArray[]{q,
                new SortAddFillArray(q), new SortBackFillArray(q), new SortFillArray(q)};

        AbstarctSorter[] sa = new AbstarctSorter[]{new BubbleSortUp(),
                new BubbleSortDown(), new QuickSort(), new DefaultSort(), new MergeSortBubbleUp(), new MergeSortBubbleDown(),
                new MergeSortQuickSort(), new MergeSortDefaultSort()};

        OutputResult out = new OutputResult(fa, sa);
        out.showResult();*/

    }
}
