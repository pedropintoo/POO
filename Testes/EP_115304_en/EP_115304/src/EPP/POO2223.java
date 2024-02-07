package POO2223;

import POO2223.Storage.GarageStorage;
import POO2223.Storage.LockerStorage;
import POO2223.Storage.StorageUnit;
import POO2223.Storage.WarehouseStorage;
import POO2223.Storage.UnitType;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// Notes:
// Não altere o código apresentado *** Do not change the code shown
// Deve apenas completar o código de alinea2, onde indicado *** You should only change the code where indicated in alinea2
// Deve comentar o código para garantir que vai executando parcialmente *** You may comment the code to test and execute partially

public class POO2223 {

	public static void main(String[] args) throws FileNotFoundException {
		PrintStream fl = new PrintStream(new File("POO_2223EP.txt"));
		test(System.out); // executa e escreve na consola *** executes and writes to console 
		test(fl); // executa e escreve no ficheiro *** executes and writes to file
		fl.close();
	}

	private static void test(PrintStream out) {
		alinea1(out);
		//alinea2(out);
	}

	// DO NOT CHANGE THIS METHOD
	// CREATE THE CLASS DEFINITIONS ACCORDING TO THE DESCRIPTION IN THE EXAM AND THE CODE BELOW
	private static void alinea1(PrintStream out) {
		out.println("\nAlínea 1) ----------------------------------\n");

		/*
		** Creating StorageService; Registering clients; Adding storage units
		*/

		StorageService storageService = new StorageService("StorageSolutions", "Zona Industrial da Taboeira, Aveiro");

		// Registering 4 clients
		storageService.registerClient(123456789, "João Sousa", ClientType.PERSONAL);
		storageService.registerClient(234567890, "Ana Pereira", ClientType.PERSONAL);
		storageService.registerClient(501234567, "Arlindo Marques, Unipessoal", ClientType.ENTERPRISE);
		storageService.registerClient(501987654, "A Tralha", ClientType.ENTERPRISE);

		// Adding 2 warehouse units
		StorageUnit warehouse1 = new WarehouseStorage("Taboeira, Aveiro", new int[]{300, 1500, 300}, 200);
		StorageUnit warehouse2 = new WarehouseStorage("Taboeira, Aveiro", new int[]{300, 1200, 300}, 120);
		storageService.addStorageUnit(warehouse1);
		storageService.addStorageUnit(warehouse2);
		
		// Adding 3 garage units
		StorageUnit[] garages = new StorageUnit[]{
			new GarageStorage("Taboeira, Aveiro", new int[]{280, 400, 250}, 60),
			new GarageStorage("Taboeira, Aveiro", new int[]{280, 500, 250}, 80),
			new GarageStorage("Taboeira, Aveiro", new int[]{300, 600, 280}, 90)
		};
		storageService.addStorageUnits(Arrays.asList(garages));

		// Adding 6 lockers, all of the same size
		for (int i=0; i<6; i++) {
			storageService.addStorageUnit(new LockerStorage("Aveiro (Estação CP)", new int[]{30, 50, 30}, 10));
		}
		// Adding 6 larger lockers
		for (int i=0; i<6; i++) {
			storageService.addStorageUnit(new LockerStorage("Aveiro (Estação CP)", new int[]{60, 80, 50}, 20));
		}


		/*
		** Rent storage units
		*/

		// PERSONAL client can not rent a warehouse
		Client c1 = storageService.getClient(123456789);
		Boolean result = storageService.rentStorageUnit(c1, warehouse1, LocalDate.of(2023, 6, 1), 180);
		if (!result) {
			out.printf("** Could not book rental of %s unit for client %s.\n", warehouse1.getType(), c1);
		}		

		// ENTERPRISE client can rent a warehouse
		Client c2 = storageService.getClient(501234567);
		result = storageService.rentStorageUnit(c2, warehouse1, LocalDate.of(2023, 6, 1), 180);
		if (!result) {
			out.printf("** Could not book rental of %s unit for client %s.\n", warehouse1.getType(), c2);
		}		

		// Client c1 rents a garage unit
		StorageUnit g1 = garages[0];
		result = storageService.rentStorageUnit(c1, g1, LocalDate.of(2023, 6, 1), 90);
		if (!result) {
			out.printf("** Could not book rental of %s unit for client %s.\n", g1.getType(), c1);
		}		

		// Same garage unit cannot be rented during the same period
		Client c3 = storageService.getClient(234567890);
		result = storageService.rentStorageUnit(c3, g1, LocalDate.of(2023, 8, 1), 60);
		if (!result) {
			out.printf("** Could not book rental of %s unit for client %s.\n", g1.getType(), c3);
		}

		// Client c3 rents different garage unit
		StorageUnit g2 = garages[1];
		result = storageService.rentStorageUnit(c3, g2, LocalDate.of(2023, 8, 1), 60);
		if (!result) {
			out.printf("** Could not book rental of %s unit for client %s.\n", g2.getType(), c3);
		}


		/*
		** List rentals
		*/
		List<String> rentals = storageService.listRentals();
		if (!rentals.isEmpty()) {
			out.println("\n** Current rentals");
			rentals.forEach(out::print);
		}
		
	}

