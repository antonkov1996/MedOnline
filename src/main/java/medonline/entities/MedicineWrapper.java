package medonline.entities;

public class MedicineWrapper extends Medicine {
    private int quantity;

    public MedicineWrapper() {
    }

    public MedicineWrapper(Medicine medicine, int quantity) {
        super.setId_class(medicine.getId_class());
        super.setId_medicine(medicine.getId_medicine());
        super.setId_provider(medicine.getId_provider());
        super.setMedicine_name(medicine.getMedicine_name());
        super.setPrice(medicine.getPrice());
        this.quantity = quantity;
    }

    public MedicineWrapper(int id_medicine, String medicine_name, int id_provider, float price, int quantity, int id_class, int quantity1) {
        super(id_medicine, medicine_name, id_provider, price, quantity, id_class);
        this.quantity = quantity1;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "MedicineWrapper{" +
                "quantity=" + quantity +
                '}';
    }
}
