package test.TestePratico;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.Scanner;

public class PackagingTester {
    // TODO: Tester for PackageManager
    public static void main(String[] args) throws FileNotFoundException {
        PackageManager packageManager = new PackageManager();


        packageManager.addPackage(new Package(55, 20,"Aveiro","Lisboa"));
        packageManager.addPackage(new Package(56, 12,"Porto","Coimbra"));
        packageManager.addPackage(new Package(57, 14,"Braga","Lisboa"));
        packageManager.addPackage(new Package(58, 7,"Viseu","Porto"));
        packageManager.addPackage(new Package(59, 2,"Coimbra","Lisboa"));
        packageManager.addPackage(new Package(60, 9,"Portimão","Coimbra"));

        packageManager.removePackage(57);

        Scanner input = new Scanner(new FileReader("src/test/TestePratico/encomendas.txt"));
        String cabecalho = input.nextLine();

        int index;
        double weight;
        String destination;
        String sender;

        while (input.hasNextLine()){
            String[] line = input.nextLine().split("; ");
            index = Integer.parseInt(line[0]);
            weight = Double.parseDouble(line[1]);
            destination = line[2];
            sender = line[3];
            packageManager.addPackage(new Package(index, weight, destination, sender));
        }

        Package pkg7 = packageManager.searchPackage(7);

        System.out.println("Encomenda [7] -> "+pkg7);
        System.out.println("Preço -> "+packageManager.calculateShippingCost(pkg7.getId()));

        System.out.println();
        packageManager.printAllPackages();

        packageManager.generateFile("src/test/TestePratico/relatorio.txt");


    }
}
