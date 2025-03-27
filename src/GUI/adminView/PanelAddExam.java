package GUI.adminView;

import BUS.ClassBUS;
import BUS.SubjectBUS;
import DTO.ClassDTO;
import DTO.ExamDTO;
import DTO.SubjectDTO;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import GUI.events.MyEventListener;
import UTILS.TimeUtils;
import java.awt.Component;
import javax.swing.JOptionPane;

public class PanelAddExam extends javax.swing.JPanel {

    private MyEventListener event;
    private ArrayList<ClassDTO> classes;
    private ClassBUS classBUS;

    public void addEvent(MyEventListener event) {
        this.event = event;
    }

    public PanelAddExam() {
        initComponents();
        classes = new ArrayList<ClassDTO>();
        classBUS = new ClassBUS();
        btnSubmit.setIcon(new FlatSVGIcon("assets/right.svg", 32, 32));
        btnCancel.setIcon(new FlatSVGIcon("assets/cancel.svg", 32, 32));
        btnReset.setIcon(new FlatSVGIcon("assets/reset.svg", 32, 32));

        ArrayList<SubjectDTO> subjects = (new SubjectBUS()).getAll();
        ArrayList<Object> items = new ArrayList<Object>();
        for (SubjectDTO i : subjects) {
            items.add(i);
        }
        cbxSubjects.setData(items);
        setLayout(new BorderLayout());
        setForm(jPanel1);
    }

    private void setForm(Component panel) {
        this.removeAll();
        this.add(panel, BorderLayout.CENTER);
        this.repaint();
        this.revalidate();
    }

