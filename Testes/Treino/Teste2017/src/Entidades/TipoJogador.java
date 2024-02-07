package Entidades;

public enum TipoJogador {
    GuardaRedes,
    Avancado,
    Defesa,
    Medio;


    public static TipoJogador valorDe(String valor){
        switch (valor){
            case "Guarda-redes" -> {
                return TipoJogador.GuardaRedes;
            }
            case "Avançado" -> {
                return TipoJogador.Avancado;
            }
            case "Defesa" -> {
                return TipoJogador.Defesa;
            }
            case "Médio" -> {
                return TipoJogador.Medio;
            }
            default -> {
                return null;
            }
        }
    }
}
