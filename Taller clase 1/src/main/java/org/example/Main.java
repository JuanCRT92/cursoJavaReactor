package org.example;


import org.example.clase1_lunes.CalcularIva;
import org.example.clase1_lunes.Descuento;
import org.example.clase1_lunes.MayorMenorImple;
import org.example.clase1_lunes.MayorMenor;

import java.util.logging.Logger;


public class Main {

    private static final MayorMenor MAYOR_MENOR = new MayorMenorImple();
    static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        System.out.println("Primera practica curso reactividad.");

        System.out.println("************** Actividad del día lunes **************");
        System.out.println("************** Punto 1 **************");
        Main.punto1();
        System.out.println("************** Punto 2 **************");
        Main.punto2();
        System.out.println("************** Punto 3 **************");
        Main.punto3();
    }

    /**
     * Haciendo uso de lo aprendido(Expresiones lambda, referencias a métodos y funciones puras) resuelva:
     * */

    /**
     * 1. Con la intención de encontrar el número mayor en una lista y a su vez el número menor, cree un método que le permita
     * estas dos funciones, siguiendo los principios de las funciones puras.
     */
    private static void punto1() {
        int[] lista = {8, 3, 4, 5, 6, 7, 8, 9, 10};
        int mayor = 0;
        int menor = lista[0];
        for (int i : lista) {
            mayor = MAYOR_MENOR.encontrarMayor(mayor, i);
            menor = MAYOR_MENOR.encontrarMenor(menor, i);
        }

        System.out.println("El numero mayor es: " + mayor);
        System.out.println("El numero menor es: " + menor);

    }

    /**
     * 2. En una tienda de ropa necesitamos aplicar un descuento a las ventas que se hacen, este descuento
     * es variable por lo que necesitamos que usted cree un método que reciba el total de la venta y el porcentaje a descontar
     * y devuelva el nuevo precio total.
     */
    private static void punto2() {
        double totalVenta = 100_000;
        int porcentajeDescuento = 5;
        double totalVentaConDescuento = 0;
        Descuento des = new Descuento() {
            @Override
            public double aplicarDescuento(double precio, int descuento) {

                return (precio * descuento) / 100;
            }
        };
        totalVentaConDescuento = totalVenta - (des.aplicarDescuento(totalVenta, porcentajeDescuento));
        System.out.println("El total de la venta con descuento es: " + totalVentaConDescuento);

        //Lamda

        Descuento des2 = (precio, descuento) -> (precio * descuento) / 100;
        System.out.println("Con lambda " + (totalVenta - des2.aplicarDescuento(totalVenta, porcentajeDescuento)));

    }


    /**
     * 3. Necesitamos calcular el iva de una venta, para esto es necesario que usted cree un método
     * Tendremos dos escenarios posibles, en el primero se le pasará únicamente el valor al cual se le debe
     * aplicar el iva, sin especificar el porcentaje, en este caso se debe aplicar un 21% siempre.
     * En el segundo escenario se le pasará tanto el precio de la venta como el porcentaje de iva.
     * Cree una sola función que pueda lograr estos dos propósitos
     */
    private static void punto3() {
        double venta = 100_000;
        CalcularIva calcularIva = new CalcularIva() {

            @Override
            public double calcularIva(double precio, int iva) {
                return precio * iva / 100;
            }
        };

        //ejercicio sin parametro de iva
        double ivaCalculado = CalcularIva.calcularIva(venta);
        System.out.println("El iva calculado es: " + ivaCalculado);

        //ejercicio con parametro de iva
        int porcentajeIva = 19;
        ivaCalculado = calcularIva.calcularIva(venta, porcentajeIva);
        System.out.println("El iva calculado con " + porcentajeIva + ": " + ivaCalculado);
        CalcularIva calcularIva3 = (precio, iva) -> (precio * iva) / 100;
        System.out.println("Con lambda " + calcularIva3.calcularIva(venta, porcentajeIva));


    }
}