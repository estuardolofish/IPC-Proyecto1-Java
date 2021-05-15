package main;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static main.AccionesProfesor.txtCodigoActualizar;

public class Login extends JFrame implements ActionListener {

    JLabel l1, l2, l3;
    JTextField codigotxt ;
    JPasswordField contratxt;
    JButton iniciarSesbtn;
    JCheckBox admin,profesor,alumno;

    public static String usuario = "";
    public static String pass = "";

    public Login() {
        //declarando los labels

        //label usuario
        l1 = new JLabel("USUARIO");
        l1.setBounds(10, 60, 150, 50);
        l1.setVisible(true);
        this.add(l1);

        //label contarseña
        l2 = new JLabel("CONTASEÑA");
        l2.setBounds(10, 100, 150, 100);
        l2.setVisible(true);
        this.add(l2);

        //label contarseña
        l3 = new JLabel("BIENVENIDO AL DTT");
        l3.setBounds(150, 0, 300, 100);
        l3.setVisible(true);
        this.add(l3);

        //declarando los textos
        //texto de usuario
        codigotxt = new JTextField();
        codigotxt.setBounds(150, 75, 250, 30);
        codigotxt.setVisible(true);
        this.add(codigotxt);

        //texto de usuario
        contratxt = new JPasswordField();
        contratxt.setBounds(150, 140, 250, 30);
        contratxt.setVisible(true);
        this.add(contratxt);
        
        //poniendo los checkbox
    
        admin = new JCheckBox("ADMINISTRADOR");
        admin.setBounds(40, 200, 125, 30);
        admin.setVisible(true);
        admin.addActionListener(this);
        this.add(admin);
        
        profesor = new JCheckBox("PROFESOR");
        profesor.setBounds(165, 200, 125, 30);
        profesor.setVisible(true);
        profesor.addActionListener(this);
        this.add(profesor);
        
        alumno = new JCheckBox("ALUMNO");
        alumno.setBounds(290, 200, 125, 30);
        alumno.setVisible(true);
        alumno.addActionListener(this);
        this.add(alumno);
        

        //declarando los botones
        //boton iniciar sesion
        iniciarSesbtn = new JButton("INICIAR SESION");
        iniciarSesbtn.setBounds(40, 250, 350, 30);
        iniciarSesbtn.setVisible(true);
        iniciarSesbtn.addActionListener(this);
        this.add(iniciarSesbtn);

        this.setTitle("LOGIN");
        this.setBounds(100, 100, 500, 350);
        this.setBackground(Color.yellow);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setResizable(false);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == iniciarSesbtn) {
            usuario = codigotxt.getText();
            pass = contratxt.getText();
            System.out.println("hola probando el boton de login " + usuario + pass);
            
            if (admin.isSelected() == true) {
                if (usuario.equals("admin") && pass.equals("admin")) {

                    System.out.println("contraseña administrador correcta");
                    MenuAdmin menuAdmin = new MenuAdmin();
                    this.dispose();

                } else {
                    System.out.println("no correcto");
                }

            } else if (profesor.isSelected() == true) {
                
                for (int i = 0; i < Main.profesores.length; i++) {
                    if (Main.profesores[i] != null) {

                        if (Main.profesores[i].getCodigoProfe() == Integer.parseInt(usuario) && Main.profesores[i].getContaseniaProfe().equals(pass)) {
                            System.out.println("contraseña profesor correcta");
                            ModuloProfesor moduloProfesor = new ModuloProfesor();
                            this.dispose();
                            JOptionPane.showMessageDialog(this, "INGRESO CORRECTAMENTE" + Main.profesores[i].getNombreProfe() + " " + Main.profesores[i].getApellidoProfe());
                            break;
                            // Si lo encontramos, vamos a devolver el objeto, recordemos que cada posicion del arreglo es una posicion
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "AUN NO SE HAN CARGADO DATOS DEL PROFESOR");
                        System.out.println("datos vacios");
                        break;
                    }

                }

            } else if (alumno.isSelected() == true) {

            }else
            {
                JOptionPane.showMessageDialog(this, "DATOS INCORRECTOS");
                System.out.println("alguno de los datos es incorrecto");
            }
            
            
           
        }else if (e.getSource() == admin) {
            profesor.setSelected(false);
            alumno.setSelected(false);
        } else if (e.getSource() == profesor) {
            admin.setSelected(false);
            alumno.setSelected(false);
        }else if (e.getSource() == alumno) {
            profesor.setSelected(false);
            admin.setSelected(false);
        }


    }
}
