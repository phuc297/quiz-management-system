package GUI;

import BUS.Role;
import BUS.LoginBUS;
import DTO.AccountDTO;
import UTILS.Cons;
import java.awt.Image;
import javax.swing.ImageIcon;
import GUI.adminView.FrameAdmin;
import GUI.studentView.FrameStudent;
import GUI.teacherView.FrameTeacher;

public class FrameLogin extends javax.swing.JFrame {

    private ImageIcon icon;
    private Image image;
    private Image scaledImage;

    private static final int WIDTH = 1010;
    private static final int HEIGHT = 625;
    private LoginBUS loginBUS;

    public FrameLogin() {
        initComponents();
        loginBUS = new LoginBUS();
        
        myInitComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelContain = new javax.swing.JPanel();
        panel_Right = new javax.swing.JPanel();
        txtUsername = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        cbxShowpassword = new javax.swing.JRadioButton();
        lbRegister = new javax.swing.JLabel();
        lbPicture = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btn_min = new javax.swing.JButton();
        btn_exit = new javax.swing.JButton();
        cbxUser = new javax.swing.JComboBox<>();
        lbAlert = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        lbLeft = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        setResizable(false);

        panelContain.setBackground(new java.awt.Color(204, 255, 255));
        panelContain.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));

        panel_Right.setBackground(new java.awt.Color(204, 255, 255));
        panel_Right.setAlignmentX(0.0F);
        panel_Right.setAlignmentY(0.0F);
        panel_Right.setMaximumSize(new java.awt.Dimension(380, 446));

        txtUsername.setText("ad");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 255));
        jLabel1.setText("Tên tài khoản");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 204, 255));
        jLabel2.setText("Mật khẩu");

        btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(0, 204, 255));
        btnLogin.setText("Đăng nhập");
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnLogin.setFocusable(false);
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        cbxShowpassword.setBackground(new java.awt.Color(204, 255, 255));
        cbxShowpassword.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cbxShowpassword.setForeground(new java.awt.Color(0, 204, 255));
        cbxShowpassword.setText("Hiển thị mật khẩu");
        cbxShowpassword.setFocusable(false);
        cbxShowpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxShowpasswordActionPerformed(evt);
            }
        });

        lbRegister.setBackground(new java.awt.Color(0, 204, 255));
        lbRegister.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        lbRegister.setForeground(new java.awt.Color(0, 204, 255));
        lbRegister.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbRegister.setText("Chưa có tài khoản? Đăng kí ngay");
        lbRegister.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbRegister.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbRegisterMouseClicked(evt);
            }
        });

        lbPicture.setBackground(new java.awt.Color(0, 0, 0));

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        btn_min.setBackground(java.awt.SystemColor.control);
        btn_min.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btn_min.setText("-");
        btn_min.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_min.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_min.setFocusable(false);
        btn_min.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_minActionPerformed(evt);
            }
        });

        btn_exit.setBackground(new java.awt.Color(255, 102, 102));
        btn_exit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_exit.setForeground(new java.awt.Color(255, 255, 255));
        btn_exit.setText("X");
        btn_exit.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_exit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_exit.setFocusable(false);
        btn_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_min, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btn_min, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        cbxUser.setBackground(java.awt.SystemColor.control);
        cbxUser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Giáo Viên", "Học sinh" }));
        cbxUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxUserActionPerformed(evt);
            }
        });

        lbAlert.setBackground(new java.awt.Color(0, 204, 255));
        lbAlert.setFont(new java.awt.Font("Segoe UI", 2, 13)); // NOI18N
        lbAlert.setForeground(new java.awt.Color(255, 102, 102));
        lbAlert.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbAlert.setText("Sai thông tin đăng nhập");
        lbAlert.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbAlert.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        txtPassword.setText("ad");

        javax.swing.GroupLayout panel_RightLayout = new javax.swing.GroupLayout(panel_Right);
        panel_Right.setLayout(panel_RightLayout);
        panel_RightLayout.setHorizontalGroup(
            panel_RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_RightLayout.createSequentialGroup()
                .addGap(0, 60, Short.MAX_VALUE)
                .addGroup(panel_RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_RightLayout.createSequentialGroup()
                        .addGroup(panel_RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbRegister, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panel_RightLayout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel_RightLayout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtPassword))
                            .addComponent(cbxShowpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxUser, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbAlert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(50, 50, 50))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_RightLayout.createSequentialGroup()
                        .addComponent(lbPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96))))
        );
        panel_RightLayout.setVerticalGroup(
            panel_RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_RightLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cbxUser, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(panel_RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel_RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(cbxShowpassword)
                .addGap(18, 18, 18)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbAlert)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbRegister)
                .addGap(32, 32, 32))
        );

        lbLeft.setBackground(new java.awt.Color(0, 204, 255));
        lbLeft.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelContainLayout = new javax.swing.GroupLayout(panelContain);
        panelContain.setLayout(panelContainLayout);
        panelContainLayout.setHorizontalGroup(
            panelContainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContainLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(lbLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panel_Right, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        panelContainLayout.setVerticalGroup(
            panelContainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbLeft, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE)
            .addGroup(panelContainLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(panel_Right, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(panelContain, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void myInitComponents() {
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        btnLogin.setBackground(new java.awt.Color(255, 255, 255));

        ImageLoader.loadScaledImageToJLabel(lbPicture, lbPicture.getWidth(), lbPicture.getHeight(), Cons.IMAGE_PATH + "login.png");
        ImageLoader.loadScaledImageToJLabel(lbLeft, lbLeft.getWidth(), lbLeft.getHeight(), Cons.IMAGE_PATH + "bg5.jpg");

        lbAlert.setVisible(false);
        setVisible(true);
        if (cbxUser.getSelectedIndex() == 0) {
            txtUsername.setText("ad");
            txtPassword.setText("ad");
        }
        if (cbxUser.getSelectedIndex() == 1) {
            txtUsername.setText("teacher1");
            txtPassword.setText("pass1");
        }
        if (cbxUser.getSelectedIndex() == 2) {
            txtUsername.setText("student1");
            txtPassword.setText("pass1");
        }
    }

    private void cbxShowpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxShowpasswordActionPerformed
        if (cbxShowpassword.isSelected())
            txtPassword.setEchoChar((char) 0);
        else
            txtPassword.setEchoChar('\u2022');
    }//GEN-LAST:event_cbxShowpasswordActionPerformed

    private void btn_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btn_exitActionPerformed

    private void btn_minActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_minActionPerformed

    }//GEN-LAST:event_btn_minActionPerformed

    private void cbxUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxUserActionPerformed
        if (cbxUser.getSelectedIndex() == 0) {
            txtUsername.setText("ad");
            txtPassword.setText("ad");
        }
        if (cbxUser.getSelectedIndex() == 1) {
            txtUsername.setText("teacher1");
            txtPassword.setText("pass1");
        }
        if (cbxUser.getSelectedIndex() == 2) {
            txtUsername.setText("student1");
            txtPassword.setText("pass1");
        }
    }//GEN-LAST:event_cbxUserActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        if (cbxUser.getSelectedIndex() == 0) {
            if (loginBUS.checkLogin(Role.ADMIN.toString(), txtUsername.getText(), txtPassword.getText()) != null) {
                FrameAdmin adminFrame = new FrameAdmin();
                adminFrame.addLogOutEvent(() -> {
                    setVisible(true);
                });
                adminFrame.setVisible(true);
                setVisible(false);
                lbAlert.setVisible(false);
                return;
            }
        }
        if (cbxUser.getSelectedIndex() == 1) {
            AccountDTO account = loginBUS.checkLogin(Role.TEACHER.toString(), txtUsername.getText(), txtPassword.getText());
            if (account != null) {
                FrameTeacher teacherFrame = new FrameTeacher();
                teacherFrame.addLogOutEvent(() -> {
                    setVisible(true);
                });
                teacherFrame.setAccount(account);
                setVisible(false);
                lbAlert.setVisible(false);
                return;
            }
        }
        if (cbxUser.getSelectedIndex() == 2) {
            AccountDTO account = loginBUS.checkLogin(Role.STUDENT.toString(), txtUsername.getText(), txtPassword.getText());
            if (account != null) {
                FrameStudent studentFrame = new FrameStudent();
                studentFrame.addLogOutEvent(() -> {
                    setVisible(true);
                });
                studentFrame.setAccount(account);
                setVisible(false);
                lbAlert.setVisible(false);
                return;
            }
        }
        lbAlert.setVisible(true);
    }//GEN-LAST:event_btnLoginActionPerformed

    private void lbRegisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbRegisterMouseClicked
        FrameRegister frameRegister = new FrameRegister();
        frameRegister.setVisible(true);
        frameRegister.addEvent(() -> {
            setVisible(true);
        });
        setVisible(false);
    }//GEN-LAST:event_lbRegisterMouseClicked

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btn_exit;
    private javax.swing.JButton btn_min;
    private javax.swing.JRadioButton cbxShowpassword;
    private javax.swing.JComboBox<String> cbxUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbAlert;
    private javax.swing.JLabel lbLeft;
    private javax.swing.JLabel lbPicture;
    private javax.swing.JLabel lbRegister;
    private javax.swing.JPanel panelContain;
    private javax.swing.JPanel panel_Right;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
