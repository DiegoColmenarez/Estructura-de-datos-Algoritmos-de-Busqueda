package org.exercise7;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Venta {
    private final NumFactura numFactura;
    private final LocalDate fecha;
    private final BigDecimal valor;

    public Venta(BigDecimal valor){
        this.numFactura = NumFactura.crear();
        this.fecha = LocalDate.now();
        this.valor = valor;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public NumFactura getNumFactura() {
        return numFactura;
    }

    public BigDecimal getValor() {
        return valor;
    }
}
