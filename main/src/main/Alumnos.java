
package main;


public class Alumnos {
    
     private int codigoAlumno;
    private String nombreAlumno;
    private String apellidoAlumno;
    private String correoAlumno;
    private String generoAlumno;
    private String contraseniaAlumno;
    private String fotoRutaAlumno;

    public Alumnos() {
        codigoAlumno = 0;
        nombreAlumno = "";
        apellidoAlumno = "";
        correoAlumno = "";
        generoAlumno = "";
        contraseniaAlumno = "";
        fotoRutaAlumno = "";
    }

    public Alumnos(int codigoAlumno, String nombreAlumno, String apellidoAlumno, String correoAlumno, String generoAlumno, String contraseniaAlumno, String fotoRutaAlumno) {
        this.codigoAlumno = codigoAlumno;
        this.nombreAlumno = nombreAlumno;
        this.apellidoAlumno = apellidoAlumno;
        this.correoAlumno = correoAlumno;
        this.generoAlumno = generoAlumno;
        this.contraseniaAlumno = contraseniaAlumno;
        this.fotoRutaAlumno = fotoRutaAlumno;
    }
    
    public void mostrarDatosProfesores()
    {
        System.out.println("CODIGO: " + codigoAlumno);
        System.out.println("NOMBRE: " + nombreAlumno);
    }
    
    /*
    
    public void mostrarDatosAlumnosAcciones() {
        AccionesProfesor.txtCodigo.setText(String.valueOf(codigoProfe));
        AccionesProfesor.txtNombre.setText(nombreProfe);
        AccionesProfesor.txtApellido.setText(apellidoProfe);
        AccionesProfesor.txtCorreo.setText(correoProfe);
        AccionesProfesor.txtContrasenia.setText(contaseniaProfe);
        if (generoProfe.equalsIgnoreCase("f")){
            
        //AccionesProfesor.comboGenero.setText(contaseniaProfe);
        //AccionesProfesor.comboGenero.addItem("FEMENINO");
        //AccionesProfesor.comboGenero.getComponent(1);
       
        //AccionesProfesor.comboGenero.getItemAt(2);
       AccionesAlumno.comboGenero.setSelectedIndex(1);
        
        //AccionesProfesor.comboGenero.setToolTipText("FEMENINO");
        
        }else if (generoProfe.equalsIgnoreCase("m")) {
            
        
       AccionesProfesor.comboGenero.setSelectedIndex(2);
        }
      
    }
    
*/

    public int getCodigoAlumno() {
        return codigoAlumno;
    }


    public void setCodigoAlumno(int codigoAlumno) {
        this.codigoAlumno = codigoAlumno;
    }


    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }


    public String getApellidoAlumno() {
        return apellidoAlumno;
    }


    public void setApellidoAlumno(String apellidoAlumno) {
        this.apellidoAlumno = apellidoAlumno;
    }


    public String getCorreoAlumno() {
        return correoAlumno;
    }

    public void setCorreoAlumno(String correoAlumno) {
        this.correoAlumno = correoAlumno;
    }


    public String getGeneroAlumno() {
        return generoAlumno;
    }


    public void setGeneroAlumno(String generoAlumno) {
        this.generoAlumno = generoAlumno;
    }



    public String getContraseniaAlumno() {
        return contraseniaAlumno;
    }

    public void setContraseniaAlumno(String contraseniaAlumno) {
        this.contraseniaAlumno = contraseniaAlumno;
    }


    public String getFotoRutaAlumno() {
        return fotoRutaAlumno;
    }


    public void setFotoRutaAlumno(String fotoRutaAlumno) {
        this.fotoRutaAlumno = fotoRutaAlumno;
    }
    
   
    
    
    
}
