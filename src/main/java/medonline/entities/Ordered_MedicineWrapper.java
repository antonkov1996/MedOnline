package medonline.entities;

public class Ordered_MedicineWrapper extends Ordered_Medicine {
    private Medicine medicine;

    public Ordered_MedicineWrapper() {
    }

    public Ordered_MedicineWrapper(int id_medicine, int id_order, int quantity, Medicine medicine) {
        super(id_medicine, id_order, quantity);
        this.medicine = medicine;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    @Override
    public String toString() {
        return "Ordered_MedicineWrapper{" +
                "medicine=" + medicine +
                '}';
    }

}
