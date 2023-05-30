import org.json.JSONObject;

public class OrderDetails {
    private int orderId;
    private int product;
    private int quantity;
    private int price;

    public OrderDetails() {

    }

    public OrderDetails(int orderId, int product, int quantity, int price) {
        this.orderId = orderId;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProduct() {
        return product;
    }

    public void setProduct(int product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public JSONObject toJsonObject() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("order_id", orderId);
        jsonObject.put("product", product);
        jsonObject.put("quantity", quantity);
        jsonObject.put("price", price);
        return jsonObject;
    }
}
