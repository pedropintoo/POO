package test.TestePratico;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import java.util.Comparator;
import java.util.TreeSet;

public class PackageManager {
    // TODO: Gere as encomendas
    TreeSet<Package> allOrders = new TreeSet<>(Comparator.comparing(Package::getId));

    public void addPackage(Package pkg){
        allOrders.add(pkg);
    }
    public void removePackage(int id){
        allOrders.removeIf(pkg -> pkg.getId() == id);
    }
    public Package searchPackage(int id){
        for(Package pkg : allOrders){
            if(pkg.getId() == id) return pkg;
        }
        return null;
    }
    public double calculateShippingCost(int id){
        StandardShippingCostCalculator calculator = new StandardShippingCostCalculator();

        for(Package pkg : allOrders){
            if(pkg.getId() == id) return calculator.calculateShippingCost(pkg);
        }
        return -1;
    }
    public void printAllPackages(){
        allOrders.forEach(System.out::println);
    }
    public void generateFile(String path) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(path);

        allOrders.forEach(pkg -> out.append(pkg.getDestination()).append(";")
                                    .append(pkg.getDestination()).append(";")
                                    .append(String.valueOf(pkg.getWeight())).append(";")
                                    .append(String.valueOf(this.calculateShippingCost(pkg.getId()))).append("\n"));

        out.close();
    }


}
