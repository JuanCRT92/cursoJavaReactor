package org.example.clase1_lunes;

public interface CalcularIva {
    static double  calcularIva(double precio){
        return precio * 0.21;
    }
    double calcularIva(double precio, int iva);
}
