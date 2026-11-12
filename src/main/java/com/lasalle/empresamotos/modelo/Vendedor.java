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
public class Vendedor {

    private String nombre;
    private String codigo;

    public Vendedor(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void mostrarInformacion() {
        System.out.println("Vendedor: " + nombre + " | Codigo: " + codigo);
    }

    public Venta realizarVenta(int numero, String fecha, Moto moto, Cliente cliente)
            throws MotoNoDisponibleException, ClienteNoRegistradoException {
        Venta venta = new Venta(numero, fecha, moto, cliente, this);
        venta.realizarVenta();
        venta.generarFactura();
        return venta;
    }
}