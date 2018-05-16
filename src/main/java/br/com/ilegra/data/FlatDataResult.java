package br.com.ilegra.data;

public class FlatDataResult {

    private Integer amountCustomer;
    private Integer amountSalesman;
    private String expensiveSale;
    private String worstSaleman;



    public Integer getAmountCustomer() {
        return amountCustomer;
    }

    public void setAmountCustomer(Integer amountCustomer) {
        this.amountCustomer = amountCustomer;
    }

    public Integer getAmountSalesman() {
        return amountSalesman;
    }

    public void setAmountSalesman(Integer amountSalesman) {
        this.amountSalesman = amountSalesman;
    }

    public String getExpensiveSale() {
        return expensiveSale;
    }

    public void setExpensiveSale(String expensiveSale) {
        this.expensiveSale = expensiveSale;
    }

    public String getWorstSaleman() {
        return worstSaleman;
    }

    public void setWorstSaleman(String worstSaleman) {
        this.worstSaleman = worstSaleman;
    }
}
