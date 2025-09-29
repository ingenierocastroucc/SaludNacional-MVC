package App;

import Controller.ProfesionalSaludController;
import Repository.InMemoryProfesionalSaludRepository;
import Repository.ProfesionalSaludRepository;
import Services.ProfesionalSaludService;
import View.ProfesionalSaludView;

public class App {
    public static void main(String[] args) {
        // Instancias de infraestructura
        ProfesionalSaludRepository repo = new InMemoryProfesionalSaludRepository();
        ProfesionalSaludService service = new ProfesionalSaludService(repo);
        ProfesionalSaludView vista = new ProfesionalSaludView();

        // Controlador
        ProfesionalSaludController controlador = new ProfesionalSaludController(service, vista);

        // Iniciar aplicación
        controlador.iniciar();
    }
}
