package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.VO.Departamento;
import java.sql.ResultSet;


public class DepartamentoDAO {

    public void guardar(Connection conexion, Departamento departamento) throws SQLException {
        try {

            PreparedStatement consulta;
            consulta = conexion.prepareStatement("INSERT INTO departamento ( codigo,  nombre,  ubicacion) "
                    + "VALUES(?, ?, ?)");
            consulta.setInt(1, departamento.getCodigo());
            consulta.setString(2, departamento.getNombre());
            consulta.setString(3, departamento.getUbicacion());
            consulta.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }

    public void mostrarDepartamento(Connection conexion, JTable tabladepartamento) throws SQLException {

        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Codigo");
        model.addColumn("Nombre");
        model.addColumn("ubicacion");

        try {
            PreparedStatement consulta = conexion.prepareStatement("SELECT * FROM departamento");
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {

                Object[] lista = {resultado.getInt(1), resultado.getString(2), resultado.getString(3)};
                model.addRow(lista);

            }

            tabladepartamento.setModel(model);

        } catch (SQLException ex) {
            throw new SQLException(ex);
        }

    }

}
