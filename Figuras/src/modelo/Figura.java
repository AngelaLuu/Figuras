package modelo;

public abstract class Figura {
    protected String color;

    public Figura(String color) {
        this.color = color;
    }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public abstract double perimetro();
    public abstract double area();
}
