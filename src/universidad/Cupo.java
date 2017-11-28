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
public class Cupo implements Serializable {
    private int Cantidad;
    private int Disponibles;
    private Programa Programa;

    public Cupo(int Cantidad, int Disponibles, Programa Programa) {
        this.Cantidad = Cantidad;
        this.Disponibles = Disponibles;
        this.Programa = Programa;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public int getDisponibles() {
        return Disponibles;
    }

    public Programa getPrograma() {
        return Programa;
    }

       public void DecrementarDisponibilidad(){
       this.Disponibles -= 1;
    }
    public void AumentarDisponibilidad(){
        this.Disponibles += 1;
    }
    
    @Override
    public String toString() {
        return "Cupo{" + "Cantidad=" + Cantidad + ", Disponibles=" + Disponibles + ", Programa=" + Programa + '}';
    }

    

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
      
        final Cupo other = (Cupo) obj;
       
        if (!Objects.equals(this.Programa, other.Programa)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
