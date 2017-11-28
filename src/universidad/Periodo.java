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
 * @author Joe
 */
public class Periodo implements Serializable{

    private String Inicio;
    private String Final;
    private short Año;
    private LinkedList<Curso> Cursos;

    public Periodo(String Inicio, String Final, short Año) {
        this.Inicio = Inicio;
        this.Final = Final;
        this.Año = Año;
        this.Cursos = new LinkedList<>();

    }

    public String getInicio() {
        return Inicio;
    }

    public String getFinal() {
        return Final;
    }

    public short getAño() {
        return Año;
    }

    public LinkedList<Curso> getCursos() {
        return Cursos;
    }

    public void AddCurso(Curso curso) throws Exception {
        if (this.Cursos.contains(curso)) {
            throw new Exception("El curso ya esta contenido");
        }

        this.Cursos.add(curso);
    }
    
    public void RemoveCurso(Curso curso) throws Exception {
        if (this.Cursos.contains(curso)) {
            this.Cursos.remove(curso);
        }

       throw new Exception("El curso no esta contenido");
    }

    public void setCursos(LinkedList<Curso> Cursos) {
        this.Cursos = Cursos;
    }

    public void CancelarCurso(Curso curso) throws Exception {
        if (curso.Estado == false) {
            throw new Exception("El curso ya fue canselado");
        }
        curso.Estado = true;

    }

    public Cupo BuscarCupo() {
        for (Curso Curso1 : Cursos) {
            Cupo c = Curso1.getCupo();
            return c;
        }
       return null;
    }

    public Curso BuscarCurso(Asignatura a, int grupo) throws ObjectNotFoundException, Exception {

        if ("" == Integer.toString(grupo)) {
            throw new NumberFormatException("Por favor digite un grupo");
        } else {

            for (Curso Curso1 : Cursos) {
                if (Curso1.getAsignatura().equals(a)) {
                    if (Curso1.getGrupo() == grupo) {
                        return Curso1;
                    }

                }

            }
            throw new ObjectNotFoundException("El curso no esta programado");
        }
    }   
    
    public Curso BuscarCurso1(Cupo c) throws ObjectNotFoundException, Exception {

            for (Curso Curso1 : Cursos) {
                if (Curso1.BuscarCupo().equals(c)) { 
                        return Curso1;
                    }

                }
          throw new ObjectNotFoundException("El curso no esta programado");
            }
            
        
    

    @Override
    public String toString() {
        return Inicio + "-" + Final + "/" + Año;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Periodo other = (Periodo) obj;
        if (!Objects.equals(this.Inicio, other.Inicio)) {
            return false;
        }
        if (!Objects.equals(this.Final, other.Final)) {
            return false;
        }
        if (this.Año != other.Año) {
            return false;
        }
        if (!Objects.equals(this.Cursos, other.Cursos)) {
            return false;
        }
        return true;
    }

}
