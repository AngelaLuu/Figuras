package modelo;

public class TrianguloEquilatero extends Triangulo {
    
    public TrianguloEquilatero(Punto p1, Punto p2, Punto p3, String color) {
        super(new Punto[]{p1, p2, p3}, color);
        validarEquilatero();
    }

    private void validarEquilatero() {
        double ladoA = vertices[0].distancia(vertices[1]);
        double ladoB = vertices[1].distancia(vertices[2]);
        double ladoC = vertices[2].distancia(vertices[0]);

        if (Math.abs(ladoA - ladoB) > 0.001 || Math.abs(ladoB - ladoC) > 0.001) {
            throw new IllegalArgumentException("No es un triángulo equilátero válido. Todos los lados deben ser iguales.");
        }
    }

    @Override
    public double area() {
        double lado = vertices[0].distancia(vertices[1]);
        return (Math.sqrt(3) / 4) * Math.pow(lado, 2);
    }

    @Override
    public double perimetro() {
        return 3 * vertices[0].distancia(vertices[1]); // 3 * lado
    }

    @Override
    public String toString() {
        return "Triángulo Equilátero - Color: " + getColor() + ", Área: " + area() + ", Perímetro: " + perimetro();
    }
}