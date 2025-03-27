package GUI.teacherView;

import BUS.QuestionBUS;
import DTO.QuestionDTO;
import java.awt.BorderLayout;
import javax.swing.table.DefaultTableModel;
import GUI.ScrollBarTable;
import GUI.TableModel.TableModel;
import GUI.swing.ModelCard;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Collections;

public class PanelQuestion extends javax.swing.JPanel {

    private int teacherId;
    private ArrayList<QuestionDTO> questions;
    private QuestionBUS questionBUS;

    public PanelQuestion(int teacherId) {
        initComponents();
        questionBUS = new QuestionBUS();
        this.teacherId = teacherId;
        setLayout(new BorderLayout());
        setForm(panelMain);
        ScrollBarTable.setScrollBarTable(jScrollPane1);

        lbAdd.setSvgImage("add", 32, 32);
        lbRemove.setSvgImage("remove", 32, 32);
        lbEdit.setSvgImage("edit", 32, 32);
        lbRemove.setEnabled(false);
        lbEdit.setEnabled(false);
        setData();
    }

    private void setForm(Component com) {
        removeAll();
        add(com, BorderLayout.CENTER);
        repaint();
        revalidate();
    }

    private void setData() {
        questions = questionBUS.getQuestionsOfTeacher(teacherId);
        DefaultTableModel model = TableModel.getQuestion(questions);
        table1.setModel(model);
        cardSummary1.setModel(new ModelCard("light-card", "Số câu hỏi", Integer.toString(questions.size()), Color.decode("#fa4659")));
    }

    private void setModelTable(ArrayList<QuestionDTO> arr) {
        DefaultTableModel model = TableModel.getQuestion(arr);
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
        cbxOrder = new GUI.component.Combobox();
        jLabel1 = new javax.swing.JLabel();
        cardSummary1 = new GUI.component.CardSummary();
        searchBar1 = new GUI.component.SearchBar();
        cbxSearch = new GUI.component.Combobox();

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

        cbxOrder.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ID (Tăng dần)", "ID (Giảm dần)", "Môn học" }));
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

        cbxSearch.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mã câu hỏi", "Câu hỏi", "Đáp án" }));
        cbxSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
        panelMain.setLayout(panelMainLayout);
        panelMainLayout.setHorizontalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelMainLayout.createSequentialGroup()
                                .addGap(749, 749, 749)
                                .addComponent(lbEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(lbRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(lbAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelMainLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panelTable1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelMainLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(searchBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cbxSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cbxOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelMainLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cardSummary1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5))
        );
        panelMainLayout.setVerticalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cardSummary1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(searchBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbxOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbxSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(panelTable1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(94, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMain, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lbAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAddMouseClicked
        PanelAddQuestion panel = new PanelAddQuestion(teacherId);
        panel.addEvent(() -> {
            setForm(panelMain);
            setData();
        });
        setForm(panel);
    }//GEN-LAST:event_lbAddMouseClicked

    private void lbRemoveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbRemoveMouseClicked
        if (lbRemove.isEnabled()) {
            int selected = table1.getSelectedRow();
            int id = (int) table1.getModel().getValueAt(selected, 0);
            questionBUS.remove(id);
            setData();
        }
    }//GEN-LAST:event_lbRemoveMouseClicked

    private void lbEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbEditMouseClicked
        if (lbEdit.isEnabled()) {
            int selected = table1.getSelectedRow();
            int id = (int) table1.getModel().getValueAt(selected, 0);
            QuestionDTO q = questionBUS.get(id);
            PanelEditQuestion panel = new PanelEditQuestion(q);
            panel.addEvent(() -> {
                setForm(panelMain);
                setData();
            });
            setForm(panel);
        }
    }//GEN-LAST:event_lbEditMouseClicked

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked
        int selected = table1.getSelectedRow();
        if (selected != -1) {
            lbRemove.setEnabled(true);
            lbEdit.setEnabled(true);
        }
    }//GEN-LAST:event_table1MouseClicked

    private void cbxOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxOrderActionPerformed
        if (cbxOrder.getSelectedIndex() == 0) {
            setData();
        }
        if (cbxOrder.getSelectedIndex() == 0) {
            Collections.sort(questions, (QuestionDTO s1, QuestionDTO s2) -> {
                if (s1.getQuestionId() < s2.getQuestionId()) {
                    return -1;
                } else if (s1.getQuestionId() > s2.getQuestionId()) {
                    return 1;
                }
                return 0;
            });
            setModelTable(questions);
        }
        if (cbxOrder.getSelectedIndex() == 1) {
            Collections.sort(questions, (QuestionDTO s1, QuestionDTO s2) -> {
                if (s1.getQuestionId() > s2.getQuestionId()) {
                    return -1;
                } else if (s1.getQuestionId() < s2.getQuestionId()) {
                    return 1;
                }
                return 0;
            });
            setModelTable(questions);
        }
        if (cbxOrder.getSelectedIndex() == 2) {
            ArrayList<QuestionDTO> sQuestions = questionBUS.getOrderbySubject(teacherId);
            setModelTable(sQuestions);
        }
    }//GEN-LAST:event_cbxOrderActionPerformed

    private void searchBar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBar1MouseClicked
        int selected = cbxSearch.getSelectedIndex();
        String txt = searchBar1.getText();
        if (selected == 0) {
            setModelTable(questionBUS.findById(txt));
            return;
        }
        if (selected == 1) {
            setModelTable(questionBUS.findOfByText(questions, txt));
            return;
        }
        if (selected == 2) {
            setModelTable(questionBUS.findOfByAnswer(questions, txt));
        }
    }//GEN-LAST:event_searchBar1MouseClicked

    private void cbxSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxSearchActionPerformed
        int selected = cbxSearch.getSelectedIndex();
        String txt = searchBar1.getText();
        if (selected == 0) {
            setModelTable(questionBUS.findById(txt));
            return;
        }
        if (selected == 1) {
            setModelTable(questionBUS.findOfByText(questions, txt));
            return;
        }
        if (selected == 2) {
            setModelTable(questionBUS.findOfByAnswer(questions, txt));
        }
    }//GEN-LAST:event_cbxSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.component.CardSummary cardSummary1;
    private GUI.component.Combobox cbxOrder;
    private GUI.component.Combobox cbxSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private GUI.component.Svg lbAdd;
    private GUI.component.Svg lbEdit;
    private GUI.component.Svg lbRemove;
    private javax.swing.JPanel panelMain;
    private GUI.component.PanelRoundRect panelTable1;
    private GUI.component.SearchBar searchBar1;
    private GUI.component.Table table1;
    // End of variables declaration//GEN-END:variables
}
