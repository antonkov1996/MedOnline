package medonline.beans;

import medonline.entities.Classification;
import medonline.entities.Medicine;
import medonline.entities.Provider;
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

@WebServlet(name = "MedicineInfoServlet", urlPatterns = {"/medicine"})
public class MedicineInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection connection = MyUtils.getStoredConnection(request);
        String errorString = null;
        Medicine medicine = new Medicine();
        Provider provider = new Provider();
        Classification classification = new Classification();
        try {
            int id_medicine = Integer.parseInt(request.getParameter("id"));
            medicine = DBUtils.querryMedicineByID(connection, id_medicine);
            provider = DBUtils.querryProviderById(connection, medicine.getId_provider());
            classification = DBUtils.querryClassById(connection, medicine.getId_class());
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        request.setAttribute("errorString", errorString);
        request.setAttribute("medicine", medicine);
        request.setAttribute("classification", classification);
        request.setAttribute("provider", provider);
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/medicineView.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
