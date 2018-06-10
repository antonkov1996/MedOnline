package medonline.utils;

import medonline.entities.Order;
import medonline.entities.OrderWrapper;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelWriter {
    private static String[] columns = {"id_order", "id_customer", "Order_date", "Toral"};
    private static List<Order> orders = new ArrayList<Order>();

    public static Workbook create(OrderWrapper orderWrapper) throws IOException,InvalidFormatException {
        orders.add(new Order());


        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Orders");

        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.RED.getIndex());

        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        // Create a Row
        Row headerRow = sheet.createRow(0);

        for (int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }

        // Create Other rows and cells with orders data
        int rowNum = 1;

        for (Order order : orders) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(order.getId_order());
            row.createCell(1).setCellValue(order.getId_customer());
            row.createCell(2).setCellValue(order.getOrder_date());
            row.createCell(3).setCellValue(order.getTotal());
        }

        // Resize all columns to fit the content size
        for (int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // Write the output to a file
//        FileOutputStream fileOut = new FileOutputStream("orders.xlsx");
//        workbook.write(fileOut);
//        fileOut.close();
//        asd
        return workbook;
    }
}
