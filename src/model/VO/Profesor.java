package model.VO;

/**
 *
 * 
 */
public class Profesor {

    private int codigo;
    private String nombre;
    private String titulo;
    private Departamento departamento;

    public Profesor() {
    }

    public Profesor(int codigo) {
        this.codigo = codigo;
    }

    public Profesor(int codigo, String nombre, String titulo, Departamento departamento) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.titulo = titulo;
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

}
