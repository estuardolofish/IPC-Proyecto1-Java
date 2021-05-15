/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import static main.ProfesoresAdmin.sp;
import static main.ProfesoresAdmin.t;

/**
 *
 * @author Estuardo Lòpez
 */
public class AccionesProfesor extends JFrame implements ActionListener, MouseListener {

    JLabel lb1, lb2, lb3, lb4, lb5, lb6, lb7;
    public static JButton btnActualizar, btnEliminar, btnAgregar;
    public static JTextField txtCodigo, txtNombre, txtApellido, txtCorreo, txtContrasenia, txtGenero;
    public static JComboBox comboGenero;
    public static int txtCodigoActualizar;
    int limiteInicio = 0;

    public AccionesProfesor() {
        //labels
        lb1 = new JLabel("CODIGO");
        lb1.setBounds(20, 20, 100, 30);
        lb1.setVisible(true);
        this.add(lb1);

        lb2 = new JLabel("NOMBRE");
        lb2.setBounds(20, 70, 100, 30);
        lb2.setVisible(true);
        this.add(lb2);

        lb3 = new JLabel("APELLIDO");
        lb3.setBounds(20, 120, 100, 30);
        lb3.setVisible(true);
        this.add(lb3);

        lb4 = new JLabel("CORREO");
        lb4.setBounds(20, 170, 100, 30);
        lb4.setVisible(true);
        this.add(lb4);

        lb5 = new JLabel("CONTRASEÑA");
        lb5.setBounds(20, 220, 100, 30);
        lb5.setVisible(true);
        this.add(lb5);

        lb6 = new JLabel("GENERO");
        lb6.setBounds(20, 270, 100, 30);
        lb6.setVisible(true);
        this.add(lb6);

        //textos
        txtCodigo = new JTextField();
        //txtCodigo.setText("hola");
        txtCodigo.setBounds(125, 20, 175, 30);
        txtCodigo.setVisible(true);
        this.add(txtCodigo);

        txtNombre = new JTextField();
        txtNombre.setBounds(125, 70, 400, 30);
        txtNombre.setVisible(true);
        this.add(txtNombre);

        txtApellido = new JTextField();
        txtApellido.setBounds(125, 120, 400, 30);
        txtApellido.setVisible(true);
        this.add(txtApellido);

        txtCorreo = new JTextField();
        txtCorreo.setBounds(125, 170, 400, 30);
        txtCorreo.setVisible(true);
        this.add(txtCorreo);

        txtContrasenia = new JTextField();
        txtContrasenia.setBounds(125, 220, 400, 30);
        txtContrasenia.setVisible(true);
        this.add(txtContrasenia);
        //combo

        String[] lista = {"", "FEMENINO", "MASCULINO"};
        comboGenero = new JComboBox(lista);
        comboGenero.setBounds(125, 270, 175, 30);
        comboGenero.setVisible(true);
        this.add(comboGenero);
        //botones
        btnAgregar = new JButton("CREAR");
        btnAgregar.setBounds(20, 350, 150, 30);
        btnAgregar.setVisible(true);
        btnAgregar.addActionListener(this);
        this.add(btnAgregar);

        btnActualizar = new JButton("ACTUALIZAR");
        btnActualizar.setBounds(190, 350, 150, 30);
        btnActualizar.setVisible(true);
        btnActualizar.addActionListener(this);
        this.add(btnActualizar);

        btnEliminar = new JButton("ELIMINAR");
        btnEliminar.setBounds(360, 350, 150, 30);
        btnEliminar.setVisible(true);
        btnEliminar.addActionListener(this);
        this.add(btnEliminar);

        //creando el formualrio
        this.setTitle("ACCIONES PROFESOR");
        this.setBounds(200, 200, 550, 550);
        this.setLayout(null);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setResizable(false);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnActualizar) {
            txtCodigoActualizar = Integer.parseInt(txtCodigo.getText());
            System.out.println(txtCodigoActualizar);
            for (int i = 0; i < Main.profesores.length; i++) {
                if (Main.profesores[i].getCodigoProfe() == txtCodigoActualizar) {

                    Main.profesores[i].setNombreProfe(txtNombre.getText());
                    Main.profesores[i].setApellidoProfe(txtApellido.getText());
                    Main.profesores[i].setCorreoProfe(txtCorreo.getText());
                    Main.profesores[i].setContaseniaProfe(txtContrasenia.getText());
                    System.out.println(comboGenero.getSelectedIndex());
                    if (comboGenero.getSelectedIndex() == 1) {

                        Main.profesores[i].setGeneroProfe("f");
                    } else if (comboGenero.getSelectedIndex() == 2) {
                        Main.profesores[i].setGeneroProfe("m");

                    }
                    System.out.println(Main.profesores[i].getNombreProfe());

                    ProfesoresAdmin.btnActualizarAux.doClick();

                    this.dispose();
                    JOptionPane.showMessageDialog(this, "DATOS ACTUALIZADOS");
                    break;
                    // Si lo encontramos, vamos a devolver el objeto, recordemos que cada posicion del arreglo es una posicion
                }
            }
        } else if (e.getSource() == btnAgregar) {
            if (txtCodigo.getText() == "" || txtNombre.getText() == "" || txtApellido.getText() == "" || txtCorreo.getText() == "" || txtContrasenia.getText() == "" || comboGenero.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(this, "ALGUNO DE LOS CAMPOS ESTAN VACIOS");
            } else {
                String generoNuevoIngreso = "";
                if (comboGenero.getSelectedIndex() == 1) {
                    generoNuevoIngreso = "f";

                } else if (comboGenero.getSelectedIndex() == 2) {
                    generoNuevoIngreso = "m";

                }

                Profesores profesores = new Profesores(Integer.parseInt(txtCodigo.getText()), txtNombre.getText(), txtApellido.getText(), txtCorreo.getText(), generoNuevoIngreso, txtContrasenia.getText());

                Main.agregarProfesor(profesores);

                ProfesoresAdmin.btnActualizarAux.doClick();
                this.dispose();
                JOptionPane.showMessageDialog(this, "DATOS INGRESADOS CORRECTAMENTE");
            }
        }else if (e.getSource() == btnEliminar) {
            
            txtCodigoActualizar = Integer.parseInt(txtCodigo.getText());
            System.out.println(txtCodigoActualizar);
            for (int i = 0; i < Main.profesores.length; i++) {
                if (Main.profesores[i].getCodigoProfe() == txtCodigoActualizar) {

                    Main.profesores[i].setCodigoProfe(0);
                    Main.profesores[i].setNombreProfe("");
                    Main.profesores[i].setApellidoProfe("");
                    Main.profesores[i].setCorreoProfe("");
                    Main.profesores[i].setContaseniaProfe("");
                    Main.profesores[i].setGeneroProfe("");
                   
     
                    limiteInicio = i;
                    this.dispose();
                    JOptionPane.showMessageDialog(this, "DATOS ELIMINADO");
                    break;
                    // Si lo encontramos, vamos a devolver el objeto, recordemos que cada posicion del arreglo es una posicion
                }

            }

            for (int j = limiteInicio; j < Main.profesores.length; j++) {
                if (j + 1 < Main.profesores.length) {
                    Main.profesores[j] = null;
                    Main.profesores[j] = Main.profesores[j + 1];
                    System.out.println(j);
                } else {
                    System.out.println(j);
                    Main.profesores[j] = null;
                }
            }
            
            Main.cProfesores--;
            ProfesoresAdmin.btnActualizarAux.doClick();
            
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
