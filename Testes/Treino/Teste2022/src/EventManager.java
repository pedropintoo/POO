import java.time.LocalDate;
import java.util.*;
import Atividades.*;

public class EventManager {
    private final String nome;
    private final Map<Client, ArrayList<Event>> lista = new LinkedHashMap<>();

    public EventManager(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }

    public String listClients(){
        StringBuilder str = new StringBuilder("Clients:\n");
        lista.keySet().forEach(k -> str.append(k).append("\n"));
        return str.toString();
    }

    public String[] clientsWithEvents(){
        StringBuilder str = new StringBuilder();
        lista.keySet().stream()
                .filter(k -> lista.get(k).size() > 0)
                .forEach(k -> str.append(k).append(","));
        return str.toString().split(",");
    }

    public String[] nextEventsByDate(){
        StringBuilder str = new StringBuilder();
        TreeSet<Event> allEvents = new TreeSet<>(Comparator.comparing(Event::getDate));
        lista.values().forEach(allEvents::addAll);

        String[] strings = new String[allEvents.size()];
        int i = 0;
        for(Event event : allEvents){
            strings[i] = event.toString();
            i++;
        }
        return strings;
    }

    public String listEvents(){
        StringBuilder str = new StringBuilder("Events:\n");
        lista.forEach((k,v) -> {
            str.append(k).append("\n");
            v.forEach(event -> str.append("*** ").append(event.toString()).append("\n"));
        });

        return str.toString();
    }

    public Client addClient(String nome, String localidade){
        Client client = new Client(nome, localidade);
        if(!isClient(client)){
            lista.put(client,new ArrayList<>());
        }
        return client;
    }

    public Event addEvent(Client client, LocalDate date){
        if(!isClient(client) ||
                lista.get(client).stream()
                        .filter(event -> event.getDate().equals(date))
                        .toList().size() != 0){
            return null; // se nao for cliente ou se tiver um evento com a mesma data
        }
        Event event = new Event(date);
        lista.get(client).add(event);
        return event;
    }

    public boolean isClient(Client client){
        return lista.containsKey(client);
    }

    // Getters
    public String getNome() {
        return this.nome;
    }

    public Map<Client, ArrayList<Event>> getLista() {
        return this.lista;
    }
}
