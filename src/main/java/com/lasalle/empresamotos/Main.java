/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.lasalle.empresamotos;
import com.lasalle.empresamotos.excepciones.ClienteNoRegistradoException;
import com.lasalle.empresamotos.excepciones.MotoNoDisponibleException;
import com.lasalle.empresamotos.excepciones.PrecioInvalidoException;
import com.lasalle.empresamotos.modelo.Cliente;
import com.lasalle.empresamotos.modelo.Moto;
import com.lasalle.empresamotos.modelo.MotoDeportiva;
import com.lasalle.empresamotos.modelo.MotoUrbana;
import com.lasalle.empresamotos.modelo.Vendedor;
import com.lasalle.empresamotos.servicio.EmpresaMotos;
import java.time.LocalDate;
import java.util.Scanner;
/**
 *
 * @author Usuario
 */
public class Main {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        EmpresaMotos empresa = new EmpresaMotos("Motos La Salle");
        Vendedor vendedor = new Vendedor("Laura Perez", "V-001");
        int numeroVenta = 1;
        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero("Elija una opcion: ");
            System.out.println();

            switch (opcion) {
                case 1:
                    registrarDeportiva(empresa);
                    break;
                case 2:
                    registrarUrbana(empresa);
                    break;
                case 3:
                    empresa.mostrarInventario();
                    break;
                case 4:
                    buscarMoto(empresa);
                    break;
                case 5:
                    registrarCliente(empresa);
                    break;
                case 6:
                    if (realizarVenta(empresa, vendedor, numeroVenta)) {
                        numeroVenta++;
                    }
                    break;
                case 0:
                    System.out.println("Hasta luego.");
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }
            System.out.println();
        } while (opcion != 0);
    }

    private static void mostrarMenu() {
        System.out.println("========== EMPRESA DE MOTOS ==========");
        System.out.println("1. Registrar moto deportiva");
        System.out.println("2. Registrar moto urbana");
        System.out.println("3. Mostrar inventario");
        System.out.println("4. Buscar moto por modelo");
        System.out.println("5. Registrar cliente");
        System.out.println("6. Realizar venta");
        System.out.println("0. Salir");
        System.out.println("======================================");
    }

    private static void registrarDeportiva(EmpresaMotos empresa) {
        String marca = leerTexto("Marca: ");
        String modelo = leerTexto("Modelo: ");
        double precio = leerDouble("Precio: ");
        int cilindrada = leerEntero("Cilindrada (cc): ");
        try {
            empresa.registrarMoto(new MotoDeportiva(marca, modelo, precio, cilindrada));
        } catch (PrecioInvalidoException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void registrarUrbana(EmpresaMotos empresa) {
        String marca = leerTexto("Marca: ");
        String modelo = leerTexto("Modelo: ");
        double precio = leerDouble("Precio: ");
        double consumo = leerDouble("Consumo (km/gal): ");
        try {
            empresa.registrarMoto(new MotoUrbana(marca, modelo, precio, consumo));
        } catch (PrecioInvalidoException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void buscarMoto(EmpresaMotos empresa) {
        String modelo = leerTexto("Modelo a buscar: ");
        Moto moto = empresa.buscarMoto(modelo);
        if (moto == null) {
            System.out.println("Moto no encontrada.");
        } else {
            moto.mostrarInformacion();
        }
    }

    private static void registrarCliente(EmpresaMotos empresa) {
        String nombre = leerTexto("Nombre: ");
        String documento = leerTexto("Documento: ");
        if (empresa.buscarCliente(documento) != null) {
            System.out.println("Ya existe un cliente con ese documento.");
            return;
        }
        empresa.registrarCliente(new Cliente(nombre, documento));
    }

    private static boolean realizarVenta(EmpresaMotos empresa, Vendedor vendedor, int numero) {
        String documento = leerTexto("Documento del cliente: ");
        
        Cliente cliente = empresa.buscarCliente(documento);

        String modelo = leerTexto("Modelo de la moto: ");
        Moto moto = empresa.buscarMoto(modelo);
        if (moto == null) {
            System.out.println("Moto no encontrada.");
            return false;
        }

        try {
            vendedor.realizarVenta(numero, LocalDate.now().toString(), moto, cliente);
            return true;
        } catch (ClienteNoRegistradoException | MotoNoDisponibleException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    

    private static String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return sc.nextLine().trim();
    }

    private static int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un numero entero valido.");
            }
        }
    }

    private static double leerDouble(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Double.parseDouble(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un numero valido.");
            }
        }
    }
}