import java.time.LocalDate;
import Atividades.*;

public interface IEvent {
    Event addActivity(Activity activity);
    LocalDate getDate();
    double totalPrice();
}
