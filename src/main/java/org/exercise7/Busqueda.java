package org.exercise7;

import java.util.ArrayList;

public class Busqueda {

    private void ordenarPorNumFactura(ArrayList<Venta> ventas) {
        for (int i = 1; i < ventas.size(); i++) {
            Venta actual = ventas.get(i);
            int j = i - 1;
            while (j >= 0 && ventas.get(j).getNumFactura().serial > actual.getNumFactura().serial) {
                ventas.set(j + 1, ventas.get(j));
                j--;
            }
            ventas.set(j + 1, actual);
        }
    }

    public Venta buscarBinaria(ArrayList<Venta> ventas, long serial) {
        ordenarPorNumFactura(ventas);
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
