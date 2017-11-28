/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.Objects;

/**
 *
 * @author Joe
 */
public class Curso implements Serializable{
   private int Grupo;
   private int TotalCupos;
   private Docente Docente;
   private LinkedList<Horario>Horarios;
   private LinkedList<Cupo> Cupos;
   private Asignatura Asignatura;
   boolean Estado;
   Cupo cupo;
   private LinkedList<Estudiante> estudiantesMatriculados = new LinkedList<>();
   private Date fechaCancelacion = new Date();

   
    public Curso(int Grupo, Docente Docente,Cupo cupo, Asignatura Asignatura) throws Exception {
        this.Grupo = Grupo;
        this.TotalCupos = getTotalCupos();
        this.Horarios = new LinkedList<>();
        this.Docente = Docente;
        this.Cupos = new LinkedList<>();
//        this.Cupos.add(cupo);
        this.Asignatura = Asignatura;
        this.Estado = true;
    }
   

    
    public boolean getEstado(){
     return Estado;    
    }
    
    public int getGrupo() {
        return Grupo;
    }

    public int getTotalCupos() {
        return TotalCupos;
    }

    public LinkedList<Horario> getHorarios() {
        return Horarios;
    }

    public Docente getDocente() {
        return Docente;
    }

    public LinkedList<Cupo> getCupos() {
        return Cupos;
    }

    public Cupo getCupo() {
        return cupo;
    }
    
    public Asignatura getAsignatura() {
        return Asignatura;
    }

     public Date getFechaCancelacion() {
        return fechaCancelacion;
    }
     
    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }

    public LinkedList<Estudiante> getEstudiantesMatriculados() {
        return estudiantesMatriculados;
    }

    public void setEstudiantesMatriculados(LinkedList<Estudiante> estudiantesMatriculados) {
        this.estudiantesMatriculados = estudiantesMatriculados;
    }

    public void setCupos(LinkedList<Cupo> Cupos) {
        this.Cupos = Cupos;
    }
    
    
    
    
    public void AddHorario(Horario horario) throws Exception{
        if(Horarios.contains(horario)){
                throw new Exception("El Horario Ya se Agrego");
            
        }
        
        Horarios.add(horario);
    }
    
    public void AddCupo(Cupo cupo) throws Exception{
        if(Cupos.contains(cupo)){
                throw new Exception("El Cupo Ya se Agrego");
            
        }
        
        Cupos.add(cupo);
        this.TotalCupos += cupo.getCantidad();
    }
     
    public void RemoveCupo(Cupo cupo) throws Exception{
       Cupos.remove(cupo);
        this.TotalCupos -= cupo.getCantidad();
    }
  
    
    public void Cancelar(){
        this.Estado = false;
        
    }
      
    public void Habilitar(){
        this.Estado = true;
        
    }
     
    public Cupo BuscarCupo(Programa programa) throws ObjectNotFoundException {
        for (Cupo c : this.Cupos) {
            if (c.getPrograma().equals(programa)) {
                return c;
            }
        }
        throw new ObjectNotFoundException("Cupos no ofrecido para el programa: " + programa.getNombre());
    }
   
    public void AgregarEstudiante(Estudiante estudiante) {
        estudiantesMatriculados.add(estudiante);
    }
    
    public void EliminarEstudiante(Estudiante estudiante) {
        estudiantesMatriculados.remove(estudiante);
    }
      
    public Cupo BuscarCupo(){
        for (Cupo Cupo1 : Cupos) {
            Cupo c =Cupo1;
               
            return  c;
                    
        }
        return null;
    }
    
    
    public String toEstado() {
        if(Estado == true){
            return "Activo";
        }
        else{
            return "Cancelado";
        }
    }
   
    @Override
    public String toString() {
        return "Curso{" + "Grupo=" + Grupo + ", TotalCupos=" + TotalCupos + ", Horarios=" + Horarios + ", Docente=" + Docente + ", Cupos=" + Cupos + ", Asignatura=" + Asignatura + '}';
    }
  
    

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Curso other = (Curso) obj;
        if (this.Grupo != other.Grupo) {
            return false;
        }
        if (this.TotalCupos != other.TotalCupos) {
            return false;
        }
        if (!Objects.equals(this.Horarios, other.Horarios)) {
            return false;
        }
        if (!Objects.equals(this.Docente, other.Docente)) {
            return false;
        }
        if (!Objects.equals(this.Cupos, other.Cupos)) {
            return false;
        }
        if (!Objects.equals(this.Asignatura, other.Asignatura)) {
            return false;
        }
        return true;
    }
    
    
    

    
    
    
}
