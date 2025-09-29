package Repository;

import Model.ProfesionalSalud;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class InMemoryProfesionalSaludRepository implements ProfesionalSaludRepository {

    private final List<ProfesionalSalud> tabla = new ArrayList<>();
    // Índices para búsquedas rápidas
    private final Map<String, ProfesionalSalud> idxId = new ConcurrentHashMap<>();
    private final Map<String, ProfesionalSalud> idxDocumento = new ConcurrentHashMap<>();

    @Override
    public synchronized ProfesionalSalud crear(ProfesionalSalud p) {
        if (idxId.containsKey(p.getId())) throw new IllegalArgumentException("ID duplicado");
        if (idxDocumento.containsKey(p.getDocumento())) throw new IllegalArgumentException("Documento duplicado");
        tabla.add(p);
        idxId.put(p.getId(), p);
        idxDocumento.put(p.getDocumento(), p);
        return p;
    }

    @Override
    public Optional<ProfesionalSalud> porId(String id) {
        return Optional.ofNullable(idxId.get(id));
    }

    @Override
    public Optional<ProfesionalSalud> porDocumento(String documento) {
        return Optional.ofNullable(idxDocumento.get(documento));
    }

    @Override
    public List<ProfesionalSalud> listar() {
        return List.copyOf(tabla);
    }

    @Override
    public List<ProfesionalSalud> porCargo(String cargo) {
        String c = cargo == null ? "" : cargo.trim().toLowerCase();
        return tabla.stream()
                .filter(p -> p.getCargo().toLowerCase().contains(c))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProfesionalSalud> porEspecialidad(String especialidad) {
        String e = especialidad == null ? "" : especialidad.trim().toLowerCase();
        return tabla.stream()
                .filter(p -> p.getEspecialidad().toLowerCase().contains(e))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProfesionalSalud> porNombre(String nombreLike) {
        String n = nombreLike == null ? "" : nombreLike.trim().toLowerCase();
        return tabla.stream()
                .filter(p -> (p.getNombres() + " " + p.getApellidos()).toLowerCase().contains(n))
                .collect(Collectors.toList());
    }

    @Override
    public synchronized ProfesionalSalud actualizar(ProfesionalSalud p) {
        ProfesionalSalud actual = idxId.get(p.getId());
        if (actual == null) throw new NoSuchElementException("No existe ID " + p.getId());

        if (!actual.getDocumento().equals(p.getDocumento()) &&
                idxDocumento.containsKey(p.getDocumento())) {
            throw new IllegalArgumentException("Documento ya usado por otro profesional");
        }

        // Reindexar documento si cambió
        idxDocumento.remove(actual.getDocumento());
        idxDocumento.put(p.getDocumento(), p);

        // Reemplazar en la tabla
        int i = tabla.indexOf(actual);
        tabla.set(i, p);
        idxId.put(p.getId(), p);
        return p;
    }

    @Override
    public synchronized boolean eliminar(String id) {
        ProfesionalSalud actual = idxId.remove(id);
        if (actual == null) return false;
        idxDocumento.remove(actual.getDocumento());
        return tabla.remove(actual);
    }

    @Override
    public long total() {
        return tabla.size();
    }
}