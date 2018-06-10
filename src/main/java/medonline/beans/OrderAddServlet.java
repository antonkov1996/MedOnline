package medonline.beans;

import medonline.connect.MyConnection;
import medonline.entities.Customer;
import medonline.entities.MedicineWrapper;
import medonline.filters.CustomerRoleRequestWrapper;
import medonline.utils.DBUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "OrderAddServlet", urlPatterns = {"/order/add"})
public class OrderAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection connection = null;
        List<MedicineWrapper> medicineWrapperList = (List<MedicineWrapper>) request.getSession().getAttribute("medicineWrapperList");
        String errorString = null;
        Customer customer;
        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(dt);
        CustomerRoleRequestWrapper customerRoleRequestWrapper = (CustomerRoleRequestWrapper) request;
        int id_order = 0;
        try {
            connection = MyConnection.getConnection();
            customer = DBUtils.findCustomer(connection, customerRoleRequestWrapper.getEmail());
            id_order = DBUtils.addOrder(connection, customer.getId_custom(), currentTime);
            MyConnection.closeQuietly(connection);

        } catch (Exception e) {
            MyConnection.rollbackQuietly(connection);
            e.printStackTrace();
            errorString = e.getMessage();
        }
        connection = null;
        try {
            connection = MyConnection.getConnection();
            for (MedicineWrapper medicineWrapper : medicineWrapperList
                    ) {
                DBUtils.addOrderedMedicine(connection, medicineWrapper.getId_medicine(), id_order, medicineWrapper.getQuantity());
            }
            MyConnection.closeQuietly(connection);
        } catch (Exception e) {
            MyConnection.rollbackQuietly(connection);
            e.printStackTrace();
            errorString = e.getMessage();
        }
        connection = null;
        try {
            connection = MyConnection.getConnection();
            DBUtils.updateTotalOrder(connection, id_order);
            MyConnection.closeQuietly(connection);
        } catch (Exception e) {
            MyConnection.rollbackQuietly(connection);
            e.printStackTrace();
            errorString = e.getMessage();
        }
        medicineWrapperList.clear();
        HashMap medicineBasket = (HashMap) request.getSession().getAttribute("medicineBasket");
        medicineBasket.clear();
        request.setAttribute("errorString", errorString);
        request.getSession().setAttribute("medicineWrapperList", medicineWrapperList);
        request.getSession().setAttribute("medicineBasket", medicineBasket);
        response.sendRedirect(request.getContextPath() + "/yourorders");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
