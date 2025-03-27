package GUI.studentView;

import BUS.ResultBUS;
import DTO.ResultDTO;
import java.awt.BorderLayout;
import javax.swing.table.DefaultTableModel;
import GUI.ScrollBarTable;
import GUI.TableModel.TableModel;
import GUI.swing.ModelCard;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;

public class PanelExam extends javax.swing.JPanel {

    private int studentId;
    private ArrayList<ResultDTO> results;
    private ResultBUS resultBUS;

    public PanelExam(int studentId) {
        initComponents();
        removeAll();
        setLayout(new BorderLayout());
        add(jLabel1, BorderLayout.NORTH);
        add(panelMain, BorderLayout.CENTER);
        ScrollBarTable.setScrollBarTable(jScrollPane1);

        resultBUS = new ResultBUS();
        this.studentId = studentId;
        setData();
    }

    public void setData() {
        results = resultBUS.getListStudent(studentId);
        DefaultTableModel model = TableModel.getResultStudent(results);
        table1.setModel(model);
        cardSummary1.setModel(new ModelCard("exam-card", "Các kì thi đã tham gia", Integer.toString(results.size()), Color.decode("#00cc66")));
    }

    private void setModelTable(ArrayList<ResultDTO> arr) {
        DefaultTableModel model = TableModel.getResultStudent(arr);
        table1.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        panelMain = new javax.swing.JPanel();
        panelTable1 = new GUI.component.PanelRoundRect();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new GUI.component.Table();
        searchBar1 = new GUI.component.SearchBar();
        cbxOrder = new GUI.component.Combobox();
        jLabel2 = new javax.swing.JLabel();
        combobox1 = new GUI.component.Combobox();
        cardSummary1 = new GUI.component.CardSummary();

        jLabel1.setForeground(new java.awt.Color(51, 204, 255));
        jLabel1.setText("Các kì thi đã tham dự");
        jLabel1.setToolTipText("");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel1.setOpaque(true);
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        panelMain.setPreferredSize(new java.awt.Dimension(880, 460));

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
        table1.setPreferredScrollableViewportSize(new java.awt.Dimension(820, 400));
        jScrollPane1.setViewportView(table1);

        javax.swing.GroupLayout panelTable1Layout = new javax.swing.GroupLayout(panelTable1);
        panelTable1.setLayout(panelTable1Layout);
        panelTable1Layout.setHorizontalGroup(
            panelTable1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTable1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        panelTable1Layout.setVerticalGroup(
            panelTable1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTable1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        cbxOrder.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ID (Tăng dần)", "ID (Giảm dần)", "Số câu hỏi (Tăng dần)", "Số câu hỏi (Giảm dần)", "Điểm số (Tăng dần)", "Điểm số (Giảm dần)" }));
        cbxOrder.setPreferredSize(new java.awt.Dimension(215, 35));
        cbxOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxOrderActionPerformed(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Order By");
        jLabel2.setToolTipText("");

        combobox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mã kì thi", "Tên kì thi", "Môn thi", "Thời gian làm bài", "Số câu hỏi" }));

        javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
        panelMain.setLayout(panelMainLayout);
        panelMainLayout.setHorizontalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cardSummary1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(panelMainLayout.createSequentialGroup()
                            .addComponent(searchBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(combobox1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cbxOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(panelTable1, javax.swing.GroupLayout.PREFERRED_SIZE, 882, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(275, Short.MAX_VALUE))
        );
        panelMainLayout.setVerticalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cardSummary1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(combobox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbxOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(panelTable1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelMain, javax.swing.GroupLayout.PREFERRED_SIZE, 1189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelMain, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        DefaultTableModel model = TableModel.getResultStudent(resultBUS.getListStudent(studentId));
        table1.setModel(model);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void cbxOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxOrderActionPerformed
        if (cbxOrder.getSelectedIndex() == 0) {
            Collections.sort(results, (DTO.ResultDTO s1, DTO.ResultDTO s2) -> {
                if (s1.getExamId() < s2.getExamId()) {
                    return -1;
                } else if (s1.getExamId() > s2.getExamId()) {
                    return 1;
                }
                return 0;
            });
            setModelTable(results);
        }
        if (cbxOrder.getSelectedIndex() == 1) {
            Collections.sort(results, (DTO.ResultDTO s1, DTO.ResultDTO s2) -> {
                if (s1.getExamId() > s2.getExamId()) {
                    return -1;
                } else if (s1.getExamId() < s2.getExamId()) {
                    return 1;
                }
                return 0;
            });
            setModelTable(results);
        }
        if (cbxOrder.getSelectedIndex() == 2) {
            Collections.sort(results, (DTO.ResultDTO s1, DTO.ResultDTO s2) -> {
                if (s1.getTotalQuestion() < s2.getTotalQuestion()) {
                    return -1;
                } else if (s1.getTotalQuestion() > s2.getTotalQuestion()) {
                    return 1;
                }
                return 0;
            });
            setModelTable(results);
        }
        if (cbxOrder.getSelectedIndex() == 3) {
            Collections.sort(results, (DTO.ResultDTO s1, DTO.ResultDTO s2) -> {
                if (s1.getTotalQuestion() > s2.getTotalQuestion()) {
                    return -1;
                } else if (s1.getTotalQuestion() < s2.getTotalQuestion()) {
                    return 1;
                }
                return 0;
            });
            setModelTable(results);
        }
        if (cbxOrder.getSelectedIndex() == 4) {
            Collections.sort(results, (DTO.ResultDTO s1, DTO.ResultDTO s2) -> {
                if (s1.getScore() < s2.getScore()) {
                    return -1;
                } else if (s1.getScore() > s2.getScore()) {
                    return 1;
                }
                return 0;
            });
            setModelTable(results);
        }
        if (cbxOrder.getSelectedIndex() == 5) {
            Collections.sort(results, (DTO.ResultDTO s1, DTO.ResultDTO s2) -> {
                if (s1.getScore() > s2.getScore()) {
                    return -1;
                } else if (s1.getScore() < s2.getScore()) {
                    return 1;
                }
                return 0;
            });
            setModelTable(results);
        }
    }//GEN-LAST:event_cbxOrderActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.component.CardSummary cardSummary1;
    private GUI.component.Combobox cbxOrder;
    private GUI.component.Combobox combobox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelMain;
    private GUI.component.PanelRoundRect panelTable1;
    private GUI.component.SearchBar searchBar1;
    private GUI.component.Table table1;
    // End of variables declaration//GEN-END:variables
}
