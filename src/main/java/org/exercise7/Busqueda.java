package org.exercise7;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Busqueda {

    public static void ordenarPorNumFactura(ArrayList<Venta> ventas) {
        for (int i = 1; i < ventas.size(); i++) {
            Venta actual = ventas.get(i);
            int j = i - 1;
            while (j >= 0 && ventas.get(j).getNumFactura().getSerial() > actual.getNumFactura().getSerial()) {
                ventas.set(j + 1, ventas.get(j));
                j--;
            }
            ventas.set(j + 1, actual);
        }
    }

    public static Venta buscarVenta(ArrayList<Venta> ventas, long serial) {
        int inicio = 0;
        int fin = ventas.size() - 1;
        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            long s = ventas.get(medio).getNumFactura().getSerial();
            if (s == serial) return ventas.get(medio);
            if (s < serial) inicio = medio + 1;
            else fin = medio - 1;
        }
        return null;
    }

    public static ArrayList<Venta> buscarVentasCliente(ArrayList<Cliente> clientes, long idCliente) {
        for (Cliente cliente : clientes) {
            if (cliente.getId().getId() == idCliente) {
                return cliente.getVentas();
            }
        }
        return null;
    }

    public static Venta[] buscarValorPrimeraUltima(ArrayList<Venta> ventas, BigDecimal valorBuscado) {
        Venta primera = null;
        Venta ultima = null;
        for (Venta actual : ventas) {
            if (actual.getValor().compareTo(valorBuscado) == 0) {
                if (primera == null) {
                    primera = actual;
                }
                ultima = actual;
            }
        }
        return new Venta[]{primera, ultima};
    }
}