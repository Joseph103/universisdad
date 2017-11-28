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
public class Semestre implements Serializable{
    private int Numero;
    private LinkedList<Asignatura> Asignaturas;

    public Semestre(int Numero, LinkedList<Asignatura> Asignaturas) {
        this.Numero = Numero;
        this.Asignaturas = Asignaturas;
    }

    public int getNumero() {
        return Numero;
    }

    public LinkedList<Asignatura> getAsignaturas() {
        return Asignaturas;
    }
    
    
     public void AddAsignatura(Asignatura asignatura) throws Exception{
        if(this.Asignaturas.contains(asignatura)){
            throw new Exception("El curso ya esta contenido");
        }
        
        this.Asignaturas.add(asignatura);
    }

    @Override
    public String toString() {
        return "Semestre" +"/n"+ "Numero:" + Numero +"/n"+ "Asignaturas:" + Asignaturas ;
    }

    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Semestre other = (Semestre) obj;
        if (this.Numero != other.Numero) {
            return false;
        }
        if (!Objects.equals(this.Asignaturas, other.Asignaturas)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
}
