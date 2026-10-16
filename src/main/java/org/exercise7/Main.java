package org.exercise7;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Main {
    private static void imprimirVentas(ArrayList<Venta> ventas) {
        for (Venta v : ventas) {
            System.out.println("Serial: " + v.getNumFactura().serial + " | Valor: " + v.getValor() + " | Fecha: " + v.getFecha());
        }
    }
     static void main(String[] args) {

        ArrayList<Venta> ventasGlobales = new ArrayList<>();

        Venta v1 = new Venta(new BigDecimal("150.00"));
        Venta v2 = new Venta(new BigDecimal("300.50"));
        Venta v3 = new Venta(new BigDecimal("150.00"));
        Venta v4 = new Venta(new BigDecimal("80.00"));

        ventasGlobales.add(v3);
        ventasGlobales.add(v1);
        ventasGlobales.add(v4);
        ventasGlobales.add(v2);

        ArrayList<Venta> ventasClienteA = new ArrayList<>();
        ventasClienteA.add(v1);
        ventasClienteA.add(v2);
        Cliente clienteA = new Cliente("Alejandro", ventasClienteA);

        ArrayList<Cliente> clientesGlobales = new ArrayList<>();
        clientesGlobales.add(clienteA);

        System.out.println("--- Ordenamiento por número de factura ---");
        System.out.println("Antes de ordenar:");
        imprimirVentas(ventasGlobales);
        Busqueda.ordenarPorNumFactura(ventasGlobales);
        System.out.println("Después de ordenar:");
        imprimirVentas(ventasGlobales);

        System.out.println("\n---  Búsqueda de una factura específica ---");
        long serialABuscar = v1.getNumFactura().getSerial();
        Venta ventaEncontrada = Busqueda.buscarVenta(ventasGlobales, serialABuscar);
        if (ventaEncontrada != null) {
            System.out.println("Factura encontrada: Serial " + ventaEncontrada.getNumFactura().getSerial() + " | Valor: " + ventaEncontrada.getValor());
        } else {
            System.out.println("Factura no encontrada.");
        }

        System.out.println("\n--- Búsqueda de todas las ventas de un cliente ---");
        long idCliente = clienteA.getId().id;
        ArrayList<Venta> ventasDelCliente = Busqueda.buscarVentasCliente(clientesGlobales, idCliente);

        if (ventasDelCliente != null) {
            System.out.println("Ventas del cliente " + clienteA.getNombre() + ":");
            imprimirVentas(ventasDelCliente);
        } else {
            System.out.println("Cliente no encontrado o sin ventas.");
        }

        System.out.println("\n--- Primera y última venta con determinado valor ---");
        BigDecimal valorBuscado = new BigDecimal("150.00");
        Venta[] limites = Busqueda.buscarValorPrimeraUltima(ventasGlobales, valorBuscado);
        if (limites[0] != null && limites[1] != null) {
            System.out.println("Valor buscado: " + valorBuscado);
            System.out.println("Primera venta encontrada - Serial: " + limites[0].getNumFactura().getSerial());
            System.out.println("Última venta encontrada  - Serial: " + limites[1].getNumFactura().getSerial());
        } else {
            System.out.println("No se encontraron ventas con ese valor.");
        }
    }
}