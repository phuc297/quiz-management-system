package GUI.adminView;

import BUS.ExamBUS;
import DTO.ExamDTO;
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.table.DefaultTableModel;
import GUI.ScrollBarTable;
import GUI.TableModel.ColumnNames;
import GUI.TableModel.TableModel;
import GUI.swing.ModelCard;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import GUI.swing.MyFileChooser;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class PanelExam extends javax.swing.JPanel {

    private ArrayList<ExamDTO> exams;
    private ExamBUS examBUS;
    private boolean openExcel;

    public PanelExam() {
        initComponents();

        examBUS = new ExamBUS();

        setLayout(new BorderLayout());
        ScrollBarTable.setScrollBarTable(jScrollPane1);
        setData();
        setForm(panelMain);

        lbAdd.setSvgImage("add", 32, 32);
        lbRemove.setSvgImage("remove", 32, 32);
        lbEdit.setSvgImage("edit", 32, 32);
        lbStartExam.setSvgImage("bell", 32, 32);
        lbFinishExam.setSvgImage("lock", 32, 32);
        lbDetail.setSvgImage("detail", 32, 32);
        lbExcel.setSvgImage("excel", 32, 32);
        lbRemove.setEnabled(false);
        lbEdit.setEnabled(false);
        lbStartExam.setEnabled(false);
        lbFinishExam.setEnabled(false);
        lbDetail.setEnabled(false);

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
        this.exams = examBUS.getAll();
        DefaultTableModel model = TableModel.getExam(exams);
        table1.setModel(model);
        cardSummary1.setModel(new ModelCard("exam-card", "Số kì thi", Integer.toString(exams.size()), Color.decode("#00cc66")));
    }

    private void setModelTable(ArrayList<ExamDTO> arr) {
        DefaultTableModel model = TableModel.getExam(arr);
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
        lbStartExam = new GUI.component.Svg();
        cbxOrder = new GUI.component.Combobox();
        jLabel1 = new javax.swing.JLabel();
        searchBar1 = new GUI.component.SearchBar();
        cbxSearch = new GUI.component.Combobox();
        lbExcel = new GUI.component.Svg();
        lbFinishExam = new GUI.component.Svg();
        lbImport = new GUI.component.Svg();
        lbExport = new GUI.component.Svg();
        lbDetail = new GUI.component.Svg();

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
        table1.setPreferredScrollableViewportSize(new java.awt.Dimension(818, 400));
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

        lbStartExam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbStartExamMouseClicked(evt);
            }
        });

        cbxOrder.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ID (Giảm dần)", "ID (Tăng dần)", "Môn học", "Đang chờ xử lý", "Đang diễn ra", "Đã kết thúc", "Số câu hỏi (Tăng dần)", "Số câu hỏi (Giảm dần)", "Thời gian làm bài" }));
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

        cbxSearch.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mã kì thi", "Tên kì thi", "Môn thi", "Thời gian làm bài", "Số câu hỏi" }));
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

        lbFinishExam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbFinishExamMouseClicked(evt);
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

        lbDetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbDetailMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
        panelMain.setLayout(panelMainLayout);
        panelMainLayout.setHorizontalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cardSummary1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelMainLayout.createSequentialGroup()
                            .addComponent(searchBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cbxSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cbxOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(panelTable1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(panelMainLayout.createSequentialGroup()
                            .addComponent(lbExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(lbImport, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(lbExport, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(lbFinishExam, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(lbStartExam, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lbEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(lbRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(lbAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(5, 54, Short.MAX_VALUE))
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
                        .addComponent(lbEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbRemove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbStartExam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbExcel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbFinishExam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbExport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbImport, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lbDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(75, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(150, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked
        int selectedRow = table1.getSelectedRow();
        if (selectedRow != -1) {
            lbRemove.setEnabled(true);
            lbEdit.setEnabled(true);
            lbDetail.setEnabled(false);
            int selected = table1.getSelectedRow();
            String status = table1.getModel().getValueAt(selected, 3).toString();
            if (status.equals("pending")) {
                lbStartExam.setEnabled(true);
                lbFinishExam.setEnabled(false);
            }
            if (status.equals("in progress")) {
                lbStartExam.setEnabled(false);
                lbFinishExam.setEnabled(true);
                lbEdit.setEnabled(false);
                lbDetail.setEnabled(true);
            }
            if (status.equals("finished")) {
                lbEdit.setEnabled(false);
                lbDetail.setEnabled(false);
                lbStartExam.setEnabled(false);
                lbFinishExam.setEnabled(false);
                lbDetail.setEnabled(true);
            }
        } else {
            lbRemove.setEnabled(false);
            lbEdit.setEnabled(false);
            lbStartExam.setEnabled(false);
            lbDetail.setEnabled(false);
        }
    }//GEN-LAST:event_table1MouseClicked

    private void lbAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAddMouseClicked
        PanelAddExam panel = new PanelAddExam();
        panel.addEvent(() -> {
            setData();
            setForm(panelMain);
        });
        setForm(panel);
    }//GEN-LAST:event_lbAddMouseClicked

    private void lbRemoveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbRemoveMouseClicked
        if (lbRemove.isEnabled()) {
            int confirm = JOptionPane.showConfirmDialog(null, "Bạn xác nhận xóa kì thi này?");
            if (confirm == JOptionPane.YES_OPTION) {
                int selected = table1.getSelectedRow();
                int id = (int) table1.getModel().getValueAt(selected, 0);
                String status = table1.getModel().getValueAt(selected, 3).toString();
                if (status.equals("in progress")) {
                    JOptionPane.showMessageDialog(null, "Không thể xóa bài thi đang diễn ra");
                }
                if (status.equals("finished")) {
                    confirm = JOptionPane.showConfirmDialog(null, "Xóa kì thi này thì mọi thông tin về kết quả bài thi đều sẽ bị hủy bỏ, Bạn có chắc chắn muốn xóa không?");
                    if (confirm == JOptionPane.YES_OPTION) {
                        if (examBUS.remove(id)) {
                            JOptionPane.showMessageDialog(null, "Đã xóa");
                            setData();
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_lbRemoveMouseClicked

    private void lbStartExamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbStartExamMouseClicked
        if (lbStartExam.isEnabled()) {
            int confirm = JOptionPane.showConfirmDialog(null, "Bạn muốn bắt đàu kì thi này?");
            if (confirm == JOptionPane.YES_OPTION) {
                int selected = table1.getSelectedRow();
                int id = (int) table1.getModel().getValueAt(selected, 0);
                if (examBUS.startExam(id)) {
                    JOptionPane.showMessageDialog(null, "Đã bắt đầu");
                    setData();
                } else {
                    JOptionPane.showMessageDialog(null, "Không thể bắt đầu");
                }
            }
        }
    }//GEN-LAST:event_lbStartExamMouseClicked

    private void cbxOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxOrderActionPerformed
        if (cbxOrder.getSelectedIndex() == 0) {
            Collections.sort(exams, (ExamDTO s1, ExamDTO s2) -> {
                if (s1.getExamId() > s2.getExamId()) {
                    return -1;
                } else if (s1.getExamId() < s2.getExamId()) {
                    return 1;
                }
                return 0;
            });
            DefaultTableModel model = TableModel.getExam(exams);
            table1.setModel(model);

        }
        if (cbxOrder.getSelectedIndex() == 1) {
            Collections.sort(exams, (ExamDTO s1, ExamDTO s2) -> {
                if (s1.getExamId() < s2.getExamId()) {
                    return -1;
                } else if (s1.getExamId() > s2.getExamId()) {
                    return 1;
                }
                return 0;
            });
            DefaultTableModel model = TableModel.getExam(exams);
            table1.setModel(model);
        }
        if (cbxOrder.getSelectedIndex() == 2) {
            ArrayList<ExamDTO> examsOrder = examBUS.getAllOrderBySubject();
            DefaultTableModel model = TableModel.getExam(examsOrder);
            table1.setModel(model);
        }
        if (cbxOrder.getSelectedIndex() == 3) {
            ArrayList<ExamDTO> examsOrder = examBUS.getAllPending();
            DefaultTableModel model = TableModel.getExam(examsOrder);
            table1.setModel(model);
        }
        if (cbxOrder.getSelectedIndex() == 4) {
            ArrayList<ExamDTO> examsOrder = examBUS.getAllInProgress();
            DefaultTableModel model = TableModel.getExam(examsOrder);
            table1.setModel(model);
        }
        if (cbxOrder.getSelectedIndex() == 5) {
            ArrayList<ExamDTO> examsOrder = examBUS.getAllFinished();
            DefaultTableModel model = TableModel.getExam(examsOrder);
            table1.setModel(model);
        }
        if (cbxOrder.getSelectedIndex() == 6) {
            Collections.sort(exams, (ExamDTO s1, ExamDTO s2) -> {
                if (s1.getTotalQuestion() < s2.getTotalQuestion()) {
                    return -1;
                } else if (s1.getTotalQuestion() > s2.getTotalQuestion()) {
                    return 1;
                }
                return 0;
            });
            DefaultTableModel model = TableModel.getExam(exams);
            table1.setModel(model);
        }
        if (cbxOrder.getSelectedIndex() == 7) {
            Collections.sort(exams, (ExamDTO s1, ExamDTO s2) -> {
                if (s1.getTotalQuestion() > s2.getTotalQuestion()) {
                    return -1;
                } else if (s1.getTotalQuestion() < s2.getTotalQuestion()) {
                    return 1;
                }
                return 0;
            });
            DefaultTableModel model = TableModel.getExam(exams);
            table1.setModel(model);
        }
    }//GEN-LAST:event_cbxOrderActionPerformed

    private void cbxSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxSearchActionPerformed
        int selected = cbxSearch.getSelectedIndex();
        String txt = searchBar1.getText();
        if (selected == 0) {
            setModelTable(examBUS.findById(txt));
            return;
        }
        if (selected == 1) {
            setModelTable(examBUS.find(txt));
            return;
        }
        if (selected == 2) {
            setModelTable(examBUS.findBySubject(exams, txt));
            return;
        }
        if (selected == 3) {
            setModelTable(examBUS.findByTime(exams, txt));
            return;
        }
        if (selected == 4) {
            setModelTable(examBUS.findByNumberQuestions(exams, txt));
        }
    }//GEN-LAST:event_cbxSearchActionPerformed

    private void searchBar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBar1MouseClicked
        int selected = cbxSearch.getSelectedIndex();
        String txt = searchBar1.getText();
        if (selected == 0) {
            setModelTable(examBUS.findById(txt));
            return;
        }
        if (selected == 1) {
            setModelTable(examBUS.find(txt));
            return;
        }
        if (selected == 2) {
            setModelTable(examBUS.findBySubject(exams, txt));
            return;
        }
        if (selected == 3) {
            setModelTable(examBUS.findByTime(exams, txt));
            return;
        }
        if (selected == 4) {
            setModelTable(examBUS.findByNumberQuestions(exams, txt));
        }
    }//GEN-LAST:event_searchBar1MouseClicked

    private void lbExcelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbExcelMouseClicked
        openExcel = !openExcel;
        lbImport.setVisible(openExcel);
        lbExport.setVisible(openExcel);
    }//GEN-LAST:event_lbExcelMouseClicked

    private void lbEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbEditMouseClicked
        if (lbEdit.isEnabled()) {

        }
    }//GEN-LAST:event_lbEditMouseClicked

    private void lbFinishExamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbFinishExamMouseClicked
        if (lbFinishExam.isEnabled()) {
            int confirm = JOptionPane.showConfirmDialog(null, "Bạn muốn đóng kì thi này?");
            if (confirm == JOptionPane.YES_OPTION) {
                int selected = table1.getSelectedRow();
                int id = (int) table1.getModel().getValueAt(selected, 0);
                if (examBUS.finishExam(id)) {
                    JOptionPane.showMessageDialog(null, "Đã kết thúc");
                    setData();
                }
            }
        }
    }//GEN-LAST:event_lbFinishExamMouseClicked

    private void lbImportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbImportMouseClicked
        if (lbImport.isVisible()) {
            DefaultTableModel model = (DefaultTableModel) table1.getModel();
            ArrayList<ExamDTO> importExam = new ArrayList<ExamDTO>();

            MyFileChooser fileChooser = new MyFileChooser();
            int result = fileChooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try {
                    ArrayList<Object> data = examBUS.readExcel(file.getPath());

                    for (Object object : data) {
                        importExam.add((ExamDTO) object);
                    }
                    for (ExamDTO i : importExam) {
                        Object rowData[] = {
                            i.getExamId(),
                            i.getExamName(),
                            i.getSubjectName(),
                            i.getStatus(),
                            i.getDuration(),
                            i.getTotalQuestion(),
                            i.getStartTime()
                        };
                        model.addRow(rowData);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(PanelQuestion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_lbImportMouseClicked

    private void lbExportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbExportMouseClicked
        if (lbExport.isVisible()) {
            ArrayList<Object> objects = new ArrayList<Object>();
            for (ExamDTO exam : exams) {
                objects.add((Object) exam);
            }

            MyFileChooser fileChooser = new MyFileChooser();
            int result = fileChooser.showSaveDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try {
                    examBUS.writeExcel(ColumnNames.getExam(), objects, file.getPath() + ".xlsx", "Danh sách kì thi");
                } catch (IOException ex) {
                    Logger.getLogger(PanelQuestion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_lbExportMouseClicked

    private void lbDetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbDetailMouseClicked
        int id = (int) table1.getModel().getValueAt(table1.getSelectedRow(), 0);
        if (id != -1) {
            PanelExamDetail panel = new PanelExamDetail(id);
            panel.addEvent(() -> {
                setForm(panelMain);
            });
            setForm(panel);
        }
    }//GEN-LAST:event_lbDetailMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.component.CardSummary cardSummary1;
    private GUI.component.Combobox cbxOrder;
    private GUI.component.Combobox cbxSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private GUI.component.Svg lbAdd;
    private GUI.component.Svg lbDetail;
    private GUI.component.Svg lbEdit;
    private GUI.component.Svg lbExcel;
    private GUI.component.Svg lbExport;
    private GUI.component.Svg lbFinishExam;
    private GUI.component.Svg lbImport;
    private GUI.component.Svg lbRemove;
    private GUI.component.Svg lbStartExam;
    private javax.swing.JPanel panelMain;
    private GUI.component.PanelRoundRect panelTable1;
    private GUI.component.SearchBar searchBar1;
    private GUI.component.Table table1;
    // End of variables declaration//GEN-END:variables
}
