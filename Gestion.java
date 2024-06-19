import java.util.ArrayList;
import java.util.Scanner;
public class Gestion{
    private ArrayList<Estudiante> estudiantes = new ArrayList<>();

    public void agregarEstudiante(String nombre, String apellido, int edad, String codigo) {
        Estudiante estudiante = new Estudiante(nombre, apellido, edad, codigo);
        estudiantes.add(estudiante);
        System.out.println("Estudiante agregado con éxito.");
    }

    public void listarEstudiantes() {
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
        } else {
            System.out.println("Lista de estudiantes registrados:");
            for (Estudiante estudiante : estudiantes) {
                System.out.println(estudiante);
            }
        }
    }

    public void buscarEstudiantePorCodigo(String codigo) {
        boolean encontrado = false;
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getCodigo().equals(codigo)) {
                System.out.println("Estudiante encontrado: " + estudiante);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontró un estudiante con el código de estudiante proporcionado.");
        }
    }
    
    public class Main {
    public static void main(String[] args) {
        Gestion gestion = new Gestion();
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\nMenú de opciones:");
            System.out.println("1. Agregar Estudiante");
            System.out.println("2. Listar Estudiantes");
            System.out.println("3. Buscar Estudiante por Código de Estudiante");
            System.out.println("4. Salir del Programa");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del estudiante: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el apellido del estudiante: ");
                    String apellido = scanner.nextLine();
                    System.out.print("Ingrese la edad del estudiante: ");
                    int edad = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Ingrese el código de estudiante: ");
                    String codigoEstudiante = scanner.nextLine();
                    gestion.agregarEstudiante(nombre, apellido, edad, codigoEstudiante);
                    break;
                case 2:
                    gestion.listarEstudiantes();
                    break;
                case 3:
                    System.out.print("Ingrese el código de estudiante: ");
                    String codigoBuscar = scanner.nextLine();
                    gestion.buscarEstudiantePorCodigo(codigoBuscar);
                    break;
                case 4:
                    salir = true;
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }

        scanner.close();
    }
}
}

