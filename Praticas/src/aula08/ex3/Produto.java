package aula08.ex3;

public interface Produto {
    String getNome();
    double getPreco();
    int getQuatidade();
    void adidiconarQuantidade(int quantidade);
    void removerQuantidade(int quantidade);
}
