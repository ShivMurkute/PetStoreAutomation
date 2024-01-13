package api.utilitise;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.*;

import javax.swing.text.Style;
import javax.xml.crypto.Data;
import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.io.*;

public class XLUtility {
    public FileInputStream fi;
    public FileOutputStream fo;
    public XSSFWorkbook workbook;
    public XSSFSheet sheet;
    public XSSFRow row;
    public XSSFCell cell;
    public XSSFCellStyle cellStyle;

    String path;
    public XLUtility(String path){//Constructor (send path of the xml)
        this.path=path;
    }
    public int getRowCount(String sheetName) throws IOException {
        fi=new FileInputStream(path);
        workbook=new XSSFWorkbook(fi);
        sheet=workbook.getSheet(sheetName);
        int rowCount=sheet.getLastRowNum();
        workbook.close();
        fi.close();
        return rowCount;//it will return How many rows in excel count
    }
    public  int getColumnCount(String sheetName,int rownum) throws IOException {
fi=new FileInputStream(path);
workbook=new XSSFWorkbook(fi);
sheet=workbook.getSheet(sheetName);
row=sheet.getRow(rownum);
int cellcount=row.getLastCellNum();
workbook.close();
fi.close();
return cellcount;

    }
    public String getCellData(String sheetName,int rownum,int colnum) throws IOException {
fi=new FileInputStream(path);
workbook=new XSSFWorkbook(fi);
sheet= workbook.getSheet(sheetName);
row=sheet.getRow(rownum);
cell=row.getCell(colnum);
DataFormatter formator=new DataFormatter();
String data;
try{
    data =formator.formatCellValue(cell);//Returns the formatted value of cell
}
catch (Exception e){
    data="";
        }
workbook.close();
fi.close();
return data;

    }
    public void setCellData(String sheetName,int rownum,int colnum,String data) throws IOException {
        File xlfile=new File(path);
        if(!xlfile.exists())    //if file not exists create new file
        {
            workbook=new XSSFWorkbook();
            fo=new FileOutputStream(path);
            workbook.write(fo);
        }
        fi=new FileInputStream(path);
        workbook=new XSSFWorkbook(fi);

        if(workbook.getSheetIndex(sheetName)==-1);//if sheet not exists then create new sheet
        workbook.createSheet(sheetName);
        sheet= workbook.getSheet(sheetName);

        if(sheet.getRow(rownum)==null);// if row not exists create new row
        sheet.createRow(rownum);
        row=sheet.getRow(rownum);

        cell=row.createCell(colnum);
        cell.setCellValue(data);
        fo=new FileOutputStream(path);
        workbook.write(fo);
        workbook.close();
        fi.close();
        fo.close();

    }
    public void fillGreenColor(String sheetName,int rownum,int colnum) throws IOException {
        fi=new FileInputStream(path);
        workbook=new XSSFWorkbook(fi);
        sheet= workbook.getSheet(sheetName);
         row=sheet.getRow(rownum);
         cell=row.getCell(colnum);

        cellStyle=workbook.createCellStyle();
        cellStyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cell.setCellStyle(cellStyle);
        workbook.write(fo);
        workbook.close();
        fi.close();
        fo.close();
    }
    public void fillRedColor(String sheetName,int rownum,int colnum) throws IOException {
        fi=new FileInputStream(path);
        workbook=new XSSFWorkbook(fi);
        sheet= workbook.getSheet(sheetName);
        row=sheet.getRow(rownum);
        cell=row.getCell(colnum);

        cellStyle=workbook.createCellStyle();
        cellStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cell.setCellStyle(cellStyle);
        workbook.write(fo);
        workbook.close();
        fi.close();
        fo.close();

    }






}
