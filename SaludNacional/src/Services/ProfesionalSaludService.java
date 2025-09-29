package Services;

import Model.ProfesionalSalud;
import Repository.ProfesionalSaludRepository;

import java.util.List;
import java.util.Optional;

public class ProfesionalSaludService {

    private final ProfesionalSaludRepository repository;

    public ProfesionalSaludService(ProfesionalSaludRepository repository) {
        this.repository = repository;
    }

    // Crear un nuevo profesional
    public ProfesionalSalud crearProfesional(ProfesionalSalud profesional) {
        return repository.crear(profesional);
    }

    // Buscar por ID
    public Optional<ProfesionalSalud> buscarPorId(String id) {
        return repository.porId(id);
    }

    // Buscar por documento
    public Optional<ProfesionalSalud> buscarPorDocumento(String documento) {
        return repository.porDocumento(documento);
    }

    // Listar todos
    public List<ProfesionalSalud> listarTodos() {
        return repository.listar();
    }

    // Buscar por cargo
    public List<ProfesionalSalud> buscarPorCargo(String cargo) {
        return repository.porCargo(cargo);
    }

    // Buscar por especialidad
    public List<ProfesionalSalud> buscarPorEspecialidad(String especialidad) {
        return repository.porEspecialidad(especialidad);
    }

    // Buscar por nombre
    public List<ProfesionalSalud> buscarPorNombre(String nombre) {
        return repository.porNombre(nombre);
    }

    // Actualizar un profesional
    public ProfesionalSalud actualizarProfesional(ProfesionalSalud profesional) {
        return repository.actualizar(profesional);
    }

    // Eliminar por ID
    public boolean eliminarProfesional(String id) {
        return repository.eliminar(id);
    }

    // Total de profesionales registrados
    public long contarProfesionales() {
        return repository.total();
    }
}
