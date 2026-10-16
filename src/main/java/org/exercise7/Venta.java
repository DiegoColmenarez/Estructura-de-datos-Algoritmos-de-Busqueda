package org.exercise7;

import java.time.LocalDate;

public class Venta {
    private NumFactura numFactura;
    private Cliente cliente;
    private LocalDate fecha;

    public Venta(NumFactura numFactura, Cliente cliente, LocalDate fecha){
        this.cliente = cliente;
        this.numFactura = NumFactura.crear();
        this.fecha = LocalDate.now();
    }
}
