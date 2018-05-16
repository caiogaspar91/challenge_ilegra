package br.com.ilegra.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sale {
    private String salesmanName;
    private String id;
    private List<SaleItem> items;

    public Sale(String id, String salesmanName) {
        this.setSalesmanName(salesmanName);
        this.id = id;
    }

    public void addItem(SaleItem item) {
        this.addItem(Arrays.asList(item));
    }

    public void addItem(List<SaleItem> items) {
        if (this.items == null)
            this.items = new ArrayList<>();

        this.items.addAll(items);
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<SaleItem> getItems() {
        return items;
    }

    public void setItems(List<SaleItem> items) {
        this.items = items;
    }

    public String getSalesmanName() {
        return salesmanName;
    }

    public void setSalesmanName(String salesmanName) {
        this.salesmanName = salesmanName;
    }

    public Double getTotal() {
        if (this.items != null && !this.items.isEmpty())
            return this.getItems().stream().mapToDouble(SaleItem::getTotal).sum();
        return 0D;
    }
}
