package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.VO.Profesor;
import java.sql.ResultSet;

public class ProfesorDAO {

    public void guardar(Connection conexion, Profesor profesor) throws SQLException {
        try {
            

            PreparedStatement consulta;
            consulta = conexion.prepareStatement("INSERT INTO profesor ( codigo, nombre, titulo, codigo_departamento) "
                    + "VALUES(?, ?, ?, ?)");
            consulta.setInt(1, profesor.getCodigo());
            consulta.setString(2, profesor.getNombre());
            consulta.setString(3, profesor.getTitulo());
            consulta.setInt(4, profesor.getDepartamento().getCodigo());
            consulta.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }

    public void mostrarProfesor(Connection conexion, JTable tablaProfesor) throws SQLException {

        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Codigo");
        model.addColumn("Nombre");
        model.addColumn("Titulo");
        model.addColumn("departamento");

        try {
            PreparedStatement consulta = conexion.prepareStatement("SELECT * FROM profesor");
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {

                Object[] lista = {resultado.getInt(1), resultado.getString(2), resultado.getString(3), resultado.getInt(4)};
                model.addRow(lista);

            }

            tablaProfesor.setModel(model);

        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }

}
