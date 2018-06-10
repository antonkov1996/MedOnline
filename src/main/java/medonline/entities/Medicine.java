package medonline.entities;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Medicine {
    private int id_medicine;
    private String medicine_name;
    private int id_provider;
    private float price;
    private int quantity;
    private int id_class;

    public Medicine() {
    }

    public Medicine(int id_medicine, String medicine_name, int id_provider, float price, int quantity, int id_class) {
        this.id_medicine = id_medicine;
        this.medicine_name = medicine_name;
        this.id_provider = id_provider;
        this.price = price;
        this.quantity = quantity;
        this.id_class = id_class;
    }

    public int getId_medicine() {
        return id_medicine;
    }

    public void setId_medicine(int id_medicine) {
        this.id_medicine = id_medicine;
    }

    public String getMedicine_name() {
        return medicine_name;
    }

    public void setMedicine_name(String medicine_name) {
        this.medicine_name = medicine_name;
    }

    public int getId_provider() {
        return id_provider;
    }

    public void setId_provider(int id_provider) {
        this.id_provider = id_provider;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getId_class() {
        return id_class;
    }

    public void setId_class(int id_class) {
        this.id_class = id_class;
    }


    @Override
    public String toString() {
        return "Medicine{" +
                "id_medicine=" + id_medicine +
                ", medicine_name='" + medicine_name + '\'' +
                ", id_provider=" + id_provider +
                ", price=" + price +
                ", quantity=" + quantity +
                ", id_class=" + id_class +
                '}';
    }

    public static Medicine initResultSet(Medicine medicine, ResultSet resultSet) throws SQLException {
        medicine.setId_medicine(resultSet.getInt("id_medicine"));
        medicine.setMedicine_name(resultSet.getString("medicine_name"));
        medicine.setId_provider(resultSet.getInt("id_provider"));
        medicine.setPrice(resultSet.getFloat("price"));
        medicine.setQuantity(resultSet.getInt("quantity"));
        medicine.setId_class(resultSet.getInt("id_class"));
        return medicine;
    }
}
