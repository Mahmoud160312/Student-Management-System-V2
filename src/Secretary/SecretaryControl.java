/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Secretary;

import Login.Login;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import static newatomicstudent.functions.changeBtnCAFFalse;
import static newatomicstudent.functions.*;

/**
 *
 * @author mahmo
 */
public class SecretaryControl extends javax.swing.JFrame {

    // declare images
    Image image;                    // this will be used for scalling the images

    public SecretaryControl() {
        initComponents();
        setIcon();
        // this to open in full screen
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        speedUpScrollPane(sp_secretaryControl);
        changeCurssorWhenEnterButton(btn_apsence);
        changeCurssorWhenEnterButton(btn_Setting);
        changeCurssorWhenEnterButton(btn_exam);
        changeCurssorWhenEnterButton(btn_groups);
        changeCurssorWhenEnterButton(btn_logout);
        changeCurssorWhenEnterButton(btn_money);
        changeCurssorWhenEnterButton(btn_quiz);
        changeCurssorWhenEnterButton(btn_reports);
        changeCurssorWhenEnterButton(btn_studentMangement);
        changeCurssorWhenEnterButton(btn_statistics);
    }

    public void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(returnYourImageURL())));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sp_secretaryControl = new javax.swing.JScrollPane();
        pl_background = new javax.swing.JPanel();
        lb_title = new javax.swing.JLabel();
        pl_firstButtonsControl = new javax.swing.JPanel();
        btn_exam = new javax.swing.JButton();
        btn_quiz = new javax.swing.JButton();
        btn_apsence = new javax.swing.JButton();
        btn_studentMangement = new javax.swing.JButton();
        btn_logout = new javax.swing.JButton();
        btn_Setting = new javax.swing.JButton();
        pl_secondButtonsControl = new javax.swing.JPanel();
        btn_statistics = new javax.swing.JButton();
        btn_reports = new javax.swing.JButton();
        btn_money = new javax.swing.JButton();
        btn_groups = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pl_background.setBackground(new java.awt.Color(255, 255, 255));
        pl_background.setAutoscrolls(true);

        lb_title.setFont(new java.awt.Font("Cairo", 0, 36)); // NOI18N
        lb_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_title.setText("القائمة الرئيسية");

        pl_firstButtonsControl.setBackground(new java.awt.Color(255, 255, 255));
        pl_firstButtonsControl.setAutoscrolls(true);
        pl_firstButtonsControl.setLayout(new java.awt.GridLayout(1, 5, 10, 10));

        btn_exam.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        btn_exam.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/exams-icon.png"))); // NOI18N
        btn_exam.setText("امتحانات");
        btn_exam.setContentAreaFilled(false);
        btn_exam.setIconTextGap(16);
        btn_exam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_examMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_examMouseExited(evt);
            }
        });
        btn_exam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_examActionPerformed(evt);
            }
        });
        pl_firstButtonsControl.add(btn_exam);

        btn_quiz.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        btn_quiz.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/ass-icon.png"))); // NOI18N
        btn_quiz.setText("التسميعات");
        btn_quiz.setContentAreaFilled(false);
        btn_quiz.setIconTextGap(16);
        btn_quiz.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_quizMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_quizMouseExited(evt);
            }
        });
        btn_quiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_quizActionPerformed(evt);
            }
        });
        pl_firstButtonsControl.add(btn_quiz);

        btn_apsence.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        btn_apsence.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/ap-icon.png"))); // NOI18N
        btn_apsence.setText("غياب و حضور");
        btn_apsence.setContentAreaFilled(false);
        btn_apsence.setIconTextGap(16);
        btn_apsence.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_apsenceMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_apsenceMouseExited(evt);
            }
        });
        btn_apsence.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_apsenceActionPerformed(evt);
            }
        });
        pl_firstButtonsControl.add(btn_apsence);

        btn_studentMangement.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        btn_studentMangement.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/sm-icon.png"))); // NOI18N
        btn_studentMangement.setText("ادارة الطلاب");
        btn_studentMangement.setContentAreaFilled(false);
        btn_studentMangement.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_studentMangement.setIconTextGap(20);
        btn_studentMangement.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_studentMangementMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_studentMangementMouseExited(evt);
            }
        });
        btn_studentMangement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_studentMangementActionPerformed(evt);
            }
        });
        pl_firstButtonsControl.add(btn_studentMangement);

        btn_logout.setBackground(new java.awt.Color(204, 204, 204));
        btn_logout.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        btn_logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/log-out-btn.png"))); // NOI18N
        btn_logout.setText("تسجيل الخروج");
        btn_logout.setContentAreaFilled(false);
        btn_logout.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btn_logout.setIconTextGap(16);
        btn_logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_logoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_logoutMouseExited(evt);
            }
        });
        btn_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logoutActionPerformed(evt);
            }
        });

        btn_Setting.setBackground(new java.awt.Color(19, 64, 93));
        btn_Setting.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        btn_Setting.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/Settings3.png"))); // NOI18N
        btn_Setting.setText("الاعدادات");
        btn_Setting.setContentAreaFilled(false);
        btn_Setting.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btn_Setting.setIconTextGap(16);
        btn_Setting.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_SettingMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_SettingMouseExited(evt);
            }
        });
        btn_Setting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SettingActionPerformed(evt);
            }
        });

        pl_secondButtonsControl.setBackground(new java.awt.Color(255, 255, 255));
        pl_secondButtonsControl.setAutoscrolls(true);
        pl_secondButtonsControl.setMinimumSize(new java.awt.Dimension(1018, 99));
        pl_secondButtonsControl.setLayout(new java.awt.GridLayout(1, 3, 10, 10));

        btn_statistics.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        btn_statistics.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/statistics.png"))); // NOI18N
        btn_statistics.setText("الاحصائيات");
        btn_statistics.setContentAreaFilled(false);
        btn_statistics.setIconTextGap(20);
        btn_statistics.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_statisticsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_statisticsMouseExited(evt);
            }
        });
        btn_statistics.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_statisticsActionPerformed(evt);
            }
        });
        pl_secondButtonsControl.add(btn_statistics);

        btn_reports.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        btn_reports.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/re-icon.png"))); // NOI18N
        btn_reports.setText("تقارير");
        btn_reports.setContentAreaFilled(false);
        btn_reports.setIconTextGap(20);
        btn_reports.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_reportsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_reportsMouseExited(evt);
            }
        });
        btn_reports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reportsActionPerformed(evt);
            }
        });
        pl_secondButtonsControl.add(btn_reports);

        btn_money.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        btn_money.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/bills-icon.png"))); // NOI18N
        btn_money.setText("المصاريف");
        btn_money.setContentAreaFilled(false);
        btn_money.setIconTextGap(16);
        btn_money.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_moneyMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_moneyMouseExited(evt);
            }
        });
        btn_money.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_moneyActionPerformed(evt);
            }
        });
        pl_secondButtonsControl.add(btn_money);

        btn_groups.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        btn_groups.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/gp-icon.png"))); // NOI18N
        btn_groups.setText("الفرق و المجموعات");
        btn_groups.setContentAreaFilled(false);
        btn_groups.setIconTextGap(10);
        btn_groups.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_groupsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_groupsMouseExited(evt);
            }
        });
        btn_groups.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_groupsActionPerformed(evt);
            }
        });
        pl_secondButtonsControl.add(btn_groups);

        javax.swing.GroupLayout pl_backgroundLayout = new javax.swing.GroupLayout(pl_background);
        pl_background.setLayout(pl_backgroundLayout);
        pl_backgroundLayout.setHorizontalGroup(
            pl_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pl_backgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pl_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pl_backgroundLayout.createSequentialGroup()
                        .addGap(475, 475, 475)
                        .addComponent(lb_title, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                        .addGap(257, 257, 257)
                        .addComponent(btn_Setting, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(pl_secondButtonsControl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pl_firstButtonsControl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        pl_backgroundLayout.setVerticalGroup(
            pl_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pl_backgroundLayout.createSequentialGroup()
                .addGroup(pl_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pl_backgroundLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(lb_title))
                    .addGroup(pl_backgroundLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btn_Setting, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(51, 51, 51)
                .addComponent(pl_firstButtonsControl, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(pl_secondButtonsControl, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(142, 142, 142)
                .addComponent(btn_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        sp_secretaryControl.setViewportView(pl_background);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp_secretaryControl, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp_secretaryControl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_moneyMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_moneyMouseEntered
        changeBtnCAFTrue(btn_money);
    }//GEN-LAST:event_btn_moneyMouseEntered

    private void btn_moneyMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_moneyMouseExited
        changeBtnCAFFalse(btn_money);
    }//GEN-LAST:event_btn_moneyMouseExited

    private void btn_quizMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_quizMouseEntered
        changeBtnCAFTrue(btn_quiz);
    }//GEN-LAST:event_btn_quizMouseEntered

    private void btn_quizMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_quizMouseExited
        changeBtnCAFFalse(btn_quiz);
    }//GEN-LAST:event_btn_quizMouseExited

    private void btn_apsenceMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_apsenceMouseEntered
        changeBtnCAFTrue(btn_apsence);
    }//GEN-LAST:event_btn_apsenceMouseEntered

    private void btn_apsenceMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_apsenceMouseExited
        changeBtnCAFFalse(btn_apsence);
    }//GEN-LAST:event_btn_apsenceMouseExited

    private void btn_studentMangementMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_studentMangementMouseEntered
        changeBtnCAFTrue(btn_studentMangement);
    }//GEN-LAST:event_btn_studentMangementMouseEntered

    private void btn_groupsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_groupsMouseEntered
        changeBtnCAFTrue(btn_groups);
    }//GEN-LAST:event_btn_groupsMouseEntered

    private void btn_groupsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_groupsMouseExited
        changeBtnCAFFalse(btn_groups);
    }//GEN-LAST:event_btn_groupsMouseExited

    private void btn_examMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_examMouseEntered
        changeBtnCAFTrue(btn_exam);
    }//GEN-LAST:event_btn_examMouseEntered

    private void btn_reportsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_reportsMouseEntered
        changeBtnCAFTrue(btn_reports);
    }//GEN-LAST:event_btn_reportsMouseEntered

    private void btn_SettingMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_SettingMouseEntered
        changeBtnCAFTrue(btn_Setting);
    }//GEN-LAST:event_btn_SettingMouseEntered

    private void btn_examMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_examMouseExited
        changeBtnCAFFalse(btn_exam);
    }//GEN-LAST:event_btn_examMouseExited

    private void btn_reportsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_reportsMouseExited
        changeBtnCAFFalse(btn_reports);
    }//GEN-LAST:event_btn_reportsMouseExited

    private void btn_SettingMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_SettingMouseExited
        changeBtnCAFFalse(btn_Setting);
    }//GEN-LAST:event_btn_SettingMouseExited

    private void btn_studentMangementMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_studentMangementMouseExited
        changeBtnCAFFalse(btn_studentMangement);
    }//GEN-LAST:event_btn_studentMangementMouseExited

    private void btn_logoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_logoutMouseEntered
        changeBtnCAFTrue(btn_logout);
        btn_logout.setForeground(Color.red);
    }//GEN-LAST:event_btn_logoutMouseEntered

    private void btn_logoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_logoutMouseExited
        changeBtnCAFFalse(btn_logout);
        btn_logout.setForeground(new Color(19, 64, 93));
    }//GEN-LAST:event_btn_logoutMouseExited

    private void btn_studentMangementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_studentMangementActionPerformed
        this.setVisible(false);
        StudentManagement studentManagement = new StudentManagement();
        if (this.getExtendedState() != 0) {
            studentManagement.setExtendedState(JFrame.MAXIMIZED_BOTH);
        }
        studentManagement.setVisible(true);
    }//GEN-LAST:event_btn_studentMangementActionPerformed

    private void btn_statisticsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_statisticsMouseEntered
        changeBtnCAFTrue(btn_statistics);
    }//GEN-LAST:event_btn_statisticsMouseEntered

    private void btn_statisticsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_statisticsMouseExited
        changeBtnCAFFalse(btn_statistics);
    }//GEN-LAST:event_btn_statisticsMouseExited

    private void btn_examActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_examActionPerformed
        this.setVisible(false);
        Exam exam = new Exam();
        if (this.getExtendedState() != 0) {
            exam.setExtendedState(JFrame.MAXIMIZED_BOTH);
        }
        exam.setVisible(true);
    }//GEN-LAST:event_btn_examActionPerformed

    private void btn_groupsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_groupsActionPerformed
        this.setVisible(false);
        levelGroupsManagement levelGroupManagement = new levelGroupsManagement();
        if (this.getExtendedState() != 0) {
            levelGroupManagement.setExtendedState(JFrame.MAXIMIZED_BOTH);
        }
        levelGroupManagement.setVisible(true);
    }//GEN-LAST:event_btn_groupsActionPerformed

    private void btn_moneyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_moneyActionPerformed
        this.setVisible(false);
        MoneyManagement moneyManagement = new MoneyManagement();
        if (this.getExtendedState() != 0) {
            moneyManagement.setExtendedState(JFrame.MAXIMIZED_BOTH);
        }
        moneyManagement.setVisible(true);

    }//GEN-LAST:event_btn_moneyActionPerformed

    private void btn_quizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_quizActionPerformed
        this.setVisible(false);
        Quiz quiz = new Quiz();
        if (this.getExtendedState() != 0) {
            quiz.setExtendedState(JFrame.MAXIMIZED_BOTH);
        }
        quiz.setVisible(true);
    }//GEN-LAST:event_btn_quizActionPerformed

    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logoutActionPerformed
        int yes = JOptionPane.showConfirmDialog(null, "هل انت متاكد من انك تريد تسجيل الدخول", "استفهام", JOptionPane.YES_NO_OPTION, 1);
        if (yes == JOptionPane.YES_OPTION) {
            Login l = new Login();
            this.setVisible(false);
            l.setVisible(true);
        }
    }//GEN-LAST:event_btn_logoutActionPerformed

    private void btn_apsenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_apsenceActionPerformed
        this.setVisible(false);
        Attendance attendance = new Attendance();
        if (this.getExtendedState() != 0) {
            attendance.setExtendedState(JFrame.MAXIMIZED_BOTH);
        }
        attendance.setVisible(true);
    }//GEN-LAST:event_btn_apsenceActionPerformed

    private void btn_SettingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SettingActionPerformed
        this.setVisible(false);
        Settings settings = new Settings();
        if (this.getExtendedState() != 0) {
            settings.setExtendedState(JFrame.MAXIMIZED_BOTH);
        }
        settings.setVisible(true);
    }//GEN-LAST:event_btn_SettingActionPerformed

    private void btn_reportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reportsActionPerformed
        this.setVisible(false);
        Reports reports = new Reports();
        if (this.getExtendedState() != 0) {
            reports.setExtendedState(JFrame.MAXIMIZED_BOTH);
        }
        reports.setVisible(true);
    }//GEN-LAST:event_btn_reportsActionPerformed

    private void btn_statisticsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_statisticsActionPerformed
        this.setVisible(false);
        SecretaryDashBoard dashBoard = new SecretaryDashBoard();
        if (this.getExtendedState() != 0) {
            dashBoard.setExtendedState(JFrame.MAXIMIZED_BOTH);
        }
        dashBoard.setVisible(true);
    }//GEN-LAST:event_btn_statisticsActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SecretaryControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SecretaryControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SecretaryControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SecretaryControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SecretaryControl().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Setting;
    private javax.swing.JButton btn_apsence;
    private javax.swing.JButton btn_exam;
    private javax.swing.JButton btn_groups;
    private javax.swing.JButton btn_logout;
    private javax.swing.JButton btn_money;
    private javax.swing.JButton btn_quiz;
    private javax.swing.JButton btn_reports;
    private javax.swing.JButton btn_statistics;
    private javax.swing.JButton btn_studentMangement;
    private javax.swing.JLabel lb_title;
    private javax.swing.JPanel pl_background;
    private javax.swing.JPanel pl_firstButtonsControl;
    private javax.swing.JPanel pl_secondButtonsControl;
    private javax.swing.JScrollPane sp_secretaryControl;
    // End of variables declaration//GEN-END:variables
}
