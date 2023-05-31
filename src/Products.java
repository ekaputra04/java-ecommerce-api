import org.json.JSONObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 * Class ini digunakan sebagai model dari tabel products
 */

public class Products {
    private int id;
    private int seller;
    private String title;
    private String description;
    private String price;
    private int stock;

    public Products() {
    }

    public Products(int id, int seller, String title, String description, String price, int stock) {
        this.id = id;
        this.seller = seller;
        this.title = title;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeller() {
        return seller;
    }

    public void setSeller(int seller) {
        this.seller = seller;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public JSONObject toJsonObject() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", id);
        jsonObject.put("seller", seller);
        jsonObject.put("title", title);
        jsonObject.put("description", description);
        jsonObject.put("price", price);
        jsonObject.put("stock", stock);
        return jsonObject;
    }

    public int parseProductsJSON(String json) {
        try {
            JSONObject obj = new JSONObject(json);
            seller = obj.getInt("seller");
            title = obj.getString("title");
            description = obj.getString("description");
            price = obj.getString("price");
            stock = obj.getInt("stock");
        } catch (Exception e) {
            return 1;
        }
        return 0;
    }

    public void insertProduct() {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "INSERT INTO products (seller, title, description, price, stock) VALUES (?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, seller);
            pstmt.setString(2, title);
            pstmt.setString(3, description);
            pstmt.setString(4, price);
            pstmt.setInt(5, stock);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateProduct(String idProduct) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "UPDATE products SET seller = \"" + seller +
                    "\" , title = \"" + title +
                    "\" , description = \"" + description +
                    "\" , price = \"" + price +
                    "\" , stock = \"" + stock +
                    "\" WHERE id = " + idProduct;
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
