package GUI.studentView;

import BUS.ClassBUS;
import DTO.ClassDTO;
import GUI.component.CardClass;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelClass extends javax.swing.JPanel {

    private String[] color = {"#dfbac9", "#eec5b7", "#ffcebe", "#fc8585", "#85cbd9", "#ffc86d", "#957dad", "#7787a3", "#d291bc", "#a1bfaf", "#7787a3", "#edabba"};
    private ArrayList<CardClass> cardClasses;
    private int studentId;
    private ArrayList<ClassDTO> classes;

    public PanelClass(int studentId) {
        initComponents();
        setLayout(new BorderLayout());
        add(jLabel1, BorderLayout.NORTH);
        add(panelContain, BorderLayout.CENTER);
        this.studentId = studentId;
        this.classes = (new ClassBUS()).getAllOfStudent(studentId);
        if (classes.size() > 0) {
            setData();
        } else {
            JLabel label = new JLabel("Học sinh không tham gia lớp học nào");
            label.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
            label.setForeground(new java.awt.Color(51, 204, 255));
            label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            label.setSize(label.getWidth(), label.getHeight() * 3);
            panelContain.add(label);
        }
    }

    private void setData() {
        BoxLayout layout = new BoxLayout(panelContain, BoxLayout.Y_AXIS);
        panelContain.setLayout(layout);

        
        
        int iColor = 0;
        cardClasses = new ArrayList<CardClass>();

        ArrayList<JPanel> panelsRow = new ArrayList<>();
        for (int i = 0; i < classes.size() / 4 + 1; i++) {
            panelsRow.add(new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 15)));
        }

        int index = 0;
        int countX = 0;
        for (ClassDTO c : classes) {
            CardClass cardClass = new CardClass();
            cardClass.setPreferredSize(new Dimension(270, 180));
            if (iColor >= color.length) {
                iColor = 0;
            }
            cardClass.setModel(
                    c.getClassName(),
                    c.getTeacherName(),
                    c.getSubjectName(),
                    Color.decode(color[iColor++]),
                    (new ClassBUS()).getNumberStudent(c.getClassId())
            );
            cardClasses.add(cardClass);

            panelContain.add(panelsRow.get(index));
            panelsRow.get(index).add(cardClass);

            if (countX >= 3) {
                index++;
                countX = -1;
            }
            countX++;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelContain = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1000, 32767));

        panelContain.setMaximumSize(new java.awt.Dimension(1000, 2147483647));
        panelContain.setLayout(new java.awt.GridBagLayout());

        jLabel1.setForeground(new java.awt.Color(51, 204, 255));
        jLabel1.setText("Lớp học");
        jLabel1.setToolTipText("");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel1.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelContain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 676, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelContain, javax.swing.GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel panelContain;
    // End of variables declaration//GEN-END:variables
}
