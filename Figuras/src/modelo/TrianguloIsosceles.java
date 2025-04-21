package modelo;

public class TrianguloIsosceles extends Triangulo {
    
    public TrianguloIsosceles(Punto baseInicio, Punto baseFin, Punto vertice, String color) {
        super(new Punto[]{baseInicio, baseFin, vertice}, color);
        validarIsosceles();
    }

    private void validarIsosceles() {
        double ladoA = vertices[0].distancia(vertices[1]);
        double ladoB = vertices[1].distancia(vertices[2]);
        double ladoC = vertices[2].distancia(vertices[0]);

        if (!(Math.abs(ladoB - ladoC) < 0.001) && !(Math.abs(ladoA - ladoB) < 0.001) && !(Math.abs(ladoA - ladoC) < 0.001)) {
            throw new IllegalArgumentException("No es un triángulo isósceles válido. Dos lados deben ser iguales.");
        }
    }

    @Override
    public double area() {
        double base = vertices[0].distancia(vertices[1]);
        double altura = Math.abs(vertices[2].getY() - vertices[0].getY());
        return (base * altura) / 2;
    }

    @Override
    public double perimetro() {
        double ladoIgual = vertices[1].distancia(vertices[2]); // Uno de los lados iguales
        double base = vertices[0].distancia(vertices[1]);
        return (2 * ladoIgual) + base;
    }

    @Override
    public String toString() {
        return "Triángulo Isósceles - Color: " + getColor() + ", Área: " + area() + ", Perímetro: " + perimetro();
    }
}