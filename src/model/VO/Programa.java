package model.VO;


public class Programa {

    private int codigo;
    private String nombre;
    private String ubicacion;
    private Profesor profesor;
    private Departamento departamento;

    public Programa() {
    }

    public Programa(int codigo) {
        this.codigo = codigo;
    }

    public Programa(int codigo, String nombre, String ubicacion, Profesor profesor, Departamento departamento) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.profesor = profesor;
        this.departamento = departamento;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profrsor) {
        this.profesor = profesor;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

}
