package ex2.entity;

public class Medicine {
    private int id;
    private String medicineName;
    private int stock;

    public Medicine() {
    }

    public Medicine(int id, String medicineName, int stock) {
        this.id = id;
        this.medicineName = medicineName;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }    

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "medicine{" +
                "id=" + id +
                ", medicineName='" + medicineName + '\'' +
                ", stock=" + stock +
                '}';
    }
}