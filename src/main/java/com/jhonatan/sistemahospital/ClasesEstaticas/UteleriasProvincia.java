package com.jhonatan.sistemahospital.ClasesEstaticas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UteleriasProvincia {

    public static char generarIdProvincia() {
        /*creamos una lista con las letras del alfabeto*/

        List<Character> alfabeto = new ArrayList<>();
        for (char c = 'B'; c <= 'Z'; c++) {
            alfabeto.add(c);
        }

        /*Barajaramos la lista para obtener un orden aleatorio*/
        Collections.shuffle(alfabeto);

        /*extraer los caracteres sin repetor*/
        return alfabeto.remove(0);

    }

}
