package org.exercise7;

import java.util.concurrent.atomic.AtomicLong;

public class NumFactura {

    long serial;

    private NumFactura(Long serial){
        this.serial = serial;
    }

    private static final AtomicLong inicio = new AtomicLong(1000);

    private static long incrementarSerial(){
        return  inicio.incrementAndGet();
    }

    public static NumFactura crear(){
        return new NumFactura(incrementarSerial());
    }
}
