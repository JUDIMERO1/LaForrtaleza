package model.VO;

/**
 *
 * 
 */
public class Asignatura {

    private int codigo;
    private String nombre;
    private int creditos;
    private Programa programa;

    public Asignatura() {
    }

    public Asignatura(int codigo) {
        this.codigo = codigo;
    }

    public Asignatura(int codigo, String nombre, int creditos, Programa programa) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
        this.programa = programa;
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

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public Programa getPrograma() {
        return programa;
    }

    public void setPrograma(Programa programa) {
        this.programa = programa;
    }

}