	// CHANGE THIS METHOD ONLY WHERE INDICATED
	private static void alinea2(PrintStream out) throws FileNotFoundException {
		out.println("\n\nAlínea 2) ----------------------------------\n");


		//** Creating StorageService; Registering clients; Adding storage units


		StorageService storageService = new StorageService("Storit", "Oiã");

		// Registering clients
		storageService.registerClient(123456789, "João Sousa", ClientType.PERSONAL);
		storageService.registerClient(150987654, "Ana Pereira", ClientType.PERSONAL);
		storageService.registerClient(157894320, "Carla Moura", ClientType.PERSONAL);
		storageService.registerClient(501234567, "Arlindo Marques, Unipessoal", ClientType.ENTERPRISE);
		storageService.registerClient(501987654, "A Tralha", ClientType.ENTERPRISE);
		storageService.registerClient(505321987, "Patudos, LDA", ClientType.ENTERPRISE);

		// Adding warehouse units
		storageService.addStorageUnit(new WarehouseStorage("Taboeira, Aveiro", new int[]{500, 2000, 400}, 200));
		storageService.addStorageUnit(new WarehouseStorage("Taboeira, Aveiro", new int[]{300, 1500, 300}, 200));
		storageService.addStorageUnit(new WarehouseStorage("Taboeira, Aveiro", new int[]{300, 1200, 300}, 120));
		
		// Adding garage units
		storageService.addStorageUnit(new GarageStorage("Taboeira, Aveiro", new int[]{280, 400, 250}, 60));
		storageService.addStorageUnit(new GarageStorage("Taboeira, Aveiro", new int[]{280, 500, 250}, 80));
		storageService.addStorageUnit(new GarageStorage("Taboeira, Aveiro", new int[]{300, 600, 280}, 90));

		// Adding lockers
		for (int i=0; i<6; i++) {
			storageService.addStorageUnit(new LockerStorage("Aveiro (Estação CP)", new int[]{50, 50, 50}, 10));
			storageService.addStorageUnit(new LockerStorage("Aveiro (Estação CP)", new int[]{60, 80, 50}, 20));
		}

		

		//** Adicione a seguir o código necessário para a leitura do ficheiro e registo dos alugueres.
		//** Add the code to read from file and register the bookings.

		// # Fields
		// # Client tax id; rental start date; rental duration; type of storage unit; minimum dimensions
		// 123456789;2023-06-01;150;WAREHOUSE;200x300x250

		Scanner input = new Scanner(new File("src/POO2223/bookings.txt"));

		input.nextLine();
		input.nextLine();

		Client client;
		Rental rental;
		String[] content;
		StorageUnit storageUnit;
		String[] dim;
		int size;
		while (input.hasNextLine()){
			content = input.nextLine().split(";");

			dim = content[3].split("x");
			size = Integer.parseInt(dim[0]) * Integer.parseInt(dim[1]) * Integer.parseInt(dim[2]);

			client = storageService.getClient(Integer.parseInt(content[0]));
			rental = new Rental(LocalDate.parse(content[1]), LocalDate.parse(content[1]).plusDays(Long.parseLong(content[2])));
			storageService.getAvailableUnitsBySize(LocalDate.parse(content[1]), size);
		}



		//** Não modifique o metodo a partir daqui. Pode comentar para executar o programa.
		//** Do not modify the method from this point on. You may comment to excute the programme.


		out.println("\n"+ storageService + ": Finished reading file.\n\n");
		
		// Deve devolver uma lista vazia (ou null) pois não existem garagens com a dimensão indicada (ou maiores)
		// This should return empty (or null) since there are no garage units with the required dimensions (or larger)
		out.println("Looking for garage with dimensions 300x400x300");
		List<StorageUnit> available = storageService.findAvailableUnits(UnitType.GARAGE, LocalDate.of(2023, 6, 1),90, new int[]{300, 400, 300});
		if (available==null || available.isEmpty()) {
			out.println("** No options available for the type, dimensions, and dates requested.\n");
		} else {
			StorageUnit u = available.get(0);
			out.printf("%s, is available for a total price of %.2f.\n", u, storageService.calculateTotalCost(u, 90));
		}

		// Deve devolver uma lista de unidades de arrumação disponíveis
		// This should return a list of available storage units
		out.println("Looking for garage with dimensions 300x400x280");
		available = storageService.findAvailableUnits(UnitType.GARAGE, LocalDate.of(2023, 6, 1),90, new int[]{300, 400, 280});
		if (available==null || available.isEmpty()) {
			out.println("** No options available for the type, dimensions, and dates requested.\n");
		} else {
			StorageUnit u = available.get(0);
			out.printf("%s, is available for a total price of %.2f.\n", u, storageService.calculateTotalCost(u, 90));
		}

		// listar todas as unidades disponíveis a partir de 2023/12/01 por 100 dias, por ordem decrescente de volume total
		// list all available units from 2023/12/01 for 100 days, in decreasing order of total volume
		out.println("\n\n" + storageService + ": AVAILABLE UNITS BY SIZE");
		storageService.getAvailableUnitsBySize(LocalDate.of(2023, 12, 1), 100).forEach(out::println);

		out.println();


	}

}
