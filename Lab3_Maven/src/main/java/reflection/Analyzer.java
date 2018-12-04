package reflection;

import filters.DescFill;
import filters.FillArrays;
import org.reflections.Reflections;
import sorters.AbstarctSorter;


import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Set;

/**
 * <h1>Analyzer</h1>
 * <p>The class serves to analyze time of work different sorts using different fillers.</p>
 * <p>This class has 1 method which use reflection to call all fill,sort-methods</p>
 * @author Khomenko Olexandr
 * @version 1.3
 */
public class Analyzer {

    /**
     * @param size - arrays size
     * @param bound - numbers bound
     * @see FillArrays#fillRandom(int, int)
     */
    public void analyzeSort(int size,int bound) {

        Reflections reflections = new Reflections("sorters");
        Set<Class<? extends AbstarctSorter>> classes = reflections.getSubTypesOf(AbstarctSorter.class);

        Method[] methods = FillArrays.class.getMethods();

        for (Method mt : methods) {

            if (mt.isAnnotationPresent(DescFill.class)) { //Check for annotation

                DescFill desc = mt.getAnnotation(DescFill.class);//Write name of fillArray methods
                System.out.println(desc.name());

                // Invoke method with appropriate arguments
                try {
                    Object obj = mt.invoke(FillArrays.class, new Integer(size), new Integer(bound)); //Method fill(int,int)
                    //System.out.println(obj[0]);
                    int n = Array.getLength(obj); //Print array using different fillers
                    int[] arr = new int[n];
                    for (int i = 0; i < n; i++) {
                        System.out.print(Array.get(obj, i) + " ");
                        arr[i]=(Integer) Array.get(obj, i);
                    }
                    System.out.println();
                    /*for(Object s : obj){
                        System.out.println(s);
                        System.out.println(Array.get(obj,1).toString());*/
                    //System.out.println(s.toString());

                    for (Class<? extends AbstarctSorter> aClass : classes) {
                        System.out.println(aClass.getName());
                        try {
                            AbstarctSorter list = aClass.newInstance();

                            //list.add("test");
                            //int[] arr = {3, 1, 2};
                            int[] carr = Arrays.copyOf(arr,n);

                            long begin = System.currentTimeMillis();
                            list.sort(carr);
                            long end = System.currentTimeMillis();
                            long result = end - begin;

                            System.out.println("Time Result: "+result+" ms.");

                            for(int z:carr){
                                System.out.print(z+" ");
                            }
                            System.out.println();
                            //System.out.println(list.getClass().getName() + ": " + list.toString());
                        } catch (Exception ex) {
                        }
                        System.out.println("-----------------------------------------");
                    }

                } catch (Exception ex) {
                    System.out.println("Wrong function!");
                }
            }
        }
    }
}


