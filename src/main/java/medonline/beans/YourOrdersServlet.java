package medonline.beans;

import medonline.entities.*;
import medonline.filters.CustomerRoleRequestWrapper;
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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "YourOrdersServlet", urlPatterns = {"/yourorders"})
public class YourOrdersServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection connection = MyUtils.getStoredConnection(request);
        String errorString = null;
        Medicine medicine = new Medicine();
        HashMap medicineBasket = (HashMap) request.getSession().getAttribute("medicineBasket");
        List<Integer> quantityList = new ArrayList<Integer>(medicineBasket.values());
        List<MedicineWrapper> medicineWrapperList = new ArrayList<MedicineWrapper>();
        if (medicineBasket != null) {
            Iterator iterator = medicineBasket.keySet().iterator();
            int i =0;
            while (iterator.hasNext()) {

                try {
                    medicine = DBUtils.querryMedicineByID(connection, (Integer) iterator.next());
                    int quantity = quantityList.get(i);
                    medicineWrapperList.add(new MedicineWrapper(medicine,quantity));
                } catch (SQLException e) {
                    e.printStackTrace();
                    errorString = e.getMessage();
                }
                i++;

            }
        }
        Customer customer = new Customer();
        List<Ordered_MedicineWrapper> ordered_medicineList = new ArrayList<Ordered_MedicineWrapper>();
        List<OrderWrapper> orderWrapperList = new ArrayList<OrderWrapper>();
        CustomerRoleRequestWrapper customerRoleRequestWrapper = (CustomerRoleRequestWrapper) request;
        //нужно получить список ордеров и в каждом получить сведения
        try {
            customer = DBUtils.findCustomer(connection, customerRoleRequestWrapper.getEmail());
            int id_customer = customer.getId_custom();
            orderWrapperList = DBUtils.querryOrderByCustomer(connection, id_customer);
            for (OrderWrapper wrapper : orderWrapperList
                    ) {
                wrapper.setCustomer(customer);
                ordered_medicineList = DBUtils.querryOrderedMedicineWrapperByOrder(connection, wrapper.getId_order());
                wrapper.setOrdered_medicineList(ordered_medicineList);

            }
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }


        request.setAttribute("errorString", errorString);
        request.setAttribute("orderWrapperList", orderWrapperList);
        request.setAttribute("customer", customer);
        request.setAttribute("medicineWrapperList", medicineWrapperList);

        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/orderView.jsp");
        dispatcher.forward(request, response);
    }
}
