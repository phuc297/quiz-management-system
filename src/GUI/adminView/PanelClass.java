package GUI.adminView;

import BUS.ClassBUS;
import DTO.ClassDTO;
import java.awt.BorderLayout;
import java.awt.Component;
import GUI.ScrollBarTable;
import GUI.TableModel.TableModel;
import javax.swing.table.DefaultTableModel;
import GUI.swing.ModelCard;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;

public class PanelClass extends javax.swing.JPanel {

    private int selectedRow = -1;
    private ArrayList<ClassDTO> classes;
    private ClassBUS classBUS;
    private boolean openExcel;

    public PanelClass() {
        initComponents();

        classBUS = new ClassBUS();

        setLayout(new BorderLayout());
        ScrollBarTable.setScrollBarTable(jScrollPane1);
        setData();
        setForm(panelMain);

        lbAdd.setSvgImage("add", 32, 32);
        lbRemove.setSvgImage("remove", 32, 32);
        lbEdit.setSvgImage("edit", 32, 32);
        lbExcel.setSvgImage("excel", 32, 32);
        lbRemove.setEnabled(false);
        lbEdit.setEnabled(false);

        lbExport.setSvgImage("export", 32, 32);
        openExcel = false;
        lbExport.setVisible(openExcel);
    }

    private void setForm(Component com) {
        this.removeAll();
        this.add(com);
        this.repaint();
        this.revalidate();
    }

    private void setData() {
        classes = classBUS.getAll();
        DefaultTableModel model = TableModel.getClass(classes);
        table1.setModel(model);
        cardSummary1.setModel(new ModelCard("class-card", "Số lớp học", Integer.toString(classes.size()), Color.decode("#f2a6a6")));
    }

    private void setModelTable(ArrayList<ClassDTO> arr) {
        DefaultTableModel model = TableModel.getClass(arr);
        table1.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMain = new javax.swing.JPanel();
        cardSummary1 = new GUI.component.CardSummary();
        panelTable1 = new GUI.component.PanelRoundRect();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new GUI.component.Table();
        lbAdd = new GUI.component.Svg();
        lbRemove = new GUI.component.Svg();
        lbEdit = new GUI.component.Svg();
        cbxOrder = new GUI.component.Combobox();
        jLabel1 = new javax.swing.JLabel();
        searchBar1 = new GUI.component.SearchBar();
        cbxSearch = new GUI.component.Combobox();
        lbExcel = new GUI.component.Svg();
        lbExport = new GUI.component.Svg();

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
        table1.setPreferredScrollableViewportSize(new java.awt.Dimension(818, 402));
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table1);

