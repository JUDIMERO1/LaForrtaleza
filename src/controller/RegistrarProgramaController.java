package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.DAO.Conexion;
import model.DAO.ProgramaDAO;
import model.VO.Departamento;
import model.VO.Profesor;
import model.VO.Programa;
import view.RegistrarPrograma;

/**
 *
 * 
 */
public class RegistrarProgramaController implements ActionListener {

    private RegistrarPrograma registrarPrograma;

    public RegistrarProgramaController() {
        registrarPrograma = new RegistrarPrograma();
        registrarPrograma.setVisible(true);
        registrarPrograma.setLocationRelativeTo(null);
        ActionListener(this);
    }

    private void ActionListener(ActionListener controller) {
        registrarPrograma.btnAgregar.addActionListener(controller);
        registrarPrograma.btnBuscar.addActionListener(controller);
        registrarPrograma.btnInicio.addActionListener(controller);
    }

    @Override
    public void actionPerformed(ActionEvent event) {

        if (event.getSource() == registrarPrograma.btnAgregar) {

            int codigo = Integer.parseInt(registrarPrograma.txtCodigo.getText());
            String nombre = registrarPrograma.txtNombre.getText();
            String ubicacion = registrarPrograma.txtUbicacion.getText();
            int codigoDirector = Integer.parseInt(registrarPrograma.txtCodDirector.getText());
            int codigoDepartamento = Integer.parseInt(registrarPrograma.txtCodDepartamento.getText());

            Profesor director = new Profesor(codigoDirector);

            Departamento departamento = new Departamento(codigoDepartamento);

            Programa programa = new Programa(codigo, nombre, ubicacion, director, departamento);

            registrar(programa);

            JOptionPane.showMessageDialog(registrarPrograma, "Se ha registrado correctamente");

            registrarPrograma.txtCodigo.setText("");
            registrarPrograma.txtNombre.setText("");
            registrarPrograma.txtUbicacion.setText("");
            registrarPrograma.txtCodDirector.setText("");
            registrarPrograma.txtCodDepartamento.setText("");

        }

        if (event.getSource() == registrarPrograma.btnBuscar) {
            MostrarPrograma(registrarPrograma.tabla);
        }

        if (event.getSource() == registrarPrograma.btnInicio) {
            registrarPrograma.setVisible(false);
            PrincipalController controller = new PrincipalController();
        }

    }

    public void registrar(Programa programa) {
        try {
            ProgramaDAO us = new ProgramaDAO();
            us.guardar(Conexion.obtener(), programa);
        } catch (Exception e) {
        }
    }

    public void MostrarPrograma(JTable tablaPrograma) {
        try {
            ProgramaDAO vdao = new ProgramaDAO();
            vdao.mostrarPrograma(Conexion.obtener(), tablaPrograma);

        } catch (Exception e) {
        }

    }

}
