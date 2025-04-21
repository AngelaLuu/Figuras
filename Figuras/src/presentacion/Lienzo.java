package presentacion;

import modelo.*;
import javax.swing.*;
import java.awt.*;

public class Lienzo extends JPanel {
    private Figura[] figuras;
    private int margen = 50;
    private int espacio = 80;
    private int escala = 20;

    public Lienzo(Figura[] figuras) {
        this.figuras = figuras;
        setBackground(new Color(245, 245, 245));
        setPreferredSize(new Dimension(1000, 500));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int xActual = margen;
        int centroY = getHeight() / 2;

        for (Figura figura : figuras) {
            g2d.setColor(obtenerColor(figura.getColor()));
            g2d.setStroke(new BasicStroke(2));

            if (figura instanceof Cuadrilatero cuadrilatero) {
                dibujarPoligono(g2d, cuadrilatero.getVertices(), xActual, centroY);
                dibujarEtiqueta(g2d, "Cuadrado", xActual, centroY);
                xActual += calcularAncho(cuadrilatero.getVertices()) + espacio;
            } 
            else if (figura instanceof TrianguloEquilatero) {
                dibujarPoligono(g2d, ((Triangulo)figura).getVertices(), xActual, centroY);
                dibujarEtiqueta(g2d, "Equilátero", xActual, centroY);
                xActual += calcularAncho(((Triangulo)figura).getVertices()) + espacio;
            }
            else if (figura instanceof TrianguloIsosceles) {
                dibujarPoligono(g2d, ((Triangulo)figura).getVertices(), xActual, centroY);
                dibujarEtiqueta(g2d, "Isósceles", xActual, centroY);
                xActual += calcularAncho(((Triangulo)figura).getVertices()) + espacio;
            }
            else if (figura instanceof Triangulo) {
                dibujarPoligono(g2d, ((Triangulo)figura).getVertices(), xActual, centroY);
                dibujarEtiqueta(g2d, "Triángulo", xActual, centroY);
                xActual += calcularAncho(((Triangulo)figura).getVertices()) + espacio;
            }
        }
    }

    private void dibujarPoligono(Graphics2D g2d, Punto[] vertices, int offsetX, int centroY) {
        int[] xPoints = new int[vertices.length];
        int[] yPoints = new int[vertices.length];

        for (int i = 0; i < vertices.length; i++) {
            xPoints[i] = offsetX + (int) (vertices[i].getX() * escala);
            yPoints[i] = centroY - (int) (vertices[i].getY() * escala);
        }

        g2d.fillPolygon(xPoints, yPoints, vertices.length);
        g2d.setColor(Color.BLACK);
        g2d.drawPolygon(xPoints, yPoints, vertices.length);
    }

    private void dibujarEtiqueta(Graphics2D g2d, String texto, int x, int y) {
        g2d.setColor(Color.BLACK);
        g2d.drawString(texto, x, y + 40);
    }

    private int calcularAncho(Punto[] vertices) {
        double maxX = 0;
        for (Punto p : vertices) {
            if (p.getX() > maxX) maxX = p.getX();
        }
        return (int) (maxX * escala);
    }

    private Color obtenerColor(String nombreColor) {
        return switch (nombreColor.toLowerCase()) {
            case "amarillo" -> new Color(255, 255, 0, 200);
            case "verde" -> new Color(50, 200, 50, 200);
            case "rojo" -> new Color(200, 50, 50, 200);
            case "azul" -> new Color(50, 50, 200, 200);
            default -> new Color(180, 180, 180, 200);
        };
    }
}