package modelo;

public class CuadrilateroIrregular extends Cuadrilatero {

    public CuadrilateroIrregular(Punto[] vertices, String color) {
        super(vertices, color);
    }

    @Override
    public double perimetro() {
        return vertices[0].distancia(vertices[1]) + 
               vertices[1].distancia(vertices[2]) + 
               vertices[2].distancia(vertices[3]) + 
               vertices[3].distancia(vertices[0]);
    }

    @Override
    public double area() {
        // Fórmula del área de Gauss para polígonos irregulares
        double sum1 = vertices[0].getX() * vertices[1].getY() + 
                     vertices[1].getX() * vertices[2].getY() + 
                     vertices[2].getX() * vertices[3].getY() + 
                     vertices[3].getX() * vertices[0].getY();
        
        double sum2 = vertices[0].getY() * vertices[1].getX() + 
                     vertices[1].getY() * vertices[2].getX() + 
                     vertices[2].getY() * vertices[3].getX() + 
                     vertices[3].getY() * vertices[0].getX();
        
        return Math.abs(sum1 - sum2) / 2;
    }
}