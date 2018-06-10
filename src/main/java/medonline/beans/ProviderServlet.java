package medonline.beans;

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
import java.util.List;

@WebServlet(name = "ProviderServlet", urlPatterns = {"/provider"})
public class ProviderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection connection = MyUtils.getStoredConnection(request);
        String errorString = null;
        List<Medicine> medicineList = null;
        Provider provider = null;
        try {
            int idProvider = Integer.parseInt(request.getParameter("id"));
            medicineList = DBUtils.querryMedicineByProvider(connection, idProvider);
            provider = DBUtils.querryProviderById(connection, idProvider);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        request.setAttribute("errorString", errorString);
        request.setAttribute("provider", provider);
        request.setAttribute("medicineList", medicineList);
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/providerView.jsp");
        dispatcher.forward(request, response);
    }
}
