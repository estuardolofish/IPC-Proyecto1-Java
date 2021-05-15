
package main;

import com.jtattoo.plaf.mcwin.McWinLookAndFeel;
import javax.swing.JFrame;
import javax.swing.UIManager;
import com.jtattoo.plaf.hifi.HiFiLookAndFeel;




public class Main {
    static Profesores[] profesores = new Profesores[50];
    static int cProfesores = 0;
    static Alumnos[] alumnos = new Alumnos[300];
    static int cAlumnos = 0;
    static Cursos[] cursos = new Cursos[1000];
    static int cCursos = 0;
    
    public static void main(String[] args) {
        
        JFrame.setDefaultLookAndFeelDecorated(true);

        try{

            UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
            //UIManager.setLookAndFeel(new McWinLookAndFeel());

            Login login = new Login();          
        }catch(Exception e){
            e.printStackTrace();
        }
        
       
    }
    
    //METODOS PARA EL PROFESOR
    
    //INGRESO DE DATOS AL ARREGLO
    public static void agregarProfesor(Profesores profesor)
    {
        if (cProfesores < profesores.length) {
            profesores[cProfesores] = profesor;
            cProfesores++;
        }
        else
        {
            System.out.println("LLEGASTE AL LIMITE DE PROFESORES");
        }
    }
    
    public static void mostrarProfesor()
    {
        for (int i = 0; i < cProfesores; i++) {
            profesores[i].mostrarDatosProfesores();
        }
    }
    
        // METODO PARA BUSCAR UNA PERSONA POR SU CODIGO
    public static void mostrarProfesorAcciones(int Codigo){
        for (int i = 0; i < cProfesores; i++) {

            if(profesores[i].getCodigoProfe() == Codigo)
            {
                profesores[i].mostrarDatosProfesoresAcciones();  
                //AccionesProfesor.txtCodigo.setText(String.valueOf(profesores[i].getCodigoProfe()));
                return;
            }
         
        }
        System.out.println("No se encontro el nombre");
    }
    
    public static Object[][] convertirDatosTabla()
    {
        int filas = cProfesores;
        Object[][] arregloProfesores = new Object[filas][5];
        for (int i = 0; i < filas; i++) {
            if (profesores[i] != null) {
                
            arregloProfesores[i][0] = profesores[i].getCodigoProfe();
            arregloProfesores[i][1] = profesores[i].getNombreProfe();
            arregloProfesores[i][2] = profesores[i].getApellidoProfe();
            arregloProfesores[i][3] = profesores[i].getCorreoProfe();
            arregloProfesores[i][4] = profesores[i].getGeneroProfe();
            }
        }
        return arregloProfesores;
    }
    
    
    //METODOS PARA EL CURSO

    
    //INGRESO DE DATOS AL ARREGLO
    public static void agregarCurso(Cursos curso)
    {
        if (cCursos < cursos.length) {
            cursos[cCursos] = curso;
            cCursos++;
        }
        else
        {
            System.out.println("LLEGASTE AL LIMITE DE PROFESORES");
        }
    }
    
    public static void mostrarCurso()
    {
        for (int i = 0; i < cCursos; i++) {
            cursos[i].mostrarDatosCursos();
        }
    }
    
        // METODO PARA BUSCAR UNA PERSONA POR SU CODIGO
    public static void mostrarCursoAcciones(int Codigo){
        for (int i = 0; i < cCursos; i++) {

            if(cursos[i].getCodigoCurso() == Codigo)
            {
                cursos[i].mostrarDatosCursosAcciones();  
                //AccionesProfesor.txtCodigo.setText(String.valueOf(profesores[i].getCodigoProfe()));
                return;
            }
         
        }
        System.out.println("No se encontro el nombre");
    }
    
    public static String encontrarProfesorID(int id) {
        for (int i = 0; i < cProfesores; i++) {
            if (profesores[i].getCodigoProfe() == id) {
                return profesores[i].getNombreProfe() + " " + profesores[i].getApellidoProfe();
            }
        }
        return null;
    }
    
       public static int encontrarProfesorNomApe(String nombre , String apellido) {
        for (int i = 0; i < cProfesores; i++) {
            if (profesores[i].getNombreProfe().equals(nombre)  && profesores[i].getApellidoProfe().equals(apellido)) {
                return profesores[i].getCodigoProfe();
            }
        }
        return 0;
    }
    
    public static Object[][] convertirDatosTablaCursos()
    {
        int filas = cCursos;
        int codigoprofe = 0;
        Object[][] arregloCursos = new Object[filas][5];
        for (int i = 0; i < filas; i++) {
            if (cursos[i] != null) {
                
            arregloCursos[i][0] = cursos[i].getCodigoCurso();
            arregloCursos[i][1] = cursos[i].getNombreCurso();
            arregloCursos[i][2] = cursos[i].getCreditosCurso();
            arregloCursos[i][3] = cursos[i].getAlumnosCurso();
            codigoprofe = cursos[i].getCodigoProfesor();
            encontrarProfesorID(codigoprofe);
            arregloCursos[i][4] = encontrarProfesorID(codigoprofe);
            //arregloCursos[i][4] = profesores[codigoprofe-1].getNombreProfe() + " " + profesores[codigoprofe-1].getApellidoProfe();
            }
            codigoprofe=0;
        }
        return arregloCursos;
    }
    
    //METODOS PARA LOS ALUMNOS
    public static void agregarAlumno(Alumnos alumno)
    {
        if (cAlumnos < alumnos.length) {
            alumnos[cAlumnos] = alumno;
            cAlumnos++;
        }
        else
        {
            System.out.println("LLEGASTE AL LIMITE DE ALUMNOS");
        }
    }
    
 
    
        // METODO PARA BUSCAR UNA PERSONA POR SU CODIGO

    
    public static Object[][] convertirDatosTablaAlumno()
    {
        int filas = cAlumnos;
        Object[][] arregloAlumnos = new Object[filas][5];
        for (int i = 0; i < filas; i++) {
            if (alumnos[i] != null) {
                
            arregloAlumnos[i][0] = alumnos[i].getCodigoAlumno();
            arregloAlumnos[i][1] = alumnos[i].getNombreAlumno();
            arregloAlumnos[i][2] = alumnos[i].getApellidoAlumno();
            arregloAlumnos[i][3] = alumnos[i].getCorreoAlumno();
            arregloAlumnos[i][4] = alumnos[i].getGeneroAlumno();
            }
        }
        return arregloAlumnos;
    }
    
    
}
