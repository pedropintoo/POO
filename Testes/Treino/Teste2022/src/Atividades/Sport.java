package Atividades;

public class Sport extends Activity{
    private final Modality modality;
    public enum Modality{
        KAYAK("Kayak"),
        HIKING("Hiking"),
        BIKE("Bike"),
        BOWLING("Bowling");

        private final String value;

        Modality(String value){
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }
    }

    public Sport(Modality modality, int numParticipantes) {
        super(numParticipantes, 30);
        this.modality = modality;
    }

    @Override
    public String toString() {
        return "\t"+modality.getValue() + " sporting activity with "+super.toString();
    }

    public Modality getModality() {
        return this.modality;
    }
}
