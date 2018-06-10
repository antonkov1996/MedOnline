package medonline.beans;

import medonline.entities.Medicine;
import medonline.utils.MyUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;

@WebServlet(name = "DeleteFormBasketServlet", urlPatterns = {"/medicine/del"})
public class DeleteFormBasketServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HashMap medicineBasket = (HashMap) request.getSession().getAttribute("medicineBasket");
        Connection connection = MyUtils.getStoredConnection(request);
        String errorString = null;
        Medicine medicine = new Medicine();
        try {
            if (request.getParameter("id") == null) {
                response.sendRedirect(request.getContextPath() + "/catalog");
                return;
            }
            int id = Integer.parseInt(request.getParameter("id"));

            medicineBasket.remove(id);
        } catch (Exception e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        request.getSession().setAttribute("medicineBasket", medicineBasket);
        response.sendRedirect(request.getContextPath() + "/yourorders");
    }
}
