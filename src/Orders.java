import org.json.JSONObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 * Class ini digunakan sebagai model dari tabel orders
 */

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
        jsonObject.put("is_paid", isPaid);
        return jsonObject;
    }

    public int parseOrdersJSON(String json) {
        try {
            JSONObject obj = new JSONObject(json);
            buyer = obj.getInt("buyer");
            note = obj.getInt("note");
            total = obj.getInt("total");
            discount = obj.getInt("discount");
            isPaid = obj.getBoolean("is_paid");
        } catch (Exception e) {
            return 1;
        }
        return 0;
    }

    public void insertOrder() {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "INSERT INTO orders (buyer, note, total, discount, is_paid) VALUES (?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, buyer);
            pstmt.setInt(2, note);
            pstmt.setInt(3, total);
            pstmt.setInt(4, discount);
            pstmt.setBoolean(5, isPaid);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateOrder(String idOrder) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "UPDATE orders SET buyer = \"" + buyer +
                    "\" , note = \"" + note +
                    "\" , total = \"" + total +
                    "\" , discount = \"" + discount +
                    "\" , is_paid = \"" + isPaid +
                    "\" WHERE id = " + idOrder;
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
