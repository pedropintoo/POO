import Entidades.*;

public class Jogo {
    private final Equipa equipa1;
    private final Equipa equipa2;
    private final Bola bola;
    private final int tempoTotal;
    private int tempoDecorrido;

    public Jogo(Equipa equipa1, Equipa equipa2, Bola bola, int tempoTotal) {
        this.equipa1 = equipa1;
        this.equipa2 = equipa2;
        this.bola = bola;
        this.tempoTotal = tempoTotal;
    }

    @Override
    public String toString() {
        return " Jogo entre "+equipa1.getNome()+" e "+equipa2.getNome();
    }
}
