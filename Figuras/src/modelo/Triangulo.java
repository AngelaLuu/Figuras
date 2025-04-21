package modelo;

public abstract class Triangulo extends Figura {
    protected Punto[] vertices = new Punto[3];

    public Triangulo(Punto[] vertices, String color) {
        super(color);
        this.vertices = vertices;
    }

    public Punto[] getVertices() { return vertices; }
    public void setVertices(Punto[] vertices) { this.vertices = vertices; }
}
