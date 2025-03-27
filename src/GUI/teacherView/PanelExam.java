package GUI.teacherView;

import BUS.ExamBUS;
import DTO.ExamDTO;
import GUI.ScrollBarTable;
import java.awt.BorderLayout;
import GUI.TableModel.TableModel;
import GUI.adminView.PanelExamDetail;
import GUI.swing.ModelCard;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PanelExam extends javax.swing.JPanel {

    private int teacherId;
    private ArrayList<ExamDTO> exams;
    private ExamBUS examBUS;

    public PanelExam(int teacherId) {
        initComponents();
        setLayout(new BorderLayout());
        setForm(panelMain);
        ScrollBarTable.setScrollBarTable(jScrollPane1);

        examBUS = new ExamBUS();
        this.teacherId = teacherId;

        setData();

        lbAdd.setSvgImage("add", 32, 32);
        lbRemove.setSvgImage("remove", 32, 32);
        lbEdit.setSvgImage("edit", 32, 32);
        lbStartExam.setSvgImage("bell", 32, 32);
        lbFinishExam.setSvgImage("lock", 32, 32);
        lbDetail.setSvgImage("detail", 32, 32);
        lbRemove.setEnabled(false);
        lbEdit.setEnabled(false);
        lbStartExam.setEnabled(false);
        lbFinishExam.setEnabled(false);
        lbDetail.setEnabled(false);
    }

    private void setData() {
        this.exams = examBUS.getAllOfTeacher(teacherId);
        DefaultTableModel model = TableModel.getExam(exams);
        table1.setModel(model);
        cardSummary1.setModel(new ModelCard("exam-card", "Các kì thi của môn học đang quản lý", Integer.toString(exams.size()), Color.decode("#00cc66")));
    }

    private void setForm(Component com) {
        removeAll();
        add(com, BorderLayout.CENTER);
        repaint();
        revalidate();
    }

    private void setModelTable(ArrayList<ExamDTO> arr) {
        DefaultTableModel model = TableModel.getExam(arr);
        table1.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMain = new javax.swing.JPanel();
        panelTable1 = new GUI.component.PanelRoundRect();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new GUI.component.Table();
        lbAdd = new GUI.component.Svg();
        lbRemove = new GUI.component.Svg();
        lbEdit = new GUI.component.Svg();
        lbStartExam = new GUI.component.Svg();
        cardSummary1 = new GUI.component.CardSummary();
        cbxOrder = new GUI.component.Combobox();
        jLabel1 = new javax.swing.JLabel();
        searchBar1 = new GUI.component.SearchBar();
        cbxSearch = new GUI.component.Combobox();
        lbFinishExam = new GUI.component.Svg();
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

        lbStartExam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbStartExamMouseClicked(evt);
            }
        });

        cbxOrder.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ID (Tăng dần)", "ID (Giảm dần)", "Môn học", "Trạng thái", "Số câu hỏi (Tăng dần)", "Số câu hỏi (Giảm dần)", "Thời gian làm bài" }));
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

        lbFinishExam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbFinishExamMouseClicked(evt);
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
                    .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(panelMainLayout.createSequentialGroup()
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
                            .addComponent(lbAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMainLayout.createSequentialGroup()
                                .addComponent(searchBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbxOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(panelTable1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(cardSummary1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );
        panelMainLayout.setVerticalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cardSummary1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbxOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbxSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(panelTable1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbFinishExam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelMainLayout.createSequentialGroup()
                        .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbStartExam, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lbAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAddMouseClicked
        PanelAddExam panel = new PanelAddExam(teacherId);
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
                lbFinishExam.setEnabled(true);
                lbEdit.setEnabled(false);
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

    private void cbxOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxOrderActionPerformed
        if (cbxOrder.getSelectedIndex() == 0) {
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
        if (cbxOrder.getSelectedIndex() == 1) {
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
        if (cbxOrder.getSelectedIndex() == 2) {

        }
        if (cbxOrder.getSelectedIndex() == 3) {

        }
        if (cbxOrder.getSelectedIndex() == 4) {
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
        if (cbxOrder.getSelectedIndex() == 5) {
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
    private GUI.component.Svg lbFinishExam;
    private GUI.component.Svg lbRemove;
    private GUI.component.Svg lbStartExam;
    private javax.swing.JPanel panelMain;
    private GUI.component.PanelRoundRect panelTable1;
    private GUI.component.SearchBar searchBar1;
    private GUI.component.Table table1;
    // End of variables declaration//GEN-END:variables
}
