
package main;

import static main.AccionesCurso.txtCreditos;


public class Cursos {
    
    private int codigoCurso;
    private String nombreCurso;
    private int creditosCurso;
    private int alumnosCurso;
    private int codigoProfesor;

    public Cursos() {
        codigoCurso = 0;
        nombreCurso = "";
        creditosCurso = 0;
        alumnosCurso = 0;
        codigoProfesor = 0;
    }

    public Cursos(int codigoCurso, String nombreCurso, int creditosCurso, int alumnosCurso, int codigoProfesor) {
        this.codigoCurso = codigoCurso;
        this.nombreCurso = nombreCurso;
        this.creditosCurso = creditosCurso;
        this.alumnosCurso = alumnosCurso;
        this.codigoProfesor = codigoProfesor;
    }
    
     public void mostrarDatosCursos()
    {
        System.out.println("CODIGO: " + codigoCurso);
        System.out.println("NOMBRE: " + nombreCurso);
    }
    
    public void mostrarDatosCursosAcciones() {
        
        AccionesCurso.txtCodigo.setText(String.valueOf(codigoCurso));
        AccionesCurso.txtNombre.setText(nombreCurso);
        AccionesCurso.txtCreditos.setText(String.valueOf(creditosCurso));
        AccionesCurso.comboProfesor.setSelectedItem(codigoProfesor);

        
    }
    


    public int getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(int codigoCurso) {
        this.codigoCurso = codigoCurso;
    }


    public String getNombreCurso() {
        return nombreCurso;
    }


    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

 
    public int getCreditosCurso() {
        return creditosCurso;
    }


    public void setCreditosCurso(int creditosCurso) {
        this.creditosCurso = creditosCurso;
    }


    public int getAlumnosCurso() {
        return alumnosCurso;
    }


    public void setAlumnosCurso(int alumnosCurso) {
        this.alumnosCurso = alumnosCurso;
    }


    public int getCodigoProfesor() {
        return codigoProfesor;
    }

 
    public void setCodigoProfesor(int codigoProfesor) {
        this.codigoProfesor = codigoProfesor;
    }
    
    
}
