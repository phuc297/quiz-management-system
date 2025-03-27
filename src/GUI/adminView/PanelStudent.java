package GUI.adminView;

import BUS.StudentBUS;
import java.awt.Component;
import java.util.ArrayList;
import DTO.StudentDTO;
import GUI.ScrollBarTable;
import GUI.TableModel.ColumnNames;
import GUI.TableModel.TableModel;
import javax.swing.table.DefaultTableModel;
import GUI.swing.ModelCard;
import java.awt.Color;
import java.util.Collections;
import GUI.swing.MyFileChooser;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class PanelStudent extends javax.swing.JPanel {

    private int selectedRow = -1;
    private ArrayList<StudentDTO> students;
    private StudentBUS studentBUS;
    private boolean openExcel;

    public PanelStudent() {
        initComponents();
        setOpaque(false);
        setBorder(null);
        ScrollBarTable.setScrollBarTable(jScrollPane1);

        studentBUS = new StudentBUS();
        setData();
        setForm(panelMain);

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
        students = studentBUS.getAll();
        DefaultTableModel model = TableModel.getStudent(students);
        table1.setModel(model);
        int maleStudents = studentBUS.getAllMale().size();
        int femaleStudents = studentBUS.getAllFemale().size();
        cardSummary1.setModel(new ModelCard("students-card", "Số học sinh", Integer.toString(students.size()), new Color(255, 204, 153)));
        cardSummary2.setModel(new ModelCard("student-card-male", "Số học sinh nam", Integer.toString(maleStudents), new Color(0, 153, 51)));
        cardSummary3.setModel(new ModelCard("student-card-female", "Số học sinh nữ", Integer.toString(femaleStudents), new Color(255, 80, 80)));
    }

    private void setModelTable(ArrayList<StudentDTO> arr) {
        DefaultTableModel model = TableModel.getStudent(arr);
        table1.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMain = new javax.swing.JPanel();
        cardSummary1 = new GUI.component.CardSummary();
        cardSummary2 = new GUI.component.CardSummary();
        cardSummary3 = new GUI.component.CardSummary();
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
        lbImport = new GUI.component.Svg();
        lbExport = new GUI.component.Svg();

        setOpaque(false);
        setLayout(new java.awt.BorderLayout());

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

        javax.swing.GroupLayout panelTable1Layout = new javax.swing.GroupLayout(panelTable1);
        panelTable1.setLayout(panelTable1Layout);
        panelTable1Layout.setHorizontalGroup(
            panelTable1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTable1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 811, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        panelTable1Layout.setVerticalGroup(
            panelTable1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTable1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
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

        cbxOrder.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ID (Tăng dần)", "ID (Giảm dần)", "Giới tính Nam", "Giới tính Nữ", "Ngày sinh (Tăng dần)", "Ngày sinh (Giảm dần)" }));
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

        cbxSearch.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tất cả", "Mã học sinh", "Họ tên", "Ngày sinh", "Số điện thoại", "Email", "Mã tài khoản" }));
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

        lbImport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbImportMouseClicked(evt);
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
                    .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(panelTable1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(panelMainLayout.createSequentialGroup()
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
                    .addGroup(panelMainLayout.createSequentialGroup()
                        .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(searchBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(cardSummary1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelMainLayout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(cardSummary2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(cardSummary3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMainLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbxOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(249, Short.MAX_VALUE))
        );
        panelMainLayout.setVerticalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cardSummary3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cardSummary2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cardSummary1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbxOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbxSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(panelTable1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lbEdit, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                        .addComponent(lbAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                        .addComponent(lbRemove, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                    .addComponent(lbExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbImport, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbExport, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(113, Short.MAX_VALUE))
        );

        add(panelMain, java.awt.BorderLayout.CENTER);
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
        PanelAddStudent panelAddStudent = new PanelAddStudent();
        panelAddStudent.addEvent(() -> {
            setData();
            setForm(panelMain);
        });
        setForm(panelAddStudent);
    }//GEN-LAST:event_lbAddMouseClicked

    private void lbRemoveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbRemoveMouseClicked
        if (lbRemove.isEnabled()) {
            int confirm = JOptionPane.showConfirmDialog(null, "Bạn xác nhận xóa học sinh này?");
            if (confirm == JOptionPane.YES_OPTION) {
                int selected = table1.getSelectedRow();
                int id = (int) table1.getModel().getValueAt(selected, 0);
                if (studentBUS.remove(id)) {
                    JOptionPane.showMessageDialog(null, "Đã xóa");
                }
                setData();
            }
        }
    }//GEN-LAST:event_lbRemoveMouseClicked

    private void lbEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbEditMouseClicked
        if (lbEdit.isEnabled()) {
            int selected = table1.getSelectedRow();
            int id = (int) table1.getModel().getValueAt(selected, 0);
            setData();
        }
    }//GEN-LAST:event_lbEditMouseClicked

    private void cbxOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxOrderActionPerformed
        if (cbxOrder.getSelectedIndex() == 0) {
            Collections.sort(students, (StudentDTO s1, StudentDTO s2) -> {
                if (s1.getStudentId() < s2.getStudentId()) {
                    return -1;
                } else if (s1.getStudentId() > s2.getStudentId()) {
                    return 1;
                }
                return 0;
            });
            setModelTable(students);
        }
        if (cbxOrder.getSelectedIndex() == 1) {
            Collections.sort(students, (StudentDTO s1, StudentDTO s2) -> {
                if (s1.getStudentId() > s2.getStudentId()) {
                    return -1;
                } else if (s1.getStudentId() < s2.getStudentId()) {
                    return 1;
                }
                return 0;
            });
            setModelTable(students);
        }
        if (cbxOrder.getSelectedIndex() == 2) {
            ArrayList<StudentDTO> maleStudents = studentBUS.getAllMale();
            setModelTable(maleStudents);
        }
        if (cbxOrder.getSelectedIndex() == 3) {
            ArrayList<StudentDTO> femaleStudents = studentBUS.getAllFemale();
            setModelTable(femaleStudents);
        }
        if (cbxOrder.getSelectedIndex() == 4) {
            ArrayList<StudentDTO> bdStudents = studentBUS.getAllBirthdayAsc();
            setModelTable(bdStudents);
        }
        if (cbxOrder.getSelectedIndex() == 5) {
            ArrayList<StudentDTO> bdStudents = studentBUS.getAllBirthdayDesc();
            setModelTable(bdStudents);
        }
    }//GEN-LAST:event_cbxOrderActionPerformed

    private void searchBar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBar1MouseClicked
        int selected = cbxSearch.getSelectedIndex();
        String txt = searchBar1.getText();
        if (selected == 0) {
            setModelTable(studentBUS.find(txt));
            return;
        }
        if (selected == 1) {
            setModelTable(studentBUS.findById(txt));
            return;
        }
        if (selected == 2) {
            setModelTable(studentBUS.findByName(txt));
            return;
        }
        if (selected == 3) {
            setModelTable(studentBUS.findByBirthday(txt));
            return;
        }
        if (selected == 4) {
            setModelTable(studentBUS.findByPhone(txt));
            return;
        }
        if (selected == 5) {
            setModelTable(studentBUS.findByEmail(txt));
            return;
        }
        if (selected == 6) {
            setModelTable(studentBUS.findByAccountId(txt));
        }
    }//GEN-LAST:event_searchBar1MouseClicked

    private void cbxSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxSearchActionPerformed
        int selected = cbxSearch.getSelectedIndex();
        String txt = searchBar1.getText();
        if (selected == 0) {
            setModelTable(studentBUS.find(txt));
            return;
        }
        if (selected == 1) {
            setModelTable(studentBUS.findById(txt));
            return;
        }
        if (selected == 2) {
            setModelTable(studentBUS.findByName(txt));
            return;
        }
        if (selected == 3) {
            setModelTable(studentBUS.findByBirthday(txt));
            return;
        }
        if (selected == 4) {
            setModelTable(studentBUS.findByPhone(txt));
            return;
        }
        if (selected == 5) {
            setModelTable(studentBUS.findByEmail(txt));
            return;
        }
        if (selected == 6) {
            setModelTable(studentBUS.findByAccountId(txt));
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
            for (StudentDTO student : students) {
                objects.add((Object) student);
            }

            MyFileChooser fileChooser = new MyFileChooser();
            int result = fileChooser.showSaveDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try {
                    studentBUS.writeExcel(ColumnNames.getStudent(), objects, file.getPath() + ".xlsx", "Danh sách học sinh");
                    JOptionPane.showMessageDialog(null, "Xuất dữ liệu ra file Excel thành công");
                } catch (IOException ex) {
                    Logger.getLogger(PanelStudent.class.getName()).log(Level.SEVERE, null, ex);
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
                    ArrayList<Object> data = studentBUS.readExcel(file.getPath());
                    ArrayList<StudentDTO> importStudents = new ArrayList<StudentDTO>();
                    for (Object object : data) {
                        StudentDTO s = (StudentDTO) object;
                        if (true) {
                            importStudents.add(s);
                        } else {
                            JOptionPane.showMessageDialog(null, "Không thể nhập dữ liệu, Hãy kiểm tra lại dữ liệu trong file");
                            return;
                        }
                    }

                    for (StudentDTO i : importStudents) {
                        studentBUS.insert(i);
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.component.CardSummary cardSummary1;
    private GUI.component.CardSummary cardSummary2;
    private GUI.component.CardSummary cardSummary3;
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
