package GUI.component;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class CardClass extends javax.swing.JPanel {

    private Color backgroundColor = Color.CYAN;

    public CardClass() {
        initComponents();
        lbClassName.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lbClassName.setForeground(Color.white);
        lbTeacher.setForeground(Color.white);
        lbNumber.setForeground(Color.white);
        setPreferredSize(new Dimension(270, 180));
    }

    public void setModel(String className, String teacherName, String subject, Color color, int number) {
        lbTeacher.setText("Giáo viên: " + teacherName);
        lbClassName.setText(className);
        lbSubject.setText("Môn học: " + subject);
        lbNumber.setText("Sỉ số lớp: " + Integer.toString(number));
        this.backgroundColor = color;
    }

    public void setColor(Color color) {
        this.backgroundColor = color;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTeacher = new javax.swing.JLabel();
        lbClassName = new javax.swing.JLabel();
        lbNumber = new javax.swing.JLabel();
        lbSubject = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 153, 153));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(270, 125));

        lbTeacher.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbTeacher.setText("Nguyễn thanh bình");

        lbClassName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbClassName.setText("Xác suất thống kê 2");

        lbNumber.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbNumber.setForeground(new java.awt.Color(255, 255, 255));
        lbNumber.setText("Sỉ số lớp: 23");

        lbSubject.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbSubject.setForeground(new java.awt.Color(255, 255, 255));
        lbSubject.setText("Môn:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbNumber, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbClassName, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                    .addComponent(lbTeacher, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbSubject, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbClassName, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbSubject)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbTeacher)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbNumber)
                .addContainerGap(56, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(backgroundColor);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
        g2.setColor(new Color(255, 255, 255, 50));
        g2.fillOval(-getWidth() / 3, -getHeight() / 2, getHeight(), getHeight());
        super.paintComponent(grphcs);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbClassName;
    private javax.swing.JLabel lbNumber;
    private javax.swing.JLabel lbSubject;
    private javax.swing.JLabel lbTeacher;
    // End of variables declaration//GEN-END:variables

}
