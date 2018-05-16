package br.com.ilegra.run;

import br.com.ilegra.config.FileConfig;
import br.com.ilegra.data.Customer;
import br.com.ilegra.data.FlatDataResult;
import br.com.ilegra.data.Sale;
import br.com.ilegra.data.Salesman;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.*;
import java.util.stream.Collectors;

public class DataProcessor {

    public static void execute(Map<Class, List> map, String fileName) {
        List customers = map.get(Customer.class);
        List<Sale> sales = map.get(Sale.class);
        List salesmans = map.get(Salesman.class);

        FlatDataResult result = new FlatDataResult();
        result.setAmountCustomer(customers.size());
        result.setAmountSalesman(salesmans.size());
        Optional<Sale> expensiveSale = sales.stream().max(Comparator.comparing(sale -> (sale).getTotal()));
        result.setExpensiveSale(expensiveSale.get().getId());

        Map<String, Double> totalSoldBySalesman = sales.stream().collect(Collectors.groupingBy(Sale::getSalesmanName, Collectors.summingDouble(Sale::getTotal)));
        String salesman = totalSoldBySalesman.entrySet().stream().min(Map.Entry.comparingByValue()).get().getKey();
        result.setWorstSaleman(salesman);
        writeResult(result, fileName);
    }


    private static void writeResult(FlatDataResult flatDataResult, String fileName) {
        BufferedWriter writer = null;
        try {
            File resultFile = new File(FileConfig.FILE_DIR_OUT + File.separator + fileName.replace(".dat",".done.dat"));
            writer = new BufferedWriter(new FileWriter(resultFile));
            writer.append("Amount of clients -> ").append(String.valueOf(flatDataResult.getAmountCustomer()));
            writer.newLine();
            writer.append("Amount of salesman -> ").append(String.valueOf(flatDataResult.getAmountSalesman()));
            writer.newLine();
            writer.append("Most expensive sale -> ").append(flatDataResult.getExpensiveSale());
            writer.newLine();
            writer.append("Worst salesman -> ").append(flatDataResult.getWorstSaleman());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (Exception e) {
            }
        }


    }

}
