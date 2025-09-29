package View;

import Model.ProfesionalSalud;

import java.util.List;
import java.util.Scanner;

public class ProfesionalSaludView {

    private final Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {
        System.out.println("\n===== Sistema Nacional de Salud =====");
        System.out.println("1. Registrar profesional");
        System.out.println("2. Listar todos los profesionales");
        System.out.println("3. Buscar por ID");
        System.out.println("4. Buscar por Documento");
        System.out.println("5. Buscar por Cargo");
        System.out.println("6. Buscar por Especialidad");
        System.out.println("7. Buscar por Nombre");
        System.out.println("8. Actualizar profesional");
        System.out.println("9. Eliminar profesional");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public int leerOpcion() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            return -1;
        }
    }

    public String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    public double leerDouble(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Double.parseDouble(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Entrada inválida. Intente de nuevo.");
            }
        }
    }

    public ProfesionalSalud leerProfesional() {
        String id = leerTexto("ID: ");
        String nombres = leerTexto("Nombres: ");
        String apellidos = leerTexto("Apellidos: ");
        String documento = leerTexto("Documento: ");
        String cargo = leerTexto("Cargo: ");
        String especialidad = leerTexto("Especialidad: ");
        String area = leerTexto("Área de atención: ");
        double salario = leerDouble("Salario: ");
        return new ProfesionalSalud(id, nombres, apellidos, documento, cargo, especialidad, area, salario);
    }

    public ProfesionalSalud leerProfesionalConId(String id) {
        String nombres = leerTexto("Nombres: ");
        String apellidos = leerTexto("Apellidos: ");
        String documento = leerTexto("Documento: ");
        String cargo = leerTexto("Cargo: ");
        String especialidad = leerTexto("Especialidad: ");
        String area = leerTexto("Área de atención: ");
        double salario = leerDouble("Salario: ");
        return new ProfesionalSalud(id, nombres, apellidos, documento, cargo, especialidad, area, salario);
    }

    public void mostrarLista(List<ProfesionalSalud> lista) {
        if (lista.isEmpty()) {
            System.out.println("No se encontraron profesionales.");
        } else {
            lista.forEach(System.out::println);
        }
    }

    public void mostrarProfesional(ProfesionalSalud p) {
        System.out.println(p);
    }

    public void mostrarMensaje(String msg) {
        System.out.println(msg);
    }

    public void mostrarError(String msg) {
        System.err.println("Error: " + msg);
    }
}