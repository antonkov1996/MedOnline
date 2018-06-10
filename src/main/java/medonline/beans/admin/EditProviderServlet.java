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

@WebServlet(name = "EditProviderServlet", urlPatterns = {"/provider/edit"})
public class EditProviderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);

        String id_provider = (String) request.getParameter("id");
        String prov_name = (String) request.getParameter("prov_name");
        String address = (String) request.getParameter("address");
        String city = (String) request.getParameter("city");

        Provider provider = new Provider(Integer.parseInt(id_provider), prov_name, address, city);
        String errorString = null;

        try {
            DBUtils.updateProvider(conn, Integer.parseInt(id_provider), prov_name, address, city);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        request.setAttribute("errorString", errorString);
        request.setAttribute("provider", provider);
        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/editProviderView.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/provider/all");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
        int id = Integer.parseInt(request.getParameter("id"));
        Provider provider = null;
        String errorString = null;

        try {
            provider = DBUtils.querryProviderById(conn, id);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        if (errorString != null && provider == null) {
            response.sendRedirect(request.getServletPath() + "/provider/all");
            return;
        }
        request.setAttribute("errorString", errorString);
        request.setAttribute("provider", provider);

        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/editProviderView.jsp");
        dispatcher.forward(request, response);
    }
}
