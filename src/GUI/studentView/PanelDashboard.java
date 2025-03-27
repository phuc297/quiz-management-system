package GUI.studentView;

import BUS.ExamBUS;
import java.util.ArrayList;
import DTO.ExamDTO;
import DTO.StudentDTO;
import GUI.events.StartExamListener;
import GUI.swing.ExamItem;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PanelDashboard extends javax.swing.JPanel {

    private StudentDTO student;
    private ExamBUS examBUS;
    private JFrame frame;
    private int numberExams;
    private boolean isExam;

    public PanelDashboard(StudentDTO student, JFrame frame) {
        initComponents();
        this.student = student;
        this.frame = frame;
        isExam = false;
        examBUS = new ExamBUS();

        setLayout(new BorderLayout());
        add(jLabel1, BorderLayout.NORTH);
        add(panelMain, BorderLayout.CENTER);
        panelExamItem.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 15));

        FlowLayout layout = new FlowLayout();
        layout.setHgap(35);
        layout.setVgap(35);
        panelExamItem.setLayout(layout);

        setData();
    }

    public void setData() {
        panelExamItem.removeAll();
        ArrayList<ExamDTO> exams = examBUS.getAllOfStudent(student.getStudentId());
        numberExams = exams.size();
        for (ExamDTO exam : exams) {
            ExamItem examItem = new ExamItem(exam);
            examItem.addStartExamListener(new StartExamListener() {
                @Override
                public void start(ExamDTO exam) {
                    FrameExam frameExam = new FrameExam();
                    frameExam.addEvent(() -> {
                        isExam = true;
                        panelExamItem.remove(examItem);
                        numberExams--;
                        if (numberExams <= 0) {
                            setNoExam();
                        }
                    });
                    frameExam.addEventClose(() -> {
                        frame.setVisible(true);
                    });
                    frameExam.setInfoExam(exam, student);
                    frame.setVisible(false);
                    frameExam.setVisible(true);
                }

            });
            panelExamItem.add(examItem);
        }
        if (numberExams <= 0) {
            setNoExam();
        }
    }

    private void setNoExam() {
        JLabel lb = new JLabel("Không có kì thi nào đang diễn ra");
        lb.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb.setForeground(new java.awt.Color(51, 204, 255));
        lb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb.setSize(lb.getWidth(), lb.getHeight() * 3);
        panelExamItem.removeAll();
        panelExamItem.add(lb);
    }

    public boolean isExam() {
        return isExam;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        panelMain = new javax.swing.JPanel();
        panelExamItem = new javax.swing.JPanel();

        setBackground(new java.awt.Color(153, 0, 51));
        setOpaque(false);

        jLabel1.setForeground(new java.awt.Color(51, 204, 255));
        jLabel1.setText("Các kì thi đang diễn ra");
        jLabel1.setToolTipText("");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel1.setOpaque(true);

        javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
        panelMain.setLayout(panelMainLayout);
        panelMainLayout.setHorizontalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addContainerGap(69, Short.MAX_VALUE)
                .addComponent(panelExamItem, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
        );
        panelMainLayout.setVerticalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(panelExamItem, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel panelExamItem;
    private javax.swing.JPanel panelMain;
    // End of variables declaration//GEN-END:variables
}
