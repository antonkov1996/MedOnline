package medonline.beans;

import medonline.entities.Customer;
import medonline.utils.MyUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "CustomerInfoServlet", urlPatterns = {"/customerInfo"})
public class CustomerInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Customer loginedCustomer = MyUtils.getLoginedCustomer(session);
        request.setAttribute("customer", loginedCustomer);
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/customerInfoView.jsp");
        dispatcher.forward(request, response);
    }
}