        javax.swing.GroupLayout panelTable1Layout = new javax.swing.GroupLayout(panelTable1);
        panelTable1.setLayout(panelTable1Layout);
        panelTable1Layout.setHorizontalGroup(
            panelTable1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTable1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        panelTable1Layout.setVerticalGroup(
            panelTable1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTable1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
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

        lbEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbEditMouseClicked(evt);
            }
        });

        cbxOrder.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ID (Tăng dần)", "ID (Giảm dần)" }));
        cbxOrder.setPreferredSize(new java.awt.Dimension(215, 35));
        cbxOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxOrderActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Order By");
        jLabel1.setToolTipText("");

        searchBar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchBar1MouseClicked(evt);
            }
        });

        cbxSearch.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mã lớp", "Tên lớp", "Giáo viên", "Môn học", "Số lượng học sinh" }));
        cbxSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxSearchActionPerformed(evt);
            }
        });

        lbExcel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbExcelMouseClicked(evt);
            }
        });

        lbExport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbExportMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
        panelMain.setLayout(panelMainLayout);
        panelMainLayout.setHorizontalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMainLayout.createSequentialGroup()
                            .addComponent(searchBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cbxSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cbxOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(panelTable1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMainLayout.createSequentialGroup()
                            .addComponent(lbExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(lbExport, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(lbRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(lbAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(cardSummary1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(221, Short.MAX_VALUE))
        );
        panelMainLayout.setVerticalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cardSummary1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbxSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbxOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(panelTable1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lbEdit, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                        .addComponent(lbAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                        .addComponent(lbRemove, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                        .addComponent(lbExcel, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                    .addComponent(lbExport, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(85, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked
        selectedRow = table1.getSelectedRow();
        if (selectedRow != -1) {
            lbRemove.setEnabled(true);
            lbEdit.setEnabled(true);
        } else {
            lbRemove.setEnabled(false);
            lbEdit.setEnabled(false);
        }
    }//GEN-LAST:event_table1MouseClicked

    private void lbAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAddMouseClicked
        PanelAddClass panel = new PanelAddClass();
        PanelAddStudentClass panelAdd = new PanelAddStudentClass();
        panelAdd.addCancelEvent(() -> {
            setForm(panel);
        });
        panelAdd.addSubmitEvent(() -> {
            setForm(panelMain);
            setData();
        });
        panel.addEvent(() -> {
            setForm(panelMain);
            if (panel.isInserted()) {
                panelAdd.setClass(panel.classCreated());
                setForm(panelAdd);
            }
        });
        panel.addEventCancel(() -> {
            setForm(panelMain);
        });

        setForm(panel);
    }//GEN-LAST:event_lbAddMouseClicked

    private void lbRemoveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbRemoveMouseClicked
        if (lbRemove.isEnabled()) {
            int selected = table1.getSelectedRow();
            int id = (int) table1.getModel().getValueAt(selected, 0);
            int confirm = JOptionPane.showConfirmDialog(null, "Bạn xác nhận xóa lớp học này?");
            if (confirm == JOptionPane.YES_OPTION) {
                if (classBUS.remove(id)) {
                    JOptionPane.showMessageDialog(null, "Đã xóa thành công");
                    setData();
                } else {
                    JOptionPane.showMessageDialog(null, "Không thể xóa lớp học này");
                }
            }
        }
    }//GEN-LAST:event_lbRemoveMouseClicked

    private void cbxOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxOrderActionPerformed
        if (cbxOrder.getSelectedIndex() == 0) {
            setData();
        }
        if (cbxOrder.getSelectedIndex() == 0) {
            Collections.sort(classes, (ClassDTO s1, ClassDTO s2) -> {
                if (s1.getClassId() < s2.getClassId()) {
                    return -1;
                } else if (s1.getClassId() > s2.getClassId()) {
                    return 1;
                }
                return 0;
            });
            DefaultTableModel model = TableModel.getClass(classes);
            table1.setModel(model);
        }
        if (cbxOrder.getSelectedIndex() == 1) {
            Collections.sort(classes, (ClassDTO s1, ClassDTO s2) -> {
                if (s1.getClassId() > s2.getClassId()) {
                    return -1;
                } else if (s1.getClassId() < s2.getClassId()) {
                    return 1;
                }
                return 0;
            });
            DefaultTableModel model = TableModel.getClass(classes);
            table1.setModel(model);
        }
    }//GEN-LAST:event_cbxOrderActionPerformed

    private void searchBar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBar1MouseClicked
        int selected = cbxSearch.getSelectedIndex();
        String txt = searchBar1.getText();
        if (selected == 0) {
            setModelTable(classBUS.findById(txt));
            return;
        }
        if (selected == 1) {
            setModelTable(classBUS.find(txt));
            return;
        }
        if (selected == 2) {
            setModelTable(classBUS.findByTeacher(txt));
            return;
        }
        if (selected == 3) {
            setModelTable(classBUS.findBySubject(txt));
            return;
        }
        if (selected == 4) {
            setModelTable(classBUS.findByNumberOfStudents(txt));
            return;
        }
    }//GEN-LAST:event_searchBar1MouseClicked

    private void cbxSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxSearchActionPerformed
        int selected = cbxSearch.getSelectedIndex();
        String txt = searchBar1.getText();
        if (selected == 0) {
            setModelTable(classBUS.findById(txt));
            return;
        }
        if (selected == 1) {
            setModelTable(classBUS.find(txt));
            return;
        }
        if (selected == 2) {
            setModelTable(classBUS.findByTeacher(txt));
            return;
        }
        if (selected == 3) {
            setModelTable(classBUS.findBySubject(txt));
            return;
        }
        if (selected == 4) {
            setModelTable(classBUS.findByNumberOfStudents(txt));
            return;
        }
    }//GEN-LAST:event_cbxSearchActionPerformed

    private void lbExcelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbExcelMouseClicked
        openExcel = !openExcel;
        lbExport.setVisible(openExcel);
    }//GEN-LAST:event_lbExcelMouseClicked

    private void lbExportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbExportMouseClicked

    }//GEN-LAST:event_lbExportMouseClicked

    private void lbEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbEditMouseClicked
        int id = (int) table1.getModel().getValueAt(table1.getSelectedRow(), 0);
        ClassDTO classDTO = classBUS.get(id);
        classDTO.setTotalStudents((int) table1.getModel().getValueAt(table1.getSelectedRow(), 4));
        PanelEditClass panel = new PanelEditClass(classDTO);
        panel.addEvent(() -> {
            setForm(panelMain);
            setData();
        });

        setForm(panel);
    }//GEN-LAST:event_lbEditMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.component.CardSummary cardSummary1;
    private GUI.component.Combobox cbxOrder;
    private GUI.component.Combobox cbxSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private GUI.component.Svg lbAdd;
    private GUI.component.Svg lbEdit;
    private GUI.component.Svg lbExcel;
    private GUI.component.Svg lbExport;
    private GUI.component.Svg lbRemove;
    private javax.swing.JPanel panelMain;
    private GUI.component.PanelRoundRect panelTable1;
    private GUI.component.SearchBar searchBar1;
    private GUI.component.Table table1;
    // End of variables declaration//GEN-END:variables
}
