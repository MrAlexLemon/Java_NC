package excel;

import filters.DescFill;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.charts.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;

import org.apache.poi.xssf.usermodel.charts.XSSFChartLegend;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTMarker;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTMarkerStyle;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea;
import reflection.Analyzer;
import sorters.AbstarctSorter;
import sorters.Description;

import java.io.FileOutputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class ExcelWriter {

    private Analyzer an; //Measure time of work different algorithms
    private ArrayList<Method> method; //fillers methods
    private ArrayList<AbstarctSorter> abstrsort; //sorts methods

    private ArrayList<Long> res1 = new ArrayList<Long>(); //time of work first filler
    private ArrayList<Long> res2 = new ArrayList<Long>(); //time of work second filler
    private ArrayList<Long> res3 = new ArrayList<Long>(); //time of work 3s filler
    private ArrayList<Long> res4 = new ArrayList<Long>(); //time of work 4s filler

    private Workbook wb = new XSSFWorkbook(); //create excel workbook

    public ExcelWriter() {

        an = new Analyzer(11, 11);
        method = new ArrayList<Method>();
        abstrsort = new ArrayList<AbstarctSorter>();
        method.addAll(an.getFillers()); //get fillers
        abstrsort.addAll(an.getSorts()); //get all sort methods
    }


    public void selectData(int size) { //meausure time of different combination sorts and fillers

        an = new Analyzer(size, 7);
        long[][] timeWork = new long[4][8];
        int i = 0;

        for (Method m : method) {
            int j = 0;
            for (AbstarctSorter as : abstrsort) {
                timeWork[i][j] = an.getResult(m, as);
                if (i == 0) {
                    res1.add(timeWork[i][j]);
                } else if (i == 1) {
                    res2.add(timeWork[i][j]);
                } else if (i == 2) {
                    res3.add(timeWork[i][j]);
                } else if (i == 3) {
                    res4.add(timeWork[i][j]);
                }
                j++;
            }
            i++;
        }

    }

    public void testFunction(int start, int finish) throws Exception {

        for (int i = start; i <= finish; i++) {
            selectData(i);
        }

        ArrayList<ArrayList<Long>> arrres = new ArrayList<ArrayList<Long>>();
        arrres.add(res1);
        arrres.add(res2);
        arrres.add(res3);
        arrres.add(res4);

        for (int k = 0; k < 4; k++) {
            writeExcel(start, finish, arrres, k);
        }
    }

    public void writeExcel(int start, int finish, ArrayList<ArrayList<Long>> arrres, int k) throws Exception { //create sheet write data and build chart
        //Workbook wb = new XSSFWorkbook();
        //Get name of fillers
        Sheet dataSheet = wb.createSheet(method.get(k).getAnnotation(DescFill.class).name());

        final int NUM_OF_ROWS = finish - start + 1;
        final int NUM_OF_COLUMNS = 9;

        //Create row,cell and filling
        Row row;
        Cell cell;
        int q = 0;
        for (int rowIndex = 0; rowIndex < NUM_OF_ROWS; rowIndex++) {
            row = dataSheet.createRow((short) rowIndex);
            for (int colIndex = 0; colIndex < NUM_OF_COLUMNS; colIndex++) {
                cell = row.createCell((short) colIndex);
                //cell.setCellValue(rowIndex * ((colIndex + 1) + ((int) (Math.random() * 10))));
                if (colIndex == 0) {
                    cell.setCellValue(start + rowIndex);
                } else {
                    long temp = arrres.get(k).get(q);
                    cell.setCellValue(temp);
                    q++;
                }
            }
        }

        Drawing drawing = dataSheet.createDrawingPatriarch();
        ClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, NUM_OF_COLUMNS + 2, 3, NUM_OF_COLUMNS + 15, 20);

        Chart chart = drawing.createChart(anchor);
        ChartLegend legend = chart.getOrCreateLegend();
        legend.setPosition(LegendPosition.RIGHT);

        LineChartData data = chart.getChartDataFactory().createLineChartData();

        ChartAxis bottomAxis = chart.getChartAxisFactory().createCategoryAxis(AxisPosition.BOTTOM);
        ValueAxis leftAxis = chart.getChartAxisFactory().createValueAxis(AxisPosition.LEFT);
        leftAxis.setCrosses(AxisCrosses.AUTO_ZERO);

        ChartDataSource<Number> xs = DataSources.fromNumericCellRange(dataSheet, new CellRangeAddress(0, NUM_OF_ROWS - 1, 0, 0));
        ChartDataSource<Number> ys1 = DataSources.fromNumericCellRange(dataSheet, new CellRangeAddress(0, NUM_OF_ROWS - 1, 1, 1));
        ChartDataSource<Number> ys2 = DataSources.fromNumericCellRange(dataSheet, new CellRangeAddress(0, NUM_OF_ROWS - 1, 2, 2));
        ChartDataSource<Number> ys3 = DataSources.fromNumericCellRange(dataSheet, new CellRangeAddress(0, NUM_OF_ROWS - 1, 3, 3));
        ChartDataSource<Number> ys4 = DataSources.fromNumericCellRange(dataSheet, new CellRangeAddress(0, NUM_OF_ROWS - 1, 4, 4));
        ChartDataSource<Number> ys5 = DataSources.fromNumericCellRange(dataSheet, new CellRangeAddress(0, NUM_OF_ROWS - 1, 5, 5));
        ChartDataSource<Number> ys6 = DataSources.fromNumericCellRange(dataSheet, new CellRangeAddress(0, NUM_OF_ROWS - 1, 6, 6));
        ChartDataSource<Number> ys7 = DataSources.fromNumericCellRange(dataSheet, new CellRangeAddress(0, NUM_OF_ROWS - 1, 7, 7));
        ChartDataSource<Number> ys8 = DataSources.fromNumericCellRange(dataSheet, new CellRangeAddress(0, NUM_OF_ROWS - 1, 8, 8));


        ArrayList<ChartDataSource> arrN = new ArrayList<ChartDataSource>();
        arrN.add(ys1);
        arrN.add(ys2);
        arrN.add(ys3);
        arrN.add(ys4);
        arrN.add(ys5);
        arrN.add(ys6);
        arrN.add(ys7);
        arrN.add(ys8);

        //Get name of sorts methods and using them in chart
        for (int t = 0; t < arrN.size(); t++) {
            LineChartSeries series1 = data.addSeries(xs, arrN.get(t));
            series1.setTitle(abstrsort.get(t).getClass().getMethod("sort", int[].class).getAnnotation(Description.class).name());
        }


        chart.plot(data, bottomAxis, leftAxis);

        XSSFChart xssfChart = (XSSFChart) chart;
        CTPlotArea plotArea = xssfChart.getCTChart().getPlotArea();
        CTMarker ctMarker = CTMarker.Factory.newInstance();
        ctMarker.setSymbol(CTMarkerStyle.Factory.newInstance());
        for (CTLineSer ser : plotArea.getLineChartArray()[0].getSerArray()) {
            ser.setMarker(ctMarker);
        }

        FileOutputStream fileOut = new FileOutputStream("chart.xlsx");
        wb.write(fileOut);
        fileOut.close();
    }

}
