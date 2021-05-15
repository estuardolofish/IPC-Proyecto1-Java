
package main;

import static main.AccionesProfesor.txtContrasenia;


public class Profesores {
    
     private int codigoProfe;
    private String nombreProfe;
    private String apellidoProfe;
    private String correoProfe;
    private String generoProfe;
    private String contaseniaProfe;
    
    
    public Profesores() {
        codigoProfe = 0;       
        nombreProfe = "";
        apellidoProfe = "";
        correoProfe = "";
        generoProfe = "";
        contaseniaProfe = "";
    }

    public Profesores(int codigoProfe, String nombreProfe, String apellidoProfe, String correoProfe, String generoProfe, String contaseniaProfe) {
        this.codigoProfe = codigoProfe;
        this.nombreProfe = nombreProfe;
        this.apellidoProfe = apellidoProfe;
        this.correoProfe = correoProfe;
        this.generoProfe = generoProfe;
        this.contaseniaProfe = contaseniaProfe;
    }
    
    public void mostrarDatosProfesores()
    {
        System.out.println("CODIGO: " + codigoProfe);
        System.out.println("NOMBRE: " + nombreProfe);
    }
    
    public void mostrarDatosProfesoresAcciones() {
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
       AccionesProfesor.comboGenero.setSelectedIndex(1);
        
        //AccionesProfesor.comboGenero.setToolTipText("FEMENINO");
        
        }else if (generoProfe.equalsIgnoreCase("m")) {
            
        
       AccionesProfesor.comboGenero.setSelectedIndex(2);
        }
      
    }

 
    public int getCodigoProfe() {
        return codigoProfe;
    }

  
    public void setCodigoProfe(int codigoProfe) {
        this.codigoProfe = codigoProfe;
    }

   
    public String getNombreProfe() {
        return nombreProfe;
    }

 
    public void setNombreProfe(String nombreProfe) {
        this.nombreProfe = nombreProfe;
    }


    public String getApellidoProfe() {
        return apellidoProfe;
    }


    public void setApellidoProfe(String apellidoProfe) {
        this.apellidoProfe = apellidoProfe;
    }


    public String getCorreoProfe() {
        return correoProfe;
    }


    public void setCorreoProfe(String correoProfe) {
        this.correoProfe = correoProfe;
    }

 
    public String getGeneroProfe() {
        return generoProfe;
    }


    public void setGeneroProfe(String generoProfe) {
        this.generoProfe = generoProfe;
    }


    public String getContaseniaProfe() {
        return contaseniaProfe;
    }


    public void setContaseniaProfe(String contaseniaProfe) {
        this.contaseniaProfe = contaseniaProfe;
    }
   
    
    
}
