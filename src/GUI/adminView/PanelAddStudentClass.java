package GUI.adminView;

import BUS.ClassBUS;
import BUS.StudentBUS;
import DTO.ClassDTO;
import DTO.StudentDTO;
import GUI.ScrollBarTable;
import GUI.events.MyEventListener;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class PanelAddStudentClass extends javax.swing.JPanel {

    private MyEventListener eventSubmit;
    private MyEventListener eventCancel;

    public void addSubmitEvent(MyEventListener event) {
        this.eventSubmit = event;
    }

    public void addCancelEvent(MyEventListener event) {
        this.eventCancel = event;
    }

    private StudentBUS studentBUS;
    private ClassBUS classBUS;
    private ClassDTO classDTO;
    private ArrayList<StudentDTO> allStudents;
    private ArrayList<Integer> classStudents;
    private DefaultTableModel model1;
    private DefaultTableModel model2;

    public PanelAddStudentClass() {
        initComponents();
        ScrollBarTable.setScrollBarTable(jScrollPane1);
        ScrollBarTable.setScrollBarTable(jScrollPane2);
        studentBUS = new StudentBUS();
        classBUS = new ClassBUS();
        allStudents = studentBUS.getAll();
        classStudents = new ArrayList<Integer>();

        table1.setMultiSelect(true);
        table2.setMultiSelect(true);

        setData();

        lbAdd.setSvgImage("right0", 32, 32);
        lbRemove.setSvgImage("left", 32, 32);
    }

    public void setClass(ClassDTO classDTO) {
        this.classDTO = classDTO;
    }

    private void setData() {
        Vector<String> columnNames = new Vector<String>();
        columnNames.add("Mã học sinh");
        columnNames.add("Họ");
        columnNames.add("Tên");

        model1 = new DefaultTableModel(columnNames, 0);
        model2 = new DefaultTableModel(columnNames, 0);

        for (StudentDTO i : allStudents) {
            Object rowData[] = {
                i.getStudentId(),
                i.getFirstName(),
                i.getLastName()
            };
            model1.addRow(rowData);
        }
        table1.setModel(model1);
        table2.setModel(model2);

        ListSelectionModel selectionModel = table1.getSelectionModel();
        selectionModel.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        selectionModel = table2.getSelectionModel();
        selectionModel.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnSubmit = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        panelRoundRect1 = new GUI.component.PanelRoundRect();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new GUI.component.Table();
        panelRoundRect2 = new GUI.component.PanelRoundRect();
        jScrollPane2 = new javax.swing.JScrollPane();
        table2 = new GUI.component.Table();
        lbAdd = new GUI.component.Svg();
        lbRemove = new GUI.component.Svg();
        searchBar1 = new GUI.component.SearchBar();

        jLabel1.setBackground(new java.awt.Color(0, 204, 204));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("       Add students to class");
        jLabel1.setOpaque(true);

        btnCancel.setBackground(new java.awt.Color(255, 128, 139));
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/left.png"))); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.setBorder(null);
        btnCancel.setFocusPainted(false);
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnReset.setBackground(new java.awt.Color(255, 176, 114));
        btnReset.setForeground(new java.awt.Color(255, 255, 255));
        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/undo.png"))); // NOI18N
        btnReset.setText("Reset");
        btnReset.setBorder(null);
        btnReset.setFocusPainted(false);
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnSubmit.setBackground(new java.awt.Color(8, 169, 74));
        btnSubmit.setForeground(new java.awt.Color(255, 255, 255));
        btnSubmit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/check.png"))); // NOI18N
        btnSubmit.setText("Submit");
        btnSubmit.setBorder(null);
        btnSubmit.setFocusPainted(false);
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        jPanel1.setMaximumSize(new java.awt.Dimension(1080, 32767));
        jPanel1.setMinimumSize(new java.awt.Dimension(1080, 470));

        table1.setModel(new javax.swing.table.DefaultTableModel(
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
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table1);

        javax.swing.GroupLayout panelRoundRect1Layout = new javax.swing.GroupLayout(panelRoundRect1);
        panelRoundRect1.setLayout(panelRoundRect1Layout);
        panelRoundRect1Layout.setHorizontalGroup(
            panelRoundRect1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundRect1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        panelRoundRect1Layout.setVerticalGroup(
            panelRoundRect1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundRect1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        table2.setModel(new javax.swing.table.DefaultTableModel(
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
        table2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table2);

        javax.swing.GroupLayout panelRoundRect2Layout = new javax.swing.GroupLayout(panelRoundRect2);
        panelRoundRect2.setLayout(panelRoundRect2Layout);
        panelRoundRect2Layout.setHorizontalGroup(
            panelRoundRect2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundRect2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        panelRoundRect2Layout.setVerticalGroup(
            panelRoundRect2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundRect2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        lbAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbAddMouseClicked(evt);
            }
        });

        lbRemove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbRemoveMouseClicked(evt);
            }
        });

        searchBar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchBar1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(searchBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(panelRoundRect1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                            .addComponent(lbRemove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelRoundRect2, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(searchBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRoundRect2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelRoundRect1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(lbAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(lbRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(270, Short.MAX_VALUE)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 270, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        eventCancel.actionPerformed();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed

    }//GEN-LAST:event_btnResetActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        classStudents.removeAll(classStudents);
        DefaultTableModel model = (DefaultTableModel) table2.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            int id = (int) model.getValueAt(i, 0);
            classStudents.add(id);
        }
        int confirm = JOptionPane.showConfirmDialog(null, "Bạn có xác nhận thêm " + classStudents.size() + " học sinh này vào lớp học " + classDTO.getClassName());
        if (confirm == JOptionPane.YES_OPTION) {
            for (int id : classStudents) {
                classBUS.insertStudent(id, classDTO.getClassId());
            }
            eventSubmit.actionPerformed();
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked
        table2.clearSelection();
        lbRemove.setEnabled(false);
        lbAdd.setEnabled(true);
    }//GEN-LAST:event_table1MouseClicked

    private void table2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table2MouseClicked
        table1.clearSelection();
        lbRemove.setEnabled(true);
        lbAdd.setEnabled(false);
    }//GEN-LAST:event_table2MouseClicked

    private void lbAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAddMouseClicked
        if (lbAdd.isEnabled()) {
            int[] selected = table1.getSelectedRows();
            int[] id = new int[selected.length];
            for (int i = 0; i < selected.length; i++) {
                int idStudent = (int) table1.getModel().getValueAt(selected[i], 0);
                id[i] = idStudent;
                String fName = table1.getModel().getValueAt(selected[i], 1).toString();
                String lName = table1.getModel().getValueAt(selected[i], 2).toString();
                StudentDTO s = new StudentDTO();
                s.setStudentId(idStudent);
                s.setFirstName(fName);
                s.setLastName(lName);
                Object rowData[] = {
                    s.getStudentId(),
                    s.getFirstName(),
                    s.getLastName()};
                model2.addRow(rowData);
            }

            for (int i = 0; i < id.length; i++) {
                model1.removeRow(selected[i] - i);
            }
            table1.clearSelection();
        }
    }//GEN-LAST:event_lbAddMouseClicked

    private void lbRemoveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbRemoveMouseClicked
        if (lbRemove.isEnabled()) {
            int[] selected = table2.getSelectedRows();
            for (int i = 0; i < selected.length; i++) {
                int id = (int) table2.getModel().getValueAt(selected[i], 0);
                String fName = table2.getModel().getValueAt(selected[i], 1).toString();
                String lName = table2.getModel().getValueAt(selected[i], 2).toString();
                StudentDTO s = new StudentDTO();
                s.setStudentId(id);
                s.setFirstName(fName);
                s.setLastName(lName);
                Object rowData[] = {
                    s.getStudentId(),
                    s.getFirstName(),
                    s.getLastName()};
                model1.addRow(rowData);
            }
            for (int i = 0; i < selected.length; i++) {
                model2.removeRow(selected[i] - i);
            }
            table2.clearSelection();
        }
    }//GEN-LAST:event_lbRemoveMouseClicked

    private void searchBar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBar1MouseClicked
        String txt = searchBar1.getText();
        ArrayList<StudentDTO> students = studentBUS.findByNameAndId(txt);

        Vector<String> columnNames = new Vector<String>();
        columnNames.add("Mã học sinh");
        columnNames.add("Họ");
        columnNames.add("Tên");

        model1 = new DefaultTableModel(columnNames, 0);
        for (StudentDTO i : students) {
            Object rowData[] = {
                i.getStudentId(),
                i.getFirstName(),
                i.getLastName()
            };
            model1.addRow(rowData);
        }
        table1.setModel(model1);
    }//GEN-LAST:event_searchBar1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private GUI.component.Svg lbAdd;
    private GUI.component.Svg lbRemove;
    private GUI.component.PanelRoundRect panelRoundRect1;
    private GUI.component.PanelRoundRect panelRoundRect2;
    private GUI.component.SearchBar searchBar1;
    private GUI.component.Table table1;
    private GUI.component.Table table2;
    // End of variables declaration//GEN-END:variables
}
