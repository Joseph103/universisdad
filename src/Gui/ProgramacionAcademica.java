/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import universidad.Asignatura;
import universidad.Cupo;
import universidad.Curso;
import universidad.Docente;
import universidad.Matricula;
import universidad.ObjectNotFoundException;
import universidad.Programa;
import universidad.Universidad;

/**
 *
 * @author josep
 */
public class ProgramacionAcademica extends javax.swing.JInternalFrame {
     
    public Universidad College;
     Asignatura asig;
     Matricula matricula;
     Docente d;
     Cupo c;
     LinkedList<Programa> lista;
     Curso curso;
     Programa programa;

     
     /**
     * Creates new form ProgramacionAcademica
     */
    public ProgramacionAcademica(Universidad college,Docente docente) {
       
        this.College = college;
        this.curso=College.getPeriodoActual().getCursos().get(0);
        initComponents();
        cargarComboProgramas();
        Agregar.addActionListener(new AgregarCurso());
        CodField.addActionListener(new BuscarAsignatura());
        IdField.addActionListener(new BuscarDocente());
        NombreField.addActionListener(new BuscarDocenteN());
        PNC.addActionListener(new ProgramarNuevoCurso());
        

        
        
//        for (Curso curso : College.getPeriodoActual().getCursos()) {
//            
//                curso.getCupos().clear();
//               
//            }
                   
               
        
        
                this.Table.setModel(new AbstractTableModel() {

            @Override
            public int getRowCount() { 

                if (curso.getCupos()== null) {
                    return 0;
                }
                return curso.getCupos().size();
            }

            @Override
            public int getColumnCount() {
                return 2;
            }

            @Override
            public String getColumnName(int ColumIndex) {
                switch (ColumIndex) {
                    case 0:
                        return "Programa";
                    case 1:
                        return "Cupos";
             
                }
                
                return "";
            }

            @Override
            public Object getValueAt(int RowIndex, int ColumnIndex) {
               Cupo cupo = curso.getCupos().get(RowIndex);
              
//               for (Cupo c :College.getPeriodoActual().getCursos().get(RowIndex).getCupos()){
                switch (ColumnIndex) {
                    case 0:
                        return cupo.getPrograma().getNombre();
                    case 1:
                        return cupo.getCantidad();
                    
              
                        
                }
                return "";
//            }
               
            }
            
            
        });
                
                
                  this.Guardar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    if (asig == null) {
                        throw new Exception("debe buscar una signatura y debe digitar un grupo".toUpperCase());
                    }
                    if (docente == null) {
                        throw new Exception("debe asignar un docente");
                    }
                    if (curso.getCupos().isEmpty() == true) {
                        throw new Exception("debe agregar un cupo");
                    }
                    if ("".equals(GrupoField.getText().trim())) {
                        throw new Exception("debe digitar un grupo");
                    }
                    short grupo = Short.parseShort(GrupoField.getText().trim());
                    curso = new Curso(grupo,docente,curso.getCupo(),asig);
                    int op = 0;
                    //long acumf = 0;
                    for (Cupo cupoadi : curso.getCupos()) {
                        curso.AddCupo(cupoadi);
                    }
                   
                    College.getPeriodoActual().AddCurso(curso);
                   
                    JOptionPane.showMessageDialog(ProgramacionAcademica.this, "curso guardado exitosamente");
                    CodField.setText("");
                    NombreField.setText("");
                    CredField.setText("");
                    GrupoField.setText("");
                    IntencidadField.setText("");
                    IdField.setText("");
                    NomField.setText("");
                    FormacionField.setText("");
                    TotalCupos.setText("");
                    
                    d = null;
                    programa = null;
                    asig = null;
                    curso.getCupos().clear();
            
                    
                    
                    Table.updateUI();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(ProgramacionAcademica.this, ex.getMessage());
                    Logger.getLogger(ProgramacionAcademica.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
   
    }
        
        
    
    
    

    public void cargarComboProgramas(){
         lista = College.getProgramas();
        for (Programa lista1 : lista){
            Programa p = lista1;
            ComboBox.addItem(p.toString());
        }
    }

    public Programa Programas(){
        lista = College.getProgramas();
        Programa p = null;
        for (Programa lista1 : lista){
            p = lista1;
        }
        return p;
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
        CodField = new javax.swing.JTextField();
        NomField = new javax.swing.JTextField();
        CredField = new javax.swing.JTextField();
        IntencidadField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        GrupoField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        IdField = new javax.swing.JTextField();
        NombreField = new javax.swing.JTextField();
        FormacionField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        ComboBox = new javax.swing.JComboBox();
        CuposField = new javax.swing.JTextField();
        Agregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        Guardar = new javax.swing.JButton();
        PNC = new javax.swing.JButton();
        TotalCupos = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.gray, java.awt.Color.gray), "Asignatura"));

        IntencidadField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IntencidadFieldActionPerformed(evt);
            }
        });

        jLabel1.setText("Codigo:");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Cred:");

        jLabel4.setText("I.H:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CodField, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NomField, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(CredField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(IntencidadField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(NomField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CodField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CredField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IntencidadField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jLabel5.setText("Grupo:");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.gray, java.awt.Color.gray), "Docente"));

        NombreField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NombreFieldActionPerformed(evt);
            }
        });

        jLabel6.setText("Identificacion:");

        jLabel7.setText("Nombre:");

        jLabel8.setText("Formacion:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(IdField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(NombreField, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 131, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(FormacionField)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NombreField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FormacionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.gray, java.awt.Color.gray), "Cupos  Por Programa Academico"));

        jLabel9.setText("Programcion Academica:");

        ComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxActionPerformed(evt);
            }
        });

        Agregar.setText("Agregar");

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(Table);

        jLabel11.setText("Cupos:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(ComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(CuposField, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Agregar))
                            .addComponent(jLabel11)))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CuposField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Agregar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Guardar.setText("Guardar");

        PNC.setText("Programar Nuevo Curso");

        jLabel10.setText("Total Cupos:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(487, Short.MAX_VALUE)
                .addComponent(PNC)
                .addGap(46, 46, 46))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(112, 112, 112))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(48, 48, 48)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(GrupoField, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 159, Short.MAX_VALUE)
                            .addComponent(TotalCupos, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(48, 48, 48)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(466, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(24, 24, 24)
                .addComponent(PNC)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(27, 27, 27)
                            .addComponent(jLabel5)
                            .addGap(18, 18, 18)
                            .addComponent(GrupoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(18, 18, 18)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(TotalCupos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(Guardar)))
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IntencidadFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IntencidadFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IntencidadFieldActionPerformed

    private void NombreFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombreFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NombreFieldActionPerformed

    private void ComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Agregar;
    private javax.swing.JTextField CodField;
    private javax.swing.JComboBox ComboBox;
    private javax.swing.JTextField CredField;
    private javax.swing.JTextField CuposField;
    private javax.swing.JTextField FormacionField;
    private javax.swing.JTextField GrupoField;
    private javax.swing.JButton Guardar;
    private javax.swing.JTextField IdField;
    private javax.swing.JTextField IntencidadField;
    private javax.swing.JTextField NomField;
    private javax.swing.JTextField NombreField;
    private javax.swing.JButton PNC;
    private javax.swing.JTable Table;
    private javax.swing.JTextField TotalCupos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    


 public class BuscarAsignatura implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {

            try {

                asig = College.BuscaAsignatura(Integer.parseInt(CodField.getText()));
                NomField.setText(asig.getNombre());
                CredField.setText(Byte.toString(asig.getCreditos()));
                IntencidadField.setText(Integer.toString(asig.getIntensidad()));

            } catch (ObjectNotFoundException ex) {
                Logger.getLogger(MatriculaAcademica.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(Table, ex.getMessage());
            }

        }
    }
 
  public class BuscarDocente implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
      
            try {

                d = College.BuscaDocente(Integer.parseInt(IdField.getText()));
                NombreField.setText(d.toString());
                FormacionField.setText((d.getProfesion()));
                

            } catch (ObjectNotFoundException ex) {
                Logger.getLogger(MatriculaAcademica.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(Table, ex.getMessage());
            }

        }
    }
  
  
  public class BuscarDocenteN implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
       Docente ns ;
            try {

             
              ns = College.BuscarDocente(NombreField.getText());
                IdField.setText(ns.getIdentificacion()+"");
                FormacionField.setText((ns.getProfesion()));
                NombreField.setText(ns.toString());

            } catch (ObjectNotFoundException ex) {
                Logger.getLogger(MatriculaAcademica.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(Table, ex.getMessage());
            }

        }
    }
  
  

  
  public class AgregarCurso implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                 
           programa =  College.getProgramas().get(ComboBox.getSelectedIndex());
           Cupo cupo = new Cupo(Integer.parseInt(CuposField.getText()),Integer.parseInt(CuposField.getText()),programa);
                
            
                curso  = College.getPeriodoActual().BuscarCurso(asig, Integer.parseInt(GrupoField.getText()));
                
              curso.AddCupo(cupo);
                Table.updateUI();
               
               
              TotalCupos.setText(Integer.toString(curso.getTotalCupos()));
                      
                
                
            } catch (Exception ex) {
                 JOptionPane.showMessageDialog(null, ex.getMessage());
                Logger.getLogger(ProgramacionAcademica.class.getName()).log(Level.SEVERE, null, ex);
               
            }
        }
      
  }
  
  
    public class ProgramarNuevoCurso  implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                CodField.setText("");
                
                NombreField.setText("");
                CredField.setText("");
                GrupoField.setText("");
                IdField.setText("");
                NomField.setText("");
                FormacionField.setText("");
                TotalCupos.setText("");
                IntencidadField.setText("");
                CuposField.setText("");
                curso.setCupos(new LinkedList<>());
                d = null;
                programa = null;
                asig = null;
               
              
                Table.updateUI();    
                ComboBox.updateUI();
            }
      
    }
    
    
  
      
  }
  

