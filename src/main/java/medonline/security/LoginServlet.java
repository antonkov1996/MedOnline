package medonline.security;

import medonline.entities.Customer;
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
import java.util.HashMap;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");
        dispatcher.forward(request, response);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String errorString = null;
        String customerEmail = request.getParameter("email");
        String password = request.getParameter("password");
        Customer customer =new Customer();
        try {
            Connection connection = MyUtils.getStoredConnection(request);
            customer=DBUtils.findCustomer(connection,customerEmail,password);
        }
        catch (SQLException e){
            e.printStackTrace();
            errorString = e.getMessage();
        }
        if (customer==null){
            errorString="Invalid userName or Password";
            request.setAttribute("errorString",errorString);
            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");
            dispatcher.forward(request,response);
            return;
        }
        MyUtils.storeLoginedCustomer(request.getSession(),customer);
        int redirectId = -1;
        try {
            redirectId=Integer.parseInt(request.getParameter("redirectId"));
        }
        catch (Exception e){

        }
        request.getSession().setAttribute("medicineBasket",new HashMap<>());
        request.getSession().setAttribute("isLogined",true);

        String requestUri = MyUtils.getRedirectAfterLoginUrl(request.getSession(),redirectId);
        if (requestUri!=null){
            response.sendRedirect(requestUri);
        } else {
            response.sendRedirect(request.getContextPath()+"/customerInfo");
        }


    }
}
