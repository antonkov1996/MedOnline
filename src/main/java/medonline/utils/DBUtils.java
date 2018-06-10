package medonline.utils;

import medonline.entities.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtils {

    public static List<Classification> querryClassifications(Connection connection) throws SQLException {
        String sql = "select * from classification;";

        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        List<Classification> classificationList = new ArrayList<Classification>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id_class");
            String desc = resultSet.getString("description");
            Classification classification = new Classification();
            classification.setId_class(id);
            classification.setDescription(desc);
            classificationList.add(classification);

        }
        return classificationList;
    }

    public static List<Medicine> querryMedicines(Connection connection) throws SQLException {
        String sql = "select * from medicine;";

        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        List<Medicine> medicineList = new ArrayList<Medicine>();
        while (resultSet.next()) {

            Medicine medicine = new Medicine();
            medicine = Medicine.initResultSet(medicine, resultSet);
            medicineList.add(medicine);

        }
        return medicineList;
    }

    public static List<Medicine> searchMedicines(Connection connection, String search_text) throws SQLException {
        search_text = "%" + search_text + "%";
        String sql = "select * from medicine where medicine_name like ?;";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, search_text);
        ResultSet resultSet = statement.executeQuery();
        List<Medicine> medicineList = new ArrayList<Medicine>();
        while (resultSet.next()) {

            Medicine medicine = new Medicine();
            medicine = Medicine.initResultSet(medicine, resultSet);
            medicineList.add(medicine);

        }
        return medicineList;
    }

    public static List<Customer> querryCustomers(Connection connection) throws SQLException {
        String sql = "select * from customers;";

        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        List<Customer> customerList = new ArrayList<Customer>();
        while (resultSet.next()) {

            Customer customer = new Customer();
            customer = Customer.initResultSet(customer, resultSet);
            customerList.add(customer);

        }
        return customerList;
    }


    public static List<Provider> querryProviders(Connection connection) throws SQLException {
        String sql = "select * from medonline.providers";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        List<Provider> providerList = new ArrayList<Provider>();
        while (resultSet.next()) {
            Provider provider = new Provider();
            Provider.initResultSet(provider, resultSet);
            providerList.add(provider);

        }
        return providerList;
    }

    public static List<Order> querryOrders(Connection connection) throws SQLException {
        String sql = "select * from orders";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        List<Order> orderList = new ArrayList<Order>();
        while (resultSet.next()) {
            Order order = new Order();
            order = Order.initResultSet(order, resultSet);
            orderList.add(order);

        }
        return orderList;
    }

    public static List<Medicine> querryMedicineByClass(Connection connection, int id_class) throws SQLException {
        String sql = "select * from medicine where medicine.id_class=?;";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, String.valueOf(id_class));
        ResultSet resultSet = statement.executeQuery();
        List<Medicine> medicineList = new ArrayList<Medicine>();
        while (resultSet.next()) {
            Medicine medicine = new Medicine();
            medicine = Medicine.initResultSet(medicine, resultSet);
            medicineList.add(medicine);

        }
        return medicineList;
    }

    public static List<Ordered_Medicine> querryOrderedMedicineByOrder(Connection connection, int id_order) throws SQLException {
        String sql = "select * from ordered_medicine where id_order=?;";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, String.valueOf(id_order));
        ResultSet resultSet = statement.executeQuery();
        List<Ordered_Medicine> medicineList = new ArrayList<Ordered_Medicine>();
        while (resultSet.next()) {
            Ordered_Medicine ordered_medicine = new Ordered_Medicine();
            ordered_medicine = Ordered_Medicine.initResultSet(ordered_medicine, resultSet);
            medicineList.add(ordered_medicine);

        }
        return medicineList;
    }

    public static List<Ordered_MedicineWrapper> querryOrderedMedicineWrapperByOrder(Connection connection, int id_order) throws SQLException {
        String sql = "select * from ordered_medicine where id_order=?;";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, String.valueOf(id_order));
        ResultSet resultSet = statement.executeQuery();
        List<Ordered_MedicineWrapper> medicineList = new ArrayList<Ordered_MedicineWrapper>();
        while (resultSet.next()) {
            Ordered_MedicineWrapper ordered_medicine = new Ordered_MedicineWrapper();
//            ordered_medicine = Ordered_Medicine.initResultSet(ordered_medicine, resultSet);
            ordered_medicine.setId_medicine(resultSet.getInt("id_medicine"));
            ordered_medicine.setId_order(resultSet.getInt("id_order"));
            ordered_medicine.setQuantity(resultSet.getInt("quantity"));
            ordered_medicine.setMedicine(DBUtils.querryMedicineByID(connection, ordered_medicine.getId_medicine()));
            medicineList.add(ordered_medicine);

        }
        return medicineList;
    }

    public static Medicine querryMedicineByID(Connection connection, int id_medicine) throws SQLException {
        String sql = "select * from medicine where id_medicine=?;";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, String.valueOf(id_medicine));
        ResultSet resultSet = statement.executeQuery();
        Medicine medicine = new Medicine();
        if (resultSet.next()) {
            medicine = Medicine.initResultSet(medicine, resultSet);
        }
        return medicine;
    }

    public static Order querryOrderById(Connection connection, int id_order) throws SQLException {
        String sql = "select * from medonline.orders where id_order=?;";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, String.valueOf(id_order));
        ResultSet resultSet = statement.executeQuery();
        Order order = new Order();
        if (resultSet.next()) {
            order = Order.initResultSet(order, resultSet);
        }
        return order;
    }

    public static List<OrderWrapper> querryOrderByCustomer(Connection connection, int id_customer) throws SQLException {
        String sql = "select * from medonline.orders where id_customer=?;";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, String.valueOf(id_customer));
        ResultSet resultSet = statement.executeQuery();
        List<OrderWrapper> orderList = new ArrayList<OrderWrapper>();
        while (resultSet.next()) {

            OrderWrapper order = new OrderWrapper();
            order.setId_order(resultSet.getInt("id_order"));
            order.setId_customer(resultSet.getInt("id_customer"));
            order.setOrder_date(resultSet.getDate("order_date"));
            order.setTotal(resultSet.getFloat("total"));
            orderList.add(order);

        }
        return orderList;
    }

    public static List<Medicine> querryMedicineByProvider(Connection connection, int id_provider) throws SQLException {
        String sql = "select * from medicine where id_provider=?;";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, String.valueOf(id_provider));
        ResultSet resultSet = statement.executeQuery();
        List<Medicine> medicineList = new ArrayList<Medicine>();
        while (resultSet.next()) {
            Medicine medicine = new Medicine();
            medicine = Medicine.initResultSet(medicine, resultSet);
            medicineList.add(medicine);

        }
        return medicineList;
    }

    public static Classification querryClassById(Connection connection, int id_class) throws SQLException {
        String sql = "select * from classification where id_class=?;";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, String.valueOf(id_class));
        ResultSet resultSet = statement.executeQuery();
        Classification classification = new Classification();
        if (resultSet.next()) {
            classification.setId_class(resultSet.getInt("id_class"));
            classification.setDescription(resultSet.getString("description"));
        }
        return classification;
    }

    public static Provider querryProviderById(Connection connection, int id_prov) throws SQLException {
        String sql = "select * from providers where id_provider=?;";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, String.valueOf(id_prov));
        ResultSet resultSet = statement.executeQuery();
        Provider provider = new Provider();
        if (resultSet.next()) {
            provider = Provider.initResultSet(provider, resultSet);

        }

        return provider;

    }

    public static Customer findCustomer(Connection conn, String customer_email) throws SQLException {

        String sql = "select * from customers where email=?";

        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, customer_email);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            Customer customer = new Customer();
            customer = customer.initResultSet(customer, rs);
            return customer;
        }
        return null;
    }

    public static Customer findCustomer(Connection conn, String email, String password) throws SQLException {

        String sql = "select * from customers where email=? and password=?;";

        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, email);
        pstm.setString(2, password);
        ResultSet rs = pstm.executeQuery();

        if (rs.next()) {

            Customer customer = new Customer();
            customer = customer.initResultSet(customer, rs);
            return customer;
        }
        return null;
    }

    public static void registerCustomer(Connection connection, String email, String password, String first_name, String last_name) throws SQLException {
        String sql = "call register_customer(?,?,?,?);";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, email);
        pstm.setString(2, password);
        pstm.setString(3, first_name);
        pstm.setString(4, last_name);
        ResultSet resultSet = pstm.executeQuery();
    }

    public static int addOrder(Connection connection, int id_customer, String date) throws SQLException {
        String sql = "insert into medonline.orders (id_customer,order_date,total) values (?,?,?);";
        PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pstm.setInt(1, id_customer);
        pstm.setString(2, date);
        pstm.setFloat(3, 1);
        int affectedRows = pstm.executeUpdate();

        if (affectedRows == 0) {
            throw new SQLException("Creating user failed, no rows affected.");
        }

        try (ResultSet generatedKeys = pstm.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                int i = generatedKeys.getInt(1);
                return i;
            } else {
                throw new SQLException("Creating user failed, no ID obtained.");
            }
        }
    }

    public static void addOrderedMedicine(Connection connection, int id_medicine, int id_order, int quantity) throws SQLException {
        String sql = "insert into ordered_medicine (id_medicine,id_order,quantity) values (?,?,?);";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setInt(1, id_medicine);
        pstm.setInt(2, id_order);
        pstm.setInt(3, quantity);
        pstm.executeUpdate();
        DBUtils.changeMedicineQuantity(connection, id_medicine, quantity);
    }

    public static void changeMedicineQuantity(Connection connection, int id_medicine, int quantity) throws SQLException {
        String sql = "set @quantity = (select quantity from medicine where id_medicine=?);";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setInt(1, id_medicine);
        pstm.executeUpdate();
        String sql2 = "update medicine set quantity=(@quantity-?) where id_medicine=?;";
        PreparedStatement pstm2 = connection.prepareStatement(sql2);
        pstm2.setInt(1, quantity);
        pstm2.setInt(2, id_medicine);
        pstm2.executeUpdate();
    }

    public static void updateTotalOrder(Connection connection, int id_order) throws SQLException {
        String sql = "update orders set total=(select sum(ordered_medicine.quantity*medicine.price) from ordered_medicine,medicine where ordered_medicine.id_medicine= medicine.id_medicine and ordered_medicine.id_order=?)where id_order=?;";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setInt(1, id_order);
        pstm.setInt(2, id_order);
        pstm.executeUpdate();

    }

    public static void deleteOrderById(Connection connection, int id_order) throws SQLException {
        String sql = "call delete_order(?); ";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, String.valueOf(id_order));
        ResultSet resultSet = statement.executeQuery();
    }

    public static void deleteMedicineById(Connection connection, int id_medicine) throws SQLException {
        String sql = "delete from medicine where id_medicine=?;";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, String.valueOf(id_medicine));
        statement.executeUpdate();
    }

    public static void deleteProviderById(Connection connection, int id_provider) throws SQLException {
        String sql = "delete from providers where id_provider=?; ";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, String.valueOf(id_provider));
        statement.executeUpdate();
    }

    public static void deleteCustomerById(Connection connection, int id_custom) throws SQLException {
        String sql = "delete from customers where id_custom=?;";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, String.valueOf(id_custom));
        statement.executeUpdate();
    }

    public static void changeCustomerToAdminById(Connection connection, int id_custom) throws SQLException {
        String sql = "update customers set role='ADMIN' where id_custom=?;";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, String.valueOf(id_custom));
        statement.executeUpdate();
    }

    public static void updateMedicine(Connection connection, int id_medicine, String name, int id_provider, float price, int quan, int id_class) throws SQLException {
        String sql = "update medicine set medicine_name=? ,id_provider=? ,price=? ,quantity=? ,id_class=? where id_medicine=?;";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, name);
        statement.setInt(2, id_provider);
        statement.setFloat(3, price);
        statement.setInt(4, quan);
        statement.setInt(5, id_class);
        statement.setInt(6, id_medicine);
        statement.executeUpdate();
    }

    public static void updateProvider(Connection connection, int id_provider, String name, String address, String city) throws SQLException {
        String sql = "update providers set providers.prov_name=? ,providers.address=? ,providers.city=? where providers.id_provider=?;";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, name);
        statement.setString(2, address);
        statement.setString(3, city);
        statement.setInt(4, id_provider);
        statement.executeUpdate();
    }

    public static void addProvider(Connection connection, String prov_name, String address, String city) throws SQLException {
        String sql = "insert into providers (prov_name, address, city) VALUES (?,?,?);";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, prov_name);
        pstm.setString(2, address);
        pstm.setString(3, city);
        pstm.executeUpdate();
    }

    public static void addMedicine(Connection connection, String medicine_name, String id_provider, String price, String quantity, String id_class) throws SQLException {
        String sql = "insert into medicine (medicine_name, id_provider, price, quantity, id_class) VALUES (?,?,?,?,?);";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, medicine_name);
        pstm.setString(2, id_provider);
        pstm.setString(3, price);
        pstm.setString(4, quantity);
        pstm.setString(5, id_class);
        pstm.executeUpdate();
    }

    public static void addClass(Connection connection, String description) throws SQLException {
        String sql = "insert into classification (description) values (?);";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, description);
        pstm.executeUpdate();
    }
}

