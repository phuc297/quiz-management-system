package GUI.teacherView;

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
import GUI.events.MyEventListener;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class PanelAddExamQuestion1 extends javax.swing.JPanel {

    private MyEventListener eventSubmit;
    private MyEventListener eventcancel;
    private ExamDTO exam;
    private ArrayList<ClassDTO> classes;
    private ArrayList<QuestionDTO> questions;
    private ArrayList<QuestionDTO> examQuestions;
    private ArrayList<Integer> examQuestionsId;
    private ExamBUS examBUS;
    private DefaultTableModel model1;
    private DefaultTableModel model2;
    private QuestionBUS questionBUS;
    private ExamQuestionBUS examQuestionBUS;

    public void addEventSubmit(MyEventListener event) {
        this.eventSubmit = event;
    }

    public void addEventCancel(MyEventListener event) {
        this.eventcancel = event;
    }

    public PanelAddExamQuestion1(ExamDTO exam, ArrayList<ClassDTO> classes) {
        initComponents();
        this.exam = exam;
        this.classes = classes;
        this.examQuestionsId = new ArrayList<Integer>();
        examBUS = new ExamBUS();
        questionBUS = new QuestionBUS();
        examQuestionBUS = new ExamQuestionBUS();
        ScrollBarTable.setScrollBarTable(jScrollPane3);
        ScrollBarTable.setScrollBarTable(jScrollPane1);
        ScrollBarTable.setScrollBarTable(jScrollPane2);
        questions = questionBUS.getQuestionsOfSubject(exam.getSubjectId());
        examQuestions = new ArrayList<QuestionDTO>();

        table1.setMultiSelect(true);
        table2.setMultiSelect(true);
        lbAdd.setSvgImage("right0", 32, 32);
        lbRemove.setSvgImage("left", 32, 32);
        setData();
        lbQ.setText(Integer.toString(examQuestionsId.size()) + "/" + Integer.toString(exam.getTotalQuestion()));
    }

    private void setData() {
        model1 = TableModel.getExamQuestion(questions);
        table1.setModel(model1);
        TableColumnModel columnModel = table1.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(30);
        columnModel.getColumn(0).setMaxWidth(30);
        columnModel.getColumn(1).setPreferredWidth(150);

        model2 = TableModel.getExamQuestion(examQuestions);
        table2.setModel(model2);
        TableColumnModel columnModel2 = table2.getColumnModel();
        columnModel2.getColumn(0).setPreferredWidth(30);
        columnModel2.getColumn(0).setMaxWidth(30);
        columnModel2.getColumn(1).setPreferredWidth(150);

        ListSelectionModel selectionModel = table1.getSelectionModel();
        selectionModel.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        selectionModel = table2.getSelectionModel();
        selectionModel.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    }

    private void setModelTable(ArrayList<QuestionDTO> arr) {
        model1.setRowCount(0);
        model1 = TableModel.getExamQuestion(arr);
        table1.setModel(model1);
        TableColumnModel columnModel = table1.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(30);
        columnModel.getColumn(0).setMaxWidth(30);
        columnModel.getColumn(1).setPreferredWidth(150);
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
        lbRemove = new GUI.component.Svg();
        lbAdd = new GUI.component.Svg();
        searchBar1 = new GUI.component.SearchBar();
        cbxSearch = new GUI.component.Combobox();
        lbQ = new javax.swing.JLabel();

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
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                table1MouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(table1);

        javax.swing.GroupLayout panelRoundRect1Layout = new javax.swing.GroupLayout(panelRoundRect1);
        panelRoundRect1.setLayout(panelRoundRect1Layout);
        panelRoundRect1Layout.setHorizontalGroup(
            panelRoundRect1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundRect1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                table2MouseEntered(evt);
            }
        });
        jScrollPane2.setViewportView(table2);

        javax.swing.GroupLayout panelRoundRect2Layout = new javax.swing.GroupLayout(panelRoundRect2);
        panelRoundRect2.setLayout(panelRoundRect2Layout);
        panelRoundRect2Layout.setHorizontalGroup(
            panelRoundRect2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundRect2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        panelRoundRect2Layout.setVerticalGroup(
            panelRoundRect2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRoundRect2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        lbRemove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbRemoveMouseClicked(evt);
            }
        });

        lbAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbAddMouseClicked(evt);
            }
        });

        searchBar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchBar1MouseClicked(evt);
            }
        });

        cbxSearch.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mã câu hỏi", "Câu hỏi" }));
        cbxSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxSearchActionPerformed(evt);
            }
        });

        lbQ.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbQ.setForeground(new java.awt.Color(255, 51, 51));
        lbQ.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbQ.setText("jLabel2");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelRoundRect1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelRoundRect2, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(searchBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbQ, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(116, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbxSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbQ, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRoundRect2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelRoundRect1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(83, 83, 83))
        );

        jScrollPane3.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1028, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
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
        if (examQuestionsId.size() == exam.getTotalQuestion()) {
            if (examBUS.insert(exam)) {
                int examId = examBUS.getLatestId();
                for (int q : examQuestionsId) {
                    examQuestionBUS.insert(new ExamQuestionDTO(examId, q));
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

    }//GEN-LAST:event_table2MouseClicked

    private void lbRemoveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbRemoveMouseClicked
        if (lbRemove.isEnabled()) {
            int[] selected = table2.getSelectedRows();
            int[] id = new int[selected.length];
            for (int i = 0; i < selected.length; i++) {
                int idQuestion = (int) table2.getModel().getValueAt(selected[i], 0);
                id[i] = idQuestion;
                String textQ = table2.getModel().getValueAt(selected[i], 1).toString();
                QuestionDTO q = new QuestionDTO();
                q.setQuestionId(idQuestion);
                q.setQuestionText(textQ);

                Object rowData[] = {
                    q.getQuestionId(),
                    q.getQuestionText()};
                model1.addRow(rowData);
                questions.add(questionBUS.get(idQuestion));
                examQuestionsId.remove((Object) idQuestion);
            }

            for (int i = 0; i < id.length; i++) {
                model2.removeRow(selected[i] - i);
            }
            lbQ.setText(Integer.toString(examQuestionsId.size()) + "/" + Integer.toString(exam.getTotalQuestion()));
            table2.clearSelection();
        }
    }//GEN-LAST:event_lbRemoveMouseClicked

    private void lbAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAddMouseClicked
        if (lbAdd.isEnabled()) {
            int[] selected = table1.getSelectedRows();
            int[] id = new int[selected.length];
            if (examQuestionsId.size() + selected.length <= exam.getTotalQuestion()) {
                for (int i = 0; i < selected.length; i++) {
                    int idQuestion = (int) table1.getModel().getValueAt(selected[i], 0);
                    id[i] = idQuestion;
                    String textQ = table1.getModel().getValueAt(selected[i], 1).toString();
                    QuestionDTO q = new QuestionDTO();
                    q.setQuestionId(idQuestion);
                    q.setQuestionText(textQ);

                    Object rowData[] = {
                        q.getQuestionId(),
                        q.getQuestionText()};
                    model2.addRow(rowData);
                    for (QuestionDTO qdto : questions) {
                        if (qdto.getQuestionId() == q.getQuestionId()) {
                            questions.remove(qdto);
                            break;
                        }
                    }
                    examQuestionsId.add(idQuestion);
                }

                for (int i = 0; i < id.length; i++) {
                    model1.removeRow(selected[i] - i);
                }
                table1.clearSelection();
                lbQ.setText(Integer.toString(examQuestionsId.size()) + "/" + Integer.toString(exam.getTotalQuestion()));
                if (examQuestionsId.size() == exam.getTotalQuestion()) {
                    JOptionPane.showMessageDialog(null, "Đã nhập đủ số câu hỏi");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Vượt quá số câu hỏi của bài thi");
            }
            table1.clearSelection();
        }
    }//GEN-LAST:event_lbAddMouseClicked

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked

    }//GEN-LAST:event_table1MouseClicked

    private void searchBar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBar1MouseClicked
        int selected = cbxSearch.getSelectedIndex();
        String txt = searchBar1.getText();
        if (selected == 0) {
            setModelTable(questionBUS.findById(questions, txt));
            return;
        }
        if (selected == 1) {
            setModelTable(questionBUS.find(questions, txt));
            return;
        }
    }//GEN-LAST:event_searchBar1MouseClicked

    private void cbxSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxSearchActionPerformed
        int selected = cbxSearch.getSelectedIndex();
        String txt = searchBar1.getText();
        if (selected == 0) {
            setModelTable(questionBUS.findById(questions, txt));
            return;
        }
        if (selected == 1) {
            setModelTable(questionBUS.find(questions, txt));
            return;
        }
    }//GEN-LAST:event_cbxSearchActionPerformed

    private void table1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseEntered
        table2.clearSelection();
        lbRemove.setEnabled(false);
        lbAdd.setEnabled(true);
    }//GEN-LAST:event_table1MouseEntered

    private void table2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table2MouseEntered
        table1.clearSelection();
        lbRemove.setEnabled(true);
        lbAdd.setEnabled(false);
    }//GEN-LAST:event_table2MouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSubmit;
    private GUI.component.Combobox cbxSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private GUI.component.Svg lbAdd;
    private javax.swing.JLabel lbQ;
    private GUI.component.Svg lbRemove;
    private GUI.component.PanelRoundRect panelRoundRect1;
    private GUI.component.PanelRoundRect panelRoundRect2;
    private GUI.component.SearchBar searchBar1;
    private GUI.component.Table table1;
    private GUI.component.Table table2;
    // End of variables declaration//GEN-END:variables
}
