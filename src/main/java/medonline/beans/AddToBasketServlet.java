package medonline.beans;

import medonline.entities.Medicine;
import medonline.utils.DBUtils;
import medonline.utils.MyUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;

@WebServlet(name = "AddToBasketServlet", urlPatterns = {"/medicine/add"})
public class AddToBasketServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doGet(request, response);
        HashMap medicineBasket = (HashMap) request.getSession().getAttribute("medicineBasket");
        Connection connection = MyUtils.getStoredConnection(request);
        String errorString = null;
        Medicine medicine = new Medicine();
        try {
            if (request.getParameter("id")==null){
                response.sendRedirect(request.getContextPath()+"/catalog");
                return;
            }
            int id = Integer.parseInt(request.getParameter("id"));
            int q = Integer.parseInt(request.getParameter("q"));
            medicine=DBUtils.querryMedicineByID(connection,id);
            medicineBasket.put(medicine.getId_medicine(),q);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        request.getSession().setAttribute("medicineBasket",medicineBasket);
        response.sendRedirect(request.getContextPath()+"/yourorders");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
