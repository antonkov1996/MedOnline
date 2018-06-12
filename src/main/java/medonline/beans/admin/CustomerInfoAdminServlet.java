package medonline.beans.admin;

import medonline.entities.Customer;
import medonline.entities.Order;
import medonline.entities.OrderWrapper;
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

@WebServlet(name = "CustomerInfoAdminServlet", urlPatterns = {"/customer/info"})
public class CustomerInfoAdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection connection = MyUtils.getStoredConnection(request);
        String errorString = null;
        String email = request.getParameter("email");
        Customer customer = new Customer();
        List<OrderWrapper> orderList = new ArrayList<OrderWrapper>();
        try {
            customer = DBUtils.findCustomer(connection, email);
            orderList= DBUtils.querryOrderByCustomer(connection,customer.getId_custom());
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        request.setAttribute("errorString", errorString);
        request.setAttribute("customer", customer);
        request.setAttribute("orderList", orderList);
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/customerInfoView.jsp");
        dispatcher.forward(request, response);
    }
}
