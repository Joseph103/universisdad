/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad;

import Gui.MainGUI;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author josep
 */
public class Main {

    /**
     * @param args the command line arguments
     */

    Curso c;

    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                Universidad College = null;
                ObjectInputStream ois = null;

                try {
                    ois = new ObjectInputStream(new FileInputStream("UniPro.data"));

                    College = (Universidad) ois.readObject();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    if (ois != null) {
                        try {
                            ois.close();
                        } catch (IOException ex) {
                            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                if (College == null) {

                    try {

                        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm aa");

                        Asignatura[] asignaturas = {new Asignatura(458, "Calculo 2", (byte) 4, 4),
                            new Asignatura(78, "Funda mentos de programacion", (byte) 4, 4), new Asignatura(10, "pri", (byte) 4, 4)};

                        Programa[] programas = {new Programa(456, "Tec Sistemas", "Diurna"),
                            new Programa(120, "Ing. Sistemas", "Diurna"),
                            new Programa(540, "Ing.Industrial", "Diurna"),
                            new Programa(200, "Derecho", "Diurena")};

                        Docente[] docentes = {new Docente("Ingeniero Systemas", 123456, "Andres", "Sanchez", "789"),
                            new Docente("Abogado", 456, "Fernando", "Candelo", "589"),
                            new Docente("Ingeniero Industrial", 1236, "Andrea", "Ramires", "123")};

                        Estudiante[] estudiantes = {new Estudiante(123, 4564213, "Joseph", "Bejarano", "123456", programas[0]),
                            new Estudiante(13, 4564213, "Jose", "arano", "123", programas[0])};

                        Cupo cupo = new Cupo(12, 5, programas[0]);
                        Cupo cupo1 = new Cupo(12, 5, programas[1]);
                        Cupo cupo2 = new Cupo(12, 5, programas[2]);
                        Cupo cupo3 = new Cupo(12, 5, programas[3]);

                        Horario horario = new Horario((byte) 1, sdf.parse("8:00 Am"), sdf.parse("10:00 Am"));

                        Curso[] cursos = {new Curso(50, docentes[0], cupo, asignaturas[0]),
                            new Curso(50, docentes[0], cupo1, asignaturas[1]),
                            new Curso(50, docentes[1], cupo2, asignaturas[2]),
                            new Curso(50, docentes[2], cupo3, asignaturas[2])};

                        Periodo periodo = new Periodo("Agosto", "Diciembre", (short) 2015);
                        Periodo[] periodos = {new Periodo("Marzo", "Julio", (short) 1994)};

                        periodo.AddCurso(cursos[0]);
                        periodo.AddCurso(cursos[1]);
                        periodo.AddCurso(cursos[2]);
                        periodo.AddCurso(cursos[3]);

                        College = new Universidad("123-NA", "ToPro", "Calle 25 #32-20", periodo);

                        for (Periodo periodo1 : periodos) {
                            College.AddPeriodo(periodo1);
                        }
                        for (Asignatura asignatura1 : asignaturas) {
                            College.AddAsignatura(asignatura1);
                        }
                        for (Programa programa1 : programas) {
                            College.AddPrograma(programa1);
                        }
                        for (Docente docente1 : docentes) {
                            College.AddDocente(docente1);
                        }
                        for (Estudiante estudiante1 : estudiantes) {
                            College.AddEstudiante(estudiante1);
                        }

                    } catch (Exception ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }

                }

                MainGUI ventana = new MainGUI(College);
                ventana.setVisible(true);
            }
        });
    }
}
