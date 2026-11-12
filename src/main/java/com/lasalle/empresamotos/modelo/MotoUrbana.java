/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lasalle.empresamotos.modelo;
import com.lasalle.empresamotos.excepciones.PrecioInvalidoException;

/**
 *
 * @author Usuario
 */
public class MotoUrbana extends Moto {

    private double consumo; 

    public MotoUrbana(String marca, String modelo, double precio, double consumo)
            throws PrecioInvalidoException {
        super(marca, modelo, precio);
        this.consumo = consumo;
    }

    public double getConsumo() {
        return consumo;
    }

    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }

    
    @Override
    public double calcularPrecioFinal() {
        double recargo = 0.05;
        return getPrecio() * (1 + recargo);
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("--- Moto Urbana ---");
        super.mostrarInformacion();
        System.out.println("Consumo: " + consumo + " km/gal");
        System.out.printf("Precio final: $%,.0f%n", calcularPrecioFinal());
    }
}
