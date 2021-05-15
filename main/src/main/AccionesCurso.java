
package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static main.AccionesProfesor.btnActualizar;
import static main.AccionesProfesor.btnAgregar;
import static main.AccionesProfesor.btnEliminar;
import static main.AccionesProfesor.comboGenero;
import static main.AccionesProfesor.txtApellido;
import static main.AccionesProfesor.txtCodigo;
import static main.AccionesProfesor.txtCodigoActualizar;
import static main.AccionesProfesor.txtContrasenia;
import static main.AccionesProfesor.txtCorreo;
import static main.AccionesProfesor.txtNombre;

/**
 *
 * @author Estuardo Lòpez
 */
public class AccionesCurso extends JFrame implements ActionListener{

    JLabel lb1, lb2, lb3, lb4;
    public static JButton btnActualizar, btnEliminar, btnAgregar;
    public static JTextField txtCodigo, txtNombre, txtCreditos;
    public static JComboBox comboProfesor;
    
    int limiteInicio = 0;
    
    public AccionesCurso() {
        //labels
        lb1 = new JLabel("CODIGO");
        lb1.setBounds(20, 20, 100, 30);
        lb1.setVisible(true);
        this.add(lb1);
        
        lb2 = new JLabel("NOMBRE");
        lb2.setBounds(20, 70, 100, 30);
        lb2.setVisible(true);
        this.add(lb2);
        
        lb3 = new JLabel("CREDITOS");
        lb3.setBounds(20, 120, 100, 30);
        lb3.setVisible(true);
        this.add(lb3);

        lb4 = new JLabel("PROFESOR");
        lb4.setBounds(20, 170, 100, 30);
        lb4.setVisible(true);
        this.add(lb4);



        //textos
        txtCodigo = new JTextField();
        txtCodigo.setBounds(125, 20, 175, 30);
        txtCodigo.setVisible(true);
        this.add(txtCodigo);

        txtNombre = new JTextField();
        txtNombre.setBounds(125, 70, 400, 30);
        txtNombre.setVisible(true);
        this.add(txtNombre);

        txtCreditos = new JTextField();
        txtCreditos.setBounds(125, 120, 400, 30);
        txtCreditos.setVisible(true);
        this.add(txtCreditos);
        
        String[] lista = {""};
        comboProfesor = new JComboBox(lista);
        
        for (int i = 0; i < Main.cProfesores; i++) {
            AccionesCurso.comboProfesor.addItem(Main.profesores[i].getNombreProfe() + " " + Main.profesores[i].getApellidoProfe());
        }

        comboProfesor.setBounds(125, 170, 175, 30);
        comboProfesor.setVisible(true);
        this.add(comboProfesor);
        
        
        //botones
        btnAgregar = new JButton("CREAR");
        btnAgregar.setBounds(20, 250, 150, 30);
        btnAgregar.setVisible(true);
        btnAgregar.addActionListener(this);
        this.add(btnAgregar);
        
        btnActualizar = new JButton("ACTUALIZAR");
        btnActualizar.setBounds(190, 250, 150, 30);
        btnActualizar.setVisible(true);
        btnActualizar.addActionListener(this);
        this.add(btnActualizar);

        btnEliminar = new JButton("ELIMINAR");
        btnEliminar.setBounds(360, 250, 150, 30);
        btnEliminar.setVisible(true);
        btnEliminar.addActionListener(this);
        this.add(btnEliminar);

        
        
        //creando el formualrio
        this.setTitle("ACCIONES CURSO");
        this.setBounds(200, 200, 550, 550);
        this.setLayout(null);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setResizable(false);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAgregar) {
             if (txtCodigo.getText() == "" || txtNombre.getText() == "" || txtCreditos.getText() == "" || comboProfesor.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(this, "ALGUNO DE LOS CAMPOS ESTAN VACIOS");
            } else {
                 String profesorcombo= (String) comboProfesor.getSelectedItem();
                 String[] profesorNomApe = profesorcombo.split(" ");
                 
                 System.out.println(profesorNomApe[0]);
                 System.out.println(profesorNomApe[1]);
                 System.out.println(Main.encontrarProfesorNomApe(profesorNomApe[0],profesorNomApe[1]));
                
                Cursos cursos = new Cursos(Integer.parseInt(txtCodigo.getText()), txtNombre.getText(), Integer.parseInt(txtCreditos.getText()), 0, Main.encontrarProfesorNomApe(profesorNomApe[0],profesorNomApe[1]));

                Main.agregarCurso(cursos);

                CursosAdmin.btnActualizarAux.doClick();
                
                this.dispose();
                JOptionPane.showMessageDialog(this, "DATOS INGRESADOS CORRECTAMENTE" + comboProfesor.getSelectedItem());
                JOptionPane.showMessageDialog(this, "DATOS INGRESADOS CORRECTAMENTE");
             }
        } else if (e.getSource() == btnActualizar) {
            txtCodigoActualizar = Integer.parseInt(txtCodigo.getText());
            System.out.println(txtCodigoActualizar);
            for (int i = 0; i < Main.cursos.length; i++) {
                if (Main.cursos[i].getCodigoCurso()== txtCodigoActualizar && comboProfesor.getSelectedItem()!="") {
                    String profesorcombo= (String) comboProfesor.getSelectedItem();
                 String[] profesorNomApe = profesorcombo.split(" ");
                 
                 System.out.println(profesorNomApe[0]);
                 System.out.println(profesorNomApe[1]);
                 System.out.println(Main.encontrarProfesorNomApe(profesorNomApe[0],profesorNomApe[1]));
                 

                    Main.cursos[i].setNombreCurso(txtNombre.getText());
                    Main.cursos[i].setCreditosCurso(Integer.parseInt(txtCreditos.getText()));
                    Main.cursos[i].setCodigoProfesor(Main.encontrarProfesorNomApe(profesorNomApe[0],profesorNomApe[1]));
                               

                    CursosAdmin.btnActualizarAux.doClick();

                    this.dispose();
                    JOptionPane.showMessageDialog(this, "DATOS ACTUALIZADOS");
                    break;
                    // Si lo encontramos, vamos a devolver el objeto, recordemos que cada posicion del arreglo es una posicion
                }
            }
            
        } else if (e.getSource() == btnEliminar) {
            
            txtCodigoActualizar = Integer.parseInt(txtCodigo.getText());
            System.out.println(txtCodigoActualizar);
            for (int i = 0; i < Main.cursos.length; i++) {
                if (Main.cursos[i].getCodigoCurso() == txtCodigoActualizar) {

                    Main.cursos[i].setCodigoCurso(0);
                    Main.cursos[i].setNombreCurso("");
                    Main.cursos[i].setCreditosCurso(0);
                    Main.cursos[i].setAlumnosCurso(0);
                    Main.cursos[i].setCodigoProfesor(0);
         
                   
     
                    limiteInicio = i;
                    this.dispose();
                    JOptionPane.showMessageDialog(this, "DATOS ELIMINADO");
                    break;
                    // Si lo encontramos, vamos a devolver el objeto, recordemos que cada posicion del arreglo es una posicion
                }
            }
            
            for (int j = limiteInicio; j < Main.cursos.length; j++) {
                if (j + 1 < Main.cursos.length) {
                    Main.cursos[j] = null;
                    Main.cursos[j] = Main.cursos[j + 1];
                    System.out.println(j);
                } else {
                    System.out.println(j);
                    Main.cursos[j] = null;
                }
            }
            
            Main.cCursos--;
            CursosAdmin.btnActualizarAux.doClick();
            
            
        }
    }
    
}
