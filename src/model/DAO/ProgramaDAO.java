package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.VO.Programa;
import java.sql.ResultSet;

public class ProgramaDAO {

    public void guardar(Connection conexion, Programa programa) throws SQLException {
        try {
            

            PreparedStatement consulta;
            consulta = conexion.prepareStatement("INSERT INTO programa ( codigo, nombre, ubicacion, codigo_departamento, codigo_director) "
                    + "VALUES(?, ?, ?, ?, ?)");
            consulta.setInt(1, programa.getCodigo());
            consulta.setString(2, programa.getNombre());
            consulta.setString(3, programa.getUbicacion());
            consulta.setInt(4, programa.getDepartamento().getCodigo());
            consulta.setInt(5, programa.getProfesor().getCodigo());
            consulta.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }

    public void mostrarPrograma(Connection conexion, JTable tablaPrograma) throws SQLException {

        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Codigo");
        model.addColumn("Nombre");
        model.addColumn("ubicacion");
        model.addColumn("departamento");
        model.addColumn("director");

        try {
            PreparedStatement consulta = conexion.prepareStatement("SELECT * FROM programa");
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {

                Object[] lista = {resultado.getInt(1), resultado.getString(2), resultado.getString(3), resultado.getInt(4), resultado.getInt(5)};
                model.addRow(lista);

            }

            tablaPrograma.setModel(model);

        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }
}
