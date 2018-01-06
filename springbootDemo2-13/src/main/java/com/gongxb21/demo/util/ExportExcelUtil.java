package com.gongxb21.demo.util;

import java.awt.Color;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.Borders;

/**
 * @author gongxb
 *
 * 2018年1月6日
 */
public class ExportExcelUtil {
	public static void exportExcel(HttpServletRequest request,HttpServletResponse response,String  fileName,ExcelData data) throws Exception {
		response.setHeader("content-type", "application/vnd.ms-excel");
		response.setHeader("content-Disposition", "attachment;filename="+URLEncoder.encode(fileName,"utf-8"));
		exportExcel(data,response.getOutputStream());
	}

	/**
	 * @param data
	 * @param outputStream
	 * void
	 */
	private static void exportExcel(ExcelData data,ServletOutputStream outputStream) {
		 XSSFWorkbook wb = new XSSFWorkbook();
	        try {
	            String sheetName = data.getName();
	            if (null == sheetName) {
	                sheetName = "Sheet1";
	            }
	            XSSFSheet sheet = wb.createSheet(sheetName);
	            writeExcel(wb, sheet, data);

	            wb.write(outputStream);
	        }catch(Exception e) {
	        	System.out.println("catch a exception ");
	        } 
	}

	/**
	 * @param wb
	 * @param sheet
	 * @param data
	 * void
	 */
	private static void writeExcel(XSSFWorkbook wb, XSSFSheet sheet, ExcelData data) {
		int rowIndex = 0;

        rowIndex = writeTitlesToExcel(wb, sheet, data.getTitleList());
        writeRowsToExcel(wb, sheet, data.getRows(), rowIndex);
        autoSizeColumns(sheet, data.getTitleList().size() + 1);
	}

	/**
	 * @param sheet
	 * @param i
	 * void
	 */
	private static void autoSizeColumns(XSSFSheet sheet, int columnNumber) {
		 for (int i = 0; i < columnNumber; i++) {
	            int orgWidth = sheet.getColumnWidth(i);
	            sheet.autoSizeColumn(i, true);
	            int newWidth = (int) (sheet.getColumnWidth(i) + 100);
	            if (newWidth > orgWidth) {
	                sheet.setColumnWidth(i, newWidth);
	            } else {
	                sheet.setColumnWidth(i, orgWidth);
	            }
	        }
		
	}

	/**
	 * @param wb
	 * @param sheet
	 * @param rows
	 * @param rowIndex
	 * void
	 */
	private static int writeRowsToExcel(XSSFWorkbook wb, XSSFSheet sheet, List<List<Object>> rows, int rowIndex) {
		  int colIndex = 0;

	        Font dataFont = wb.createFont();
	        dataFont.setFontName("simsun");
	        // dataFont.setFontHeightInPoints((short) 14);
	        dataFont.setColor(IndexedColors.BLACK.index);

	        XSSFCellStyle dataStyle = wb.createCellStyle();
	        dataStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);
	        dataStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
	        dataStyle.setFont(dataFont);
	        setBorder(dataStyle, BorderStyle.THIN, new XSSFColor(new Color(0, 0, 0)));

	        for (List<Object> rowData : rows) {
	            Row dataRow = sheet.createRow(rowIndex);
	            colIndex = 0;

	            for (Object cellData : rowData) {
	                Cell cell = dataRow.createCell(colIndex);
	                if (cellData != null) {
	                    cell.setCellValue(cellData.toString());
	                } else {
	                    cell.setCellValue("");
	                }

	                cell.setCellStyle(dataStyle);
	                colIndex++;
	            }
	            rowIndex++;
	        }
	        return rowIndex;
	}

	/**
	 * @param wb
	 * @param sheet
	 * @param titleList
	 * @return
	 * int
	 */
	private static int writeTitlesToExcel(XSSFWorkbook wb, XSSFSheet sheet, List<String> titleList) {
		   int rowIndex = 0;
	        int colIndex = 0;

	        Font titleFont = wb.createFont();
	        titleFont.setFontName("simsun");
	        titleFont.setBoldweight((short)2);
	        // titleFont.setFontHeightInPoints((short) 14);
	        titleFont.setColor(IndexedColors.BLACK.index);

	        XSSFCellStyle titleStyle = wb.createCellStyle();
	        titleStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);
	        titleStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
	        titleStyle.setFillForegroundColor(new XSSFColor(new Color(182, 184, 192)));
	        titleStyle.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
	        titleStyle.setFont(titleFont);
	        setBorder(titleStyle, BorderStyle.THIN, new XSSFColor(new Color(0, 0, 0)));

	        Row titleRow = sheet.createRow(rowIndex);
	        // titleRow.setHeightInPoints(25);
	        colIndex = 0;

	        for (String field : titleList) {
	            Cell cell = titleRow.createCell(colIndex);
	            cell.setCellValue(field);
	            cell.setCellStyle(titleStyle);
	            colIndex++;
	        }

	        rowIndex++;
	        return rowIndex;
	}

	/**
	 * @param style
	 * @param thin
	 * @param xssfColor
	 * void
	 */
	private static void setBorder(XSSFCellStyle style, BorderStyle border, XSSFColor color) {
		style.setBorderTop(border);
		style.setBorderLeft(border);
		style.setBorderRight(border);
		style.setBorderBottom(border);
	}
}
