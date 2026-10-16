package org.exercise7;

import java.util.ArrayList;

public class Cliente {

    private final ClienteId clienteId;
    private final ArrayList<Venta> ventas;
    private String nombre;

    public Cliente(String nombre, ArrayList<Venta> ventas){
        this.nombre = nombre;
        this.ventas = ventas;
        this.clienteId = ClienteId.crear();
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public ArrayList<Venta> getVentas() {
        return ventas;
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarVenta(Venta venta){
        ventas.add(venta);
    }
}
