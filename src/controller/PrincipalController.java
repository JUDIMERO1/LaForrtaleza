package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.MenuPrincipal;

/**
 *
 * 
 */
public class PrincipalController implements ActionListener {

    private static PrincipalController instancia;
    private MenuPrincipal vista;

    //controlador
    
    public PrincipalController() {
        this.vista = new MenuPrincipal();
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        ActionListener(this);
    }

    //metodo para obtener la instancia del controlador principal
    public static PrincipalController getInstance() {
        if (instancia == null) {
            instancia = new PrincipalController();
        }
        return instancia;
    }

    private void ActionListener(ActionListener controller) {
        vista.btnRegistrarProfesor.addActionListener(controller);
        vista.btnRegistrarAsignatura.addActionListener(controller);
        vista.btnMatricula.addActionListener(controller);
        vista.btnRegistrarEstudiante.addActionListener(controller);
        vista.btnRegistrarDepartamento.addActionListener(controller);
        vista.btnRegistrarPrograma.addActionListener(controller);
        vista.btnRegistrarGrupo.addActionListener(controller);
        
    }

    @Override
    public void actionPerformed(ActionEvent event) {

        //abrir GUI Registro profesor
        if (event.getSource() == vista.btnRegistrarProfesor) {
            registrarProfesorGUI();
        }

        //abrir GUI Registro asignatura
        if (event.getSource() == vista.btnRegistrarAsignatura) {
            registrarAsignaturaGUI();
        }

        //abrir GUI Registro estudiante
        if (event.getSource() == vista.btnRegistrarEstudiante) {
            registrarEstudianteGUI();
        }

        //abrir GUI Registro departamento
        if (event.getSource() == vista.btnRegistrarDepartamento) {
            registrarDepartamentoGUI();
        }

        //abrir GUI Registro programa
        if (event.getSource() == vista.btnRegistrarPrograma) {
            registrarProgramaGUI();
        }

        //abrir GUI matricula
        if (event.getSource() == vista.btnMatricula) {
            matriculaGUI();
        }

        //abrir GUI Registro grupo
        if (event.getSource() == vista.btnRegistrarGrupo) {
            RegistrarGrupoGUI();
        }

    }

// Ocultar la GUI actual (si hay una) y mostrar la registrarAsignaturaGUI
    public void registrarAsignaturaGUI() {
        vista.setVisible(false);
        RegistrarAsignaturaController asignaturaController = new RegistrarAsignaturaController();
    }

    // Ocultar la GUI actual (si hay una) y mostrar la registrarEstudianteGUI
    public void registrarEstudianteGUI() {
        vista.setVisible(false);
        RegistrarEstudianteController estudianteController = new RegistrarEstudianteController();
    }

    // Ocultar la GUI actual (si hay una) y mostrar la registrarProfesorGUI
    public void registrarProfesorGUI() {
        vista.setVisible(false);
        RegistrarProfesorController profesorController = new RegistrarProfesorController();
    }

    // Ocultar la GUI actual (si hay una) y mostrar la registrarDepartamentoGUI
    public void registrarDepartamentoGUI() {
        vista.setVisible(false);
        RegistrarDepartamentoController departamentoController = new RegistrarDepartamentoController();
    }

    // Ocultar la GUI actual (si hay una) y mostrar la registrarProgramaGUI
    public void registrarProgramaGUI() {
        vista.setVisible(false);
        RegistrarProgramaController programaController = new RegistrarProgramaController();
    }

    // Ocultar la GUI actual (si hay una) y mostrar la MatriculaGUI
    public void matriculaGUI() {
        vista.setVisible(false);
        MatriculaController matriculaController = new MatriculaController();
    }

    public void RegistrarGrupoGUI() {
        vista.setVisible(false);
        RegistrarGrupoController registrarGrupoController = new RegistrarGrupoController();
    }

}
