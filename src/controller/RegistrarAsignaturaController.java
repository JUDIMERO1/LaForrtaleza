package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.DAO.AsignaturaDAO;
import model.DAO.Conexion;
import model.VO.Asignatura;
import model.VO.Programa;
import view.RegistrarAsignatura;


/**
 *
 * 
 */
public class RegistrarAsignaturaController implements ActionListener {

    private RegistrarAsignatura registroAsignatura;

    public RegistrarAsignaturaController() {
        registroAsignatura = new RegistrarAsignatura();
        registroAsignatura.setVisible(true);
        registroAsignatura.setLocationRelativeTo(null);
        ActionListener(this);
    }

    private void ActionListener(ActionListener controller) {
        registroAsignatura.btnAgregar.addActionListener(controller);
        registroAsignatura.btnBuscar.addActionListener(controller);
        registroAsignatura.btnInicio.addActionListener(controller);
    }

    @Override
    public void actionPerformed(ActionEvent event) {

        if (event.getSource() == registroAsignatura.btnAgregar) {

            int codigo = Integer.parseInt(registroAsignatura.txtCodigo.getText());
            String nombre = registroAsignatura.txtNombre.getText();
            int creditos = Integer.parseInt(registroAsignatura.txtCreditos.getText());
            int codigoPrograma = Integer.parseInt(registroAsignatura.txtCodPrograma.getText());

            Programa programa = new Programa(codigoPrograma);

            Asignatura asignatura = new Asignatura(codigo, nombre, creditos, programa);

            registrar(asignatura);

            JOptionPane.showMessageDialog(registroAsignatura, "Se ha registrado correctamente");

            registroAsignatura.txtCodigo.setText("");
            registroAsignatura.txtNombre.setText("");
            registroAsignatura.txtCreditos.setText("");
            registroAsignatura.txtCodPrograma.setText("");

        }

        if (event.getSource() == registroAsignatura.btnBuscar) {
            MostarAsignatura(registroAsignatura.tabla);
        }

        if (event.getSource() == registroAsignatura.btnInicio) {
            registroAsignatura.setVisible(false);
            PrincipalController controller = new PrincipalController();
        }

    }

    public void registrar(Asignatura asignatura) {
        try {
            AsignaturaDAO us = new AsignaturaDAO();
            us.guardar(Conexion.obtener(), asignatura);
        } catch (Exception e) {
        }
    }

    public void MostarAsignatura(JTable tablaAsignatura) {
        try {
            AsignaturaDAO vdao = new AsignaturaDAO();
            vdao.mostrarAsignatura(Conexion.obtener(), tablaAsignatura);

        } catch (Exception e) {
        }

    }
}
