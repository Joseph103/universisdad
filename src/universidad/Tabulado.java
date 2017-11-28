package universidad;


import Gui.MatriculaAcademica;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Objects;
import javax.swing.JOptionPane;
import universidad.Matricula;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Joe
 */
public class Tabulado implements Serializable{
    private LinkedList<Matricula>Matriculas;
    private Periodo Periodo;
    private byte creditos = 0;
    byte credi;
    MatriculaAcademica matriculaAcademica;

    public Tabulado(Periodo Periodo) {
        this.Matriculas = new LinkedList<>();
        this.Periodo = Periodo;
    }

    public LinkedList<Matricula> getMatriculas() {
        return Matriculas;
    }

    public Periodo getPeriodo() {
        return Periodo;
    }

    public void setPeriodo(Periodo Periodo) {
        this.Periodo = Periodo;
    }

    
    
    public void AddMatricula(Matricula matricula) throws Exception {
        if (Matriculas.contains(matricula)) {
            throw new Exception("Matricula ya se encuentra");
        }
        credi = (byte) (creditos + matricula.getCurso().getAsignatura().getCreditos());
        if (credi > 20) {
            throw new Exception("El estudiante no puede quedar con mas de 20 creditos");
        }
       
        creditos += matricula.getCurso().getAsignatura().getCreditos();
        Matriculas.add(matricula);
    }
    
//     public void RemoveMatricula(Matricula matricula) throws Exception {
//        if (Matriculas.contains(matricula)) {
//          
//         credi = (byte) (creditos + matricula.getCurso().getAsignatura().getCreditos());
//        if (credi < 6) {
//            throw new Exception("El estudiante no puede tener menos de 6 creditos");
//        }}
//        
//        creditos -= matricula.getCurso().getAsignatura().getCreditos();
//        Matriculas.remove(matricula);
//    }
    
    
     
    public Matricula BuscarMatricula(int codigo, int grupo) throws ObjectNotFoundException {
        for (Matricula matricula : this.Matriculas) {
            if (matricula.getCurso().getAsignatura().getCodigo() == codigo && matricula.getCurso().getGrupo() == grupo) {
                return matricula;
            }
        }
        throw new ObjectNotFoundException("No se encontro matricula con el codigo de asignatura " + codigo + " y el grupo " + grupo);
    }
     
     
     public void CancelarCurso(int codigo,int grupo, Programa programa) throws  Exception  {
        Matricula m = BuscarMatricula(codigo, grupo);
         credi = (byte) (creditos - m.getCurso().getAsignatura().getCreditos());
        if (credi < 6) {
            throw new Exception("El estudiante no puede quedar con menos de 6 creditos");
        }
        m.getCurso().Cancelar();
        m.getCurso().BuscarCupo(programa).AumentarDisponibilidad();
        creditos -= m.getCurso().getAsignatura().getCreditos();
    }
   
    

    @Override
    public String toString() {
        return "Tabulado"+"/n" + "Matriculas:" +"/n"+ Matriculas + "Periodo:"+"/n" + Periodo;
    }

  

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tabulado other = (Tabulado) obj;
        if (!Objects.equals(this.Matriculas, other.Matriculas)) {
            return false;
        }
        if (!Objects.equals(this.Periodo, other.Periodo)) {
            return false;
        }
        return true;
    }
    
   

    
}
