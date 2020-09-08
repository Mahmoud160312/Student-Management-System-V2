/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Secretary;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import static newatomicstudent.functions.defaultAfterHover;
import static newatomicstudent.functions.enter;
import static newatomicstudent.functions.hoverInMouseClicked;
import static newatomicstudent.functions.hoverInMouseMotion;
import static newatomicstudent.functions.textFieldValidation;
import static newatomicstudent.functions.loadLevel;
import static newatomicstudent.functions.*;
import static newatomicstudent.functions.general_connection;

/**
 *
 * @author mahmo
 */
public class StudentManagement extends javax.swing.JFrame {

    // general_connection with the database
    Connection con;
    // this variable is very important for printing will determine which content will be printed depend on the buttons clicked
    int printTableDetermination = -1;
    DefaultListModel dlm14 = new DefaultListModel();

    /**
     * Creates new form StudentManagement
     */
    public StudentManagement() {
        initComponents();
        setIcon();
        // connect to the database
        con = general_connection();

        // set all panels not visible except add panel and make the button add student request focus
        hoverInMouseClicked(btn_add);
        pl_addingStudent.setVisible(true);
        pl_notes.setVisible(false);
        pl_searchingStudent.setVisible(false);
        pl_viewingStudent.setVisible(false);
        btn_print.setVisible(false);

        //************************ this for adding panel********************///////
        // load the level and group 
        loadLevel(cb_level);
        loadGroup(lst_have, cb_level.getSelectedItem().toString());

        // set the transfere labels between groups false
        lb_haveToAdd.setEnabled(false);
        lb_addToHave.setEnabled(false);

        //************************ this for searching panel*****************///////
        // load the level and group 
        loadLevel(cb_level1);
        loadGroup(lst_added1, cb_level1.getSelectedItem().toString());
        // set the transfere labels between groups false
        lb_haveToAdd1.setEnabled(false);
        lb_addToHave1.setEnabled(false);
        tf_code1.setEnabled(false);
        tf_studentName1.setEnabled(false);
        btn_update.setEnabled(false);
        btn_stop.setEnabled(false);
        btn_delete.setEnabled(false);
        lst_have1.setModel(dlm14);
        lst_added1.setModel(dlm14);
        lst_searchNames.setModel(dlm14);
        pl_searchNames.setVisible(false);

        // viewing panel
        loadLevel(cb_level2);
        loadGroup(cb_group, cb_level2.getSelectedItem().toString());

        // notes panel 
        lb_written_by.setText(loadHolderName());
        lb_written_date.setText(getDate());
        loadLevel(cb_level3);
        tf_code2.setEnabled(false);
        tf_studentName3.setEnabled(false);
        btn_delete1.setEnabled(true);
        ta_newNote.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        // change cursor pointer to hand cursor in all buttons;
        changeCurssorWhenEnterButton(btn_add);
        changeCurssorWhenEnterButton(btn_Setting);
        changeCurssorWhenEnterButton(btn_clean);
        changeCurssorWhenEnterButton(btn_clean1);
        changeCurssorWhenEnterButton(btn_clean2);
        changeCurssorWhenEnterButton(btn_delete);
        changeCurssorWhenEnterButton(btn_delete1);
        changeCurssorWhenEnterButton(btn_notes);
        changeCurssorWhenEnterButton(btn_clean);
        changeCurssorWhenEnterButton(btn_print);
        changeCurssorWhenEnterButton(btn_delete);
        changeCurssorWhenEnterButton(btn_home);
        changeCurssorWhenEnterButton(btn_update);
        changeCurssorWhenEnterButton(btn_save);
        changeCurssorWhenEnterButton(btn_savenote);
        changeCurssorWhenEnterButton(btn_search);
        changeCurssorWhenEnterButton(btn_search1);
        changeCurssorWhenEnterButton(btn_search2);
        changeCurssorWhenEnterButton(btn_stop);
        changeCurssorWhenEnterButton(btn_view);
        changeCurssorWhenEnterButton(btn_viewAll);
        changeCurssorWhenEnterButton(btn_viewGroup);
        changeCurssorWhenEnterButton(btn_viewLevel);
        changeCurssorWhenEnterButton(btn_viewStudent);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        sp_studentManagement = new javax.swing.JScrollPane();
        pl_background = new javax.swing.JPanel();
        pl_topButtonControl = new javax.swing.JPanel();
        lp_empty = new javax.swing.JLabel();
        lp_empty1 = new javax.swing.JLabel();
        lp_empty2 = new javax.swing.JLabel();
        btn_notes = new javax.swing.JButton();
        btn_view = new javax.swing.JButton();
        btn_search = new javax.swing.JButton();
        btn_add = new javax.swing.JButton();
        StudentManagement = new javax.swing.JLayeredPane();
        pl_addingStudent = new javax.swing.JPanel();
        pl_verticalLine = new javax.swing.JPanel();
        pl_horizontalBottomLine = new javax.swing.JPanel();
        lb_avilable = new javax.swing.JLabel();
        lb_maxavalible = new javax.swing.JLabel();
        lb_added = new javax.swing.JLabel();
        lb_have = new javax.swing.JLabel();
        lb_addToHave = new javax.swing.JLabel();
        lb_haveToAdd = new javax.swing.JLabel();
        sp_addedd = new javax.swing.JScrollPane();
        lst_added = new javax.swing.JList<>();
        sp_have = new javax.swing.JScrollPane();
        lst_have = new javax.swing.JList<>();
        lb_star = new javax.swing.JLabel();
        lb_star3 = new javax.swing.JLabel();
        pl_studentData = new javax.swing.JPanel();
        tf_code = new javax.swing.JTextField();
        lb_code = new javax.swing.JLabel();
        tf_studentName = new javax.swing.JTextField();
        lb_studentName = new javax.swing.JLabel();
        tf_studentPhone = new javax.swing.JTextField();
        lb_studentPhone = new javax.swing.JLabel();
        tf_address = new javax.swing.JTextField();
        lb_address = new javax.swing.JLabel();
        cb_level = new javax.swing.JComboBox<>();
        lb_level = new javax.swing.JLabel();
        pl_parentData = new javax.swing.JPanel();
        tf_parentName = new javax.swing.JTextField();
        lb_parentName = new javax.swing.JLabel();
        tf_parentPhone = new javax.swing.JTextField();
        lb_phone = new javax.swing.JLabel();
        tf_job = new javax.swing.JTextField();
        lb_job = new javax.swing.JLabel();
        tf_relativity = new javax.swing.JTextField();
        lb_relativity = new javax.swing.JLabel();
        btn_save = new javax.swing.JButton();
        btn_clean1 = new javax.swing.JButton();
        lb_star5 = new javax.swing.JLabel();
        lb_star15 = new javax.swing.JLabel();
        lb_star2 = new javax.swing.JLabel();
        lb_star4 = new javax.swing.JLabel();
        pl_searchingStudent = new javax.swing.JPanel();
        pl_parentData1 = new javax.swing.JPanel();
        tf_parentName1 = new javax.swing.JTextField();
        lb_parentName1 = new javax.swing.JLabel();
        tf_parentPhone1 = new javax.swing.JTextField();
        lb_parentPhone1 = new javax.swing.JLabel();
        tf_job1 = new javax.swing.JTextField();
        lb_parentJob1 = new javax.swing.JLabel();
        tf_relativity1 = new javax.swing.JTextField();
        lb_relativity1 = new javax.swing.JLabel();
        sp_have1 = new javax.swing.JScrollPane();
        lst_have1 = new javax.swing.JList<>();
        sp_added1 = new javax.swing.JScrollPane();
        lst_added1 = new javax.swing.JList<>();
        pl_studentData1 = new javax.swing.JPanel();
        tf_studentName2 = new javax.swing.JTextField();
        lb_studentName2 = new javax.swing.JLabel();
        tf_address1 = new javax.swing.JTextField();
        lb_address1 = new javax.swing.JLabel();
        tf_studentPhone1 = new javax.swing.JTextField();
        lb_studentPhone1 = new javax.swing.JLabel();
        pl_studentDataForSearch = new javax.swing.JPanel();
        cb_level1 = new javax.swing.JComboBox<>();
        lb_levelName1 = new javax.swing.JLabel();
        tf_code1 = new javax.swing.JTextField();
        lb_code1 = new javax.swing.JLabel();
        tf_studentName1 = new javax.swing.JTextField();
        lb_studentName1 = new javax.swing.JLabel();
        lb_parentData = new javax.swing.JLabel();
        rb_code = new javax.swing.JRadioButton();
        rb_name = new javax.swing.JRadioButton();
        lb_studentData = new javax.swing.JLabel();
        lb_haveToAdd1 = new javax.swing.JLabel();
        lb_addToHave1 = new javax.swing.JLabel();
        lb_added1 = new javax.swing.JLabel();
        lb_have1 = new javax.swing.JLabel();
        btn_clean = new javax.swing.JButton();
        btn_search1 = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_stop = new javax.swing.JButton();
        lb_star6 = new javax.swing.JLabel();
        lb_star7 = new javax.swing.JLabel();
        lb_star8 = new javax.swing.JLabel();
        lb_star9 = new javax.swing.JLabel();
        lb_star10 = new javax.swing.JLabel();
        lb_status = new javax.swing.JLabel();
        tf_status = new javax.swing.JTextField();
        lb_star16 = new javax.swing.JLabel();
        tf_avilable = new javax.swing.JTextField();
        lb_status1 = new javax.swing.JLabel();
        pl_verticalLine1 = new javax.swing.JPanel();
        pl_horizontalBottomLine1 = new javax.swing.JPanel();
        lb_star18 = new javax.swing.JLabel();
        pl_searchNames = new javax.swing.JPanel();
        sp_searchNames = new javax.swing.JScrollPane();
        lst_searchNames = new javax.swing.JList<>();
        pl_notes = new javax.swing.JPanel();
        btn_search2 = new javax.swing.JButton();
        btn_clean2 = new javax.swing.JButton();
        rb_studentCode = new javax.swing.JRadioButton();
        rb_studentName = new javax.swing.JRadioButton();
        pl_horizontalLine = new javax.swing.JPanel();
        pl_verticalSeperatePanel = new javax.swing.JPanel();
        lb_noteScript = new javax.swing.JLabel();
        sp_newNote = new javax.swing.JScrollPane();
        ta_newNote = new javax.swing.JTextArea();
        sp_oldNote = new javax.swing.JScrollPane();
        t_oldNote = new javax.swing.JTable();
        lb_oldNote = new javax.swing.JLabel();
        btn_savenote = new javax.swing.JButton();
        btn_delete1 = new javax.swing.JButton();
        lb_noteScript1 = new javax.swing.JLabel();
        lb_written_date = new javax.swing.JLabel();
        lb_write = new javax.swing.JLabel();
        lb_written_by = new javax.swing.JLabel();
        lb_star13 = new javax.swing.JLabel();
        lb_star14 = new javax.swing.JLabel();
        pl_studentDataForSearch1 = new javax.swing.JPanel();
        cb_level3 = new javax.swing.JComboBox<>();
        lb_levelName2 = new javax.swing.JLabel();
        tf_code2 = new javax.swing.JTextField();
        lb_code2 = new javax.swing.JLabel();
        tf_studentName3 = new javax.swing.JTextField();
        lb_studentName4 = new javax.swing.JLabel();
        lb_star17 = new javax.swing.JLabel();
        pl_viewingStudent = new javax.swing.JPanel();
        cb_group = new javax.swing.JComboBox<>();
        cb_level2 = new javax.swing.JComboBox<>();
        lb_classification = new javax.swing.JLabel();
        pl_checkBoxForParent = new javax.swing.JPanel();
        chb_parentName = new javax.swing.JCheckBox();
        chb_parentPhone = new javax.swing.JCheckBox();
        chb_parentJob = new javax.swing.JCheckBox();
        pl_parents = new javax.swing.JPanel();
        lb_parentName2 = new javax.swing.JLabel();
        lb_parentPhone2 = new javax.swing.JLabel();
        lb_parentJob2 = new javax.swing.JLabel();
        pl_student = new javax.swing.JPanel();
        lb_studentName5 = new javax.swing.JLabel();
        lb_studentPhone5 = new javax.swing.JLabel();
        lb_address5 = new javax.swing.JLabel();
        lb_date = new javax.swing.JLabel();
        lb_level1 = new javax.swing.JLabel();
        pl_seperateLine = new javax.swing.JPanel();
        pl_checkBoxForStudent = new javax.swing.JPanel();
        chb_studentName = new javax.swing.JCheckBox();
        chb_studentPhone = new javax.swing.JCheckBox();
        chb_address = new javax.swing.JCheckBox();
        chb_date = new javax.swing.JCheckBox();
        chb_level = new javax.swing.JCheckBox();
        pl_verticalSeperateLine = new javax.swing.JPanel();
        btn_viewStudent = new javax.swing.JButton();
        sp_studentData = new javax.swing.JScrollPane();
        t_viewStudentData = new javax.swing.JTable();
        pl_viewButtonsControl = new javax.swing.JPanel();
        btn_viewAll = new javax.swing.JButton();
        btn_viewLevel = new javax.swing.JButton();
        btn_viewGroup = new javax.swing.JButton();
        lb_star11 = new javax.swing.JLabel();
        lb_star12 = new javax.swing.JLabel();
        lb_number = new javax.swing.JLabel();
        lb_number1 = new javax.swing.JLabel();
        pl_bottomButtonCotrol = new javax.swing.JPanel();
        btn_print = new javax.swing.JButton();
        lb_empty3 = new javax.swing.JLabel();
        lb_empty4 = new javax.swing.JLabel();
        btn_home = new javax.swing.JButton();
        btn_Setting = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pl_background.setBackground(new java.awt.Color(255, 255, 255));
        pl_background.setMinimumSize(new java.awt.Dimension(1205, 650));
        pl_background.setPreferredSize(new java.awt.Dimension(1237, 700));

        pl_topButtonControl.setBackground(new java.awt.Color(19, 64, 93));
        pl_topButtonControl.setMinimumSize(new java.awt.Dimension(1205, 60));
        pl_topButtonControl.setPreferredSize(new java.awt.Dimension(1205, 60));
        pl_topButtonControl.setLayout(new java.awt.GridLayout(1, 0, 10, 10));
        pl_topButtonControl.add(lp_empty);
        pl_topButtonControl.add(lp_empty1);
        pl_topButtonControl.add(lp_empty2);

        btn_notes.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        btn_notes.setForeground(new java.awt.Color(255, 255, 255));
        btn_notes.setText("ملحوظات");
        btn_notes.setContentAreaFilled(false);
        btn_notes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_notesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_notesMouseExited(evt);
            }
        });
        btn_notes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_notesActionPerformed(evt);
            }
        });
        pl_topButtonControl.add(btn_notes);

        btn_view.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        btn_view.setForeground(new java.awt.Color(255, 255, 255));
        btn_view.setText("عرض الطلاب");
        btn_view.setContentAreaFilled(false);
        btn_view.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_viewMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_viewMouseExited(evt);
            }
        });
        btn_view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_viewActionPerformed(evt);
            }
        });
        pl_topButtonControl.add(btn_view);

        btn_search.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        btn_search.setForeground(new java.awt.Color(255, 255, 255));
        btn_search.setText("بحث عن طالب");
        btn_search.setContentAreaFilled(false);
        btn_search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_searchMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_searchMouseExited(evt);
            }
        });
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });
        pl_topButtonControl.add(btn_search);

        btn_add.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        btn_add.setForeground(new java.awt.Color(255, 255, 255));
        btn_add.setText("اضافة طالب");
        btn_add.setContentAreaFilled(false);
        btn_add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_addMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_addMouseExited(evt);
            }
        });
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });
        pl_topButtonControl.add(btn_add);

        StudentManagement.setPreferredSize(new java.awt.Dimension(1205, 553));
        StudentManagement.setLayout(new java.awt.CardLayout());

        pl_addingStudent.setBackground(new java.awt.Color(255, 255, 255));
        pl_addingStudent.setPreferredSize(new java.awt.Dimension(1205, 541));

        pl_verticalLine.setBackground(new java.awt.Color(0, 155, 255));

        javax.swing.GroupLayout pl_verticalLineLayout = new javax.swing.GroupLayout(pl_verticalLine);
        pl_verticalLine.setLayout(pl_verticalLineLayout);
        pl_verticalLineLayout.setHorizontalGroup(
            pl_verticalLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );
        pl_verticalLineLayout.setVerticalGroup(
            pl_verticalLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 322, Short.MAX_VALUE)
        );

        pl_horizontalBottomLine.setBackground(new java.awt.Color(0, 155, 255));
        pl_horizontalBottomLine.setMinimumSize(new java.awt.Dimension(440, 5));

        javax.swing.GroupLayout pl_horizontalBottomLineLayout = new javax.swing.GroupLayout(pl_horizontalBottomLine);
        pl_horizontalBottomLine.setLayout(pl_horizontalBottomLineLayout);
        pl_horizontalBottomLineLayout.setHorizontalGroup(
            pl_horizontalBottomLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        pl_horizontalBottomLineLayout.setVerticalGroup(
            pl_horizontalBottomLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        lb_avilable.setBackground(new java.awt.Color(255, 255, 255));
        lb_avilable.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        lb_avilable.setForeground(new java.awt.Color(102, 102, 102));
        lb_avilable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_avilable.setText("اختر مجموعة ");

        lb_maxavalible.setBackground(new java.awt.Color(255, 255, 255));
        lb_maxavalible.setFont(new java.awt.Font("Cairo", 1, 16)); // NOI18N
        lb_maxavalible.setForeground(new java.awt.Color(102, 102, 102));
        lb_maxavalible.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lb_maxavalible.setText("متاح : ");

        lb_added.setBackground(new java.awt.Color(255, 255, 255));
        lb_added.setFont(new java.awt.Font("Cairo", 1, 17)); // NOI18N
        lb_added.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_added.setText("المضافة");

        lb_have.setBackground(new java.awt.Color(255, 255, 255));
        lb_have.setFont(new java.awt.Font("Cairo", 1, 17)); // NOI18N
        lb_have.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_have.setText("اختر المجموعات");

        lb_addToHave.setBackground(new java.awt.Color(255, 255, 255));
        lb_addToHave.setFont(new java.awt.Font("Cairo", 1, 24)); // NOI18N
        lb_addToHave.setForeground(new java.awt.Color(0, 153, 204));
        lb_addToHave.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_addToHave.setText(">>");
        lb_addToHave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb_addToHave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_addToHaveMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lb_addToHaveMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lb_addToHaveMouseExited(evt);
            }
        });

        lb_haveToAdd.setBackground(new java.awt.Color(255, 255, 255));
        lb_haveToAdd.setFont(new java.awt.Font("Cairo", 1, 24)); // NOI18N
        lb_haveToAdd.setForeground(new java.awt.Color(0, 153, 204));
        lb_haveToAdd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_haveToAdd.setText("<<");
        lb_haveToAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb_haveToAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_haveToAddMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lb_haveToAddMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lb_haveToAddMouseExited(evt);
            }
        });

        lst_added.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 155, 255)));
        lst_added.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        lst_added.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                lst_addedComponentAdded(evt);
            }
        });
        lst_added.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lst_addedValueChanged(evt);
            }
        });
        sp_addedd.setViewportView(lst_added);

        lst_have.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 155, 255)));
        lst_have.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        lst_have.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lst_haveValueChanged(evt);
            }
        });
        sp_have.setViewportView(lst_have);

        lb_star.setBackground(new java.awt.Color(255, 255, 255));
        lb_star.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_star.setForeground(new java.awt.Color(255, 0, 0));
        lb_star.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_star.setText("*");

        lb_star3.setBackground(new java.awt.Color(255, 255, 255));
        lb_star3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_star3.setForeground(new java.awt.Color(255, 0, 0));
        lb_star3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_star3.setText("*");

        pl_studentData.setBackground(new java.awt.Color(255, 255, 255));
        pl_studentData.setLayout(new java.awt.GridLayout(5, 2, 20, 20));

        tf_code.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        tf_code.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_code.setToolTipText("اكتب كود الطالب و تاكد من ان يكون رقم صحيح");
        tf_code.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 155, 255), 2, true));
        tf_code.setDoubleBuffered(true);
        tf_code.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_codeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tf_codeFocusLost(evt);
            }
        });
        tf_code.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_codeKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_codeKeyTyped(evt);
            }
        });
        pl_studentData.add(tf_code);
        tf_code.getAccessibleContext().setAccessibleName("");

        lb_code.setBackground(new java.awt.Color(255, 255, 255));
        lb_code.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_code.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_code.setText("كود الطالب");
        pl_studentData.add(lb_code);

        tf_studentName.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        tf_studentName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_studentName.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 155, 255), 2, true));
        tf_studentName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_studentNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tf_studentNameFocusLost(evt);
            }
        });
        tf_studentName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_studentNameKeyPressed(evt);
            }
        });
        pl_studentData.add(tf_studentName);

        lb_studentName.setBackground(new java.awt.Color(255, 255, 255));
        lb_studentName.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_studentName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_studentName.setText("اسم الطالب");
        pl_studentData.add(lb_studentName);

        tf_studentPhone.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        tf_studentPhone.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_studentPhone.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 155, 255), 2, true));
        tf_studentPhone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_studentPhoneFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tf_studentPhoneFocusLost(evt);
            }
        });
        tf_studentPhone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_studentPhoneKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_studentPhoneKeyTyped(evt);
            }
        });
        pl_studentData.add(tf_studentPhone);

        lb_studentPhone.setBackground(new java.awt.Color(255, 255, 255));
        lb_studentPhone.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_studentPhone.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_studentPhone.setText("رقم الهاتف");
        pl_studentData.add(lb_studentPhone);

        tf_address.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        tf_address.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_address.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 155, 255), 2, true));
        tf_address.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_addressKeyPressed(evt);
            }
        });
        pl_studentData.add(tf_address);

        lb_address.setBackground(new java.awt.Color(255, 255, 255));
        lb_address.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_address.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_address.setText("العنوان");
        pl_studentData.add(lb_address);

        cb_level.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        cb_level.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "اختر الفرقة" }));
        cb_level.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 155, 255), 1, true));
        cb_level.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_levelItemStateChanged(evt);
            }
        });
        cb_level.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cb_levelFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cb_levelFocusLost(evt);
            }
        });
        pl_studentData.add(cb_level);

        lb_level.setBackground(new java.awt.Color(255, 255, 255));
        lb_level.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_level.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_level.setText("الفرقة");
        pl_studentData.add(lb_level);

        pl_parentData.setBackground(new java.awt.Color(255, 255, 255));
        pl_parentData.setLayout(new java.awt.GridLayout(4, 0, 20, 20));

        tf_parentName.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        tf_parentName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_parentName.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 155, 255), 2, true));
        tf_parentName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_parentNameKeyPressed(evt);
            }
        });
        pl_parentData.add(tf_parentName);

        lb_parentName.setBackground(new java.awt.Color(255, 255, 255));
        lb_parentName.setFont(new java.awt.Font("Cairo", 1, 17)); // NOI18N
        lb_parentName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_parentName.setText("اسم ولي الامر");
        pl_parentData.add(lb_parentName);

        tf_parentPhone.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        tf_parentPhone.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_parentPhone.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 155, 255), 2, true));
        tf_parentPhone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_parentPhoneFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tf_parentPhoneFocusLost(evt);
            }
        });
        tf_parentPhone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_parentPhoneKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_parentPhoneKeyTyped(evt);
            }
        });
        pl_parentData.add(tf_parentPhone);

        lb_phone.setBackground(new java.awt.Color(255, 255, 255));
        lb_phone.setFont(new java.awt.Font("Cairo", 1, 17)); // NOI18N
        lb_phone.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_phone.setText("هاتف ولي الامر");
        pl_parentData.add(lb_phone);

        tf_job.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        tf_job.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_job.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 155, 255), 2, true));
        tf_job.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_jobKeyPressed(evt);
            }
        });
        pl_parentData.add(tf_job);

        lb_job.setBackground(new java.awt.Color(255, 255, 255));
        lb_job.setFont(new java.awt.Font("Cairo", 1, 17)); // NOI18N
        lb_job.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_job.setText("وظيفة ولي الامر");
        pl_parentData.add(lb_job);

        tf_relativity.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        tf_relativity.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_relativity.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 155, 255), 2, true));
        tf_relativity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_relativityActionPerformed(evt);
            }
        });
        tf_relativity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_relativityKeyPressed(evt);
            }
        });
        pl_parentData.add(tf_relativity);

        lb_relativity.setBackground(new java.awt.Color(255, 255, 255));
        lb_relativity.setFont(new java.awt.Font("Cairo", 1, 17)); // NOI18N
        lb_relativity.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_relativity.setText("درجة القرابه");
        pl_parentData.add(lb_relativity);

        btn_save.setBackground(new java.awt.Color(0, 155, 255));
        btn_save.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        btn_save.setForeground(new java.awt.Color(255, 255, 255));
        btn_save.setText("اضافة");
        btn_save.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_saveMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_saveMouseExited(evt);
            }
        });
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });

        btn_clean1.setBackground(new java.awt.Color(153, 153, 153));
        btn_clean1.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        btn_clean1.setForeground(new java.awt.Color(255, 255, 255));
        btn_clean1.setText("تنظيف");
        btn_clean1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clean1ActionPerformed(evt);
            }
        });

        lb_star5.setBackground(new java.awt.Color(255, 255, 255));
        lb_star5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_star5.setForeground(new java.awt.Color(255, 0, 0));
        lb_star5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_star5.setText("*");
        lb_star5.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        lb_star15.setBackground(new java.awt.Color(255, 255, 255));
        lb_star15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_star15.setForeground(new java.awt.Color(255, 0, 0));
        lb_star15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_star15.setText("*");
        lb_star15.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        lb_star2.setBackground(new java.awt.Color(255, 255, 255));
        lb_star2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_star2.setForeground(new java.awt.Color(255, 0, 0));
        lb_star2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_star2.setText("*");

        lb_star4.setBackground(new java.awt.Color(255, 255, 255));
        lb_star4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_star4.setForeground(new java.awt.Color(255, 0, 0));
        lb_star4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_star4.setText("*");
        lb_star4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout pl_addingStudentLayout = new javax.swing.GroupLayout(pl_addingStudent);
        pl_addingStudent.setLayout(pl_addingStudentLayout);
        pl_addingStudentLayout.setHorizontalGroup(
            pl_addingStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pl_addingStudentLayout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addComponent(lb_star)
                .addGroup(pl_addingStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pl_addingStudentLayout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addComponent(pl_parentData, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
                        .addGap(53, 53, 53)
                        .addComponent(pl_verticalLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(112, 112, 112)
                        .addGroup(pl_addingStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_star4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lb_star2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lb_star15, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lb_star5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(0, 0, 0)
                        .addComponent(pl_studentData, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
                        .addGap(7, 7, 7))
                    .addGroup(pl_addingStudentLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(btn_clean1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(pl_addingStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pl_addingStudentLayout.createSequentialGroup()
                                .addComponent(btn_save, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(90, 90, 90)
                                .addGroup(pl_addingStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pl_addingStudentLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(sp_addedd, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pl_addingStudentLayout.createSequentialGroup()
                                        .addGap(40, 40, 40)
                                        .addComponent(lb_added, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lb_star3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(pl_addingStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lb_haveToAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lb_addToHave, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(pl_addingStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pl_addingStudentLayout.createSequentialGroup()
                                        .addGap(40, 40, 40)
                                        .addComponent(lb_have, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(sp_have, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addComponent(lb_avilable, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lb_maxavalible, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(pl_horizontalBottomLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        pl_addingStudentLayout.setVerticalGroup(
            pl_addingStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pl_addingStudentLayout.createSequentialGroup()
                .addGroup(pl_addingStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pl_addingStudentLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pl_verticalLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pl_addingStudentLayout.createSequentialGroup()
                        .addGroup(pl_addingStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pl_addingStudentLayout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(lb_star4)
                                .addGap(43, 43, 43)
                                .addComponent(lb_star2)
                                .addGap(37, 37, 37)
                                .addComponent(lb_star15)
                                .addGap(93, 93, 93)
                                .addComponent(lb_star5))
                            .addGroup(pl_addingStudentLayout.createSequentialGroup()
                                .addGap(103, 103, 103)
                                .addComponent(lb_star, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pl_addingStudentLayout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(pl_parentData, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pl_addingStudentLayout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(pl_studentData, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(15, 15, 15)))
                .addComponent(pl_horizontalBottomLine, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pl_addingStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pl_addingStudentLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(lb_star3)
                        .addGap(32, 32, 32)
                        .addGroup(pl_addingStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_save, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_clean1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pl_addingStudentLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(sp_addedd, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lb_added, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pl_addingStudentLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(lb_haveToAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(lb_addToHave, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pl_addingStudentLayout.createSequentialGroup()
                        .addComponent(lb_have, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(sp_have, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pl_addingStudentLayout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(pl_addingStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_avilable, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_maxavalible, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20))
        );

        StudentManagement.add(pl_addingStudent, "card7");

        pl_searchingStudent.setBackground(new java.awt.Color(255, 255, 255));

        pl_parentData1.setBackground(new java.awt.Color(255, 255, 255));
        pl_parentData1.setLayout(new java.awt.GridLayout(4, 0, 10, 10));

        tf_parentName1.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        tf_parentName1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_parentName1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 155, 255), 2, true));
        tf_parentName1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_parentName1KeyPressed(evt);
            }
        });
        pl_parentData1.add(tf_parentName1);

        lb_parentName1.setBackground(new java.awt.Color(255, 255, 255));
        lb_parentName1.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_parentName1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_parentName1.setText("اسم ولي الامر");
        pl_parentData1.add(lb_parentName1);

        tf_parentPhone1.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        tf_parentPhone1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_parentPhone1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 155, 255), 2, true));
        tf_parentPhone1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_parentPhone1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tf_parentPhone1FocusLost(evt);
            }
        });
        tf_parentPhone1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_parentPhone1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_parentPhone1KeyTyped(evt);
            }
        });
        pl_parentData1.add(tf_parentPhone1);

        lb_parentPhone1.setBackground(new java.awt.Color(255, 255, 255));
        lb_parentPhone1.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_parentPhone1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_parentPhone1.setText("هاتف ولي الامر");
        pl_parentData1.add(lb_parentPhone1);

        tf_job1.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        tf_job1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_job1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 155, 255), 2, true));
        tf_job1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_job1KeyPressed(evt);
            }
        });
        pl_parentData1.add(tf_job1);

        lb_parentJob1.setBackground(new java.awt.Color(255, 255, 255));
        lb_parentJob1.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_parentJob1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_parentJob1.setText("وظيفة ولي الامر");
        pl_parentData1.add(lb_parentJob1);

        tf_relativity1.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        tf_relativity1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_relativity1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 155, 255), 2, true));
        pl_parentData1.add(tf_relativity1);

        lb_relativity1.setBackground(new java.awt.Color(255, 255, 255));
        lb_relativity1.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_relativity1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_relativity1.setText("درجة القرابه");
        pl_parentData1.add(lb_relativity1);

        lst_have1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 155, 255)));
        lst_have1.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        lst_have1.setMaximumSize(new java.awt.Dimension(180, 150));
        lst_have1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lst_have1ValueChanged(evt);
            }
        });
        sp_have1.setViewportView(lst_have1);

        lst_added1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 155, 255)));
        lst_added1.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        lst_added1.setModel(new DefaultListModel ());
        lst_added1.setMaximumSize(new java.awt.Dimension(180, 150));
        lst_added1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lst_added1ValueChanged(evt);
            }
        });
        sp_added1.setViewportView(lst_added1);

        pl_studentData1.setBackground(new java.awt.Color(255, 255, 255));
        pl_studentData1.setLayout(new java.awt.GridLayout(3, 0, 10, 10));

        tf_studentName2.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        tf_studentName2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_studentName2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 155, 255), 2, true));
        tf_studentName2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_studentName2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tf_studentName2FocusLost(evt);
            }
        });
        tf_studentName2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_studentName2KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_studentName2KeyTyped(evt);
            }
        });
        pl_studentData1.add(tf_studentName2);

        lb_studentName2.setBackground(new java.awt.Color(255, 255, 255));
        lb_studentName2.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_studentName2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_studentName2.setText("اسم الطالب");
        pl_studentData1.add(lb_studentName2);

        tf_address1.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        tf_address1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_address1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 155, 255), 2, true));
        tf_address1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_address1KeyPressed(evt);
            }
        });
        pl_studentData1.add(tf_address1);

        lb_address1.setBackground(new java.awt.Color(255, 255, 255));
        lb_address1.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_address1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_address1.setText("العنوان");
        pl_studentData1.add(lb_address1);

        tf_studentPhone1.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        tf_studentPhone1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_studentPhone1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 155, 255), 2, true));
        tf_studentPhone1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_studentPhone1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tf_studentPhone1FocusLost(evt);
            }
        });
        tf_studentPhone1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_studentPhone1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_studentPhone1KeyTyped(evt);
            }
        });
        pl_studentData1.add(tf_studentPhone1);

        lb_studentPhone1.setBackground(new java.awt.Color(255, 255, 255));
        lb_studentPhone1.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_studentPhone1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_studentPhone1.setText("الهاتف");
        pl_studentData1.add(lb_studentPhone1);

        pl_studentDataForSearch.setBackground(new java.awt.Color(255, 255, 255));
        pl_studentDataForSearch.setLayout(new java.awt.GridLayout(3, 0, 10, 10));

        cb_level1.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        cb_level1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "اختر الفرقة", "Item 2", "Item 3", "Item 4" }));
        cb_level1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 155, 255), 1, true));
        cb_level1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_level1ItemStateChanged(evt);
            }
        });
        cb_level1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cb_level1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cb_level1FocusLost(evt);
            }
        });
        pl_studentDataForSearch.add(cb_level1);

        lb_levelName1.setBackground(new java.awt.Color(255, 255, 255));
        lb_levelName1.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_levelName1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_levelName1.setText("الفرقة");
        pl_studentDataForSearch.add(lb_levelName1);

        tf_code1.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        tf_code1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_code1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 155, 255), 2, true));
        tf_code1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_code1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tf_code1FocusLost(evt);
            }
        });
        tf_code1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_code1ActionPerformed(evt);
            }
        });
        tf_code1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_code1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_code1KeyTyped(evt);
            }
        });
        pl_studentDataForSearch.add(tf_code1);

        lb_code1.setBackground(new java.awt.Color(255, 255, 255));
        lb_code1.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_code1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_code1.setText("كود الطالب");
        pl_studentDataForSearch.add(lb_code1);

        tf_studentName1.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        tf_studentName1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_studentName1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 155, 255), 2, true));
        tf_studentName1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_studentName1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tf_studentName1FocusLost(evt);
            }
        });
        tf_studentName1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_studentName1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_studentName1KeyTyped(evt);
            }
        });
        pl_studentDataForSearch.add(tf_studentName1);

        lb_studentName1.setBackground(new java.awt.Color(255, 255, 255));
        lb_studentName1.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_studentName1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_studentName1.setText("اسم الطالب");
        pl_studentDataForSearch.add(lb_studentName1);

        lb_parentData.setBackground(new java.awt.Color(255, 255, 255));
        lb_parentData.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_parentData.setForeground(new java.awt.Color(19, 64, 93));
        lb_parentData.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_parentData.setText("بيانات ولي الامر:");

        rb_code.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rb_code);
        rb_code.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 155, 255), 2, true));
        rb_code.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_codeActionPerformed(evt);
            }
        });

        rb_name.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rb_name);
        rb_name.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 155, 255), 2, true));
        rb_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_nameActionPerformed(evt);
            }
        });

        lb_studentData.setBackground(new java.awt.Color(255, 255, 255));
        lb_studentData.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_studentData.setForeground(new java.awt.Color(19, 64, 93));
        lb_studentData.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_studentData.setText("بيانات الطالب:");

        lb_haveToAdd1.setBackground(new java.awt.Color(255, 255, 255));
        lb_haveToAdd1.setFont(new java.awt.Font("Cairo", 1, 24)); // NOI18N
        lb_haveToAdd1.setForeground(new java.awt.Color(0, 153, 204));
        lb_haveToAdd1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_haveToAdd1.setText("<<");
        lb_haveToAdd1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb_haveToAdd1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_haveToAdd1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lb_haveToAdd1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lb_haveToAdd1MouseExited(evt);
            }
        });

        lb_addToHave1.setBackground(new java.awt.Color(255, 255, 255));
        lb_addToHave1.setFont(new java.awt.Font("Cairo", 1, 24)); // NOI18N
        lb_addToHave1.setForeground(new java.awt.Color(0, 153, 204));
        lb_addToHave1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_addToHave1.setText(">>");
        lb_addToHave1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb_addToHave1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_addToHave1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lb_addToHave1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lb_addToHave1MouseExited(evt);
            }
        });

        lb_added1.setBackground(new java.awt.Color(255, 255, 255));
        lb_added1.setFont(new java.awt.Font("Cairo", 1, 17)); // NOI18N
        lb_added1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_added1.setText("المضافة");

        lb_have1.setBackground(new java.awt.Color(255, 255, 255));
        lb_have1.setFont(new java.awt.Font("Cairo", 1, 17)); // NOI18N
        lb_have1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_have1.setText("اختر المجموعات");

        btn_clean.setBackground(new java.awt.Color(153, 153, 153));
        btn_clean.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        btn_clean.setForeground(new java.awt.Color(255, 255, 255));
        btn_clean.setText("تنظيف");
        btn_clean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cleanActionPerformed(evt);
            }
        });

        btn_search1.setBackground(new java.awt.Color(19, 64, 93));
        btn_search1.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        btn_search1.setForeground(new java.awt.Color(255, 255, 255));
        btn_search1.setText("بحث");
        btn_search1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_search1ActionPerformed(evt);
            }
        });

        btn_update.setBackground(new java.awt.Color(0, 0, 0));
        btn_update.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        btn_update.setForeground(new java.awt.Color(255, 255, 255));
        btn_update.setText("تعديل");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_delete.setBackground(new java.awt.Color(153, 0, 0));
        btn_delete.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        btn_delete.setForeground(new java.awt.Color(255, 255, 255));
        btn_delete.setText("حذف");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_stop.setBackground(new java.awt.Color(234, 84, 51));
        btn_stop.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        btn_stop.setForeground(new java.awt.Color(255, 255, 255));
        btn_stop.setText("ايقاف/تفعيل");
        btn_stop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_stopActionPerformed(evt);
            }
        });

        lb_star6.setBackground(new java.awt.Color(255, 255, 255));
        lb_star6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_star6.setForeground(new java.awt.Color(255, 0, 0));
        lb_star6.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_star6.setText("*");

        lb_star7.setBackground(new java.awt.Color(255, 255, 255));
        lb_star7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_star7.setForeground(new java.awt.Color(255, 0, 0));
        lb_star7.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_star7.setText("*");

        lb_star8.setBackground(new java.awt.Color(255, 255, 255));
        lb_star8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_star8.setForeground(new java.awt.Color(255, 0, 0));
        lb_star8.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_star8.setText("*");

        lb_star9.setBackground(new java.awt.Color(255, 255, 255));
        lb_star9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_star9.setForeground(new java.awt.Color(255, 0, 0));
        lb_star9.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_star9.setText("*");

        lb_star10.setBackground(new java.awt.Color(255, 255, 255));
        lb_star10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_star10.setForeground(new java.awt.Color(255, 0, 0));
        lb_star10.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_star10.setText("*");

        lb_status.setBackground(new java.awt.Color(255, 255, 255));
        lb_status.setFont(new java.awt.Font("Cairo", 1, 16)); // NOI18N
        lb_status.setForeground(new java.awt.Color(102, 102, 102));
        lb_status.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lb_status.setText("حالة الطالب : ");

        tf_status.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        tf_status.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_status.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 155, 255), 2, true));
        tf_status.setDisabledTextColor(new java.awt.Color(234, 84, 51));
        tf_status.setEnabled(false);
        tf_status.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_statusKeyPressed(evt);
            }
        });

        lb_star16.setBackground(new java.awt.Color(255, 255, 255));
        lb_star16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_star16.setForeground(new java.awt.Color(255, 0, 0));
        lb_star16.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_star16.setText("*");

        tf_avilable.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        tf_avilable.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_avilable.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 155, 255), 2, true));
        tf_avilable.setDisabledTextColor(new java.awt.Color(234, 84, 51));
        tf_avilable.setEnabled(false);
        tf_avilable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_avilableKeyPressed(evt);
            }
        });

        lb_status1.setBackground(new java.awt.Color(255, 255, 255));
        lb_status1.setFont(new java.awt.Font("Cairo", 1, 16)); // NOI18N
        lb_status1.setForeground(new java.awt.Color(102, 102, 102));
        lb_status1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lb_status1.setText("العدد الحالي");

        pl_verticalLine1.setBackground(new java.awt.Color(102, 102, 102));
        pl_verticalLine1.setForeground(new java.awt.Color(51, 51, 51));
        pl_verticalLine1.setPreferredSize(new java.awt.Dimension(2, 550));

        javax.swing.GroupLayout pl_verticalLine1Layout = new javax.swing.GroupLayout(pl_verticalLine1);
        pl_verticalLine1.setLayout(pl_verticalLine1Layout);
        pl_verticalLine1Layout.setHorizontalGroup(
            pl_verticalLine1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );
        pl_verticalLine1Layout.setVerticalGroup(
            pl_verticalLine1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );

        pl_horizontalBottomLine1.setBackground(new java.awt.Color(102, 102, 102));
        pl_horizontalBottomLine1.setMinimumSize(new java.awt.Dimension(440, 5));
        pl_horizontalBottomLine1.setPreferredSize(new java.awt.Dimension(800, 2));

        javax.swing.GroupLayout pl_horizontalBottomLine1Layout = new javax.swing.GroupLayout(pl_horizontalBottomLine1);
        pl_horizontalBottomLine1.setLayout(pl_horizontalBottomLine1Layout);
        pl_horizontalBottomLine1Layout.setHorizontalGroup(
            pl_horizontalBottomLine1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        pl_horizontalBottomLine1Layout.setVerticalGroup(
            pl_horizontalBottomLine1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        lb_star18.setBackground(new java.awt.Color(255, 255, 255));
        lb_star18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_star18.setForeground(new java.awt.Color(255, 0, 0));
        lb_star18.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_star18.setText("*");

        pl_searchNames.setBackground(new java.awt.Color(255, 255, 255));

        lst_searchNames.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 155, 255)));
        lst_searchNames.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        lst_searchNames.setMaximumSize(new java.awt.Dimension(180, 150));
        lst_searchNames.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lst_searchNamesValueChanged(evt);
            }
        });
        sp_searchNames.setViewportView(lst_searchNames);

        javax.swing.GroupLayout pl_searchNamesLayout = new javax.swing.GroupLayout(pl_searchNames);
        pl_searchNames.setLayout(pl_searchNamesLayout);
        pl_searchNamesLayout.setHorizontalGroup(
            pl_searchNamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pl_searchNamesLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(sp_searchNames, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        pl_searchNamesLayout.setVerticalGroup(
            pl_searchNamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp_searchNames, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pl_searchingStudentLayout = new javax.swing.GroupLayout(pl_searchingStudent);
        pl_searchingStudent.setLayout(pl_searchingStudentLayout);
        pl_searchingStudentLayout.setHorizontalGroup(
            pl_searchingStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pl_searchingStudentLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pl_searchingStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pl_searchingStudentLayout.createSequentialGroup()
                        .addGroup(pl_searchingStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(153, 153, 153)
                        .addComponent(lb_star16, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pl_searchingStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(pl_searchingStudentLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sp_added1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pl_searchingStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lb_addToHave1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lb_haveToAdd1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sp_have1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(pl_searchingStudentLayout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(lb_added1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lb_have1)
                                .addGap(36, 36, 36))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pl_searchingStudentLayout.createSequentialGroup()
                        .addGroup(pl_searchingStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pl_searchingStudentLayout.createSequentialGroup()
                                .addComponent(lb_star7, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addGroup(pl_searchingStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pl_searchingStudentLayout.createSequentialGroup()
                                        .addGap(170, 170, 170)
                                        .addComponent(lb_parentData, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(pl_parentData1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(89, 89, 89)
                                .addGroup(pl_searchingStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lb_star10, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lb_star18, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pl_searchingStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lb_studentData, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pl_studentData1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(pl_horizontalBottomLine1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pl_searchingStudentLayout.createSequentialGroup()
                        .addComponent(tf_avilable, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb_status1)
                        .addGap(108, 108, 108)))
                .addComponent(pl_verticalLine1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(pl_searchingStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pl_searchingStudentLayout.createSequentialGroup()
                        .addGroup(pl_searchingStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_stop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pl_searchingStudentLayout.createSequentialGroup()
                                .addComponent(tf_status, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lb_status)))
                        .addGap(79, 79, 79))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pl_searchingStudentLayout.createSequentialGroup()
                        .addGroup(pl_searchingStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_star9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_star8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_star6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pl_searchingStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pl_searchNames, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pl_searchingStudentLayout.createSequentialGroup()
                                .addComponent(pl_studentDataForSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(pl_searchingStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rb_name, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rb_code, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pl_searchingStudentLayout.createSequentialGroup()
                                .addComponent(btn_search1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(btn_clean, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30))))
        );
        pl_searchingStudentLayout.setVerticalGroup(
            pl_searchingStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pl_searchingStudentLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(pl_verticalLine1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pl_searchingStudentLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(pl_searchingStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pl_searchingStudentLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(lb_studentData, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(pl_studentData1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pl_searchingStudentLayout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(lb_star7))
                    .addGroup(pl_searchingStudentLayout.createSequentialGroup()
                        .addComponent(lb_parentData)
                        .addGap(10, 10, 10)
                        .addComponent(pl_parentData1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pl_searchingStudentLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(lb_star10, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(lb_star18, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32)
                .addComponent(pl_horizontalBottomLine1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pl_searchingStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pl_searchingStudentLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pl_searchingStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pl_searchingStudentLayout.createSequentialGroup()
                                .addComponent(lb_have1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sp_have1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pl_searchingStudentLayout.createSequentialGroup()
                                .addComponent(lb_added1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sp_added1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pl_searchingStudentLayout.createSequentialGroup()
                                .addComponent(lb_haveToAdd1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lb_addToHave1)
                                .addGap(13, 13, 13))))
                    .addGroup(pl_searchingStudentLayout.createSequentialGroup()
                        .addGroup(pl_searchingStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pl_searchingStudentLayout.createSequentialGroup()
                                .addComponent(btn_update)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pl_searchingStudentLayout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(lb_star16, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(btn_delete)
                        .addGap(9, 9, 9)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pl_searchingStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_status1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_avilable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(207, 207, 207))
            .addGroup(pl_searchingStudentLayout.createSequentialGroup()
                .addGroup(pl_searchingStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pl_searchingStudentLayout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(rb_code, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pl_searchingStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(rb_name, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pl_searchingStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pl_searchingStudentLayout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(pl_studentDataForSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pl_searchingStudentLayout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(lb_star6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(lb_star8)
                                .addGap(29, 29, 29)
                                .addComponent(lb_star9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(5, 5, 5)
                .addComponent(pl_searchNames, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pl_searchingStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_search1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_clean, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(btn_stop)
                .addGap(18, 18, 18)
                .addGroup(pl_searchingStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_status, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(206, 206, 206))
        );

        StudentManagement.add(pl_searchingStudent, "card4");

        pl_notes.setBackground(new java.awt.Color(255, 255, 255));

        btn_search2.setBackground(new java.awt.Color(19, 64, 93));
        btn_search2.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        btn_search2.setForeground(new java.awt.Color(255, 255, 255));
        btn_search2.setText("بحث");
        btn_search2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_search2ActionPerformed(evt);
            }
        });

        btn_clean2.setBackground(new java.awt.Color(153, 153, 153));
        btn_clean2.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        btn_clean2.setForeground(new java.awt.Color(255, 255, 255));
        btn_clean2.setText("تنظيف");
        btn_clean2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clean2ActionPerformed(evt);
            }
        });

        rb_studentCode.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rb_studentCode);
        rb_studentCode.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 155, 255), 2, true));
        rb_studentCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_studentCodeActionPerformed(evt);
            }
        });

        rb_studentName.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rb_studentName);
        rb_studentName.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 155, 255), 2, true));
        rb_studentName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_studentNameActionPerformed(evt);
            }
        });

        pl_horizontalLine.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout pl_horizontalLineLayout = new javax.swing.GroupLayout(pl_horizontalLine);
        pl_horizontalLine.setLayout(pl_horizontalLineLayout);
        pl_horizontalLineLayout.setHorizontalGroup(
            pl_horizontalLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );
        pl_horizontalLineLayout.setVerticalGroup(
            pl_horizontalLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        pl_verticalSeperatePanel.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout pl_verticalSeperatePanelLayout = new javax.swing.GroupLayout(pl_verticalSeperatePanel);
        pl_verticalSeperatePanel.setLayout(pl_verticalSeperatePanelLayout);
        pl_verticalSeperatePanelLayout.setHorizontalGroup(
            pl_verticalSeperatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );
        pl_verticalSeperatePanelLayout.setVerticalGroup(
            pl_verticalSeperatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 290, Short.MAX_VALUE)
        );

        lb_noteScript.setBackground(new java.awt.Color(255, 255, 255));
        lb_noteScript.setFont(new java.awt.Font("Cairo", 1, 16)); // NOI18N
        lb_noteScript.setForeground(new java.awt.Color(19, 64, 93));
        lb_noteScript.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_noteScript.setText("نص الملاحظة");

        ta_newNote.setColumns(20);
        ta_newNote.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        ta_newNote.setRows(5);
        ta_newNote.setToolTipText("");
        ta_newNote.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 155, 255), 2, true));
        ta_newNote.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        ta_newNote.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ta_newNoteFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                ta_newNoteFocusLost(evt);
            }
        });
        sp_newNote.setViewportView(ta_newNote);

        t_oldNote.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        t_oldNote.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        t_oldNote.setRowHeight(30);
        t_oldNote.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_oldNoteMouseClicked(evt);
            }
        });
        sp_oldNote.setViewportView(t_oldNote);

        lb_oldNote.setBackground(new java.awt.Color(255, 255, 255));
        lb_oldNote.setFont(new java.awt.Font("Cairo", 1, 16)); // NOI18N
        lb_oldNote.setForeground(new java.awt.Color(19, 64, 93));
        lb_oldNote.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_oldNote.setText("الملاحظات السابقة");

        btn_savenote.setBackground(new java.awt.Color(21, 145, 95));
        btn_savenote.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        btn_savenote.setForeground(new java.awt.Color(255, 255, 255));
        btn_savenote.setText("حفظ");
        btn_savenote.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_savenoteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_savenoteMouseExited(evt);
            }
        });
        btn_savenote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_savenoteActionPerformed(evt);
            }
        });

        btn_delete1.setBackground(new java.awt.Color(254, 1, 1));
        btn_delete1.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        btn_delete1.setForeground(new java.awt.Color(255, 255, 255));
        btn_delete1.setText("حذف");
        btn_delete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delete1ActionPerformed(evt);
            }
        });

        lb_noteScript1.setBackground(new java.awt.Color(255, 255, 255));
        lb_noteScript1.setFont(new java.awt.Font("Cairo", 1, 16)); // NOI18N
        lb_noteScript1.setForeground(new java.awt.Color(153, 153, 153));
        lb_noteScript1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_noteScript1.setText("التاريخ");

        lb_written_date.setBackground(new java.awt.Color(255, 255, 255));
        lb_written_date.setFont(new java.awt.Font("Cairo", 1, 16)); // NOI18N
        lb_written_date.setForeground(new java.awt.Color(153, 153, 153));
        lb_written_date.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_written_date.setText("20/5/1998");

        lb_write.setBackground(new java.awt.Color(255, 255, 255));
        lb_write.setFont(new java.awt.Font("Cairo", 1, 16)); // NOI18N
        lb_write.setForeground(new java.awt.Color(19, 64, 93));
        lb_write.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_write.setText("كتبها");

        lb_written_by.setBackground(new java.awt.Color(255, 255, 255));
        lb_written_by.setFont(new java.awt.Font("Cairo", 1, 16)); // NOI18N
        lb_written_by.setForeground(new java.awt.Color(19, 64, 93));
        lb_written_by.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_written_by.setText("محمود رضا فاروق");

        lb_star13.setBackground(new java.awt.Color(255, 255, 255));
        lb_star13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_star13.setForeground(new java.awt.Color(255, 0, 0));
        lb_star13.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_star13.setText("*");

        lb_star14.setBackground(new java.awt.Color(255, 255, 255));
        lb_star14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_star14.setForeground(new java.awt.Color(255, 0, 0));
        lb_star14.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_star14.setText("*");

        pl_studentDataForSearch1.setBackground(new java.awt.Color(255, 255, 255));
        pl_studentDataForSearch1.setLayout(new java.awt.GridLayout(3, 0, 10, 10));

        cb_level3.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        cb_level3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "اختر الفرقة" }));
        cb_level3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 155, 255), 1, true));
        cb_level3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_level3ItemStateChanged(evt);
            }
        });
        cb_level3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cb_level3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cb_level3FocusLost(evt);
            }
        });
        pl_studentDataForSearch1.add(cb_level3);

        lb_levelName2.setBackground(new java.awt.Color(255, 255, 255));
        lb_levelName2.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_levelName2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_levelName2.setText("الفرقة");
        pl_studentDataForSearch1.add(lb_levelName2);

        tf_code2.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        tf_code2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_code2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 155, 255), 2, true));
        tf_code2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_code2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tf_code2FocusLost(evt);
            }
        });
        tf_code2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_code2KeyTyped(evt);
            }
        });
        pl_studentDataForSearch1.add(tf_code2);

        lb_code2.setBackground(new java.awt.Color(255, 255, 255));
        lb_code2.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_code2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_code2.setText("كود الطالب");
        pl_studentDataForSearch1.add(lb_code2);

        tf_studentName3.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        tf_studentName3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_studentName3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 155, 255), 2, true));
        tf_studentName3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_studentName3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tf_studentName3FocusLost(evt);
            }
        });
        pl_studentDataForSearch1.add(tf_studentName3);

        lb_studentName4.setBackground(new java.awt.Color(255, 255, 255));
        lb_studentName4.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_studentName4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_studentName4.setText("اسم الطالب");
        pl_studentDataForSearch1.add(lb_studentName4);

        lb_star17.setBackground(new java.awt.Color(255, 255, 255));
        lb_star17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_star17.setForeground(new java.awt.Color(255, 0, 0));
        lb_star17.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_star17.setText("*");

        javax.swing.GroupLayout pl_notesLayout = new javax.swing.GroupLayout(pl_notes);
        pl_notes.setLayout(pl_notesLayout);
        pl_notesLayout.setHorizontalGroup(
            pl_notesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pl_notesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pl_notesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pl_notesLayout.createSequentialGroup()
                        .addComponent(btn_clean2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btn_search2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89)
                        .addGroup(pl_notesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lb_star13, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_star14, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pl_studentDataForSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pl_notesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rb_studentName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rb_studentCode, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pl_notesLayout.createSequentialGroup()
                        .addGroup(pl_notesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lb_oldNote, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sp_oldNote))
                        .addGap(46, 46, 46)
                        .addComponent(pl_verticalSeperatePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pl_notesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pl_notesLayout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addComponent(lb_written_by, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lb_write, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pl_notesLayout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(lb_star17, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pl_notesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pl_notesLayout.createSequentialGroup()
                                        .addComponent(lb_written_date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lb_noteScript1)
                                        .addGap(217, 217, 217)
                                        .addComponent(lb_noteScript, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(sp_newNote, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pl_notesLayout.createSequentialGroup()
                        .addComponent(pl_horizontalLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(330, 330, 330)))
                .addGap(55, 55, 55))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pl_notesLayout.createSequentialGroup()
                .addContainerGap(101, Short.MAX_VALUE)
                .addComponent(btn_delete1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(764, 764, 764)
                .addComponent(btn_savenote, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96))
        );
        pl_notesLayout.setVerticalGroup(
            pl_notesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pl_notesLayout.createSequentialGroup()
                .addGroup(pl_notesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pl_notesLayout.createSequentialGroup()
                        .addGroup(pl_notesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pl_studentDataForSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pl_notesLayout.createSequentialGroup()
                                .addComponent(rb_studentCode, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(rb_studentName, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(32, 32, 32))
                    .addGroup(pl_notesLayout.createSequentialGroup()
                        .addGroup(pl_notesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pl_notesLayout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addGroup(pl_notesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_clean2)
                                    .addComponent(btn_search2)))
                            .addGroup(pl_notesLayout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(lb_star13, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lb_star14, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(47, 47, 47)))
                .addGroup(pl_notesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pl_verticalSeperatePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pl_notesLayout.createSequentialGroup()
                        .addComponent(pl_horizontalLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(lb_star17, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pl_notesLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(pl_notesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pl_notesLayout.createSequentialGroup()
                                .addComponent(lb_oldNote, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sp_oldNote, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pl_notesLayout.createSequentialGroup()
                                .addGroup(pl_notesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lb_noteScript, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lb_noteScript1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lb_written_date, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sp_newNote, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pl_notesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lb_write, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lb_written_by, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pl_notesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_delete1)
                    .addComponent(btn_savenote))
                .addContainerGap())
        );

        StudentManagement.add(pl_notes, "card4");

        pl_viewingStudent.setBackground(new java.awt.Color(255, 255, 255));

        cb_group.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        cb_group.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "اختر المجموعة" }));
        cb_group.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 155, 255), 1, true));
        cb_group.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cb_groupFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cb_groupFocusLost(evt);
            }
        });

        cb_level2.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        cb_level2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "اختر الفرقة" }));
        cb_level2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 155, 255), 1, true));
        cb_level2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_level2ItemStateChanged(evt);
            }
        });
        cb_level2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cb_level2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cb_level2FocusLost(evt);
            }
        });

        lb_classification.setBackground(new java.awt.Color(255, 255, 255));
        lb_classification.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_classification.setForeground(new java.awt.Color(19, 64, 93));
        lb_classification.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_classification.setText("التصنيفات:");

        pl_checkBoxForParent.setBackground(new java.awt.Color(255, 255, 255));
        pl_checkBoxForParent.setLayout(new java.awt.GridLayout(3, 3, 0, 10));

        chb_parentName.setBackground(new java.awt.Color(255, 255, 255));
        chb_parentName.setSelected(true);
        pl_checkBoxForParent.add(chb_parentName);

        chb_parentPhone.setBackground(new java.awt.Color(255, 255, 255));
        chb_parentPhone.setSelected(true);
        pl_checkBoxForParent.add(chb_parentPhone);

        chb_parentJob.setBackground(new java.awt.Color(255, 255, 255));
        chb_parentJob.setSelected(true);
        pl_checkBoxForParent.add(chb_parentJob);

        pl_parents.setBackground(new java.awt.Color(255, 255, 255));
        pl_parents.setLayout(new java.awt.GridLayout(3, 3, 0, 10));

        lb_parentName2.setBackground(new java.awt.Color(255, 255, 255));
        lb_parentName2.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_parentName2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_parentName2.setText("اسم ولي الامر");
        pl_parents.add(lb_parentName2);

        lb_parentPhone2.setBackground(new java.awt.Color(255, 255, 255));
        lb_parentPhone2.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_parentPhone2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_parentPhone2.setText("هاتف ولي الامر");
        pl_parents.add(lb_parentPhone2);

        lb_parentJob2.setBackground(new java.awt.Color(255, 255, 255));
        lb_parentJob2.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_parentJob2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_parentJob2.setText("وظيفة ولي الامر");
        pl_parents.add(lb_parentJob2);

        pl_student.setBackground(new java.awt.Color(255, 255, 255));
        pl_student.setLayout(new java.awt.GridLayout(5, 3, 0, 10));

        lb_studentName5.setBackground(new java.awt.Color(255, 255, 255));
        lb_studentName5.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_studentName5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_studentName5.setText("اسم الطالب");
        pl_student.add(lb_studentName5);

        lb_studentPhone5.setBackground(new java.awt.Color(255, 255, 255));
        lb_studentPhone5.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_studentPhone5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_studentPhone5.setText("هاتف الطالب");
        pl_student.add(lb_studentPhone5);

        lb_address5.setBackground(new java.awt.Color(255, 255, 255));
        lb_address5.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_address5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_address5.setText("العنوان");
        pl_student.add(lb_address5);

        lb_date.setBackground(new java.awt.Color(255, 255, 255));
        lb_date.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_date.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_date.setText("التاريخ");
        pl_student.add(lb_date);

        lb_level1.setBackground(new java.awt.Color(255, 255, 255));
        lb_level1.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_level1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_level1.setText("الفرقة");
        pl_student.add(lb_level1);

        pl_seperateLine.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout pl_seperateLineLayout = new javax.swing.GroupLayout(pl_seperateLine);
        pl_seperateLine.setLayout(pl_seperateLineLayout);
        pl_seperateLineLayout.setHorizontalGroup(
            pl_seperateLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 242, Short.MAX_VALUE)
        );
        pl_seperateLineLayout.setVerticalGroup(
            pl_seperateLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        pl_checkBoxForStudent.setBackground(new java.awt.Color(255, 255, 255));
        pl_checkBoxForStudent.setLayout(new java.awt.GridLayout(5, 3, 0, 10));

        chb_studentName.setBackground(new java.awt.Color(255, 255, 255));
        chb_studentName.setSelected(true);
        pl_checkBoxForStudent.add(chb_studentName);

        chb_studentPhone.setBackground(new java.awt.Color(255, 255, 255));
        chb_studentPhone.setSelected(true);
        pl_checkBoxForStudent.add(chb_studentPhone);

        chb_address.setBackground(new java.awt.Color(255, 255, 255));
        chb_address.setSelected(true);
        pl_checkBoxForStudent.add(chb_address);

        chb_date.setBackground(new java.awt.Color(255, 255, 255));
        chb_date.setSelected(true);
        pl_checkBoxForStudent.add(chb_date);

        chb_level.setBackground(new java.awt.Color(255, 255, 255));
        chb_level.setSelected(true);
        pl_checkBoxForStudent.add(chb_level);

        pl_verticalSeperateLine.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout pl_verticalSeperateLineLayout = new javax.swing.GroupLayout(pl_verticalSeperateLine);
        pl_verticalSeperateLine.setLayout(pl_verticalSeperateLineLayout);
        pl_verticalSeperateLineLayout.setHorizontalGroup(
            pl_verticalSeperateLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );
        pl_verticalSeperateLineLayout.setVerticalGroup(
            pl_verticalSeperateLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 481, Short.MAX_VALUE)
        );

        btn_viewStudent.setBackground(new java.awt.Color(0, 155, 255));
        btn_viewStudent.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        btn_viewStudent.setForeground(new java.awt.Color(255, 255, 255));
        btn_viewStudent.setText("عرض بيانات الطالب");
        btn_viewStudent.setEnabled(false);
        btn_viewStudent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_viewStudentMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_viewStudentMouseExited(evt);
            }
        });
        btn_viewStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_viewStudentActionPerformed(evt);
            }
        });

        t_viewStudentData.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 155, 255), 2, true));
        t_viewStudentData.setFont(new java.awt.Font("Cairo", 1, 11)); // NOI18N
        t_viewStudentData.setRowHeight(30);
        t_viewStudentData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_viewStudentDataMouseClicked(evt);
            }
        });
        sp_studentData.setViewportView(t_viewStudentData);

        pl_viewButtonsControl.setBackground(new java.awt.Color(255, 255, 255));
        pl_viewButtonsControl.setLayout(new java.awt.GridLayout(1, 0, 20, 0));

        btn_viewAll.setBackground(new java.awt.Color(19, 64, 93));
        btn_viewAll.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        btn_viewAll.setForeground(new java.awt.Color(255, 255, 255));
        btn_viewAll.setText("عرض المتوقفين");
        btn_viewAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_viewAllMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_viewAllMouseExited(evt);
            }
        });
        btn_viewAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_viewAllActionPerformed(evt);
            }
        });
        pl_viewButtonsControl.add(btn_viewAll);

        btn_viewLevel.setBackground(new java.awt.Color(19, 64, 93));
        btn_viewLevel.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        btn_viewLevel.setForeground(new java.awt.Color(255, 255, 255));
        btn_viewLevel.setText("عرض الفرقة");
        btn_viewLevel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_viewLevelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_viewLevelMouseExited(evt);
            }
        });
        btn_viewLevel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_viewLevelActionPerformed(evt);
            }
        });
        pl_viewButtonsControl.add(btn_viewLevel);

        btn_viewGroup.setBackground(new java.awt.Color(19, 64, 93));
        btn_viewGroup.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        btn_viewGroup.setForeground(new java.awt.Color(255, 255, 255));
        btn_viewGroup.setText("عرض المجموعة");
        btn_viewGroup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_viewGroupMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_viewGroupMouseExited(evt);
            }
        });
        btn_viewGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_viewGroupActionPerformed(evt);
            }
        });
        pl_viewButtonsControl.add(btn_viewGroup);

        lb_star11.setBackground(new java.awt.Color(255, 255, 255));
        lb_star11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_star11.setForeground(new java.awt.Color(255, 0, 0));
        lb_star11.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_star11.setText("*");

        lb_star12.setBackground(new java.awt.Color(255, 255, 255));
        lb_star12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_star12.setForeground(new java.awt.Color(255, 0, 0));
        lb_star12.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_star12.setText("*");

        lb_number.setBackground(new java.awt.Color(255, 255, 255));
        lb_number.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_number.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_number.setText("0");

        lb_number1.setBackground(new java.awt.Color(255, 255, 255));
        lb_number1.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_number1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_number1.setText("عدد المعروض");

        javax.swing.GroupLayout pl_viewingStudentLayout = new javax.swing.GroupLayout(pl_viewingStudent);
        pl_viewingStudent.setLayout(pl_viewingStudentLayout);
        pl_viewingStudentLayout.setHorizontalGroup(
            pl_viewingStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pl_viewingStudentLayout.createSequentialGroup()
                .addGroup(pl_viewingStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pl_viewingStudentLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(pl_viewingStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lb_number, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_number1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(pl_viewButtonsControl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(38, 38, 38))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pl_viewingStudentLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pl_viewingStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pl_viewingStudentLayout.createSequentialGroup()
                                .addGap(306, 306, 306)
                                .addComponent(btn_viewStudent, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                                .addGap(428, 428, 428))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pl_viewingStudentLayout.createSequentialGroup()
                                .addComponent(sp_studentData, javax.swing.GroupLayout.DEFAULT_SIZE, 949, Short.MAX_VALUE)
                                .addGap(18, 18, 18)))))
                .addComponent(pl_verticalSeperateLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(pl_viewingStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pl_viewingStudentLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(pl_viewingStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pl_viewingStudentLayout.createSequentialGroup()
                                .addGroup(pl_viewingStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lb_classification, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pl_viewingStudentLayout.createSequentialGroup()
                                        .addComponent(pl_student, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(pl_checkBoxForStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pl_viewingStudentLayout.createSequentialGroup()
                                        .addComponent(pl_parents, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(pl_checkBoxForParent, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(55, 55, 55))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pl_viewingStudentLayout.createSequentialGroup()
                                .addGroup(pl_viewingStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pl_viewingStudentLayout.createSequentialGroup()
                                        .addComponent(lb_star11, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cb_level2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pl_viewingStudentLayout.createSequentialGroup()
                                        .addComponent(lb_star12, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cb_group, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(27, 27, 27))))
                    .addGroup(pl_viewingStudentLayout.createSequentialGroup()
                        .addComponent(pl_seperateLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))))
        );
        pl_viewingStudentLayout.setVerticalGroup(
            pl_viewingStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(pl_viewingStudentLayout.createSequentialGroup()
                .addGroup(pl_viewingStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pl_viewingStudentLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(pl_viewingStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pl_viewingStudentLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(cb_level2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(pl_viewingStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pl_viewingStudentLayout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addComponent(cb_group, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pl_viewingStudentLayout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addComponent(lb_star12, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(lb_star11))
                        .addGap(18, 18, 18)
                        .addComponent(lb_classification, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addGroup(pl_viewingStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pl_student, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pl_checkBoxForStudent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pl_seperateLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pl_viewingStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pl_parents, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                            .addComponent(pl_checkBoxForParent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pl_viewingStudentLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(pl_viewingStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pl_viewButtonsControl, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pl_viewingStudentLayout.createSequentialGroup()
                                .addComponent(lb_number1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lb_number)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sp_studentData, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_viewStudent)
                        .addGap(7, 7, 7))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pl_viewingStudentLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(pl_verticalSeperateLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29))
        );

        StudentManagement.add(pl_viewingStudent, "card4");

        pl_bottomButtonCotrol.setBackground(new java.awt.Color(19, 64, 93));
        pl_bottomButtonCotrol.setMinimumSize(new java.awt.Dimension(1205, 60));
        pl_bottomButtonCotrol.setPreferredSize(new java.awt.Dimension(1205, 60));
        pl_bottomButtonCotrol.setLayout(new java.awt.GridLayout(1, 0, 40, 0));

        btn_print.setBackground(new java.awt.Color(19, 64, 93));
        btn_print.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        btn_print.setForeground(new java.awt.Color(255, 255, 255));
        btn_print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/print.png"))); // NOI18N
        btn_print.setText("طباعة");
        btn_print.setContentAreaFilled(false);
        btn_print.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btn_print.setIconTextGap(16);
        btn_print.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_printMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_printMouseExited(evt);
            }
        });
        btn_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_printActionPerformed(evt);
            }
        });
        pl_bottomButtonCotrol.add(btn_print);
        pl_bottomButtonCotrol.add(lb_empty3);
        pl_bottomButtonCotrol.add(lb_empty4);

        btn_home.setBackground(new java.awt.Color(19, 64, 93));
        btn_home.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        btn_home.setForeground(new java.awt.Color(255, 255, 255));
        btn_home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/home-btn.png"))); // NOI18N
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
        pl_bottomButtonCotrol.add(btn_home);

        btn_Setting.setBackground(new java.awt.Color(19, 64, 93));
        btn_Setting.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        btn_Setting.setForeground(new java.awt.Color(255, 255, 255));
        btn_Setting.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/Settings.png"))); // NOI18N
        btn_Setting.setText("الاعدادات");
        btn_Setting.setContentAreaFilled(false);
        btn_Setting.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
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
        pl_bottomButtonCotrol.add(btn_Setting);

        javax.swing.GroupLayout pl_backgroundLayout = new javax.swing.GroupLayout(pl_background);
        pl_background.setLayout(pl_backgroundLayout);
        pl_backgroundLayout.setHorizontalGroup(
            pl_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pl_topButtonControl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pl_bottomButtonCotrol, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pl_backgroundLayout.createSequentialGroup()
                .addComponent(StudentManagement, javax.swing.GroupLayout.PREFERRED_SIZE, 1237, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );
        pl_backgroundLayout.setVerticalGroup(
            pl_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pl_backgroundLayout.createSequentialGroup()
                .addComponent(pl_topButtonControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(StudentManagement, javax.swing.GroupLayout.PREFERRED_SIZE, 580, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(pl_bottomButtonCotrol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        sp_studentManagement.setViewportView(pl_background);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp_studentManagement, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1237, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp_studentManagement, javax.swing.GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // this function will clean after update,delete or clean after search for student
    public void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(returnYourImageURL())));
    }

    public void cleanAfterAdd() {
        tf_code.setText("");
        tf_studentName.setText("");
        tf_studentPhone.setText("");
        tf_parentName.setText("");
        tf_relativity.setText("");
        tf_job.setText("");
        tf_parentPhone.setText("");
        tf_address.setText("");
        tf_status.setText("");
        tf_avilable.setText("");
        cb_level.setSelectedIndex(0);
        FocusLostOrGained(cb_level);

        cb_level.setEnabled(true);
        DefaultListModel lst = new DefaultListModel();
        lst_added.setModel(lst);
    }

    // this function will clean after update,delete or clean after search for student
    public void cleanAfterSearch() {
        tf_code1.setText("");
        tf_studentName2.setText("");
        tf_studentName1.setText("");
        tf_studentPhone1.setText("");
        tf_parentName1.setText("");
        tf_relativity1.setText("");
        tf_job1.setText("");
        tf_parentPhone1.setText("");
        tf_address1.setText("");
        tf_status.setText("");
        tf_avilable.setText("");
        cb_level1.setSelectedIndex(0);

        cb_level1.setEnabled(true);
        DefaultListModel lst = new DefaultListModel();
        lst_added1.setModel(lst);
        btn_update.setEnabled(false);
        btn_stop.setEnabled(false);
        btn_delete.setEnabled(false);
        btn_search1.setEnabled(true);
        rb_code.setEnabled(true);
        rb_name.setEnabled(true);
        tf_studentName1.setEnabled(false);
        tf_code1.setEnabled(false);
        buttonGroup1.clearSelection();
        lst_searchNames.setVisible(true);
        sp_searchNames.setVisible(true);
        DefaultListModel listModel = (DefaultListModel) lst_searchNames.getModel();
        listModel.removeAllElements();
        lst_searchNames.setModel(listModel);
        pl_searchNames.setVisible(false);

    }

    public void loadOldNotes() {

        // check if searching with the code
        if (rb_studentCode.isSelected()) {
            // check if the code and level isn't empty
            if (checkEmpty(tf_code2) && checkEmpty(cb_level3)) {
                int code = Integer.parseInt(tf_code2.getText());
                String level = cb_level3.getSelectedItem().toString();
                String student_name = "";

                String written_by = "";
                String written_date = "";
                String notes = "";
                DefaultTableModel dtm = new DefaultTableModel();
                try {
                    PreparedStatement stmt = con.prepareStatement("select * from student_notes where student_code=? and level_name=?");
                    stmt.setInt(1, code);
                    stmt.setString(2, level);
                    ResultSet res = stmt.executeQuery();
                    dtm.addColumn("كتبها");
                    dtm.addColumn("التاريخ");
                    dtm.addColumn("الملاحظة");
                    // check if found the student or not
                    while (res.next()) {
                        student_name = res.getString("student_name");
                        written_by = res.getString("written_by");
                        notes = res.getString("notes");
                        written_date = res.getString("written_date");
                        String r[] = {written_by, written_date, notes};
                        dtm.addRow(r);
                    }
                    tf_studentName3.setText(student_name);
                    t_oldNote.setModel(dtm);
                    cb_level3.setEnabled(false);
                    tf_code2.setEnabled(false);
                    rb_studentCode.setEnabled(false);
                    rb_studentName.setEnabled(false);
                    tf_studentName3.setEnabled(false);
                } catch (SQLException ex) {
                    handleSqlExceptions(ex.getErrorCode());
                }
            }
        }

        if (rb_studentName.isSelected()) {
            // check if the name and level isn't empty
            if (checkEmpty(tf_studentName3) && checkEmpty(cb_level3)) {

                String student_name = tf_studentName3.getText();
                String level = cb_level3.getSelectedItem().toString();
                int code = 0;

                String written_by;
                String written_date;
                String notes;
                DefaultTableModel dtm = new DefaultTableModel();
                try {
                    PreparedStatement stmt = con.prepareStatement("select * from student_notes where student_name=? and level_name=?");
                    stmt.setString(1, student_name);
                    stmt.setString(2, level);
                    ResultSet res = stmt.executeQuery();
                    dtm.addColumn("كتبها");
                    dtm.addColumn("التاريخ");
                    dtm.addColumn("الملاحظة");
                    // check if found the student or not
                    while (res.next()) {
                        code = res.getInt("student_code");

                        written_by = res.getString("written_by");
                        notes = res.getString("notes");
                        written_date = res.getString("written_date");
                        String r[] = {written_by, written_date, notes};
                        dtm.addRow(r);
                    }

                    tf_code2.setText(String.valueOf(code));
                    t_oldNote.setModel(dtm);
                    tf_code2.setEnabled(false);
                    rb_studentCode.setEnabled(false);
                    cb_level3.setEnabled(false);
                    rb_studentName.setEnabled(false);
                    tf_studentName3.setEnabled(false);
                } catch (SQLException ex) {
                    handleSqlExceptions(ex.getErrorCode());
                }
            }
        }
    }
    private void btn_notesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_notesMouseEntered
        if (pl_notes.isVisible() == false) {
            hoverInMouseMotion(btn_notes);
        }
    }//GEN-LAST:event_btn_notesMouseEntered

    private void btn_notesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_notesMouseExited
        if (pl_notes.isVisible() != true) {
            btn_notes.setContentAreaFilled(false);;
        }
    }//GEN-LAST:event_btn_notesMouseExited

    private void btn_viewMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_viewMouseEntered
        if (pl_viewingStudent.isVisible() == false) {
            hoverInMouseMotion(btn_view);
        }
    }//GEN-LAST:event_btn_viewMouseEntered

    private void btn_viewMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_viewMouseExited
        if (pl_viewingStudent.isVisible() != true) {
            btn_view.setContentAreaFilled(false);;
        }
    }//GEN-LAST:event_btn_viewMouseExited

    private void btn_searchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_searchMouseEntered
        if (pl_searchingStudent.isVisible() == false) {
            hoverInMouseMotion(btn_search);
        }
    }//GEN-LAST:event_btn_searchMouseEntered

    private void btn_searchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_searchMouseExited
        if (pl_searchingStudent.isVisible() != true) {
            btn_search.setContentAreaFilled(false);;
        }
    }//GEN-LAST:event_btn_searchMouseExited

    private void btn_addMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addMouseEntered
        if (pl_addingStudent.isVisible() == false) {
            hoverInMouseMotion(btn_add);
        }
    }//GEN-LAST:event_btn_addMouseEntered

    private void btn_addMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addMouseExited
        if (pl_addingStudent.isVisible() != true) {
            btn_add.setContentAreaFilled(false);
        }

    }//GEN-LAST:event_btn_addMouseExited

    private void btn_viewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_viewActionPerformed

        // view only view panel  
        pl_addingStudent.setVisible(false);
        pl_notes.setVisible(false);
        pl_searchingStudent.setVisible(false);
        pl_viewingStudent.setVisible(true);

        // hober only view button
        hoverInMouseClicked(btn_view);
        defaultAfterHover(btn_add);
        defaultAfterHover(btn_notes);
        defaultAfterHover(btn_search);
        btn_print.setVisible(true);
        /*
        // empty all data wriiten in search panel to maintain design 
        tf_code1.setText("");
        tf_studentName1.setText("");
        tf_studentPhone1.setText("");
        tf_parentName1.setText("");
        tf_relativity1.setText("");
        tf_job1.setText("");
        tf_parentPhone1.setText("");
        tf_address1.setText("");
        tf_status.setText("");
        cb_level1.setSelectedIndex(0);
        cb_level1.setEnabled(true);
        DefaultListModel lst = new DefaultListModel();
        lst_added1.setModel(lst);
         */
    }//GEN-LAST:event_btn_viewActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        // check that the important field isn't empty
        if (checkEmpty(tf_code) && checkEmpty(tf_studentName) && checkEmpty(tf_parentPhone) && checkEmpty(tf_studentPhone) && checkEmpty(cb_level) && checkEmpty(lst_added)) {
            int student_code = Integer.parseInt(tf_code.getText());
            String student_name = tf_studentName.getText();
            int student_Phone = Integer.parseInt(tf_studentPhone.getText());
            String student_address = tf_address.getText();
            String parent_name = tf_parentName.getText();
            int parent_Phone = Integer.parseInt(tf_parentPhone.getText());
            String parent_job = tf_job.getText();
            String relativity = tf_relativity.getText();
            String student_level = cb_level.getSelectedItem().toString();
            String date = getDate();
            String status = "غير موقوف";
            String stop_date = "";
            if (checkExceedLevelWhenAddStudent(student_level)) {
                // adding student information to student table
                try {
                    PreparedStatement stmt = con.prepareStatement("insert into student values(?,?,?,?,?,?,?,?,?,?,?,?)");
                    stmt.setInt(1, student_code);
                    stmt.setString(2, student_name);
                    stmt.setInt(3, student_Phone);
                    stmt.setString(4, student_address);
                    stmt.setString(5, parent_name);
                    stmt.setInt(6, parent_Phone);
                    stmt.setString(7, parent_job);
                    stmt.setString(8, relativity);
                    stmt.setString(9, student_level);
                    stmt.setString(10, date);
                    stmt.setString(11, status);
                    stmt.setString(12, stop_date);
                    stmt.execute();

                    // adding the general_connection between the group and the student in sutdent_group_connection table
                    for (int i = 0; i < lst_added.getModel().getSize(); i++) {
                        String student_group = lst_added.getModel().getElementAt(i);
                        // check if we can add the student in this group or not the flag won't do anything
                        if (checkExceedGroupWhenAddStudent(student_level, student_group, 5) == -1) {
                            return;
                        }

                        try {
                            PreparedStatement stmt2 = con.prepareStatement("insert into student_group_connection values(?,?,?)");
                            stmt2.setInt(1, student_code);
                            stmt2.setString(2, student_group);
                            stmt2.setString(3, student_level);
                            stmt2.execute();

                        } catch (SQLException ex) {
                            handleSqlExceptions(ex.getErrorCode());
                        }

                    }
                    recordEvent("اضافة", "اضافة طالب", "تم اضافة الطالب " + " " + student_name + " " + "في الفرقة " + " " + student_level + " " + "بكود " + student_code);
                    addMessage();
                    cleanAfterAdd();
                } catch (SQLException ex) {
                    handleSqlExceptions(ex.getErrorCode());
                }
            }
        }
    }//GEN-LAST:event_btn_saveActionPerformed

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed

        // view only search panel  
        pl_addingStudent.setVisible(false);
        pl_notes.setVisible(false);
        pl_searchingStudent.setVisible(true);
        pl_viewingStudent.setVisible(false);

        // hober only search button
        hoverInMouseClicked(btn_search);
        defaultAfterHover(btn_view);
        defaultAfterHover(btn_notes);
        defaultAfterHover(btn_add);
        btn_print.setVisible(false);
    }//GEN-LAST:event_btn_searchActionPerformed

    private void btn_saveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_saveMouseEntered
        hoverInMouseClicked(btn_save);
    }//GEN-LAST:event_btn_saveMouseEntered

    private void btn_saveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_saveMouseExited
        btn_save.setBackground(new Color(19, 64, 93));

    }//GEN-LAST:event_btn_saveMouseExited

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed

        // view only add panel  
        pl_addingStudent.setVisible(true);
        pl_notes.setVisible(false);
        pl_searchingStudent.setVisible(false);
        pl_viewingStudent.setVisible(false);

        // hover only add button
        hoverInMouseClicked(btn_add);
        defaultAfterHover(btn_view);
        defaultAfterHover(btn_notes);
        defaultAfterHover(btn_search);
        btn_print.setVisible(false);

    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_notesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_notesActionPerformed

        // view only notes panel  
        pl_addingStudent.setVisible(false);
        pl_notes.setVisible(true);
        pl_searchingStudent.setVisible(false);
        pl_viewingStudent.setVisible(false);

        // hover only notes button
        hoverInMouseClicked(btn_notes);
        defaultAfterHover(btn_view);
        defaultAfterHover(btn_add);
        defaultAfterHover(btn_search);

        btn_print.setVisible(false);

        /*
        // empty all data wriiten in search panel to maintain design 
        tf_code1.setText("");
        tf_studentName1.setText("");
        tf_studentPhone1.setText("");
        tf_parentName1.setText("");
        tf_relativity1.setText("");
        tf_job1.setText("");
        tf_parentPhone1.setText("");
        tf_address1.setText("");
        tf_status.setText("");
        cb_level1.setSelectedIndex(0);
        cb_level1.setEnabled(true);
        DefaultListModel lst = new DefaultListModel();
        lst_added1.setModel(lst);
         */
    }//GEN-LAST:event_btn_notesActionPerformed

    private void btn_SettingMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_SettingMouseEntered
        hoverInMouseMotion(btn_Setting);
    }//GEN-LAST:event_btn_SettingMouseEntered

    private void btn_SettingMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_SettingMouseExited
        defaultAfterHover(btn_Setting);
    }//GEN-LAST:event_btn_SettingMouseExited

    private void btn_SettingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SettingActionPerformed
        this.setVisible(false);
        Settings settings = new Settings();
        if (this.getExtendedState() != 0) {
            settings.setExtendedState(JFrame.MAXIMIZED_BOTH);
        }
        settings.setVisible(true);
    }//GEN-LAST:event_btn_SettingActionPerformed

    private void btn_homeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_homeMouseEntered
        hoverInMouseMotion(btn_home);
    }//GEN-LAST:event_btn_homeMouseEntered

    private void btn_homeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_homeMouseExited
        defaultAfterHover(btn_home);
    }//GEN-LAST:event_btn_homeMouseExited

    private void btn_homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_homeActionPerformed
        this.setVisible(false);
        SecretaryControl secretaryControl = new SecretaryControl();
        if (this.getExtendedState() != 0) {
            secretaryControl.setExtendedState(JFrame.MAXIMIZED_BOTH);
        }
        secretaryControl.setVisible(true);

    }//GEN-LAST:event_btn_homeActionPerformed

    private void tf_codeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_codeKeyPressed
        if (enter(evt.getKeyChar())) {
            tf_studentName.requestFocus(true);

        }
    }//GEN-LAST:event_tf_codeKeyPressed

    private void tf_studentNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_studentNameKeyPressed
        if (enter(evt.getKeyChar())) {
            tf_studentPhone.requestFocus(true);
        }

    }//GEN-LAST:event_tf_studentNameKeyPressed

    private void tf_code1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_code1KeyPressed
        if (enter(evt.getKeyChar())) {
            if (rb_code.isSelected()) {
                // check if the code and level isn't empty
                if (checkEmpty(tf_code1) && checkEmpty(cb_level1)) {
                    int code = Integer.parseInt(tf_code1.getText());
                    String level = cb_level1.getSelectedItem().toString();
                    String name = "";
                    int phone = 0;
                    String parent_name = "";
                    String relativity = "";
                    String job = "";
                    int parent_phone = 0;
                    String address = "";
                    String status = "";
                    String group = "";
                    // get the student data from student table
                    try {
                        PreparedStatement stmt = con.prepareStatement("select * from student where student_code=? and level_name=?");
                        stmt.setInt(1, code);
                        stmt.setString(2, level);
                        ResultSet res = stmt.executeQuery();
                        // check if found the student or not
                        while (res.next()) {
                            name = res.getString("student_name");
                            phone = res.getInt("student_phone");
                            address = res.getString("student_address");
                            parent_name = res.getString("parent_name");
                            parent_phone = res.getInt("parent_phone");
                            job = res.getString("parent_job");
                            relativity = res.getString("relativity");
                            status = res.getString("student_status");
                        }
                        if (name.equals("")) {
                            jOptionPaneMessage("هذا الطالب غير موجود", 2);
                            return;
                        }
                        tf_studentName2.setText(name);
                        tf_studentName1.setText(name);
                        tf_studentPhone1.setText("0" + String.valueOf(phone));
                        tf_parentName1.setText(parent_name);
                        tf_relativity1.setText(relativity);
                        tf_job1.setText(job);
                        tf_parentPhone1.setText("0" + String.valueOf(parent_phone));
                        tf_address1.setText(address);
                        tf_status.setText(status);

                        // get the groups that the student involved in from table student_group_connection 
                        PreparedStatement stmt2 = con.prepareStatement("select group_name from student_group_connection where student_code=? and level_name=?");
                        stmt2.setInt(1, code);
                        stmt2.setString(2, level);
                        ResultSet res2 = stmt2.executeQuery();
                        DefaultListModel dlm = new DefaultListModel();
                        DefaultListModel dlm2 = (DefaultListModel) lst_have1.getModel();
                        while (res2.next()) {
                            group = res2.getString("group_name");
                            dlm.addElement(group);
                            dlm2.removeElement(group);
                        }
                        lst_added1.setModel(dlm);
                        lst_have1.setModel(dlm2);
                        tf_code1.setEnabled(false);
                        rb_code.setEnabled(false);
                        rb_name.setEnabled(false);
                        tf_studentName1.setEnabled(false);
                        btn_update.setEnabled(true);
                        btn_stop.setEnabled(true);
                        btn_delete.setEnabled(true);
                        btn_search1.setEnabled(false);
                        cb_level1.setEnabled(false);
                    } catch (SQLException ex) {
                        handleSqlExceptions(ex.getErrorCode());
                    }
                }
            }
        }
    }//GEN-LAST:event_tf_code1KeyPressed

    private void tf_studentName1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_studentName1KeyPressed
        if (enter(evt.getKeyChar())) {
            if (rb_name.isSelected()) {
                // check if the name and level isn't empty
                if (checkEmpty(tf_studentName1) && checkEmpty(cb_level1)) {

                    String name = tf_studentName1.getText();
                    int code = 0;
                    String level = cb_level1.getSelectedItem().toString();
                    int phone = 0;
                    String parent_name = "";
                    String relativity = "";
                    String job = "";
                    int parent_phone = 0;
                    String address = "";
                    String status = "";
                    String group = "";
                    // get the student data from student table
                    try {
                        PreparedStatement stmt = con.prepareStatement("select * from student where student_name=? and level_name=?");
                        stmt.setString(1, name);
                        stmt.setString(2, level);
                        ResultSet res = stmt.executeQuery();
                        // check if found the student or not
                        while (res.next()) {
                            code = res.getInt("student_code");
                            phone = res.getInt("student_phone");
                            address = res.getString("student_address");
                            parent_name = res.getString("parent_name");
                            parent_phone = res.getInt("parent_phone");
                            job = res.getString("parent_job");
                            relativity = res.getString("relativity");
                            status = res.getString("student_status");
                        }
                        if (code == 0) {
                            JOptionPane.showMessageDialog(null, "هذا الطالب غير موجود");
                            return;
                        }
                        tf_code1.setText(String.valueOf(code));
                        tf_studentPhone1.setText("0" + String.valueOf(phone));
                        tf_parentName1.setText(parent_name);
                        tf_relativity1.setText(relativity);
                        tf_job1.setText(job);
                        tf_parentPhone1.setText("0" + String.valueOf(parent_phone));
                        tf_address1.setText(address);
                        tf_status.setText(status);
                        tf_studentName2.setText(name);

                        // get the groups that the student involved in from table student_group_connection 
                        PreparedStatement stmt2 = con.prepareStatement("select group_name from student_group_connection where student_code=? and level_name=?");
                        stmt2.setInt(1, code);
                        stmt2.setString(2, level);
                        ResultSet res2 = stmt2.executeQuery();
                        DefaultListModel dlm = new DefaultListModel();
                        DefaultListModel dlm2 = (DefaultListModel) lst_have1.getModel();
                        while (res2.next()) {
                            group = res2.getString("group_name");
                            dlm.addElement(group);
                            dlm2.removeElement(group);
                        }
                        lst_added1.setModel(dlm);
                        lst_have1.setModel(dlm2);
                        tf_code1.setEnabled(false);
                        rb_code.setEnabled(false);
                        btn_update.setEnabled(true);
                        btn_stop.setEnabled(true);
                        btn_delete.setEnabled(true);
                        tf_studentName.setEnabled(true);
                        btn_search1.setEnabled(false);
                        cb_level.setEnabled(false);
                    } catch (SQLException ex) {
                        handleSqlExceptions(ex.getErrorCode());
                    }
                }
            }
        }
    }//GEN-LAST:event_tf_studentName1KeyPressed

    private void tf_parentName1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_parentName1KeyPressed
        if (enter(evt.getKeyChar())) {
            tf_parentPhone1.requestFocus(true);
        }
    }//GEN-LAST:event_tf_parentName1KeyPressed

    private void tf_parentPhone1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_parentPhone1KeyPressed
        if (enter(evt.getKeyChar())) {
            tf_job1.requestFocus(true);
        }
    }//GEN-LAST:event_tf_parentPhone1KeyPressed

    private void tf_job1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_job1KeyPressed
        if (enter(evt.getKeyChar())) {
            tf_relativity1.requestFocus(true);
        }
    }//GEN-LAST:event_tf_job1KeyPressed

    private void tf_address1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_address1KeyPressed
        if (enter(evt.getKeyChar())) {
            tf_studentPhone1.requestFocus(true);
        }
    }//GEN-LAST:event_tf_address1KeyPressed

    private void tf_studentPhone1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_studentPhone1KeyPressed
        if (enter(evt.getKeyChar())) {
            tf_parentName1.requestFocus(true);
        }
    }//GEN-LAST:event_tf_studentPhone1KeyPressed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        if (adminAccept()) {
            int student_code = Integer.parseInt(tf_code1.getText());
            String student_level = cb_level1.getSelectedItem().toString();

            // first delete the student connectoin with group in student_group_connection table
            PreparedStatement stmt;
            try {
                stmt = con.prepareStatement("DELETE FROM `nsms`.`student` WHERE `level_name`=? and`student_code`=?;");
                stmt.setString(1, student_level);
                stmt.setInt(2, student_code);
                stmt.execute();
                deleteMessage();
                recordEvent("حذف", "حذف طالب", "تم حذف الطالب " + tf_studentName1.getText() + "في الفرقة " + cb_level1.getSelectedItem().toString());
                cleanAfterSearch();
            } catch (SQLException ex) {
                Logger.getLogger(StudentManagement.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_viewStudentMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_viewStudentMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_viewStudentMouseEntered

    private void btn_viewStudentMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_viewStudentMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_viewStudentMouseExited

    private void btn_viewStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_viewStudentActionPerformed
        String level_name;
        DefaultListModel dlm;
        DefaultListModel dlm2;
        TableModel model1 = t_viewStudentData.getModel();
        int[] index = t_viewStudentData.getSelectedRows();
        if (checkEmpty(cb_level2)) {
            if (index.length > 0) {
                int code = Integer.parseInt(String.valueOf(model1.getValueAt(index[0], 0)));
                level_name = cb_level2.getSelectedItem().toString();
                String name = "";
                int phone = 0;
                String parent_name = "";
                String relativity = "";
                String job = "";
                int parent_phone = 0;
                String address = "";
                String status = "";
                String group = "";
                // get the student data from student table
                try {
                    PreparedStatement stmt = con.prepareStatement("select * from student where student_code=? and level_name=?");
                    stmt.setInt(1, code);
                    stmt.setString(2, level_name);
                    ResultSet res = stmt.executeQuery();

                    while (res.next()) {
                        name = res.getString("student_name");
                        phone = res.getInt("student_phone");
                        address = res.getString("student_address");
                        parent_name = res.getString("parent_name");
                        parent_phone = res.getInt("parent_phone");
                        job = res.getString("parent_job");
                        relativity = res.getString("relativity");
                        status = res.getString("student_status");
                    }
                    // if not found
                    if (name.equals("")) {
                        jOptionPaneMessage("هذا الطالب غير موجود", 2);
                        return;
                    } // if found
                    else {
                        tf_code1.setText(String.valueOf(code));
                        tf_studentName1.setText(name);
                        tf_studentName2.setText(name);
                        tf_studentPhone1.setText("0" + String.valueOf(phone));
                        tf_parentName1.setText(parent_name);
                        tf_relativity1.setText(relativity);
                        tf_job1.setText(job);
                        tf_parentPhone1.setText("0" + String.valueOf(parent_phone));
                        tf_address1.setText(address);
                        tf_status.setText(status);
                        cb_level1.setSelectedItem(level_name);

                        // get the groups that the student involved in from table student_group_connection 
                        PreparedStatement stmt2 = con.prepareStatement("select group_name from student_group_connection where student_code=? and level_name=?");
                        stmt2.setInt(1, code);
                        stmt2.setString(2, level_name);
                        ResultSet res2 = stmt2.executeQuery();
                        dlm = new DefaultListModel();
                        dlm2 = (DefaultListModel) lst_have1.getModel();
                        while (res2.next()) {
                            group = res2.getString("group_name");
                            dlm.addElement(group);
                            dlm2.removeElement(group);
                        }

                        // view only search panel  
                        pl_addingStudent.setVisible(false);
                        pl_notes.setVisible(false);
                        pl_searchingStudent.setVisible(true);
                        pl_viewingStudent.setVisible(false);

                        // clear the table and set button false
                        t_viewStudentData.clearSelection();
                        btn_viewStudent.setEnabled(false);

                        // hover only search button
                        hoverInMouseClicked(btn_search);
                        defaultAfterHover(btn_view);
                        defaultAfterHover(btn_notes);
                        defaultAfterHover(btn_add);
                        btn_print.setVisible(false);

                    }

                    // this what will happen in search panel
                    lst_added1.setModel(dlm);
                    lst_have1.setModel(dlm2);
                    tf_code1.setEnabled(false);
                    rb_code.setEnabled(false);
                    rb_name.setEnabled(false);
                    tf_studentName1.setEnabled(false);
                    btn_update.setEnabled(true);
                    btn_stop.setEnabled(true);
                    btn_delete.setEnabled(true);
                    btn_search1.setEnabled(false);
                    cb_level1.setEnabled(false);
                } catch (SQLException ex) {
                    handleSqlExceptions(ex.getErrorCode());
                }

            } else {
                jOptionPaneMessage("تاكد من اختيار احد الطلاب  من الجدول", 2);
            }
        }
    }//GEN-LAST:event_btn_viewStudentActionPerformed

    private void btn_search2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_search2ActionPerformed

        // check if searching with the code
        if (rb_studentCode.isSelected()) {
            // check if the code and level isn't empty
            if (checkEmpty(tf_code2) && checkEmpty(cb_level3)) {
                int code = Integer.parseInt(tf_code2.getText());
                String level = cb_level3.getSelectedItem().toString();
                String student_name = "";

                String written_by;
                String written_date;
                String notes;
                DefaultTableModel dtm = new DefaultTableModel();
                try {
                    PreparedStatement stmt = con.prepareStatement("select * from student"
                            + " where student_code=? and level_name=? ");

                    stmt.setInt(1, code);
                    stmt.setString(2, level);
                    ResultSet res = stmt.executeQuery();
                    while (res.next()) {
                        student_name = res.getString("student_name");
                    }

                    PreparedStatement stmt2 = con.prepareStatement("select * from student_notes "
                            + "where student_code=? and level_name=?");
                    stmt2.setInt(1, code);
                    stmt2.setString(2, level);
                    ResultSet res2 = stmt2.executeQuery();

                    dtm.addColumn("كتبها");
                    dtm.addColumn("التاريخ");
                    dtm.addColumn("الملاحظة");
                    while (res2.next()) {
                        written_by = res2.getString("written_by");
                        notes = res2.getString("notes");
                        written_date = res2.getString("written_date");
                        String r[] = {written_by, written_date, notes};
                        dtm.addRow(r);
                    }
                    System.out.println(student_name);
                    tf_studentName3.setText(student_name);
                    t_oldNote.setModel(dtm);
                    cb_level3.setEnabled(false);
                    tf_code2.setEnabled(false);
                    rb_studentCode.setEnabled(false);
                    rb_studentName.setEnabled(false);
                    tf_studentName3.setEnabled(false);
                    btn_search2.setEnabled(false);
                } catch (SQLException ex) {
                    handleSqlExceptions(ex.getErrorCode());
                }
            }
        }

        if (rb_studentName.isSelected()) {
            // check if the name and level isn't empty
            if (checkEmpty(tf_studentName3) && checkEmpty(cb_level3)) {

                String student_name = tf_studentName3.getText();
                String level = cb_level3.getSelectedItem().toString();
                int code = 0;

                String written_by;
                String written_date;
                String notes;
                DefaultTableModel dtm = new DefaultTableModel();
                try {
                    PreparedStatement stmt = con.prepareStatement("select * from student"
                            + " where student_name=? and level_name=? ");

                    stmt.setString(1, student_name);
                    stmt.setString(2, level);
                    ResultSet res = stmt.executeQuery();
                    while (res.next()) {
                        code = res.getInt("student_code");
                    }

                    PreparedStatement stmt2 = con.prepareStatement("select * from student_notes "
                            + "where student_name=? and level_name=?");
                    stmt2.setString(1, student_name);
                    stmt2.setString(2, level);
                    ResultSet res2 = stmt2.executeQuery();

                    dtm.addColumn("كتبها");
                    dtm.addColumn("التاريخ");
                    dtm.addColumn("الملاحظة");
                    while (res2.next()) {
                        written_by = res2.getString("written_by");
                        notes = res2.getString("notes");
                        written_date = res2.getString("written_date");
                        String r[] = {written_by, written_date, notes};
                        dtm.addRow(r);
                    }

                    tf_code2.setText(String.valueOf(code));
                    t_oldNote.setModel(dtm);
                    cb_level3.setEnabled(false);
                    tf_code2.setEnabled(false);
                    rb_studentCode.setEnabled(false);
                    rb_studentName.setEnabled(false);
                    tf_studentName3.setEnabled(false);
                } catch (SQLException ex) {
                    handleSqlExceptions(ex.getErrorCode());
                }
            }
        }
    }//GEN-LAST:event_btn_search2ActionPerformed

    private void btn_clean2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clean2ActionPerformed
        tf_code2.setText("");
        tf_studentName3.setText("");
        ta_newNote.setText("");
        cb_level3.setSelectedIndex(0);
        cb_level3.setEnabled(true);
        DefaultTableModel dtm = new DefaultTableModel();
        t_oldNote.setModel(dtm);
        rb_studentCode.setEnabled(true);
        rb_studentName.setEnabled(true);
        tf_studentName3.setEnabled(false);
        tf_code2.setEnabled(false);
        buttonGroup1.clearSelection();
        FocusLostOrGained(cb_level2);
        FocusLostOrGained(tf_code2);
        FocusLostOrGained(tf_studentName3);
        btn_search2.setEnabled(true);
        btn_delete1.setEnabled(true);

    }//GEN-LAST:event_btn_clean2ActionPerformed

    private void tf_codeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_codeKeyTyped
        textFieldValidation(tf_code, (evt.getKeyChar()), evt);
    }//GEN-LAST:event_tf_codeKeyTyped

    private void tf_studentPhoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_studentPhoneKeyPressed
        if (enter(evt.getKeyChar())) {
            tf_address.requestFocus(true);
        }
    }//GEN-LAST:event_tf_studentPhoneKeyPressed

    private void tf_addressKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_addressKeyPressed
        if (enter(evt.getKeyChar())) {
            tf_parentName.requestFocus(true);
        }
    }//GEN-LAST:event_tf_addressKeyPressed

    private void tf_parentNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_parentNameKeyPressed
        if (enter(evt.getKeyChar())) {
            tf_parentPhone.requestFocus(true);
        }
    }//GEN-LAST:event_tf_parentNameKeyPressed

    private void tf_parentPhoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_parentPhoneKeyPressed
        if (enter(evt.getKeyChar())) {
            tf_job.requestFocus(true);
        }
    }//GEN-LAST:event_tf_parentPhoneKeyPressed

    private void tf_jobKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_jobKeyPressed
        if (enter(evt.getKeyChar())) {
            tf_relativity.requestFocus(true);
        }
    }//GEN-LAST:event_tf_jobKeyPressed

    private void btn_savenoteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_savenoteMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_savenoteMouseEntered

    private void btn_savenoteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_savenoteMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_savenoteMouseExited

    private void btn_savenoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_savenoteActionPerformed
        // check that the important field isn't empty
        if (checkEmpty(tf_code2) && checkEmpty(tf_studentName3) && checkEmpty(ta_newNote) && checkEmpty(cb_level3)) {
            int student_code = Integer.parseInt(tf_code2.getText());
            String notes = ta_newNote.getText();
            String written_by = lb_written_by.getText();
            String written_date = lb_written_date.getText();
            String level_name = cb_level3.getSelectedItem().toString();
            String student_name = tf_studentName3.getText();
            try {
                PreparedStatement stmt = con.prepareStatement("insert into student_notes values(?,?,?,?,?,?)");
                stmt.setInt(1, student_code);
                stmt.setString(2, level_name);
                stmt.setString(3, notes);
                stmt.setString(4, student_name);
                stmt.setString(5, written_by);
                stmt.setString(6, written_date);
                stmt.execute();

                addMessage();
                // empty all the textfields, lists ,and combobox
                loadOldNotes();
                ta_newNote.setText("");

            } catch (SQLException ex) {
                handleSqlExceptions(ex.getErrorCode());
            }
        }
    }//GEN-LAST:event_btn_savenoteActionPerformed

    private void btn_printMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_printMouseEntered
        hoverInMouseMotion(btn_print);
    }//GEN-LAST:event_btn_printMouseEntered

    private void btn_printMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_printMouseExited
        defaultAfterHover(btn_print);
    }//GEN-LAST:event_btn_printMouseExited

    private void btn_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_printActionPerformed
        String title = "";
        if (printTableDetermination == -1) {
            jOptionPaneMessage("الرجاء الضغط على ازرار عرض الطلاب", 0);
        } else {
            String level = cb_level2.getSelectedItem().toString();
            String group = cb_group.getSelectedItem().toString();
            switch (printTableDetermination) {
                case 2:
                    title = " تقرير الطلاب الموقوفون";
                    break;
                case 1:
                    title = " تقرير طلاب الصف" + " \"" + level;
                    break;
                case 0:
                    title = " تقرير طلاب الصف" + " \"" + level + "المجموعة" + " \"" + group + "\" ";
                    break;
                default:
                    break;
            }
            makeReport(t_viewStudentData, title);
        }
    }//GEN-LAST:event_btn_printActionPerformed

    private void btn_delete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delete1ActionPerformed
        if (adminAccept()) {
            String level_name;
            int code;
            String notes;
            TableModel model1 = t_oldNote.getModel();
            int[] index = t_oldNote.getSelectedRows();

            if (index.length > 0) {
                code = Integer.parseInt(tf_code2.getText());
                level_name = cb_level3.getSelectedItem().toString();
                notes = String.valueOf(model1.getValueAt(index[0], 2));
                try {
                    PreparedStatement stmt = con.prepareStatement("delete from student_notes where level_name=? and student_code=? and notes=?");
                    stmt.setString(1, level_name);
                    stmt.setInt(2, code);
                    stmt.setString(3, notes);
                    stmt.execute();
                    deleteMessage();
                } catch (SQLException ex) {
                    handleSqlExceptions(ex.getErrorCode());
                }
                loadOldNotes();
            } else {
                JOptionPane.showMessageDialog(null, "تاكد من اختيار احد الملاحظات  من الجدول");
            }
        }
    }//GEN-LAST:event_btn_delete1ActionPerformed

    private void tf_parentPhoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_parentPhoneKeyTyped
        if (tf_parentPhone.getText().length() + 1 > 11) {
            evt.consume();
        }
        textFieldValidation(tf_parentPhone, (evt.getKeyChar()), evt);
    }//GEN-LAST:event_tf_parentPhoneKeyTyped

    private void tf_studentPhoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_studentPhoneKeyTyped
        if (tf_studentPhone.getText().length() + 1 > 11) {
            evt.consume();
        }
        textFieldValidation(tf_studentPhone, (evt.getKeyChar()), evt);
    }//GEN-LAST:event_tf_studentPhoneKeyTyped

    private void lb_haveToAddMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_haveToAddMouseEntered
        hoverInMouseMotion(lb_haveToAdd);
    }//GEN-LAST:event_lb_haveToAddMouseEntered

    private void lb_haveToAddMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_haveToAddMouseExited
        defaultAfterHover(lb_haveToAdd);
    }//GEN-LAST:event_lb_haveToAddMouseExited

    private void lb_addToHaveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_addToHaveMouseEntered
        hoverInMouseMotion(lb_addToHave);
    }//GEN-LAST:event_lb_addToHaveMouseEntered

    private void lb_addToHaveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_addToHaveMouseExited
        defaultAfterHover(lb_addToHave);
    }//GEN-LAST:event_lb_addToHaveMouseExited

    private void tf_codeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_codeFocusLost
        FocusLostOrGained(tf_code);
    }//GEN-LAST:event_tf_codeFocusLost

    private void tf_studentPhoneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_studentPhoneFocusLost
        FocusLostOrGained(tf_studentPhone);
    }//GEN-LAST:event_tf_studentPhoneFocusLost

    private void tf_parentPhoneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_parentPhoneFocusLost
        FocusLostOrGained(tf_parentPhone);
    }//GEN-LAST:event_tf_parentPhoneFocusLost

    private void tf_codeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_codeFocusGained
        FocusLostOrGained(tf_code);
    }//GEN-LAST:event_tf_codeFocusGained

    private void tf_studentPhoneFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_studentPhoneFocusGained
        FocusLostOrGained(tf_studentPhone);
    }//GEN-LAST:event_tf_studentPhoneFocusGained

    private void tf_parentPhoneFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_parentPhoneFocusGained
        FocusLostOrGained(tf_parentPhone);
    }//GEN-LAST:event_tf_parentPhoneFocusGained

    private void tf_studentPhone1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_studentPhone1KeyTyped
        if (tf_studentPhone1.getText().length() + 1 > 11) {
            evt.consume();
        }
        textFieldValidation(tf_studentPhone1, evt.getKeyChar(), evt);
    }//GEN-LAST:event_tf_studentPhone1KeyTyped

    private void tf_code1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_code1KeyTyped
        textFieldValidation(tf_code1, evt.getKeyChar(), evt);
    }//GEN-LAST:event_tf_code1KeyTyped

    private void tf_code1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_code1FocusLost
        FocusLostOrGained(tf_studentPhone);
    }//GEN-LAST:event_tf_code1FocusLost

    private void tf_parentPhone1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_parentPhone1KeyTyped
        if (tf_parentPhone1.getText().length() + 1 > 11) {
            evt.consume();
        }
        textFieldValidation(tf_parentPhone1, evt.getKeyChar(), evt);
    }//GEN-LAST:event_tf_parentPhone1KeyTyped

    private void tf_code1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_code1FocusGained
        FocusLostOrGained(tf_code1);
    }//GEN-LAST:event_tf_code1FocusGained

    private void tf_studentPhone1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_studentPhone1FocusLost
        FocusLostOrGained(tf_studentPhone1);
    }//GEN-LAST:event_tf_studentPhone1FocusLost

    private void tf_studentPhone1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_studentPhone1FocusGained
        FocusLostOrGained(tf_studentPhone1);
    }//GEN-LAST:event_tf_studentPhone1FocusGained

    private void tf_parentPhone1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_parentPhone1FocusGained
        FocusLostOrGained(tf_parentPhone1);
    }//GEN-LAST:event_tf_parentPhone1FocusGained

    private void tf_parentPhone1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_parentPhone1FocusLost
        FocusLostOrGained(tf_parentPhone1);
    }//GEN-LAST:event_tf_parentPhone1FocusLost

    private void lb_addToHave1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_addToHave1MouseEntered
        hoverInMouseMotion(lb_addToHave1);
    }//GEN-LAST:event_lb_addToHave1MouseEntered

    private void lb_addToHave1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_addToHave1MouseExited
        defaultAfterHover(lb_addToHave1);
    }//GEN-LAST:event_lb_addToHave1MouseExited

    private void lb_haveToAdd1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_haveToAdd1MouseEntered
        hoverInMouseMotion(lb_haveToAdd1);
    }//GEN-LAST:event_lb_haveToAdd1MouseEntered

    private void lb_haveToAdd1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_haveToAdd1MouseExited
        defaultAfterHover(lb_haveToAdd1);
    }//GEN-LAST:event_lb_haveToAdd1MouseExited

    private void cb_levelItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_levelItemStateChanged
        loadGroup(lst_have, cb_level.getSelectedItem().toString());
        // set an empty model to the lst_added
        DefaultListModel ls = new DefaultListModel();
        lst_added.setModel(ls);
        lb_addToHave.setEnabled(false);
        lb_haveToAdd.setEnabled(false);
    }//GEN-LAST:event_cb_levelItemStateChanged

    private void lb_haveToAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_haveToAddMouseClicked
        if (lb_haveToAdd.isEnabled() == true) {
            // ensure that the color is cayn
            FocusLostOrGained(lst_added);

            //moved the group from allgroups to groups added only
            String group = lst_have.getSelectedValue();
            DefaultListModel afterGive = (DefaultListModel) lst_have.getModel();
            DefaultListModel afterTake = (DefaultListModel) lst_added.getModel();

            String level_name = cb_level.getSelectedItem().toString();
            int maxNumber = 0;
            int avilable = 0;
            if (level_name.equals("اختر الفرقة")) {
                return;
            }
            // calling the function to get the maxNumber
            maxNumber = checkExceedGroupWhenAddStudent(level_name, group, 0);

            // calling the function to get the avilable
            avilable = checkExceedGroupWhenAddStudent(level_name, group, 1);
            if (avilable + 1 > maxNumber) {
                JOptionPane.showMessageDialog(null, "هذة المجموعة ممتلئة " + "يمكنك تعديل الحد الاقصى للمجموعه  من ادارة المجموعات ");
                lb_avilable.setText("ممتلئة");
                return;
            }

            // do this after checks
            afterTake.addElement(group);
            afterGive.removeElement(group);
            lst_have.setModel(afterGive);
            lst_added.setModel(afterTake);
            cb_level.setEnabled(false);
            lb_addToHave.setEnabled(false);
            lb_haveToAdd.setEnabled(false);
            lb_avilable.setText("اختر مجموعة");
        }
    }//GEN-LAST:event_lb_haveToAddMouseClicked

    private void lst_addedValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lst_addedValueChanged
        lb_addToHave.setEnabled(true);
        lb_haveToAdd.setEnabled(false);
    }//GEN-LAST:event_lst_addedValueChanged

    private void lb_addToHaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_addToHaveMouseClicked
        String group = lst_added.getSelectedValue();
        DefaultListModel afterGive = (DefaultListModel) lst_added.getModel();
        DefaultListModel afterTake = (DefaultListModel) lst_have.getModel();
        afterTake.addElement(group);
        afterGive.removeElement(group);
        lst_have.setModel(afterTake);
        lst_added.setModel(afterGive);
        if (afterGive.isEmpty()) {
            cb_level.setEnabled(true);

        }
        lb_addToHave.setEnabled(false);
        lb_haveToAdd.setEnabled(false);

    }//GEN-LAST:event_lb_addToHaveMouseClicked

    private void lst_haveValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lst_haveValueChanged

        lb_haveToAdd.setEnabled(true);
        lb_addToHave.setEnabled(false);
        if (lst_have.isSelectionEmpty() == true) {
            return;
        }
        String group = lst_have.getSelectedValue();
        String level_name = cb_level.getSelectedItem().toString();
        int maxNumber = 0;
        int avilable = 0;
        if (level_name.equals("اختر الفرقة")) {
            return;
        }
        // calling the function to get the maxNumber
        maxNumber = checkExceedGroupWhenAddStudent(level_name, group, 0);

        avilable = checkExceedGroupWhenAddStudent(level_name, group, 1);
        if (avilable + 1 > maxNumber) {
            lb_avilable.setText("ممتلئة");
            lb_haveToAdd.setEnabled(false);

        }
        lb_avilable.setText(String.valueOf(avilable) + "/" + String.valueOf(maxNumber));
    }//GEN-LAST:event_lst_haveValueChanged

    private void lst_addedComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_lst_addedComponentAdded

    }//GEN-LAST:event_lst_addedComponentAdded

    private void tf_studentNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_studentNameFocusGained
        FocusLostOrGained(tf_studentName);
    }//GEN-LAST:event_tf_studentNameFocusGained

    private void tf_studentNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_studentNameFocusLost
        FocusLostOrGained(tf_studentName);
    }//GEN-LAST:event_tf_studentNameFocusLost

    private void tf_relativityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_relativityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_relativityActionPerformed

    private void tf_relativityKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_relativityKeyPressed
    }//GEN-LAST:event_tf_relativityKeyPressed

    private void lb_haveToAdd1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_haveToAdd1MouseClicked

        if (lb_haveToAdd1.isEnabled() == true) {
            String group = lst_have1.getSelectedValue();
            String level_name = cb_level1.getSelectedItem().toString();

            // ensure that the color is cayn
            FocusLostOrGained(lst_added1);
            if (level_name.equals("اختر الفرقة")) {
                return;
            }
            //moved the group from allgroups to groups added only

            int maxNumber;
            int avilable;
            DefaultListModel afterGive = (DefaultListModel) lst_have1.getModel();
            DefaultListModel afterTake = (DefaultListModel) lst_added1.getModel();
            // calling the function to get the maxNumber
            maxNumber = checkExceedGroupWhenAddStudent(level_name, group, 0);

            avilable = checkExceedGroupWhenAddStudent(level_name, group, 1);
            if (avilable + 1 > maxNumber) {
                JOptionPane.showMessageDialog(null, "هذة المجموعة ممتلئة " + "يمكنك تعديل الحد الاقصى للمجموعه  من ادارة المجموعات ");
                tf_avilable.setText("ممتلئة");
                lb_haveToAdd1.setEnabled(false);
                return;
            }

            // do this after check
            afterTake.addElement(group);
            afterGive.removeElement(group);
            lst_have1.setModel(afterGive);
            lst_added1.setModel(afterTake);
            cb_level1.setEnabled(false);
            lb_addToHave1.setEnabled(false);
            lb_haveToAdd1.setEnabled(false);
            tf_avilable.setText("اختر مجموعة");
        }
    }//GEN-LAST:event_lb_haveToAdd1MouseClicked

    private void lb_addToHave1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_addToHave1MouseClicked
        String group = lst_added1.getSelectedValue();
        DefaultListModel afterGive = (DefaultListModel) lst_added1.getModel();
        DefaultListModel afterTake = (DefaultListModel) lst_have1.getModel();
        afterTake.addElement(group);
        afterGive.removeElement(group);
        lst_have1.setModel(afterTake);
        lst_added1.setModel(afterGive);
        lb_addToHave1.setEnabled(false);
        if (afterGive.isEmpty()) {
            cb_level1.setEnabled(true);
        }
    }//GEN-LAST:event_lb_addToHave1MouseClicked

    private void lst_have1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lst_have1ValueChanged
        lb_haveToAdd1.setEnabled(true);
        lb_addToHave1.setEnabled(false);
        if (lst_have1.isSelectionEmpty() == true) {
            return;
        }
        String group = lst_have1.getSelectedValue();
        String level_name = cb_level1.getSelectedItem().toString();
        int maxNumber = 0;
        int avilable = 0;
        if (level_name.equals("اختر الفرقة")) {
            return;
        }
        // calling the function to get the maxNumber
        maxNumber = checkExceedGroupWhenAddStudent(level_name, group, 0);

        // calling the function to get the avilable
        avilable = checkExceedGroupWhenAddStudent(level_name, group, 1);
        if (avilable + 1 > maxNumber) {
            tf_avilable.setText("ممتلئة");
            lb_haveToAdd1.setEnabled(false);
        }
        tf_avilable.setText(String.valueOf(avilable) + "/" + String.valueOf(maxNumber));
    }//GEN-LAST:event_lst_have1ValueChanged

    private void lst_added1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lst_added1ValueChanged
        lb_addToHave1.setEnabled(true);
        lb_haveToAdd1.setEnabled(false);

    }//GEN-LAST:event_lst_added1ValueChanged

    private void btn_cleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cleanActionPerformed
        cleanAfterSearch();
    }//GEN-LAST:event_btn_cleanActionPerformed

    private void rb_codeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_codeActionPerformed
        if (checkEmpty(cb_level1)) {
            tf_code1.setEnabled(true);
            tf_studentName1.setEnabled(false);
        } else {
            buttonGroup1.clearSelection();
        }
    }//GEN-LAST:event_rb_codeActionPerformed

    private void rb_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_nameActionPerformed
        if (checkEmpty(cb_level1)) {
            tf_code1.setEnabled(false);
            tf_studentName1.setEnabled(true);
        } else {
            buttonGroup1.clearSelection();
        }
    }//GEN-LAST:event_rb_nameActionPerformed

    private void btn_search1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_search1ActionPerformed

        // check if searching with the code
        if (rb_code.isSelected()) {
            // check if the code and level isn't empty
            if (checkEmpty(tf_code1) && checkEmpty(cb_level1)) {
                int code = Integer.parseInt(tf_code1.getText());
                String level = cb_level1.getSelectedItem().toString();
                String name = "";
                int phone = 0;
                String parent_name = "";
                String relativity = "";
                String job = "";
                int parent_phone = 0;
                String address = "";
                String status = "";
                String group = "";
                // get the student data from student table
                try {
                    PreparedStatement stmt = con.prepareStatement("select * from student where student_code=? and level_name=?");
                    stmt.setInt(1, code);
                    stmt.setString(2, level);
                    ResultSet res = stmt.executeQuery();
                    // check if found the student or not
                    while (res.next()) {
                        name = res.getString("student_name");
                        phone = res.getInt("student_phone");
                        address = res.getString("student_address");
                        parent_name = res.getString("parent_name");
                        parent_phone = res.getInt("parent_phone");
                        job = res.getString("parent_job");
                        relativity = res.getString("relativity");
                        status = res.getString("student_status");
                    }
                    if (name.equals("")) {
                        jOptionPaneMessage("هذا الطالب غير موجود", 2);
                        return;
                    }
                    tf_studentName2.setText(name);
                    tf_studentName1.setText(name);
                    tf_studentPhone1.setText("0" + String.valueOf(phone));
                    tf_parentName1.setText(parent_name);
                    tf_relativity1.setText(relativity);
                    tf_job1.setText(job);
                    tf_parentPhone1.setText("0" + String.valueOf(parent_phone));
                    tf_address1.setText(address);
                    tf_status.setText(status);

                    // get the groups that the student involved in from table student_group_connection 
                    PreparedStatement stmt2 = con.prepareStatement("select group_name from student_group_connection where student_code=? and level_name=?");
                    stmt2.setInt(1, code);
                    stmt2.setString(2, level);
                    ResultSet res2 = stmt2.executeQuery();
                    DefaultListModel dlm = new DefaultListModel();
                    DefaultListModel dlm2 = (DefaultListModel) lst_have1.getModel();
                    while (res2.next()) {
                        group = res2.getString("group_name");
                        dlm.addElement(group);
                        dlm2.removeElement(group);
                    }
                    lst_added1.setModel(dlm);
                    lst_have1.setModel(dlm2);
                    tf_code1.setEnabled(false);
                    rb_code.setEnabled(false);
                    rb_name.setEnabled(false);
                    tf_studentName1.setEnabled(false);
                    btn_update.setEnabled(true);
                    btn_stop.setEnabled(true);
                    btn_delete.setEnabled(true);
                    btn_search1.setEnabled(false);
                    cb_level1.setEnabled(false);
                } catch (SQLException ex) {
                    handleSqlExceptions(ex.getErrorCode());
                }
            }
        }

        if (rb_name.isSelected()) {
            // check if the name and level isn't empty
            if (checkEmpty(tf_studentName1) && checkEmpty(cb_level1)) {

                String name = tf_studentName1.getText();
                int code = 0;
                String level = cb_level1.getSelectedItem().toString();
                int phone = 0;
                String parent_name = "";
                String relativity = "";
                String job = "";
                int parent_phone = 0;
                String address = "";
                String status = "";
                String group = "";
                // get the student data from student table
                try {
                    PreparedStatement stmt = con.prepareStatement("select * from student where student_name=? and level_name=?");
                    stmt.setString(1, name);
                    stmt.setString(2, level);
                    ResultSet res = stmt.executeQuery();
                    // check if found the student or not
                    while (res.next()) {
                        code = res.getInt("student_code");
                        phone = res.getInt("student_phone");
                        address = res.getString("student_address");
                        parent_name = res.getString("parent_name");
                        parent_phone = res.getInt("parent_phone");
                        job = res.getString("parent_job");
                        relativity = res.getString("relativity");
                        status = res.getString("student_status");
                    }
                    if (code == 0) {
                        JOptionPane.showMessageDialog(null, "هذا الطالب غير موجود");
                        return;
                    }
                    tf_code1.setText(String.valueOf(code));
                    tf_studentPhone1.setText("0" + String.valueOf(phone));
                    tf_parentName1.setText(parent_name);
                    tf_relativity1.setText(relativity);
                    tf_job1.setText(job);
                    tf_parentPhone1.setText("0" + String.valueOf(parent_phone));
                    tf_address1.setText(address);
                    tf_status.setText(status);
                    tf_studentName2.setText(name);

                    // get the groups that the student involved in from table student_group_connection 
                    PreparedStatement stmt2 = con.prepareStatement("select group_name from student_group_connection where student_code=? and level_name=?");
                    stmt2.setInt(1, code);
                    stmt2.setString(2, level);
                    ResultSet res2 = stmt2.executeQuery();
                    DefaultListModel dlm = new DefaultListModel();
                    DefaultListModel dlm2 = (DefaultListModel) lst_have1.getModel();
                    while (res2.next()) {
                        group = res2.getString("group_name");
                        dlm.addElement(group);
                        dlm2.removeElement(group);
                    }
                    lst_added1.setModel(dlm);
                    lst_have1.setModel(dlm2);
                    tf_code1.setEnabled(false);
                    rb_code.setEnabled(false);
                    btn_update.setEnabled(true);
                    btn_stop.setEnabled(true);
                    btn_delete.setEnabled(true);
                    tf_studentName.setEnabled(true);
                    btn_search1.setEnabled(false);
                    cb_level.setEnabled(false);
                } catch (SQLException ex) {
                    handleSqlExceptions(ex.getErrorCode());
                }
            }
        }

    }//GEN-LAST:event_btn_search1ActionPerformed

    private void tf_statusKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_statusKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_statusKeyPressed

    private void cb_level1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cb_level1FocusGained
        FocusLostOrGained(cb_level1);
    }//GEN-LAST:event_cb_level1FocusGained

    private void cb_level1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cb_level1FocusLost
        FocusLostOrGained(cb_level1);
    }//GEN-LAST:event_cb_level1FocusLost

    private void cb_level1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_level1ItemStateChanged
        loadGroup(lst_have1, cb_level1.getSelectedItem().toString());
        DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel();
        lst_added1.setModel(comboBoxModel);
    }//GEN-LAST:event_cb_level1ItemStateChanged

    private void tf_avilableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_avilableKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_avilableKeyPressed

    private void lst_searchNamesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lst_searchNamesValueChanged
        tf_studentName1.setText(lst_searchNames.getSelectedValue());
        pl_searchNames.setVisible(false);

    }//GEN-LAST:event_lst_searchNamesValueChanged

    private void tf_studentName1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_studentName1KeyTyped
        String level = cb_level1.getSelectedItem().toString();
        loadPredictedNamesDependOnStudentNameAndLevel(tf_studentName1, level, lst_searchNames, pl_searchNames);

    }//GEN-LAST:event_tf_studentName1KeyTyped

    private void tf_studentName1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_studentName1FocusGained
        FocusLostOrGained(tf_studentName1);
    }//GEN-LAST:event_tf_studentName1FocusGained

    private void tf_studentName1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_studentName1FocusLost
        FocusLostOrGained(tf_studentName1);
    }//GEN-LAST:event_tf_studentName1FocusLost

    private void btn_stopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_stopActionPerformed
        if (adminAccept()) {
            String status;
            int code;
            String level;
            String date;
            if (checkEmpty(tf_code1) && checkEmpty(cb_level1)) {
                code = Integer.parseInt(tf_code1.getText());
                level = cb_level1.getSelectedItem().toString();
                if ("غير موقوف".equals(tf_status.getText())) {
                    status = "موقوف";
                    date = getDate();
                } else {
                    status = "غير موقوف";
                    date = null;
                }
                try {
                    PreparedStatement stmt = con.prepareStatement("update student set  student_status=?, stop_date =? where student_code=? and level_name=?");
                    stmt.setString(1, status);
                    stmt.setString(2, date);
                    stmt.setInt(3, code);
                    stmt.setString(4, level);

                    stmt.execute();
                    stopMessage();
                    recordEvent("ايقاف", "ايقاف طالب", "تم ايقاف الطالب " + "\"" + tf_studentName1.getText() + "\"" + "كود الطالب " + "\"" + tf_code1.getText() + "\"");
                    // empty the textfields
                    tf_status.setText(status);

                } catch (SQLException ex) {
                    handleSqlExceptions(ex.getErrorCode());
                }
            }
        }
    }//GEN-LAST:event_btn_stopActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        if (checkEmpty(tf_code1) && checkEmpty(tf_studentName2) && checkEmpty(tf_parentPhone1) && checkEmpty(tf_studentPhone1) && checkEmpty(cb_level1) && checkEmpty(lst_added1)) {
            int student_code = Integer.parseInt(tf_code1.getText());
            String student_name = tf_studentName2.getText();
            int student_Phone = Integer.parseInt(tf_studentPhone1.getText());
            String student_address = tf_address1.getText();
            String parent_name = tf_parentName1.getText();
            int parent_Phone = Integer.parseInt(tf_parentPhone1.getText());
            String parent_job = tf_job1.getText();
            String relativity = tf_relativity1.getText();
            String student_level = cb_level1.getSelectedItem().toString();
            try {
                // udpdate the student data at student table
                PreparedStatement stmt = con.prepareStatement("UPDATE student SET student_name=?, "
                        + "student_phone=?, student_address=?, parent_name=?,"
                        + " parent_phone=?, parent_job=?, relativity=? "
                        + "WHERE student_code=? and level_name =?;");
                stmt.setString(1, student_name);
                stmt.setInt(2, student_Phone);
                stmt.setString(3, student_address);
                stmt.setString(4, parent_name);
                stmt.setInt(5, parent_Phone);
                stmt.setString(6, parent_job);
                stmt.setString(7, relativity);
                stmt.setInt(8, student_code);
                stmt.setString(9, student_level);
                stmt.execute();

                // first delete the student connectoin with group in student_group_connection table
                PreparedStatement stmt2 = con.prepareStatement("DELETE FROM `nsms`.`student_group_connection` WHERE `level_name`=? and`student_code`=?;");
                stmt2.setString(1, student_level);
                stmt2.setInt(2, student_code);
                stmt2.execute();

                // then add the new general_connection
                for (int i = 0; i < lst_added1.getModel().getSize(); i++) {
                    String student_group = lst_added1.getModel().getElementAt(i);
                    // check if we can add the student in this group or not the flag won't do anything
                    if (checkExceedGroupWhenAddStudent(student_level, student_group, 5) == -1) {
                        continue;
                    }

                    try {
                        PreparedStatement stmt3 = con.prepareStatement("insert into student_group_connection values(?,?,?)");
                        stmt3.setInt(1, student_code);
                        stmt3.setString(2, student_group);
                        stmt3.setString(3, student_level);
                        stmt3.execute();
                        System.out.println("done");
                    } catch (SQLException ex) {
                        handleSqlExceptions(ex.getErrorCode());
                    }

                }
                updateMessage();
                recordEvent("تعديل", "تعديل الطالب", "تم تعديل بيانات الطالب  " + tf_studentName1.getText() + "في الفرقة " + cb_level1.getSelectedItem().toString());
                cleanAfterSearch();
            } catch (SQLException ex) {
                handleSqlExceptions(ex.getErrorCode());
            }
        }

    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_viewGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_viewGroupActionPerformed
        String level = cb_level2.getSelectedItem().toString();
        String group = cb_group.getSelectedItem().toString();

        if (checkEmpty(cb_level2) && checkEmpty(cb_group)) {
            try {
                PreparedStatement stmt = con.prepareStatement("select * from student where student_status!=? and level_name=? and student_code in (select student_code from student_group_connection where group_name=? and level_name=?) order by student_code  asc");
                stmt.setString(1, "موقوف");
                stmt.setString(2, level);
                stmt.setString(3, group);
                stmt.setString(4, level);
                ResultSet set = stmt.executeQuery();

                DefaultTableModel dm = new DefaultTableModel();
                dm.addColumn("الكود");

                if (chb_level.isSelected()) {
                    dm.addColumn("الفرقة");
                }
                if (chb_studentName.isSelected()) {
                    dm.addColumn("الاسم");
                }
                if (chb_studentPhone.isSelected()) {
                    dm.addColumn("رقم الهاتف");
                }
                if (chb_address.isSelected()) {
                    dm.addColumn("العنوان");
                }
                if (chb_parentName.isSelected()) {
                    dm.addColumn("اسم ولي الامر");
                }
                if (chb_parentPhone.isSelected()) {
                    dm.addColumn("رقم ولي الامر");
                }
                if (chb_parentJob.isSelected()) {
                    dm.addColumn("مهنة ولي الامر");
                }
                if (chb_date.isSelected()) {
                    dm.addColumn("التاريخ");
                }

                while (set.next()) {
                    ArrayList<String> r2 = new ArrayList<>();
                    r2.add(set.getString(1));
                    if (chb_level.isSelected()) {
                        r2.add(set.getString(9));
                    }
                    if (chb_studentName.isSelected()) {
                        r2.add(set.getString(2));
                    }
                    if (chb_studentPhone.isSelected()) {
                        r2.add(set.getString(3));
                    }
                    if (chb_address.isSelected()) {
                        r2.add(set.getString(4));
                    }
                    if (chb_parentName.isSelected()) {
                        r2.add(set.getString(5));
                    }
                    if (chb_parentPhone.isSelected()) {
                        r2.add(set.getString(6));
                    }
                    if (chb_parentJob.isSelected()) {
                        r2.add(set.getString(7));
                    }

                    if (chb_date.isSelected()) {
                        r2.add(set.getString(10));
                    }

                    String r[] = r2.toArray(new String[r2.size()]);
                    dm.addRow(r);
                }
                t_viewStudentData.setModel(dm);
                lb_number.setText(String.valueOf(dm.getRowCount()));
                printTableDetermination = 0;

            } catch (SQLException ex) {
                handleSqlExceptions(ex.getErrorCode());
            }
        }
    }//GEN-LAST:event_btn_viewGroupActionPerformed

    private void btn_viewGroupMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_viewGroupMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_viewGroupMouseExited

    private void btn_viewGroupMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_viewGroupMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_viewGroupMouseEntered

    private void btn_viewLevelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_viewLevelActionPerformed
        String level = cb_level2.getSelectedItem().toString();
        if (checkEmpty(cb_level2)) {
            try {
                PreparedStatement stmt = con.prepareStatement("select * from student where student_status!=? and level_name=? order by student_code asc");
                stmt.setString(1, "موقوف");
                stmt.setString(2, level);
                ResultSet set = stmt.executeQuery();

                DefaultTableModel dm = new DefaultTableModel();
                dm.addColumn("الكود");
                if (chb_level.isSelected()) {
                    dm.addColumn("الفرقة");
                }
                if (chb_studentName.isSelected()) {
                    dm.addColumn("الاسم");
                }
                if (chb_studentPhone.isSelected()) {
                    dm.addColumn("رقم الهاتف");
                }
                if (chb_address.isSelected()) {
                    dm.addColumn("العنوان");
                }
                if (chb_parentName.isSelected()) {
                    dm.addColumn("اسم ولي الامر");
                }
                if (chb_parentPhone.isSelected()) {
                    dm.addColumn("رقم ولي الامر");
                }
                if (chb_parentJob.isSelected()) {
                    dm.addColumn("مهنة ولي الامر");
                }
                if (chb_date.isSelected()) {
                    dm.addColumn("التاريخ");
                }

                while (set.next()) {
                    ArrayList<String> r2 = new ArrayList<>();
                    r2.add(set.getString(1));
                    if (chb_level.isSelected()) {
                        r2.add(set.getString(9));
                    }
                    if (chb_studentName.isSelected()) {
                        r2.add(set.getString(2));
                    }
                    if (chb_studentPhone.isSelected()) {
                        r2.add(set.getString(3));
                    }
                    if (chb_address.isSelected()) {
                        r2.add(set.getString(4));
                    }
                    if (chb_parentName.isSelected()) {
                        r2.add(set.getString(5));
                    }
                    if (chb_parentPhone.isSelected()) {
                        r2.add(set.getString(6));
                    }
                    if (chb_parentJob.isSelected()) {
                        r2.add(set.getString(7));
                    }
                    if (chb_date.isSelected()) {
                        r2.add(set.getString(10));
                    }
                    String r[] = r2.toArray(new String[r2.size()]);
                    dm.addRow(r);
                }
                t_viewStudentData.setModel(dm);
                lb_number.setText(String.valueOf(dm.getRowCount()));
                printTableDetermination = 1;
            } catch (SQLException ex) {
                handleSqlExceptions(ex.getErrorCode());
            }
        }
    }//GEN-LAST:event_btn_viewLevelActionPerformed

    private void btn_viewLevelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_viewLevelMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_viewLevelMouseExited

    private void btn_viewLevelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_viewLevelMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_viewLevelMouseEntered

    private void btn_viewAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_viewAllActionPerformed

        try {
            PreparedStatement stmt = con.prepareStatement("select * from student where student_status=? order by student_code asc");
            stmt.setString(1, "موقوف");
            ResultSet set = stmt.executeQuery();

            DefaultTableModel dm = new DefaultTableModel();
            dm.addColumn("الكود");
            dm.addColumn("الفرقة");
            dm.addColumn("الاسم");
            dm.addColumn("تاريخ الايقاف");

            while (set.next()) {
                ArrayList<String> r2 = new ArrayList<>();
                r2.add(set.getString(1));
                r2.add(set.getString(9));
                r2.add(set.getString(2));
                r2.add(set.getString(12));

                String r[] = r2.toArray(new String[r2.size()]);
                dm.addRow(r);
            }
            t_viewStudentData.setModel(dm);
            lb_number.setText(String.valueOf(dm.getRowCount()));
            printTableDetermination = 2;
        } catch (SQLException ex) {
            handleSqlExceptions(ex.getErrorCode());
        }

    }//GEN-LAST:event_btn_viewAllActionPerformed

    private void btn_viewAllMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_viewAllMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_viewAllMouseExited

    private void btn_viewAllMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_viewAllMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_viewAllMouseEntered

    private void cb_level2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_level2ItemStateChanged
        loadGroup(cb_group, cb_level2.getSelectedItem().toString());
    }//GEN-LAST:event_cb_level2ItemStateChanged

    private void cb_level2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cb_level2FocusGained
        FocusLostOrGained(cb_level2);
    }//GEN-LAST:event_cb_level2FocusGained

    private void cb_level2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cb_level2FocusLost
        FocusLostOrGained(cb_level2);
    }//GEN-LAST:event_cb_level2FocusLost

    private void cb_groupFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cb_groupFocusGained
        FocusLostOrGained(cb_group);
    }//GEN-LAST:event_cb_groupFocusGained

    private void cb_groupFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cb_groupFocusLost
        FocusLostOrGained(cb_group);
    }//GEN-LAST:event_cb_groupFocusLost

    private void tf_studentName2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_studentName2FocusGained
        FocusLostOrGained(tf_studentName2);
    }//GEN-LAST:event_tf_studentName2FocusGained

    private void tf_studentName2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_studentName2FocusLost
        FocusLostOrGained(tf_studentName2);
    }//GEN-LAST:event_tf_studentName2FocusLost

    private void tf_studentName2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_studentName2KeyPressed
        if (enter(evt.getKeyChar())) {
            tf_address1.requestFocus(true);
        }
    }//GEN-LAST:event_tf_studentName2KeyPressed

    private void tf_studentName2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_studentName2KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_studentName2KeyTyped

    private void cb_level3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_level3ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_level3ItemStateChanged

    private void cb_level3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cb_level3FocusGained
        FocusLostOrGained(cb_level3);
    }//GEN-LAST:event_cb_level3FocusGained

    private void cb_level3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cb_level3FocusLost
        FocusLostOrGained(cb_level3);
    }//GEN-LAST:event_cb_level3FocusLost

    private void tf_code2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_code2FocusGained
        FocusLostOrGained(tf_code2);
    }//GEN-LAST:event_tf_code2FocusGained

    private void tf_code2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_code2FocusLost
        FocusLostOrGained(tf_code2);
    }//GEN-LAST:event_tf_code2FocusLost

    private void tf_code2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_code2KeyTyped
        textFieldValidation(tf_code2, evt.getKeyChar(), evt);
    }//GEN-LAST:event_tf_code2KeyTyped

    private void tf_studentName3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_studentName3FocusGained
        FocusLostOrGained(tf_studentName3);
    }//GEN-LAST:event_tf_studentName3FocusGained

    private void tf_studentName3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_studentName3FocusLost
        FocusLostOrGained(tf_studentName3);
    }//GEN-LAST:event_tf_studentName3FocusLost

    private void rb_studentCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_studentCodeActionPerformed
        if (checkEmpty(cb_level3)) {
            tf_code2.setEnabled(true);
            tf_studentName3.setEnabled(false);
        } else {
            buttonGroup1.clearSelection();
        }

    }//GEN-LAST:event_rb_studentCodeActionPerformed

    private void rb_studentNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_studentNameActionPerformed
        if (checkEmpty(cb_level3)) {
            tf_code2.setEnabled(false);
            tf_studentName3.setEnabled(true);
        } else {
            buttonGroup1.clearSelection();
        }
    }//GEN-LAST:event_rb_studentNameActionPerformed

    private void ta_newNoteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ta_newNoteFocusGained
        FocusLostOrGained(ta_newNote);
    }//GEN-LAST:event_ta_newNoteFocusGained

    private void ta_newNoteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ta_newNoteFocusLost
        FocusLostOrGained(ta_newNote);
    }//GEN-LAST:event_ta_newNoteFocusLost

    private void t_oldNoteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_oldNoteMouseClicked
        btn_delete1.setEnabled(true);
    }//GEN-LAST:event_t_oldNoteMouseClicked

    private void btn_clean1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clean1ActionPerformed
        cleanAfterAdd();
    }//GEN-LAST:event_btn_clean1ActionPerformed

    private void cb_levelFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cb_levelFocusGained
        FocusLostOrGained(cb_level);
    }//GEN-LAST:event_cb_levelFocusGained

    private void cb_levelFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cb_levelFocusLost
        FocusLostOrGained(cb_level);
    }//GEN-LAST:event_cb_levelFocusLost

    private void t_viewStudentDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_viewStudentDataMouseClicked
        btn_viewStudent.setEnabled(true);
    }//GEN-LAST:event_t_viewStudentDataMouseClicked

    private void tf_code1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_code1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_code1ActionPerformed

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
            java.util.logging.Logger.getLogger(StudentManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentManagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane StudentManagement;
    private javax.swing.JButton btn_Setting;
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_clean;
    private javax.swing.JButton btn_clean1;
    private javax.swing.JButton btn_clean2;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_delete1;
    private javax.swing.JButton btn_home;
    private javax.swing.JButton btn_notes;
    private javax.swing.JButton btn_print;
    private javax.swing.JButton btn_save;
    private javax.swing.JButton btn_savenote;
    private javax.swing.JButton btn_search;
    private javax.swing.JButton btn_search1;
    private javax.swing.JButton btn_search2;
    private javax.swing.JButton btn_stop;
    private javax.swing.JButton btn_update;
    private javax.swing.JButton btn_view;
    private javax.swing.JButton btn_viewAll;
    private javax.swing.JButton btn_viewGroup;
    private javax.swing.JButton btn_viewLevel;
    private javax.swing.JButton btn_viewStudent;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cb_group;
    private javax.swing.JComboBox<String> cb_level;
    private javax.swing.JComboBox<String> cb_level1;
    private javax.swing.JComboBox<String> cb_level2;
    private javax.swing.JComboBox<String> cb_level3;
    private javax.swing.JCheckBox chb_address;
    private javax.swing.JCheckBox chb_date;
    private javax.swing.JCheckBox chb_level;
    private javax.swing.JCheckBox chb_parentJob;
    private javax.swing.JCheckBox chb_parentName;
    private javax.swing.JCheckBox chb_parentPhone;
    private javax.swing.JCheckBox chb_studentName;
    private javax.swing.JCheckBox chb_studentPhone;
    private javax.swing.JLabel lb_addToHave;
    private javax.swing.JLabel lb_addToHave1;
    private javax.swing.JLabel lb_added;
    private javax.swing.JLabel lb_added1;
    private javax.swing.JLabel lb_address;
    private javax.swing.JLabel lb_address1;
    private javax.swing.JLabel lb_address5;
    private javax.swing.JLabel lb_avilable;
    private javax.swing.JLabel lb_classification;
    private javax.swing.JLabel lb_code;
    private javax.swing.JLabel lb_code1;
    private javax.swing.JLabel lb_code2;
    private javax.swing.JLabel lb_date;
    private javax.swing.JLabel lb_empty3;
    private javax.swing.JLabel lb_empty4;
    private javax.swing.JLabel lb_have;
    private javax.swing.JLabel lb_have1;
    private javax.swing.JLabel lb_haveToAdd;
    private javax.swing.JLabel lb_haveToAdd1;
    private javax.swing.JLabel lb_job;
    private javax.swing.JLabel lb_level;
    private javax.swing.JLabel lb_level1;
    private javax.swing.JLabel lb_levelName1;
    private javax.swing.JLabel lb_levelName2;
    private javax.swing.JLabel lb_maxavalible;
    private javax.swing.JLabel lb_noteScript;
    private javax.swing.JLabel lb_noteScript1;
    private javax.swing.JLabel lb_number;
    private javax.swing.JLabel lb_number1;
    private javax.swing.JLabel lb_oldNote;
    private javax.swing.JLabel lb_parentData;
    private javax.swing.JLabel lb_parentJob1;
    private javax.swing.JLabel lb_parentJob2;
    private javax.swing.JLabel lb_parentName;
    private javax.swing.JLabel lb_parentName1;
    private javax.swing.JLabel lb_parentName2;
    private javax.swing.JLabel lb_parentPhone1;
    private javax.swing.JLabel lb_parentPhone2;
    private javax.swing.JLabel lb_phone;
    private javax.swing.JLabel lb_relativity;
    private javax.swing.JLabel lb_relativity1;
    private javax.swing.JLabel lb_star;
    private javax.swing.JLabel lb_star10;
    private javax.swing.JLabel lb_star11;
    private javax.swing.JLabel lb_star12;
    private javax.swing.JLabel lb_star13;
    private javax.swing.JLabel lb_star14;
    private javax.swing.JLabel lb_star15;
    private javax.swing.JLabel lb_star16;
    private javax.swing.JLabel lb_star17;
    private javax.swing.JLabel lb_star18;
    private javax.swing.JLabel lb_star2;
    private javax.swing.JLabel lb_star3;
    private javax.swing.JLabel lb_star4;
    private javax.swing.JLabel lb_star5;
    private javax.swing.JLabel lb_star6;
    private javax.swing.JLabel lb_star7;
    private javax.swing.JLabel lb_star8;
    private javax.swing.JLabel lb_star9;
    private javax.swing.JLabel lb_status;
    private javax.swing.JLabel lb_status1;
    private javax.swing.JLabel lb_studentData;
    private javax.swing.JLabel lb_studentName;
    private javax.swing.JLabel lb_studentName1;
    private javax.swing.JLabel lb_studentName2;
    private javax.swing.JLabel lb_studentName4;
    private javax.swing.JLabel lb_studentName5;
    private javax.swing.JLabel lb_studentPhone;
    private javax.swing.JLabel lb_studentPhone1;
    private javax.swing.JLabel lb_studentPhone5;
    private javax.swing.JLabel lb_write;
    private javax.swing.JLabel lb_written_by;
    private javax.swing.JLabel lb_written_date;
    private javax.swing.JLabel lp_empty;
    private javax.swing.JLabel lp_empty1;
    private javax.swing.JLabel lp_empty2;
    private javax.swing.JList<String> lst_added;
    private javax.swing.JList<String> lst_added1;
    private javax.swing.JList<String> lst_have;
    private javax.swing.JList<String> lst_have1;
    private javax.swing.JList<String> lst_searchNames;
    private javax.swing.JPanel pl_addingStudent;
    private javax.swing.JPanel pl_background;
    private javax.swing.JPanel pl_bottomButtonCotrol;
    private javax.swing.JPanel pl_checkBoxForParent;
    private javax.swing.JPanel pl_checkBoxForStudent;
    private javax.swing.JPanel pl_horizontalBottomLine;
    private javax.swing.JPanel pl_horizontalBottomLine1;
    private javax.swing.JPanel pl_horizontalLine;
    private javax.swing.JPanel pl_notes;
    private javax.swing.JPanel pl_parentData;
    private javax.swing.JPanel pl_parentData1;
    private javax.swing.JPanel pl_parents;
    private javax.swing.JPanel pl_searchNames;
    private javax.swing.JPanel pl_searchingStudent;
    private javax.swing.JPanel pl_seperateLine;
    private javax.swing.JPanel pl_student;
    private javax.swing.JPanel pl_studentData;
    private javax.swing.JPanel pl_studentData1;
    private javax.swing.JPanel pl_studentDataForSearch;
    private javax.swing.JPanel pl_studentDataForSearch1;
    private javax.swing.JPanel pl_topButtonControl;
    private javax.swing.JPanel pl_verticalLine;
    private javax.swing.JPanel pl_verticalLine1;
    private javax.swing.JPanel pl_verticalSeperateLine;
    private javax.swing.JPanel pl_verticalSeperatePanel;
    private javax.swing.JPanel pl_viewButtonsControl;
    private javax.swing.JPanel pl_viewingStudent;
    private javax.swing.JRadioButton rb_code;
    private javax.swing.JRadioButton rb_name;
    private javax.swing.JRadioButton rb_studentCode;
    private javax.swing.JRadioButton rb_studentName;
    private javax.swing.JScrollPane sp_added1;
    private javax.swing.JScrollPane sp_addedd;
    private javax.swing.JScrollPane sp_have;
    private javax.swing.JScrollPane sp_have1;
    private javax.swing.JScrollPane sp_newNote;
    private javax.swing.JScrollPane sp_oldNote;
    private javax.swing.JScrollPane sp_searchNames;
    private javax.swing.JScrollPane sp_studentData;
    private javax.swing.JScrollPane sp_studentManagement;
    private javax.swing.JTable t_oldNote;
    private javax.swing.JTable t_viewStudentData;
    private javax.swing.JTextArea ta_newNote;
    private javax.swing.JTextField tf_address;
    private javax.swing.JTextField tf_address1;
    private javax.swing.JTextField tf_avilable;
    private javax.swing.JTextField tf_code;
    private javax.swing.JTextField tf_code1;
    private javax.swing.JTextField tf_code2;
    private javax.swing.JTextField tf_job;
    private javax.swing.JTextField tf_job1;
    private javax.swing.JTextField tf_parentName;
    private javax.swing.JTextField tf_parentName1;
    private javax.swing.JTextField tf_parentPhone;
    private javax.swing.JTextField tf_parentPhone1;
    private javax.swing.JTextField tf_relativity;
    private javax.swing.JTextField tf_relativity1;
    private javax.swing.JTextField tf_status;
    private javax.swing.JTextField tf_studentName;
    private javax.swing.JTextField tf_studentName1;
    private javax.swing.JTextField tf_studentName2;
    private javax.swing.JTextField tf_studentName3;
    private javax.swing.JTextField tf_studentPhone;
    private javax.swing.JTextField tf_studentPhone1;
    // End of variables declaration//GEN-END:variables

}
