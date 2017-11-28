package Gui;

import universidad.Curso;
import universidad.Matricula;
import universidad.Universidad;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import universidad.Asignatura;
import universidad.ObjectNotFoundException;

/**
 *
 * @author Miguel
 */
public class CancelarCurso extends javax.swing.JInternalFrame {

    private Universidad universidad;
    private LinkedList<Curso> cursos = new LinkedList<>();
     Asignatura asig;
     
    public CancelarCurso(Universidad universidad) {
        this.universidad = universidad;
        initComponents();
        String s = JOptionPane.showInputDialog(Table, "Ingrese el Codigo de la Asignatura");
        Table.setVisible(false);
        try {
            
            asig = universidad.BuscaAsignatura(Integer.parseInt(s));
            Table.setVisible(true);
        } catch (ObjectNotFoundException ex) {
            Logger.getLogger(CancelarCurso.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
                
        
        cursos = universidad.getPeriodoActual().getCursos();
        
        
        Cancelar.setEnabled(false);
        Habilitar.setEnabled(false);
        
        Cancelar.addActionListener(new Cancelar());
        
        Habilitar.addActionListener(new Habilitar());
        
        this.Table.setModel(new AbstractTableModel() {

            @Override
            public int getRowCount() {
                return cursos.size();
            }

            @Override
            public int getColumnCount() {
                return 6;
            }

            @Override
            public String getColumnName(int ColumnIndex) {
                switch (ColumnIndex) {
                    case 0:
                        return "Codigo";
                    case 1:
                        return "Nombre";
                    case 2:
                        return "Grupo";
                    case 3:
                        return "Docente";
                    case 4:
                        return "Estado Curso";
                    case 5:
                        return "Fecha Cancelacion";
                }
                return "";
            }

            @Override
            public Object getValueAt(int RowIndex, int ColumnIndex) {
                Curso curso = cursos.get(RowIndex);
                switch (ColumnIndex) {
                    case 0:
                        return curso.getAsignatura().getCodigo();
                    case 1:
                        return curso.getAsignatura().getNombre();
                    case 2:
                        return curso.getGrupo();
                    case 3:
                        return curso.getDocente().getNombre();
                    case 4:
                        return curso.toEstado();
                    case 5:
                        if (curso.getEstado() == true) {
                            return "";
                        } else {
                            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                            return sdf.format(curso.getFechaCancelacion());
                        }
                }
                return "";
            }

        });

        Table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (Table.getSelectedRow() == -1) {
                    Cancelar.setEnabled(false);
                } else {
                    Curso curso = cursos.get(Table.getSelectedRow());
                    if (curso.getEstado() == true) {
                        Habilitar.setEnabled(false);
                        Cancelar.setEnabled(curso.getEstado() == true);
                    } else {
                        Cancelar.setEnabled(false);
                        Habilitar.setEnabled(curso.getEstado() == false);
                    }
                }
            }
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        Cancelar = new javax.swing.JButton();
        Habilitar = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Grupo", "Docente", "Estado Curso"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Table);

        Cancelar.setBackground(new java.awt.Color(204, 204, 204));
        Cancelar.setText("Cancelar");

        Habilitar.setBackground(new java.awt.Color(204, 204, 204));
        Habilitar.setText("Habilitar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 740, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Habilitar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Habilitar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cancelar;
    private javax.swing.JButton Habilitar;
    private javax.swing.JTable Table;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    public class Cancelar implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Curso curso = cursos.get(Table.getSelectedRow());
            if (curso.getEstudiantesMatriculados().isEmpty()) {
                try {
                    curso.Cancelar();
                    ((AbstractTableModel) Table.getModel()).fireTableDataChanged();
                    universidad.getPeriodoActual().CancelarCurso(curso);
                    Cancelar.setEnabled(false);
                } catch (Exception ex) {
                    Logger.getLogger(CancelarCurso.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No es Posible cancelar " + curso.getAsignatura().getNombre() + " en el grupo " + curso.getGrupo() + " ya que hay estudiantes matriculados en este curso ", "SIRA", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
    }

    public class Habilitar implements ActionListener {

        @Override

        public void actionPerformed(ActionEvent e) {
            try {
                Curso curso = cursos.get(Table.getSelectedRow());
                curso.Habilitar();
                ((AbstractTableModel) Table.getModel()).fireTableDataChanged();
                universidad.getPeriodoActual().AddCurso(curso);
                Habilitar.setEnabled(false);
            } catch (Exception ex) {
                Logger.getLogger(CancelarCurso.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
