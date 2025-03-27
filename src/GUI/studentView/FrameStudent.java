package GUI.studentView;

import BUS.StudentBUS;
import java.awt.Color;
import javax.swing.JComponent;
import GUI.events.MenuClickListener;
import DTO.AccountDTO;
import DTO.StudentDTO;
import GUI.events.MyEventListener;

public class FrameStudent extends javax.swing.JFrame {

    private MyEventListener event;

    public void addLogOutEvent(MyEventListener event) {
        this.event = event;
    }
    private AccountDTO account;

    public FrameStudent() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        setVisible(true);
        panelTop1.addLogOutEvent(() -> {
            event.actionPerformed();
            dispose();
        });
    }

    public void setAccount(AccountDTO account) {
        this.account = account;
        init();
    }

    private void init() {
        StudentDTO student = (new StudentBUS()).getByAccountId(account.getAccounId());
        panelMenuSide.setDraggable(this);
        PanelDashboard panelDashboard = new PanelDashboard(student, this);
        setForm(panelDashboard);
        PanelExam panelExam = new PanelExam(student.getStudentId());
        PanelAccount panelAccount = new PanelAccount(account);
        PanelClass panelClass = new PanelClass(student.getStudentId());

        panelDashboard.setData();
        panelMenuSide.addMenuClickListener(new MenuClickListener() {
            @Override
            public void onMenuClick(int index) {
                if (index == 0) {
                    setForm(panelDashboard);
                }
                if (index == 1) {
                    setForm(panelClass);
                }
                if (index == 2) {
                    if (panelDashboard.isExam()) {
                        panelExam.setData();
                    }
                    setForm(panelExam);
                }
                if (index == 3) {
                    setForm(panelAccount);
                }
            }

        });
    }

    private void setForm(JComponent com) {
        panelForm1.removeAll();
        panelForm1.add(com);
        panelForm1.repaint();
        panelForm1.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelLayered1 = new GUI.component.PanelLayered();
        panelMenuSide = new GUI.studentView.MenuStudent();
        panelTop1 = new GUI.component.PanelHeader();
        panelForm1 = new GUI.component.PanelForm();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        panelForm1.setBackground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout panelLayered1Layout = new javax.swing.GroupLayout(panelLayered1);
        panelLayered1.setLayout(panelLayered1Layout);
        panelLayered1Layout.setHorizontalGroup(
            panelLayered1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayered1Layout.createSequentialGroup()
                .addComponent(panelMenuSide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelLayered1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelTop1, javax.swing.GroupLayout.DEFAULT_SIZE, 1223, Short.MAX_VALUE)
                    .addGroup(panelLayered1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(panelForm1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(5, 5, 5))))
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
            .addComponent(panelLayered1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelLayered1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameStudent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.component.PanelForm panelForm1;
    private GUI.component.PanelLayered panelLayered1;
    private GUI.studentView.MenuStudent panelMenuSide;
    private GUI.component.PanelHeader panelTop1;
    // End of variables declaration//GEN-END:variables
}
