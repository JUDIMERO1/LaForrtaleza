package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.VO.Estudiante;
import java.sql.ResultSet;



public class EstudianteDAO {

    public void guardar(Connection conexion, Estudiante estudiante) throws SQLException {
        try {

            PreparedStatement consulta;
            consulta = conexion.prepareStatement("INSERT INTO estudiante (codigo, nombre, direccion, genero, correo) "
                    + "VALUES(?, ?, ?, ? ,?)");
            consulta.setInt(1, estudiante.getCodigo());
            consulta.setString(2, estudiante.getNombre());
            consulta.setString(3, estudiante.getDireccion());
            consulta.setString(4, estudiante.getGenero());
            consulta.setString(5, estudiante.getCorreo());
            consulta.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }

    public void mostrarEstudiante(Connection conexion, JTable tablaEstudiante) throws SQLException {

        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Codigo");
        model.addColumn("Nombre");
        model.addColumn("Dirección");
        model.addColumn("Genero");
        model.addColumn("Correo");

        try {
            PreparedStatement consulta = conexion.prepareStatement("SELECT * FROM estudiante");
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {

                Object[] lista = {resultado.getInt(1), resultado.getString(2), resultado.getString(3), resultado.getString(4),
                    resultado.getString(5)};
                model.addRow(lista);

            }

            tablaEstudiante.setModel(model);

        } catch (SQLException ex) {
            throw new SQLException(ex);
        }

    }
}
