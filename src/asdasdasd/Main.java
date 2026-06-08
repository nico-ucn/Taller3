package taller3;
//Nicolas Lucero
// 22.221.136-0
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemaMagia sistema = new SistemaMagia();

        System.out.println("Cargando base de datos del mundo mágico...");
        sistema.cargarHechizos(); 
        sistema.cargarMagos();    

        boolean salir = false;

        while (salir == false) {
            System.out.println(); 
            System.out.println("=== SISTEMA DE MAGIA: MENÚ PRINCIPAL ===");
            System.out.println("1. Panel Administrador");
            System.out.println("2. Panel Analista");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                int opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1:
                        menuAdministrador(scanner, sistema);
                        break;
                    case 2:
                        menuAnalista(scanner, sistema);
                        break;
                    case 3:
                        salir = true; 
                        System.out.println();
                        System.out.println("Guardando datos en los archivos de texto...");
                        sistema.guardarDatos(); 
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, ingrese 1, 2 o 3.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un número entero válido.");
            } catch (Exception e) {
                System.out.println("Ocurrió un error inesperado: " + e.getMessage());
            }
        }
        
        scanner.close();
    }

    private static void menuAdministrador(Scanner scanner, SistemaMagia sistema) {
        boolean volver = false;

        while (volver == false){
        	
            System.out.println(); 
            System.out.println("--- PANEL ADMINISTRADOR (CRUD) ---");
            System.out.println("1. Agregar un Mago nuevo");
            System.out.println("2. Enseñar Hechizo a Mago existente");
            System.out.println("3. Eliminar un Mago");
            System.out.println("4. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");

            try {
                int opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion){
                    case 1:
                        System.out.print("Ingrese el nombre del nuevo mago: ");
                        String nuevoNombre = scanner.nextLine();
                        if (nuevoNombre.isEmpty() == false){
                            sistema.agregarMago(nuevoNombre);
                        } else {
                            System.out.println("El nombre no puede estar vacío.");
                        }
                        break;
                    case 2:
                        System.out.print("Ingrese el nombre del mago: ");
                        String nomMago = scanner.nextLine();
                        System.out.print("Ingrese el nombre del hechizo a enseñar: ");
                        String nomHechizo = scanner.nextLine();
                        sistema.agregarHechizoMago(nomMago, nomHechizo);
                        break;
                    case 3:
                        System.out.print("Ingrese el nombre del mago a eliminar: ");
                        String magoBorrar = scanner.nextLine();
                        sistema.eliminarMago(magoBorrar);
                        break;
                    case 4:
                        volver = true; 
                        break;
                    default:
                        System.out.println("Opción no válida. Rango permitido: 1-4.");
                }
            } catch (NumberFormatException e){
                System.out.println("Error: Entrada inválida. Ingrese solo números.");
            }
        }
    }

    private static void menuAnalista(Scanner scanner, SistemaMagia sistema) {
        boolean volver = false;

        while (volver == false) {
            System.out.println(); 
            System.out.println("--- PANEL ANALISTA (REPORTES) ---");
            System.out.println("1. Top 10 Mejores Hechizos");
            System.out.println("2. Top 3 Mejores Magos");
            System.out.println("3. Mostrar todos los Hechizos");
            System.out.println("4. Mostrar todos los Magos");
            System.out.println("5. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");

            try {
                int opcion = Integer.parseInt(scanner.nextLine() );

                switch (opcion){
                    case 1:
                        System.out.println();
                        sistema.mostrarTop10Hechizos();
                        break;
                    case 2:
                        System.out.println();
                        sistema.mostrarTop3Magos();
                        break;
                    case 3:
                        System.out.println();
                        sistema.mostrarTodosLosHechizos();
                        break;
                    case 4:
                        System.out.println();
                        sistema.mostrarTodosLosMagos();
                        break;
                    case 5:
                        volver = true; 
                        break;
                    default:
                        System.out.println("Opción no válida. Rango permitido: 1-5.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Entrada inválida. Ingrese solo números.");
            }
        }
    }
}
