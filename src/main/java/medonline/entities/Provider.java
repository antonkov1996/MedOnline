package medonline.entities;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Provider {
    private int id_provider;
    private String prov_name;
    private String address;
    private String city;

    public Provider() {
    }

    public Provider(int id_provider, String prov_name, String address, String city) {
        this.id_provider = id_provider;
        this.prov_name = prov_name;
        this.address = address;
        this.city = city;
    }

    public int getId_provider() {
        return id_provider;
    }

    public void setId_provider(int id_provider) {
        this.id_provider = id_provider;
    }

    public String getProv_name() {
        return prov_name;
    }

    public void setProv_name(String prov_name) {
        this.prov_name = prov_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Provider{" +
                "id_provider=" + id_provider +
                ", prov_name='" + prov_name + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public static Provider initResultSet(Provider provider, ResultSet rs) throws SQLException {
        provider.setId_provider(rs.getInt("id_provider"));
        provider.setProv_name(rs.getString("prov_name"));
        provider.setAddress(rs.getString("address"));
        provider.setCity(rs.getString("city"));
        return provider;
    }
}
