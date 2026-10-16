package org.exercise7;

import java.util.concurrent.atomic.AtomicLong;

public class ClienteId {
    long id;

    private ClienteId(Long id){
        this.id = id;
    }

    private static final AtomicLong inicio = new AtomicLong(1);

    private static long incrementarId(){
        return  inicio.incrementAndGet();
    }

    public static ClienteId crear(){
        return new ClienteId(incrementarId());
    }
}
