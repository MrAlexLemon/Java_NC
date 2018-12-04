package com.company;

import filters.DescFill;
import filters.FillArrays;
import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.sql.Array;
import java.util.Set;

import reflection.*;

import filters.FillArrays;
import sorters.AbstarctSorter;
import sorters.BubbleSortDown;

/*@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface mod {
    String name() default "";
}

class Good {
    @mod(name = "me1")
    public static void calledcs(int a, int b) {
        System.out.println("function1 called");
        System.out.println(a + " " + b);
    }

    @mod(name = "me2")
    public static void calledcs2(int c) {
        System.out.println("function2 called");
    }

    @mod(name = "me3")
    public static void calledcs3() {
        System.out.println("function3 called");
    }

    @mod(name = "me2")
    public static void calledcs4(int c) {
        System.out.println("function4 called");
    }
}*/

/**
 * <h1>Main</h1>
 * <p>It is main class.</p>
 * @author Khomenko Olexandr
 * @version 1.3
 */
public class Main {

    /*public static Method findAnnotatedMethod(Class<?> clazz, Class<? extends Annotation> annotationClass) {
        for (Method method : clazz.getMethods())
            if( method.isAnnotationPresent(annotationClass))
                return(method);
        return(null);
    }

    public static List<Method> findAnnotatedMethods(Class<?> clazz, Class<? extends Annotation> annotationClass) {
        Method[] methods = clazz.getMethods();
        List<Method> annotatedMethods = new ArrayList<Method>(methods.length);
        for (Method method : methods) {
            if( method.isAnnotationPresent(annotationClass)){
                annotatedMethods.add(method);
            }
        }
        return annotatedMethods;
    }
*/

    /*public static void runAllAnnotatedWith(Class<? extends Annotation> annotation)
            throws Exception {
        Reflections reflections = new Reflections(new ConfigurationBuilder()
                .setUrls(org.reflections.util.ClasspathHelper.forJavaClassPath())
                .setScanners(new reflection.MethodAnnotationsScanner()));
        Set<Method> methods = reflections.getMethodsAnnotatedWith(annotation);

        for (Method m : methods) {
            // for simplicity, invokes methods as static without parameters
            m.invoke(null);
        }
    }*/

    /*public static void runAllAnnotatedWith(Class<? extends Annotation> annotation, Object[] arg)
            throws Exception {
        Reflections reflections = new Reflections(new ConfigurationBuilder()
                .setUrls(ClasspathHelper.forJavaClassPath())
                .setScanners(new MethodAnnotationsScanner()));
        Set<Method> methods = reflections.getMethodsAnnotatedWith(annotation);

        for (Method m : methods) {
            // for simplicity, invokes methods as static without parameters
            m.invoke(null);
        }
    }*/


    /**
     * <p>main function.</p>
     * @param args - input params
     */
    public static void main(String[] args) {
        //System.out.println("Lol");
        Analyzer an = new Analyzer();
        an.analyzeSort(7,10);
        /*int[] arr = FillArrays.fillRandom(7,11);
        for(int i:arr)
            System.out.print(i+" ");
        System.out.println();
        int [] arr1 = FillArrays.fillSort(7,11);
        for(int i:arr1)
            System.out.print(i+" ");
        System.out.println();
        for(int i:arr)
            System.out.print(i+" ");
        Object[] arg = new Object[]{new Integer(7),new Integer(11)};*/

        //FillArrays obj1 = new FillArrays();

//////////////////////////////////////////////////////////////////////
//        Reflections reflections = new Reflections("java.util");
       /* Reflections reflections = new Reflections("sorters");
        Set<Class<? extends AbstarctSorter>> classes = reflections.getSubTypesOf(AbstarctSorter.class);
        //Set<Class<? extends AbstarctSorter>> classes = reflections.getSubTypesOf(AbstarctSorter.class);
        for (Class<? extends AbstarctSorter> aClass : classes) {
            System.out.println(aClass.getName());
            //if (aClass == BubbleSortDown.class) {
                try {
                    AbstarctSorter list = aClass.newInstance();

                    //list.add("test");
                    int[] arr = {3, 1, 2};
                    list.sort(arr);
                    System.out.println(list.getClass().getName() + ": " + list.toString());
                } catch (Exception ex) {
                }
           // }
        }*/
//////////////////////////////////////////////////////////

        ////
        /*Method[] methods = BubbleSortDown.class.getMethods();
        for (Method mt : methods) {
            if (mt.isAnnotationPresent(Override.class)) {
                // Invoke method with appropriate arguments
                try {
                    Object obj = mt.invoke(BubbleSortDown.class, new Integer(7));
                } catch (Exception ex) {
                }
            }
        }
*/
        ////////////////////////
        /*Method[] methods = FillArrays.class.getMethods();
        for(Method mt : methods) {
            if (mt.isAnnotationPresent(DescFill.class)) {
                // Invoke method with appropriate arguments
                try {
                    Object obj = mt.invoke(FillArrays.class, new Integer(7),new Integer(10));
                }
                catch (Exception ex){}
            }
        }*/
///////////////////////////////
       /* try{
        runAllAnnotatedWith(mod.class,arg);}
        catch(Exception ex){}*/

///////////////////////
/*FillArrays objs=new FillArrays();
Class s = objs.getClass();
        System.out.println(s.getMethods());

        Method[] methods = Good.class.getMethods();
        for(Method mt : methods) {
            if (mt.isAnnotationPresent(mod.class)) {
                // Invoke method with appropriate arguments
                try{
                Object obj = mt.invoke(Good.class, null);}
                catch (Exception ex){}
            }
        }*/

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
        /*try {
            runAllAnnotatedWith(DescFill.class);
        } catch (Exception ex) {
        }*/
        /*Method[] methods = Class.getMethods();
        for(Method mt : methods) {
            if (mt.isAnnotationPresent(DescFill.class)) {
                // Invoke method with appropriate arguments
                Object obj = mt.invoke(runClass, null);
            }
        }*/


       /* String sClassName = "sorters.ImplClass";
        String sMethodName = "someMethod";
        Class c = Class.forName(sClassName);
        c.newInstance();
        Method method = c.getDeclaredMethod(sMethodName);
        method.invoke(c.newInstance());

        try {
            Class mClassObject = QuickSort.class;
            Method method = mClassObject.getDeclaredMethod("sayHello", Array.class);
            method.invoke(objectToInvokeOn, params);
        } catch (Exception ex) {
        }
*/
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
