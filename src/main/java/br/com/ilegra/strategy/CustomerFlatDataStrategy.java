package br.com.ilegra.strategy;

import br.com.ilegra.data.Customer;

class CustomerFlatDataStrategy implements FlatDataStrategyInterface<Customer>{

    @Override
    public Class getDataClass() {
        return Customer.class;
    }

    @Override
    public Customer processFlatData(String[] customerSplit) {
        return new Customer(customerSplit[1],customerSplit[2],customerSplit[3]);
    }
}
