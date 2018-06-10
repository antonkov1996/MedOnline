package medonline.entities;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Ordered_Medicine {
    private int id_medicine;
    private int id_order;
    private int quantity;

    public Ordered_Medicine() {
    }

    public Ordered_Medicine(int id_medicine, int id_order, int quantity) {
        this.id_medicine = id_medicine;
        this.id_order = id_order;
        this.quantity=quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getId_medicine() {
        return id_medicine;
    }

    public void setId_medicine(int id_medicine) {
        this.id_medicine = id_medicine;
    }

    public int getId_order() {
        return id_order;
    }

    public void setId_order(int id_order) {
        this.id_order = id_order;
    }

    @Override
    public String toString() {
        return "Ordered_Medicine{" +
                "id_medicine=" + id_medicine +
                ", id_order=" + id_order +
                ", quantity=" + quantity +
                '}';
    }

    public static Ordered_Medicine initResultSet(Ordered_Medicine orderedMedicine, ResultSet rs) throws SQLException {
        orderedMedicine.setId_medicine(rs.getInt("id_medicine"));
        orderedMedicine.setId_order(rs.getInt("id_order"));
        orderedMedicine.setQuantity(rs.getInt("quantity"));
        return orderedMedicine;
    }
}
