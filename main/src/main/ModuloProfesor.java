
package main;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static main.AccionesCurso.comboProfesor;
import static main.ProfesoresAdmin.t;

/**
 *
 * @author Estuardo Lòpez
 */
public class ModuloProfesor extends JFrame implements ActionListener {
    JLabel lb1, lb2, lb3, lb4, img;
    JButton btn1, profesoresbtn, cursosbtn, alumnosbtn,btnActualizar;

    public ModuloProfesor() {
         //labels
        lb1 = new JLabel("Usuario: ");
        lb1.setBounds(10, 5, 50, 50);
        lb1.setVisible(true);
        this.add(lb1);
        
        lb2 = new JLabel(main.Login.usuario);
        lb2.setBounds(60, 5, 200, 50);
        lb2.setVisible(true);
        this.add(lb2);
        
        lb3 = new JLabel("PROFESOR  "+Main.profesores[Integer.parseInt(main.Login.usuario)-1].getNombreProfe() + " " +Main.profesores[Integer.parseInt(main.Login.usuario)-1].getApellidoProfe());
        lb3.setBounds(300, 50, 200, 50);
        lb3.setVisible(true);
        this.add(lb3);
        
        lb4 = new JLabel("CURSOS DEL PROFESOR: ");
        lb4.setBounds(300, 100, 200, 50);
        lb4.setVisible(true);
        this.add(lb4);
        
        String[] lista = {""};
        comboProfesor = new JComboBox(lista);
        
        for (int i = 0; i < Main.cCursos; i++) {
            if (Main.cursos[i].getCodigoProfesor() == (Integer.parseInt(main.Login.usuario))) {
                
            comboProfesor.addItem("Curso - " + Main.cursos[i].getNombreCurso() + " Alumnos: " + Main.cursos[i].getAlumnosCurso());
            }
        }

        comboProfesor.setBounds(500, 100, 175, 30);
        comboProfesor.setVisible(true);
        this.add(comboProfesor);
        
        
        //boton iniciar sesion
        btn1 = new JButton("Regresar");
        btn1.setBounds(40, 250, 100, 30);
        btn1.setVisible(true);
        btn1.addActionListener(this);
        this.add(btn1);
        
        
        btnActualizar = new JButton("ACTUALIZAR");
        btnActualizar.setBounds(500, 10, 150, 30);
        btnActualizar.setVisible(true);
        btnActualizar.addActionListener(this);
        this.add(btnActualizar);
        
        this.setTitle("MENU ADMINISTRADOR");
        this.setBounds(100, 100, 800, 350);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setResizable(false);
        this.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1) {

            Login login = new Login();
            this.dispose();
        }else if (e.getSource() == btnActualizar) {
 

         

            AccionesProfesor accionesProfesor = new AccionesProfesor();
            AccionesProfesor.btnActualizar.setVisible(true);
            AccionesProfesor.btnEliminar.setVisible(true);
            AccionesProfesor.txtCodigo.setEnabled(false);
            AccionesProfesor.btnAgregar.setVisible(false);
        

            Main.mostrarProfesorAcciones(Integer.parseInt(Login.usuario));
        }
    }
    

}
