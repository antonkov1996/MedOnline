package medonline.beans;

import medonline.utils.ExcelWriter;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet(name = "PrintOrderServlet", urlPatterns = {"/order/print"})
public class PrintOrderServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ExcelWriter.create();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }

        // тип данных, которые вы отправляете
        // например application/pdf, text/plain, text/html, image/jpg
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-disposition","attachment; filename=filetodownload.xlsx");

        // файл, который вы отправляете
        File my_file = new File("orders.xlsx");

        // отправить файл в response
        OutputStream out = response.getOutputStream();
        FileInputStream in = new FileInputStream(my_file);

        byte[] buffer = new byte[4096];
        int length;

        while ((length = in.read(buffer)) > 0){
            out.write(buffer, 0, length);
        }

        // освободить ресурсы
        in.close();
        out.flush();



        response.sendRedirect(request.getContextPath()+"/yourorders");
    }
}
