/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad;
import java.io.Serializable;
/**
 *
 * @author josep
 */
public class ObjectNotFoundException extends Exception{

    public ObjectNotFoundException() {
    }

    public ObjectNotFoundException(String string) {
        super(string);
    }

    public ObjectNotFoundException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public ObjectNotFoundException(Throwable thrwbl) {
        super(thrwbl);
    }

    public ObjectNotFoundException(String string, Throwable thrwbl, boolean bln, boolean bln1) {
        super(string, thrwbl, bln, bln1);
    }
    
    
}
