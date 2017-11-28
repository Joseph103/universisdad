/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Objects;

/**
 *
 * @author atenea
 */
public class Universidad implements Serializable{
    public Estudiante logueado = null;
    public Docente logueado1 = null;
    private String Nit;
    private String Nombre;
    private String Direccion;
    private Periodo PeriodoActual;
    private LinkedList<Periodo>Periodos = new LinkedList<>();
    private LinkedList<Asignatura>Asignaturas = new LinkedList<>();
    private LinkedList<Docente> Docentes = new LinkedList<>();
    private LinkedList<Estudiante>Estudiantes = new LinkedList<>();
    private LinkedList<Programa>Programas = new LinkedList<>();

    public Universidad(String Nit, String Nombre, String Direccion, Periodo PeriodoActual) {
        this.Nit = Nit;
        this.Nombre = Nombre;
        this.Direccion = Direccion;
        this.PeriodoActual = PeriodoActual;
    }

    
  

    public String getNit() {
        return Nit;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public Periodo getPeriodoActual() {
        return PeriodoActual;
    }

    public LinkedList<Periodo> getPeriodos() {
        return Periodos;
    }

    public LinkedList<Asignatura> getAsignaturas() {
        return Asignaturas;
    }

    public LinkedList<Docente> getDocentes() {
        return Docentes;
    }

    public LinkedList<Estudiante> getEstudiantes() {
        return Estudiantes;
    }

    public LinkedList<Programa> getProgramas() {
        return Programas;
    }
    
//        public Estudiante getEstudianteLogueado() {
//        return logueado;
//    }
    

    
      public void AddPeriodo(Periodo periodo) throws Exception{
        if(this.Periodos.contains(periodo)){
            throw new Exception("el periodo ya esta contenido");
        }
        
        this.Periodos.add(periodo);
    }
    
    public void AddAsignatura(Asignatura asignatura) throws Exception{
        if(this.Asignaturas.contains(asignatura)){
            throw new Exception("La asignatura ya esta contenido");
        }
        
        this.Asignaturas.add(asignatura);
    }
    
    public void AddDocente(Docente docente) throws Exception{
        if(this.Docentes.contains(docente)){
            throw new Exception("El Docente ya se agrego");
        }
        
        this.Docentes.add(docente);
    }
    
    public void AddEstudiante(Estudiante estudiante) throws Exception{
        if(this.Estudiantes.contains(estudiante)){
            throw new Exception("El Estudiante ya se agrego");
        }
        
        this.Estudiantes.add(estudiante);
    }
    
    
    public void AddPrograma(Programa programa) throws Exception{

        if(this.Programas.contains(programa)){
            throw new Exception("El programa ya se agrego");
        }
        
        this.Programas.add(programa);
    }
    
    
    public Estudiante BuscaEstudiante(int codigo) throws ObjectNotFoundException{
        for (Estudiante estudiante: Estudiantes) {
            if(estudiante.getCodigo() == codigo){
                return estudiante;
            }
           
            }
                   
        throw new ObjectNotFoundException("El estudiante con codigo"+" "+ codigo+" "+"no se encuentra");
    }
    
      public Docente BuscaDocente(long Id) throws ObjectNotFoundException{
        for (Docente docente: Docentes) {
            if(docente.getIdentificacion() == Id){
                return docente;
            }
           
            }
                   
        throw new ObjectNotFoundException("El Docente con Id"+" "+ Id+" "+"no se encuentra");
    }
    
      public Docente BuscarDocente(String Nombre ) throws ObjectNotFoundException{
        for (Docente docente: Docentes) {
            if(docente.toString().contains(Nombre.trim())){
                return docente;
            }
           
            }
                   
        throw new ObjectNotFoundException("El Docente "+" "+ Nombre +" "+"no se encuentra");
    }
    
    public Asignatura BuscaAsignatura(int codigo) throws ObjectNotFoundException{
        if(PeriodoActual==null){
            System.out.println("Periodo nulo");
        }
        if(PeriodoActual.getCursos()==null){
            System.out.println("Cursos nulos");
        }
        System.out.println("Va a entrar al ciclo");
        System.out.println("valor de cursos: "+ PeriodoActual.getCursos());
        for (Curso curso :PeriodoActual.getCursos()) {
            System.out.println("asignatura codigo: "+ curso.getAsignatura().getCodigo());
            if(curso.getAsignatura().getCodigo() == codigo){
                return curso.getAsignatura();
            }
           
        }
                   
        throw new ObjectNotFoundException("La asignatura con codigo"+" "+ codigo+" "+"no se encuentra");
    }
    
    
  

    
//    public Estudiante BuscarEstudiante(String Password) throws ObjectNotFoundException{
//        for (Estudiante estudiante: Estudiantes) {
//            if(estudiante.getPassword().equals(Password)){
//                return estudiante;
//            }
//           
//            }
//            
//        
//        throw new ObjectNotFoundException("El estudiante  no se encuentra");
//    }
    
    
    @Override
    public String toString() {
        return "Universidad{" + "Nit=" + Nit + ", Nombre=" + Nombre + ", Direccion=" + Direccion + ", PeriodoActual=" + PeriodoActual + ", Periodos=" + Periodos + ", Asignaturas=" + Asignaturas + ", Docentes=" + Docentes + ", Estudiantes=" + Estudiantes + ", Programas=" + Programas + '}';
    }

    

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Universidad other = (Universidad) obj;
        if (!Objects.equals(this.Nit, other.Nit)) {
            return false;
        }
        if (!Objects.equals(this.Nombre, other.Nombre)) {
            return false;
        }
        if (this.Direccion != other.Direccion) {
            return false;
        }
        if (!Objects.equals(this.PeriodoActual, other.PeriodoActual)) {
            return false;
        }
        if (!Objects.equals(this.Periodos, other.Periodos)) {
            return false;
        }
        if (!Objects.equals(this.Asignaturas, other.Asignaturas)) {
            return false;
        }
        if (!Objects.equals(this.Docentes, other.Docentes)) {
            return false;
        }
        if (!Objects.equals(this.Estudiantes, other.Estudiantes)) {
            return false;
        }
        if (!Objects.equals(this.Programas, other.Programas)) {
            return false;
        }
        return true;
    }

    
    
    
    
}
