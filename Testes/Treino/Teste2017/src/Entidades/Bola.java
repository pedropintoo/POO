package Entidades;

public class Bola extends ObjetoMovel{
    private final CorDaBola corDaBola;
    private static int nBolas = 0;

    public Bola(CorDaBola corDaBola) {
        super(0,0);
        this.corDaBola = corDaBola;
        nBolas++;
    }

    // Getters

    public CorDaBola getCorDaBola() {
        return this.corDaBola;
    }

    public static int getnBolas(){
        return nBolas;
    }
}
