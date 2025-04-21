package modelo;

public class Punto {
    private double x, y;

    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    

    public double getX() { return x; }
    public double getY() { return y; }
    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }

    public double distancia(Punto p) {
        return Math.sqrt(Math.pow(p.x - this.x, 2) + Math.pow(p.y - this.y, 2));
    }
}
