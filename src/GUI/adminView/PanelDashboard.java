package GUI.adminView;

import BUS.ClassBUS;
import BUS.ExamBUS;
import BUS.QuestionBUS;
import BUS.StudentBUS;
import BUS.SubjectBUS;
import BUS.TeacherBUS;
import java.awt.Color;
import GUI.swing.ModelCard;
import java.awt.FlowLayout;

public class PanelDashboard extends javax.swing.JPanel {

    private int teachers;
    private int students;
    private int questions;
    private int exams;
    private int classes;
    private int subjects;

    private TeacherBUS teacherBUS;
    private StudentBUS studentBUS;
    private QuestionBUS questionBUS;
    private ExamBUS examBUS;
    private ClassBUS classBUS;
    private SubjectBUS subjectBUS;

    public PanelDashboard() {
        initComponents();
        FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
        layout.setHgap(35);
        layout.setVgap(35);
        panelMain.setLayout(layout);

        teacherBUS = new TeacherBUS();
        studentBUS = new StudentBUS();
        questionBUS = new QuestionBUS();
        examBUS = new ExamBUS();
        classBUS = new ClassBUS();
        subjectBUS = new SubjectBUS();

        setData();
    }

    public void setData() {
        this.teachers = teacherBUS.getAll().size();
        this.students = studentBUS.getAll().size();
        this.questions = questionBUS.getAll().size();
        this.exams = examBUS.getAll().size();
        this.classes = classBUS.getAll().size();
        this.subjects = subjectBUS.getAll().size();
        setCard();
    }

    private void setCard() {
        card1.setModel(new ModelCard("students-card", "Số học sinh", Integer.toString(students), new Color(255, 204, 153)));
        card2.setModel(new ModelCard("teacher-card", "Số giáo viên", Integer.toString(teachers), Color.decode("#5e87b8")));
        card3.setModel(new ModelCard("books-card", "Số môn hoc", Integer.toString(subjects), Color.decode("#83cee0")));
        card4.setModel(new ModelCard("class-card", "Số lớp học", Integer.toString(classes), Color.decode("#f2a6a6")));
        card5.setModel(new ModelCard("exam-card", "Số kì thi", Integer.toString(exams), Color.decode("#00cc66")));
        card6.setModel(new ModelCard("light-card", "Số câu hỏi", Integer.toString(questions), Color.decode("#fa4659")));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMain = new javax.swing.JPanel();
        card2 = new GUI.component.CardSummary();
        card1 = new GUI.component.CardSummary();
        card3 = new GUI.component.CardSummary();
        card4 = new GUI.component.CardSummary();
        card5 = new GUI.component.CardSummary();
        card6 = new GUI.component.CardSummary();

        setMaximumSize(new java.awt.Dimension(1000, 2147483647));
        setOpaque(false);

        panelMain.setMaximumSize(new java.awt.Dimension(1000, 65651561));
        panelMain.add(card2);
        panelMain.add(card1);
        panelMain.add(card3);
        panelMain.add(card4);
        panelMain.add(card5);
        panelMain.add(card6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelMain, javax.swing.GroupLayout.PREFERRED_SIZE, 981, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelMain, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(390, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.component.CardSummary card1;
    private GUI.component.CardSummary card2;
    private GUI.component.CardSummary card3;
    private GUI.component.CardSummary card4;
    private GUI.component.CardSummary card5;
    private GUI.component.CardSummary card6;
    private javax.swing.JPanel panelMain;
    // End of variables declaration//GEN-END:variables
}
