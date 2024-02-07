package Atividades;

public class Culture extends Activity{
    private final Option option;
    public enum Option{
        ARCHITECTURAL_TOUR("Architectural tour"),
        RIVER_TOUR("River tour"),
        ART_MUSEUM("Art museum"),
        WINE_TASTING("Wine tasting");

        private final String value;

        Option(String value){
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }
    }

    public Culture(Option option, int numParticipantes) {
        super(numParticipantes, 22);
        this.option = option;
    }

    @Override
    public String toString() {
        return "\t"+option.getValue() + " with "+super.toString();
    }

    public Option getOption() {
        return this.option;
    }
}