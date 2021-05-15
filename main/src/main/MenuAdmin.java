
package main;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;



public class MenuAdmin extends JFrame implements ActionListener{
    JLabel lb1, lb2, lb3, lb4, img;
    JButton btn1, profesoresbtn, cursosbtn, alumnosbtn;
    
    public MenuAdmin()
    {
        //labels
        lb1 = new JLabel("Usuario: ");
        lb1.setBounds(10, 5, 50, 50);
        lb1.setVisible(true);
        this.add(lb1);
        
        lb2 = new JLabel(main.Login.usuario);
        lb2.setBounds(60, 5, 200, 50);
        lb2.setVisible(true);
        this.add(lb2);
        
        lb3 = new JLabel("MENU ADMINISTRADOR");
        lb3.setBounds(300, 50, 200, 50);
        lb3.setVisible(true);
        this.add(lb3);
        
        
        //boton iniciar sesion
        btn1 = new JButton("Regresar");
        btn1.setBounds(40, 250, 100, 30);
        btn1.setVisible(true);
        btn1.addActionListener(this);
        this.add(btn1);

        profesoresbtn = new JButton("PROFESORES");
        profesoresbtn.setBounds(100, 100, 150, 30);
        profesoresbtn.setVisible(true);
        profesoresbtn.addActionListener(this);
        this.add(profesoresbtn);

        cursosbtn = new JButton("CURSOS");
        cursosbtn.setBounds(300, 100, 150, 30);
        cursosbtn.setVisible(true);
        cursosbtn.addActionListener(this);
        this.add(cursosbtn);

        alumnosbtn = new JButton("ALUMNOS");
        alumnosbtn.setBounds(500, 100, 150, 30);
        alumnosbtn.setVisible(true);
        alumnosbtn.addActionListener(this);
        this.add(alumnosbtn);
        
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
        } else if (e.getSource() == profesoresbtn) {

            ProfesoresAdmin profesoresAdmin = new ProfesoresAdmin();
            this.dispose();
        } else if (e.getSource() == cursosbtn) {

            CursosAdmin cursosAdmin = new CursosAdmin();
            this.dispose();
        } else if (e.getSource() == alumnosbtn) {

            AlumnosAdmin alumnosAdmin = new AlumnosAdmin();
            this.dispose();
        }
    }

    
 
    
}
