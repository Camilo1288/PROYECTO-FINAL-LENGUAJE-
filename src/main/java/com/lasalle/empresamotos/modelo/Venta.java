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
public class Venta {
    private int numero;
    private String fecha;
    private double total;
    private Moto moto;
    private Cliente cliente;
    private Vendedor vendedor;

    public Venta(int numero, String fecha, Moto moto, Cliente cliente, Vendedor vendedor) {
        this.numero = numero;
        this.fecha = fecha;
        this.moto = moto;
        this.cliente = cliente;
        this.vendedor = vendedor;
    }

    public int getNumero() {
        return numero;
    }

    public String getFecha() {
        return fecha;
    }

    public double getTotal() {
        return total;
    }

    public Moto getMoto() {
        return moto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    
    public double calcularTotal() {
        total = moto.calcularPrecioFinal();
        return total;
    }

    public void realizarVenta() throws MotoNoDisponibleException, ClienteNoRegistradoException {
        if (cliente == null) {
            throw new ClienteNoRegistradoException("El cliente no esta registrado.");
        }
        if (!moto.isDisponible()) {
            throw new MotoNoDisponibleException("La moto " + moto.getMarca() + " "
                    + moto.getModelo() + " no esta disponible.");
        }
        calcularTotal();
        moto.setDisponible(false); 
    }

    public void generarFactura() {
        System.out.println("===== FACTURA No. " + numero + " =====");
        System.out.println("Fecha: " + fecha);
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("Vendedor: " + vendedor.getNombre());
        System.out.println("Moto: " + moto.getMarca() + " " + moto.getModelo());
        System.out.printf("Total: $%,.0f%n", total);
        System.out.println("=========================");
    }
}
