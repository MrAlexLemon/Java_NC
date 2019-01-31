package com.company;

import excel.ExcelWriter;


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

        ExcelWriter ew = new ExcelWriter();
        try {
            ew.testFunction(1000,1050);
        }
        catch (Exception ex){
            System.out.println("Something are wrong!");
        }
    }
}
