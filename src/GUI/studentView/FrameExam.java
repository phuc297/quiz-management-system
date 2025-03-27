package GUI.studentView;

import BUS.AnswerBUS;
import BUS.QuestionBUS;
import BUS.ResultBUS;
import DTO.AnswerDTO;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import DTO.ExamDTO;
import DTO.QuestionDTO;
import DTO.ResultDTO;
import DTO.StudentDTO;
import GUI.Choose;
import GUI.component.ButtonQuestion;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.time.Duration;
import UTILS.TimeUtils;
import GUI.events.MyEventListener;
import java.awt.BorderLayout;

public class FrameExam extends javax.swing.JFrame {

    private MyEventListener event;
    private MyEventListener eventClose;

    public void addEvent(MyEventListener event) {
        this.event = event;
    }

    public void addEventClose(MyEventListener event) {
        this.eventClose = event;
    }
    private ExamDTO exam;
    private StudentDTO student;
    private ArrayList<QuestionDTO> questions;
    private ArrayList<ButtonQuestion> buttons;
    private ResultBUS resultBUS;
    private AnswerBUS answerBUS;
    private ButtonQuestion selectedButton;
    private int selectedQuestion = 0;
    private Duration duration;
    private Timer timer;
    private int examTime;

    public FrameExam() {
        initComponents();
        panelQuestionButtons.setLayout(new FlowLayout(FlowLayout.LEFT));
        resultBUS = new ResultBUS();
        answerBUS = new AnswerBUS();

        setLayout(new BorderLayout());
        add(panelHeader1, BorderLayout.NORTH);
        add(panelLayered1, BorderLayout.CENTER);
        panelHeader1.setFrame(this);
        panelHeader1.setDraggable(this);
        panelHeader1.addLogOutEvent(() -> {
            eventClose.actionPerformed();
            dispose();
        });
    }

