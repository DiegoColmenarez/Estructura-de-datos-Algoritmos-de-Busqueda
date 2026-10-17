package org.exercise7;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static void imprimirVentas(ArrayList<Venta> ventas) {
        if (ventas == null || ventas.isEmpty()) {
            System.out.println("No hay ventas para mostrar.");
            return;
        }
        for (Venta v : ventas) {
            System.out.println("Serial: " + v.getNumFactura().getSerial() + " | Valor: " + v.getValor() + " | Fecha: " + v.getFecha());
        }
    }

    private static void mostrarClientes(ArrayList<Cliente> clientes) {
        System.out.println("--- Clientes Disponibles ---");
        for (Cliente c : clientes) {
            System.out.println("ID: " + c.getClienteId().getId() + " - Nombre: " + c.getNombre());
        }
        System.out.print("Ingrese el ID del cliente: ");
    }

    static void main(String[] args) {

        ArrayList<Venta> ventasClienteA = new ArrayList<>();
        ArrayList<Venta> ventasClienteB = new ArrayList<>();
        Cliente clienteA = new Cliente("Alejandro", ventasClienteA);
        Cliente clienteB = new Cliente("Carlos", ventasClienteB);

        var venta1 = new Venta(new BigDecimal(10_000));
        var venta2 = new Venta(new BigDecimal(100_000));
        var venta3 = new Venta(new BigDecimal(102_000));
        var venta4 = new Venta(new BigDecimal(110_000));
        var venta5 = new Venta(new BigDecimal(10_000));
        var venta6 = new Venta(new BigDecimal(40_000));

        clienteA.agregarVenta(venta1);
        clienteB.agregarVenta(venta3);
        clienteA.agregarVenta(venta5);
        clienteB.agregarVenta(venta2);
        clienteA.agregarVenta(venta6);
        clienteB.agregarVenta(venta4);

        ArrayList<Cliente> clientesGlobales = new ArrayList<>();
        clientesGlobales.add(clienteA);
        clientesGlobales.add(clienteB);

        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        while (true) {
            System.out.println("\n--- MENÚ DE GESTIÓN DE VENTAS ---");
            System.out.println("1. Búsqueda de una factura específica de un cliente.");
            System.out.println("2. Búsqueda de todas las ventas de un cliente.");
            System.out.println("3. Búsqueda de la primera y última venta con determinado valor de un cliente.");
            System.out.println("4. Ordenamiento por número de factura de un cliente.");
            System.out.println("5. Salir.");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
                continue;
            }

            if (opcion == 5) {
                System.out.println("Saliendo del sistema...");
                break;
            }

            if (opcion < 1 || opcion > 5) {
                System.out.println("Opción no válida. Intente nuevamente.");
                continue;
            }

            mostrarClientes(clientesGlobales);
            long idCliente;

            try {
                idCliente = Long.parseLong(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("ID inválido.");
                continue;
            }

            ArrayList<Venta> ventasDelCliente = Busqueda.buscarVentasCliente(clientesGlobales, idCliente);

            if (ventasDelCliente == null) {
                System.out.println("Cliente no encontrado.");
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el número de serial de la factura (Ej. 1001): ");
                    long serial = Long.parseLong(scanner.nextLine());

                    System.out.println("Intentando búsqueda binaria...");
                    Venta ventaEncontrada = Busqueda.buscarVenta(ventasDelCliente, serial);

                    if (ventaEncontrada == null) {
                        System.out.println("No encontrada. Intentando búsqueda lineal...");
                        ventaEncontrada = Busqueda.buscarVentaLineal(ventasDelCliente, serial);
                    }

                    if (ventaEncontrada != null) {
                        System.out.println("\n¡Factura encontrada!");
                        System.out.println("Serial: " + ventaEncontrada.getNumFactura().getSerial() + " | Valor: " + ventaEncontrada.getValor());
                    } else {
                        System.out.println("\nFactura no encontrada en la lista de este cliente.");
                    }
                    break;

                case 2:
                    System.out.println("\nVentas del cliente seleccionado:");
                    imprimirVentas(ventasDelCliente);
                    break;

                case 3:
                    System.out.print("Ingrese el valor exacto a buscar (Ej. 10000): ");
                    BigDecimal valorBuscado = new BigDecimal(scanner.nextLine());
                    Venta[] limites = Busqueda.buscarValorPrimeraUltima(ventasDelCliente, valorBuscado);

                    if (limites[0] != null && limites[1] != null) {
                        System.out.println("Valor buscado: " + valorBuscado);
                        System.out.println("Primera venta encontrada -> Serial: " + limites[0].getNumFactura().getSerial());
                        System.out.println("Última venta encontrada  -> Serial: " + limites[1].getNumFactura().getSerial());
                    } else {
                        System.out.println("No se encontraron ventas con ese valor para este cliente.");
                    }
                    break;

                case 4:
                    System.out.println("Ordenando las ventas del cliente seleccionado...");
                    Busqueda.ordenarPorNumFactura(ventasDelCliente);
                    System.out.println("Ventas ordenadas exitosamente:");
                    imprimirVentas(ventasDelCliente);
                    break;
            }
        }
        scanner.close();
    }
}