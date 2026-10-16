package org.exercise7;

import java.util.ArrayList;

public class Cliente {

    ArrayList<Venta> ventas;
    String nombre;

    public Cliente(String nombre, ArrayList<Venta> ventas){
        this.nombre = nombre;
        this.ventas = ventas;
    }
}
