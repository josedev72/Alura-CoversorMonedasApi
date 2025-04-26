package com.alura.modelos;

public class Cambio {
    int descripcion;
    double origenValor;
    double destinoValor;

    public Cambio(int descripcion) {
        this.descripcion = descripcion;
    }

    public double getOrigenValor() {
        return origenValor;
    }

    public void setOrigenValor(double origenValor) {
        this.origenValor = origenValor;
    }

    public double getDestinoValor() {
        return destinoValor;
    }

    public void setDestinoValor(double destinoValor) {
        this.destinoValor = destinoValor;
    }

    @Override
    public String toString() {
        return descripcion + '\'' +
                ", Valor Moneda Origen = " + origenValor +
                ", Valor Moneda Destino = " + destinoValor;
    }
}
