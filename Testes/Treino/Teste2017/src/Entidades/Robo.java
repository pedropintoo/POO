package Entidades;

public class Robo extends ObjetoMovel{
    private final String id;
    private final TipoJogador tipoJogador;
    private int golosMarcados;

    public Robo(String id, TipoJogador tipoJogador, int x, int y) {
        super(x, y);
        this.id = id;
        this.tipoJogador = tipoJogador;
    }

    public Robo(String id, TipoJogador tipoJogador) {
        super(0, 0);
        this.id = id;
        this.tipoJogador = tipoJogador;
    }

    @Override
    public String toString() {
        return "id="+id+", tipo="+tipoJogador.name();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Robo robo)) return false;

        if (getGolos() != robo.getGolos()) return false;
        if (getId() != null ? !getId().equals(robo.getId()) : robo.getId() != null) return false;
        return getTipo() == robo.getTipo();
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getTipo() != null ? getTipo().hashCode() : 0);
        result = 31 * result + getGolos();
        return result;
    }

    public void marcaGolo(){
        this.golosMarcados++;
    }

    // Getters

    public String getId() {
        return this.id;
    }

    public TipoJogador getTipo() {
        return this.tipoJogador;
    }

    public int getGolos() {
        return this.golosMarcados;
    }

}
