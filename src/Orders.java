import org.json.JSONObject;

public class Orders {
    private int id;
    private int buyer;
    private int note;
    private int total;
    private int discount;
    private boolean isPaid;

    public Orders() {

    }

    public Orders(int id, int buyer, int note, int total, int discount, boolean isPaid) {
        this.id = id;
        this.buyer = buyer;
        this.note = note;
        this.total = total;
        this.discount = discount;
        this.isPaid = isPaid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBuyer() {
        return buyer;
    }

    public void setBuyer(int buyer) {
        this.buyer = buyer;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public boolean getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(Boolean isPaid) {
        this.isPaid = isPaid;
    }

    public JSONObject toJsonObject() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", id);
        jsonObject.put("buyer", buyer);
        jsonObject.put("note", note);
        jsonObject.put("total", total);
        jsonObject.put("discount", discount);
        jsonObject.put("isPaid", isPaid);
        return jsonObject;
    }
}