    public void setInfoExam(ExamDTO exam, StudentDTO student) {
        this.exam = exam;
        this.student = student;
        examTime = exam.getDuration() * 60;
        questions = (new QuestionBUS()).getQuestionsOfExam(exam.getExamId());
        lbTittleExam.setText("Tên kì thi: " + exam.getExamName());
        lbId.setText("Mã học sinh: " + Integer.toString(student.getStudentId()));
        lbName.setText("Tên học sinh: " + student.getName());
        buttons = new ArrayList<>();
        int i = 1;

        for (QuestionDTO question : questions) {
            String tittle = "Câu " + Integer.toString(i++);
            Dimension d = new Dimension(panelQuestionButtons.getWidth() / 5 - 5, 30);
            ButtonQuestion btn = new ButtonQuestion(tittle, d);
            btn.putClientProperty("choose", (Object) new Choose(tittle, question.getQuestionId()));
            btn.addActionListener(new ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    selectedButton = btn;
                    selectedQuestion = questions.indexOf(question);
                    lbQuestion.setText(tittle + ": " + question.getQuestionText());
                    ckbOptionA.setText("<html>" + "A. " + question.getOptionA() + "<html>");
                    ckbOptionB.setText("<html>" + "B. " + question.getOptionB() + "<html>");
                    ckbOptionC.setText("<html>" + "C. " + question.getOptionC() + "<html>");
                    ckbOptionD.setText("<html>" + "D. " + question.getOptionD() + "<html>");

                    Choose c = (Choose) btn.getClientProperty("choose");
                    ckbOptionA.setSelected(c.isOptionA());
                    ckbOptionB.setSelected(c.isOptionB());
                    ckbOptionC.setSelected(c.isOptionC());
                    ckbOptionD.setSelected(c.isOptionD());

                    if (c.isOptionA()) {
                        btn.setText(tittle + "A");
                    }
                    if (c.isOptionB()) {
                        btn.setText(tittle + "B");
                    }
                    if (c.isOptionC()) {
                        btn.setText(tittle + "C");
                    }
                    if (c.isOptionD()) {
                        btn.setText(tittle + "D");
                    }
                }
            });
            buttons.add(btn);
            panelQuestionButtons.add(btn);
        }

        selectedButton = buttons.get(0);
        lbQuestion.setText("Câu 1: " + questions.get(0).getQuestionText());
        ckbOptionA.setText("<html>" + "A. " + questions.get(0).getOptionA() + "<html>");
        ckbOptionB.setText("<html>" + "B. " + questions.get(0).getOptionB() + "<html>");
        ckbOptionC.setText("<html>" + "C. " + questions.get(0).getOptionC() + "<html>");
        ckbOptionD.setText("<html>" + "D. " + questions.get(0).getOptionD() + "<html>");

        startTimer();
    }

    private void startTimer() {
        duration = Duration.ofSeconds(examTime);
        lbTime.setText(TimeUtils.durationToString(duration));
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                duration = duration.minusSeconds(1);
                lbTime.setText(TimeUtils.durationToString(duration));
                if (duration.isZero()) {
                    JOptionPane.showMessageDialog(null, "Đã hết thời gian làm bài!");
                    ((Timer) e.getSource()).stop();
                    submitExam();
                }
            }
        }
        );
        timer.start();
    }

    private boolean checkAnswer() {
        for (ButtonQuestion btn : buttons) {
            Choose c = (Choose) btn.getClientProperty("choose");
            if (!c.isChosen()) {
                JOptionPane.showMessageDialog(null, "Còn đáp án chưa chọn!");
                return false;
            }
        }
        return true;
    }

    private void submitExam() {
        btnSubmit.setEnabled(false);
        ArrayList<AnswerDTO> answers = new ArrayList<AnswerDTO>();
        for (ButtonQuestion btn : buttons) {
            Choose c = (Choose) btn.getClientProperty("choose");
            answers.add(new AnswerDTO(exam.getExamId(), student.getStudentId(), c.getQuestionId(), c.getOption()));
        }
        resultBUS.insert(student.getStudentId(), exam.getExamId());
        answerBUS.insertAnswer2(answers, exam.getExamId());
        answerBUS.submitExam(exam.getExamId(), student.getStudentId());
        ResultDTO result = resultBUS.get(student.getStudentId(), exam.getExamId());
        ResultFrame resultFrame = new ResultFrame();
        resultFrame.setData(result);
        resultFrame.setVisible(true);
        resultFrame.addEvent(() -> {
            event.actionPerformed();
            eventClose.actionPerformed();
            dispose();
        });
        for (AnswerDTO a : answers) {
            System.out.println(a.getAnswer());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelHeader1 = new GUI.component.PanelHeader();
        panelLayered1 = new GUI.component.PanelLayered();
        btnSubmit = new javax.swing.JButton();
        panelQuestionButtons = new GUI.component.PanelRoundRect();
        panelRoundRect1 = new GUI.component.PanelRoundRect();
        lbQuestion = new javax.swing.JLabel();
        ckbOptionA = new GUI.component.Checkbox();
        ckbOptionC = new GUI.component.Checkbox();
        ckbOptionD = new GUI.component.Checkbox();
        ckbOptionB = new GUI.component.Checkbox();
        lbTittleExam = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lbTime = new javax.swing.JLabel();
        lbId = new javax.swing.JLabel();
        lbName = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1500, 800));
        setResizable(false);

        btnSubmit.setBackground(new java.awt.Color(255, 255, 255));
        btnSubmit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSubmit.setForeground(new java.awt.Color(8, 169, 74));
        btnSubmit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/submit.png"))); // NOI18N
        btnSubmit.setText("Nộp bài");
        btnSubmit.setFocusable(false);
        btnSubmit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSubmitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSubmitMouseExited(evt);
            }
        });
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        panelQuestionButtons.setBackground(new java.awt.Color(238, 238, 238));

        javax.swing.GroupLayout panelQuestionButtonsLayout = new javax.swing.GroupLayout(panelQuestionButtons);
        panelQuestionButtons.setLayout(panelQuestionButtonsLayout);
        panelQuestionButtonsLayout.setHorizontalGroup(
            panelQuestionButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );
        panelQuestionButtonsLayout.setVerticalGroup(
            panelQuestionButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 424, Short.MAX_VALUE)
        );

        lbQuestion.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lbQuestion.setText("jLabel1");
        lbQuestion.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        ckbOptionA.setText("checkbox1");
        ckbOptionA.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ckbOptionA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckbOptionAActionPerformed(evt);
            }
        });

        ckbOptionC.setText("checkbox1");
        ckbOptionC.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ckbOptionC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckbOptionCActionPerformed(evt);
            }
        });

        ckbOptionD.setText("checkbox1");
        ckbOptionD.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ckbOptionD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckbOptionDActionPerformed(evt);
            }
        });

        ckbOptionB.setText("checkbox1");
        ckbOptionB.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ckbOptionB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckbOptionBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRoundRect1Layout = new javax.swing.GroupLayout(panelRoundRect1);
        panelRoundRect1.setLayout(panelRoundRect1Layout);
        panelRoundRect1Layout.setHorizontalGroup(
            panelRoundRect1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundRect1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panelRoundRect1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelRoundRect1Layout.createSequentialGroup()
                        .addComponent(ckbOptionC, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ckbOptionD, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRoundRect1Layout.createSequentialGroup()
                        .addComponent(ckbOptionA, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ckbOptionB, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbQuestion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 937, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        panelRoundRect1Layout.setVerticalGroup(
            panelRoundRect1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRoundRect1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lbQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelRoundRect1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ckbOptionA, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ckbOptionB, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                .addGroup(panelRoundRect1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ckbOptionC, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ckbOptionD, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(91, 91, 91))
        );

        lbTittleExam.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbTittleExam.setForeground(new java.awt.Color(51, 204, 255));
        lbTittleExam.setText("jLabel1");
        lbTittleExam.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Thời gian còn lại");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lbTime.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbTime.setForeground(new java.awt.Color(255, 51, 51));
        lbTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTime.setText("00:20:42");

        lbId.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbId.setForeground(new java.awt.Color(51, 204, 255));
        lbId.setText("jLabel2");
        lbId.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lbName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbName.setForeground(new java.awt.Color(51, 204, 255));
        lbName.setText("jLabel2");
        lbName.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout panelLayered1Layout = new javax.swing.GroupLayout(panelLayered1);
        panelLayered1.setLayout(panelLayered1Layout);
        panelLayered1Layout.setHorizontalGroup(
            panelLayered1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayered1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayered1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayered1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelLayered1Layout.createSequentialGroup()
                        .addGroup(panelLayered1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(panelLayered1Layout.createSequentialGroup()
                                .addComponent(panelRoundRect1, javax.swing.GroupLayout.PREFERRED_SIZE, 997, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(panelQuestionButtons, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelLayered1Layout.createSequentialGroup()
                                .addGroup(panelLayered1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lbName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbTittleExam, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 887, Short.MAX_VALUE)
                                    .addComponent(lbId, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panelLayered1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                                    .addComponent(lbTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap(58, Short.MAX_VALUE))))
        );
        panelLayered1Layout.setVerticalGroup(
            panelLayered1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayered1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayered1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayered1Layout.createSequentialGroup()
                        .addComponent(lbTittleExam)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbId))
                    .addGroup(panelLayered1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbTime)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbName)
                .addGap(18, 18, 18)
                .addGroup(panelLayered1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRoundRect1, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelQuestionButtons, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelHeader1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(panelLayered1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(panelHeader1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelLayered1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void setSelectedCheckbox(boolean c1, boolean c2, boolean c3, boolean c4) {
        ckbOptionA.setSelected(c1);
        ckbOptionB.setSelected(c2);
        ckbOptionC.setSelected(c3);
        ckbOptionD.setSelected(c4);
        Choose c = (Choose) selectedButton.getClientProperty("choose");
        if (c.isChosen()) {
            selectedButton.setChosen();
        }
        String text = c.getText();
        if (c1) {
            selectedButton.setText(text + "A");
        }
        if (c2) {
            selectedButton.setText(text + "B");
        }
        if (c3) {
            selectedButton.setText(text + "C");
        }
        if (c4) {
            selectedButton.setText(text + "D");
        }
    }

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        if (checkAnswer()) {
            timer.stop();
            submitExam();
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void ckbOptionAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckbOptionAActionPerformed
        if (selectedQuestion != -1) {
            Choose c = (Choose) buttons.get(selectedQuestion).getClientProperty("choose");
            c.setOptionA();
            setSelectedCheckbox(true, false, false, false);
        }
    }//GEN-LAST:event_ckbOptionAActionPerformed

    private void ckbOptionBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckbOptionBActionPerformed
        if (selectedQuestion != -1) {
            Choose c = (Choose) buttons.get(selectedQuestion).getClientProperty("choose");
            c.setOptionB();
            setSelectedCheckbox(false, true, false, false);
        }
    }//GEN-LAST:event_ckbOptionBActionPerformed

    private void ckbOptionCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckbOptionCActionPerformed
        if (selectedQuestion != -1) {
            Choose c = (Choose) buttons.get(selectedQuestion).getClientProperty("choose");
            c.setOptionC();
            setSelectedCheckbox(false, false, true, false);
        }
    }//GEN-LAST:event_ckbOptionCActionPerformed

    private void ckbOptionDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckbOptionDActionPerformed
        if (selectedQuestion != -1) {
            Choose c = (Choose) buttons.get(selectedQuestion).getClientProperty("choose");
            c.setOptionD();
            setSelectedCheckbox(false, false, false, true);
        }
    }//GEN-LAST:event_ckbOptionDActionPerformed

    private void btnSubmitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSubmitMouseEntered
        btnSubmit.setBackground(new Color(8, 169, 74));
        btnSubmit.setForeground(Color.WHITE);
    }//GEN-LAST:event_btnSubmitMouseEntered

    private void btnSubmitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSubmitMouseExited
        btnSubmit.setBackground(Color.WHITE);
        btnSubmit.setForeground(new Color(8, 169, 74));
    }//GEN-LAST:event_btnSubmitMouseExited

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameExam().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSubmit;
    private GUI.component.Checkbox ckbOptionA;
    private GUI.component.Checkbox ckbOptionB;
    private GUI.component.Checkbox ckbOptionC;
    private GUI.component.Checkbox ckbOptionD;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbId;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lbQuestion;
    private javax.swing.JLabel lbTime;
    private javax.swing.JLabel lbTittleExam;
    private GUI.component.PanelHeader panelHeader1;
    private GUI.component.PanelLayered panelLayered1;
    private GUI.component.PanelRoundRect panelQuestionButtons;
    private GUI.component.PanelRoundRect panelRoundRect1;
    // End of variables declaration//GEN-END:variables
}
