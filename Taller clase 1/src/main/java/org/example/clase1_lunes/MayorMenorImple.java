package org.example.clase1_lunes;

public class MayorMenorImple implements MayorMenor {
    @Override
    public int encontrarMayor(int a, int b) {
        if (b > a) {
            return b;
        } else {
            return a;
        }
    }

    @Override
    public int encontrarMenor(int a, int b) {
        if (b < a) {
            return b;
        } else {
            return a;
        }
    }

}
