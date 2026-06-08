package taller3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaMagia {
    
    private List<Hechizo> catalogoHechizos;
    private List<Mago> listaMagos;

    public SistemaMagia(){
    	
        this.catalogoHechizos = new ArrayList<>();
        this.listaMagos = new ArrayList<>();
    }

   
    public void cargarHechizos(){
    	
        Scanner scanner = null;
        try {
            File archivo = new File("Hechizos.txt");
            
            scanner = new Scanner(archivo);

            while (scanner.hasNextLine()){
            	
                String linea = scanner.nextLine();
                
                String[] partes = linea.split(";");
                
                if (partes.length >= 4){
                	
                    String nombre = partes[0];
                    
                    String tipo = partes[1];
                    
                    int dano = Integer.parseInt(partes[2]);
                    
                    String[] extras = partes[3].split(",");

                    switch (tipo) {
                        case "Fuego":
                            catalogoHechizos.add(new HechizoFuego(nombre, dano, Integer.parseInt(extras[0])));
                            break;

                        case "Tierra":
                            catalogoHechizos.add(new HechizoTierra(nombre, dano, Integer.parseInt(extras[0])));
                            break;  
                            
                        case "Planta":
                            catalogoHechizos.add(new HechizoPlanta(nombre, dano, Integer.parseInt(extras[0]), Integer.parseInt(extras[1])));
                            break;
                            
                        case "Agua":
                            catalogoHechizos.add(new HechizoAgua(nombre, dano, Integer.parseInt(extras[0]), Integer.parseInt(extras[1])));
                            break;
                    }
                }
            }
            System.out.println("Catálogo de hechizos cargado.");
        } catch (FileNotFoundException e) {
            System.out.println("Error: No se encontró el archivo Hechizos.txt");
        } finally {
            if (scanner != null) scanner.close();
        }
    }

    public void cargarMagos(){
    	
        Scanner scanner = null;
        try {
            File archivo = new File("Magos.txt");
            
            scanner = new Scanner(archivo);

            while (scanner.hasNextLine()){
            	
                String linea = scanner.nextLine();
                
                String[] partes = linea.split(";");
                
                if (partes.length >= 2){
                    String nombreMago = partes[0];
                    
                    Mago nuevoMago = new Mago(nombreMago);
                    
                    String[] nombresHechizos = partes[1].split("\\|");

                    for (String nombreH : nombresHechizos){
                        Hechizo hechizoEncontrado = buscarHechizoPorNombre(nombreH);
                        
                        
                        if (hechizoEncontrado != null){
                            nuevoMago.aprenderHechizo(hechizoEncontrado);
                        }
                    }
                    listaMagos.add(nuevoMago);
                }
            }
            System.out.println("Lista de magos cargada correctamente.");
            
        } catch (FileNotFoundException e) {
        	
            System.out.println("Error: No se encontró el archivo Magos.txt");
        } finally {
        	
            if (scanner != null) scanner.close();
        }
    }

 
    public void guardarDatos(){
        //xd
    }

  
    public Hechizo buscarHechizoPorNombre(String nombre){
        for (Hechizo h : catalogoHechizos) {
            if (h.getNombre().equalsIgnoreCase(nombre.trim())) return h;
        }
        return null;
    }

    public Mago buscarMagoPorNombre(String nombre) {
        for (Mago m : listaMagos) {
            if (m.getNombre().equalsIgnoreCase(nombre.trim())) return m;
        }
        return null;
    }

    public void agregarMago(String nombre){
    	
        if (buscarMagoPorNombre(nombre) == null){
        	
            listaMagos.add(new Mago(nombre));
            
            System.out.println("Mago agregado al sistema.");
        } else {
            System.out.println("El mago ya existe.");
        }
    }

    public void eliminarMago(String nombre){
    	
        Mago m = buscarMagoPorNombre(nombre);
        
        if (m != null) {
            listaMagos.remove(m);
            
            System.out.println("Mago eliminado.");
        } else {
            System.out.println("Mago no encontrado.");
        }
    }

    public void agregarHechizoMago(String nombreMago, String nombreHechizo) {
        Mago m = buscarMagoPorNombre(nombreMago);
        
        Hechizo h = buscarHechizoPorNombre(nombreHechizo);
        if (m != null && h != null) {
            m.aprenderHechizo(h);
            System.out.println("Hechizo enseñado con éxito.");
        } else {
            System.out.println("Mago o Hechizo no encontrado.");
        }
    }
    public void mostrarTop10Hechizos() {
        List<Hechizo> copia = new ArrayList<>(catalogoHechizos);
        
        for (int i = 0; i < copia.size() - 1; i++) {
        	
            for (int j = 0; j < copia.size() - i - 1; j++) {
            	
                if (copia.get(j).calcularPuntuacion() < copia.get(j + 1).calcularPuntuacion()) {
                	
                    Hechizo temporal = copia.get(j);
                    
                    copia.set(j, copia.get(j + 1));
                    
                    copia.set(j + 1, temporal);
                    
                }
            }
        }
        
        System.out.println("--- TOP 10 HECHIZOS ---");
        int limite = 10;
        if (copia.size() < 10) {
            limite = copia.size();
        }

        for (int i = 0; i < limite; i++) {
            System.out.println((i + 1) + ". " + copia.get(i).getNombre() + " (Puntos: " + copia.get(i).calcularPuntuacion() + ")");
        }
    }
    public void mostrarTop3Magos(){
        ArrayList<Mago> copia = new ArrayList<>(listaMagos);
        
        for (int i = 0; i < copia.size() - 1; i++) {
        	
            for (int j = 0; j < copia.size() - i - 1; j++) {
                if (copia.get(j).calcularPuntuacionTotal() < copia.get(j + 1).calcularPuntuacionTotal()) {
                    Mago temporal = copia.get(j);
                    copia.set(j, copia.get(j + 1));
                    copia.set(j + 1, temporal);
                }
            }
        }
        
        System.out.println("--- TOP 3 MAGOS ---");
        int limite = 3;
        if (copia.size() < 3) {
            limite = copia.size();
        }

        for (int i = 0; i < limite; i++) {
            System.out.println((i + 1) + ". " + copia.get(i).getNombre() + " (Puntos Totales: " + copia.get(i).calcularPuntuacionTotal() + ")");
        }
    }

    public void mostrarTodosLosMagos() {
        for (Mago m : listaMagos) {
            System.out.println("- Mago: " + m.getNombre() + " | Poder Total: " + m.calcularPuntuacionTotal());
        }
    }

    public void mostrarTodosLosHechizos() {
        for (Hechizo h : catalogoHechizos) {
            System.out.println("- Hechizo: " + h.getNombre() + " (" + h.getTipo() + ") | Poder: " + h.calcularPuntuacion());
        }
    }
}
