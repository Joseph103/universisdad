/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author atenea
 */
public class Asignatura implements Serializable{
   private int Codigo;
   private String Nombre;
   private byte Creditos;
   private int Intensidad;
    

    public Asignatura(int Codigo, String Nombre, byte Creditos, int Intensidad) {
        this.Codigo = Codigo;
        this.Nombre = Nombre;
        this.Creditos = Creditos;
        this.Intensidad = Intensidad;
        
    }

    public int getCodigo() {
        return Codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public byte getCreditos() {
        return Creditos;
    }

    public int getIntensidad() {
        return Intensidad;
    }
    
    

    

    @Override
    public String toString() {
        return  Nombre +"   "+"Creditos:"+" "+Creditos+"   "+"Intesidad :"+" "+ Intensidad ;
    }

   

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Asignatura other = (Asignatura) obj;
        if (this.Codigo != other.Codigo) {
            return false;
        }
        if (!Objects.equals(this.Nombre, other.Nombre)) {
            return false;
        }
        if (this.Creditos != other.Creditos) {
            return false;
        }
        if (this.Intensidad != other.Intensidad) {
            return false;
        }
        
        return true;
    }
    
    
    


    
}
