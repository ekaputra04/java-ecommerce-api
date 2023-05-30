import org.json.JSONObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 * Class ini digunakan sebagai model dari tabel order_details
 */

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

    public int parseOrderDetailsJSON(String json) {
        try {
            JSONObject obj = new JSONObject(json);
            orderId = obj.getInt("order_id");
            product = obj.getInt("product");
            quantity = obj.getInt("quantity");
            price = obj.getInt("price");
        } catch (Exception e) {
            return 1;
        }
        return 0;
    }

    public void insertOrderDetails() {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "INSERT INTO order_details (order_id, product, quantity, price) VALUES (?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, orderId);
            pstmt.setInt(2, product);
            pstmt.setInt(3, quantity);
            pstmt.setInt(4, price);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateOrderDetails(String idOrderDetails) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "UPDATE order_details SET order_id = \"" + orderId +
                    "\" , product = \"" + product +
                    "\" , quantity = \"" + quantity +
                    "\" , price = \"" + price +
                    "\" WHERE order_id = " + idOrderDetails;
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
