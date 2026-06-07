package asdasdasd;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaMagia {
    
    private ArrayList<Hechizo> catalogoHechizos;
    
    private ArrayList<Mago> listaMagos;

    public SistemaMagia(){
    	
        this.catalogoHechizos = new ArrayList<>();
        
        this.listaMagos = new ArrayList<>();
    }

    
    public void cargarHechizos(){
        Scanner scanner = null;
        
        try {
            File archivo = new File("Hechizos.txt");
            
            scanner = new Scanner(archivo);
            
            while (scanner.hasNextLine()) {
            	
                String linea = scanner.nextLine();
                
                String[] partes = linea.split(";");
                
                if (partes.length >= 4) {
                	
                    String nombre = partes[0];
                    
                    String tipo = partes[1];
                    
                    int dano = Integer.parseInt(partes[2]);
                    
                    String[] extras = partes[3].split(",");

                    switch (tipo) {
                        case "Fuego":
                        	
                            int quemadura = Integer.parseInt(extras[0]);
                            catalogoHechizos.add(new HechizoFuego(nombre, dano, quemadura));
                            break;
                            
                        case "Tierra":
                        	
                            int defensa = Integer.parseInt(extras[0]);
                            catalogoHechizos.add(new HechizoTierra(nombre, dano, defensa));
                            break;
                            
                        case "Planta":
                        	
                            int stun = Integer.parseInt(extras[0]);
                            int cantPlantas = Integer.parseInt(extras[1]);
                            catalogoHechizos.add(new HechizoPlanta(nombre, dano, stun, cantPlantas));
                            break;
                            
                        case "Agua":
                        	
                            int heal = Integer.parseInt(extras[0]);
                            int presion = Integer.parseInt(extras[1]);
                            catalogoHechizos.add(new HechizoAgua(nombre, dano, heal, presion));
                            break;
                            
                        default:
                            throw new IllegalArgumentException("Elemento desconocido: " + tipo);
                    }
                    
                }

            }
            System.out.println("Catálogo de hechizos cargado correctamente.");

        } catch (FileNotFoundException e) {
            System.out.println("Error: No se encontró el archivo Hechizos.txt");
        } catch (IllegalArgumentException e) {
            System.out.println("Error en los datos: " + e.getMessage());
        } finally {

            if (scanner != null) {
                scanner.close();
            }
        }
    }

    private Hechizo buscarHechizoPorNombre(String nombreHechizo) {
        for (Hechizo h : catalogoHechizos) {
            if (h.getNombre().equals(nombreHechizo)) {
                return h;
            }
        }
        return null;
    }

    public void cargarMagos() {
        Scanner scanner = null;
        try {
            File archivo = new File("Magos.txt");
            scanner = new Scanner(archivo);


            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] partes = linea.split(";");

                if (partes.length >= 2) {
                    String nombreMago = partes[0];
                    Mago nuevoMago = new Mago(nombreMago);

                    String[] nombresHechizos = partes[1].split("\\|");

                    for (String nombreH : nombresHechizos) {
                        Hechizo hechizoEncontrado = buscarHechizoPorNombre(nombreH);
                        
                        if (hechizoEncontrado != null) {
                            nuevoMago.aprenderHechizo(hechizoEncontrado);
                        } else {
                            System.out.println("Advertencia: El hechizo '" + nombreH + "' del mago " + nombreMago + " no está en el catálogo.");
                        }
                    }
                    
                    listaMagos.add(nuevoMago);
                }
            
            }
            System.out.println("Lista de magos cargada.");

        } catch (FileNotFoundException e) {
            System.out.println("Error: No se encontró el archivo Magos.txt");
        } catch (Exception e) {
            System.out.println("Error al leer los magos: " + e.getMessage());
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
    
    public ArrayList<Hechizo> getCatalogoHechizos() {
    	return catalogoHechizos; }
    public ArrayList<Mago> getListaMagos() {
    	return listaMagos; 
    	}


}