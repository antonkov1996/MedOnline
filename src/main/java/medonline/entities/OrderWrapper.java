package medonline.entities;

import java.util.Date;
import java.util.List;

public class OrderWrapper extends Order {
    private Customer customer;
    private List<Ordered_MedicineWrapper> ordered_medicineList;

    public OrderWrapper() {
    }

    public OrderWrapper(int id_order, int id_customer, Date order_date, float total, Customer customer, List<Ordered_MedicineWrapper> ordered_medicineList) {
        super(id_order, id_customer, order_date, total);

        this.customer = customer;
        this.ordered_medicineList = ordered_medicineList;
    }

    public List<Ordered_MedicineWrapper> getOrdered_medicineList() {
        return ordered_medicineList;
    }

    public void setOrdered_medicineList(List<Ordered_MedicineWrapper> ordered_medicineList) {
        this.ordered_medicineList = ordered_medicineList;
    }



    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    @Override
    public String toString() {
        return "OrderWrapper{" +
                ", customer=" + customer +
                ", ordered_medicineList=" + ordered_medicineList +
                '}';
    }
}
