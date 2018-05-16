package br.com.ilegra.data;

public class Salesman {

    private String name;
    private Double salary;
    private String cpf;

    public Salesman(String name, String cpf,Double salary){
        this.name = name;
        this.salary = salary;
        this.cpf = cpf;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
