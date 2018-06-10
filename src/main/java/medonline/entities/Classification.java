package medonline.entities;

public class Classification {
    private int id_class;
    private String description;

    public Classification() {
    }

    public Classification(int id_class, String description) {
        this.id_class = id_class;
        this.description = description;
    }

    public int getId_class() {
        return id_class;
    }

    public void setId_class(int id_class) {
        this.id_class = id_class;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
