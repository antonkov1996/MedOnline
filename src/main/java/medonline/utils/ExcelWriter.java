package medonline.utils;

import medonline.entities.Medicine;
import medonline.entities.Order;
import medonline.entities.OrderWrapper;
import medonline.entities.Ordered_MedicineWrapper;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelWriter {
    private static String[] columns = {"Товар", "Название", "Количество", "Цена"};

    public static Workbook create(OrderWrapper orderWrapper) throws IOException, InvalidFormatException {

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Orders");

        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.RED.getIndex());

        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        int rowNum = 0;
        Row headerRow = sheet.createRow(rowNum);
        Cell cell = headerRow.createCell(0);
        cell.setCellValue("Заказ: ");
        cell.setCellStyle(headerCellStyle);

        cell = headerRow.createCell(1);
        cell.setCellValue("" + orderWrapper.getId_order());

        rowNum = 1;
        headerRow = sheet.createRow(rowNum);
        cell = headerRow.createCell(0);
        cell.setCellValue("Клиент: ");
        cell.setCellStyle(headerCellStyle);

        cell = headerRow.createCell(1);
        cell.setCellValue("" + orderWrapper.getCustomer().getLast_name());
        cell = headerRow.createCell(2);
        cell.setCellValue("" + orderWrapper.getCustomer().getFirst_name());

        rowNum = 2;
        headerRow = sheet.createRow(rowNum);
        cell = headerRow.createCell(0);
        cell.setCellValue("Дата: ");
        cell.setCellStyle(headerCellStyle);

        cell = headerRow.createCell(1);
        cell.setCellValue("" + orderWrapper.getOrder_date());

        rowNum = 3;
        headerRow = sheet.createRow(rowNum);
        cell = headerRow.createCell(0);
        cell.setCellValue("Итого: ");
        cell.setCellStyle(headerCellStyle);

        cell = headerRow.createCell(1);
        cell.setCellValue("" + orderWrapper.getTotal());

        rowNum = 5;
        headerRow = sheet.createRow(rowNum);
        for (int i = 0; i < columns.length; i++) {
            cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }

        rowNum = 6;
        for (Ordered_MedicineWrapper medicine : orderWrapper.getOrdered_medicineList()
                ) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(medicine.getId_medicine());
            row.createCell(1).setCellValue(medicine.getMedicine().getMedicine_name());
            row.createCell(2).setCellValue(medicine.getQuantity());
            row.createCell(3).setCellValue(medicine.getMedicine().getPrice());

        }


        // Resize all columns to fit the content size
        for (int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }
        return workbook;
    }
}
