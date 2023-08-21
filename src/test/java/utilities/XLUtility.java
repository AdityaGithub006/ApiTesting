package utilities;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class XLUtility {
    public FileInputStream fi;
    public FileOutputStream fo;
    public XSSFWorkbook workbook;
    public XSSFSheet sheet;
    public XSSFCell cell;
    public XSSFRow row;
    public CellStyle style;
    String path;

    public XLUtility(String path) {
        this.path = path;
    }

    public int getRowCount(String sheetName) throws IOException{
        fi = new FileInputStream(path);
        workbook = new XSSFWorkbook(fi);
        sheet = workbook.getSheet(sheetName);
        int rowCount = sheet.getLastRowNum();
        workbook.close();
        fi.close();

        return rowCount;
    }
    public int getCellCount(String sheetName, int rowNum) throws IOException{
        fi = new FileInputStream(path);
        workbook = new XSSFWorkbook(fi);
        sheet = workbook.getSheet(sheetName);
        row = sheet.getRow(rowNum);
        int cellCount = row.getLastCellNum();
        workbook.close();
        fi.close();

        return cellCount;
    }
    public String getCellData(String sheetName, int rowNum, int column) throws IOException{
        fi = new FileInputStream(path);
        workbook = new XSSFWorkbook(fi);
        sheet = workbook.getSheet(sheetName);
        row = sheet.getRow(rowNum);
        cell = row.getCell(column);

        DataFormatter dataFormatter = new DataFormatter();
        String data;
        try {
            data = dataFormatter.formatCellValue(cell); //Return the formatted value of a cell as a String
        }
        catch (Exception e){
            data ="";
        }
        workbook.close();
        fi.close();
        return data;
    }
    public void setCellData(String sheetName, int rowNum, int colNum, String data) throws IOException{
        File xFile = new File(path);
        if (!xFile.exists()){
            workbook = new XSSFWorkbook();
            fo = new FileOutputStream(path);
            workbook.write(fo);
        }
        fi = new FileInputStream(path);
        workbook = new XSSFWorkbook(fi);

        if (workbook.getSheetIndex(sheetName)==-1){ //if sheet not exists then create new sheet
            workbook.createSheet(sheetName);
        }
        sheet = workbook.getSheet(sheetName);
        if (sheet.getRow(rowNum)==null){ //if row not exists then create new sheet
            sheet.createRow(rowNum);
        }
        row = sheet.getRow(rowNum);

        cell = row.createCell(colNum);
        cell.setCellValue(data);
        fo = new FileOutputStream(path);
        workbook.write(fo);
        workbook.close();
        fi.close();
        fo.close();
    }
    public void fillGreenColor(String sheetName, int rowNum, int column) throws IOException{
        fi = new FileInputStream(path);
        workbook = new XSSFWorkbook(fi);
        sheet = workbook.getSheet(sheetName);

        row = sheet.getRow(rowNum);
        cell = row.getCell(column);

        style = workbook.createCellStyle();

        style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        cell.setCellStyle(style);
        workbook.write(fo);
        workbook.close();
        fi.close();
        fo.close();
    }
    public void fillRedColor(String sheetName, int rowNum, int column) throws IOException{
        fi = new FileInputStream(path);
        workbook = new XSSFWorkbook(fi);
        sheet = workbook.getSheet(sheetName);

        row = sheet.getRow(rowNum);
        cell = row.getCell(column);

        style = workbook.createCellStyle();

        style.setFillForegroundColor(IndexedColors.RED.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        cell.setCellStyle(style);
        workbook.write(fo);
        workbook.close();
        fi.close();
        fo.close();
    }
}


