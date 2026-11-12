/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lasalle.empresamotos.servicio;
import com.lasalle.empresamotos.modelo.Cliente;
import com.lasalle.empresamotos.modelo.Moto;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Usuario
 */
public class EmpresaMotos {

    private String nombre;
    private List<Moto> inventario;
    private List<Cliente> clientes;

    public EmpresaMotos(String nombre) {
        this.nombre = nombre;
        this.inventario = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Moto> getInventario() {
        return inventario;
    }

    public void registrarMoto(Moto moto) {
        inventario.add(moto);
        System.out.println("Moto registrada: " + moto.getMarca() + " " + moto.getModelo());
    }

    
    public Moto buscarMoto(String modelo) {
        for (Moto moto : inventario) {
            if (moto.getModelo().equalsIgnoreCase(modelo)) {
                return moto;
            }
        }
        return null;
    }

    public void mostrarInventario() {
        System.out.println("===== INVENTARIO DE " + nombre + " =====");
        if (inventario.isEmpty()) {
            System.out.println("No hay motos registradas.");
        }
        for (Moto moto : inventario) {
            moto.mostrarInformacion(); 
            System.out.println("-----------------------");
        }
    }

    public void registrarCliente(Cliente cliente) {
        clientes.add(cliente);
        System.out.println("Cliente registrado: " + cliente.getNombre());
    }

    
    public Cliente buscarCliente(String documento) {
        for (Cliente cliente : clientes) {
            if (cliente.getDocumento().equals(documento)) {
                return cliente;
            }
        }
        return null;
    }
}