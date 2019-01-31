package reflection;

import filters.DescFill;
import filters.FillArrays;
import org.reflections.Reflections;
import sorters.AbstarctSorter;


import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.*;

/**
 * <h1>testAnalyzer</h1>
 * <p>The class serves to analyze time of work different sorts using different fillers.</p>
 * <p>This class has 1 method which use reflection to call all fill,sort-methods</p>
 *
 * @author Khomenko Olexandr
 * @version 1.3
 */
public class Analyzer {

    private int size = 2;
    private int bound = 11;


    public Analyzer()
    {

    }

    public Analyzer(int size, int bound)
    {
        this.size=size;
        this.bound=bound;
    }

    /**
     * <p>Get all fillers methods</p>
     * @return listmethods - get Set of all fillers methods
     */
    public Set<Method> getFillers() {

        Set<Method> listmethods = new HashSet<Method>();
        Method[] methods = FillArrays.class.getMethods();

        for (Method mt : methods) {

            if (mt.isAnnotationPresent(DescFill.class)) { //Check for annotation
                listmethods.add(mt);
            }
        }

        return listmethods;
    }

    /**
     * <p>Get all sorts methods</p>
     * @return listmethods - get List of all sorts methods
     */
    public List<AbstarctSorter> getSorts() {
        Reflections reflections = new Reflections("sorters");
        Set<Class<? extends AbstarctSorter>> classes = reflections.getSubTypesOf(AbstarctSorter.class);
        List<AbstarctSorter> listmethods = new ArrayList<AbstarctSorter>();

        Method[] methods = AbstarctSorter.class.getMethods();

        for (Class<? extends AbstarctSorter> aClass : classes) {

            try {
                AbstarctSorter list = aClass.newInstance();
                listmethods.add(list);
            } catch (Exception ex) {
                //System.out.println(ex.getStackTrace());
            }
        }
        return listmethods;
    }

    /**
     * <p>Get all sorts methods</p>
     * @return result - get time of work filler + sorter methods
     */
    public long getResult(Method m, AbstarctSorter as) {
        long result = 0;
        try {
            Object obj = m.invoke(FillArrays.class, new Integer(size), new Integer(bound));
            int n = Array.getLength(obj); //Print array using different fillers
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                //System.out.print(Array.get(obj, i) + " ");
                arr[i] = (Integer) Array.get(obj, i);
            }

            //System.out.println();
            int[] carr = Arrays.copyOf(arr, n);
            long begin = System.currentTimeMillis();
            as.sort(carr);
            long end = System.currentTimeMillis();
            result = end - begin;
            /*for (int i = 0; i < n; i++) {
                System.out.print(carr[i] + " ");
            }*/
            //System.out.println("\n-----\n");
            //System.out.println();
        } catch (Exception ex) {
            System.out.println(ex.getStackTrace());
        }
        return result;
    }


}


