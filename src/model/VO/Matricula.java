package model.VO;

/**
 *
 * @author JUAN D MELENDEZ
 */
public class Matricula {

    private Estudiante estudiante;
    private Grupo grupo;

    public Matricula() {
    }

    public Matricula(Estudiante estudiante, Grupo grupo) {
        this.estudiante = estudiante;
        this.grupo = grupo;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

}
