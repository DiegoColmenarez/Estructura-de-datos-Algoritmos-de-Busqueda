package org.exercise7;

import java.util.ArrayList;

public class Cliente {

    private final ClienteId id;
    private final ArrayList<Venta> ventas;
    private String nombre;

    public Cliente(String nombre, ArrayList<Venta> ventas){
        this.nombre = nombre;
        this.ventas = ventas;
        this.id = ClienteId.crear();
    }

    public ClienteId getId() {
        return id;
    }

    public ArrayList<Venta> getVentas() {
        return ventas;
    }

    public String getNombre() {
        return nombre;
    }
}
