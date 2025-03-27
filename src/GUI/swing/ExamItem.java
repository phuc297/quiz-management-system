package GUI.swing;

import DTO.ExamDTO;
import GUI.events.StartExamListener;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.BorderFactory;
import UTILS.Cons;

public class ExamItem extends javax.swing.JPanel {

    private StartExamListener event;

    public void addStartExamListener(StartExamListener event) {
        this.event = event;
    }

    private static int i = 0;
    private int iColor;
    private ExamDTO exam;

    public ExamItem(ExamDTO exam) {
        initComponents();
        this.exam = exam;
        iColor = i;
        i++;
        if (i >= Cons.COLORS.length) {
            i = 0;
        }
        setText();
    }

    private void setText() {
        lbTitleExam.setText(exam.getExamName());
        lbSubject.setText("Môn học: " + exam.getSubjectName());
        lbNumberQuestions.setText("Số câu hỏi: " + Integer.toString(exam.getTotalQuestion()));
        lbTime.setText("Thời gian làm bài: " + exam.getDurationString());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTitleExam = new javax.swing.JLabel();
        btnStartExam = new javax.swing.JButton();
        lbTime = new javax.swing.JLabel();
        lbNumberQuestions = new javax.swing.JLabel();
        lbSubject = new javax.swing.JLabel();

        setFocusable(false);
        setOpaque(false);

        lbTitleExam.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTitleExam.setForeground(new java.awt.Color(0, 0, 0));
        lbTitleExam.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitleExam.setText("Kiểm tra toán");
        lbTitleExam.setMaximumSize(new java.awt.Dimension(543453453, 543453453));
        lbTitleExam.setMinimumSize(new java.awt.Dimension(0, 0));
        lbTitleExam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbTitleExamMouseClicked(evt);
            }
        });

        btnStartExam.setBackground(new java.awt.Color(255, 255, 255));
        btnStartExam.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnStartExam.setForeground(new java.awt.Color(51, 204, 255));
        btnStartExam.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/pen.png"))); // NOI18N
        btnStartExam.setText("Bắt đầu");
        btnStartExam.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 255)));
        btnStartExam.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnStartExam.setFocusable(false);
        btnStartExam.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/check.png"))); // NOI18N
        btnStartExam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnStartExamMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnStartExamMouseExited(evt);
            }
        });
        btnStartExam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartExamActionPerformed(evt);
            }
        });

        lbTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTime.setText("jLabel1");
        lbTime.setMaximumSize(new java.awt.Dimension(1234534, 1234534));
        lbTime.setMinimumSize(new java.awt.Dimension(0, 0));
        lbTime.setPreferredSize(null);

        lbNumberQuestions.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbNumberQuestions.setText("jLabel1");
        lbNumberQuestions.setMaximumSize(new java.awt.Dimension(1234534, 1234534));
        lbNumberQuestions.setMinimumSize(new java.awt.Dimension(0, 0));
        lbNumberQuestions.setPreferredSize(null);

        lbSubject.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSubject.setText("lbSubject");
        lbSubject.setMaximumSize(new java.awt.Dimension(1234534, 1234534));
        lbSubject.setMinimumSize(new java.awt.Dimension(0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTitleExam, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lbSubject, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lbNumberQuestions, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                            .addComponent(lbTime, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnStartExam, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTitleExam, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbSubject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbNumberQuestions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnStartExam, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleDescription("");
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint g = new GradientPaint(getWidth(), getHeight(), Color.decode(Cons.COLORS[iColor]), 0, getHeight(), Color.decode(Cons.COLORS[iColor]));
        g2.setPaint(g);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
        g2.setColor(new Color(255, 255, 255, 50));
        g2.fillOval(-20, 10, getHeight(), getHeight());
        g2.fillOval(0, getHeight() / 2 + 20, getHeight(), getHeight());
        super.paintComponent(grphcs);
    }


    private void btnStartExamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartExamActionPerformed
        event.start(exam);
    }//GEN-LAST:event_btnStartExamActionPerformed

    private void btnStartExamMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStartExamMouseEntered
        btnStartExam.setBackground(new Color(51, 204, 255));
        btnStartExam.setForeground(Color.WHITE);
        btnStartExam.setBorder(BorderFactory.createLineBorder(Color.WHITE));
    }//GEN-LAST:event_btnStartExamMouseEntered

    private void btnStartExamMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStartExamMouseExited
        btnStartExam.setBackground(Color.WHITE);
        btnStartExam.setForeground(new Color(51, 204, 255));
        btnStartExam.setBorder(BorderFactory.createLineBorder(new Color(51, 204, 255)));
    }//GEN-LAST:event_btnStartExamMouseExited

    private void lbTitleExamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbTitleExamMouseClicked

    }//GEN-LAST:event_lbTitleExamMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnStartExam;
    private javax.swing.JLabel lbNumberQuestions;
    private javax.swing.JLabel lbSubject;
    private javax.swing.JLabel lbTime;
    private javax.swing.JLabel lbTitleExam;
    // End of variables declaration//GEN-END:variables
}
