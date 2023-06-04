package model.VO;

/**
 *
 * 
 */
public class Departamento {

    private int codigo;
    private String nombre;
    private String ubicacion;

    public Departamento() {
    }

    public Departamento(int codigo) {
        this.codigo = codigo;
    }

    public Departamento(int codigo, String nombre, String ubicacion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
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

}
