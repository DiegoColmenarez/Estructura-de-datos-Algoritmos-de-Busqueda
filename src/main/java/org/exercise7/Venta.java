package org.exercise7;

import java.time.LocalDate;

public class Venta {
    private final NumFactura numFactura;
    private final Cliente cliente;
    private final LocalDate fecha;

    public Venta(NumFactura numFactura, Cliente cliente, LocalDate fecha){
        this.cliente = cliente;
        this.numFactura = NumFactura.crear();
        this.fecha = LocalDate.now();
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public NumFactura getNumFactura() {
        return numFactura;
    }
}
