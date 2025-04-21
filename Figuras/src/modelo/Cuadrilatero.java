package modelo;

public abstract class Cuadrilatero extends Figura {
    protected Punto[] vertices = new Punto[4];

    public Cuadrilatero(Punto[] vertices, String color) {
        super(color);
        this.vertices = vertices;
    }

    public Punto[] getVertices() { return vertices; }
    public void setVertices(Punto[] vertices) { this.vertices = vertices; }
}
