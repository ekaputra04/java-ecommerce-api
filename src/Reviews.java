import org.json.JSONObject;

public class Reviews {
    private int reviewId;
    private int orderId;
    private int star;
    private String description;

    public Reviews() {
        
    }

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
        jsonObject.put("reviewId", reviewId);
        jsonObject.put("orderId", orderId);
        jsonObject.put("star", star);
        jsonObject.put("description", description);
        return jsonObject;
    }
}
