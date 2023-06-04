package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.VO.Matricula;
import java.sql.ResultSet;
import model.VO.Asignatura;
import model.VO.Profesor;



public class MatriculaDAO {

    public void guardar(Connection conexion, Matricula matricula) throws SQLException {
        try {

            PreparedStatement consulta;
            consulta = conexion.prepareStatement("INSERT INTO matricula (codigo_estudiante, id_grupo) "
                    + "VALUES(?, ?)");
            consulta.setInt(1, matricula.getEstudiante().getCodigo());
            consulta.setString(2, matricula.getGrupo().getId());
            consulta.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }

    public void mostrarAsignatura(Connection conexion, JTable tablaAsignatura, int codigo) throws SQLException {
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Codigo");
        model.addColumn("Nombre");
        model.addColumn("Créditos");
        model.addColumn("Programa");

        try {
            PreparedStatement consulta;
            consulta = conexion.prepareStatement("SELECT * FROM asignatura WHERE codigo = ?");
            consulta.setInt(1, codigo);
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                Object[] lista = {resultado.getInt(1), resultado.getString(2), resultado.getInt(3), resultado.getInt(4)};
                model.addRow(lista);
            }
            tablaAsignatura.setModel(model);
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }

    public void mostrarHorariosPorAsignatura(Connection conexion, JTable tablaHorarios, int codigoAsignatura) throws SQLException {
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Grupo");
        model.addColumn("Salon");
        model.addColumn("Hora inicio");
        model.addColumn("Hora fin");
        model.addColumn("Día");

        try {
            PreparedStatement consulta;
            consulta = conexion.prepareStatement("SELECT g.id_grupo, h.salon, h.hora_inicio, h.hora_fin, h.dia_semana "
                    + "FROM asignatura a "
                    + "INNER JOIN grupo g ON a.codigo = g.codigo_asignatura "
                    + "INNER JOIN horario h ON g.id_grupo = h.codigo_grupo "
                    + "WHERE a.codigo = ?");
            consulta.setInt(1, codigoAsignatura);
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                Object[] lista = {resultado.getString("id_grupo"), resultado.getString("salon"), resultado.getString("hora_inicio"),
                    resultado.getString("hora_fin"), resultado.getString("dia_semana")};
                model.addRow(lista);
            }
            tablaHorarios.setModel(model);
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }

    public void matricularEstudianteEnGrupo(Connection conexion, Matricula matricula) throws SQLException {
        try {
            PreparedStatement consulta;
            consulta = conexion.prepareStatement("INSERT INTO matricula (codigo_estudiante, id_grupo) "
                    + "VALUES (?, ?)");
            consulta.setInt(1, matricula.getEstudiante().getCodigo());
            consulta.setString(2, matricula.getGrupo().getId());
            consulta.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }

    public Profesor obtenerProfesorGrupo(Connection conexion, String idGrupo) throws SQLException {
        try {
            PreparedStatement consulta = conexion.prepareStatement("SELECT p.* "
                    + "FROM grupo g "
                    + "INNER JOIN profesor p ON g.codigo_profesor = p.codigo "
                    + "WHERE g.id_grupo = ?");
            consulta.setString(1, idGrupo);
            ResultSet resultado = consulta.executeQuery();

            if (resultado.next()) {
                Profesor profesor = new Profesor();
                profesor.setCodigo(resultado.getInt("codigo"));
                profesor.setNombre(resultado.getString("nombre"));
                // Obtener más atributos del profesor según tu estructura de tabla

                return profesor;
            } else {
                return null; // No se encontró profesor para el grupo dado
            }
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }

    public Asignatura obtenerAsignaturaGrupo(Connection conexion, String idGrupo) throws SQLException {
        try {
            PreparedStatement consulta = conexion.prepareStatement("SELECT a.* "
                    + "FROM grupo g "
                    + "INNER JOIN asignatura a ON g.codigo_asignatura = a.codigo "
                    + "WHERE g.id_grupo = ?");
            consulta.setString(1, idGrupo);
            ResultSet resultado = consulta.executeQuery();

            if (resultado.next()) {
                Asignatura asignatura = new Asignatura();
                asignatura.setCodigo(resultado.getInt("codigo"));
                asignatura.setNombre(resultado.getString("nombre"));
                asignatura.setCreditos(resultado.getInt("creditos"));

                return asignatura;
            } else {
                return null; // No se encontró asignatura para el grupo dado
            }
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }

}
