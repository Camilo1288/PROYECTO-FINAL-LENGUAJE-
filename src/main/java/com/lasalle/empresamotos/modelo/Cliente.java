/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lasalle.empresamotos.modelo;
import com.lasalle.empresamotos.excepciones.ClienteNoRegistradoException;
import com.lasalle.empresamotos.excepciones.MotoNoDisponibleException;
/**
 *
 * @author Usuario
 */
public class Cliente {

    private String nombre;
    private String documento;

    public Cliente(String nombre, String documento) {
        this.nombre = nombre;
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public void mostrarInformacion() {
        System.out.println("Cliente: " + nombre + " | Documento: " + documento);
    }

    public Venta comprarMoto(Moto moto, Vendedor vendedor, int numero, String fecha)
            throws MotoNoDisponibleException, ClienteNoRegistradoException {
        return vendedor.realizarVenta(numero, fecha, moto, this);
    }
}