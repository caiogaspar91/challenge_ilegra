package br.com.ilegra.strategy;

import br.com.ilegra.data.Customer;
import br.com.ilegra.data.Salesman;

class SalesmanFlatDataStrategy implements FlatDataStrategyInterface<Salesman> {

    @Override
    public Class getDataClass() {
        return Salesman.class;
    }

    @Override
    public Salesman processFlatData(String[] salesmanSplit) {
        return new Salesman(salesmanSplit[1], salesmanSplit[2],Double.parseDouble(salesmanSplit[3]));
    }
}
