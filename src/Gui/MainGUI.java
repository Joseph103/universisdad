/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import universidad.Curso;
import universidad.Docente;
import universidad.Estudiante;
import universidad.ObjectNotFoundException;
import universidad.Universidad;

/**
 *
 * @author josep
 */
public class MainGUI extends javax.swing.JFrame {
      Universidad College;
 
      LoginEstudiantes loginEstudiantes;
      LoginCoordinador loginCoordinador;
            
      MatriculaAcademica matriculaAcademica;
      ProgramacionAcademica programacionAcademica;
      form form;
      CancelarCurso cancelarCurso;
      
    public MainGUI(Universidad College) {
       
       this.College = College; 
       
       loginEstudiantes = new LoginEstudiantes (College,this);
       loginCoordinador = new LoginCoordinador(College, this);
      
       
       
                                        
       
       initComponents();
       
      
       Desktop.add(loginEstudiantes);
       Desktop.add(loginCoordinador);
       
       
       jMatriculas.addActionListener(new ManejadorMatricula());
       
       
       Programacion.addActionListener(new ManejadorProgramcion());
       
       
       cancelar.addActionListener(new Cancelar());
       
       About.addActionListener(new AboutDeveloper());
       
       
           super.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                ObjectOutputStream oos = null;
                try {
                    oos = new ObjectOutputStream(new FileOutputStream("UniPro.data"));
                    oos.writeObject(MainGUI.this.College);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    if (oos != null) {
                        try {
                            oos.close();
                        } catch (IOException ex) {
                            Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        });
       
       
      }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Desktop = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu = new javax.swing.JMenu();
        Programacion = new javax.swing.JMenuItem();
        jMatriculas = new javax.swing.JMenuItem();
        cancelar = new javax.swing.JMenuItem();
        Help = new javax.swing.JMenu();
        About = new javax.swing.JMenuItem();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Desktop.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout DesktopLayout = new javax.swing.GroupLayout(Desktop);
        Desktop.setLayout(DesktopLayout);
        DesktopLayout.setHorizontalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1019, Short.MAX_VALUE)
        );
        DesktopLayout.setVerticalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 695, Short.MAX_VALUE)
        );

        jMenu.setText("Menu");

        Programacion.setText("Programacion Academica");
        jMenu.add(Programacion);

        jMatriculas.setText("Matriculas Estudiante");
        jMatriculas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMatriculasActionPerformed(evt);
            }
        });
        jMenu.add(jMatriculas);

        cancelar.setText("Cancelar Programacion");
        cancelar.setToolTipText("TIIENE QUE SER UN COORDINADOR PARA PODER ACCEDER");
        cancelar.setEnabled(false);
        jMenu.add(cancelar);

        jMenuBar1.add(jMenu);

        Help.setText("Help");

        About.setText("About");
        About.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AboutActionPerformed(evt);
            }
        });
        Help.add(About);

        jMenuBar1.add(Help);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Desktop, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Desktop)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMatriculasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMatriculasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMatriculasActionPerformed

    private void AboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AboutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AboutActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem About;
    private javax.swing.JDesktopPane Desktop;
    private javax.swing.JMenu Help;
    private javax.swing.JMenuItem Programacion;
    private javax.swing.JMenuItem cancelar;
    private javax.swing.JMenuItem jMatriculas;
    private javax.swing.JMenu jMenu;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    public JMenuItem getCancelar() {
        return cancelar;
    }


    

    public void mostrarventanaMA (Estudiante e){
       loginEstudiantes.setVisible(false);
        
       matriculaAcademica = new MatriculaAcademica (College,e); 
       Desktop.add(matriculaAcademica);
 
       matriculaAcademica.setVisible(true);
    }
    
    
    
     public void mostrarventanaP (Docente d){
       loginCoordinador.setVisible(false);
       
       
       form = new form(); 
       Desktop.add(form);
 
       form.setVisible(true);
    }
    
     public class Cancelar implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            
            
            cancelarCurso = new CancelarCurso(College);
            Desktop.add(cancelarCurso);
            
            cancelarCurso.setVisible(true);
            
        }
        
    }
    
    
    
    
    
    
    public class ManejadorMatricula implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
           
          
                 loginEstudiantes.setVisible(true);
           
          
        }

    }
    
    
    public class ManejadorProgramcion implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
                         
                
                loginCoordinador.setVisible(true);
                           
        }

    }
    
    
    public class AboutDeveloper implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
           JOptionPane.showMessageDialog(Desktop, "Por favor contactar el developer joseph.103@hotmail.es");
        }
        
    }
    
    
    
   
}
