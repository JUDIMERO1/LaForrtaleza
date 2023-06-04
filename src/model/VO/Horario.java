package model.VO;

/**
 *
 * 
 */
public class Horario {

    private Grupo grupo;
    private String codigoSalon;
    private String horaInicio;
    private String horaFin;
    private String diaSemana;

    public Horario() {
    }

    public Horario(String codigoSalon) {
        this.codigoSalon = codigoSalon;
    }

    public Horario(Grupo grupo, String codigoSalon, String horaInicio, String horaFin, String diaSemana) {
        this.grupo = grupo;
        this.codigoSalon = codigoSalon;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.diaSemana = diaSemana;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public String getCodigoSalon() {
        return codigoSalon;
    }

    public void setCodigoSalon(String codigoSalon) {
        this.codigoSalon = codigoSalon;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

}
