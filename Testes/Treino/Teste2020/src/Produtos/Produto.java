package Produtos;

public abstract class Produto implements PVP{
    private static int codeCounter = 1000;
    private final String code;
    private int stock = 1;
    private final double precoBase;

    private final ProdutoType type;

    public Produto(ProdutoType type, double precoBase) {
        this.code = type.name().charAt(0) + "" + codeCounter;
        Produto.codeCounter += 2;
        this.type = type;
        this.precoBase = precoBase;
    }

    @Override
    public String toString() {
        return type.name().charAt(0) + type.name().substring(1).toLowerCase();
    }

    public boolean vender(int quantidade){
        if(stock >= quantidade){
            stock = stock - quantidade;
            return true;
        }
        return false;
    }

    public abstract String getDescricao();
    @Override
    public double precoVendaAoPublico() {
        return precoBase + precoBase*0.23;
    }

    public void addStock(int n){
        stock += n;
    }

    // Getters


    public ProdutoType getType() {
        return this.type;
    }

    public String getCode() {
        return this.code;
    }

    public int getStock() {
        return this.stock;
    }

    public double getPrecoBase() {
        return this.precoBase;
    }

    // Setters


    public void setStock(int stock) {
        this.stock = stock;
    }
}
