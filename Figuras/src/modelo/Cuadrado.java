package modelo;

public class Cuadrado extends Cuadrilatero {

    public Cuadrado(Punto[] vertices, String color) {
        super(vertices, color);
    }

    @Override
    public double perimetro() {
        double lado = vertices[0].distancia(vertices[1]);
        return 4 * lado;
    }

    @Override
    public double area() {
        double lado = vertices[0].distancia(vertices[1]);
        return lado * lado;
    }
}
