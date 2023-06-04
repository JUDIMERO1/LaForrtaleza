package model.VO;

/**
 *
 * 
 */
public class Estudiante {

    private int codigo;
    private String nombre;
    private String direccion;
    private String genero;
    private String correo;

    public Estudiante() {
    }

    public Estudiante(int codigo) {
        this.codigo = codigo;
    }

    public Estudiante(int codigo, String nombre, String direccion, String genero, String correo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.genero = genero;
        this.correo = correo;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
