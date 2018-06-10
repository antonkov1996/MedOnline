package medonline.beans.admin;

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

@WebServlet(name = "CreateProviderServlet", urlPatterns = {"/provider/add"})
public class CreateProviderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
        String prov_name = (String) request.getParameter("prov_name");
        String address = (String) request.getParameter("address");
        String city = (String) request.getParameter("city");
        Provider provider = new Provider();
        String errorString = null;
        if (errorString == null) {
            try {
                DBUtils.addProvider(conn, prov_name, address, city);
            } catch (SQLException e) {
                e.printStackTrace();
                errorString = e.getMessage();
            }
        }
        request.setAttribute("errorString", errorString);
        request.setAttribute("provider", provider);
        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/addProviderView.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/provider/all");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/addProviderView.jsp");
        dispatcher.forward(request, response);
    }
}
