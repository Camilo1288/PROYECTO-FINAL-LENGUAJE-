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
public abstract class Moto {
    private String marca;
    private String modelo;
    private double precio;
    private boolean disponible;

    public Moto(String marca, String modelo, double precio) throws PrecioInvalidoException {
        this.marca = marca;
        this.modelo = modelo;
        setPrecio(precio); 
        this.disponible = true;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) throws PrecioInvalidoException {
        if (precio <= 0) {
            throw new PrecioInvalidoException("El precio debe ser mayor a cero.");
        }
        this.precio = precio;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void mostrarInformacion() {
    System.out.println("Marca: " + marca);
    System.out.println("Modelo: " + modelo);
    System.out.printf("Precio base: $%,.0f%n", precio);
    System.out.println("Disponible: " + (disponible ? "Si" : "No"));
    }

    
    public abstract double calcularPrecioFinal();
}
