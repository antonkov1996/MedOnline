package medonline.beans;

import medonline.entities.OrderWrapper;
import medonline.utils.ExcelWriter;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet(name = "PrintOrderServlet", urlPatterns = {"/order/print"})
public class PrintOrderServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OrderWrapper orderWrapper = (OrderWrapper) request.getSession().getAttribute("orderWrap");
        Workbook workbook = new XSSFWorkbook();
        try {
            workbook = ExcelWriter.create(orderWrapper);
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
        String s = "attachment; filename=Order" + orderWrapper.getId_order() + ".xlsx";
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-disposition", s);

        OutputStream out = response.getOutputStream();
        workbook.write(out);

        response.sendRedirect(request.getContextPath() + "/yourorders");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
