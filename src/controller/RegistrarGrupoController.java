package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.DAO.Conexion;
import model.DAO.GrupoDAO;
import model.DAO.HorarioDAO;
import model.VO.Asignatura;
import model.VO.Grupo;
import model.VO.Horario;
import model.VO.Profesor;
import view.RegistrarGrupo;

/**
 *
 * 
 */
public class RegistrarGrupoController implements ActionListener {

    private RegistrarGrupo registrarGrupo;

    public RegistrarGrupoController() {
        registrarGrupo = new RegistrarGrupo();
        registrarGrupo.setVisible(true);
        registrarGrupo.setLocationRelativeTo(null);
        ActionListener(this);
    }

    private void ActionListener(ActionListener controller) {
        registrarGrupo.btnAgregarGrupo.addActionListener(controller);
        registrarGrupo.btnAgregarHorario.addActionListener(controller);
        registrarGrupo.btnInicio.addActionListener(controller);
    }

    @Override
    public void actionPerformed(ActionEvent event) {

        if (event.getSource() == registrarGrupo.btnInicio) {
            registrarGrupo.setVisible(false);
            PrincipalController controller = new PrincipalController();
        }

        if (event.getSource() == registrarGrupo.btnAgregarGrupo) {

            String idGrupo = registrarGrupo.txtGrupo.getText();
            int capacidad = Integer.parseInt(registrarGrupo.txtCapacidad.getText());
            int codigoProfesor = Integer.parseInt(registrarGrupo.txtCodProfesor.getText());
            int codigoAsignatura = Integer.parseInt(registrarGrupo.txtCodAsignatura.getText());

            Profesor profesor = new Profesor(codigoProfesor);
            Asignatura asignatura = new Asignatura(codigoAsignatura);

            Grupo grupo = new Grupo(idGrupo, capacidad, profesor, asignatura);

            registrarGrupoBD(grupo);

            JOptionPane.showMessageDialog(registrarGrupo, "Se ha registrado correctamente");

            registrarGrupo.txtGrupo.setText("");
            registrarGrupo.txtCapacidad.setText("");
            registrarGrupo.txtCodProfesor.setText("");
            registrarGrupo.txtCodAsignatura.setText("");

        }

        if (event.getSource() == registrarGrupo.btnAgregarHorario) {

            String codigoGrupo = registrarGrupo.txtGrupoHorario.getText();
            String codigoSalon = registrarGrupo.txtCodSalonHorario.getText();
            String horaInicio = registrarGrupo.txtHoraInicio.getText();
            String horaFin = registrarGrupo.txtHoraFin.getText();
            String diaSemana = registrarGrupo.txtDiaSemana.getText();

            Grupo grupo = new Grupo(codigoGrupo);
            Horario horario = new Horario(grupo, codigoSalon, horaInicio, horaFin, diaSemana);

            registrarHorario(horario);

            JOptionPane.showMessageDialog(registrarGrupo, "Se ha registrado correctamente");

            registrarGrupo.txtCodSalonHorario.setText("");
            registrarGrupo.txtHoraInicio.setText("");
            registrarGrupo.txtHoraFin.setText("");
            registrarGrupo.txtDiaSemana.setText("");

        }

    }

    public void registrarGrupoBD(Grupo grupo) {
        try {
            GrupoDAO us = new GrupoDAO();
            us.guardar(Conexion.obtener(), grupo);
        } catch (Exception e) {
        }
    }

    public void registrarHorario(Horario horario) {
        try {
            HorarioDAO ho = new HorarioDAO();
            ho.guardar(Conexion.obtener(), horario);
        } catch (Exception e) {
        }
    }

}
