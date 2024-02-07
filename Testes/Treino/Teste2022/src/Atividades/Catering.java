package Atividades;

public class Catering extends Activity{
    private final Option option;
    public enum Option{
        FULL_MENU("'Full menu'"),
        DRINKS_AND_SNACKS("'Drinks and Snacks'"),
        LIGHT_BITES("'Light bites'");

        private final String value;

        Option(String value){
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }
    }

    public Catering(Option option, int numParticipantes) {
        super(numParticipantes, 25);
        this.option = option;
    }

    @Override
    public String toString() {
        return "\t"+option.getValue() + " for "+super.toString();
    }

    public Option getOption() {
        return this.option;
    }
}
