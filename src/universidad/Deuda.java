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
public class Deuda implements Serializable {
   private Periodo Periodo;

    public Deuda(Periodo Periodo) {
        this.Periodo = Periodo;
    }

    public Periodo getPeriodo() {
        return Periodo;
    }

    public void setPeriodo(Periodo Periodo) {
        this.Periodo = Periodo;
    }

   

    @Override
    public String toString() {
        return "Deuda"+"/n"+ "Periodo:" + Periodo ;
    }

  

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Deuda other = (Deuda) obj;
        if (!Objects.equals(this.Periodo, other.Periodo)) {
            return false;
        }
        return true;
    }
   
      
    
}
