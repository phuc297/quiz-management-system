package GUI.teacherView;

import BUS.TeacherBUS;
import java.awt.Color;
import javax.swing.JComponent;
import GUI.events.MenuClickListener;
import DTO.AccountDTO;
import DTO.TeacherDTO;
import java.awt.BorderLayout;
import java.awt.Dimension;
import GUI.events.MyEventListener;

public class FrameTeacher extends javax.swing.JFrame {

    private MyEventListener event;

    public void addLogOutEvent(MyEventListener event) {
        this.event = event;
    }
    private AccountDTO account;
    private TeacherDTO teacher;

    public FrameTeacher() {
        initComponents();
        panelTop1.setFrame(this);

        panelLayered1.setSize(getWidth(), getHeight());
        panelLayered1.setPreferredSize(new Dimension(getWidth(), getHeight()));
        setBackground(new Color(0, 0, 0, 0));

        setVisible(true);
        panelTop1.addLogOutEvent(() -> {
            event.actionPerformed();
            dispose();
        });

        panelForm1.setLayout(new BorderLayout());
    }

    public void setAccount(AccountDTO account) {
        this.account = account;
        this.teacher = (new TeacherBUS()).getByAccount(account.getAccounId());
        init();
    }

    private void init() {
        panelMenuSide.setDraggable(this);
        PanelDashboard panelDashboard = new PanelDashboard();
        setForm(panelDashboard);
        PanelClass panelClass = new PanelClass(teacher.getTeacherId());
        PanelSubject panelSubject = new PanelSubject(teacher.getTeacherId());
        PanelExam panelExam = new PanelExam(teacher.getTeacherId());
        PanelQuestion panelQuestion = new PanelQuestion(teacher.getTeacherId());
        PanelAccount panelAccount = new PanelAccount(account);

        panelMenuSide.addMenuClickListener(new MenuClickListener() {
            @Override
            public void onMenuClick(int index) {
                int i = 0;

//                if (index == i++) {
//                    setForm(panelDashboard);
//                }
                if (index == i++) {
                    setForm(panelClass);
                }
                if (index == i++) {
                    setForm(panelSubject);
                }
                if (index == i++) {
                    setForm(panelExam);
                }
                if (index == i++) {
                    setForm(panelQuestion);
                }
                if (index == i++) {
                    setForm(panelAccount);
                }
            }

        });
    }

    private void setForm(JComponent com) {
        panelForm1.removeAll();
        panelForm1.add(com, BorderLayout.CENTER);
        panelForm1.repaint();
        panelForm1.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelLayered1 = new GUI.component.PanelLayered();
        panelMenuSide = new GUI.teacherView.MenuTeacher();
        panelTop1 = new GUI.component.PanelHeader();
        panelForm1 = new GUI.component.PanelForm();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelLayered1.setPreferredSize(new java.awt.Dimension(1400, 800));

        javax.swing.GroupLayout panelForm1Layout = new javax.swing.GroupLayout(panelForm1);
        panelForm1.setLayout(panelForm1Layout);
        panelForm1Layout.setHorizontalGroup(
            panelForm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1016, Short.MAX_VALUE)
        );
        panelForm1Layout.setVerticalGroup(
            panelForm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 758, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelLayered1Layout = new javax.swing.GroupLayout(panelLayered1);
        panelLayered1.setLayout(panelLayered1Layout);
        panelLayered1Layout.setHorizontalGroup(
            panelLayered1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayered1Layout.createSequentialGroup()
                .addComponent(panelMenuSide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(panelLayered1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelTop1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelLayered1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(panelForm1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(57, Short.MAX_VALUE))))
        );
        panelLayered1Layout.setVerticalGroup(
            panelLayered1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMenuSide, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
            .addGroup(panelLayered1Layout.createSequentialGroup()
                .addComponent(panelTop1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(panelForm1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelLayered1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelLayered1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameTeacher().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.component.PanelForm panelForm1;
    private GUI.component.PanelLayered panelLayered1;
    private GUI.teacherView.MenuTeacher panelMenuSide;
    private GUI.component.PanelHeader panelTop1;
    // End of variables declaration//GEN-END:variables
}
