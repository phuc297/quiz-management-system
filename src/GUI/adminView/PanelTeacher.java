package GUI.adminView;

import BUS.TeacherBUS;
import DTO.TeacherDTO;
import java.awt.Color;
import java.awt.Component;
import GUI.swing.ModelCard;
import GUI.ScrollBarTable;
import GUI.TableModel.ColumnNames;
import GUI.TableModel.TableModel;
import java.awt.BorderLayout;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Collections;
import GUI.swing.MyFileChooser;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class PanelTeacher extends javax.swing.JPanel {

    private int selectedRow = -1;
    private ArrayList<TeacherDTO> teachers;
    private TeacherBUS teacherBUS;
    private boolean openExcel;

    public PanelTeacher() {
        initComponents();

        teacherBUS = new TeacherBUS();

        setLayout(new BorderLayout());
        ScrollBarTable.setScrollBarTable(jScrollPane1);
        setForm(panelMain);
        setData();

        lbAdd.setSvgImage("add", 32, 32);
        lbRemove.setSvgImage("remove", 32, 32);
        lbEdit.setSvgImage("edit", 32, 32);
        lbExcel.setSvgImage("excel", 32, 32);
        lbRemove.setEnabled(false);
        lbEdit.setEnabled(false);

        lbImport.setSvgImage("import", 32, 32);
        lbExport.setSvgImage("export", 32, 32);
        openExcel = false;
        lbImport.setVisible(openExcel);
        lbExport.setVisible(openExcel);
    }

    private void setForm(Component com) {
        this.removeAll();
        this.add(com);
        this.repaint();
        this.revalidate();
    }

    private void setData() {
        teachers = teacherBUS.getAll();
        DefaultTableModel model = TableModel.getTeacher(teachers);
        table1.setModel(model);
        card1.setModel(new ModelCard("teacher-card", "Số giáo viên", Integer.toString(teachers.size()), Color.decode("#5e87b8")));
    }

    private void setModelTable(ArrayList<TeacherDTO> arr) {
        DefaultTableModel model = TableModel.getTeacher(arr);
        table1.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMain = new javax.swing.JPanel();
        card1 = new GUI.component.CardSummary();
        panelTable1 = new GUI.component.PanelRoundRect();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new GUI.component.Table();
        lbAdd = new GUI.component.Svg();
        lbRemove = new GUI.component.Svg();
        lbEdit = new GUI.component.Svg();
        jLabel1 = new javax.swing.JLabel();
        cbxOrder = new GUI.component.Combobox();
        searchBar1 = new GUI.component.SearchBar();
        cbxSearch = new GUI.component.Combobox();
        lbExcel = new GUI.component.Svg();
        lbExport = new GUI.component.Svg();
        lbImport = new GUI.component.Svg();

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
        table1.setPreferredScrollableViewportSize(new java.awt.Dimension(818, 406));
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTable1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        panelTable1Layout.setVerticalGroup(
            panelTable1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTable1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        lbEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbEditMouseClicked(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Order By");
        jLabel1.setToolTipText("");

        cbxOrder.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ID (Tăng dần)", "ID (Giảm dần)", "Giới tính Nam", "Giới tính Nữ", "Ngày sinh (Tăng dần)", "Ngày sinh (Giảm dần)" }));
        cbxOrder.setPreferredSize(new java.awt.Dimension(215, 35));
        cbxOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxOrderActionPerformed(evt);
            }
        });

        searchBar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchBar1MouseClicked(evt);
            }
        });

        cbxSearch.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tất cả", "Mã giáo viên", "Họ tên", "Ngày sinh", "Số điện thoại", "Email", "Mã tài khoản" }));
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

        lbImport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbImportMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
        panelMain.setLayout(panelMainLayout);
        panelMainLayout.setHorizontalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelMainLayout.createSequentialGroup()
                        .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(card1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(searchBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelTable1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMainLayout.createSequentialGroup()
                        .addComponent(lbExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(lbImport, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(lbExport, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(lbRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(lbAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(145, 146, Short.MAX_VALUE))
        );
        panelMainLayout.setVerticalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(card1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(lbEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbExport, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbImport, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(164, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 237, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbxOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxOrderActionPerformed
        if (cbxOrder.getSelectedIndex() == 0) {
            Collections.sort(teachers, (TeacherDTO s1, TeacherDTO s2) -> {
                if (s1.getTeacherId() < s2.getTeacherId()) {
                    return -1;
                } else if (s1.getTeacherId() > s2.getTeacherId()) {
                    return 1;
                }
                return 0;
            });
            setModelTable(teachers);
        }
        if (cbxOrder.getSelectedIndex() == 1) {
            Collections.sort(teachers, (TeacherDTO s1, TeacherDTO s2) -> {
                if (s1.getTeacherId() > s2.getTeacherId()) {
                    return -1;
                } else if (s1.getTeacherId() < s2.getTeacherId()) {
                    return 1;
                }
                return 0;
            });
            setModelTable(teachers);
        }
        if (cbxOrder.getSelectedIndex() == 2) {
            ArrayList<TeacherDTO> maleTeachers = teacherBUS.getAllMale();
            setModelTable(maleTeachers);
        }
        if (cbxOrder.getSelectedIndex() == 3) {
            ArrayList<TeacherDTO> femaleTeachers = teacherBUS.getAllFemale();
            setModelTable(femaleTeachers);
        }
        if (cbxOrder.getSelectedIndex() == 4) {
            ArrayList<TeacherDTO> bdTeachers = teacherBUS.getAllBirthdayAsc();
            setModelTable(bdTeachers);
        }
        if (cbxOrder.getSelectedIndex() == 5) {
            ArrayList<TeacherDTO> bdTeachers = teacherBUS.getAllBirthdayDesc();
            setModelTable(bdTeachers);
        }
    }//GEN-LAST:event_cbxOrderActionPerformed

    private void lbRemoveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbRemoveMouseClicked
        if (lbRemove.isEnabled()) {
            int confirm = JOptionPane.showConfirmDialog(null, "Bạn xác nhận xóa giáo viên này?");
            if (confirm == JOptionPane.YES_OPTION) {
                int selected = table1.getSelectedRow();
                int id = (int) table1.getModel().getValueAt(selected, 0);
                if (teacherBUS.remove(id)) {
                    JOptionPane.showMessageDialog(null, "Đã xóa");
                }
                setData();
            }
        }
    }//GEN-LAST:event_lbRemoveMouseClicked

    private void lbAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAddMouseClicked
        PanelAddTeacher panel = new PanelAddTeacher();
        panel.addEvent(() -> {
            setForm(panelMain);
            setData();
        });
        setForm(panel);
    }//GEN-LAST:event_lbAddMouseClicked

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

    private void searchBar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBar1MouseClicked
        int selected = cbxSearch.getSelectedIndex();
        String txt = searchBar1.getText();
        if (selected == 0) {
            setModelTable(teacherBUS.find(txt));
            return;
        }
        if (selected == 1) {
            setModelTable(teacherBUS.findById(txt));
            return;
        }
        if (selected == 2) {
            setModelTable(teacherBUS.findByName(txt));
            return;
        }
        if (selected == 3) {
            setModelTable(teacherBUS.findByBirthday(txt));
            return;
        }
        if (selected == 4) {
            setModelTable(teacherBUS.findByPhone(txt));
            return;
        }
        if (selected == 5) {
            setModelTable(teacherBUS.findByEmail(txt));
            return;
        }
        if (selected == 6) {
            setModelTable(teacherBUS.findByAccountId(txt));
        }
    }//GEN-LAST:event_searchBar1MouseClicked

    private void cbxSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxSearchActionPerformed
        int selected = cbxSearch.getSelectedIndex();
        String txt = searchBar1.getText();
        if (selected == 0) {
            setModelTable(teacherBUS.find(txt));
            return;
        }
        if (selected == 1) {
            setModelTable(teacherBUS.findById(txt));
            return;
        }
        if (selected == 2) {
            setModelTable(teacherBUS.findByName(txt));
            return;
        }
        if (selected == 3) {
            setModelTable(teacherBUS.findByBirthday(txt));
            return;
        }
        if (selected == 4) {
            setModelTable(teacherBUS.findByPhone(txt));
            return;
        }
        if (selected == 5) {
            setModelTable(teacherBUS.findByEmail(txt));
            return;
        }
        if (selected == 6) {
            setModelTable(teacherBUS.findByAccountId(txt));
        }
    }//GEN-LAST:event_cbxSearchActionPerformed

    private void lbExcelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbExcelMouseClicked
        openExcel = !openExcel;
        lbImport.setVisible(openExcel);
        lbExport.setVisible(openExcel);
    }//GEN-LAST:event_lbExcelMouseClicked

    private void lbExportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbExportMouseClicked
        if (lbExport.isVisible()) {
            ArrayList<Object> objects = new ArrayList<Object>();
            for (TeacherDTO teacher : teachers) {
                objects.add((Object) teacher);
            }

            MyFileChooser fileChooser = new MyFileChooser();
            int result = fileChooser.showSaveDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try {
                    teacherBUS.writeExcel(ColumnNames.getTeacher(), objects, file.getPath() + ".xlsx", "Danh sách giáo viên");
                } catch (IOException ex) {
                    Logger.getLogger(PanelTeacher.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_lbExportMouseClicked

    private void lbImportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbImportMouseClicked
        if (lbImport.isVisible()) {
            MyFileChooser fileChooser = new MyFileChooser();
            int result = fileChooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try {
                    ArrayList<Object> data = teacherBUS.readExcel(file.getPath());
                    ArrayList<TeacherDTO> importTeachers = new ArrayList<TeacherDTO>();
                    for (Object object : data) {
                        TeacherDTO t = (TeacherDTO) object;
                        if (true) {
                            importTeachers.add(t);
                        } else {
                            JOptionPane.showMessageDialog(null, "Không thể nhập dữ liệu, Hãy kiểm tra lại dữ liệu trong file");
                            return;
                        }
                    }

                    for (TeacherDTO i : importTeachers) {
                        teacherBUS.insert(i);
                    }
                    setData();
                    JOptionPane.showMessageDialog(null, "Đã nhập dữ liệu từ file Excel thành công");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Không thể nhập dữ liệu, Hãy kiểm tra lại dữ liệu trong file");
                    Logger.getLogger(PanelQuestion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_lbImportMouseClicked

    private void lbEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbEditMouseClicked
        TeacherDTO teacher = new TeacherDTO();

        int id = (int) table1.getModel().getValueAt(table1.getSelectedRow(), 0);
        String name = table1.getModel().getValueAt(table1.getSelectedRow(), 1).toString();
        teacher.setFirstName(name);
        name = table1.getModel().getValueAt(table1.getSelectedRow(), 2).toString();
        teacher.setTeacherId(id);
        teacher.setLastName(name);

        PanelTeacherSubject panel = new PanelTeacherSubject(teacher);
        panel.addEvent(() -> {
            setForm(panelMain);
            setData();
        });
        setForm(panel);
    }//GEN-LAST:event_lbEditMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.component.CardSummary card1;
    private GUI.component.Combobox cbxOrder;
    private GUI.component.Combobox cbxSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private GUI.component.Svg lbAdd;
    private GUI.component.Svg lbEdit;
    private GUI.component.Svg lbExcel;
    private GUI.component.Svg lbExport;
    private GUI.component.Svg lbImport;
    private GUI.component.Svg lbRemove;
    private javax.swing.JPanel panelMain;
    private GUI.component.PanelRoundRect panelTable1;
    private GUI.component.SearchBar searchBar1;
    private GUI.component.Table table1;
    // End of variables declaration//GEN-END:variables
}
