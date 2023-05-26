public class OrderDetails {
    private int order;
    private int product;
    private int quantity;
    private int price;

    public OrderDetails(int order, int product, int quantity, int price){
        this.order = order;
        this.product = product;
        this.quantity =quantity;
        this.price = price;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
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
}
