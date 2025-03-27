package GUI.adminView;

import java.awt.Color;
import javax.swing.JComponent;
import GUI.events.MenuClickListener;
import java.awt.Dimension;
import GUI.events.MyEventListener;

public class FrameAdmin extends javax.swing.JFrame {

    private MyEventListener event;

    public void addLogOutEvent(MyEventListener event) {
        this.event = event;
    }

    public FrameAdmin() {
        initComponents();
        setSize(getPreferredSize());
        panelTop.setFrame(this);
        setBackground(new Color(1, 0, 0, 0));
        init();
        panelTop.addLogOutEvent(() -> {
            event.actionPerformed();
            dispose();
        });
        panelForm.setPreferredSize(new Dimension(this.getWidth() - menuSide.getWidth() - 10, panelForm.getHeight()));
        panelForm.setSize(new Dimension(this.getWidth() - menuSide.getWidth() - 10, panelForm.getHeight()));

    }

    private void init() {
        menuSide.setDraggable(this);
        PanelDashboard panelDashboard = new PanelDashboard();
        setForm(panelDashboard);
        PanelTeacher panelTeacher = new PanelTeacher();
        PanelStudent panelStudent = new PanelStudent();
        PanelSubject panelSubject = new PanelSubject();
        PanelClass panelClass = new PanelClass();
        PanelExam panelExam = new PanelExam();
        PanelQuestion panelQuestion = new PanelQuestion();
        PanelAccount panelAccount = new PanelAccount();

        menuSide.addMenuClickListener(new MenuClickListener() {
            @Override
            public void onMenuClick(int index) {
                if (index == 0) {
                    setForm(panelDashboard);
                }
                if (index == 1) {
                    setForm(panelTeacher);
                }
                if (index == 2) {
                    setForm(panelStudent);
                }
                if (index == 3) {
                    setForm(panelSubject);
                }
                if (index == 4) {
                    setForm(panelClass);
                }
                if (index == 5) {
                    setForm(panelExam);
                }
                if (index == 6) {
                    setForm(panelQuestion);
                }
                if (index == 7) {
                    setForm(panelAccount);
                }
            }

        });
    }

    private void setForm(JComponent component) {
        panelForm.removeAll();
        panelForm.add(component);
        panelForm.repaint();
        panelForm.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelLayered = new GUI.component.PanelLayered();
        menuSide = new GUI.adminView.MenuAdmin();
        panelTop = new GUI.component.PanelHeader();
        panelForm = new GUI.component.PanelForm();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelLayered.setPreferredSize(new java.awt.Dimension(1400, 800));

        panelForm.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelLayeredLayout = new javax.swing.GroupLayout(panelLayered);
        panelLayered.setLayout(panelLayeredLayout);
        panelLayeredLayout.setHorizontalGroup(
            panelLayeredLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayeredLayout.createSequentialGroup()
                .addComponent(menuSide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(panelLayeredLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayeredLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(panelForm, javax.swing.GroupLayout.PREFERRED_SIZE, 1016, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 57, Short.MAX_VALUE))
                    .addComponent(panelTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        panelLayeredLayout.setVerticalGroup(
            panelLayeredLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuSide, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
            .addGroup(panelLayeredLayout.createSequentialGroup()
                .addComponent(panelTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(panelForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelLayered, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelLayered, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.adminView.MenuAdmin menuSide;
    private GUI.component.PanelForm panelForm;
    private GUI.component.PanelLayered panelLayered;
    private GUI.component.PanelHeader panelTop;
    // End of variables declaration//GEN-END:variables
}
