package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import static main.ProfesoresAdmin.btnActualizarAux;
import static main.ProfesoresAdmin.t;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import static main.AccionesCurso.comboProfesor;
import static main.ProfesoresAdmin.btnExportarPdf;
import static main.ProfesoresAdmin.t;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.util.PublicCloneable;

public class CursosAdmin extends JFrame implements ActionListener,MouseListener {
    
    JTable t;
    JScrollPane sp;
    DefaultTableModel d;

    JLabel lb1, lb2, lb3, lb4;
    public static JButton btn1, btnCrear, btnCargaMasiva, btnExportarPdf, btnActualizarAux;

    String contenido = "";
    File archivo;
    FileReader fr;
    BufferedReader br;
    
    public CursosAdmin() {
       //labels
        lb1 = new JLabel("LISTADO OFICIAL");
        lb1.setBounds(20, 20, 100, 30);
        lb1.setVisible(true);
        this.add(lb1);

        //boton iniciar sesion
        btn1 = new JButton("REGRESAR");
        btn1.setBounds(40, 700, 100, 30);
        btn1.setVisible(true);
        btn1.addActionListener(this);
        this.add(btn1);
        
        btnActualizarAux = new JButton("Actualizar");
        btnActualizarAux.setBounds(550, 5, 100, 30);
        btnActualizarAux.setVisible(false);
        btnActualizarAux.addActionListener(this);
        this.add(btnActualizarAux);
        
        
        btnCrear = new JButton("AGREGAR");
        btnCrear.setBounds(550, 40, 100, 30);
        btnCrear.setVisible(true);
        btnCrear.addActionListener(this);
        this.add(btnCrear);

        btnCargaMasiva = new JButton("CARGA MASIVA");
        btnCargaMasiva.setBounds(700, 40, 150, 30);
        btnCargaMasiva.setVisible(true);
        btnCargaMasiva.addActionListener(this);
        this.add(btnCargaMasiva);

        btnExportarPdf = new JButton("EXPORTAR LISTADO A PDF");
        btnExportarPdf.setBounds(550, 100, 300, 30);
        btnExportarPdf.setVisible(true);
        btnExportarPdf.addActionListener(this);
        this.add(btnExportarPdf);
        
        //creando la tabla      
        Object[][] datos = Main.convertirDatosTablaCursos();
        String[] columnas = {"CODIGO", "NOMBRE", "CREDITOS", "ALUMNOS", "PROFESOR"};
        t = new JTable();
        d = new DefaultTableModel(datos, columnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        t.setModel(d);
        t.addMouseListener(this);
        t.getColumnModel().getColumn(0).setPreferredWidth(10);
        t.getColumnModel().getColumn(1).setPreferredWidth(10);
        t.getColumnModel().getColumn(2).setPreferredWidth(10);
        t.getColumnModel().getColumn(3).setPreferredWidth(10);
        t.getColumnModel().getColumn(4).setPreferredWidth(100);
        sp = new JScrollPane(t);
        sp.setBounds(30, 60, 500, 600);
        sp.setVisible(true);
        this.add(sp);

        this.setTitle("ADMINISTRACION DE CURSOS");
        this.setBounds(100, 100, 1000, 800);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setResizable(false);
        this.setVisible(true);

    }
    
    public  void leerArchivos()
    {

        try{
            JFileChooser fc = new JFileChooser();
            int op = fc.showOpenDialog(this);
            if (op == JFileChooser.APPROVE_OPTION) {
                //System.out.println(fc.getSelectedFile());
                archivo = fc.getSelectedFile();
            }
            
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                contenido += linea;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1) {
            MenuAdmin menuAdmin = new MenuAdmin();
            this.dispose();
        } else if (e.getSource() == btnCrear) {
            AccionesCurso accionesCurso = new AccionesCurso();
            AccionesCurso.btnActualizar.setVisible(false);
            AccionesCurso.btnEliminar.setVisible(false);
        } else if (e.getSource() == btnCargaMasiva) {
            // TODO LO QUE ESTE AQUI, HARA EL BOTON1
            System.out.println("Presionaste al Boton 1.");
            leerArchivos();
            System.out.println(contenido);
            // JsonParser parser -> Todos los metodos necesarios para interpretar un JSON.
            JsonParser parser = new JsonParser();
            // JsonArray arreglo de objetos JSON.
            JsonArray arreglo = parser.parse(contenido).getAsJsonArray();
            // PARA ESTE MOMENTO ARREGLO YA TIENE LO QUE ES UN ARREGLO ALMACENADO
            System.out.println("Cantidad de Objetos: " + arreglo.size());

            // RECORRER MI ARREGLO
            for (int i = 0; i < arreglo.size(); i++) {
                // JsonObject -> Tomar el Objeto del Arreglo
                JsonObject objeto = arreglo.get(i).getAsJsonObject();

                int codigoCurso = objeto.get("codigo").getAsInt();
                String nombreCurso = objeto.get("nombre").getAsString();
                int creditosCurso = objeto.get("creditos").getAsInt();
                int codigoProfesor = objeto.get("profesor").getAsInt();
               
                // CREAMOS NUESTRO OBJETO PERSONA
                Cursos curso = new Cursos(codigoCurso,nombreCurso, creditosCurso, 0,codigoProfesor);

                Main.agregarCurso(curso);
            }
            Main.mostrarCurso();

            this.btnActualizarAux.doClick();
        }else if (e.getSource() == btnActualizarAux) {
            this.remove(t);
            this.remove(sp);
            //creando la tabla
            Object[][] datos = Main.convertirDatosTablaCursos();
            String[] columnas = {"CODIGO", "NOMBRE", "CREDITOS", "ALUMNOS", "PROFESOR"};
            t = new JTable();
            DefaultTableModel d = new DefaultTableModel(datos, columnas) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            t.setModel(d);
            t.addMouseListener(this);
            t.getColumnModel().getColumn(0).setPreferredWidth(10);
            t.getColumnModel().getColumn(1).setPreferredWidth(10);
            t.getColumnModel().getColumn(2).setPreferredWidth(10);
            t.getColumnModel().getColumn(3).setPreferredWidth(10);
            t.getColumnModel().getColumn(4).setPreferredWidth(100);
            sp = new JScrollPane(t);
            sp.setBounds(30, 60, 500, 600);
            sp.setVisible(true);
            this.add(sp);

            t.repaint();
        }else if (e.getSource() == btnExportarPdf) {
            System.out.println("exprtando pdf");

            // Se crea el documento
            Document documento = new Document();

// Se crea el OutputStream para el fichero donde queremos dejar el pdf.
            FileOutputStream ficheroPdf = null;
            try {
                ficheroPdf = new FileOutputStream("ReporteCursos.pdf");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(CursosAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                // Se asocia el documento al OutputStream y se indica que el espaciado entre
// lineas sera de 20. Esta llamada debe hacerse antes de abrir el documento
                PdfWriter.getInstance(documento, ficheroPdf).setInitialLeading(20);
            } catch (DocumentException ex) {
                Logger.getLogger(CursosAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }

// Se abre el documento.
            documento.open();

            try {
                documento.add(new Paragraph("REPORTE CURSOS", FontFactory.getFont("arial", 22, Font.ITALIC, BaseColor.CYAN)));             // color
                documento.add(new Paragraph("", FontFactory.getFont("arial", 22, Font.ITALIC, BaseColor.CYAN)));             // color
            } catch (DocumentException ex) {
                Logger.getLogger(CursosAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }

            PdfPTable table = new PdfPTable(5);

            //table.addCell("CODIGO  | NOMBRE       | CORREO         | GENERO");
            table.addCell("CODIGO");
            table.addCell("NOMBRE");
            table.addCell("CREDITOS");
            table.addCell("ALUMNOS");
            table.addCell("PROFESOR");

            for (int j = 0; j < Main.cCursos; j++) {

                table.addCell("" + Main.cursos[j].getCodigoCurso());
                table.addCell("" + Main.cursos[j].getNombreCurso());
                table.addCell("" + Main.cursos[j].getCreditosCurso());
                table.addCell("" + Main.cursos[j].getAlumnosCurso());
                table.addCell("" + Main.encontrarProfesorID(Main.cursos[j].getCodigoCurso()));

            }

            JOptionPane.showMessageDialog(this, "REPORTE GENERADO EXITOSAMENTE");

            try {
                documento.add(table);
            } catch (DocumentException ex) {
                Logger.getLogger(CursosAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }

            documento.close();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if (e.getClickCount() == 2 && !e.isConsumed()) {
            e.consume();
            int columna = t.getColumnModel().getColumnIndexAtX(e.getX());
            // Obtenemos la fila con el MouseEvent.getY
            int fila = e.getY() / t.getRowHeight();
            System.out.println("Click en la posicion: " + fila + "-" + columna);
            Object value = t.getValueAt(fila, columna);
            System.out.println(value);

            String codigo = t.getValueAt(fila, 0).toString();
             


           
            
            AccionesCurso accionesCurso = new AccionesCurso();
            
            AccionesCurso.btnActualizar.setVisible(true);
            AccionesCurso.btnEliminar.setVisible(true);
            AccionesCurso.txtCodigo.setEnabled(false);
            AccionesCurso.btnAgregar.setVisible(false);
            
            Main.mostrarCursoAcciones(Integer.parseInt(codigo));

         
            
        }

       
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
