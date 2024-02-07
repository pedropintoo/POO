import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.Scanner;

import Atividades.*;

// Notas:
// Não altere o código apresentado
// Deve completar o código da alinea 2
// Deve comentar o código para garantir que vai executando parcialmente

public class P002122 {

	public static void main(String[] args) throws FileNotFoundException {
		PrintStream fl = new PrintStream(new File("POO_2122Ep.txt"));
		test(System.out); // executa e escreve na consola
		test(fl); // executa e escreve no ficheiro
		fl.close();
	}

	private static void test(PrintStream out) throws FileNotFoundException {
		alinea1(out);
//		alinea2(out);
	}

	private static void alinea1(PrintStream out) {
		out.println("\nAlínea 1) ----------------------------------\n");

		EventManager grandesEventos = new EventManager("Great outdoors");

		Client c1 = grandesEventos.addClient("The best", "Aveiro");
		Client c2 = grandesEventos.addClient("Team mates", "Coimbra");
		Client c3 = grandesEventos.addClient("Cool bunch", "Viseu");

//		Event e1 = grandesEventos.addEvent(c1, LocalDate.parse("2022-06-24"));
//		e1.addActivity(new Sport(Sport.Modality.KAYAK, 12))
//			.addActivity(new Catering(Catering.Option.FULL_MENU, 10))
//			.addActivity(new Catering(Catering.Option.DRINKS_AND_SNACKS, 20));
//
//		Event e2 = grandesEventos.addEvent(c2, LocalDate.parse("2022-06-30"));
//		e2.addActivity(new Catering(Catering.Option.LIGHT_BITES, 20))
//			.addActivity(new Culture(Culture.Option.ARCHITECTURAL_TOUR, 10))
//			.addActivity(new Culture(Culture.Option.RIVER_TOUR, 10));
//
//		Event e3 = grandesEventos.addEvent(c3, LocalDate.parse("2022-06-25"));
//		e3.addActivity(new Catering(Catering.Option.DRINKS_AND_SNACKS, 20))
//			.addActivity(new Culture(Culture.Option.ART_MUSEUM, 20));
//
//		Event e4 = grandesEventos.addEvent(c1, LocalDate.parse("2022-07-10"));
//		e4.addActivity(new Sport(Sport.Modality.HIKING, 15))
//			.addActivity(new Culture(Culture.Option.WINE_TASTING, 20));
//
//
//		out.println(grandesEventos.listClients());
//		out.println();
//		out.println(grandesEventos.listEvents());

	}

//	private static void alinea2(PrintStream out) throws FileNotFoundException {
//		out.println("\nAlínea 2) ----------------------------------\n");
//		EventManager em = new EventManager("Funny Sports"); // modificar
//
//		// Adicione a seguir o código necessário para a leitura do ficheiro
//
//        Scanner input = new Scanner(new FileReader("src/events.txt"));
//
//        String line;
//        char simbol;
//        String[] content;
//
//        Client client;
//        Event event = null;
//        Activity activity = null;
//        while (input.hasNextLine()){
//            line = input.nextLine();
//            simbol = line.charAt(0);
//            content = line.substring(2).split(",");
//            switch (simbol){
//                case '#' -> {
//                            client = em.addClient(content[0],content[1]);
//                            event = em.addEvent(client,LocalDate.parse(content[2]));
//                }
//                case '*' -> {
//                    if(event != null){
//                        switch (content[0]){
//                            case "Culture" -> activity = new Culture(Culture.Option.valueOf(content[1]),Integer.parseInt(content[2]));
//                            case "Sport" -> activity = new Sport(Sport.Modality.valueOf(content[1]),Integer.parseInt(content[2]));
//                            case "Catering" -> activity = new Catering(Catering.Option.valueOf(content[1]),Integer.parseInt(content[2]));
//                        }
//                        if(activity != null){
//                            event.addActivity(activity);
//                        }
//
//                    }
//
//                }
//            }
//        }
//
//
//        // não modifique o metodo a partir daqui. Pode comentar para executar o programa
//
//		if (em != null) {
//			out.println(em + ": CLIENTES COM EVENTOS");
//			for (String s: em.clientsWithEvents())  // devolve todos os clientes com eventos agendados
//				out.println(s);
//			out.println("\n" + em + ": LISTA DE PRÓXIMOS EVENTOS ORDENADOS POR DATA");
//			for (String s: em.nextEventsByDate())  // devolve todos os eventos agendados, ordenados por data
//				out.println(s);
//			out.println();
//		}
//	}

}
