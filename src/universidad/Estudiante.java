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
public class Estudiante extends Persona implements Serializable{
    
  private int Codigo;
  private LinkedList<Tabulado> Tabulados;  
  private LinkedList<Deuda>Deudas ;  
  private Programa Programa;
  private Tabulado tabuladoActual = null;

    public Estudiante(int Codigo,long Identificacion, String Nombre, String Apellido, String Password,Programa programa) {
        super(Identificacion, Nombre, Apellido, Password);
        this.Codigo = Codigo;
        this.Tabulados = new LinkedList<>();
        this.Deudas = new LinkedList<>() ;
        this.Programa = programa;
       
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public LinkedList<Tabulado> getTabulados() {
        return Tabulados;
    }

    public void setTabulados(LinkedList<Tabulado> Tabulados) {
        this.Tabulados = Tabulados;
    }

    public LinkedList<Deuda> getDeudas() {
        return Deudas;
    }

    public void setDeudas(LinkedList<Deuda> Deudas) {
        this.Deudas = Deudas;
    }

    public Programa getPrograma() {
        return Programa;
    }

    public void setPrograma(Programa Programa) {
        this.Programa = Programa;
    }
     
    
    public void AddTabulado(Tabulado tabuladoNuevo) {
        if (tabuladoActual == null) {
            tabuladoActual = tabuladoNuevo;
        } else {
            Tabulados.add(tabuladoActual);
        }
    }

    public Tabulado getTabuladoActual() {
        return tabuladoActual;
    }

//    public void setTabuladoActual(Tabulado tabuladoActual) {
//        this.tabuladoActual = tabuladoActual;
//    }
    
    public void CancelarCurso(int codigo, int grupo) throws Exception {
        tabuladoActual.CancelarCurso(codigo, grupo, Programa);
    }
    
    
    public void AddDeuda(Deuda deuda) throws Exception{
        if (this.Deudas.contains(deuda)){
            throw new Exception("La deuda ya esta contenida");
        }
        this.Deudas.add(deuda);
    }

    
    
    
    @Override
    public String toString() {
        return Nombre +"  "+ Apellido;
    }

   

  

   

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Estudiante other = (Estudiante) obj;
        if (this.Codigo != other.Codigo) {
            return false;
        }
        if (!Objects.equals(this.Tabulados, other.Tabulados)) {
            return false;
        }
        if (!Objects.equals(this.Deudas, other.Deudas)) {
            return false;
        }
        return true;
    }



    
    
}
