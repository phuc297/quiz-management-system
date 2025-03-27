package GUI.adminView;

import BUS.ExamBUS;
import BUS.ExamQuestionBUS;
import BUS.ExamStudentBUS;
import BUS.QuestionBUS;
import DTO.ClassDTO;
import DTO.ExamDTO;
import DTO.ExamQuestionDTO;
import DTO.ExamStudentDTO;
import DTO.QuestionDTO;
import GUI.ScrollBarTable;
import GUI.TableModel.TableModel;
import java.util.ArrayList;
import javax.swing.JTable;
import GUI.events.MyEventListener;
import javax.swing.JOptionPane;

public class PanelAddExamQuestion extends javax.swing.JPanel {

    private MyEventListener eventSubmit;
    private MyEventListener eventcancel;
    private ExamDTO exam;
    private ArrayList<ClassDTO> classes;
    private ArrayList<QuestionDTO> questions;
    private ArrayList<QuestionDTO> examQuestions;
    private ExamBUS examBUS;

    public void addEventSubmit(MyEventListener event) {
        this.eventSubmit = event;
    }

    public void addEventCancel(MyEventListener event) {
        this.eventcancel = event;
    }

    public PanelAddExamQuestion(ExamDTO exam, ArrayList<ClassDTO> classes) {
        initComponents();
        this.exam = exam;
        this.classes = classes;
        examBUS = new ExamBUS();
        ScrollBarTable.setScrollBarTable(jScrollPane3);
        ScrollBarTable.setScrollBarTable(jScrollPane1);
        ScrollBarTable.setScrollBarTable(jScrollPane2);
        questions = (new QuestionBUS()).getQuestionsOfSubject(exam.getSubjectId());
        examQuestions = new ArrayList<QuestionDTO>();
        table1.setMultiSelect(true);
        setData();
    }

    private void setData() {
        table1.setModel(TableModel.getQuestion(questions));
        table2.setModel(TableModel.getQuestion(examQuestions));
    }

    private boolean isChosen(QuestionDTO q) {
        for (QuestionDTO i : examQuestions) {
            if (q.getQuestionId() == i.getQuestionId()) {
                return true;
            }
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnSubmit = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        panelRoundRect1 = new GUI.component.PanelRoundRect();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new GUI.component.Table();
        panelRoundRect2 = new GUI.component.PanelRoundRect();
        jScrollPane2 = new javax.swing.JScrollPane();
        table2 = new GUI.component.Table();

        jLabel1.setBackground(new java.awt.Color(0, 204, 204));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("       Add a exam");
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
        btnSubmit.setText("Questions");
        btnSubmit.setBorder(null);
        btnSubmit.setFocusPainted(false);
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        jScrollPane3.setHorizontalScrollBar(null);

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        panelRoundRect2Layout.setVerticalGroup(
            panelRoundRect2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundRect2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelRoundRect2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelRoundRect1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(843, 843, 843))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRoundRect1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelRoundRect2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(243, 243, 243))
        );

        jScrollPane3.setViewportView(jPanel1);

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
                        .addGap(181, 181, 181)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 489, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        eventcancel.actionPerformed();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed

    }//GEN-LAST:event_btnResetActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        if (examQuestions.size() == exam.getTotalQuestion()) {
            if (examBUS.insert(exam)) {
                int examId = examBUS.getLatestId();
                for (QuestionDTO q : examQuestions) {
                    (new ExamQuestionBUS()).insert(new ExamQuestionDTO(examId, q.getQuestionId()));
                }
                for (ClassDTO c : classes) {
                    (new ExamStudentBUS()).insertClass(new ExamStudentDTO(examId, c.getClassId()));
                }
                JOptionPane.showMessageDialog(null, "Tạo kì thi thành công");
                eventSubmit.actionPerformed();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Chưa nhập đủ số câu hỏi cho bài thi");
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void table2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table2MouseClicked
        JTable table = (JTable) evt.getSource();
        if (evt.getClickCount() == 2) {
            int selected = (int) table2.getModel().getValueAt(table2.getSelectedRow(), 0);
            for (QuestionDTO q : examQuestions) {
                if (q.getQuestionId() == selected) {
                    for (int i = 0; i < questions.size(); i++) {
                        if (selected == (int) table1.getModel().getValueAt(i, 0)) {

                            break;
                        }
                    }
                    examQuestions.remove(q);
                    table2.setModel(TableModel.getQuestion(examQuestions));
                    break;
                }
            }
        }
    }//GEN-LAST:event_table2MouseClicked

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked
        if (examQuestions.size() < exam.getTotalQuestion()) {
            int selected = (int) table1.getModel().getValueAt(table1.getSelectedRow(), 0);
            for (QuestionDTO q : questions) {
                if (q.getQuestionId() == selected && !isChosen(q)) {
                    table1.setAddRow(table1.getSelectedRow());
                    examQuestions.add(q);
                    table2.setModel(TableModel.getQuestion(examQuestions));
                    break;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Đã nhập đủ câu hỏi");
        }
    }//GEN-LAST:event_table1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private GUI.component.PanelRoundRect panelRoundRect1;
    private GUI.component.PanelRoundRect panelRoundRect2;
    private GUI.component.Table table1;
    private GUI.component.Table table2;
    // End of variables declaration//GEN-END:variables
}
