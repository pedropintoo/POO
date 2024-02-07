package Atividades;

public abstract class Activity {
    private final int numParticipantes;
    private final int precoParticipante;

    public Activity(int numParticipantes, int precoParticipante) {
        this.numParticipantes = numParticipantes;
        this.precoParticipante = precoParticipante;
    }

    @Override
    public String toString() {
        return numParticipantes + " participants";
    }

    // Getters
    public int getNumParticipantes() {
        return this.numParticipantes;
    }

    public int getPrecoParticipante() {
        return this.precoParticipante;
    }

}
