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
public class MotoDeportiva extends Moto {

    private int cilindrada;

    public MotoDeportiva(String marca, String modelo, double precio, int cilindrada)
            throws PrecioInvalidoException {
        super(marca, modelo, precio); 
        this.cilindrada = cilindrada;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    
    @Override
    public double calcularPrecioFinal() {
        double recargo = (cilindrada > 600) ? 0.15 : 0.10;
        return getPrecio() * (1 + recargo);
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("--- Moto Deportiva ---");
        super.mostrarInformacion();
        System.out.println("Cilindrada: " + cilindrada + " cc");
        System.out.printf("Precio final: $%,.0f%n", calcularPrecioFinal());
    }
}