    private boolean checkData() {
        if (txtExamName.getText().equals("") || classes.size() <= 0) {
            return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        btnReset = new javax.swing.JButton();
        btnSubmit = new javax.swing.JButton();
        txtExamName = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        cbxSubjects = new GUI.component.Combobox();
        jLabel1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cbxNumberQuestions = new GUI.component.Combobox();
        jLabel13 = new javax.swing.JLabel();
        cbxDuration = new GUI.component.Combobox();
        cbxClass = new GUI.component.Combobox();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstClass = new javax.swing.JList<>();

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel10.setText("Môn học");
        jLabel10.setPreferredSize(null);

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

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel11.setText("Tên kì thi");
        jLabel11.setPreferredSize(null);

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

        cbxSubjects.setPreferredSize(null);
        cbxSubjects.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxSubjectsActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(0, 204, 204));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("       Add a exam");
        jLabel1.setOpaque(true);

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel12.setText("Số câu hỏi");
        jLabel12.setPreferredSize(null);

        cbxNumberQuestions.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100", "101", "102", "103", "104", "105", "106", "107", "108", "109", "110", "111", "112", "113", "114", "115", "116", "117", "118", "119", "120", "121", "122", "123", "124", "125", "126", "127", "128", "129", "130", "131", "132", "133", "134", "135", "136", "137", "138", "139", "140", "141", "142", "143", "144", "145", "146", "147", "148", "149", "150" }));
        cbxNumberQuestions.setPreferredSize(null);

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel13.setText("Thời gian làm bài");
        jLabel13.setPreferredSize(null);

        cbxDuration.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1 phút", "2 phút", "3 phút", "4 phút", "5 phút", "6 phút", "7 phút", "8 phút", "9 phút", "10 phút", "11 phút", "12 phút", "13 phút", "14 phút", "15 phút", "16 phút", "17 phút", "18 phút", "19 phút", "20 phút", "21 phút", "22 phút", "23 phút", "24 phút", "25 phút", "26 phút", "27 phút", "28 phút", "29 phút", "30 phút", "31 phút", "32 phút", "33 phút", "34 phút", "35 phút", "36 phút", "37 phút", "38 phút", "39 phút", "40 phút", "41 phút", "42 phút", "43 phút", "44 phút", "45 phút", "46 phút", "47 phút", "48 phút", "49 phút", "50 phút", "51 phút", "52 phút", "53 phút", "54 phút", "55 phút", "56 phút", "57 phút", "58 phút", "59 phút", "60 phút", "61 phút", "62 phút", "63 phút", "64 phút", "65 phút", "66 phút", "67 phút", "68 phút", "69 phút", "70 phút", "71 phút", "72 phút", "73 phút", "74 phút", "75 phút", "76 phút", "77 phút", "78 phút", "79 phút", "80 phút", "81 phút", "82 phút", "83 phút", "84 phút", "85 phút", "86 phút", "87 phút", "88 phút", "89 phút", "90 phút", "91 phút", "92 phút", "93 phút", "94 phút", "95 phút", "96 phút", "97 phút", "98 phút", "99 phút", "100 phút", "101 phút", "102 phút", "103 phút", "104 phút", "105 phút", "106 phút", "107 phút", "108 phút", "109 phút", "110 phút", "111 phút", "112 phút", "113 phút", "114 phút", "115 phút", "116 phút", "117 phút", "118 phút", "119 phút", "120 phút", "121 phút", "122 phút", "123 phút", "124 phút", "125 phút", "126 phút", "127 phút", "128 phút", "129 phút", "130 phút", "131 phút", "132 phút", "133 phút", "134 phút", "135 phút", "136 phút", "137 phút", "138 phút", "139 phút", "140 phút", "141 phút", "142 phút", "143 phút", "144 phút", "145 phút", "146 phút", "147 phút", "148 phút", "149 phút", "150 phút" }));
        cbxDuration.setPreferredSize(null);

        cbxClass.setPreferredSize(null);
        cbxClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxClassActionPerformed(evt);
            }
        });

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel15.setText("Lớp thi");

        lstClass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstClassMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(lstClass);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 103, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cbxClass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbxSubjects, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtExamName)
                                .addComponent(cbxNumberQuestions, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cbxDuration, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 104, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtExamName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxSubjects, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbxNumberQuestions, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbxDuration, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxClass, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(81, Short.MAX_VALUE))
        );

        txtExamName.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(142, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(79, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbxSubjectsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxSubjectsActionPerformed
        classes.removeAll(classes);
        lstClass.setModel(new DefaultListModel());
        ArrayList<Object> items = new ArrayList<Object>();
        SubjectDTO s = (SubjectDTO) cbxSubjects.getSelectedItem();
        ArrayList<ClassDTO> classes = classBUS.getAllOfSubject(s.getSubjectId());
        if (classes.size() != 0) {
            for (ClassDTO i : classes) {
                items.add(i);
            }
            cbxClass.setData(items);
        } else {
            cbxClass.removeData();
        }
    }//GEN-LAST:event_cbxSubjectsActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        if (checkData()) {
            SubjectDTO s = (SubjectDTO) cbxSubjects.getSelectedItem();
            String start = TimeUtils.getNow();

            ExamDTO exam = new ExamDTO();
            exam.setExamName(txtExamName.getText());
            exam.setSubjectId(s.getSubjectId());
            exam.setStatus("pending");
            exam.setDuration(cbxDuration.getSelectedIndex() + 1);
            exam.setStartTime(start);
            exam.setTotalQuestion(cbxNumberQuestions.getSelectedIndex() + 1);

            PanelAddExamQuestion1 panel = new PanelAddExamQuestion1(exam, classes);
            panel.addEventSubmit(() -> {
                event.actionPerformed();
            });
            panel.addEventCancel(() -> {
                setForm(jPanel1);
            });
            setForm(panel);
        } else {
            JOptionPane.showMessageDialog(null, "Chưa nhập đủ thông tin");
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed

    }//GEN-LAST:event_btnResetActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        event.actionPerformed();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void cbxClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxClassActionPerformed
        if (cbxClass.getSelectedItem() != null) {
            DefaultListModel model = new DefaultListModel();
            ClassDTO c = (ClassDTO) cbxClass.getSelectedItem();
            if (!classes.contains(c)) {
                classes.add(c);
                for (ClassDTO i : classes) {
                    model.addElement(i.toString());
                }
                lstClass.setModel(model);
            }
        }
    }//GEN-LAST:event_cbxClassActionPerformed

    private void lstClassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstClassMouseClicked
        if (evt.getClickCount() == 2) {
            classes.remove(lstClass.getSelectedIndex());
            DefaultListModel model = new DefaultListModel();
            for (ClassDTO i : classes) {
                model.addElement(i.toString());
            }
            lstClass.setModel(model);
        }
    }//GEN-LAST:event_lstClassMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSubmit;
    private GUI.component.Combobox cbxClass;
    private GUI.component.Combobox cbxDuration;
    private GUI.component.Combobox cbxNumberQuestions;
    private GUI.component.Combobox cbxSubjects;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> lstClass;
    private javax.swing.JTextField txtExamName;
    // End of variables declaration//GEN-END:variables
}
