package medonline.beans;

import medonline.entities.Customer;
import medonline.entities.Order;
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

@WebServlet(name = "OrdersServlet" , urlPatterns = {"/order/all"})
public class OrdersServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection connection = MyUtils.getStoredConnection(request);
        String errorString = null;
        List<Order> orderList = new ArrayList<Order>();
        List<Customer> customerList = new ArrayList<Customer>();
        try {
            orderList = DBUtils.querryOrders(connection);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        request.setAttribute("errorString", errorString);
        request.setAttribute("orderList", orderList);
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/orderView.jsp");
        dispatcher.forward(request, response);
    }
}
