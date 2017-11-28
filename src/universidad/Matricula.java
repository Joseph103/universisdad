/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Joe
 */
public class Matricula implements Serializable{
   private Date dateMatricula;
   private Date dateCancelada;
   private Curso Curso;
   
    public Matricula(Curso Curso,Date dateMatricula) {
        this.dateMatricula = dateMatricula;
        this.Curso=Curso;
    }

    public Date getDateMatricula() {
        return dateMatricula;
    }

    public void setDateMatricula(Date dateMatricula) {
        this.dateMatricula = dateMatricula;
    }

    public Date getDateCancelada() {
        return dateCancelada;
    }

    public void setDateCancelada(Date dateCancelada) {
        this.dateCancelada = dateCancelada;
    }

    public Curso getCurso() {
        return Curso;
    }

    public void setCurso(Curso Curso) {
        this.Curso = Curso;
    }

    
  

    @Override
    public String toString() {
        return "Matricula" + "/n"+"dateMatricula:" + dateMatricula + "/n"+"dateCancelada:" + dateCancelada + "/n"+"Curso:" + Curso ;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Matricula other = (Matricula) obj;

        if (!Objects.equals(this.Curso, other.Curso)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }


   
    
    
}
