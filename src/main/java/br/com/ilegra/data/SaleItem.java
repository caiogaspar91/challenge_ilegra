package br.com.ilegra.data;

public class SaleItem {

    private String id;
    private Integer quantity;
    private Double price;
    private Double total;

    public SaleItem(String id, Integer quantity, Double price) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        total = price * quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
