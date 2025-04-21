package modelo;

public class TrianguloEspecifico extends Triangulo {

    public TrianguloEspecifico(Punto[] vertices, String color) {
        super(vertices, color);
    }

    @Override
    public double perimetro() {
        double lado1 = vertices[0].distancia(vertices[1]);
        double lado2 = vertices[1].distancia(vertices[2]);
        double lado3 = vertices[2].distancia(vertices[0]);
        return lado1 + lado2 + lado3;
    }

    @Override
    public double area() {
        double lado1 = vertices[0].distancia(vertices[1]);
        double lado2 = vertices[1].distancia(vertices[2]);
        double lado3 = vertices[2].distancia(vertices[0]);
        double s = perimetro() / 2;
        return Math.sqrt(s * (s - lado1) * (s - lado2) * (s - lado3));  // Fórmula de Herón
    }
}
