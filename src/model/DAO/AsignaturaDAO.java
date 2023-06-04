package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.VO.Asignatura;
import java.sql.ResultSet;


public class AsignaturaDAO {

    public void guardar(Connection conexion, Asignatura asignatura) throws SQLException {
        try {

            PreparedStatement consulta;
            consulta = conexion.prepareStatement("INSERT INTO asignatura (codigo, nombre, creditos, codigo_programa) "
                    + "VALUES(?, ?, ?, ?)");
            consulta.setInt(1, asignatura.getCodigo());
            consulta.setString(2, asignatura.getNombre());
            consulta.setInt(3, asignatura.getCreditos());
            consulta.setInt(4, asignatura.getPrograma().getCodigo());
            consulta.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }

    public void mostrarAsignatura(Connection conexion, JTable tablaAsignatura) throws SQLException {

        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Codigo");
        model.addColumn("Nombre");
        model.addColumn("Créditos");
        model.addColumn("Programa");

        try {
            PreparedStatement consulta;
            consulta = conexion.prepareStatement("SELECT * FROM asignatura");
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

}
