import java.time.LocalDate;

public class DigitalObject {
    private LocalDate dataCriacao;
    private String doi;
    private User owner;
    private boolean partilha;

    private SensitivityLevel sensitivityLevel;

    public DigitalObject(String doi) {
        this.doi = doi;
        this.dataCriacao = LocalDate.now();
        this.sensitivityLevel = SensitivityLevel.PERSONAL;
    }

    public DigitalObject(String doi, SensitivityLevel sensitivityLevel) {
        this.doi = doi;
        this.dataCriacao = LocalDate.now();
        this.sensitivityLevel = sensitivityLevel;

    }


    @Override
    public String toString() {
        return "DOI: "+doi+"; Created: "+dataCriacao.toString()+"; Level: "+sensitivityLevel.toString()+"; "+(partilha?"Public":"");
    }

    // Getters

    public boolean isPartilha() {
        return this.partilha;
    }

    public LocalDate getDataCriacao() {
        return this.dataCriacao;
    }

    public String getDoi() {
        return this.doi;
    }

    public User getOwner() {
        return this.owner;
    }

    public SensitivityLevel getSensitivityLevel() {
        return this.sensitivityLevel;
    }


    // Setters


    public void setPartilha(boolean partilha) {
        this.partilha = partilha;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public void setSensitivityLevel(SensitivityLevel sensitivityLevel) {
        this.sensitivityLevel = sensitivityLevel;
    }
}
