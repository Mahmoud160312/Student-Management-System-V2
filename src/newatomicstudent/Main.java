package newatomicstudent;

import Login.Login;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static newatomicstudent.functions.admin_connection;

public class Main {

    static Connection con = admin_connection();

    public static void main(String[] args) throws Exception {
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
            java.util.logging.Logger.getLogger(Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //String user_name="mahmo";
        //String user_name = "Mahmoud Reda";                                  //  Mine
        //String user_name="mo7a";                                            //  Amani
        //String user_name="Hisham El Attar";                                 //  Hisham EL Attar pc
        //String user_name = "Toshiba";                                       //  Hisham EL Attar labtop
        //String user_name = "hp";                                            //  Weal Amar
        //String user_name="TASNEEM";                                         //  Ahmed Esmail
        String user_name = "myvin";                                           //  Ahmed El5odary
        //String user_name = "Freecomp";                                //  Ahmed Abo Shady
        //String user_name = "Metro Computer";                                //  Ahemd Ismail

        String pass = System.getProperty("user.name");
        System.out.println(pass);
        if (!user_name.equals(pass)) {
            JOptionPane.showMessageDialog(null, "لقد تم نقل البرنامج الى جهاز غير معلوم دون علم المختصيين", "عذراا", 3);
            return;
        }
        /*
        // if only one month;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); //this to take a specific format
        Date date = new Date();                                     // the current date
        Date end_date = null;                                         // the last date the program have
        String current_date = dateFormat.format(date);              // convert the current date to string     
        String curr_date = null;                                    // get the last date in the database

        // convert the string of end date to date object
        try {
            end_date = dateFormat.parse("2019-10-10");
        } catch (ParseException ex) {
            System.out.println(ex);
        }

        //check if the program pass the year or not
        if (date.equals(end_date) || date.after(end_date)) {
            JOptionPane.showMessageDialog(null, "يجب تفعيل البرنامج الرجاء الاتصال بالمتخصصين");
            return;
        }
        //get the last date and compare it with the current date to check if the date didn't go back
        try {
            PreparedStatement stmt = con.prepareStatement("select *from expired_date");
            ResultSet set = stmt.executeQuery();
            while (set.next()) {
                curr_date = set.getString("start_date");
            }

            Date date2 = null;                             // convert the string in the database to date object
            try {
                date2 = dateFormat.parse(curr_date);
            } catch (ParseException ex) {
                System.out.println(ex);
            }
            // check if the date go back the current date and the last date stored in the database
            if (date.before(date2)) {
                JOptionPane.showMessageDialog(null, "لقد تم تغير التاريخ الي تاريخ اقدم الرجاء ضبط التاريخ على يوم " + curr_date, "عذراا", 3);
                return;
            }

        } catch (SQLException ex) {
            System.out.println("Error" + ex.getErrorCode());
        }
        // update the last date stored in the database
        try {
            PreparedStatement stmt = con.prepareStatement("update expired_date set end_date=?,start_date=?");
            stmt.setString(1, "2019-10-10");
            stmt.setString(2, current_date);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getErrorCode());
        }
        */
        /*
        // if only one year
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); //this to take a specific format
        Date date = new Date();                                     // the current date
        Date end_date = null;                                         // the last date the program have
        String current_date = dateFormat.format(date);              // convert the current date to string     
        String curr_date = null;                                    // get the last date in the database

        // convert the string of end date to date object
        try {
            end_date = dateFormat.parse("2020-08-01");
        } catch (ParseException ex) {
            System.out.println(ex);
        }

        //check if the program pass the year or not
        if (date.equals(end_date) || date.after(end_date)) {
            JOptionPane.showMessageDialog(null, "يجب تفعيل البرنامج الرجاء الاتصال بالمتخصصين");
            return;
        }
        //get the last date and compare it with the current date to check if the date didn't go back
        try {
            PreparedStatement stmt = con.prepareStatement("select *from expired_date");
            ResultSet set = stmt.executeQuery();
            while (set.next()) {
                curr_date = set.getString("start_date");
            }

            Date date2 = null;                             // convert the string in the database to date object
            try {
                date2 = dateFormat.parse(curr_date);
            } catch (ParseException ex) {
                 System.out.println(ex);
            }
            // check if the date go back the current date and the last date stored in the database
            if (date.before(date2)) {
                JOptionPane.showMessageDialog(null, "لقد تم تغير التاريخ الي تاريخ اقدم الرجاء ضبط التاريخ على يوم " + curr_date, "عذراا", 3);
                return;
            }

        } catch (SQLException ex) {
            System.out.println("Error" + ex.getErrorCode());
        }
        // update the last date stored in the database
        try {
            PreparedStatement stmt = con.prepareStatement("update expired_date set end_date=?,start_date=?");
            stmt.setString(1, "2020-08-01");
            stmt.setString(2, current_date);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getErrorCode());
        }
        */
        
        Splash w = new Splash();
        w.setVisible(true);
        w.prog.setVisible(false);
        Thread th = new Thread() {
            public void run() {
                for (int i = 0; i <= 10; i++) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    if (i == 1) {
                        w.prog.setValue(10);
                    }
                    if (i == 2) {
                        w.prog.setValue(20);
                    }
                    if (i == 3) {
                        w.prog.setValue(30);
                    }
                    if (i == 4) {
                        w.prog.setValue(40);
                    }
                    if (i == 5) {
                        w.prog.setValue(50);
                    }
                    if (i == 6) {
                        w.prog.setValue(60);
                    }
                    if (i == 7) {
                        w.prog.setValue(70);
                    }
                    if (i == 8) {
                        w.prog.setValue(80);
                    }
                    if (i == 9) {
                        w.prog.setValue(90);
                    }
                    if (i == 10) {
                        w.prog.setValue(100);
                    }
                }
                w.setVisible(false);
                Login login = new Login();
                login.setVisible(true);

            }
        };
        th.start();
    }

}
