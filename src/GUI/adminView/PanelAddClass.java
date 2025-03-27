package GUI.adminView;

import BUS.ClassBUS;
import BUS.SubjectBUS;
import BUS.TeacherBUS;
import DTO.ClassDTO;
import DTO.SubjectDTO;
import DTO.TeacherDTO;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.util.ArrayList;
import GUI.events.MyEventListener;
import javax.swing.JOptionPane;

public class PanelAddClass extends javax.swing.JPanel {

    private MyEventListener event;
    private MyEventListener eventCancel;

    public void addEvent(MyEventListener event) {
        this.event = event;
    }

    public void addEventCancel(MyEventListener event) {
        this.eventCancel = event;
    }
    private TeacherBUS teacherBUS;
    private SubjectBUS subjectBUS;
    private ClassBUS classBUS;
    private boolean isInserted;
    private ClassDTO classDTO;

    public PanelAddClass() {
        initComponents();
        isInserted = false;
        btnSubmit.setIcon(new FlatSVGIcon("assets/submit.svg", 32, 32));
        btnCancel.setIcon(new FlatSVGIcon("assets/cancel.svg", 32, 32));
        btnReset.setIcon(new FlatSVGIcon("assets/reset.svg", 32, 32));
        teacherBUS = new TeacherBUS();
        subjectBUS = new SubjectBUS();
        classBUS = new ClassBUS();
        setData();
    }

    private void setData() {
        ArrayList<SubjectDTO> subjects = subjectBUS.getAll();
        ArrayList<Object> items = new ArrayList<Object>();
        for (SubjectDTO i : subjects) {
            items.add(i);
        }
        cbxSubjects.setData(items);

        ArrayList<TeacherDTO> teachers = teacherBUS.getAllBySubject(subjects.get(0).getSubjectId());
        ArrayList<Object> items1 = new ArrayList<Object>();
        for (TeacherDTO i : teachers) {
            items1.add(i);
        }
        cbxTeachers.setData(items1);
    }

    public boolean isInserted() {
        return isInserted;
    }

    public ClassDTO classCreated() {
        return classDTO;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnSubmit = new javax.swing.JButton();
        cbxSubjects = new GUI.component.Combobox();
        cbxTeachers = new GUI.component.Combobox();
        txtClassName = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();

        jLabel1.setBackground(new java.awt.Color(0, 204, 204));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("       Add a class");
        jLabel1.setOpaque(true);

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel10.setText("Môn học");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel9.setText("Giáo viên");

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
        btnSubmit.setText("Submit");
        btnSubmit.setBorder(null);
        btnSubmit.setFocusPainted(false);
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        cbxSubjects.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxSubjectsActionPerformed(evt);
            }
        });

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel11.setText("Tên lớp");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 125, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbxTeachers, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtClassName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxSubjects, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 125, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(txtClassName))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxSubjects, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbxTeachers, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(91, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        eventCancel.actionPerformed();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed

    }//GEN-LAST:event_btnResetActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        TeacherDTO t = (TeacherDTO) cbxTeachers.getSelectedItem();
        SubjectDTO s = (SubjectDTO) cbxSubjects.getSelectedItem();
        classDTO = new ClassDTO(txtClassName.getText(), t.getTeacherId(), s.getSubjectId());
        if (classBUS.insert(classDTO)) {
            JOptionPane.showMessageDialog(null, "Đã tạo thành công");
            classDTO.setClassId(classBUS.getLatest());
            isInserted = true;
            event.actionPerformed();
        } else {
            JOptionPane.showMessageDialog(null, "Tên lớp đã tồn tại");
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void cbxSubjectsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxSubjectsActionPerformed
        SubjectDTO selected = (SubjectDTO) cbxSubjects.getSelectedItem();
        ArrayList<TeacherDTO> teachers = teacherBUS.getAllBySubject(selected.getSubjectId());
        ArrayList<Object> items1 = new ArrayList<Object>();
        for (TeacherDTO i : teachers) {
            items1.add(i);
        }
        cbxTeachers.setData(items1);
    }//GEN-LAST:event_cbxSubjectsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSubmit;
    private GUI.component.Combobox cbxSubjects;
    private GUI.component.Combobox cbxTeachers;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtClassName;
    // End of variables declaration//GEN-END:variables
}
