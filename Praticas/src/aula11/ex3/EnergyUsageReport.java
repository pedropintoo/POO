package aula11.ex3;

import aula11.ex2.SimpleGradeCalculator;
import aula11.ex2.Student;

import java.io.*;
import java.util.*;

public class EnergyUsageReport {

    HashSet<Customer> clients = new HashSet<>();

    public void load(String s) throws FileNotFoundException {
        Scanner input = new Scanner(new FileReader("src/aula11/ex3/clients.txt"));

        while (input.hasNextLine()){
            // 1001|2450|3675|1980|3025
            String line = input.nextLine();
            String[] words = line.split("\\|");

            ArrayList<Double> energy = new ArrayList<>();
            for(int i = 1; i < words.length; i++){
                energy.add(Double.valueOf(words[i]));
            }
            addCustomer(new Customer (Integer.parseInt(words[0]), energy));
        }
    }


    public void addCustomer(Customer customer ) {
        clients.add(customer);
    }

    public void removeCustomer(int id) {
        clients.removeIf(student -> student.getCustomerId() == id);
    }

    public Customer getCustomer(int id) {
        for(Customer customer : clients){
            if(customer.getCustomerId() == id){
                return customer;
            }
        }
        return null;
    }

    public double calculateTotalUsage(int id) {
        double result = 0;
        for(Double energy : getCustomer(id).getMeterReadings()){
            result += energy;
        }
        return result;
    }


    public void generateReport(String file) throws IOException {
        PrintWriter out = new PrintWriter("src/aula11/ex3/"+file);
        for(Customer customer : clients){
            out.println(customer);
        }
        out.close();
    }
}
