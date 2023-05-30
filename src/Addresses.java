import org.json.JSONObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Addresses {
    private int users;
    private String type;
    private String line1;
    private String line2;
    private String city;
    private String province;
    private String postcode;

    public Addresses() {}

    public Addresses(int users, String type, String line1, String line2, String city, String province,
            String postcode) {
        this.users = users;
        this.type = type;
        this.line1 = line1;
        this.line2 = line2;
        this.city = city;
        this.province = province;
        this.postcode = postcode;
    }

    public int getUsers() {
        return users;
    }

    public void setUsers(int users) {
        this.users = users;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public JSONObject toJsonObject() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", users);
        jsonObject.put("tipe", type);
        jsonObject.put("line1", line1);
        jsonObject.put("line2", line2);
        jsonObject.put("city", city);
        jsonObject.put("province", province);
        jsonObject.put("postcode", postcode);
        return jsonObject;
    }

    public int parseJson(String json){
        try {
            JSONObject obj = new JSONObject(json);
            type = obj.getString("tipe");
            line1 = obj.getString("line1");
            line2 = obj.getString("line2");
            city = obj.getString("city");
            province = obj.getString("province");            
            postcode = obj.getString("postcode");
        }catch (Exception e){
            return 1;
        }
        return 0;
    }

    public int parseAddressesJSON(String json){
        try {
            JSONObject obj = new JSONObject(json);
            type = obj.getString("tipe");
            line1 = obj.getString("line1");
            line2 = obj.getString("line2");
            city = obj.getString("city");
            province = obj.getString("province");
            postcode = obj.getString("postcode");
        }catch (Exception e){
            return 1;
        }
        return 0;
    }

    public void insertAddress(){
        try{
            Connection conn = DatabaseConnection.getConnection();
            String sql = "INSERT INTO addresses (tipe, line1, line2, city, province, postcode) VALUES (?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, type);
            pstmt.setString(2, line1);
            pstmt.setString(3, line2);
            pstmt.setString(4, city);
            pstmt.setString(5, province);
            pstmt.setString(6, postcode);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }        
    }

    public void updateAddress(String idAddress) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "UPDATE addresses SET tipe = \"" + type +
                    "\" , line1 = \"" + line1 +
                    "\" , line2 = \"" + line2 +
                    "\" , city = \"" + city +
                    "\" , province = \"" + province +
                    "\" , postcode = \"" + postcode +
                    "\" WHERE id = " + idAddress;
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
