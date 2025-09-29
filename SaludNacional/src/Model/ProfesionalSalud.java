package Model;

import java.util.Objects;

public class ProfesionalSalud {
    private final String id;           // UUID o código interno
    private String nombres;
    private String apellidos;
    private String documento;          // CC/NIT/TI
    private String cargo;              // Médico, Enfermero, Adm., etc.
    private String especialidad;       // Medicina Interna, Pediatría, etc.
    private String areaAtencion;       // Urgencias, UCI, Consulta Externa
    private double salario;

    public ProfesionalSalud(String id, String nombres, String apellidos, String documento,
                            String cargo, String especialidad, String areaAtencion, double salario) {
        this.id = Objects.requireNonNull(id, "id requerido");
        setNombres(nombres);
        setApellidos(apellidos);
        setDocumento(documento);
        setCargo(cargo);
        setEspecialidad(especialidad);
        setAreaAtencion(areaAtencion);
        setSalario(salario);
    }

    // Getters
    public String getId() { return id; }
    public String getNombres() { return nombres; }
    public String getApellidos() { return apellidos; }
    public String getDocumento() { return documento; }
    public String getCargo() { return cargo; }
    public String getEspecialidad() { return especialidad; }
    public String getAreaAtencion() { return areaAtencion; }
    public double getSalario() { return salario; }

    // Setters con validación básica
    public void setNombres(String nombres) {
        if (nombres == null || nombres.isBlank()) throw new IllegalArgumentException("nombres vacíos");
        this.nombres = nombres.trim();
    }
    public void setApellidos(String apellidos) {
        if (apellidos == null || apellidos.isBlank()) throw new IllegalArgumentException("apellidos vacíos");
        this.apellidos = apellidos.trim();
    }
    public void setDocumento(String documento) {
        if (documento == null || documento.isBlank()) throw new IllegalArgumentException("documento vacío");
        this.documento = documento.trim();
    }
    public void setCargo(String cargo) {
        if (cargo == null || cargo.isBlank()) throw new IllegalArgumentException("cargo vacío");
        this.cargo = cargo.trim();
    }
    public void setEspecialidad(String especialidad) {
        if (especialidad == null) especialidad = "";
        this.especialidad = especialidad.trim();
    }
    public void setAreaAtencion(String areaAtencion) {
        if (areaAtencion == null) areaAtencion = "";
        this.areaAtencion = areaAtencion.trim();
    }
    public void setSalario(double salario) {
        if (salario < 0) throw new IllegalArgumentException("salario inválido");
        this.salario = salario;
    }

    @Override public String toString() {
        return String.format("%s | %s %s | Doc:%s | Cargo:%s | Esp:%s | Área:%s | $%.2f",
                id, nombres, apellidos, documento, cargo, especialidad, areaAtencion, salario);
    }
}
