package Entidades;

public abstract class ObjetoMovel {
    private int x;
    private int y;
    private int velocidade = 0;
    private double distancia = 0;

    public ObjetoMovel(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public void calcDist(int xOld, int yOld, int xNew, int yNew){
        this.distancia += Math.sqrt((xOld-xNew)*(xOld-xNew) + (yOld-yNew)*(yOld-yNew));
    }

    public void move(int x, int y){
        int xOld = this.x;
        int yOld = this.y;

        this.x = x;
        this.y = y;

        calcDist(xOld, yOld, this.x, this.y); // Calcular distancia percorrida
    }

    public void move(int x, int y, int velocidade ){
        int xOld = this.x;
        int yOld = this.y;

        if(this.x > x) {
            this.x -= velocidade;
        }
        else if(this.x < x) {
            this.x += velocidade;
        }
        if(this.y > y) {
            this.y -= velocidade;
        }
        else if(this.y < y) {
            this.y += velocidade;
        }

        calcDist(xOld, yOld, this.x, this.y); // Calcular distancia percorrida
    }

    // Getters

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getVelocidade() {
        return this.velocidade;
    }

    public double getDistancia() {
        return this.distancia;
    }
}
