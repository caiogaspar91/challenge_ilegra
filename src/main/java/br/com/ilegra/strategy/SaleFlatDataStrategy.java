package br.com.ilegra.strategy;

import br.com.ilegra.data.Sale;
import br.com.ilegra.data.SaleItem;

import java.util.ArrayList;
import java.util.List;

class SaleFlatDataStrategy implements FlatDataStrategyInterface<Sale> {

    @Override
    public Class getDataClass() {
        return Sale.class;
    }

    @Override
    public Sale processFlatData(String[] saleSplit) {
        Sale sale = new Sale(saleSplit[1], saleSplit[3]);
        sale.addItem(getSaleItems(saleSplit[2]));
        return sale;
    }

    private List<SaleItem> getSaleItems(String itemsString) {
        String[] itemsSplit = itemsString.replace("[","").replace("]","").split(",");
        List<SaleItem> items = new ArrayList<>();

        for (String item : itemsSplit) {
            String[] itemSplit = item.split("-");
            if (itemSplit.length == 3) {
                items.add(new SaleItem(itemSplit[0], Integer.parseInt(itemSplit[1]), Double.parseDouble(itemSplit[2])));
            }
        }

        return items;
    }
}
