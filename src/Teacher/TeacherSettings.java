/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teacher;

import java.awt.Toolkit;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static newatomicstudent.functions.*;

/**
 *
 * @author mahmo
 */
public class TeacherSettings extends javax.swing.JFrame {

    Connection con;

    /**
     * Creates new form Settings
     */
    public TeacherSettings() {
        con = general_connection();
        initComponents();
        setIcon();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sp_setting = new javax.swing.JScrollPane();
        pl_background = new javax.swing.JPanel();
        pl_firstButtonsControl = new javax.swing.JPanel();
        btn_restore = new javax.swing.JButton();
        btn_backup = new javax.swing.JButton();
        btn_profile = new javax.swing.JButton();
        pl_secondButtonsControl = new javax.swing.JPanel();
        btn_path = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_footer = new javax.swing.JButton();
        lb_title = new javax.swing.JLabel();
        btn_home = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pl_background.setBackground(new java.awt.Color(255, 255, 255));

        pl_firstButtonsControl.setBackground(new java.awt.Color(255, 255, 255));
        pl_firstButtonsControl.setAutoscrolls(true);
        pl_firstButtonsControl.setLayout(new java.awt.GridLayout(1, 5, 15, 10));

        btn_restore.setBackground(new java.awt.Color(255, 255, 255));
        btn_restore.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        btn_restore.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/resotre.png"))); // NOI18N
        btn_restore.setText("استرجاع النسخ الاحتياطي");
        btn_restore.setContentAreaFilled(false);
        btn_restore.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_restore.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btn_restore.setIconTextGap(16);
        btn_restore.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_restoreMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_restoreMouseExited(evt);
            }
        });
        btn_restore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_restoreActionPerformed(evt);
            }
        });
        pl_firstButtonsControl.add(btn_restore);

        btn_backup.setBackground(new java.awt.Color(255, 255, 255));
        btn_backup.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        btn_backup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/backup.png"))); // NOI18N
        btn_backup.setText("نسخ احتياطي");
        btn_backup.setContentAreaFilled(false);
        btn_backup.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_backup.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btn_backup.setIconTextGap(16);
        btn_backup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_backupMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_backupMouseExited(evt);
            }
        });
        btn_backup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backupActionPerformed(evt);
            }
        });
        pl_firstButtonsControl.add(btn_backup);

        btn_profile.setBackground(new java.awt.Color(255, 255, 255));
        btn_profile.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        btn_profile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/profile.png"))); // NOI18N
        btn_profile.setText("الملف الشخصي");
        btn_profile.setContentAreaFilled(false);
        btn_profile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_profile.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btn_profile.setIconTextGap(16);
        btn_profile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_profileMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_profileMouseExited(evt);
            }
        });
        btn_profile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_profileActionPerformed(evt);
            }
        });
        pl_firstButtonsControl.add(btn_profile);

        pl_secondButtonsControl.setBackground(new java.awt.Color(255, 255, 255));
        pl_secondButtonsControl.setAutoscrolls(true);
        pl_secondButtonsControl.setMinimumSize(new java.awt.Dimension(1018, 99));
        pl_secondButtonsControl.setLayout(new java.awt.GridLayout(1, 3, 15, 10));

        btn_path.setBackground(new java.awt.Color(255, 255, 255));
        btn_path.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        btn_path.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/path.png"))); // NOI18N
        btn_path.setText("اختيار مكان النسخ التلقائي");
        btn_path.setContentAreaFilled(false);
        btn_path.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_path.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btn_path.setIconTextGap(16);
        btn_path.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_pathMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_pathMouseExited(evt);
            }
        });
        btn_path.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pathActionPerformed(evt);
            }
        });
        pl_secondButtonsControl.add(btn_path);

        btn_delete.setBackground(new java.awt.Color(255, 255, 255));
        btn_delete.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        btn_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/delete.png"))); // NOI18N
        btn_delete.setText("مسح الكل");
        btn_delete.setContentAreaFilled(false);
        btn_delete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_delete.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btn_delete.setIconTextGap(16);
        btn_delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_deleteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_deleteMouseExited(evt);
            }
        });
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });
        pl_secondButtonsControl.add(btn_delete);

        btn_footer.setBackground(new java.awt.Color(255, 255, 255));
        btn_footer.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        btn_footer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/footer.png"))); // NOI18N
        btn_footer.setText("دباجة التقارير");
        btn_footer.setContentAreaFilled(false);
        btn_footer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_footer.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btn_footer.setIconTextGap(16);
        btn_footer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_footerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_footerMouseExited(evt);
            }
        });
        btn_footer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_footerActionPerformed(evt);
            }
        });
        pl_secondButtonsControl.add(btn_footer);

        lb_title.setFont(new java.awt.Font("Cairo", 1, 36)); // NOI18N
        lb_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_title.setText("الاعدادات");

        btn_home.setBackground(new java.awt.Color(19, 64, 93));
        btn_home.setFont(new java.awt.Font("Cairo", 1, 20)); // NOI18N
        btn_home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/home.png"))); // NOI18N
        btn_home.setText("الرئيسية");
        btn_home.setContentAreaFilled(false);
        btn_home.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btn_home.setIconTextGap(16);
        btn_home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_homeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_homeMouseExited(evt);
            }
        });
        btn_home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_homeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pl_backgroundLayout = new javax.swing.GroupLayout(pl_background);
        pl_background.setLayout(pl_backgroundLayout);
        pl_backgroundLayout.setHorizontalGroup(
            pl_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pl_backgroundLayout.createSequentialGroup()
                .addGap(545, 545, 545)
                .addComponent(lb_title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(263, 263, 263)
                .addComponent(btn_home, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(pl_backgroundLayout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addGroup(pl_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pl_secondButtonsControl, javax.swing.GroupLayout.DEFAULT_SIZE, 1113, Short.MAX_VALUE)
                    .addComponent(pl_firstButtonsControl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(72, 72, 72))
        );
        pl_backgroundLayout.setVerticalGroup(
            pl_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pl_backgroundLayout.createSequentialGroup()
                .addGroup(pl_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pl_backgroundLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(lb_title))
                    .addGroup(pl_backgroundLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(btn_home, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(58, 58, 58)
                .addComponent(pl_firstButtonsControl, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(113, 113, 113)
                .addComponent(pl_secondButtonsControl, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        sp_setting.setViewportView(pl_background);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sp_setting)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp_setting, javax.swing.GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
     public static String getDateForBackup() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        return dateFormat.format(date);
    }

    // get the current time
    public static String getTimeForBackup() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("hh;mm-a");
        return sdf.format(cal.getTime());
    }

    public void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(returnYourImageURL())));
    }
    private void btn_backupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backupActionPerformed
        String path = null;
        JFileChooser fc = new JFileChooser();
        fc.showOpenDialog(null);
        String date = getDateForBackup();
        String time = getTimeForBackup();

        try {
            File f = fc.getSelectedFile();
            if (fc.getSelectedFile() == null) {
                return;
            }
            path = f.getAbsolutePath();
            path = path.replace('\\', '/');
            path = path + "(" + date + ")" + ".sql";
            System.out.println(path);
        } catch (Exception ex) {
            System.out.println(ex);
        }

        Process p = null;
        try {

            Process runtime = Runtime.getRuntime().exec("C:/Program Files/MySQL/MySQL Server 5.7/bin/mysqldump.exe -uroot -pMr5-3285928# --add-drop-database -B nsms -r " + path);

            int processComplete = runtime.waitFor();
            if (processComplete == 0) {
                jOptionPaneMessage("تم اخذ نسخة احتياطية بنجاح", 1);
            } else {
                jOptionPaneMessage("لم يتم اخذ نسخة احتياطية", 2);

            }
        } catch (Exception ex) {
            System.out.println(ex);
        }


    }//GEN-LAST:event_btn_backupActionPerformed

    private void btn_restoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_restoreActionPerformed
        if (adminAccept()) {
            String path = "";
            JFileChooser fc = new JFileChooser();
            fc.showOpenDialog(null);

            try {
                File f = fc.getSelectedFile();
                if (fc.getSelectedFile() == null) {
                    return;
                }
                path = f.getAbsolutePath();
                path = path.replace('\\', '/');

            } catch (Exception ex) {
                System.out.println(ex);
            }

            String user = "root";
            String pass = "Mr5-3285928#";
            String dbName = "nsms";
            String[] restoreCmd = new String[]{"C:/Program Files/MySQL/MySQL Server 5.7/bin/mysql.exe", "--user=" + user, "--password=" + pass, "--database=" + dbName, "-e", "source " + path};
            Process process;
            int replay;
            replay = JOptionPane.showConfirmDialog(null, "هل انت متاكد من انك تريد استرجاع النسخه الاحتياطية", "confirm", JOptionPane.YES_NO_OPTION, 2);
            if (replay == JOptionPane.YES_OPTION) {
                try {
                    process = Runtime.getRuntime().exec(restoreCmd);
                    int processComplete = process.waitFor();
                    if (processComplete == 0) {
                        JOptionPane.showMessageDialog(null, "تم الاسترجاع بنجاح;)", "Done...", JOptionPane.PLAIN_MESSAGE);
                    }
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }

        }
    }//GEN-LAST:event_btn_restoreActionPerformed

    private void btn_pathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pathActionPerformed
        String path = null;
        JFileChooser fc = new JFileChooser();
        fc.showOpenDialog(null);

        try {
            File f = fc.getSelectedFile();
            if (fc.getSelectedFile() == null) {
                return;
            }
            path = f.getAbsolutePath();
            path = path.replace('\\', '/');
            System.out.println(path);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        try {
            PreparedStatement stmt = con.prepareStatement("update  path set path=?");

            stmt.setString(1, path);

            stmt.executeUpdate();
            jOptionPaneMessage("تم اختيار مكان الحفظ التلقائي بنجاح", WIDTH);
        } catch (SQLException ex) {
            System.out.println(ex.getErrorCode());
        }

    }//GEN-LAST:event_btn_pathActionPerformed

    private void btn_footerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_footerActionPerformed
        String foot = JOptionPane.showInputDialog(null, "اكتب ما سيعرض باسفل كل تقرير", "الفوتر", JOptionPane.PLAIN_MESSAGE);
        try {
            PreparedStatement stmt = con.prepareStatement("update  footer set footer=?");
            stmt.setString(1, foot);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "تم", "", JOptionPane.PLAIN_MESSAGE);
        } catch (SQLException ex) {
            System.out.println(ex.getErrorCode());
        }
    }//GEN-LAST:event_btn_footerActionPerformed

    private void btn_profileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_profileActionPerformed
        TeacherProfile teacherProfile = new TeacherProfile();
        this.setVisible(false);
        teacherProfile.setVisible(true);
    }//GEN-LAST:event_btn_profileActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        if (adminAccept()) {
            String path = null;
            path = "empty.sql";
            String user = "root";
            String pass = "Mr5-3285928#";
            String dbName = "nsms";
            String[] restoreCmd = new String[]{"C:/Program Files/MySQL/MySQL Server 5.7/bin/mysql.exe", "--user=" + user, "--password=" + pass, "--database=" + dbName, "-e", "source " + path};
            Process process;
            int replay;
            replay = JOptionPane.showConfirmDialog(null, "هل انت متاكد من انك تريد حذف كل البيانات", "confirm", JOptionPane.YES_NO_OPTION, 2);
            if (replay == JOptionPane.YES_OPTION) {
                try {
                    process = Runtime.getRuntime().exec(restoreCmd);
                    int processComplete = process.waitFor();
                    if (processComplete == 0) {
                        JOptionPane.showMessageDialog(null, "تم الحذف بنجاح ;)", "Done...", JOptionPane.PLAIN_MESSAGE);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_profileMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_profileMouseEntered
        changeBtnCAFTrue(btn_profile);
    }//GEN-LAST:event_btn_profileMouseEntered

    private void btn_backupMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_backupMouseEntered
        changeBtnCAFTrue(btn_backup);
    }//GEN-LAST:event_btn_backupMouseEntered

    private void btn_restoreMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_restoreMouseEntered
        changeBtnCAFTrue(btn_restore);
    }//GEN-LAST:event_btn_restoreMouseEntered

    private void btn_footerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_footerMouseEntered
        changeBtnCAFTrue(btn_footer);
    }//GEN-LAST:event_btn_footerMouseEntered

    private void btn_deleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_deleteMouseEntered
        changeBtnCAFTrue(btn_delete);
    }//GEN-LAST:event_btn_deleteMouseEntered

    private void btn_pathMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_pathMouseEntered
        changeBtnCAFTrue(btn_path);
    }//GEN-LAST:event_btn_pathMouseEntered

    private void btn_profileMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_profileMouseExited
        changeBtnCAFFalse(btn_profile);
    }//GEN-LAST:event_btn_profileMouseExited

    private void btn_backupMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_backupMouseExited
        changeBtnCAFFalse(btn_backup);
    }//GEN-LAST:event_btn_backupMouseExited

    private void btn_restoreMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_restoreMouseExited
        changeBtnCAFFalse(btn_restore);
    }//GEN-LAST:event_btn_restoreMouseExited

    private void btn_footerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_footerMouseExited
        changeBtnCAFFalse(btn_footer);
    }//GEN-LAST:event_btn_footerMouseExited

    private void btn_deleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_deleteMouseExited
        changeBtnCAFFalse(btn_delete);
    }//GEN-LAST:event_btn_deleteMouseExited

    private void btn_pathMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_pathMouseExited
        changeBtnCAFFalse(btn_path);
    }//GEN-LAST:event_btn_pathMouseExited

    private void btn_homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_homeActionPerformed
        this.setVisible(false);
        TeacherControl teacherControl = new TeacherControl();
        if (this.getExtendedState() != 0) {
            teacherControl.setExtendedState(JFrame.MAXIMIZED_BOTH);
        }
        teacherControl.setVisible(true);
    }//GEN-LAST:event_btn_homeActionPerformed

    private void btn_homeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_homeMouseEntered
        changeBtnCAFTrue(btn_home);
    }//GEN-LAST:event_btn_homeMouseEntered

    private void btn_homeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_homeMouseExited
        changeBtnCAFFalse(btn_home);
    }//GEN-LAST:event_btn_homeMouseExited

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
            java.util.logging.Logger.getLogger(TeacherSettings.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TeacherSettings.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TeacherSettings.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TeacherSettings.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TeacherSettings().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_backup;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_footer;
    private javax.swing.JButton btn_home;
    private javax.swing.JButton btn_path;
    private javax.swing.JButton btn_profile;
    private javax.swing.JButton btn_restore;
    private javax.swing.JLabel lb_title;
    private javax.swing.JPanel pl_background;
    private javax.swing.JPanel pl_firstButtonsControl;
    private javax.swing.JPanel pl_secondButtonsControl;
    private javax.swing.JScrollPane sp_setting;
    // End of variables declaration//GEN-END:variables
}
