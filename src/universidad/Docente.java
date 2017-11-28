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
public class Docente extends Persona implements Serializable{
    private String Profesion;

    public Docente(String Profesion, long Identificacion, String Nombre, String Apellido, String Password) {
        super(Identificacion, Nombre, Apellido, Password);
        this.Profesion = Profesion;
        this.Apellido = Apellido;
        this.Nombre = Nombre;
    }

    public String getProfesion() {
        return Profesion;
    }

    public void setProfesion(String Profesion) {
        this.Profesion = Profesion;
    }

    @Override
    public String toString() {
        return Nombre+" "+Apellido;
    }

  
    

 

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Docente other = (Docente) obj;
        if (!Objects.equals(this.Profesion, other.Profesion)) {
            return false;
        }
        return true;
    }
    
    
    

}
