public enum SensitivityLevel {
    PERSONAL("Personal"),
    RESTRICTED("Restricted"),
    LOW("Low");

    private String value;
    SensitivityLevel(String value){
        this.value = value;
    }

    @Override
    public String toString(){
        return value;
    }
}
