package medonline.beans.admin;

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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CreateMedicineServlet", urlPatterns = {"/medicine/create"})
public class CreateMedicineServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);

        String medicine_name = (String) request.getParameter("medicine_name");
        String id_provider = (String) request.getParameter("id_provider");
        String price = (String) request.getParameter("price");
        String quantity = (String) request.getParameter("quantity");
        String id_class = (String) request.getParameter("id_class");
        Medicine medicine = new Medicine();

        String errorString = null;
        if (errorString == null) {
            try {
                DBUtils.addMedicine(conn, medicine_name, id_provider, price, quantity, id_class);

            } catch (SQLException e) {
                e.printStackTrace();
                errorString = e.getMessage();
            }
        }
        request.setAttribute("errorString", errorString);
        request.setAttribute("medicine", medicine);

        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/addMedicineView.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/medicine/create");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
        List<Classification> classificationList = new ArrayList<Classification>();
        List<Provider> providerList = new ArrayList<Provider>();
        try {
            classificationList= DBUtils.querryClassifications(conn);
            providerList=DBUtils.querryProviders(conn);
        }catch (Exception e){

        }
        request.setAttribute("classificationList", classificationList);
        request.setAttribute("providerList", providerList);

        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/addMedicineView.jsp");
        dispatcher.forward(request, response);
    }
}
