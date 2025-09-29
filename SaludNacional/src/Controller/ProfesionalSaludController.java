package Controller;

import Model.ProfesionalSalud;
import Services.ProfesionalSaludService;
import View.ProfesionalSaludView;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ProfesionalSaludController {

    private final ProfesionalSaludService service;
    private final ProfesionalSaludView vista;
    private final Scanner scanner = new Scanner(System.in);

    public ProfesionalSaludController(ProfesionalSaludService service, ProfesionalSaludView vista) {
        this.service = service;
        this.vista = vista;
    }

    public void iniciar() {
        boolean salir = false;
        while (!salir) {
            vista.mostrarMenu();
            int opcion = vista.leerOpcion();
            switch (opcion) {
                case 1 -> registrarProfesional();
                case 2 -> listarProfesionales();
                case 3 -> buscarPorId();
                case 4 -> buscarPorDocumento();
                case 5 -> buscarPorCargo();
                case 6 -> buscarPorEspecialidad();
                case 7 -> buscarPorNombre();
                case 8 -> actualizarProfesional();
                case 9 -> eliminarProfesional();
                case 0 -> {
                    vista.mostrarMensaje("Saliendo del sistema...");
                    salir = true;
                }
                default -> vista.mostrarError("Opción no válida");
            }
        }
    }

    private void registrarProfesional() {
        ProfesionalSalud p = vista.leerProfesional();
        service.crearProfesional(p);
        vista.mostrarMensaje("Profesional registrado exitosamente.");
    }

    private void listarProfesionales() {
        List<ProfesionalSalud> lista = service.listarTodos();
        vista.mostrarLista(lista);
    }

    private void buscarPorId() {
        String id = vista.leerTexto("Ingrese ID: ");
        Optional<ProfesionalSalud> resultado = service.buscarPorId(id);
        resultado.ifPresentOrElse(
                vista::mostrarProfesional,
                () -> vista.mostrarError("No se encontró profesional con ese ID.")
        );
    }

    private void buscarPorDocumento() {
        String doc = vista.leerTexto("Ingrese documento: ");
        Optional<ProfesionalSalud> resultado = service.buscarPorDocumento(doc);
        resultado.ifPresentOrElse(
                vista::mostrarProfesional,
                () -> vista.mostrarError("No se encontró profesional con ese documento.")
        );
    }

    private void buscarPorCargo() {
        String cargo = vista.leerTexto("Ingrese cargo: ");
        vista.mostrarLista(service.buscarPorCargo(cargo));
    }

    private void buscarPorEspecialidad() {
        String especialidad = vista.leerTexto("Ingrese especialidad: ");
        vista.mostrarLista(service.buscarPorEspecialidad(especialidad));
    }

    private void buscarPorNombre() {
        String nombre = vista.leerTexto("Ingrese nombre o apellido: ");
        vista.mostrarLista(service.buscarPorNombre(nombre));
    }

    private void actualizarProfesional() {
        String id = vista.leerTexto("Ingrese ID a actualizar: ");
        Optional<ProfesionalSalud> existente = service.buscarPorId(id);
        if (existente.isPresent()) {
            ProfesionalSalud actualizado = vista.leerProfesionalConId(id);
            service.actualizarProfesional(actualizado);
            vista.mostrarMensaje("Profesional actualizado correctamente.");
        } else {
            vista.mostrarError("No existe un profesional con ese ID.");
        }
    }

    private void eliminarProfesional() {
        String id = vista.leerTexto("Ingrese ID a eliminar: ");
        if (service.eliminarProfesional(id)) {
            vista.mostrarMensaje("Profesional eliminado correctamente.");
        } else {
            vista.mostrarError("No se encontró profesional con ese ID.");
        }
    }
}