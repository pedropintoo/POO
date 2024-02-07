import Atividades.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class Event implements IEvent{
    private final LocalDate date;
    private final ArrayList<Activity> lista = new ArrayList<>();

    public Event(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("Evento em "+date.toString()+", total="+String.format("%.0f",totalPrice())+" euros\n");

        lista.forEach(activity -> str.append(activity.toString()).append("\n"));

        return str.toString();
    }

    @Override
    public Event addActivity(Activity activity) {

        for(Activity act : lista){
            if(activity instanceof Culture activityC && act instanceof Culture actC){
                if(activityC.getOption().equals(actC.getOption())){
                    return this;
                }
            }
            else if(activity instanceof Sport activityS && act instanceof Sport actS){
                if(activityS.getModality().equals(actS.getModality())){
                    return this;
                }
            }
            else if(act instanceof Catering && activity instanceof Catering){
                return this;
            }
        }

        lista.add(activity);
        return this;
    }

    @Override
    public LocalDate getDate() {
        return date;
    }

    @Override
    public double totalPrice() {
        return lista.stream()
                .mapToInt(act -> act.getNumParticipantes() * act.getPrecoParticipante())
                .sum();
    }

    // Getters


    public ArrayList<Activity> getLista() {
        return this.lista;
    }
}
