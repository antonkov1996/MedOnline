package medonline.beans.admin;

import medonline.entities.Medicine;
import medonline.utils.DBUtils;
import medonline.utils.MyUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "MedicinesServlet", urlPatterns = {"/medicine/all"})
public class MedicinesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection connection = MyUtils.getStoredConnection(request);
        String errorString = null;
        List<Medicine> medicineList = null;
        try {
            medicineList = DBUtils.querryMedicines(connection);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        request.setAttribute("errorString", errorString);
        request.setAttribute("medicineList", medicineList);
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/catalogView.jsp");
        dispatcher.forward(request, response);
    }
}
