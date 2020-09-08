package newatomicstudent;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class functions {
    public static void printJ(String student_name, int student_code, String level_name, String month_name, String date, double discount, double total) {
        int yes = JOptionPane.showConfirmDialog(null, "هل تريد طباعه ايصال ؟ ", "استفهام", JOptionPane.YES_NO_OPTION);
        if (yes == 0) {
            JTextArea j = new JTextArea();
            j.setSize(240, 450);
            j.setLineWrap(true);
            j.append("************************\n\n");
            j.append("أ/احمد الخضري\n\n");
            j.append("************************\n\n");
            j.append("اسم الطالب : " + student_name + "\n");
            j.append("------------------------\n\n");
            j.append("كود الطالب : " + student_code + "\n");
            j.append("------------------------\n\n");
            j.append("الفرقه : " + level_name + "\n");
            j.append("------------------------\n\n");
            j.append("شهر الدفع : " + month_name + "\n");
            j.append("------------------------\n\n");
            j.append("تاريخ الدفع : " + date + "\n");
            j.append("------------------------\n\n");
            if (discount != 0) {
                j.append("المبلغ : " + total + "$" + "\n");
            } else {
                j.append("المبلغ : " + total + "\n");
            }
            j.append("************************\n\n");
            try {
                j.print();
            } catch (PrinterException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }

    public static void changeCurssorWhenEnterButton(JButton btn) {
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    // get the current date
    public static String getDate() {

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        return dateFormat.format(date);
    }

    // get the current time
    public static String getTime() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss a");
        return sdf.format(cal.getTime());
    }

    // this to speed up the jscrollpane
    public static void speedUpScrollPane(JScrollPane jScrollPane) {
        jScrollPane.getVerticalScrollBar().setUnitIncrement(16);
        jScrollPane.getHorizontalScrollBar().setUnitIncrement(10);
    }

    public static void setTableSorter(JTable table) {
        table.setAutoCreateRowSorter(true);
    }

    //sort depend on specific column
    public static void sortTableDependOnSpecificColumn(JTable table, int index) {

        RowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
        List<RowSorter.SortKey> sortKeys = new ArrayList<>();
        sortKeys.add(new RowSorter.SortKey(index, SortOrder.DESCENDING));
        sorter.setSortKeys(sortKeys);
        table.setRowSorter(sorter);
    }

    // when the mouse enterd the button this function change it
    public static void changeBtnCAFTrue(JButton btn) {
        Color btnBGColor = new Color(218, 227, 255);
        Color borderColor = new Color(0, 120, 215, 200);
        btn.setBackground(btnBGColor);
        btn.setContentAreaFilled(true);
        LineBorder border = new LineBorder(borderColor, 2, true);
        btn.setBorder(border);
    }

    // when the mouse exit the button this function change it
    public static void changeBtnCAFFalse(JButton btn) {
        btn.setContentAreaFilled(false);
        EmptyBorder border = new EmptyBorder(1, 1, 1, 1);
        btn.setBorder(border);
    }

    // when the mouse enterd the button this function change it
    public static void hoverInMouseMotion(JButton btn) {
        Color btnBGColor = new Color(19, 64, 93);
        //Color btnBGColor = new Color(104, 165, 204);

        btn.setBackground(btnBGColor);
        btn.setContentAreaFilled(true);

    }

    // when the mouse exit the button this function change it
    public static void hoverInMouseClicked(JButton btn) {
        Color btnBGColor = new Color(0, 155, 255);
        btn.setBackground(btnBGColor);
        btn.setBorder(new LineBorder(Color.WHITE, 2, true));
        btn.setContentAreaFilled(true);

    }

    // when press in one buttons of the button control all the buttons return to default color
    public static void defaultAfterHover(JButton btn) {
        btn.setBorder(new LineBorder(new Color(19, 64, 93), 1, true));
        btn.setContentAreaFilled(false);
    }

    // when the mouse enterd the label this function change it
    public static void hoverInMouseMotion(JLabel lb) {
        lb.setForeground(Color.red);

    }

    // when press in one label of the button control all the buttons return to default color
    public static void defaultAfterHover(JLabel lb) {
        Color lbBGColor = new Color(0, 155, 255);
        lb.setForeground(lbBGColor);
    }

    // this is what happen when the user click enter in some textfield
    public static boolean enter(int evt) {
        return evt == KeyEvent.VK_ENTER;
    }

    // check if the written in the textfield is an integer value
    public static boolean textFieldValidation(JTextField tf, char c, KeyEvent evt) {
        if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_ENTER && c != KeyEvent.VK_PERIOD) {
            tf.setBorder(new LineBorder(Color.red, 2, true));
            evt.consume();
            return true;
        }
        tf.setForeground(Color.black);
        tf.setBorder(new LineBorder(new Color(0, 155, 255), 2, true));
        return false;
    }

    // only insure that the border of the text field is cayn
    public static void FocusLostOrGained(JTextField tf) {
        tf.setForeground(Color.black);
        tf.setBorder(new LineBorder(new Color(0, 155, 255), 2, true));
    }

    // only insure that the border of the text field is cayn
    public static void FocusLostOrGained(JTextArea ta) {
        ta.setForeground(Color.black);
        ta.setBorder(new LineBorder(new Color(0, 155, 255), 2, true));
    }

    // only insure that the border of the combobox is cayn
    public static void FocusLostOrGained(JComboBox cb) {
        cb.setForeground(Color.black);
        cb.setBorder(new LineBorder(new Color(0, 155, 255), 2, true));
    }

    // only insure that the border of the combobox is cayn
    public static void FocusLostOrGained(JList list) {
        list.setForeground(Color.black);
        list.setBorder(new LineBorder(new Color(0, 155, 255), 2, true));
    }

    // only insure that the border of the combobox is cayn
    public static void FocusLostOrGained(JDateChooser dc) {
        dc.setForeground(Color.black);
        dc.setBorder(new LineBorder(new Color(0, 155, 255), 2, true));

    }

    // take admin acceptance in delete update or stop
    public static boolean adminAccept() {
        String accept_code = JOptionPane.showInputDialog(null, "اكتب كود الموافقة لاكمال العملية ", "كود الموافقة", JOptionPane.INFORMATION_MESSAGE);
        String message;
        String code = returnAcceptCode();

        if (!code.equals(accept_code)) {
            message = "فشل في الموافقة";
            jOptionPaneMessage(message, 0);
            return false;
        }
        return true;
    }

    public static String returnAcceptCode() {
        PreparedStatement stmt;
        ResultSet set;
        Connection adminCon = admin_connection();
        String code = "";
        try {
            stmt = adminCon.prepareStatement("select *from adminPermision");
            set = stmt.executeQuery();
            set.next();
            code = set.getString("accept_code");

        } catch (SQLException ex) {
            handleSqlExceptions(ex.getErrorCode());
        }
        return code;
    }

    // send the table and this function will take title and print the table
    public static void makeReport(JTable t, String title) {
        String header = title;
        String footer = " ";
        MessageFormat Header;
        MessageFormat Footer;

        try {
            Connection con = general_connection();
            PreparedStatement stmt = con.prepareStatement("select * from footer");
            ResultSet set = stmt.executeQuery();
            while (set.next()) {
                footer = set.getString("footer");
            }
        } catch (SQLException ex) {
            handleSqlExceptions(ex.getErrorCode());
        }

        Header = new MessageFormat((header));
        Footer = new MessageFormat((footer));

        try {

            t.setFont(new Font("Segoe Symbol", Font.BOLD, 14));
            t.print(JTable.PrintMode.FIT_WIDTH, Header, Footer);
            t.setFont(new Font("cairo", Font.BOLD, 14));
        } catch (PrinterException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    // connect the program with the database
    public static Connection general_connection() {
        Connection conn = null;
        String URL = "jdbc:mysql://localhost:3306/";
        String DBNAME = "nsms";
        String DRIVER = "com.mysql.jdbc.Driver";
        String USERNAME = "root";
        String PASSWORD = "Mr5-3285928#";

        String message;

        try {
            Class.forName(DRIVER).newInstance();
            conn = DriverManager.getConnection(URL + DBNAME, USERNAME, PASSWORD);

        } catch (Exception e) {
            message = "لا يستطيع الاتصال بقاعدة البيانات"
                    + " ان استمرت المشكله الرجاء الاتصال بالمختصين";
            jOptionPaneMessage(message + e, 0);
        }
        return conn;
    }

    public static Connection admin_connection() {
        Connection conn = null;
        String URL = "jdbc:mysql://localhost:3306/";
        String DBNAME = "adminnsms";
        String DRIVER = "com.mysql.jdbc.Driver";
        String USERNAME = "root";
        String PASSWORD = "Mr5-3285928#";

        String message;

        try {
            Class.forName(DRIVER).newInstance();
            conn = DriverManager.getConnection(URL + DBNAME, USERNAME, PASSWORD);

        } catch (Exception e) {
            message = "لا يستطيع الاتصال بقاعدة البيانات"
                    + " ان استمرت المشكله الرجاء الاتصال بالمختصين";
            jOptionPaneMessage(message + e, 0);
        }
        return conn;
    }

    // load the groups of the student in the combobox
    public static void loadGroup(JComboBox cb, String level_name) {
        DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
        PreparedStatement stmt;
        ResultSet resultSet;
        String group_name;
        dcbm.addElement("اختر المجموعة");
        if (level_name.equals("اختر الفرقة")) {
            return;
        }
        try {

            Connection con = general_connection();
            stmt = con.prepareStatement("select * from student_group where level_name=?");
            stmt.setString(1, level_name);
            resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                group_name = resultSet.getString("group_name");
                dcbm.addElement(group_name);
            }
        } catch (SQLException ex) {
            handleSqlExceptions(ex.getErrorCode());
        }
        cb.setModel(dcbm);
    }

    // load the groups of the student in the table
    public static void loadGroup(JTable table, String level_name) {
        DefaultTableModel dtm = new DefaultTableModel();
        PreparedStatement stmt;
        ResultSet resultSet;
        String group_name;
        String group_time;
        int maxNumber;
        try {
            Connection con = general_connection();
            stmt = con.prepareStatement("select * from student_group where level_name=?");
            stmt.setString(1, level_name);
            resultSet = stmt.executeQuery();
            dtm.addColumn("الحد الاقصى");
            dtm.addColumn("الميعاد");
            dtm.addColumn("اسم المجموعة");

            while (resultSet.next()) {
                group_name = resultSet.getString("group_name");
                group_time = resultSet.getString("group_time");
                maxNumber = resultSet.getInt("maxNumber");
                String r[] = {String.valueOf(maxNumber), group_time, group_name};
                dtm.addRow(r);
            }
        } catch (SQLException ex) {
            handleSqlExceptions(ex.getErrorCode());
        }
        table.setModel(dtm);
    }

    // load the groups of the student in the table
    public static void loadGroup(JList list, String level_name) {
        DefaultListModel dlm = new DefaultListModel();
        PreparedStatement stmt;
        ResultSet resultSet;
        String group_name;

        if (level_name.equals("اختر الفرقة")) {
            list.setModel(dlm);
            return;
        }
        try {

            Connection con = general_connection();
            stmt = con.prepareStatement("select * from student_group where level_name=?");
            stmt.setString(1, level_name);
            resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                group_name = resultSet.getString("group_name");
                dlm.addElement(group_name);
            }
        } catch (SQLException ex) {
            handleSqlExceptions(ex.getErrorCode());
        }
        list.setModel(dlm);
    }

    // this function hold the icon of the program and return the url to setIcon function in all classes
    public static String returnYourImageURL() {
        return "/Photos/logo.png";
    }

    // load the books of the student in the table
    public static void loadBook(JTable table, String level_name) {
        DefaultTableModel dtm = new DefaultTableModel();
        PreparedStatement stmt;
        ResultSet resultSet;
        String book_name;

        int book_cost;
        int total;
        int sold;
        int avilable;
        try {
            Connection con = general_connection();
            stmt = con.prepareStatement("select * from student_book where level_name=?");
            stmt.setString(1, level_name);
            resultSet = stmt.executeQuery();
            dtm.addColumn("الكلي");
            dtm.addColumn("مباع");
            dtm.addColumn("العدد الحالي");
            dtm.addColumn("السعر");
            dtm.addColumn("اسم المذكرة");

            while (resultSet.next()) {
                book_name = resultSet.getString("book_name");
                book_cost = resultSet.getInt("book_cost");
                total = resultSet.getInt("maxNumber");
                sold = resultSet.getInt("sold");
                avilable = total - sold;
                String r[] = {String.valueOf(total), String.valueOf(sold), String.valueOf((avilable)), String.valueOf(book_cost), book_name};
                dtm.addRow(r);
            }
        } catch (SQLException ex) {
            handleSqlExceptions(ex.getErrorCode());
        }
        table.setModel(dtm);
    }

    // load the books of the student in the table
    public static void loadBook(JComboBox cb, String level_name) {
        DefaultComboBoxModel dcm = new DefaultComboBoxModel();
        PreparedStatement stmt;
        ResultSet resultSet;
        String book_name;

        try {
            Connection con = general_connection();
            stmt = con.prepareStatement("select * from student_book where level_name=?");
            stmt.setString(1, level_name);
            resultSet = stmt.executeQuery();
            dcm.addElement("اختر المذكرة");

            while (resultSet.next()) {
                book_name = resultSet.getString("book_name");
                dcm.addElement(book_name);
            }
        } catch (SQLException ex) {
            handleSqlExceptions(ex.getErrorCode());
        }
        cb.setModel(dcm);
    }

    // load the quiz of the student "التسميعات"
    public static void loadQuiz(JTable table, String level_name) {
        DefaultTableModel dtm = new DefaultTableModel();
        PreparedStatement stmt;
        ResultSet resultSet;
        int quiz_code;
        String quiz_date;
        double quiz_degree;
        String quiz_name;
        try {
            Connection con = general_connection();
            stmt = con.prepareStatement("select * from quiz where level_name=? ");
            stmt.setString(1, level_name);
            resultSet = stmt.executeQuery();
            dtm.addColumn("التاريخ");
            dtm.addColumn("الدرجة");
            dtm.addColumn("اسم التسميع");
            dtm.addColumn("كود التسميع");

            while (resultSet.next()) {
                quiz_code = resultSet.getInt("quiz_code");
                quiz_name = resultSet.getString("quiz_name");
                quiz_degree = resultSet.getDouble("quiz_degree");
                quiz_date = resultSet.getString("quiz_date");
                String r[] = {quiz_date, String.valueOf(quiz_degree), quiz_name, String.valueOf(quiz_code)};
                dtm.addRow(r);
            }
        } catch (SQLException ex) {
            handleSqlExceptions(ex.getErrorCode());
        }
        table.setModel(dtm);
    }

    // load the quiz of the student "التسميع"
    public static void loadQuiz(JComboBox comboBox, String level_name) {
        DefaultComboBoxModel dcm = new DefaultComboBoxModel();
        PreparedStatement stmt;
        ResultSet resultSet;
        int quiz_code;
        try {
            Connection con = general_connection();
            stmt = con.prepareStatement("select quiz_code from quiz where level_name=? order by quiz_code desc" );
            stmt.setString(1, level_name);
            resultSet = stmt.executeQuery();
            dcm.addElement("اختر التسميع");
            while (resultSet.next()) {
                quiz_code = resultSet.getInt("quiz_code");
                dcm.addElement(quiz_code);
            }
        } catch (SQLException ex) {
            handleSqlExceptions(ex.getErrorCode());
        }
        comboBox.setModel(dcm);
    }

    // load the quiz degree of the student "درجة التسميع"
    public static void loadStudentDegreeInQuiz(JTable table, String level_name, int quiz_number) {
        DefaultTableModel dtm = new DefaultTableModel();
        PreparedStatement stmt;
        ResultSet resultSet;
        String answer_date;
        int student_code;
        String answer_time;
        double student_degree;
        String student_name;

        try {
            Connection con = general_connection();
            stmt = con.prepareStatement("select * from student_quiz_connection where level_name=? and quiz_code=? and student_code in (select student_code from student where student_status!=?)order by date");
            stmt.setString(1, level_name);
            stmt.setInt(2, quiz_number);
            stmt.setString(3, "موقوف");
            resultSet = stmt.executeQuery();
            dtm.addColumn("الوقت");
            dtm.addColumn("التاريخ");
            dtm.addColumn("درجة الطالب");
            dtm.addColumn("اسم الطالب");
            dtm.addColumn("كود الطالب");
            while (resultSet.next()) {
                answer_date = resultSet.getString("date");
                student_code = resultSet.getInt("student_code");
                student_name = resultSet.getString("student_name");
                student_degree = resultSet.getDouble("student_degree");
                answer_time = resultSet.getString("time");

                String r[] = {answer_time, answer_date, String.valueOf(student_degree), student_name, String.valueOf(student_code)};
                dtm.addRow(r);
            }
        } catch (SQLException ex) {
            handleSqlExceptions(ex.getErrorCode());
        }
        table.setModel(dtm);
    }

    // load the exam of the student "الامتحانات"
    public static void loadExam(JTable table, String level_name) {
        DefaultTableModel dtm = new DefaultTableModel();
        PreparedStatement stmt;
        ResultSet resultSet;
        int exam_code;
        String exam_date;
        double exam_degree;
        String exam_name;
        try {
            Connection con = general_connection();
            stmt = con.prepareStatement("select * from exam where level_name=?");
            stmt.setString(1, level_name);
            resultSet = stmt.executeQuery();
            dtm.addColumn("التاريخ");
            dtm.addColumn("الدرجة");
            dtm.addColumn("اسم الامتحان");
            dtm.addColumn("كود الامتحان");

            while (resultSet.next()) {
                exam_code = resultSet.getInt("exam_code");
                exam_name = resultSet.getString("exam_name");
                exam_degree = resultSet.getDouble("exam_degree");
                exam_date = resultSet.getString("exam_date");
                String r[] = {exam_date, String.valueOf(exam_degree), exam_name, String.valueOf(exam_code)};
                dtm.addRow(r);
            }
        } catch (SQLException ex) {
            handleSqlExceptions(ex.getErrorCode());
        }
        table.setModel(dtm);
    }

    // load the exam of the student "الامتحانات"
    public static void loadExam(JComboBox comboBox, String level_name) {
        DefaultComboBoxModel dcm = new DefaultComboBoxModel();
        PreparedStatement stmt;
        ResultSet resultSet;
        int exam_code;
        try {
            Connection con = general_connection();
            stmt = con.prepareStatement("select exam_code from exam where level_name=? order by exam_code desc");
            stmt.setString(1, level_name);
            resultSet = stmt.executeQuery();
            dcm.addElement("اختر الامتحان");
            while (resultSet.next()) {
                exam_code = resultSet.getInt("exam_code");
                dcm.addElement(exam_code);
            }
        } catch (SQLException ex) {
            handleSqlExceptions(ex.getErrorCode());
        }
        comboBox.setModel(dcm);
    }

    // load the quiz degree of the student "درجة التسميع"
    public static void loadStudentDegreeInExam(JTable table, String level_name, int exam_number) {
        DefaultTableModel dtm = new DefaultTableModel();
        PreparedStatement stmt;
        ResultSet resultSet;

        String answer_date;
        int student_code;
        String answer_time;
        double student_degree;
        String student_name;

        try {
            Connection con = general_connection();
            stmt = con.prepareStatement("select * from student_exam_connection where level_name=? and exam_code=? and student_code in (select student_code from student where student_status!=?)order by date");
            stmt.setString(1, level_name);
            stmt.setInt(2, exam_number);
            stmt.setString(3, "موقوف");
            resultSet = stmt.executeQuery();
            dtm.addColumn("الوقت");
            dtm.addColumn("التاريخ");
            dtm.addColumn("درجة الطالب");
            dtm.addColumn("اسم الطالب");
            dtm.addColumn("كود الطالب");
            while (resultSet.next()) {
                answer_date = resultSet.getString("date");
                student_code = resultSet.getInt("student_code");
                student_name = resultSet.getString("student_name");
                student_degree = resultSet.getDouble("student_degree");
                answer_time = resultSet.getString("time");

                String r[] = {answer_time, answer_date, String.valueOf(student_degree), student_name, String.valueOf(student_code)};
                dtm.addRow(r);
            }
        } catch (SQLException ex) {
            handleSqlExceptions(ex.getErrorCode());
        }
        table.setModel(dtm);
    }

    // load the class of the student in a table "الحصة"
    public static void loadClass(JTable table, String level_name) {
        DefaultTableModel dtm = new DefaultTableModel();
        PreparedStatement stmt;
        ResultSet resultSet;
        int class_number;
        String start_date;
        String end_name;
        try {
            Connection con = general_connection();
            stmt = con.prepareStatement("select * from class where level_name=?");
            stmt.setString(1, level_name);
            resultSet = stmt.executeQuery();
            dtm.addColumn("الى");
            dtm.addColumn("من");
            dtm.addColumn("رقم الحصه");

            while (resultSet.next()) {
                class_number = resultSet.getInt("class_number");
                start_date = resultSet.getString("start_date");
                end_name = resultSet.getString("end_date");
                String r[] = {end_name, start_date, String.valueOf(class_number)};
                dtm.addRow(r);
            }
        } catch (SQLException ex) {
            handleSqlExceptions(ex.getErrorCode());
        }
        table.setModel(dtm);
    }

    // load the class of the student "الحصة"
    public static void loadClass(JComboBox cb, String level_name) {
        DefaultComboBoxModel dcm = new DefaultComboBoxModel();
        PreparedStatement stmt;
        ResultSet resultSet;
        int class_number;
        try {
            Connection con = general_connection();
            stmt = con.prepareStatement("select * from class where level_name=? order by class_number desc");
            stmt.setString(1, level_name);
            resultSet = stmt.executeQuery();
            dcm.addElement("اختر رقم الحصة");
            while (resultSet.next()) {
                class_number = resultSet.getInt("class_number");
                dcm.addElement(class_number);
            }
        } catch (SQLException ex) {
            handleSqlExceptions(ex.getErrorCode());
        }
        cb.setModel(dcm);
    }

    // search for student name by code and level
    public static void searchForStudentNameByCode(JTextField tf_code, JTextField tf_studentName, String level) {
        String message;
        FocusLostOrGained(tf_code);
        if (!tf_code.getText().equals("") && !tf_code.getText().equals("غير موجود")) {
            int student_code = Integer.parseInt(tf_code.getText());
            String name = "";
            try {
                Connection con = general_connection();
                PreparedStatement stmt = con.prepareStatement("select student_name, student_status from student where student_code=? and level_name=?");
                stmt.setInt(1, student_code);
                stmt.setString(2, level);
                ResultSet res = stmt.executeQuery();
                // check if found the student or not
                while (res.next()) {
                    name = res.getString("student_name");
                }
                if (name.equals("")) {
                    tf_code.setText("");
                    message = "هذا الطالب غير موجود";
                    jOptionPaneMessage(message, 0);
                    tf_studentName.setText(name);
                    return;
                }
                tf_studentName.setText(name);

            } catch (SQLException ex) {
                handleSqlExceptions(ex.getErrorCode());
            }
        }
    }

    // search for student code by name and level
    public static void searchForStudentCodeByName(JTextField tf_code, JTextField tf_studentName, String level) {
        FocusLostOrGained(tf_studentName);
        if (!tf_studentName.getText().equals("")) {
            String name = tf_studentName.getText();
            int student_code = -1;
            // get the student data from student table
            try {
                Connection con = general_connection();
                PreparedStatement stmt = con.prepareStatement("select student_code from student where student_name=? and level_name=?");
                stmt.setString(1, name);
                stmt.setString(2, level);
                ResultSet res = stmt.executeQuery();
                // check if found the student or not
                while (res.next()) {
                    student_code = res.getInt("student_code");
                }

                tf_code.setText(String.valueOf(student_code));

            } catch (SQLException ex) {
                handleSqlExceptions(ex.getErrorCode());
            }
        }
    }

    // load the predicted names in the list depend on the name and the level
    public static void loadPredictedNamesDependOnStudentNameAndLevel(JTextField tf_studentName, String level, JList lst_searchNames, JPanel pl_searchNames) {
        String tempName = tf_studentName.getText();
        // get the student names from student table
        try {
            Connection con = general_connection();
            PreparedStatement stmt = con.prepareStatement("select student_name from student where student_name like " + "\'" + "%" + tempName + "%" + "\' and level_name=?");
            stmt.setString(1, level);
            ResultSet res = stmt.executeQuery();
            DefaultListModel dlm = new DefaultListModel();
            dlm.clear();
            while (res.next()) {
                String name = res.getString("student_name");
                dlm.addElement(name);
            }
            lst_searchNames.setModel(dlm);
            pl_searchNames.setVisible(true);
        } catch (SQLException ex) {
            handleSqlExceptions(ex.getErrorCode());
        }

    }

    // search for student name by code and level
    public static void searchForQuizNameAndDegreeByCode(JComboBox comboBox, JTextField tf_quizName, JTextField tf_quizDegree, String level) {
        String message;
        FocusLostOrGained(comboBox);
        if (!comboBox.getSelectedItem().toString().equals("") && !comboBox.getSelectedItem().toString().equals("غير موجود")) {
            int quiz_code = Integer.parseInt(comboBox.getSelectedItem().toString());
            String name = "";
            double degree = 0;
            try {
                Connection con = general_connection();
                PreparedStatement stmt = con.prepareStatement("select quiz_name,quiz_degree from quiz where quiz_code=? and level_name=?");
                stmt.setInt(1, quiz_code);
                stmt.setString(2, level);
                ResultSet res = stmt.executeQuery();
                // check if found the student or not
                while (res.next()) {
                    name = res.getString("quiz_name");
                    degree = res.getDouble("quiz_degree");
                }
                if (name.equals("")) {
                    comboBox.setSelectedIndex(0);
                    message = "هذا التسميع  غير موجود";
                    jOptionPaneMessage(message, 0);
                    tf_quizName.setText(name);
                    tf_quizDegree.setText("");
                    return;
                }
                tf_quizName.setText(name);
                tf_quizDegree.setText(String.valueOf(degree));

            } catch (SQLException ex) {
                handleSqlExceptions(ex.getErrorCode());
            }
        }
    }

    // search for student name by code and level
    public static void searchForExamNameAndDegreeByCode(JComboBox comboBox, JTextField tf_examName, JTextField tf_examDegree, String level) {
        String message;
        FocusLostOrGained(comboBox);
        if (!comboBox.getSelectedItem().toString().equals("") && !comboBox.getSelectedItem().toString().equals("غير موجود")) {
            int exam_code = Integer.parseInt(comboBox.getSelectedItem().toString());
            String name = "";
            double degree = 0;
            try {
                Connection con = general_connection();
                PreparedStatement stmt = con.prepareStatement("select exam_name,exam_degree from exam where exam_code=? and level_name=?");
                stmt.setInt(1, exam_code);
                stmt.setString(2, level);
                ResultSet res = stmt.executeQuery();
                // check if found the student or not
                while (res.next()) {
                    name = res.getString("exam_name");
                    degree = res.getDouble("exam_degree");
                }
                if (name.equals("")) {
                    comboBox.setSelectedIndex(0);
                    message = "هذا الامتحان  غير موجود";
                    jOptionPaneMessage(message, 0);
                    tf_examName.setText(name);
                    tf_examDegree.setText("");
                    return;
                }
                tf_examName.setText(name);
                tf_examDegree.setText(String.valueOf(degree));

            } catch (SQLException ex) {
                handleSqlExceptions(ex.getErrorCode());
            }
        }
    }

    // search for student code by name and level
    public static void searchForQuizCodeByName(JTextField tf_code, JTextField tf_quizName, String level) {
        FocusLostOrGained(tf_quizName);
        if (!tf_quizName.getText().equals("")) {
            String name = tf_quizName.getText();
            int quiz_code = -1;
            // get the student data from student table
            try {
                Connection con = general_connection();
                PreparedStatement stmt = con.prepareStatement("select quiz_code from quiz where quiz_name=? and level_name=?");
                stmt.setString(1, name);
                stmt.setString(2, level);
                ResultSet res = stmt.executeQuery();
                // check if found the student or not
                while (res.next()) {
                    quiz_code = res.getInt("quiz_code");
                }

                tf_code.setText(String.valueOf(quiz_code));

            } catch (SQLException ex) {
                handleSqlExceptions(ex.getErrorCode());
            }
        }
    }

    // load the predicted names in the list depend on the name and the level
    public static void loadPredictedNamesDependOnQuizNameAndLevel(JTextField tf_quizName, String level, JList lst_searchQuiz, JPanel pl_searchQuiz) {
        String tempName = tf_quizName.getText();
        // get the student names from student table
        try {
            Connection con = general_connection();
            PreparedStatement stmt = con.prepareStatement("select quiz_name from quiz where quiz_name like " + "\'" + "%" + tempName + "%" + "\' and level_name=?");
            stmt.setString(1, level);
            ResultSet res = stmt.executeQuery();
            DefaultListModel dlm = new DefaultListModel();
            dlm.clear();
            while (res.next()) {
                String name = res.getString("quiz_name");
                dlm.addElement(name);
            }
            lst_searchQuiz.setModel(dlm);
            pl_searchQuiz.setVisible(true);
        } catch (SQLException ex) {
            handleSqlExceptions(ex.getErrorCode());
        }

    }

    // load the table of external money in specific month
    public static void loadExternalMoney(JTable t, String month) {
        try {
            Connection con = general_connection();
            PreparedStatement stmt = con.prepareStatement("select * from external_money where month=?");
            stmt.setString(1, month);
            ResultSet set = stmt.executeQuery();

            DefaultTableModel dm = new DefaultTableModel();

            dm.addColumn("التاريخ");
            dm.addColumn("المبلغ المدفوع");
            dm.addColumn("سبب الدفع");
            dm.addColumn("الشخص المدفوع لة");

            while (set.next()) {

                String r[] = {set.getString(4), String.valueOf(set.getInt(3)), set.getString(2),
                    set.getString(1)};
                dm.addRow(r);
            }
            t.setModel(dm);

        } catch (SQLException ex) {
            System.out.println("Error" + ex.getErrorCode());
        }
    }

    // load the level of the student in the combobox
    public static void loadLevel(JComboBox cb) {
        DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
        PreparedStatement stmt;
        ResultSet resultSet;
        String level_name;
        dcbm.addElement("اختر الفرقة");
        try {

            Connection con = general_connection();
            stmt = con.prepareStatement("select * from student_level");
            resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                level_name = resultSet.getString("level_name");
                dcbm.addElement(level_name);
            }
        } catch (SQLException ex) {
            handleSqlExceptions(ex.getErrorCode());
        }
        cb.setModel(dcbm);
    }

    // load the level of the student in the table
    public static void loadLevel(JTable table) {
        DefaultTableModel dtm = new DefaultTableModel();
        PreparedStatement stmt;
        ResultSet resultSet;
        String level_name;
        int monthCost;
        int maxNumber;
        try {
            Connection con = general_connection();
            stmt = con.prepareStatement("select * from student_level");
            resultSet = stmt.executeQuery();
            dtm.addColumn("الحد الاقصى");
            dtm.addColumn("المصاريف الشهرية");
            dtm.addColumn("اسم الفرقة");

            while (resultSet.next()) {
                level_name = resultSet.getString("level_name");
                monthCost = resultSet.getInt("month_cost");
                maxNumber = resultSet.getInt("max_number");
                String r[] = {String.valueOf(maxNumber), String.valueOf(monthCost), level_name};
                dtm.addRow(r);
            }
        } catch (SQLException ex) {
            handleSqlExceptions(ex.getErrorCode());
        }
        table.setModel(dtm);
    }

    // this function will load the table of the secretary
    public static void loadSecretary(JTable table) {
        DefaultTableModel dtm = new DefaultTableModel();
        PreparedStatement stmt;
        ResultSet resultSet;
        String code;
        String name;
        String password;

        try {
            Connection con = general_connection();
            stmt = con.prepareStatement("select * from secretary");
            resultSet = stmt.executeQuery();
            dtm.addColumn("الباسورد");
            dtm.addColumn("الاسم");
            dtm.addColumn("الكود");

            while (resultSet.next()) {
                code = resultSet.getString("secretary_code");
                name = resultSet.getString("secretary_name");
                password = resultSet.getString("secretary_password");
                if (code.equals("admin")) {
                    continue;
                }
                String r[] = {password, name, code};
                dtm.addRow(r);
            }
        } catch (SQLException ex) {
            handleSqlExceptions(ex.getErrorCode());
        }
        table.setModel(dtm);
    }

    // load student that attend a class in a level
    public static void loadStudentThatAttendClass(JTable table, String level, String group, int class_number) {
        Connection con = general_connection();
        PreparedStatement stmt;
        ResultSet resultSet;
        DefaultTableModel dtm = new DefaultTableModel();
        String date;
        String time;
        String student_name;
        int code;
        try {
            stmt = con.prepareStatement("select * from student_class_connection where level_name=? and class_number=? and group_name=?");
            stmt.setString(1, level);
            stmt.setInt(2, class_number);
            stmt.setString(3, group);
            resultSet = stmt.executeQuery();

            dtm.addColumn("التوقيت");
            dtm.addColumn("التاريخ");
            dtm.addColumn("اسم الطالب");
            dtm.addColumn("كود الطالب");
            while (resultSet.next()) {
                code = resultSet.getInt("student_code");
                student_name = resultSet.getString("student_name");
                date = resultSet.getString("attendance_date");
                time = resultSet.getString("attendance_time");
                String r[] = {time, date, student_name, String.valueOf(code)};
                dtm.addRow(r);
            }
            table.setModel(dtm);
        } catch (SQLException ex) {
            handleSqlExceptions(ex.getErrorCode());
        }
    }

    // send a messagedialog depend on the sqlexception error code
    public static void handleSqlExceptions(int code) {
        String message;
        switch (code) {
            case 0:
                message = "فشل الاتصال بقاعدة البيانات"
                        + " ان استمرت المشكله الرجاء الاتصال بالمختصين";
                jOptionPaneMessage(message, 0);
                System.out.println(code);
                break;
            case 1062:
                message = "تم الاضافة من قبل";
                jOptionPaneMessage(message, 0);
                System.out.println(code);
                break;
            case 1054:
                message = "هذا خطا من النظام الرجاء الاتصال بالمختصين";
                jOptionPaneMessage(message, 0);
                System.out.println(code);
                break;
            case 1265:
                message = "رجاء ادخل القيم بطريقة صحيحه";
                jOptionPaneMessage(message, 0);
                System.out.println(code);
                break;
            default:
                System.out.println(code);
                break;
        }
    }

    // check wheater the textfield is empty
    public static boolean checkEmpty(JTextField tf) {
        String message;
        if ((tf.getText().trim()).equals("")) {
            tf.setBorder(new LineBorder(Color.red, 2, true));
            tf.setText("");
            message = "تاكد من ملئ كل الفراغات المجاوره للعلامة الحمراء  ";
            jOptionPaneMessage(message, 0);
            return false;
        }
        return true;
    }

    public static boolean checkEmpty(JDateChooser dc) {
        String message;
        if (((JTextField) dc.getDateEditor().getUiComponent()).getText().trim().equals("")) {
            dc.setBorder(new LineBorder(Color.red, 2, true));
            ((JTextField) dc.getDateEditor().getUiComponent()).setText("");
            message = "تاكد من ملئ كل الفراغات المجاوره للعلامة الحمراء  ";
            jOptionPaneMessage(message, 0);
            return false;
        }
        return true;
    }

    // check wheater the textfield is empty
    public static boolean checkEmpty(JTextArea ta) {
        String message;
        if ((ta.getText().trim()).equals("")) {
            ta.setBorder(new LineBorder(Color.red, 2, true));
            ta.setText("");
            message = "تاكد من ملئ كل الفراغات المجاوره للعلامة الحمراء  ";
            jOptionPaneMessage(message, 0);
            return false;
        }
        return true;
    }

    // check if the level not selected from the combobox
    public static boolean checkEmpty(JComboBox cb) {
        String message;
        switch (cb.getSelectedItem().toString()) {
            case "اختر الفرقة":
                cb.setBorder(new LineBorder(Color.red, 2, true));
                message = "تاكد من اضافة الفرقة";
                jOptionPaneMessage(message, 0);
                return false;
            case "اختر المجموعة":
                cb.setBorder(new LineBorder(Color.red, 2, true));
                message = "تاكد من اضافة المجموعة";
                jOptionPaneMessage(message, 0);
                return false;
            case "اختر الشهر":
                cb.setBorder(new LineBorder(Color.red, 2, true));
                message = "تاكد من اضافة الشهر";
                jOptionPaneMessage(message, 0);
                return false;
            case "اختر المذكرة":
                cb.setBorder(new LineBorder(Color.red, 2, true));
                message = "تاكد من اضافة المذكرة";
                jOptionPaneMessage(message, 0);
                return false;
            case "اختر التسميع":
                cb.setBorder(new LineBorder(Color.red, 2, true));
                message = "تاكد من اضافة تسميع";
                jOptionPaneMessage(message, 0);
                return false;
            case "اختر الامتحان":
                cb.setBorder(new LineBorder(Color.red, 2, true));
                message = "تاكد من اضافة امتحان";
                jOptionPaneMessage(message, 0);
                return false;
            case "اختر رقم الحصة":
                cb.setBorder(new LineBorder(Color.red, 2, true));
                message = "تاكد من اضافة حصة";
                jOptionPaneMessage(message, 0);
                return false;
            default:
                break;
        }
        return true;
    }

    // check if nothing added to the jlist
    public static boolean checkEmpty(JList list) {
        String message;
        if (list.getModel().getSize() == 0) {
            message = "تاكد من اضافة مجموعة واحده على الاقل";
            list.setBorder(new LineBorder(Color.red, 2, true));
            jOptionPaneMessage(message, 0);
            return false;
        }
        return true;
    }

    // if there an error make the textfield red
    public static void makeRed(JTextField tf) {
        tf.setBorder(new LineBorder(Color.red, 2, true));
    }

    // when adding a new group check if all the groups total is less than or equal level total
    public static boolean checkExceedLevelWhenAddOrUpdateGroup(int currentGroup, String level, String operation, String group) {

        PreparedStatement stmt;
        ResultSet resultSet;
        String message;
        int maxNumber = 0;
        if (operation.equals("add")) {
            try {
                Connection con = general_connection();
                stmt = con.prepareStatement("select max_number from student_level where level_name=?");
                stmt.setString(1, level);
                resultSet = stmt.executeQuery();

                while (resultSet.next()) {
                    maxNumber = resultSet.getInt(1);
                }

                if (currentGroup > maxNumber) {
                    message = "لقد تخطيت الحد الاقصى للاضافة بمجموع  " + currentGroup
                            + "   " + "من اصل" + "   " + maxNumber + "   "
                            + "بفارق" + "   " + (currentGroup - maxNumber) + "   " + "يمكنك تعديل الحد الاقصى للفرقة من ادارة الفرق";
                    jOptionPaneMessage(message, 0);
                    return false;
                }

            } catch (SQLException ex) {
                handleSqlExceptions(ex.getErrorCode());
            }
        } else if (operation.equals("update")) {
            try {
                Connection con = general_connection();
                stmt = con.prepareStatement("select max_number from student_level where level_name=?");
                stmt.setString(1, level);
                resultSet = stmt.executeQuery();

                while (resultSet.next()) {
                    maxNumber = resultSet.getInt(1);
                }

                if (currentGroup > maxNumber) {
                    message = "لقد تخطيت الحد الاقصى للاضافة بمجموع  " + currentGroup
                            + "   " + "من اصل" + "   " + maxNumber + "   "
                            + "بفارق" + "   " + (currentGroup - maxNumber) + "   " + "يمكنك تعديل الحد الاقصى للفرقة من ادارة الفرق";
                    jOptionPaneMessage(message, 0);
                    return false;
                }

            } catch (SQLException ex) {
                handleSqlExceptions(ex.getErrorCode());
            }
        }

        return true;
    }

    // when adding new student check if the students added total is less than group max total
    // note that the flag parameters only to determine which integer value will be return the max or the avialabe
    public static int checkExceedGroupWhenAddStudent(String level_name, String group_name, int flag) {
        PreparedStatement stmt;
        ResultSet resultSet;
        int maxNumber = 0;
        int avilable = 0;
        try {
            Connection con = general_connection();
            stmt = con.prepareStatement("select student_group.maxNumber as MaxNumber, count(student_group_connection.student_code) as avilable from student_group,student_group_connection where student_group.level_name=? and student_group_connection.level_name=? and student_group_connection.group_name=? and student_group.group_name=?");
            stmt.setString(1, level_name);
            stmt.setString(2, level_name);
            stmt.setString(3, group_name);
            stmt.setString(4, group_name);
            resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                maxNumber = resultSet.getInt(1);
                avilable = resultSet.getInt(2);
            }

            if (flag == 1) {
                return avilable;
            }
            if (flag == 0) {
                return maxNumber;
            }
        } catch (SQLException ex) {
            handleSqlExceptions(ex.getErrorCode());
        }
        return 0;
    }

    // when adding new student check if that student exceed the max number of the level or not
    public static boolean checkExceedLevelWhenAddStudent(String level_name) {
        PreparedStatement stmt;
        ResultSet resultSet;
        int maxNumber = 0;
        int avilable = 0;
        String message;
        try {
            Connection con = general_connection();
            stmt = con.prepareStatement("select student_level.max_number, count(student.student_code) from student, student_level where student_level.level_name=? and student.level_name=? and student.student_status != ?");
            stmt.setString(1, level_name);
            stmt.setString(2, level_name);
            stmt.setString(3, "موقوف");
            resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                maxNumber = resultSet.getInt(1);
                avilable = resultSet.getInt(2);
            }

            if (avilable + 1 > maxNumber) {
                message = "هذة الفرقة ممتلئة لا يمكن اضافة طلاب اكثر بها يمكنك تعديل سعة الفرقة من ادارة الفرق";
                jOptionPaneMessage(message, 0);
                return false;
            }
        } catch (SQLException ex) {
            handleSqlExceptions(ex.getErrorCode());
        }
        return true;
    }

    // check if the student degree is bigger than total degree.
    public static boolean checkExceedStudentDegree(JTextField tf_studentDegree, JTextField tf_quizDegree) {
        double student_degree = Double.parseDouble(tf_studentDegree.getText());
        double quiz_degree = Double.parseDouble(tf_quizDegree.getText());
        if (student_degree > quiz_degree) {
            String message = "درجات الطالب اكبر من الدرجة الكلية";
            makeRed(tf_studentDegree);
            jOptionPaneMessage(message, 0);
            return false;
        }
        return true;
    }

    // this function will check if the student in the group when need to attend it or not
    public static boolean checkIfStudentInTheGroupOrNot(int code, JComboBox cb_group, JComboBox cb_level) {
        PreparedStatement stmt;
        ResultSet resultSet;
        String group_name = cb_group.getSelectedItem().toString();
        String level_name = cb_level.getSelectedItem().toString();
        int student_code = -1;
        Connection con = general_connection();
        try {
            stmt = con.prepareStatement("select student_code from student_group_connection where  group_name=? and student_code=? and level_name=?");
            stmt.setString(1, group_name);
            stmt.setInt(2, code);
            stmt.setString(3, level_name);
            resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                student_code = resultSet.getInt("student_code");
            }
            if (String.valueOf(student_code).equals("") || student_code == -1) {
                jOptionPaneMessage("هذا الطالب غير موجود في هذه المجموعة", 0);
                return false;
            }

        } catch (SQLException ex) {
            handleSqlExceptions(ex.getErrorCode());
        }

        return true;
    }

    // check if the student attend the class in different group or not
    public static boolean checkIfStudentAttendTheClassOrNot(int code, JComboBox cb_class, JComboBox cb_level) {
        PreparedStatement stmt;
        ResultSet resultSet;
        int class_number = Integer.parseInt(cb_class.getSelectedItem().toString());
        String level_name = cb_level.getSelectedItem().toString();
        String student_code = "";
        Connection con = general_connection();
        try {
            stmt = con.prepareStatement("select student_code from student_class_connection where  class_number=? and student_code=? and level_name=?");
            stmt.setInt(1, class_number);
            stmt.setInt(2, code);
            stmt.setString(3, level_name);
            resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                student_code = resultSet.getString("student_code");
            }
            if (!String.valueOf(student_code).equals("")) {
                jOptionPaneMessage("هذا الطالب تم تحضيره في هذه الحصه من قبل", 0);
                return false;
            }

        } catch (SQLException ex) {
            handleSqlExceptions(ex.getErrorCode());
        }

        return true;
    }

    // this function will take the message and the type of the message and show it as JOptionPane message
    public static void jOptionPaneMessage(String message, int type) {
        String title;
        switch (type) {
            case 0:
                title = "خطا";
                break;
            case 1:
                title = "اعلام";
                break;
            case 2:
                title = "تحذير";
                break;
            case 3:
                title = "استفهام";
                break;
            default:
                title = "title";
        }
        JOptionPane.showMessageDialog(null, message, title, type);
    }

    // message appear to inform delete
    public static void deleteMessage() {
        JOptionPane.showMessageDialog(null, "تم الحذف بنجاح", "اعلام", 1);
    }
    // message appear to inform add

    public static void addMessage() {
        JOptionPane.showMessageDialog(null, "تم الاضافة بنجاح", "اعلام", 1);
    }
    // message appear to inform update

    public static void updateMessage() {
        JOptionPane.showMessageDialog(null, "تم التعديل بنجاح", "اعلام", 1);
    }
    // message appear to inform stop

    public static void stopMessage() {
        JOptionPane.showMessageDialog(null, "تم الايقاف  بنجاح", "اعلام", 1);
    }

    public static void updateHolder(String user_code, String user_name, String user_password) {
        PreparedStatement stmt;
        Connection con = general_connection();
        try {
            stmt = con.prepareStatement("update holder set user_code=? , user_name=?, user_password=? ");
            stmt.setString(1, user_code);
            stmt.setString(2, user_name);
            stmt.setString(3, user_password);
            stmt.execute();
        } catch (SQLException ex) {
            handleSqlExceptions(ex.getErrorCode());
        }
    }

    // return the name of the user that enter the database
    public static String loadHolderName() {
        PreparedStatement stmt;
        Connection con = general_connection();
        ResultSet resultSet;
        String user_name = "";
        try {
            stmt = con.prepareStatement("select user_name from holder");
            resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                user_name = resultSet.getString("user_name");
            }
            return user_name;
        } catch (SQLException ex) {
            handleSqlExceptions(ex.getErrorCode());
        }
        return null;
    }

    // return the code of the user that enter the database
    public static String loadHolderCode() {
        PreparedStatement stmt;
        Connection con = general_connection();
        ResultSet resultSet;
        String user_code = "";
        try {
            stmt = con.prepareStatement("select user_code from holder");
            resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                user_code = resultSet.getString("user_code");
            }
            return user_code;
        } catch (SQLException ex) {
            handleSqlExceptions(ex.getErrorCode());
        }
        return null;
    }

    // return the password of the user that enter the database
    public static String loadHolderPassword() {
        PreparedStatement stmt;
        Connection con = general_connection();
        ResultSet resultSet;
        String user_password = "";
        try {
            stmt = con.prepareStatement("select user_password from holder");
            resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                user_password = resultSet.getString("user_password");
            }
            return user_password;
        } catch (SQLException ex) {
            handleSqlExceptions(ex.getErrorCode());
        }
        return null;
    }

    // record the event of the secretary and who do the event "مراقبة النظام"
    public static void recordEvent(String eventKind, String eventName, String theEvent) {
        String user_code = loadHolderCode();
        String user_name = loadHolderName();
        String time = getTime();
        String date = getDate();
        Connection adminCon = admin_connection();
        PreparedStatement stmt;
        try {
            stmt = adminCon.prepareStatement("insert into system_monitoring values(?,?,?,?,?,?,?)");
            stmt.setString(1, user_code);
            stmt.setString(2, user_name);
            stmt.setString(3, eventKind);
            stmt.setString(4, eventName);
            stmt.setString(5, theEvent);
            stmt.setString(6, date);
            stmt.setString(7, time);
            stmt.execute();
        } catch (SQLException ex) {
            handleSqlExceptions(ex.getErrorCode());
        }
    }

    // load the data in system Monitoring table
    public static void loadSystemView(String first_date, String second_date, JTable t_events) {
        DefaultTableModel dtm = new DefaultTableModel();
        Connection con = admin_connection();
        PreparedStatement stmt;
        ResultSet resultSet;
        try {
            stmt = con.prepareStatement("select * from system_monitoring where event_date between cast(? as date) and cast(? as date) order by cast(event_date as date)desc, cast(event_time as time) desc ");
            stmt.setString(1, first_date);
            stmt.setString(2, second_date);
            resultSet = stmt.executeQuery();
            dtm.addColumn("الوقت");
            dtm.addColumn("التاريخ");
            dtm.addColumn("الحدث");
            dtm.addColumn("اسم الحدث");
            dtm.addColumn("نوع الحدث");
            dtm.addColumn("اسم السكرتير");
            dtm.addColumn("كود السكرتير");
            while (resultSet.next()) {
                String r[] = {
                    resultSet.getString(7),
                    resultSet.getString(6),
                    resultSet.getString(5),
                    resultSet.getString(4),
                    resultSet.getString(3),
                    resultSet.getString(2),
                    resultSet.getString(1)
                };
                dtm.addRow(r);
            }

            t_events.setModel(dtm);
            changeTheWidthOfTableColumn(t_events, 2, 550);  // the event
            changeTheWidthOfTableColumn(t_events, 3, 200);  // eventName

        } catch (SQLException ex) {
            handleSqlExceptions(ex.getErrorCode());
        }
    }

    // change the width of the column in a table to 170
    public static void changeTheWidthOfTableColumn(JTable table, int columnIndex) {
        TableColumnModel tcm = table.getColumnModel();
        tcm.getColumn(columnIndex).setPreferredWidth(170);
    }

    // change the width of the column in a table to specified amount
    public static void changeTheWidthOfTableColumn(JTable table, int columnIndex, int amount) {
        TableColumnModel tcm = table.getColumnModel();
        tcm.getColumn(columnIndex).setPreferredWidth(amount);
    }

}
