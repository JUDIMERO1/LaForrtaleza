package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.DAO.Conexion;
import model.DAO.MatriculaDAO;
import model.VO.Asignatura;
import model.VO.Estudiante;
import model.VO.Grupo;
import model.VO.Matricula;
import model.VO.Profesor;
import view.MatriculaVista;


/**
 *
 * 
 */
public class MatriculaController implements ActionListener {

    private MatriculaVista matriculaVista;

    public MatriculaController() {
        matriculaVista = new MatriculaVista();
        matriculaVista.setVisible(true);
        matriculaVista.setLocationRelativeTo(null);
        ActionListener(this);
    }

    private void ActionListener(ActionListener controller) {
        matriculaVista.btnMatricularse.addActionListener(controller);
        matriculaVista.btnInicio.addActionListener(controller);
        matriculaVista.btnBuscar.addActionListener(controller);

    }

    @Override
    public void actionPerformed(ActionEvent event) {

        if (event.getSource() == matriculaVista.btnBuscar) {
            int codigo = Integer.parseInt(matriculaVista.txtCodigo.getText());
            MostrarAsignatura(matriculaVista.tablaAsignaturas, codigo);
            MostrarHorario(matriculaVista.tablaHorario, codigo);
        }

        if (event.getSource() == matriculaVista.btnMatricularse) {
            // Obtener el índice de la fila seleccionada en la tabla de horarios
            int filaSeleccionada = matriculaVista.tablaHorario.getSelectedRow();

            // Verificar si hay una fila seleccionada
            if (filaSeleccionada >= 0) {
                // Obtener el código del grupo de la columna correspondiente en la tabla de horarios

                String codigoGrupo = (String) matriculaVista.tablaHorario.getValueAt(filaSeleccionada, matriculaVista.tablaHorario.getColumn("Grupo").getModelIndex());

                Estudiante estudiante = new Estudiante(1152143);
                Grupo grupo = new Grupo(codigoGrupo);
                // Realizar la matriculación en el grupo
                Matricula matricula = new Matricula(estudiante, grupo);

                matricula(matricula);

                Asignatura asignatura = retornarAsignatura(codigoGrupo);
                Profesor profesor = retornarProfesor(codigoGrupo);

                retornarProfesor(codigoGrupo);

                JOptionPane.showMessageDialog(matriculaVista, "Asignatura: " + asignatura.getNombre()
                        + "\nProfesor: " + profesor.getNombre());

            } else {
                JOptionPane.showMessageDialog(matriculaVista, "Selecccione un horario");
            }
        }

        if (event.getSource() == matriculaVista.btnInicio) {
            matriculaVista.setVisible(false);
            PrincipalController controller = new PrincipalController();
        }

    }

    public Asignatura retornarAsignatura(String grupo) {
        try {
            MatriculaDAO us = new MatriculaDAO();
            return us.obtenerAsignaturaGrupo(Conexion.obtener(), grupo);
        } catch (Exception e) {
        }
        return null;
    }

    public Profesor retornarProfesor(String grupo) {
        try {
            MatriculaDAO us = new MatriculaDAO();
            return us.obtenerProfesorGrupo(Conexion.obtener(), grupo);
        } catch (Exception e) {
        }
        return null;
    }

    public void registrar(Matricula matricula) {
        try {
            MatriculaDAO us = new MatriculaDAO();
            us.guardar(Conexion.obtener(), matricula);
        } catch (Exception e) {
        }
    }

    public void MostrarAsignatura(JTable tablaPrograma, int codigo) {
        try {
            MatriculaDAO us = new MatriculaDAO();
            us.mostrarAsignatura(Conexion.obtener(), tablaPrograma, codigo);

        } catch (Exception e) {
        }

    }

    public void MostrarHorario(JTable tablaPrograma, int codigo) {
        try {
            MatriculaDAO us = new MatriculaDAO();
            us.mostrarHorariosPorAsignatura(Conexion.obtener(), tablaPrograma, codigo);

        } catch (Exception e) {
        }

    }

    public void matricula(Matricula matricula) {
        try {
            MatriculaDAO us = new MatriculaDAO();
            us.matricularEstudianteEnGrupo(Conexion.obtener(), matricula);

        } catch (Exception e) {
        }

    }

}
