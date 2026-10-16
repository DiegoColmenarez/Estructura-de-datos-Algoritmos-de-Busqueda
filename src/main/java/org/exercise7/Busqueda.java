package org.exercise7;

import java.util.ArrayList;

public class Busqueda {

    public Venta buscarBinaria(ArrayList<Venta> ventas, long serial) {

        int inicio = 0;
        int fin = ventas.size() - 1;

        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            long s = ventas.get(medio).getNumFactura().serial;
            if (s == serial) return ventas.get(medio);
            if (s < serial) inicio = medio + 1;
            else fin = medio - 1;
        }
        return null;
    }
}
