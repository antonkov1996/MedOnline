package medonline.entities;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Customer {
    private int id_custom;
    private String email;
    private String password;
    private String first_name;
    private String last_name;
    private String role;

    public Customer() {
    }

    public Customer(int id_custom, String email, String password, String first_name, String last_name, String role) {
        this.id_custom = id_custom;
        this.email = email;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.role = role;
    }

    public int getId_custom() {
        return id_custom;
    }

    public void setId_custom(int id_custom) {
        this.id_custom = id_custom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id_custom=" + id_custom +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    public static Customer initResultSet(Customer customer, ResultSet rs) throws SQLException {
        customer.setId_custom(rs.getInt("id_custom"));
        customer.setEmail(rs.getString("email"));
        customer.setPassword(rs.getString("password"));
        customer.setFirst_name(rs.getString("first_name"));
        customer.setLast_name(rs.getString("last_name"));
        customer.setRole(rs.getString("role"));
        return customer;
    }
}
