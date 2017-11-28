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
public class Programa implements Serializable{
    private int Codigo;
    private String Nombre;
    private String Jornada;
    private LinkedList<Semestre> Semestres = new LinkedList<>();
    private LinkedList<Asignatura>Asignaturas = new LinkedList<>();
    

    public Programa(int Codigo, String Nombre, String Jornada) {
        this.Codigo = Codigo;
        this.Nombre = Nombre;
        this.Jornada = Jornada;
        
    }

    public int getCodigo() {
        return Codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getJornada() {
        return Jornada;
    }

    public LinkedList<Semestre> getSemestres() {
        return Semestres;
    }

    public LinkedList<Asignatura> getAsignaturas() {
        return Asignaturas;
    }
    
    
    public void AddSemestre(Semestre semestre) throws Exception{
        if(this.Semestres.contains(semestre)){
            throw new Exception("El semestre ya esta contenido");
        }
        
        this.Semestres.add(semestre);
    }
    
    public void AddAsignatura(Asignatura asignatura) throws Exception{
        if(this.Asignaturas.contains(asignatura)){
            throw new Exception("La asignatura ya esta contenido");
        }
        
        this.Asignaturas.add(asignatura);
    }
    
    

    @Override
    public String toString() {
        return Codigo + "-" +Nombre ;
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Programa other = (Programa) obj;
        if (this.Codigo != other.Codigo) {
            return false;
        }
        if (!Objects.equals(this.Nombre, other.Nombre)) {
            return false;
        }
        if (!Objects.equals(this.Jornada, other.Jornada)) {
            return false;
        }
        if (!Objects.equals(this.Semestres, other.Semestres)) {
            return false;
        }
        if (!Objects.equals(this.Asignaturas, other.Asignaturas)) {
            return false;
        }
        return true;
    }
    
    

 
    
    
    
}
