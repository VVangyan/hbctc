package com.xuxueli.poi.excel;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xuxueli.poi.excel.annotation.ExcelSheet;
import com.xuxueli.poi.excel.util.FieldReflectionUtil;

/**
 * Excel导入工具
 *
 * @author xuxueli 2017-09-08 22:41:19
 */
public class ExcelImportUtil {
    private static Logger logger = LoggerFactory.getLogger(ExcelImportUtil.class);

    /**
     * 从Workbook导入Excel文件，并封装成对象
     *
     * @param sheetClass
     * @param workbook
     * @return
     */
    public static List<Object> importExcel(Class<?> sheetClass, Workbook workbook) {
        try {
            // sheet
            ExcelSheet excelSheet = sheetClass.getAnnotation(ExcelSheet.class);
            String sheetName = (excelSheet!=null && excelSheet.name()!=null && excelSheet.name().trim().length()>0)?excelSheet.name().trim():sheetClass.getSimpleName();

            // sheet field
            List<Field> fields = new ArrayList<Field>();
            if (sheetClass.getDeclaredFields()!=null && sheetClass.getDeclaredFields().length>0) {
                for (Field field: sheetClass.getDeclaredFields()) {
                    if (Modifier.isStatic(field.getModifiers())) {
                        continue;
                    }
                    fields.add(field);
                }
            }

            if (fields==null || fields.size()==0) {
                throw new RuntimeException(">>>>>>>>>>> xxl-excel error, data field can not be empty.");
            }

            // sheet data
            Sheet sheet = workbook.getSheet(sheetName);

            Iterator<Row> sheetIterator = sheet.rowIterator();
            int rowIndex = 0;
            List<Object> dataList = new ArrayList<Object>();
            while (sheetIterator.hasNext()) {
                Row rowX = sheetIterator.next();
                if (rowIndex > 0) {
                    Object rowObj = sheetClass.newInstance();
                    for (int i = 0; i < fields.size(); i++) {
                    	String fieldValueStr="";
                        Field field = fields.get(i);
                        if(rowX.getCell(i)!=null) {
                        	//2017-12-22 修改日期数据获取时候报错 
                        	//Excel导入异常Cannot get a text value from a numeric cell解决
							Cell cell = rowX.getCell(i);
							//cell.setCellType(CellType.STRING);
							DataFormatter formatter = new DataFormatter();
							//String val = formatter.formatCellValue(sheet.getRow(col).getCell(row));
							fieldValueStr = formatter.formatCellValue(cell);
							//fieldValueStr = cell.getStringCellValue();
                        }

                        Object fieldValue = FieldReflectionUtil.parseValue(field, fieldValueStr);

                        field.setAccessible(true);
                        field.set(rowObj, fieldValue);
                    }
                    dataList.add(rowObj);
                }
                rowIndex++;
            }
            return dataList;
        } catch (IllegalAccessException e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    /**
     * 导入Excel文件，并封装成对象
     *
     * @param sheetClass
     * @param excelFile
     * @return
     */
    public static List<Object> importExcel(Class<?> sheetClass, File excelFile) {
    	Workbook workbook=null;
    	try {
            workbook = WorkbookFactory.create(excelFile);
            List<Object> dataList = importExcel(sheetClass, workbook);
            return dataList;
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e);
        } catch (InvalidFormatException e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }finally {
        	//此处需要释放资源，不然Excel打开的时候提示锁定状态
        	 try {
        		 if(workbook!=null) {
        			 workbook.close();
        		 }
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
    }

    /**
     * 从文件路径导入Excel文件，并封装成对象
     *
     * @param sheetClass
     * @param filePath
     * @return
     */
    public static List<Object> importExcel(Class<?> sheetClass, String filePath) {
        File excelFile = new File(filePath);
        List<Object> dataList = importExcel(sheetClass, excelFile);
        return dataList;
    }

    /**
     * 导入Excel数据流，并封装成对象
     *
     * @param sheetClass
     * @param inputStream
     * @return
     */
    public static List<Object> importExcel(Class<?> sheetClass, InputStream inputStream) {
        try {
            Workbook workbook = WorkbookFactory.create(inputStream);
            List<Object> dataList = importExcel(sheetClass, workbook);
            return dataList;
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e);
        } catch (InvalidFormatException e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

}
