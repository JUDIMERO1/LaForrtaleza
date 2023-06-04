package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.DAO.Conexion;
import model.DAO.DepartamentoDAO;
import model.VO.Departamento;
import view.RegistrarDepartamento;

/**
 *
 * 
 */
public class RegistrarDepartamentoController implements ActionListener {

    private RegistrarDepartamento registrarDepartamento;

    public RegistrarDepartamentoController() {
        registrarDepartamento = new RegistrarDepartamento();
        registrarDepartamento.setVisible(true);
        registrarDepartamento.setLocationRelativeTo(null);
        ActionListener(this);
    }

    private void ActionListener(ActionListener controller) {
        registrarDepartamento.btnAgregar.addActionListener(controller);
        registrarDepartamento.btnBuscar.addActionListener(controller);
        registrarDepartamento.btnInicio.addActionListener(controller);
    }

    @Override
    public void actionPerformed(ActionEvent event) {

        if (event.getSource() == registrarDepartamento.btnAgregar) {

            int codigo = Integer.parseInt(registrarDepartamento.txtCodigo.getText());
            String nombre = registrarDepartamento.txtNombre.getText();
            String ubicacion = registrarDepartamento.txtUbicacion.getText();

            Departamento departamento = new Departamento(codigo, nombre, ubicacion);

            registrar(departamento);

            JOptionPane.showMessageDialog(registrarDepartamento, "Se ha registrado correctamente");

            registrarDepartamento.txtCodigo.setText("");
            registrarDepartamento.txtNombre.setText("");
            registrarDepartamento.txtUbicacion.setText("");

        }

        if (event.getSource() == registrarDepartamento.btnBuscar) {
            MostarDepartamento(registrarDepartamento.tabla);
        }

        if (event.getSource() == registrarDepartamento.btnInicio) {
            registrarDepartamento.setVisible(false);
            PrincipalController controller = new PrincipalController();
        }

    }

    public void registrar(Departamento departamento) {
        try {
            DepartamentoDAO us = new DepartamentoDAO();
            us.guardar(Conexion.obtener(), departamento);
        } catch (Exception e) {
        }
    }

    public void MostarDepartamento(JTable tabladepartamento) {
        try {
            DepartamentoDAO vdao = new DepartamentoDAO();
            vdao.mostrarDepartamento(Conexion.obtener(), tabladepartamento);

        } catch (Exception e) {
        }

    }

}
