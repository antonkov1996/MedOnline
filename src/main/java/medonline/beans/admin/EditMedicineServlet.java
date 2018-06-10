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

@WebServlet(name = "EditMedicineServlet", urlPatterns = {"/medicine/edit"})
public class EditMedicineServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
        String id_medicine = (String) request.getParameter("id_medicine");
        String medicine_name = (String) request.getParameter("medicine_name");
        String id_provider = (String) request.getParameter("id_provider");
        String priceStr = (String) request.getParameter("price");
        String quantity = (String) request.getParameter("quantity");
        String id_class = (String) request.getParameter("id_class");
        float price = 0;
        try {
            price = Float.parseFloat(priceStr);
        } catch (Exception e) {
        }
        Medicine medicine = new Medicine(Integer.parseInt(id_medicine), medicine_name, Integer.parseInt(id_provider), price, Integer.parseInt(quantity), Integer.parseInt(id_class));
        String errorString = null;

        try {
            DBUtils.updateMedicine(conn, Integer.parseInt(id_medicine), medicine_name, Integer.parseInt(id_provider), price, Integer.parseInt(quantity), Integer.parseInt(id_class));
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        request.setAttribute("errorString", errorString);
        request.setAttribute("medicine", medicine);
        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/editMedicineView.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/medicine/all");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
        int id = Integer.parseInt(request.getParameter("id"));
        Medicine medicine = null;
        String errorString = null;

        try {
            medicine = DBUtils.querryMedicineByID(conn, id);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        if (errorString != null && medicine == null) {
            response.sendRedirect(request.getServletPath() + "/medicine/all");
            return;
        }
        request.setAttribute("errorString", errorString);
        request.setAttribute("medicine", medicine);

        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/editMedicineView.jsp");
        dispatcher.forward(request, response);
    }
}
