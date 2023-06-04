package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.VO.Horario;


public class HorarioDAO {

    public void guardar(Connection conexion, Horario horario) throws SQLException {
        try {

            PreparedStatement consulta;
            consulta = conexion.prepareStatement("INSERT INTO horario (codigo_grupo, salon, hora_inicio, hora_fin,  dia_semana) "
                    + "VALUES(?, ?, ?, ?, ?)");
            consulta.setString(1, horario.getGrupo().getId());
            consulta.setString(2, horario.getCodigoSalon());
            consulta.setString(3, horario.getHoraInicio());
            consulta.setString(4, horario.getHoraFin());
            consulta.setString(5, horario.getDiaSemana());
            consulta.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }

}
