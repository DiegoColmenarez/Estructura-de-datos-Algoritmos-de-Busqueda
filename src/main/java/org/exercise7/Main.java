package org.exercise7;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Main {
    private static void imprimirVentas(ArrayList<Venta> ventas) {
        for (Venta v : ventas) {
            System.out.println("Serial: " + v.getNumFactura().getSerial() + " | Valor: " + v.getValor() + " | Fecha: " + v.getFecha());
        }
    }
     static void main(String[] args) {


        ArrayList<Venta> ventasClienteA = new ArrayList<>();
        ArrayList<Venta> ventasClienteB = new ArrayList<>();
        Cliente clienteA = new Cliente("Alejandro", ventasClienteA);
        Cliente clienteB = new Cliente("Carlos", ventasClienteB);
        var venta1 = new  Venta(new BigDecimal(10_000));
        var venta2 = new  Venta(new BigDecimal(100_000));
        var venta3 = new  Venta(new BigDecimal(102_000));
        var venta4 = new  Venta(new BigDecimal(110_000));
        var venta5 = new  Venta(new BigDecimal(10_000));
        var venta6 = new  Venta(new BigDecimal(40_000));

        clienteA.agregarVenta(venta1);
        clienteB.agregarVenta(venta3);
        clienteA.agregarVenta(venta5);
        clienteB.agregarVenta(venta2);
        clienteA.agregarVenta(venta6);
        clienteB.agregarVenta(venta4);

        ArrayList<Cliente> clientesGlobales = new ArrayList<>();
        clientesGlobales.add(clienteA);
        clientesGlobales.add(clienteB);

        System.out.println("--- Ordenamiento por número de factura ---");
        System.out.println("Antes de ordenar las ventas del clienteB:");
        imprimirVentas(clienteB.getVentas());
        Busqueda.ordenarPorNumFactura(clienteB.getVentas());
        System.out.println("Después de ordenar:");
        imprimirVentas(clienteB.getVentas());

        System.out.println("\n---  Búsqueda de una factura específica ---");
        Venta ventaEncontrada = Busqueda.buscarVenta(clienteB.getVentas(), 1001);
        if (ventaEncontrada != null) {
            System.out.println("Factura encontrada: Serial " + ventaEncontrada.getNumFactura().getSerial() + " | Valor: " + ventaEncontrada.getValor());
        } else {
            System.out.println("Factura no encontrada.");
        }

        System.out.println("\n--- Búsqueda de todas las ventas de un cliente ---");
        ArrayList<Venta> ventasDelCliente = Busqueda.buscarVentasCliente(clientesGlobales, clienteA.getClienteId().getId());

        if (ventasDelCliente != null) {
            System.out.println("Ventas del cliente " + clienteA.getNombre() + ":");
            imprimirVentas(ventasDelCliente);
        } else {
            System.out.println("Cliente no encontrado o sin ventas.");
        }

        System.out.println("\n--- Primera y última venta con determinado valor ---");
        BigDecimal valorBuscado = new BigDecimal(10_000);
        Venta[] limites = Busqueda.buscarValorPrimeraUltima(clienteA.getVentas(), valorBuscado);
        if (limites[0] != null && limites[1] != null) {
            System.out.println("Valor buscado: " + valorBuscado);
            System.out.println("Primera venta encontrada - Serial: " + limites[0].getNumFactura().getSerial());
            System.out.println("Última venta encontrada  - Serial: " + limites[1].getNumFactura().getSerial());
        } else {
            System.out.println("No se encontraron ventas con ese valor.");
        }
    }
}