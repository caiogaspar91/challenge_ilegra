package br.com.ilegra.strategy;

public interface FlatDataStrategyInterface<T> {

    Class getDataClass();
    T processFlatData(String[] flatData);


}
