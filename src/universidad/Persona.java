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
 * @author Joe
 */
public class Persona implements Serializable{
    long  Identificacion;
    String Nombre;
    String Apellido;
    String Password;

    public Persona(long Identificacion, String Nombre, String Apellido, String Password) {
        this.Identificacion = Identificacion;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Password = Password;
    }

    public long getIdentificacion() {
        return Identificacion;
    }

    public void setIdentificacion(long Identificacion) {
        this.Identificacion = Identificacion;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

   

  

    @Override
    public String toString() {
        return  Nombre +"  "+ Apellido;
    }



    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;
        if (this.Identificacion != other.Identificacion) {
            return false;
        }
        if (!Objects.equals(this.Nombre, other.Nombre)) {
            return false;
        }
        if (!Objects.equals(this.Apellido, other.Apellido)) {
            return false;
        }
        return true;
    }
    

 
    
    
}
