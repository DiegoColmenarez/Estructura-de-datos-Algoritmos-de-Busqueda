package org.exercise7;

import java.util.ArrayList;

public class OrdenamientoVentas {

    public static void ordenarPorNumFactura(ArrayList<Venta> ventas) {
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
}
