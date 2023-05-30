import org.json.JSONObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Reviews {
    private int reviewId;
    private int orderId;
    private int star;
    private String description;

    public Reviews() {}

    public Reviews(int reviewId, int orderId, int star, String description) {
        this.reviewId = reviewId;
        this.orderId = orderId;
        this.star = star;
        this.description = description;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public JSONObject toJsonObject() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("review_id", reviewId);
        jsonObject.put("star", star);
        jsonObject.put("description", description);
        jsonObject.put("order_id", orderId);
        return jsonObject;
    }

    public int parseReviewsJSON(String json){
        try {
            JSONObject obj = new JSONObject(json);
            star = obj.getInt("star");
            description = obj.getString("description");
            orderId = obj.getInt("order_id");
        }catch (Exception e){
            return 1;
        }
        return 0;
    }

    public void insertReview(){
        try{
            Connection conn = DatabaseConnection.getConnection();
            String sql = "INSERT INTO users (star, description, order_id) VALUES (?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, star);
            pstmt.setString(2, description);
            pstmt.setInt(3, orderId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
