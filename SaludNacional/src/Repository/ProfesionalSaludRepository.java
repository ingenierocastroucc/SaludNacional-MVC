package Repository;

import Model.ProfesionalSalud;
import java.util.List;
import java.util.Optional;

public interface ProfesionalSaludRepository {
    ProfesionalSalud crear(ProfesionalSalud p);
    Optional<ProfesionalSalud> porId(String id);
    Optional<ProfesionalSalud> porDocumento(String documento);
    List<ProfesionalSalud> listar();
    List<ProfesionalSalud> porCargo(String cargo);
    List<ProfesionalSalud> porEspecialidad(String especialidad);
    List<ProfesionalSalud> porNombre(String nombreLike);
    ProfesionalSalud actualizar(ProfesionalSalud p);
    boolean eliminar(String id);
    long total();
}
