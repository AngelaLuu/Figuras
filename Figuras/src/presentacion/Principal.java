package presentacion;

import modelo.*;
import javax.swing.*;

public class Principal {

    public static void main(String[] args) {
        // 1. Cuadrado (lados iguales)
        Punto[] verticesCuadrado = {
            new Punto(0, 0),
            new Punto(2, 0),
            new Punto(2, 2),
            new Punto(0, 2)
        };
        Cuadrado cuadrado = new Cuadrado(verticesCuadrado, "Amarillo");

        // 2. Rectángulo (o CuadriláteroIrregular)
        Punto[] verticesIrregular = {
            new Punto(0, 0),
            new Punto(3, 0),
            new Punto(2, 3),
            new Punto(1, 2)
        };
        CuadrilateroIrregular irregular = new CuadrilateroIrregular(verticesIrregular, "Verde");

        // 3. Triángulos (opcional, para completar el ejemplo)
        TrianguloEquilatero equilatero = new TrianguloEquilatero(
            new Punto(0, 0), 
            new Punto(2, 0), 
            new Punto(1, Math.sqrt(3)), 
            "Rojo"
        );

        TrianguloIsosceles isosceles = new TrianguloIsosceles(
            new Punto(1, 0), 
            new Punto(5, 0), 
            new Punto(3, 4), 
            "Azul"
        );

        // 4. Agrupar figuras
        Figura[] figuras = { 
            cuadrado, 
            irregular, 
            equilatero, 
            isosceles 
        };

        // 5. Mostrar datos en consola
        for (Figura f : figuras) {
            System.out.println("Figura: " + f.getClass().getSimpleName() + " | Color: " + f.getColor());
            System.out.printf("Perímetro: %.2f\n", f.perimetro());
            System.out.printf("Área: %.2f\n\n", f.area());
        }

        // 6. Configurar ventana
        JFrame ventana = new JFrame("Figuras Geométricas");
        ventana.add(new Lienzo(figuras));
        ventana.pack();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }
}