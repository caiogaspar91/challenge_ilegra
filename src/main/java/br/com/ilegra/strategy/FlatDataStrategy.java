package br.com.ilegra.strategy;

public class FlatDataStrategy {

    public Object process(String flatData) {

        String[] flatSplit = flatData.split("ç");
        if (flatSplit.length < 4) {
            return null;
        }
        return getStrategy(flatData).processFlatData(flatSplit);
    }

    public Class getClassFlat(String flatData) {
        return getStrategy(flatData).getDataClass();
    }


    private FlatDataStrategyInterface getStrategy(String flatData) {
        if (flatData.startsWith("001")) {
            return new SalesmanFlatDataStrategy();
        } else if (flatData.startsWith("002")) {
            return new CustomerFlatDataStrategy();
        } else if (flatData.startsWith("003")) {
            return new SaleFlatDataStrategy();
        }
        return null;
    }

}
