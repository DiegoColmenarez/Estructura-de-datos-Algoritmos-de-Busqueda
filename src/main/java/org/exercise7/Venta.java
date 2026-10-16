package org.exercise7;

import java.time.LocalDate;

public class Venta {
    private final NumFactura numFactura;
    private final LocalDate fecha;

    public Venta(NumFactura numFactura, LocalDate fecha){
        this.numFactura = NumFactura.crear();
        this.fecha = LocalDate.now();
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public NumFactura getNumFactura() {
        return numFactura;
    }
}
