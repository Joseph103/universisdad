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
public class Horario implements Serializable{

   private byte Dia;
   private Date HoradeInicio;
   private Date HoraFinal ;

    public Horario(byte Dia, Date HoradeInicio, Date HoraFinal) {
        this.Dia = Dia;
        this.HoradeInicio = HoradeInicio;
        this.HoraFinal = HoraFinal;
    }

    public byte getDia() {
        return Dia;
    }

    public void setDia(byte Dia) {
        this.Dia = Dia;
    }

    public Date getHoradeInicio() {
        return HoradeInicio;
    }

    public void setHoradeInicio(Date HoradeInicio) {
        this.HoradeInicio = HoradeInicio;
    }

    public Date getHoraFinal() {
        return HoraFinal;
    }

    public void setHoraFinal(Date HoraFinal) {
        this.HoraFinal = HoraFinal;
    }

  
    

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Horario other = (Horario) obj;
        if (this.Dia != other.Dia) {
            return false;
        }
        if (!Objects.equals(this.HoradeInicio, other.HoradeInicio)) {
            return false;
        }
        if (!Objects.equals(this.HoraFinal, other.HoraFinal)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Horario" + "/n"+"Dia:" + Dia+"/n" + "HoradeInicio:" + HoradeInicio+"/n" + "HoraFinal:" + HoraFinal ;
    }
    
    
    
    
}
