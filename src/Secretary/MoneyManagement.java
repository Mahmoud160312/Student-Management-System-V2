package Secretary;

import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import newatomicstudent.functions;
import static newatomicstudent.functions.*;

/**
 *
 * @author mahmo
 */
public class MoneyManagement extends javax.swing.JFrame {

    Connection con;

    // this variable is very important for printing will determine which content will be printed depend on the buttons clicked
    int printTableDetermination = -1;

    /**
     * Creates new form MoneyManagement
     */
    public MoneyManagement() {
        initComponents();
        setIcon();
        // initialize the genral_connection
        con = general_connection();

        // view only month Cost panel  
        pl_monthCost.setVisible(true);
        pl_bookCost.setVisible(false);
        pl_didNotPayYet.setVisible(false);
        pl_externalMoney.setVisible(false);
        pl_dailyReport.setVisible(false);

        // hover only Month Cost button
        hoverInMouseClicked(btn_monthCost);
        defaultAfterHover(btn_bookCost);
        defaultAfterHover(btn_didNotPayYet);
        defaultAfterHover(btn_externalMoney);
        defaultAfterHover(btn_dialyReport);

        // month cost panel
        loadLevel(cb_level);
        pl_searchNames.setVisible(false);

        //book Cost panel
        loadLevel(cb_level1);
        loadBook(cb_book1, cb_level1.getSelectedItem().toString());
        pl_searchNames1.setVisible(false);

        // didn't pay yet panel
        loadLevel(cb_level2);

        // paid panel
        loadLevel(cb_level3);

        // didn't pay book yet panel
        loadLevel(cb_level5);
        loadBook(cb_book5, cb_level5.getSelectedItem().toString());

        // paid book panel
        loadLevel(cb_level6);
        loadBook(cb_book6, cb_level6.getSelectedItem().toString());

        // change cursor pointer to hand cursor in all buttons;
        changeCurssorWhenEnterButton(btn_Setting);
        changeCurssorWhenEnterButton(btn_add);
        changeCurssorWhenEnterButton(btn_add1);
        changeCurssorWhenEnterButton(btn_add2);
        changeCurssorWhenEnterButton(btn_bookCost);
        changeCurssorWhenEnterButton(btn_clean);
        changeCurssorWhenEnterButton(btn_clean1);
        changeCurssorWhenEnterButton(btn_clean2);
        changeCurssorWhenEnterButton(btn_delete);
        changeCurssorWhenEnterButton(btn_delete1);
        changeCurssorWhenEnterButton(btn_delete2);
        changeCurssorWhenEnterButton(btn_dialyReport);
        changeCurssorWhenEnterButton(btn_didNotPayYet);
        changeCurssorWhenEnterButton(btn_externalMoney);
        changeCurssorWhenEnterButton(btn_home);
        changeCurssorWhenEnterButton(btn_monthCost);
        changeCurssorWhenEnterButton(btn_printExternalMoney);
        changeCurssorWhenEnterButton(btn_search);
        changeCurssorWhenEnterButton(btn_search1);
        changeCurssorWhenEnterButton(btn_search2);
        changeCurssorWhenEnterButton(btn_search3);
        changeCurssorWhenEnterButton(btn_update);
        changeCurssorWhenEnterButton(btn_update1);
    }

    public void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(returnYourImageURL())));
    }

    // this function will clean after action in month cost panel
    public void cleanAfterAddDeleteUpdateMonth() {
        tf_code.setText("");
        tf_studentName.setText("");
        tf_paid.setText("0");
        tf_rest.setText("0");
        tf_discount.setText("0");
        DefaultListModel lst = new DefaultListModel();
        lst_searchNames.setModel(lst);
        btn_update.setEnabled(false);
        btn_delete.setEnabled(false);
        btn_add.setEnabled(true);
        btn_search.setEnabled(true);
        cb_level.setEnabled(true);
        cb_month.setEnabled(true);
        tf_studentName.setEnabled(true);
        tf_code.setEnabled(true);
        FocusLostOrGained(cb_level);
        FocusLostOrGained(cb_month);
        FocusLostOrGained(tf_code);
        FocusLostOrGained(tf_studentName);
        FocusLostOrGained(tf_paid);
        FocusLostOrGained(tf_discount);
        tf_code.requestFocus(true);
        pl_searchNames.setVisible(false);
        btn_printBill.setEnabled(false);
    }
    // this function will clean after action in book cost panel

    public void cleanAfterAddDeleteUpdateBook() {
        tf_code1.setText("");
        tf_recieve.setText("");
        tf_studentName1.setText("");
        tf_paid1.setText("0");
        tf_rest1.setText("0");
        tf_discount1.setText("0");
        DefaultListModel lst = new DefaultListModel();
        lst_searchNames1.setModel(lst);
        btn_update1.setEnabled(false);
        btn_delete1.setEnabled(false);
        btn_recieve.setEnabled(false);
        btn_add1.setEnabled(true);
        btn_search1.setEnabled(true);
        cb_level1.setEnabled(true);
        FocusLostOrGained(cb_level1);
        FocusLostOrGained(tf_code1);
        FocusLostOrGained(tf_studentName1);
        FocusLostOrGained(tf_paid1);
        FocusLostOrGained(tf_discount1);
        tf_code1.requestFocus(true);
        tf_code1.setEnabled(true);
        tf_studentName1.setEnabled(true);
        cb_book1.setEnabled(true);

    }

    // clean after add external money
    public void cleanAfterAddOrDeleteExternalMoney() {
        tf_person.setText("");
        tf_reason.setText("");
        tf_amount.setText("");
        FocusLostOrGained(cb_month2);
        FocusLostOrGained(tf_person);
        FocusLostOrGained(tf_reason);
        FocusLostOrGained(tf_amount);
        cb_month2.setEnabled(true);
        tf_person.setEnabled(true);
        tf_reason.setEnabled(true);
        tf_amount.setEnabled(true);
        btn_add2.setEnabled(true);
        btn_delete2.setEnabled(false);

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
        sp_moneyManagement = new javax.swing.JScrollPane();
        lb_background = new javax.swing.JPanel();
        pl_topButtonControl = new javax.swing.JPanel();
        btn_dialyReport = new javax.swing.JButton();
        btn_externalMoney = new javax.swing.JButton();
        btn_didNotPayYetBook = new javax.swing.JButton();
        btn_paiedBook = new javax.swing.JButton();
        btn_bookCost = new javax.swing.JButton();
        btn_didNotPayYet = new javax.swing.JButton();
        btn_paied = new javax.swing.JButton();
        btn_monthCost = new javax.swing.JButton();
        moneyManagement = new javax.swing.JLayeredPane();
        pl_monthCost = new javax.swing.JPanel();
        pl_studentDataForSearch = new javax.swing.JPanel();
        cb_level = new javax.swing.JComboBox<>();
        lb_levelName = new javax.swing.JLabel();
        tf_code = new javax.swing.JTextField();
        lb_code = new javax.swing.JLabel();
        tf_studentName = new javax.swing.JTextField();
        lb_studentName = new javax.swing.JLabel();
        cb_month = new javax.swing.JComboBox<>();
        lb_month = new javax.swing.JLabel();
        lb_star6 = new javax.swing.JLabel();
        lb_star8 = new javax.swing.JLabel();
        lb_star9 = new javax.swing.JLabel();
        lb_star10 = new javax.swing.JLabel();
        btn_search = new javax.swing.JButton();
        btn_clean = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_add = new javax.swing.JButton();
        pl_horizontalBottomLine1 = new javax.swing.JPanel();
        pl_monthCostData = new javax.swing.JPanel();
        tf_rest = new javax.swing.JTextField();
        lb_rest = new javax.swing.JLabel();
        tf_total = new javax.swing.JTextField();
        lb_total = new javax.swing.JLabel();
        tf_discount = new javax.swing.JTextField();
        lb_discount = new javax.swing.JLabel();
        tf_paid = new javax.swing.JTextField();
        lb_paid = new javax.swing.JLabel();
        pl_searchNames = new javax.swing.JPanel();
        sp_searchNames = new javax.swing.JScrollPane();
        lst_searchNames = new javax.swing.JList<>();
        btn_printBill = new javax.swing.JButton();
        pl_bookCost = new javax.swing.JPanel();
        lb_star7 = new javax.swing.JLabel();
        lb_star11 = new javax.swing.JLabel();
        lb_star13 = new javax.swing.JLabel();
        btn_search1 = new javax.swing.JButton();
        btn_clean1 = new javax.swing.JButton();
        btn_update1 = new javax.swing.JButton();
        btn_delete1 = new javax.swing.JButton();
        btn_add1 = new javax.swing.JButton();
        pl_horizontalBottomLine2 = new javax.swing.JPanel();
        pl_studentDataForSearch1 = new javax.swing.JPanel();
        cb_level1 = new javax.swing.JComboBox<>();
        lb_levelName1 = new javax.swing.JLabel();
        tf_code1 = new javax.swing.JTextField();
        lb_code1 = new javax.swing.JLabel();
        tf_studentName1 = new javax.swing.JTextField();
        lb_studentName1 = new javax.swing.JLabel();
        cb_book1 = new javax.swing.JComboBox<>();
        lb_book1 = new javax.swing.JLabel();
        lb_star15 = new javax.swing.JLabel();
        pl_monthCostData3 = new javax.swing.JPanel();
        tf_rest1 = new javax.swing.JTextField();
        lb_rest1 = new javax.swing.JLabel();
        tf_total1 = new javax.swing.JTextField();
        lb_total1 = new javax.swing.JLabel();
        tf_discount1 = new javax.swing.JTextField();
        lb_discount1 = new javax.swing.JLabel();
        tf_paid1 = new javax.swing.JTextField();
        lb_paid1 = new javax.swing.JLabel();
        pl_searchNames1 = new javax.swing.JPanel();
        sp_searchNames1 = new javax.swing.JScrollPane();
        lst_searchNames1 = new javax.swing.JList<>();
        lb_status = new javax.swing.JLabel();
        tf_recieve = new javax.swing.JTextField();
        btn_recieve = new javax.swing.JButton();
        pl_didNotPayYet = new javax.swing.JPanel();
        btn_search2 = new javax.swing.JButton();
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
        lb_level1 = new javax.swing.JLabel();
        pl_seperateLine = new javax.swing.JPanel();
        pl_checkBoxForStudent = new javax.swing.JPanel();
        chb_studentName = new javax.swing.JCheckBox();
        chb_studentPhone = new javax.swing.JCheckBox();
        chb_address = new javax.swing.JCheckBox();
        chb_level = new javax.swing.JCheckBox();
        pl_verticalSeperateLine = new javax.swing.JPanel();
        sp_studentData = new javax.swing.JScrollPane();
        t_viewStudentData = new javax.swing.JTable();
        lb_star16 = new javax.swing.JLabel();
        lb_star12 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        cb_level2 = new javax.swing.JComboBox<>();
        cb_month1 = new javax.swing.JComboBox<>();
        lb_didNotPayNumber = new javax.swing.JLabel();
        lb_number2 = new javax.swing.JLabel();
        btn_printInternalMoney2 = new javax.swing.JButton();
        pl_externalMoney = new javax.swing.JPanel();
        pl_verticalSeperateLine1 = new javax.swing.JPanel();
        sp_externalMoney = new javax.swing.JScrollPane();
        t_externalMoney = new javax.swing.JTable();
        lb_star17 = new javax.swing.JLabel();
        lb_star14 = new javax.swing.JLabel();
        pl_externalMoneyData = new javax.swing.JPanel();
        cb_month2 = new javax.swing.JComboBox<>();
        lb_month1 = new javax.swing.JLabel();
        tf_person = new javax.swing.JTextField();
        lb_person = new javax.swing.JLabel();
        tf_reason = new javax.swing.JTextField();
        lb_reason = new javax.swing.JLabel();
        tf_amount = new javax.swing.JTextField();
        lb_amount = new javax.swing.JLabel();
        lb_star18 = new javax.swing.JLabel();
        lb_star19 = new javax.swing.JLabel();
        btn_add2 = new javax.swing.JButton();
        btn_delete2 = new javax.swing.JButton();
        btn_clean2 = new javax.swing.JButton();
        pl_dailyReport = new javax.swing.JPanel();
        btn_search3 = new javax.swing.JButton();
        lb_classification1 = new javax.swing.JLabel();
        pl_checkBoxForParent1 = new javax.swing.JPanel();
        chb_monthCost = new javax.swing.JCheckBox();
        chb_monthRest = new javax.swing.JCheckBox();
        chb_day = new javax.swing.JCheckBox();
        pl_parents1 = new javax.swing.JPanel();
        lb_parentName3 = new javax.swing.JLabel();
        lb_parentPhone3 = new javax.swing.JLabel();
        lb_parentPhone5 = new javax.swing.JLabel();
        pl_student1 = new javax.swing.JPanel();
        lb_name = new javax.swing.JLabel();
        lb_studentPhone7 = new javax.swing.JLabel();
        pl_seperateLine1 = new javax.swing.JPanel();
        pl_checkBoxForStudent1 = new javax.swing.JPanel();
        chb_name = new javax.swing.JCheckBox();
        chb_Level = new javax.swing.JCheckBox();
        pl_verticalSeperateLine2 = new javax.swing.JPanel();
        lb_star20 = new javax.swing.JLabel();
        code = new javax.swing.JLabel();
        chb_code = new javax.swing.JCheckBox();
        pl_monthCostData2 = new javax.swing.JPanel();
        tf_totalAvilable = new javax.swing.JTextField();
        lb_total2 = new javax.swing.JLabel();
        tf_totalOutcome = new javax.swing.JTextField();
        lb_discount2 = new javax.swing.JLabel();
        tf_totalIncome = new javax.swing.JTextField();
        lb_paid2 = new javax.swing.JLabel();
        tf_BookIncome = new javax.swing.JTextField();
        lb_paid3 = new javax.swing.JLabel();
        dc_day = new com.toedter.calendar.JDateChooser();
        lb_name1 = new javax.swing.JLabel();
        pl_parents2 = new javax.swing.JPanel();
        lb_parentJob3 = new javax.swing.JLabel();
        lb_parentName4 = new javax.swing.JLabel();
        lb_parentPhone4 = new javax.swing.JLabel();
        pl_checkBoxForParent2 = new javax.swing.JPanel();
        chb_monthDiscount = new javax.swing.JCheckBox();
        chb_monthName = new javax.swing.JCheckBox();
        chb_time = new javax.swing.JCheckBox();
        pl_holdALlMoney = new javax.swing.JPanel();
        lb_internalMoney = new javax.swing.JLabel();
        sp_InternalMoney = new javax.swing.JScrollPane();
        t_InternalMoney = new javax.swing.JTable();
        btn_printInternalMoney = new javax.swing.JButton();
        lb_bookMoney = new javax.swing.JLabel();
        sp_BookMoney = new javax.swing.JScrollPane();
        t_BookMoney = new javax.swing.JTable();
        btn_printBookMoney = new javax.swing.JButton();
        lb_externalMoney = new javax.swing.JLabel();
        sp_externalMoneyData = new javax.swing.JScrollPane();
        t_externalMoneyData = new javax.swing.JTable();
        btn_printExternalMoney = new javax.swing.JButton();
        pl_paied = new javax.swing.JPanel();
        btn_search5 = new javax.swing.JButton();
        lb_classification3 = new javax.swing.JLabel();
        pl_checkBoxForParent5 = new javax.swing.JPanel();
        chb_parentName1 = new javax.swing.JCheckBox();
        chb_parentPhone1 = new javax.swing.JCheckBox();
        chb_parentJob1 = new javax.swing.JCheckBox();
        pl_parents5 = new javax.swing.JPanel();
        lb_parentName7 = new javax.swing.JLabel();
        lb_parentPhone9 = new javax.swing.JLabel();
        lb_parentJob5 = new javax.swing.JLabel();
        pl_student3 = new javax.swing.JPanel();
        lb_studentName6 = new javax.swing.JLabel();
        lb_studentPhone6 = new javax.swing.JLabel();
        lb_address6 = new javax.swing.JLabel();
        lb_level2 = new javax.swing.JLabel();
        pl_checkBoxForStudent3 = new javax.swing.JPanel();
        chb_studentName1 = new javax.swing.JCheckBox();
        chb_studentPhone1 = new javax.swing.JCheckBox();
        chb_address1 = new javax.swing.JCheckBox();
        chb_level1 = new javax.swing.JCheckBox();
        pl_verticalSeperateLine3 = new javax.swing.JPanel();
        sp_studentData1 = new javax.swing.JScrollPane();
        t_viewStudentData1 = new javax.swing.JTable();
        lb_star21 = new javax.swing.JLabel();
        lb_star22 = new javax.swing.JLabel();
        pl_level_month = new javax.swing.JPanel();
        cb_level3 = new javax.swing.JComboBox<>();
        cb_month3 = new javax.swing.JComboBox<>();
        lb_number1 = new javax.swing.JLabel();
        lb_payNumber = new javax.swing.JLabel();
        btn_printInternalMoney1 = new javax.swing.JButton();
        pl_didNotPayYetBook = new javax.swing.JPanel();
        btn_search4 = new javax.swing.JButton();
        lb_classification2 = new javax.swing.JLabel();
        pl_checkBoxForParent3 = new javax.swing.JPanel();
        chb_parentName3 = new javax.swing.JCheckBox();
        chb_parentPhone3 = new javax.swing.JCheckBox();
        chb_parentJob3 = new javax.swing.JCheckBox();
        pl_parents3 = new javax.swing.JPanel();
        lb_parentName5 = new javax.swing.JLabel();
        lb_parentPhone6 = new javax.swing.JLabel();
        lb_parentJob4 = new javax.swing.JLabel();
        pl_student2 = new javax.swing.JPanel();
        lb_studentName8 = new javax.swing.JLabel();
        lb_studentPhone9 = new javax.swing.JLabel();
        lb_address8 = new javax.swing.JLabel();
        lb_level4 = new javax.swing.JLabel();
        pl_checkBoxForStudent2 = new javax.swing.JPanel();
        chb_studentName3 = new javax.swing.JCheckBox();
        chb_studentPhone3 = new javax.swing.JCheckBox();
        chb_address3 = new javax.swing.JCheckBox();
        chb_level3 = new javax.swing.JCheckBox();
        pl_verticalSeperateLine5 = new javax.swing.JPanel();
        sp_studentData3 = new javax.swing.JScrollPane();
        t_viewStudentData3 = new javax.swing.JTable();
        lb_star25 = new javax.swing.JLabel();
        lb_star26 = new javax.swing.JLabel();
        LevelGroupHolder = new javax.swing.JPanel();
        cb_level5 = new javax.swing.JComboBox<>();
        cb_book5 = new javax.swing.JComboBox<>();
        btn_printInternalMoney3 = new javax.swing.JButton();
        pl_paiedBook = new javax.swing.JPanel();
        btn_search7 = new javax.swing.JButton();
        lb_classification5 = new javax.swing.JLabel();
        pl_checkBoxForParent7 = new javax.swing.JPanel();
        chb_parentName4 = new javax.swing.JCheckBox();
        chb_parentPhone4 = new javax.swing.JCheckBox();
        chb_parentJob4 = new javax.swing.JCheckBox();
        chb_recieve = new javax.swing.JCheckBox();
        pl_parents7 = new javax.swing.JPanel();
        lb_parentName9 = new javax.swing.JLabel();
        lb_parentPhone11 = new javax.swing.JLabel();
        lb_parentJob7 = new javax.swing.JLabel();
        lb_recieve = new javax.swing.JLabel();
        pl_student5 = new javax.swing.JPanel();
        lb_studentName9 = new javax.swing.JLabel();
        lb_studentPhone10 = new javax.swing.JLabel();
        lb_address9 = new javax.swing.JLabel();
        lb_level5 = new javax.swing.JLabel();
        pl_checkBoxForStudent5 = new javax.swing.JPanel();
        chb_studentName4 = new javax.swing.JCheckBox();
        chb_studentPhone4 = new javax.swing.JCheckBox();
        chb_address4 = new javax.swing.JCheckBox();
        chb_level4 = new javax.swing.JCheckBox();
        pl_verticalSeperateLine6 = new javax.swing.JPanel();
        sp_studentData4 = new javax.swing.JScrollPane();
        t_viewStudentData4 = new javax.swing.JTable();
        lb_star27 = new javax.swing.JLabel();
        lb_star28 = new javax.swing.JLabel();
        pl_level_month2 = new javax.swing.JPanel();
        cb_level6 = new javax.swing.JComboBox<>();
        cb_book6 = new javax.swing.JComboBox<>();
        btn_printInternalMoney4 = new javax.swing.JButton();
        pl_bottomButtonCotrol = new javax.swing.JPanel();
        lb_empty3 = new javax.swing.JLabel();
        lb_empty4 = new javax.swing.JLabel();
        lb_empty5 = new javax.swing.JLabel();
        btn_home = new javax.swing.JButton();
        btn_Setting = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        sp_moneyManagement.setBackground(new java.awt.Color(255, 255, 255));
        sp_moneyManagement.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        sp_moneyManagement.setToolTipText("");
        sp_moneyManagement.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        lb_background.setBackground(new java.awt.Color(255, 255, 255));
        lb_background.setPreferredSize(new java.awt.Dimension(1205, 650));

        pl_topButtonControl.setBackground(new java.awt.Color(19, 64, 93));
        pl_topButtonControl.setMinimumSize(new java.awt.Dimension(1205, 60));
        pl_topButtonControl.setPreferredSize(new java.awt.Dimension(1205, 60));
        pl_topButtonControl.setLayout(new java.awt.GridLayout(1, 0, 10, 10));

        btn_dialyReport.setBackground(new java.awt.Color(19, 64, 93));
        btn_dialyReport.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        btn_dialyReport.setForeground(new java.awt.Color(255, 255, 255));
        btn_dialyReport.setText("تقرير يومي");
        btn_dialyReport.setContentAreaFilled(false);
        btn_dialyReport.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btn_dialyReport.setIconTextGap(16);
        btn_dialyReport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_dialyReportMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_dialyReportMouseExited(evt);
            }
        });
        btn_dialyReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dialyReportActionPerformed(evt);
            }
        });
        pl_topButtonControl.add(btn_dialyReport);

        btn_externalMoney.setBackground(new java.awt.Color(19, 64, 93));
        btn_externalMoney.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        btn_externalMoney.setForeground(new java.awt.Color(255, 255, 255));
        btn_externalMoney.setText("المصاريف الخارجية");
        btn_externalMoney.setContentAreaFilled(false);
        btn_externalMoney.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btn_externalMoney.setIconTextGap(16);
        btn_externalMoney.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_externalMoneyMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_externalMoneyMouseExited(evt);
            }
        });
        btn_externalMoney.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_externalMoneyActionPerformed(evt);
            }
        });
        pl_topButtonControl.add(btn_externalMoney);

        btn_didNotPayYetBook.setBackground(new java.awt.Color(19, 64, 93));
        btn_didNotPayYetBook.setFont(new java.awt.Font("Cairo", 1, 13)); // NOI18N
        btn_didNotPayYetBook.setForeground(new java.awt.Color(255, 255, 255));
        btn_didNotPayYetBook.setText("المتخلفين عن الملازم");
        btn_didNotPayYetBook.setContentAreaFilled(false);
        btn_didNotPayYetBook.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btn_didNotPayYetBook.setIconTextGap(16);
        btn_didNotPayYetBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_didNotPayYetBookMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_didNotPayYetBookMouseExited(evt);
            }
        });
        btn_didNotPayYetBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_didNotPayYetBookActionPerformed(evt);
            }
        });
        pl_topButtonControl.add(btn_didNotPayYetBook);

        btn_paiedBook.setBackground(new java.awt.Color(19, 64, 93));
        btn_paiedBook.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        btn_paiedBook.setForeground(new java.awt.Color(255, 255, 255));
        btn_paiedBook.setText("الدافعين الملازم");
        btn_paiedBook.setContentAreaFilled(false);
        btn_paiedBook.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btn_paiedBook.setIconTextGap(16);
        btn_paiedBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_paiedBookMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_paiedBookMouseExited(evt);
            }
        });
        btn_paiedBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_paiedBookActionPerformed(evt);
            }
        });
        pl_topButtonControl.add(btn_paiedBook);

        btn_bookCost.setBackground(new java.awt.Color(19, 64, 93));
        btn_bookCost.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        btn_bookCost.setForeground(new java.awt.Color(255, 255, 255));
        btn_bookCost.setText("مصاريف الملازم");
        btn_bookCost.setContentAreaFilled(false);
        btn_bookCost.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btn_bookCost.setIconTextGap(16);
        btn_bookCost.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_bookCostMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_bookCostMouseExited(evt);
            }
        });
        btn_bookCost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_bookCostActionPerformed(evt);
            }
        });
        pl_topButtonControl.add(btn_bookCost);

        btn_didNotPayYet.setBackground(new java.awt.Color(19, 64, 93));
        btn_didNotPayYet.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        btn_didNotPayYet.setForeground(new java.awt.Color(255, 255, 255));
        btn_didNotPayYet.setText("المتخلفين عن الدفع");
        btn_didNotPayYet.setContentAreaFilled(false);
        btn_didNotPayYet.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btn_didNotPayYet.setIconTextGap(16);
        btn_didNotPayYet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_didNotPayYetMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_didNotPayYetMouseExited(evt);
            }
        });
        btn_didNotPayYet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_didNotPayYetActionPerformed(evt);
            }
        });
        pl_topButtonControl.add(btn_didNotPayYet);

        btn_paied.setBackground(new java.awt.Color(19, 64, 93));
        btn_paied.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        btn_paied.setForeground(new java.awt.Color(255, 255, 255));
        btn_paied.setText("الدافعين");
        btn_paied.setContentAreaFilled(false);
        btn_paied.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btn_paied.setIconTextGap(16);
        btn_paied.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_paiedMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_paiedMouseExited(evt);
            }
        });
        btn_paied.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_paiedActionPerformed(evt);
            }
        });
        pl_topButtonControl.add(btn_paied);

        btn_monthCost.setBackground(new java.awt.Color(19, 64, 93));
        btn_monthCost.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        btn_monthCost.setForeground(new java.awt.Color(255, 255, 255));
        btn_monthCost.setText("مصاريف الشهر");
        btn_monthCost.setContentAreaFilled(false);
        btn_monthCost.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btn_monthCost.setIconTextGap(16);
        btn_monthCost.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_monthCostMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_monthCostMouseExited(evt);
            }
        });
        btn_monthCost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_monthCostActionPerformed(evt);
            }
        });
        pl_topButtonControl.add(btn_monthCost);

        moneyManagement.setPreferredSize(new java.awt.Dimension(1205, 562));
        moneyManagement.setLayout(new java.awt.CardLayout());

        pl_monthCost.setBackground(new java.awt.Color(255, 255, 255));

        pl_studentDataForSearch.setBackground(new java.awt.Color(255, 255, 255));
        pl_studentDataForSearch.setLayout(new java.awt.GridLayout(4, 0, 10, 20));

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
        cb_level.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_levelActionPerformed(evt);
            }
        });
        cb_level.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cb_levelKeyTyped(evt);
            }
        });
        pl_studentDataForSearch.add(cb_level);

        lb_levelName.setBackground(new java.awt.Color(255, 255, 255));
        lb_levelName.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_levelName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_levelName.setText("الفرقة");
        pl_studentDataForSearch.add(lb_levelName);

        tf_code.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        tf_code.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_code.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 155, 255), 2, true));
        tf_code.setEnabled(false);
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
        pl_studentDataForSearch.add(tf_code);

        lb_code.setBackground(new java.awt.Color(255, 255, 255));
        lb_code.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_code.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_code.setText("كود الطالب");
        pl_studentDataForSearch.add(lb_code);

        tf_studentName.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        tf_studentName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_studentName.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 155, 255), 2, true));
        tf_studentName.setEnabled(false);
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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_studentNameKeyTyped(evt);
            }
        });
        pl_studentDataForSearch.add(tf_studentName);

        lb_studentName.setBackground(new java.awt.Color(255, 255, 255));
        lb_studentName.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_studentName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_studentName.setText("اسم الطالب");
        pl_studentDataForSearch.add(lb_studentName);

        cb_month.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        cb_month.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "اختر الشهر", "يناير", "فبراير", "مارس", "ابريل", "مايو", "يونيو", "يوليو", "اغسطس", "سبتمبر", "اكتوبر", "نوفمبر", "ديسمبر" }));
        cb_month.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 155, 255), 1, true));
        cb_month.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_monthItemStateChanged(evt);
            }
        });
        cb_month.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cb_monthFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cb_monthFocusLost(evt);
            }
        });
        cb_month.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cb_monthKeyPressed(evt);
            }
        });
        pl_studentDataForSearch.add(cb_month);

        lb_month.setBackground(new java.awt.Color(255, 255, 255));
        lb_month.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_month.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_month.setText("اسم الشهر");
        pl_studentDataForSearch.add(lb_month);

        lb_star6.setBackground(new java.awt.Color(255, 255, 255));
        lb_star6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_star6.setForeground(new java.awt.Color(255, 0, 0));
        lb_star6.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_star6.setText("*");

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

        btn_search.setBackground(new java.awt.Color(19, 64, 93));
        btn_search.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        btn_search.setForeground(new java.awt.Color(255, 255, 255));
        btn_search.setText("بحث");
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });

        btn_clean.setBackground(new java.awt.Color(153, 153, 153));
        btn_clean.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        btn_clean.setForeground(new java.awt.Color(255, 255, 255));
        btn_clean.setText("تنظيف");
        btn_clean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cleanActionPerformed(evt);
            }
        });

        btn_update.setBackground(new java.awt.Color(0, 0, 0));
        btn_update.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        btn_update.setForeground(new java.awt.Color(255, 255, 255));
        btn_update.setText("تعديل");
        btn_update.setEnabled(false);
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_delete.setBackground(new java.awt.Color(153, 0, 0));
        btn_delete.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        btn_delete.setForeground(new java.awt.Color(255, 255, 255));
        btn_delete.setText("حذف");
        btn_delete.setEnabled(false);
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_add.setBackground(new java.awt.Color(0, 155, 255));
        btn_add.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        btn_add.setForeground(new java.awt.Color(255, 255, 255));
        btn_add.setText("اضافة");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        pl_horizontalBottomLine1.setBackground(new java.awt.Color(102, 102, 102));
        pl_horizontalBottomLine1.setMinimumSize(new java.awt.Dimension(440, 5));
        pl_horizontalBottomLine1.setPreferredSize(new java.awt.Dimension(800, 2));

        javax.swing.GroupLayout pl_horizontalBottomLine1Layout = new javax.swing.GroupLayout(pl_horizontalBottomLine1);
        pl_horizontalBottomLine1.setLayout(pl_horizontalBottomLine1Layout);
        pl_horizontalBottomLine1Layout.setHorizontalGroup(
            pl_horizontalBottomLine1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 890, Short.MAX_VALUE)
        );
        pl_horizontalBottomLine1Layout.setVerticalGroup(
            pl_horizontalBottomLine1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pl_monthCostData.setBackground(new java.awt.Color(255, 255, 255));
        pl_monthCostData.setLayout(new java.awt.GridLayout(1, 0, 15, 10));

        tf_rest.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        tf_rest.setForeground(new java.awt.Color(204, 102, 0));
        tf_rest.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_rest.setText("0");
        tf_rest.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 155, 255), 2, true));
        tf_rest.setDisabledTextColor(new java.awt.Color(255, 153, 0));
        tf_rest.setEnabled(false);
        pl_monthCostData.add(tf_rest);

        lb_rest.setBackground(new java.awt.Color(255, 255, 255));
        lb_rest.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_rest.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_rest.setText("الباقي");
        pl_monthCostData.add(lb_rest);

        tf_total.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        tf_total.setForeground(new java.awt.Color(204, 102, 0));
        tf_total.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_total.setText("0");
        tf_total.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 155, 255), 2, true));
        tf_total.setDisabledTextColor(new java.awt.Color(255, 153, 0));
        tf_total.setEnabled(false);
        pl_monthCostData.add(tf_total);

        lb_total.setBackground(new java.awt.Color(255, 255, 255));
        lb_total.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_total.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_total.setText("الكلي");
        pl_monthCostData.add(lb_total);

        tf_discount.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        tf_discount.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_discount.setText("0");
        tf_discount.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 155, 255), 2, true));
        tf_discount.setEnabled(false);
        tf_discount.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_discountFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tf_discountFocusLost(evt);
            }
        });
        tf_discount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_discountActionPerformed(evt);
            }
        });
        tf_discount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_discountKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_discountKeyTyped(evt);
            }
        });
        pl_monthCostData.add(tf_discount);

        lb_discount.setBackground(new java.awt.Color(255, 255, 255));
        lb_discount.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_discount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_discount.setText("الخصم");
        pl_monthCostData.add(lb_discount);

        tf_paid.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        tf_paid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_paid.setText("0");
        tf_paid.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 155, 255), 2, true));
        tf_paid.setEnabled(false);
        tf_paid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_paidFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tf_paidFocusLost(evt);
            }
        });
        tf_paid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_paidKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_paidKeyTyped(evt);
            }
        });
        pl_monthCostData.add(tf_paid);

        lb_paid.setBackground(new java.awt.Color(255, 255, 255));
        lb_paid.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_paid.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_paid.setText("المدفوع");
        pl_monthCostData.add(lb_paid);

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pl_searchNamesLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(sp_searchNames, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btn_printBill.setBackground(new java.awt.Color(0, 155, 255));
        btn_printBill.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        btn_printBill.setForeground(new java.awt.Color(255, 255, 255));
        btn_printBill.setText("طباعة وصل مصاريف");
        btn_printBill.setEnabled(false);
        btn_printBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_printBillActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pl_monthCostLayout = new javax.swing.GroupLayout(pl_monthCost);
        pl_monthCost.setLayout(pl_monthCostLayout);
        pl_monthCostLayout.setHorizontalGroup(
            pl_monthCostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pl_monthCostLayout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addGroup(pl_monthCostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pl_monthCostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pl_monthCostLayout.createSequentialGroup()
                            .addComponent(pl_horizontalBottomLine1, javax.swing.GroupLayout.PREFERRED_SIZE, 890, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(118, 118, 118))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pl_monthCostLayout.createSequentialGroup()
                            .addComponent(pl_monthCostData, javax.swing.GroupLayout.PREFERRED_SIZE, 1100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(52, 52, 52))
                        .addGroup(pl_monthCostLayout.createSequentialGroup()
                            .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(220, 220, 220))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pl_monthCostLayout.createSequentialGroup()
                            .addGroup(pl_monthCostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lb_star10, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(pl_monthCostLayout.createSequentialGroup()
                                    .addGroup(pl_monthCostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btn_clean, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn_search, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(pl_searchNames, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(33, 33, 33)
                                    .addGroup(pl_monthCostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(pl_monthCostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lb_star9, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lb_star8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(lb_star6, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(pl_studentDataForSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(83, 83, 83)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pl_monthCostLayout.createSequentialGroup()
                        .addComponent(btn_printBill)
                        .addGap(862, 862, 862))))
        );
        pl_monthCostLayout.setVerticalGroup(
            pl_monthCostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pl_monthCostLayout.createSequentialGroup()
                .addGroup(pl_monthCostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pl_monthCostLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(lb_star10)
                        .addGap(42, 42, 42)
                        .addComponent(lb_star6)
                        .addGap(42, 42, 42)
                        .addComponent(lb_star8)
                        .addGap(35, 35, 35)
                        .addComponent(lb_star9))
                    .addGroup(pl_monthCostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pl_monthCostLayout.createSequentialGroup()
                            .addGap(53, 53, 53)
                            .addGroup(pl_monthCostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(pl_studentDataForSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(pl_searchNames, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pl_monthCostLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(btn_search)
                            .addGap(16, 16, 16)
                            .addComponent(btn_clean))))
                .addGap(18, 18, 18)
                .addComponent(pl_horizontalBottomLine1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(pl_monthCostData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addGroup(pl_monthCostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_add)
                    .addComponent(btn_delete)
                    .addComponent(btn_update))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_printBill)
                .addContainerGap())
        );

        moneyManagement.add(pl_monthCost, "card2");

        pl_bookCost.setBackground(new java.awt.Color(255, 255, 255));

        lb_star7.setBackground(new java.awt.Color(255, 255, 255));
        lb_star7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_star7.setForeground(new java.awt.Color(255, 0, 0));
        lb_star7.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_star7.setText("*");

        lb_star11.setBackground(new java.awt.Color(255, 255, 255));
        lb_star11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_star11.setForeground(new java.awt.Color(255, 0, 0));
        lb_star11.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_star11.setText("*");

        lb_star13.setBackground(new java.awt.Color(255, 255, 255));
        lb_star13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_star13.setForeground(new java.awt.Color(255, 0, 0));
        lb_star13.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_star13.setText("*");

        btn_search1.setBackground(new java.awt.Color(19, 64, 93));
        btn_search1.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        btn_search1.setForeground(new java.awt.Color(255, 255, 255));
        btn_search1.setText("بحث");
        btn_search1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_search1ActionPerformed(evt);
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

        btn_update1.setBackground(new java.awt.Color(0, 0, 0));
        btn_update1.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        btn_update1.setForeground(new java.awt.Color(255, 255, 255));
        btn_update1.setText("تعديل");
        btn_update1.setEnabled(false);
        btn_update1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_update1ActionPerformed(evt);
            }
        });

        btn_delete1.setBackground(new java.awt.Color(153, 0, 0));
        btn_delete1.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        btn_delete1.setForeground(new java.awt.Color(255, 255, 255));
        btn_delete1.setText("حذف");
        btn_delete1.setEnabled(false);
        btn_delete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delete1ActionPerformed(evt);
            }
        });

        btn_add1.setBackground(new java.awt.Color(0, 155, 255));
        btn_add1.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        btn_add1.setForeground(new java.awt.Color(255, 255, 255));
        btn_add1.setText("اضافة");
        btn_add1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_add1ActionPerformed(evt);
            }
        });

        pl_horizontalBottomLine2.setBackground(new java.awt.Color(102, 102, 102));
        pl_horizontalBottomLine2.setMinimumSize(new java.awt.Dimension(440, 5));
        pl_horizontalBottomLine2.setPreferredSize(new java.awt.Dimension(800, 2));

        javax.swing.GroupLayout pl_horizontalBottomLine2Layout = new javax.swing.GroupLayout(pl_horizontalBottomLine2);
        pl_horizontalBottomLine2.setLayout(pl_horizontalBottomLine2Layout);
        pl_horizontalBottomLine2Layout.setHorizontalGroup(
            pl_horizontalBottomLine2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 890, Short.MAX_VALUE)
        );
        pl_horizontalBottomLine2Layout.setVerticalGroup(
            pl_horizontalBottomLine2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pl_studentDataForSearch1.setBackground(new java.awt.Color(255, 255, 255));
        pl_studentDataForSearch1.setLayout(new java.awt.GridLayout(4, 0, 10, 20));

        cb_level1.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        cb_level1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "اختر الفرقة" }));
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
        pl_studentDataForSearch1.add(cb_level1);

        lb_levelName1.setBackground(new java.awt.Color(255, 255, 255));
        lb_levelName1.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_levelName1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_levelName1.setText("الفرقة");
        pl_studentDataForSearch1.add(lb_levelName1);

        tf_code1.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        tf_code1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_code1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 155, 255), 2, true));
        tf_code1.setEnabled(false);
        tf_code1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_code1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tf_code1FocusLost(evt);
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
        pl_studentDataForSearch1.add(tf_code1);

        lb_code1.setBackground(new java.awt.Color(255, 255, 255));
        lb_code1.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_code1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_code1.setText("كود الطالب");
        pl_studentDataForSearch1.add(lb_code1);

        tf_studentName1.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        tf_studentName1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_studentName1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 155, 255), 2, true));
        tf_studentName1.setEnabled(false);
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
        pl_studentDataForSearch1.add(tf_studentName1);

        lb_studentName1.setBackground(new java.awt.Color(255, 255, 255));
        lb_studentName1.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_studentName1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_studentName1.setText("اسم الطالب");
        pl_studentDataForSearch1.add(lb_studentName1);

        cb_book1.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        cb_book1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "اختر المذكرة" }));
        cb_book1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 155, 255), 1, true));
        cb_book1.setEnabled(false);
        cb_book1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_book1ItemStateChanged(evt);
            }
        });
        cb_book1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cb_book1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cb_book1FocusLost(evt);
            }
        });
        cb_book1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cb_book1KeyPressed(evt);
            }
        });
        pl_studentDataForSearch1.add(cb_book1);

        lb_book1.setBackground(new java.awt.Color(255, 255, 255));
        lb_book1.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_book1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_book1.setText("اسم المذكره");
        pl_studentDataForSearch1.add(lb_book1);

        lb_star15.setBackground(new java.awt.Color(255, 255, 255));
        lb_star15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_star15.setForeground(new java.awt.Color(255, 0, 0));
        lb_star15.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_star15.setText("*");

        pl_monthCostData3.setBackground(new java.awt.Color(255, 255, 255));
        pl_monthCostData3.setLayout(new java.awt.GridLayout(1, 0, 15, 10));

        tf_rest1.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        tf_rest1.setForeground(new java.awt.Color(204, 102, 0));
        tf_rest1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_rest1.setText("0");
        tf_rest1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 155, 255), 2, true));
        tf_rest1.setDisabledTextColor(new java.awt.Color(255, 153, 0));
        tf_rest1.setEnabled(false);
        pl_monthCostData3.add(tf_rest1);

        lb_rest1.setBackground(new java.awt.Color(255, 255, 255));
        lb_rest1.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_rest1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_rest1.setText("الباقي");
        pl_monthCostData3.add(lb_rest1);

        tf_total1.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        tf_total1.setForeground(new java.awt.Color(204, 102, 0));
        tf_total1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_total1.setText("0");
        tf_total1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 155, 255), 2, true));
        tf_total1.setDisabledTextColor(new java.awt.Color(255, 153, 0));
        tf_total1.setEnabled(false);
        pl_monthCostData3.add(tf_total1);

        lb_total1.setBackground(new java.awt.Color(255, 255, 255));
        lb_total1.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_total1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_total1.setText("الكلي");
        pl_monthCostData3.add(lb_total1);

        tf_discount1.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        tf_discount1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_discount1.setText("0");
        tf_discount1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 155, 255), 2, true));
        tf_discount1.setEnabled(false);
        tf_discount1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_discount1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tf_discount1FocusLost(evt);
            }
        });
        tf_discount1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_discount1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_discount1KeyTyped(evt);
            }
        });
        pl_monthCostData3.add(tf_discount1);

        lb_discount1.setBackground(new java.awt.Color(255, 255, 255));
        lb_discount1.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_discount1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_discount1.setText("الخصم");
        pl_monthCostData3.add(lb_discount1);

        tf_paid1.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        tf_paid1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_paid1.setText("0");
        tf_paid1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 155, 255), 2, true));
        tf_paid1.setEnabled(false);
        tf_paid1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_paid1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tf_paid1FocusLost(evt);
            }
        });
        tf_paid1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_paid1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_paid1KeyTyped(evt);
            }
        });
        pl_monthCostData3.add(tf_paid1);

        lb_paid1.setBackground(new java.awt.Color(255, 255, 255));
        lb_paid1.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_paid1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_paid1.setText("المدفوع");
        pl_monthCostData3.add(lb_paid1);

        pl_searchNames1.setBackground(new java.awt.Color(255, 255, 255));

        lst_searchNames1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 155, 255)));
        lst_searchNames1.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        lst_searchNames1.setMaximumSize(new java.awt.Dimension(180, 150));
        lst_searchNames1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lst_searchNames1ValueChanged(evt);
            }
        });
        sp_searchNames1.setViewportView(lst_searchNames1);

        javax.swing.GroupLayout pl_searchNames1Layout = new javax.swing.GroupLayout(pl_searchNames1);
        pl_searchNames1.setLayout(pl_searchNames1Layout);
        pl_searchNames1Layout.setHorizontalGroup(
            pl_searchNames1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pl_searchNames1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(sp_searchNames1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        pl_searchNames1Layout.setVerticalGroup(
            pl_searchNames1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp_searchNames1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
        );

        lb_status.setBackground(new java.awt.Color(255, 255, 255));
        lb_status.setFont(new java.awt.Font("Cairo", 1, 16)); // NOI18N
        lb_status.setForeground(new java.awt.Color(102, 102, 102));
        lb_status.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lb_status.setText("حالة الطالب : ");

        tf_recieve.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        tf_recieve.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_recieve.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 155, 255), 2, true));
        tf_recieve.setDisabledTextColor(new java.awt.Color(234, 84, 51));
        tf_recieve.setEnabled(false);
        tf_recieve.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_recieveKeyPressed(evt);
            }
        });

        btn_recieve.setBackground(new java.awt.Color(234, 84, 51));
        btn_recieve.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        btn_recieve.setForeground(new java.awt.Color(255, 255, 255));
        btn_recieve.setText("استلم/لم يستلم");
        btn_recieve.setEnabled(false);
        btn_recieve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_recieveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pl_bookCostLayout = new javax.swing.GroupLayout(pl_bookCost);
        pl_bookCost.setLayout(pl_bookCostLayout);
        pl_bookCostLayout.setHorizontalGroup(
            pl_bookCostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pl_bookCostLayout.createSequentialGroup()
                .addGroup(pl_bookCostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pl_bookCostLayout.createSequentialGroup()
                        .addContainerGap(25, Short.MAX_VALUE)
                        .addGroup(pl_bookCostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pl_bookCostLayout.createSequentialGroup()
                                .addComponent(pl_monthCostData3, javax.swing.GroupLayout.PREFERRED_SIZE, 1100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pl_bookCostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(pl_bookCostLayout.createSequentialGroup()
                                    .addGroup(pl_bookCostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pl_bookCostLayout.createSequentialGroup()
                                            .addGroup(pl_bookCostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(btn_clean1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(btn_search1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(pl_searchNames1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(pl_bookCostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(lb_star7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lb_star11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pl_bookCostLayout.createSequentialGroup()
                                            .addGap(0, 0, Short.MAX_VALUE)
                                            .addGroup(pl_bookCostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(lb_star13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lb_star15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGap(0, 0, 0)
                                    .addComponent(pl_studentDataForSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(pl_bookCostLayout.createSequentialGroup()
                                    .addComponent(pl_horizontalBottomLine2, javax.swing.GroupLayout.PREFERRED_SIZE, 890, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(94, 94, 94)))))
                    .addGroup(pl_bookCostLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(pl_bookCostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_recieve, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pl_bookCostLayout.createSequentialGroup()
                                .addComponent(tf_recieve, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lb_status)))
                        .addGap(99, 99, 99)
                        .addGroup(pl_bookCostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_update1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_delete1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_add1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(55, 55, 55))
        );
        pl_bookCostLayout.setVerticalGroup(
            pl_bookCostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pl_bookCostLayout.createSequentialGroup()
                .addGroup(pl_bookCostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pl_bookCostLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lb_star15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(lb_star13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(lb_star7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(lb_star11)
                        .addGap(42, 42, 42))
                    .addGroup(pl_bookCostLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(pl_bookCostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pl_searchNames1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pl_studentDataForSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pl_bookCostLayout.createSequentialGroup()
                                .addComponent(btn_search1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_clean1)
                                .addGap(9, 9, 9)))
                        .addGap(16, 16, 16)))
                .addComponent(pl_horizontalBottomLine2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(pl_monthCostData3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(pl_bookCostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pl_bookCostLayout.createSequentialGroup()
                        .addComponent(btn_update1)
                        .addGap(30, 30, 30)
                        .addGroup(pl_bookCostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_delete1)
                            .addComponent(btn_add1)))
                    .addGroup(pl_bookCostLayout.createSequentialGroup()
                        .addComponent(btn_recieve)
                        .addGap(18, 18, 18)
                        .addGroup(pl_bookCostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_recieve, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_status, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(38, 38, 38))
        );

        moneyManagement.add(pl_bookCost, "card2");

        pl_didNotPayYet.setBackground(new java.awt.Color(255, 255, 255));

        btn_search2.setBackground(new java.awt.Color(19, 64, 93));
        btn_search2.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        btn_search2.setForeground(new java.awt.Color(255, 255, 255));
        btn_search2.setText("بحث");
        btn_search2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_search2ActionPerformed(evt);
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

        lb_level1.setBackground(new java.awt.Color(255, 255, 255));
        lb_level1.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_level1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_level1.setText("الفرقة");
        pl_student.add(lb_level1);

        pl_seperateLine.setBackground(new java.awt.Color(153, 153, 153));
        pl_seperateLine.setPreferredSize(new java.awt.Dimension(600, 2));

        javax.swing.GroupLayout pl_seperateLineLayout = new javax.swing.GroupLayout(pl_seperateLine);
        pl_seperateLine.setLayout(pl_seperateLineLayout);
        pl_seperateLineLayout.setHorizontalGroup(
            pl_seperateLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 344, Short.MAX_VALUE)
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

        chb_level.setBackground(new java.awt.Color(255, 255, 255));
        chb_level.setSelected(true);
        pl_checkBoxForStudent.add(chb_level);

        pl_verticalSeperateLine.setBackground(new java.awt.Color(153, 153, 153));
        pl_verticalSeperateLine.setPreferredSize(new java.awt.Dimension(2, 500));

        javax.swing.GroupLayout pl_verticalSeperateLineLayout = new javax.swing.GroupLayout(pl_verticalSeperateLine);
        pl_verticalSeperateLine.setLayout(pl_verticalSeperateLineLayout);
        pl_verticalSeperateLineLayout.setHorizontalGroup(
            pl_verticalSeperateLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );
        pl_verticalSeperateLineLayout.setVerticalGroup(
            pl_verticalSeperateLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        t_viewStudentData.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 155, 255), 2, true));
        t_viewStudentData.setFont(new java.awt.Font("Cairo", 1, 11)); // NOI18N
        t_viewStudentData.setRowHeight(30);
        sp_studentData.setViewportView(t_viewStudentData);

        lb_star16.setBackground(new java.awt.Color(255, 255, 255));
        lb_star16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_star16.setForeground(new java.awt.Color(255, 0, 0));
        lb_star16.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_star16.setText("*");

        lb_star12.setBackground(new java.awt.Color(255, 255, 255));
        lb_star12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_star12.setForeground(new java.awt.Color(255, 0, 0));
        lb_star12.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_star12.setText("*");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.GridLayout(2, 0, 0, 20));

        cb_level2.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        cb_level2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "اختر الفرقة" }));
        cb_level2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 155, 255), 2, true));
        cb_level2.setPreferredSize(new java.awt.Dimension(180, 33));
        cb_level2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cb_level2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cb_level2FocusLost(evt);
            }
        });
        jPanel1.add(cb_level2);

        cb_month1.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        cb_month1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "اختر الشهر", "يناير", "فبراير", "مارس", "ابريل", "مايو", "يونيو", "يوليو", "اغسطس", "سبتمبر", "اكتوبر", "نوفمبر", "ديسمبر" }));
        cb_month1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 155, 255), 2, true));
        cb_month1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cb_month1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cb_month1FocusLost(evt);
            }
        });
        jPanel1.add(cb_month1);

        lb_didNotPayNumber.setBackground(new java.awt.Color(255, 255, 255));
        lb_didNotPayNumber.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_didNotPayNumber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_didNotPayNumber.setText("0");

        lb_number2.setBackground(new java.awt.Color(255, 255, 255));
        lb_number2.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_number2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_number2.setText("عدد المتخلفين عن الدفع");

        btn_printInternalMoney2.setBackground(new java.awt.Color(0, 155, 255));
        btn_printInternalMoney2.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        btn_printInternalMoney2.setForeground(new java.awt.Color(255, 255, 255));
        btn_printInternalMoney2.setText("طباعة");
        btn_printInternalMoney2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_printInternalMoney2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pl_didNotPayYetLayout = new javax.swing.GroupLayout(pl_didNotPayYet);
        pl_didNotPayYet.setLayout(pl_didNotPayYetLayout);
        pl_didNotPayYetLayout.setHorizontalGroup(
            pl_didNotPayYetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pl_didNotPayYetLayout.createSequentialGroup()
                .addGroup(pl_didNotPayYetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pl_didNotPayYetLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lb_didNotPayNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(lb_number2))
                    .addGroup(pl_didNotPayYetLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(pl_didNotPayYetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pl_didNotPayYetLayout.createSequentialGroup()
                                .addComponent(btn_printInternalMoney2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(sp_studentData, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE))))
                .addGap(40, 40, 40)
                .addComponent(pl_verticalSeperateLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pl_didNotPayYetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pl_didNotPayYetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pl_didNotPayYetLayout.createSequentialGroup()
                            .addGroup(pl_didNotPayYetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(pl_seperateLine, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(pl_didNotPayYetLayout.createSequentialGroup()
                                    .addComponent(pl_parents, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(pl_checkBoxForParent, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(28, 28, 28)
                                    .addComponent(pl_student, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(pl_checkBoxForStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(49, 49, 49))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pl_didNotPayYetLayout.createSequentialGroup()
                            .addComponent(lb_classification, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap()))
                    .addGroup(pl_didNotPayYetLayout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(pl_didNotPayYetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_star12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_star16, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pl_didNotPayYetLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_search2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(106, 106, 106))))
        );
        pl_didNotPayYetLayout.setVerticalGroup(
            pl_didNotPayYetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pl_didNotPayYetLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(pl_didNotPayYetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pl_didNotPayYetLayout.createSequentialGroup()
                        .addGroup(pl_didNotPayYetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pl_didNotPayYetLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(pl_didNotPayYetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pl_didNotPayYetLayout.createSequentialGroup()
                                        .addComponent(lb_star16)
                                        .addGap(30, 30, 30)
                                        .addComponent(lb_star12, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lb_classification, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pl_didNotPayYetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pl_didNotPayYetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(pl_checkBoxForParent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(pl_parents, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(pl_didNotPayYetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(pl_student, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(pl_checkBoxForStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, 0)
                                .addComponent(pl_seperateLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(btn_search2))
                            .addComponent(pl_verticalSeperateLine, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pl_didNotPayYetLayout.createSequentialGroup()
                        .addGroup(pl_didNotPayYetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_didNotPayNumber)
                            .addComponent(lb_number2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sp_studentData, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_printInternalMoney2)
                        .addContainerGap())))
        );

        moneyManagement.add(pl_didNotPayYet, "card4");

        pl_externalMoney.setBackground(new java.awt.Color(255, 255, 255));

        pl_verticalSeperateLine1.setBackground(new java.awt.Color(153, 153, 153));
        pl_verticalSeperateLine1.setPreferredSize(new java.awt.Dimension(2, 500));

        javax.swing.GroupLayout pl_verticalSeperateLine1Layout = new javax.swing.GroupLayout(pl_verticalSeperateLine1);
        pl_verticalSeperateLine1.setLayout(pl_verticalSeperateLine1Layout);
        pl_verticalSeperateLine1Layout.setHorizontalGroup(
            pl_verticalSeperateLine1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );
        pl_verticalSeperateLine1Layout.setVerticalGroup(
            pl_verticalSeperateLine1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        t_externalMoney.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 155, 255), 2, true));
        t_externalMoney.setFont(new java.awt.Font("Cairo", 1, 11)); // NOI18N
        t_externalMoney.setRowHeight(30);
        t_externalMoney.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_externalMoneyMouseClicked(evt);
            }
        });
        sp_externalMoney.setViewportView(t_externalMoney);

        lb_star17.setBackground(new java.awt.Color(255, 255, 255));
        lb_star17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_star17.setForeground(new java.awt.Color(255, 0, 0));
        lb_star17.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_star17.setText("*");

        lb_star14.setBackground(new java.awt.Color(255, 255, 255));
        lb_star14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_star14.setForeground(new java.awt.Color(255, 0, 0));
        lb_star14.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_star14.setText("*");

        pl_externalMoneyData.setBackground(new java.awt.Color(255, 255, 255));
        pl_externalMoneyData.setLayout(new java.awt.GridLayout(4, 0, 10, 20));

        cb_month2.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        cb_month2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "اختر الشهر", "يناير", "فبراير", "مارس", "ابريل", "مايو", "يونيو", "يوليو", "اغسطس", "سبتمبر", "اكتوبر", "نوفمبر", "ديسمبر" }));
        cb_month2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 155, 255), 1, true));
        cb_month2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_month2ItemStateChanged(evt);
            }
        });
        cb_month2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cb_month2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cb_month2FocusLost(evt);
            }
        });
        pl_externalMoneyData.add(cb_month2);

        lb_month1.setBackground(new java.awt.Color(255, 255, 255));
        lb_month1.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_month1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_month1.setText("اسم الشهر");
        pl_externalMoneyData.add(lb_month1);

        tf_person.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        tf_person.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_person.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 155, 255), 2, true));
        tf_person.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_personFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tf_personFocusLost(evt);
            }
        });
        tf_person.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_personKeyPressed(evt);
            }
        });
        pl_externalMoneyData.add(tf_person);

        lb_person.setBackground(new java.awt.Color(255, 255, 255));
        lb_person.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_person.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_person.setText("الشخص المدفوع له");
        pl_externalMoneyData.add(lb_person);

        tf_reason.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        tf_reason.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_reason.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 155, 255), 2, true));
        tf_reason.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_reasonFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tf_reasonFocusLost(evt);
            }
        });
        tf_reason.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_reasonKeyPressed(evt);
            }
        });
        pl_externalMoneyData.add(tf_reason);

        lb_reason.setBackground(new java.awt.Color(255, 255, 255));
        lb_reason.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_reason.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_reason.setText("سبب الدفع");
        pl_externalMoneyData.add(lb_reason);

        tf_amount.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        tf_amount.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_amount.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 155, 255), 2, true));
        tf_amount.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_amountFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tf_amountFocusLost(evt);
            }
        });
        tf_amount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_amountKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_amountKeyTyped(evt);
            }
        });
        pl_externalMoneyData.add(tf_amount);

        lb_amount.setBackground(new java.awt.Color(255, 255, 255));
        lb_amount.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_amount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_amount.setText("المبلغ المدفوع");
        pl_externalMoneyData.add(lb_amount);

        lb_star18.setBackground(new java.awt.Color(255, 255, 255));
        lb_star18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_star18.setForeground(new java.awt.Color(255, 0, 0));
        lb_star18.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_star18.setText("*");

        lb_star19.setBackground(new java.awt.Color(255, 255, 255));
        lb_star19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_star19.setForeground(new java.awt.Color(255, 0, 0));
        lb_star19.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_star19.setText("*");

        btn_add2.setBackground(new java.awt.Color(0, 155, 255));
        btn_add2.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        btn_add2.setForeground(new java.awt.Color(255, 255, 255));
        btn_add2.setText("اضافة");
        btn_add2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_add2ActionPerformed(evt);
            }
        });

        btn_delete2.setBackground(new java.awt.Color(153, 0, 0));
        btn_delete2.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        btn_delete2.setForeground(new java.awt.Color(255, 255, 255));
        btn_delete2.setText("حذف");
        btn_delete2.setEnabled(false);
        btn_delete2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delete2ActionPerformed(evt);
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

        javax.swing.GroupLayout pl_externalMoneyLayout = new javax.swing.GroupLayout(pl_externalMoney);
        pl_externalMoney.setLayout(pl_externalMoneyLayout);
        pl_externalMoneyLayout.setHorizontalGroup(
            pl_externalMoneyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pl_externalMoneyLayout.createSequentialGroup()
                .addGroup(pl_externalMoneyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pl_externalMoneyLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(sp_externalMoney, javax.swing.GroupLayout.DEFAULT_SIZE, 758, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addGroup(pl_externalMoneyLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(btn_delete2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(pl_verticalSeperateLine1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pl_externalMoneyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pl_externalMoneyLayout.createSequentialGroup()
                        .addGroup(pl_externalMoneyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lb_star14, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_star17, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_star18)
                            .addComponent(lb_star19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pl_externalMoneyData, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pl_externalMoneyLayout.createSequentialGroup()
                        .addComponent(btn_clean2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_add2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))))
        );
        pl_externalMoneyLayout.setVerticalGroup(
            pl_externalMoneyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pl_externalMoneyLayout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(pl_externalMoneyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pl_externalMoneyLayout.createSequentialGroup()
                        .addGroup(pl_externalMoneyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pl_externalMoneyData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pl_externalMoneyLayout.createSequentialGroup()
                                .addComponent(lb_star14)
                                .addGap(41, 41, 41)
                                .addComponent(lb_star17)
                                .addGap(33, 33, 33)
                                .addComponent(lb_star18)
                                .addGap(39, 39, 39)
                                .addComponent(lb_star19)))
                        .addGap(39, 39, 39)
                        .addGroup(pl_externalMoneyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_add2)
                            .addComponent(btn_clean2)))
                    .addGroup(pl_externalMoneyLayout.createSequentialGroup()
                        .addComponent(sp_externalMoney, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(btn_delete2))
                    .addComponent(pl_verticalSeperateLine1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        moneyManagement.add(pl_externalMoney, "card4");

        pl_dailyReport.setBackground(new java.awt.Color(255, 255, 255));

        btn_search3.setBackground(new java.awt.Color(19, 64, 93));
        btn_search3.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        btn_search3.setForeground(new java.awt.Color(255, 255, 255));
        btn_search3.setText("بحث");
        btn_search3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_search3ActionPerformed(evt);
            }
        });

        lb_classification1.setBackground(new java.awt.Color(255, 255, 255));
        lb_classification1.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_classification1.setForeground(new java.awt.Color(19, 64, 93));
        lb_classification1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_classification1.setText("التصنيفات:");

        pl_checkBoxForParent1.setBackground(new java.awt.Color(255, 255, 255));
        pl_checkBoxForParent1.setLayout(new java.awt.GridLayout(3, 3, 0, 10));

        chb_monthCost.setBackground(new java.awt.Color(255, 255, 255));
        chb_monthCost.setSelected(true);
        pl_checkBoxForParent1.add(chb_monthCost);

        chb_monthRest.setBackground(new java.awt.Color(255, 255, 255));
        chb_monthRest.setSelected(true);
        pl_checkBoxForParent1.add(chb_monthRest);

        chb_day.setBackground(new java.awt.Color(255, 255, 255));
        chb_day.setSelected(true);
        pl_checkBoxForParent1.add(chb_day);

        pl_parents1.setBackground(new java.awt.Color(255, 255, 255));
        pl_parents1.setLayout(new java.awt.GridLayout(3, 3, 0, 10));

        lb_parentName3.setBackground(new java.awt.Color(255, 255, 255));
        lb_parentName3.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_parentName3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_parentName3.setText("المبلغ المدفوع");
        pl_parents1.add(lb_parentName3);

        lb_parentPhone3.setBackground(new java.awt.Color(255, 255, 255));
        lb_parentPhone3.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_parentPhone3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_parentPhone3.setText("باقي الشهر");
        pl_parents1.add(lb_parentPhone3);

        lb_parentPhone5.setBackground(new java.awt.Color(255, 255, 255));
        lb_parentPhone5.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_parentPhone5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_parentPhone5.setText("التاريخ");
        pl_parents1.add(lb_parentPhone5);

        pl_student1.setBackground(new java.awt.Color(255, 255, 255));
        pl_student1.setLayout(new java.awt.GridLayout(2, 3, 0, 10));

        lb_name.setBackground(new java.awt.Color(255, 255, 255));
        lb_name.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_name.setText("اسم الطالب");
        pl_student1.add(lb_name);

        lb_studentPhone7.setBackground(new java.awt.Color(255, 255, 255));
        lb_studentPhone7.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_studentPhone7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_studentPhone7.setText("الفرقة");
        pl_student1.add(lb_studentPhone7);

        pl_seperateLine1.setBackground(new java.awt.Color(153, 153, 153));
        pl_seperateLine1.setPreferredSize(new java.awt.Dimension(300, 2));

        javax.swing.GroupLayout pl_seperateLine1Layout = new javax.swing.GroupLayout(pl_seperateLine1);
        pl_seperateLine1.setLayout(pl_seperateLine1Layout);
        pl_seperateLine1Layout.setHorizontalGroup(
            pl_seperateLine1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 295, Short.MAX_VALUE)
        );
        pl_seperateLine1Layout.setVerticalGroup(
            pl_seperateLine1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        pl_checkBoxForStudent1.setBackground(new java.awt.Color(255, 255, 255));
        pl_checkBoxForStudent1.setLayout(new java.awt.GridLayout(2, 3, 0, 10));

        chb_name.setBackground(new java.awt.Color(255, 255, 255));
        chb_name.setSelected(true);
        pl_checkBoxForStudent1.add(chb_name);

        chb_Level.setBackground(new java.awt.Color(255, 255, 255));
        chb_Level.setSelected(true);
        chb_Level.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chb_LevelActionPerformed(evt);
            }
        });
        pl_checkBoxForStudent1.add(chb_Level);

        pl_verticalSeperateLine2.setBackground(new java.awt.Color(153, 153, 153));
        pl_verticalSeperateLine2.setPreferredSize(new java.awt.Dimension(2, 500));

        javax.swing.GroupLayout pl_verticalSeperateLine2Layout = new javax.swing.GroupLayout(pl_verticalSeperateLine2);
        pl_verticalSeperateLine2.setLayout(pl_verticalSeperateLine2Layout);
        pl_verticalSeperateLine2Layout.setHorizontalGroup(
            pl_verticalSeperateLine2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );
        pl_verticalSeperateLine2Layout.setVerticalGroup(
            pl_verticalSeperateLine2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        lb_star20.setBackground(new java.awt.Color(255, 255, 255));
        lb_star20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_star20.setForeground(new java.awt.Color(255, 0, 0));
        lb_star20.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_star20.setText("*");

        code.setBackground(new java.awt.Color(255, 255, 255));
        code.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        code.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        code.setText("الكود");

        chb_code.setBackground(new java.awt.Color(255, 255, 255));
        chb_code.setSelected(true);

        pl_monthCostData2.setBackground(new java.awt.Color(255, 255, 255));
        pl_monthCostData2.setLayout(new java.awt.GridLayout(1, 0, 10, 10));

        tf_totalAvilable.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        tf_totalAvilable.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_totalAvilable.setText("0");
        tf_totalAvilable.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 155, 255), 2, true));
        pl_monthCostData2.add(tf_totalAvilable);

        lb_total2.setBackground(new java.awt.Color(255, 255, 255));
        lb_total2.setFont(new java.awt.Font("Cairo", 1, 16)); // NOI18N
        lb_total2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_total2.setText("المبلغ الحالي");
        pl_monthCostData2.add(lb_total2);

        tf_totalOutcome.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        tf_totalOutcome.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_totalOutcome.setText("0");
        tf_totalOutcome.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 155, 255), 2, true));
        pl_monthCostData2.add(tf_totalOutcome);

        lb_discount2.setBackground(new java.awt.Color(255, 255, 255));
        lb_discount2.setFont(new java.awt.Font("Cairo", 1, 16)); // NOI18N
        lb_discount2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_discount2.setText("مجموع الخارجة");
        pl_monthCostData2.add(lb_discount2);

        tf_totalIncome.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        tf_totalIncome.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_totalIncome.setText("0");
        tf_totalIncome.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 155, 255), 2, true));
        pl_monthCostData2.add(tf_totalIncome);

        lb_paid2.setBackground(new java.awt.Color(255, 255, 255));
        lb_paid2.setFont(new java.awt.Font("Cairo", 1, 16)); // NOI18N
        lb_paid2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_paid2.setText("مجموع الورادة");
        pl_monthCostData2.add(lb_paid2);

        tf_BookIncome.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        tf_BookIncome.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_BookIncome.setText("0");
        tf_BookIncome.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 155, 255), 2, true));
        pl_monthCostData2.add(tf_BookIncome);

        lb_paid3.setBackground(new java.awt.Color(255, 255, 255));
        lb_paid3.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_paid3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_paid3.setText("المذكرات");
        pl_monthCostData2.add(lb_paid3);

        dc_day.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 155, 255), 2, true));
        dc_day.setDateFormatString("yyyy-MM-dd");
        dc_day.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        dc_day.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                dc_dayFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                dc_dayFocusLost(evt);
            }
        });

        lb_name1.setBackground(new java.awt.Color(255, 255, 255));
        lb_name1.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_name1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_name1.setText("اختر اليوم");

        pl_parents2.setBackground(new java.awt.Color(255, 255, 255));
        pl_parents2.setLayout(new java.awt.GridLayout(3, 3, 0, 10));

        lb_parentJob3.setBackground(new java.awt.Color(255, 255, 255));
        lb_parentJob3.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_parentJob3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_parentJob3.setText("الخصم");
        pl_parents2.add(lb_parentJob3);

        lb_parentName4.setBackground(new java.awt.Color(255, 255, 255));
        lb_parentName4.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_parentName4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_parentName4.setText("اسم الشهر");
        pl_parents2.add(lb_parentName4);

        lb_parentPhone4.setBackground(new java.awt.Color(255, 255, 255));
        lb_parentPhone4.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_parentPhone4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_parentPhone4.setText("الوقت");
        pl_parents2.add(lb_parentPhone4);

        pl_checkBoxForParent2.setBackground(new java.awt.Color(255, 255, 255));
        pl_checkBoxForParent2.setLayout(new java.awt.GridLayout(3, 3, 0, 10));

        chb_monthDiscount.setBackground(new java.awt.Color(255, 255, 255));
        chb_monthDiscount.setSelected(true);
        pl_checkBoxForParent2.add(chb_monthDiscount);

        chb_monthName.setBackground(new java.awt.Color(255, 255, 255));
        chb_monthName.setSelected(true);
        pl_checkBoxForParent2.add(chb_monthName);

        chb_time.setBackground(new java.awt.Color(255, 255, 255));
        chb_time.setSelected(true);
        pl_checkBoxForParent2.add(chb_time);

        pl_holdALlMoney.setBackground(new java.awt.Color(255, 255, 255));

        lb_internalMoney.setBackground(new java.awt.Color(255, 255, 255));
        lb_internalMoney.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_internalMoney.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_internalMoney.setText(" المصاريف الوارده من المصاريف الشهرية");

        t_InternalMoney.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 155, 255), 2, true));
        t_InternalMoney.setFont(new java.awt.Font("Cairo", 1, 11)); // NOI18N
        t_InternalMoney.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        t_InternalMoney.setRowHeight(30);
        sp_InternalMoney.setViewportView(t_InternalMoney);

        btn_printInternalMoney.setBackground(new java.awt.Color(0, 155, 255));
        btn_printInternalMoney.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        btn_printInternalMoney.setForeground(new java.awt.Color(255, 255, 255));
        btn_printInternalMoney.setText("طباعة");
        btn_printInternalMoney.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_printInternalMoneyActionPerformed(evt);
            }
        });

        lb_bookMoney.setBackground(new java.awt.Color(255, 255, 255));
        lb_bookMoney.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_bookMoney.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_bookMoney.setText(" المصاريف الوارده من المذكرات");

        t_BookMoney.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 155, 255), 2, true));
        t_BookMoney.setFont(new java.awt.Font("Cairo", 1, 11)); // NOI18N
        t_BookMoney.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        t_BookMoney.setRowHeight(30);
        sp_BookMoney.setViewportView(t_BookMoney);

        btn_printBookMoney.setBackground(new java.awt.Color(0, 155, 255));
        btn_printBookMoney.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        btn_printBookMoney.setForeground(new java.awt.Color(255, 255, 255));
        btn_printBookMoney.setText("طباعة");
        btn_printBookMoney.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_printBookMoneyActionPerformed(evt);
            }
        });

        lb_externalMoney.setBackground(new java.awt.Color(255, 255, 255));
        lb_externalMoney.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_externalMoney.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_externalMoney.setText("جدول المصاريف الخارجة");

        t_externalMoneyData.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 155, 255), 2, true));
        t_externalMoneyData.setFont(new java.awt.Font("Cairo", 1, 11)); // NOI18N
        t_externalMoneyData.setRowHeight(30);
        sp_externalMoneyData.setViewportView(t_externalMoneyData);

        btn_printExternalMoney.setBackground(new java.awt.Color(0, 155, 255));
        btn_printExternalMoney.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        btn_printExternalMoney.setForeground(new java.awt.Color(255, 255, 255));
        btn_printExternalMoney.setText("طباعة");
        btn_printExternalMoney.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_printExternalMoneyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pl_holdALlMoneyLayout = new javax.swing.GroupLayout(pl_holdALlMoney);
        pl_holdALlMoney.setLayout(pl_holdALlMoneyLayout);
        pl_holdALlMoneyLayout.setHorizontalGroup(
            pl_holdALlMoneyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pl_holdALlMoneyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pl_holdALlMoneyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sp_BookMoney)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pl_holdALlMoneyLayout.createSequentialGroup()
                        .addComponent(btn_printInternalMoney)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lb_bookMoney))
                    .addGroup(pl_holdALlMoneyLayout.createSequentialGroup()
                        .addComponent(btn_printBookMoney)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lb_externalMoney))
                    .addComponent(sp_externalMoneyData)
                    .addGroup(pl_holdALlMoneyLayout.createSequentialGroup()
                        .addComponent(btn_printExternalMoney)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pl_holdALlMoneyLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lb_internalMoney))
                    .addComponent(sp_InternalMoney)))
        );
        pl_holdALlMoneyLayout.setVerticalGroup(
            pl_holdALlMoneyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pl_holdALlMoneyLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(lb_internalMoney)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sp_InternalMoney, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addGroup(pl_holdALlMoneyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_printInternalMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_bookMoney))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sp_BookMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(pl_holdALlMoneyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_printBookMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_externalMoney))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sp_externalMoneyData, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(btn_printExternalMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout pl_dailyReportLayout = new javax.swing.GroupLayout(pl_dailyReport);
        pl_dailyReport.setLayout(pl_dailyReportLayout);
        pl_dailyReportLayout.setHorizontalGroup(
            pl_dailyReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pl_dailyReportLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(pl_dailyReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pl_monthCostData2, javax.swing.GroupLayout.PREFERRED_SIZE, 856, Short.MAX_VALUE)
                    .addGroup(pl_dailyReportLayout.createSequentialGroup()
                        .addComponent(pl_holdALlMoney, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(8, 8, 8)))
                .addGroup(pl_dailyReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pl_dailyReportLayout.createSequentialGroup()
                        .addComponent(lb_name1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65))
                    .addGroup(pl_dailyReportLayout.createSequentialGroup()
                        .addComponent(pl_verticalSeperateLine2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pl_dailyReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pl_dailyReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pl_dailyReportLayout.createSequentialGroup()
                                    .addComponent(code, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(chb_code, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(6, 6, 6)
                                    .addComponent(pl_student1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, 0)
                                    .addComponent(pl_checkBoxForStudent1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pl_dailyReportLayout.createSequentialGroup()
                                    .addComponent(pl_parents2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, 0)
                                    .addComponent(pl_checkBoxForParent2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(pl_parents1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, 0)
                                    .addComponent(pl_checkBoxForParent1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(pl_seperateLine1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pl_dailyReportLayout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(lb_star20, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pl_dailyReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pl_dailyReportLayout.createSequentialGroup()
                                        .addComponent(lb_classification1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap())
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pl_dailyReportLayout.createSequentialGroup()
                                        .addComponent(dc_day, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(35, 35, 35))))
                            .addGroup(pl_dailyReportLayout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(btn_search3, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))))))
        );
        pl_dailyReportLayout.setVerticalGroup(
            pl_dailyReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pl_dailyReportLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(pl_dailyReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pl_dailyReportLayout.createSequentialGroup()
                        .addComponent(pl_monthCostData2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addGroup(pl_dailyReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pl_verticalSeperateLine2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pl_dailyReportLayout.createSequentialGroup()
                                .addComponent(pl_holdALlMoney, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(13, 13, 13))))
                    .addGroup(pl_dailyReportLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(lb_name1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pl_dailyReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lb_star20)
                            .addComponent(dc_day, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(lb_classification1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pl_dailyReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pl_student1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pl_dailyReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(chb_code, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(code))
                            .addComponent(pl_checkBoxForStudent1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pl_seperateLine1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addGroup(pl_dailyReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pl_parents2, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                            .addComponent(pl_checkBoxForParent2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pl_checkBoxForParent1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pl_parents1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(52, 52, 52)
                        .addComponent(btn_search3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        moneyManagement.add(pl_dailyReport, "card4");

        pl_paied.setBackground(new java.awt.Color(255, 255, 255));

        btn_search5.setBackground(new java.awt.Color(19, 64, 93));
        btn_search5.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        btn_search5.setForeground(new java.awt.Color(255, 255, 255));
        btn_search5.setText("بحث");
        btn_search5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_search5ActionPerformed(evt);
            }
        });

        lb_classification3.setBackground(new java.awt.Color(255, 255, 255));
        lb_classification3.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_classification3.setForeground(new java.awt.Color(19, 64, 93));
        lb_classification3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_classification3.setText("التصنيفات:");

        pl_checkBoxForParent5.setBackground(new java.awt.Color(255, 255, 255));
        pl_checkBoxForParent5.setLayout(new java.awt.GridLayout(3, 3, 0, 10));

        chb_parentName1.setBackground(new java.awt.Color(255, 255, 255));
        chb_parentName1.setSelected(true);
        pl_checkBoxForParent5.add(chb_parentName1);

        chb_parentPhone1.setBackground(new java.awt.Color(255, 255, 255));
        chb_parentPhone1.setSelected(true);
        pl_checkBoxForParent5.add(chb_parentPhone1);

        chb_parentJob1.setBackground(new java.awt.Color(255, 255, 255));
        chb_parentJob1.setSelected(true);
        pl_checkBoxForParent5.add(chb_parentJob1);

        pl_parents5.setBackground(new java.awt.Color(255, 255, 255));
        pl_parents5.setLayout(new java.awt.GridLayout(3, 3, 0, 10));

        lb_parentName7.setBackground(new java.awt.Color(255, 255, 255));
        lb_parentName7.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_parentName7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_parentName7.setText("اسم ولي الامر");
        pl_parents5.add(lb_parentName7);

        lb_parentPhone9.setBackground(new java.awt.Color(255, 255, 255));
        lb_parentPhone9.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_parentPhone9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_parentPhone9.setText("هاتف ولي الامر");
        pl_parents5.add(lb_parentPhone9);

        lb_parentJob5.setBackground(new java.awt.Color(255, 255, 255));
        lb_parentJob5.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_parentJob5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_parentJob5.setText("وظيفة ولي الامر");
        pl_parents5.add(lb_parentJob5);

        pl_student3.setBackground(new java.awt.Color(255, 255, 255));
        pl_student3.setLayout(new java.awt.GridLayout(5, 3, 0, 10));

        lb_studentName6.setBackground(new java.awt.Color(255, 255, 255));
        lb_studentName6.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_studentName6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_studentName6.setText("اسم الطالب");
        pl_student3.add(lb_studentName6);

        lb_studentPhone6.setBackground(new java.awt.Color(255, 255, 255));
        lb_studentPhone6.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_studentPhone6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_studentPhone6.setText("هاتف الطالب");
        pl_student3.add(lb_studentPhone6);

        lb_address6.setBackground(new java.awt.Color(255, 255, 255));
        lb_address6.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_address6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_address6.setText("العنوان");
        pl_student3.add(lb_address6);

        lb_level2.setBackground(new java.awt.Color(255, 255, 255));
        lb_level2.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_level2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_level2.setText("الفرقة");
        pl_student3.add(lb_level2);

        pl_checkBoxForStudent3.setBackground(new java.awt.Color(255, 255, 255));
        pl_checkBoxForStudent3.setLayout(new java.awt.GridLayout(5, 3, 0, 10));

        chb_studentName1.setBackground(new java.awt.Color(255, 255, 255));
        chb_studentName1.setSelected(true);
        pl_checkBoxForStudent3.add(chb_studentName1);

        chb_studentPhone1.setBackground(new java.awt.Color(255, 255, 255));
        chb_studentPhone1.setSelected(true);
        pl_checkBoxForStudent3.add(chb_studentPhone1);

        chb_address1.setBackground(new java.awt.Color(255, 255, 255));
        chb_address1.setSelected(true);
        pl_checkBoxForStudent3.add(chb_address1);

        chb_level1.setBackground(new java.awt.Color(255, 255, 255));
        chb_level1.setSelected(true);
        pl_checkBoxForStudent3.add(chb_level1);

        pl_verticalSeperateLine3.setBackground(new java.awt.Color(153, 153, 153));
        pl_verticalSeperateLine3.setPreferredSize(new java.awt.Dimension(2, 500));

        javax.swing.GroupLayout pl_verticalSeperateLine3Layout = new javax.swing.GroupLayout(pl_verticalSeperateLine3);
        pl_verticalSeperateLine3.setLayout(pl_verticalSeperateLine3Layout);
        pl_verticalSeperateLine3Layout.setHorizontalGroup(
            pl_verticalSeperateLine3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );
        pl_verticalSeperateLine3Layout.setVerticalGroup(
            pl_verticalSeperateLine3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 506, Short.MAX_VALUE)
        );

        t_viewStudentData1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 155, 255), 2, true));
        t_viewStudentData1.setFont(new java.awt.Font("Cairo", 1, 11)); // NOI18N
        t_viewStudentData1.setRowHeight(30);
        sp_studentData1.setViewportView(t_viewStudentData1);

        lb_star21.setBackground(new java.awt.Color(255, 255, 255));
        lb_star21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_star21.setForeground(new java.awt.Color(255, 0, 0));
        lb_star21.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_star21.setText("*");

        lb_star22.setBackground(new java.awt.Color(255, 255, 255));
        lb_star22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_star22.setForeground(new java.awt.Color(255, 0, 0));
        lb_star22.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_star22.setText("*");

        pl_level_month.setBackground(new java.awt.Color(255, 255, 255));
        pl_level_month.setLayout(new java.awt.GridLayout(2, 0, 0, 20));

        cb_level3.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        cb_level3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "اختر الفرقة" }));
        cb_level3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 155, 255), 2, true));
        cb_level3.setPreferredSize(new java.awt.Dimension(180, 33));
        cb_level3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cb_level3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cb_level3FocusLost(evt);
            }
        });
        pl_level_month.add(cb_level3);

        cb_month3.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        cb_month3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "اختر الشهر", "يناير", "فبراير", "مارس", "ابريل", "مايو", "يونيو", "يوليو", "اغسطس", "سبتمبر", "اكتوبر", "نوفمبر", "ديسمبر" }));
        cb_month3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 155, 255), 2, true));
        cb_month3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cb_month3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cb_month3FocusLost(evt);
            }
        });
        pl_level_month.add(cb_month3);

        lb_number1.setBackground(new java.awt.Color(255, 255, 255));
        lb_number1.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_number1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_number1.setText("عدد الدافعين");

        lb_payNumber.setBackground(new java.awt.Color(255, 255, 255));
        lb_payNumber.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_payNumber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_payNumber.setText("0");

        btn_printInternalMoney1.setBackground(new java.awt.Color(0, 155, 255));
        btn_printInternalMoney1.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        btn_printInternalMoney1.setForeground(new java.awt.Color(255, 255, 255));
        btn_printInternalMoney1.setText("طباعة");
        btn_printInternalMoney1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_printInternalMoney1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pl_paiedLayout = new javax.swing.GroupLayout(pl_paied);
        pl_paied.setLayout(pl_paiedLayout);
        pl_paiedLayout.setHorizontalGroup(
            pl_paiedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pl_paiedLayout.createSequentialGroup()
                .addGroup(pl_paiedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pl_paiedLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lb_payNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(lb_number1))
                    .addGroup(pl_paiedLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(pl_paiedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pl_paiedLayout.createSequentialGroup()
                                .addComponent(btn_printInternalMoney1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(sp_studentData1, javax.swing.GroupLayout.DEFAULT_SIZE, 759, Short.MAX_VALUE))))
                .addGap(40, 40, 40)
                .addComponent(pl_verticalSeperateLine3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pl_paiedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pl_paiedLayout.createSequentialGroup()
                        .addGroup(pl_paiedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pl_paiedLayout.createSequentialGroup()
                                .addComponent(pl_parents5, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pl_checkBoxForParent5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(pl_student3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pl_checkBoxForStudent3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lb_classification3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pl_paiedLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pl_paiedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pl_paiedLayout.createSequentialGroup()
                                .addComponent(btn_search5, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(106, 106, 106))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pl_paiedLayout.createSequentialGroup()
                                .addGroup(pl_paiedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lb_star22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lb_star21, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, 0)
                                .addComponent(pl_level_month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59))))))
        );
        pl_paiedLayout.setVerticalGroup(
            pl_paiedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pl_paiedLayout.createSequentialGroup()
                .addGroup(pl_paiedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pl_paiedLayout.createSequentialGroup()
                        .addGroup(pl_paiedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_payNumber)
                            .addComponent(lb_number1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sp_studentData1, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pl_paiedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(pl_verticalSeperateLine3, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
                        .addGroup(pl_paiedLayout.createSequentialGroup()
                            .addGap(24, 24, 24)
                            .addGroup(pl_paiedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pl_paiedLayout.createSequentialGroup()
                                    .addComponent(lb_star21)
                                    .addGap(30, 30, 30)
                                    .addComponent(lb_star22, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(pl_level_month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_classification3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(pl_paiedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pl_paiedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(pl_checkBoxForParent5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(pl_parents5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(pl_paiedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(pl_student3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(pl_checkBoxForStudent3, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(31, 31, 31)
                            .addComponent(btn_search5))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_printInternalMoney1)
                .addContainerGap())
        );

        moneyManagement.add(pl_paied, "card4");

        pl_didNotPayYetBook.setBackground(new java.awt.Color(255, 255, 255));

        btn_search4.setBackground(new java.awt.Color(19, 64, 93));
        btn_search4.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        btn_search4.setForeground(new java.awt.Color(255, 255, 255));
        btn_search4.setText("بحث");
        btn_search4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_search4ActionPerformed(evt);
            }
        });

        lb_classification2.setBackground(new java.awt.Color(255, 255, 255));
        lb_classification2.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_classification2.setForeground(new java.awt.Color(19, 64, 93));
        lb_classification2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_classification2.setText("التصنيفات:");

        pl_checkBoxForParent3.setBackground(new java.awt.Color(255, 255, 255));
        pl_checkBoxForParent3.setLayout(new java.awt.GridLayout(3, 3, 0, 10));

        chb_parentName3.setBackground(new java.awt.Color(255, 255, 255));
        chb_parentName3.setSelected(true);
        pl_checkBoxForParent3.add(chb_parentName3);

        chb_parentPhone3.setBackground(new java.awt.Color(255, 255, 255));
        chb_parentPhone3.setSelected(true);
        pl_checkBoxForParent3.add(chb_parentPhone3);

        chb_parentJob3.setBackground(new java.awt.Color(255, 255, 255));
        chb_parentJob3.setSelected(true);
        pl_checkBoxForParent3.add(chb_parentJob3);

        pl_parents3.setBackground(new java.awt.Color(255, 255, 255));
        pl_parents3.setLayout(new java.awt.GridLayout(3, 3, 0, 10));

        lb_parentName5.setBackground(new java.awt.Color(255, 255, 255));
        lb_parentName5.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_parentName5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_parentName5.setText("اسم ولي الامر");
        pl_parents3.add(lb_parentName5);

        lb_parentPhone6.setBackground(new java.awt.Color(255, 255, 255));
        lb_parentPhone6.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_parentPhone6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_parentPhone6.setText("هاتف ولي الامر");
        pl_parents3.add(lb_parentPhone6);

        lb_parentJob4.setBackground(new java.awt.Color(255, 255, 255));
        lb_parentJob4.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_parentJob4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_parentJob4.setText("وظيفة ولي الامر");
        pl_parents3.add(lb_parentJob4);

        pl_student2.setBackground(new java.awt.Color(255, 255, 255));
        pl_student2.setLayout(new java.awt.GridLayout(5, 3, 0, 10));

        lb_studentName8.setBackground(new java.awt.Color(255, 255, 255));
        lb_studentName8.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_studentName8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_studentName8.setText("اسم الطالب");
        pl_student2.add(lb_studentName8);

        lb_studentPhone9.setBackground(new java.awt.Color(255, 255, 255));
        lb_studentPhone9.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_studentPhone9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_studentPhone9.setText("هاتف الطالب");
        pl_student2.add(lb_studentPhone9);

        lb_address8.setBackground(new java.awt.Color(255, 255, 255));
        lb_address8.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_address8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_address8.setText("العنوان");
        pl_student2.add(lb_address8);

        lb_level4.setBackground(new java.awt.Color(255, 255, 255));
        lb_level4.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_level4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_level4.setText("الفرقة");
        pl_student2.add(lb_level4);

        pl_checkBoxForStudent2.setBackground(new java.awt.Color(255, 255, 255));
        pl_checkBoxForStudent2.setLayout(new java.awt.GridLayout(5, 3, 0, 10));

        chb_studentName3.setBackground(new java.awt.Color(255, 255, 255));
        chb_studentName3.setSelected(true);
        pl_checkBoxForStudent2.add(chb_studentName3);

        chb_studentPhone3.setBackground(new java.awt.Color(255, 255, 255));
        chb_studentPhone3.setSelected(true);
        pl_checkBoxForStudent2.add(chb_studentPhone3);

        chb_address3.setBackground(new java.awt.Color(255, 255, 255));
        chb_address3.setSelected(true);
        pl_checkBoxForStudent2.add(chb_address3);

        chb_level3.setBackground(new java.awt.Color(255, 255, 255));
        chb_level3.setSelected(true);
        pl_checkBoxForStudent2.add(chb_level3);

        pl_verticalSeperateLine5.setBackground(new java.awt.Color(153, 153, 153));
        pl_verticalSeperateLine5.setPreferredSize(new java.awt.Dimension(2, 500));

        javax.swing.GroupLayout pl_verticalSeperateLine5Layout = new javax.swing.GroupLayout(pl_verticalSeperateLine5);
        pl_verticalSeperateLine5.setLayout(pl_verticalSeperateLine5Layout);
        pl_verticalSeperateLine5Layout.setHorizontalGroup(
            pl_verticalSeperateLine5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );
        pl_verticalSeperateLine5Layout.setVerticalGroup(
            pl_verticalSeperateLine5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        t_viewStudentData3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 155, 255), 2, true));
        t_viewStudentData3.setFont(new java.awt.Font("Cairo", 1, 11)); // NOI18N
        t_viewStudentData3.setRowHeight(30);
        sp_studentData3.setViewportView(t_viewStudentData3);

        lb_star25.setBackground(new java.awt.Color(255, 255, 255));
        lb_star25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_star25.setForeground(new java.awt.Color(255, 0, 0));
        lb_star25.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_star25.setText("*");

        lb_star26.setBackground(new java.awt.Color(255, 255, 255));
        lb_star26.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_star26.setForeground(new java.awt.Color(255, 0, 0));
        lb_star26.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_star26.setText("*");

        LevelGroupHolder.setBackground(new java.awt.Color(255, 255, 255));
        LevelGroupHolder.setLayout(new java.awt.GridLayout(2, 0, 0, 20));

        cb_level5.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        cb_level5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "اختر الفرقة" }));
        cb_level5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 155, 255), 2, true));
        cb_level5.setPreferredSize(new java.awt.Dimension(180, 33));
        cb_level5.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_level5ItemStateChanged(evt);
            }
        });
        cb_level5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cb_level5FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cb_level5FocusLost(evt);
            }
        });
        LevelGroupHolder.add(cb_level5);

        cb_book5.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        cb_book5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "اختر المذكرة" }));
        cb_book5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 155, 255), 2, true));
        cb_book5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cb_book5FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cb_book5FocusLost(evt);
            }
        });
        LevelGroupHolder.add(cb_book5);

        btn_printInternalMoney3.setBackground(new java.awt.Color(0, 155, 255));
        btn_printInternalMoney3.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        btn_printInternalMoney3.setForeground(new java.awt.Color(255, 255, 255));
        btn_printInternalMoney3.setText("طباعة");
        btn_printInternalMoney3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_printInternalMoney3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pl_didNotPayYetBookLayout = new javax.swing.GroupLayout(pl_didNotPayYetBook);
        pl_didNotPayYetBook.setLayout(pl_didNotPayYetBookLayout);
        pl_didNotPayYetBookLayout.setHorizontalGroup(
            pl_didNotPayYetBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pl_didNotPayYetBookLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(pl_didNotPayYetBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pl_didNotPayYetBookLayout.createSequentialGroup()
                        .addComponent(sp_studentData3, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
                        .addGap(40, 40, 40))
                    .addGroup(pl_didNotPayYetBookLayout.createSequentialGroup()
                        .addComponent(btn_printInternalMoney3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(pl_verticalSeperateLine5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pl_didNotPayYetBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pl_didNotPayYetBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pl_didNotPayYetBookLayout.createSequentialGroup()
                            .addComponent(pl_parents3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(pl_checkBoxForParent3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(28, 28, 28)
                            .addComponent(pl_student2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(pl_checkBoxForStudent2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(49, 49, 49))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pl_didNotPayYetBookLayout.createSequentialGroup()
                            .addComponent(lb_classification2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap()))
                    .addGroup(pl_didNotPayYetBookLayout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(pl_didNotPayYetBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_star26, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_star25, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addComponent(LevelGroupHolder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pl_didNotPayYetBookLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_search4, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(106, 106, 106))))
        );
        pl_didNotPayYetBookLayout.setVerticalGroup(
            pl_didNotPayYetBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pl_didNotPayYetBookLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(pl_didNotPayYetBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pl_didNotPayYetBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pl_didNotPayYetBookLayout.createSequentialGroup()
                            .addGap(16, 16, 16)
                            .addGroup(pl_didNotPayYetBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pl_didNotPayYetBookLayout.createSequentialGroup()
                                    .addComponent(lb_star25)
                                    .addGap(30, 30, 30)
                                    .addComponent(lb_star26, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(LevelGroupHolder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_classification2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(pl_didNotPayYetBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pl_didNotPayYetBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(pl_checkBoxForParent3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(pl_parents3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(pl_didNotPayYetBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(pl_student2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(pl_checkBoxForStudent2, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(0, 0, 0)
                            .addComponent(btn_search4)
                            .addGap(25, 25, 25))
                        .addComponent(pl_verticalSeperateLine5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pl_didNotPayYetBookLayout.createSequentialGroup()
                        .addComponent(sp_studentData3, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btn_printInternalMoney3)))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        moneyManagement.add(pl_didNotPayYetBook, "card4");

        pl_paiedBook.setBackground(new java.awt.Color(255, 255, 255));

        btn_search7.setBackground(new java.awt.Color(19, 64, 93));
        btn_search7.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        btn_search7.setForeground(new java.awt.Color(255, 255, 255));
        btn_search7.setText("بحث");
        btn_search7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_search7ActionPerformed(evt);
            }
        });

        lb_classification5.setBackground(new java.awt.Color(255, 255, 255));
        lb_classification5.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_classification5.setForeground(new java.awt.Color(19, 64, 93));
        lb_classification5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_classification5.setText("التصنيفات:");

        pl_checkBoxForParent7.setBackground(new java.awt.Color(255, 255, 255));
        pl_checkBoxForParent7.setLayout(new java.awt.GridLayout(4, 3, 0, 10));

        chb_parentName4.setBackground(new java.awt.Color(255, 255, 255));
        chb_parentName4.setSelected(true);
        pl_checkBoxForParent7.add(chb_parentName4);

        chb_parentPhone4.setBackground(new java.awt.Color(255, 255, 255));
        chb_parentPhone4.setSelected(true);
        pl_checkBoxForParent7.add(chb_parentPhone4);

        chb_parentJob4.setBackground(new java.awt.Color(255, 255, 255));
        chb_parentJob4.setSelected(true);
        pl_checkBoxForParent7.add(chb_parentJob4);

        chb_recieve.setBackground(new java.awt.Color(255, 255, 255));
        chb_recieve.setSelected(true);
        pl_checkBoxForParent7.add(chb_recieve);

        pl_parents7.setBackground(new java.awt.Color(255, 255, 255));
        pl_parents7.setLayout(new java.awt.GridLayout(4, 4, 0, 10));

        lb_parentName9.setBackground(new java.awt.Color(255, 255, 255));
        lb_parentName9.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_parentName9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_parentName9.setText("اسم ولي الامر");
        pl_parents7.add(lb_parentName9);

        lb_parentPhone11.setBackground(new java.awt.Color(255, 255, 255));
        lb_parentPhone11.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_parentPhone11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_parentPhone11.setText("هاتف ولي الامر");
        pl_parents7.add(lb_parentPhone11);

        lb_parentJob7.setBackground(new java.awt.Color(255, 255, 255));
        lb_parentJob7.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_parentJob7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_parentJob7.setText("وظيفة ولي الامر");
        pl_parents7.add(lb_parentJob7);

        lb_recieve.setBackground(new java.awt.Color(255, 255, 255));
        lb_recieve.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_recieve.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_recieve.setText("حالة الاستلام");
        pl_parents7.add(lb_recieve);

        pl_student5.setBackground(new java.awt.Color(255, 255, 255));
        pl_student5.setLayout(new java.awt.GridLayout(5, 3, 0, 10));

        lb_studentName9.setBackground(new java.awt.Color(255, 255, 255));
        lb_studentName9.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_studentName9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_studentName9.setText("اسم الطالب");
        pl_student5.add(lb_studentName9);

        lb_studentPhone10.setBackground(new java.awt.Color(255, 255, 255));
        lb_studentPhone10.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_studentPhone10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_studentPhone10.setText("هاتف الطالب");
        pl_student5.add(lb_studentPhone10);

        lb_address9.setBackground(new java.awt.Color(255, 255, 255));
        lb_address9.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_address9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_address9.setText("العنوان");
        pl_student5.add(lb_address9);

        lb_level5.setBackground(new java.awt.Color(255, 255, 255));
        lb_level5.setFont(new java.awt.Font("Cairo", 1, 18)); // NOI18N
        lb_level5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_level5.setText("الفرقة");
        pl_student5.add(lb_level5);

        pl_checkBoxForStudent5.setBackground(new java.awt.Color(255, 255, 255));
        pl_checkBoxForStudent5.setLayout(new java.awt.GridLayout(5, 3, 0, 10));

        chb_studentName4.setBackground(new java.awt.Color(255, 255, 255));
        chb_studentName4.setSelected(true);
        pl_checkBoxForStudent5.add(chb_studentName4);

        chb_studentPhone4.setBackground(new java.awt.Color(255, 255, 255));
        chb_studentPhone4.setSelected(true);
        pl_checkBoxForStudent5.add(chb_studentPhone4);

        chb_address4.setBackground(new java.awt.Color(255, 255, 255));
        chb_address4.setSelected(true);
        pl_checkBoxForStudent5.add(chb_address4);

        chb_level4.setBackground(new java.awt.Color(255, 255, 255));
        chb_level4.setSelected(true);
        pl_checkBoxForStudent5.add(chb_level4);

        pl_verticalSeperateLine6.setBackground(new java.awt.Color(153, 153, 153));
        pl_verticalSeperateLine6.setPreferredSize(new java.awt.Dimension(2, 500));

        javax.swing.GroupLayout pl_verticalSeperateLine6Layout = new javax.swing.GroupLayout(pl_verticalSeperateLine6);
        pl_verticalSeperateLine6.setLayout(pl_verticalSeperateLine6Layout);
        pl_verticalSeperateLine6Layout.setHorizontalGroup(
            pl_verticalSeperateLine6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );
        pl_verticalSeperateLine6Layout.setVerticalGroup(
            pl_verticalSeperateLine6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 506, Short.MAX_VALUE)
        );

        t_viewStudentData4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 155, 255), 2, true));
        t_viewStudentData4.setFont(new java.awt.Font("Cairo", 1, 11)); // NOI18N
        t_viewStudentData4.setRowHeight(30);
        sp_studentData4.setViewportView(t_viewStudentData4);

        lb_star27.setBackground(new java.awt.Color(255, 255, 255));
        lb_star27.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_star27.setForeground(new java.awt.Color(255, 0, 0));
        lb_star27.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_star27.setText("*");

        lb_star28.setBackground(new java.awt.Color(255, 255, 255));
        lb_star28.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_star28.setForeground(new java.awt.Color(255, 0, 0));
        lb_star28.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_star28.setText("*");

        pl_level_month2.setBackground(new java.awt.Color(255, 255, 255));
        pl_level_month2.setLayout(new java.awt.GridLayout(2, 0, 0, 20));

        cb_level6.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        cb_level6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "اختر الفرقة" }));
        cb_level6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 155, 255), 2, true));
        cb_level6.setPreferredSize(new java.awt.Dimension(180, 33));
        cb_level6.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_level6ItemStateChanged(evt);
            }
        });
        cb_level6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cb_level6FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cb_level6FocusLost(evt);
            }
        });
        pl_level_month2.add(cb_level6);

        cb_book6.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        cb_book6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "اختر المذكرة" }));
        cb_book6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 155, 255), 2, true));
        cb_book6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cb_book6FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cb_book6FocusLost(evt);
            }
        });
        pl_level_month2.add(cb_book6);

        btn_printInternalMoney4.setBackground(new java.awt.Color(0, 155, 255));
        btn_printInternalMoney4.setFont(new java.awt.Font("Cairo", 1, 14)); // NOI18N
        btn_printInternalMoney4.setForeground(new java.awt.Color(255, 255, 255));
        btn_printInternalMoney4.setText("طباعة");
        btn_printInternalMoney4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_printInternalMoney4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pl_paiedBookLayout = new javax.swing.GroupLayout(pl_paiedBook);
        pl_paiedBook.setLayout(pl_paiedBookLayout);
        pl_paiedBookLayout.setHorizontalGroup(
            pl_paiedBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pl_paiedBookLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(pl_paiedBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pl_paiedBookLayout.createSequentialGroup()
                        .addComponent(sp_studentData4, javax.swing.GroupLayout.DEFAULT_SIZE, 759, Short.MAX_VALUE)
                        .addGap(40, 40, 40))
                    .addGroup(pl_paiedBookLayout.createSequentialGroup()
                        .addComponent(btn_printInternalMoney4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(pl_verticalSeperateLine6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pl_paiedBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pl_paiedBookLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_search7, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(106, 106, 106))
                    .addGroup(pl_paiedBookLayout.createSequentialGroup()
                        .addGroup(pl_paiedBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pl_paiedBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pl_paiedBookLayout.createSequentialGroup()
                                    .addComponent(pl_parents7, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(pl_checkBoxForParent7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(28, 28, 28)
                                    .addComponent(pl_student5, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(pl_checkBoxForStudent5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(lb_classification5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pl_paiedBookLayout.createSequentialGroup()
                                .addGap(98, 98, 98)
                                .addGroup(pl_paiedBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lb_star28, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lb_star27, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, 0)
                                .addComponent(pl_level_month2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        pl_paiedBookLayout.setVerticalGroup(
            pl_paiedBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pl_paiedBookLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pl_paiedBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pl_paiedBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pl_paiedBookLayout.createSequentialGroup()
                            .addGroup(pl_paiedBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pl_paiedBookLayout.createSequentialGroup()
                                    .addComponent(lb_star27)
                                    .addGap(30, 30, 30)
                                    .addComponent(lb_star28, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(pl_level_month2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                            .addComponent(lb_classification5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(pl_paiedBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pl_paiedBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(pl_checkBoxForParent7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(pl_parents7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(pl_paiedBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(pl_student5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(pl_checkBoxForStudent5, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(31, 31, 31)
                            .addComponent(btn_search7))
                        .addComponent(pl_verticalSeperateLine6, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE))
                    .addGroup(pl_paiedBookLayout.createSequentialGroup()
                        .addComponent(sp_studentData4, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btn_printInternalMoney4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        moneyManagement.add(pl_paiedBook, "card4");

        pl_bottomButtonCotrol.setBackground(new java.awt.Color(19, 64, 93));
        pl_bottomButtonCotrol.setMinimumSize(new java.awt.Dimension(1205, 60));
        pl_bottomButtonCotrol.setPreferredSize(new java.awt.Dimension(1205, 60));
        pl_bottomButtonCotrol.setLayout(new java.awt.GridLayout(1, 0, 40, 0));
        pl_bottomButtonCotrol.add(lb_empty3);
        pl_bottomButtonCotrol.add(lb_empty4);
        pl_bottomButtonCotrol.add(lb_empty5);

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

        javax.swing.GroupLayout lb_backgroundLayout = new javax.swing.GroupLayout(lb_background);
        lb_background.setLayout(lb_backgroundLayout);
        lb_backgroundLayout.setHorizontalGroup(
            lb_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pl_topButtonControl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(lb_backgroundLayout.createSequentialGroup()
                .addComponent(moneyManagement, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                .addGap(20, 20, 20))
            .addGroup(lb_backgroundLayout.createSequentialGroup()
                .addComponent(pl_bottomButtonCotrol, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        lb_backgroundLayout.setVerticalGroup(
            lb_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lb_backgroundLayout.createSequentialGroup()
                .addComponent(pl_topButtonControl, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(moneyManagement, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pl_bottomButtonCotrol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        sp_moneyManagement.setViewportView(lb_background);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp_moneyManagement)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp_moneyManagement, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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

    private void chb_LevelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chb_LevelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chb_LevelActionPerformed

    private void lst_searchNamesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lst_searchNamesValueChanged
        tf_studentName.setText(lst_searchNames.getSelectedValue());
        pl_searchNames.setVisible(false);
    }//GEN-LAST:event_lst_searchNamesValueChanged

    private void tf_studentNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_studentNameKeyTyped
        if (!checkEmpty(cb_level)) {
            evt.consume();
            return;
        }

        String level = cb_level.getSelectedItem().toString();
        loadPredictedNamesDependOnStudentNameAndLevel(tf_studentName, level, lst_searchNames, pl_searchNames);

    }//GEN-LAST:event_tf_studentNameKeyTyped

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
        if (checkEmpty(cb_level) && checkEmpty(cb_month) && checkEmpty(tf_code) && checkEmpty(tf_studentName)) {
            String level_name = cb_level.getSelectedItem().toString();
            String month_name = cb_month.getSelectedItem().toString();
            int Student_code = Integer.parseInt(tf_code.getText());
            int paid = -1;
            int discount = -1;
            int rest = -1;
            PreparedStatement stmt;
            ResultSet resultSet;
            try {
                stmt = con.prepareStatement("select * from pay_for_month where level_name=? and student_code=? and month_name=?");
                stmt.setString(1, level_name);
                stmt.setInt(2, Student_code);
                stmt.setString(3, month_name);
                resultSet = stmt.executeQuery();
                while (resultSet.next()) {
                    paid = (resultSet.getInt("amount_paid"));
                    discount = (resultSet.getInt("discount"));
                    rest = (resultSet.getInt("rest"));
                }
                if (paid != (-1)) {
                    tf_paid.setText(String.valueOf(paid));
                    tf_discount.setText(String.valueOf(discount));
                    tf_rest.setText(String.valueOf(rest));

                    btn_update.setEnabled(true);
                    btn_delete.setEnabled(true);
                    btn_add.setEnabled(false);
                    btn_search.setEnabled(false);
                    cb_level.setEnabled(false);
                    cb_month.setEnabled(false);
                    tf_studentName.setEnabled(false);
                    tf_code.setEnabled(false);
                    btn_printBill.setEnabled(true);

                } else {
                    jOptionPaneMessage("لم يدفع هذا الطالب هذا الشهر", 2);
                }
            } catch (SQLException ex) {
                handleSqlExceptions(ex.getErrorCode());
            }
        }
    }//GEN-LAST:event_btn_searchActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        // check that the important field isn't empty
        if (checkEmpty(cb_level) && checkEmpty(cb_month) && checkEmpty(tf_code) && checkEmpty(tf_studentName) && checkEmpty(tf_paid) && checkEmpty(tf_discount)) {
            int student_code = Integer.parseInt(tf_code.getText());
            String student_name = tf_studentName.getText();
            String level_name = cb_level.getSelectedItem().toString();
            String month_name = cb_month.getSelectedItem().toString();
            int amount_paid = Integer.parseInt(tf_paid.getText());
            int discount = Integer.parseInt(tf_discount.getText());
            int rest = Integer.parseInt(tf_rest.getText());
            int total = Integer.parseInt(tf_total.getText());

            // check if the total value entered is bigger than the total or not
            if ((discount == 0 && amount_paid == 0)) {
                makeRed(tf_paid);
                makeRed(tf_discount);
                JOptionPane.showMessageDialog(null, "المبلغ المدفوع و الخصم غير مضافين تاكد من الاضافة");
                return;
            }
            if ((discount + amount_paid > total)) {
                makeRed(tf_paid);
                makeRed(tf_discount);
                JOptionPane.showMessageDialog(null, "المبلغ المدفوع و الخصم اكبر من المجموع الكلي بفارق " + ((discount + amount_paid) - total));
            } else {
                String date = getDate();
                String time = getTime();

                // adding student information to student table
                try {
                    PreparedStatement stmt = con.prepareStatement("insert into pay_for_month values(?,?,?,?,?,?,?,?,?)");
                    stmt.setInt(1, student_code);
                    stmt.setString(2, level_name);
                    stmt.setString(3, month_name);
                    stmt.setString(4, student_name);
                    stmt.setInt(5, amount_paid);
                    stmt.setInt(6, discount);
                    stmt.setInt(7, rest);
                    stmt.setString(8, date);
                    stmt.setString(9, time);
                    stmt.execute();
                    recordEvent("اضافة", "اضافة مصاريف", "اضافة مصاريف شهر " + month_name + "للطالب " + student_name + "في الفرقة " + level_name + "بمبلغ قدر " + amount_paid + "و خصم " + discount);
                    addMessage();
                    functions.printJ(student_name, student_code, level_name, month_name, date, discount, total);
                    cleanAfterAddDeleteUpdateMonth();
                } catch (SQLException ex) {
                    handleSqlExceptions(ex.getErrorCode());
                }
            }
        }
    }//GEN-LAST:event_btn_addActionPerformed

    private void cb_levelKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cb_levelKeyTyped

    }//GEN-LAST:event_cb_levelKeyTyped

    private void cb_levelItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_levelItemStateChanged
        tf_code.setText("");
        tf_studentName.setText("");
        String level_name = cb_level.getSelectedItem().toString();
        if (!tf_paid.getText().equals("") && !tf_discount.getText().equals("")) {
            int total = Integer.parseInt(tf_total.getText());
            int paid = Integer.parseInt(tf_paid.getText());
            int discount = Integer.parseInt(tf_discount.getText());
            int rest = total - (paid + discount);
            tf_rest.setText(String.valueOf(rest));
        }

        if (!level_name.equals("اختر الفرقة")) {
            tf_paid.setEnabled(true);
            tf_discount.setEnabled(true);
            tf_code.setEnabled(true);
            tf_studentName.setEnabled(true);
            cb_month.setEnabled(true);
            PreparedStatement stmt;
            ResultSet resultSet;
            int month_cost = 0;
            try {

                stmt = con.prepareStatement("select month_cost from student_level where level_name=?");
                stmt.setString(1, level_name);
                resultSet = stmt.executeQuery();

                while (resultSet.next()) {
                    month_cost = resultSet.getInt("month_cost");
                }
                tf_total.setText(String.valueOf(month_cost));

            } catch (SQLException ex) {
                handleSqlExceptions(ex.getErrorCode());
            }
        } else {
            tf_paid.setEnabled(false);
            tf_discount.setEnabled(false);
            tf_code.setEnabled(false);
            tf_studentName.setEnabled(false);

        }
    }//GEN-LAST:event_cb_levelItemStateChanged

    private void tf_codeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_codeKeyTyped
        if (!checkEmpty(cb_level)) {
            evt.consume();
        }
        textFieldValidation(tf_code, evt.getKeyChar(), evt);
    }//GEN-LAST:event_tf_codeKeyTyped

    private void tf_codeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_codeFocusLost
        String level = cb_level.getSelectedItem().toString();
        searchForStudentNameByCode(tf_code, tf_studentName, level);

    }//GEN-LAST:event_tf_codeFocusLost

    private void tf_codeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_codeFocusGained
        FocusLostOrGained(tf_code);
    }//GEN-LAST:event_tf_codeFocusGained

    private void btn_cleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cleanActionPerformed
        cleanAfterAddDeleteUpdateMonth();
    }//GEN-LAST:event_btn_cleanActionPerformed

    private void tf_paidKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_paidKeyTyped
        textFieldValidation(tf_paid, evt.getKeyChar(), evt);

    }//GEN-LAST:event_tf_paidKeyTyped

    private void tf_discountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_discountKeyTyped
        textFieldValidation(tf_discount, evt.getKeyChar(), evt);
    }//GEN-LAST:event_tf_discountKeyTyped

    private void cb_levelFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cb_levelFocusGained
        FocusLostOrGained(cb_level);
    }//GEN-LAST:event_cb_levelFocusGained

    private void cb_levelFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cb_levelFocusLost
        FocusLostOrGained(cb_level);
    }//GEN-LAST:event_cb_levelFocusLost

    private void tf_studentNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_studentNameFocusGained
        String level = cb_level.getSelectedItem().toString();
        searchForStudentCodeByName(tf_code, tf_studentName, level);
    }//GEN-LAST:event_tf_studentNameFocusGained

    private void tf_studentNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_studentNameFocusLost

        String level = cb_level.getSelectedItem().toString();
        searchForStudentCodeByName(tf_code, tf_studentName, level);
    }//GEN-LAST:event_tf_studentNameFocusLost

    private void tf_paidFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_paidFocusGained
        tf_paid.setText("");
        FocusLostOrGained(tf_paid);
    }//GEN-LAST:event_tf_paidFocusGained

    private void tf_paidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_paidFocusLost
        FocusLostOrGained(tf_paid);
        if (!tf_paid.getText().equals("") && !tf_discount.getText().equals("")) {
            int total = Integer.parseInt(tf_total.getText());
            int paid = Integer.parseInt(tf_paid.getText());
            int discount = Integer.parseInt(tf_discount.getText());
            int rest = total - (paid + discount);
            tf_rest.setText(String.valueOf(rest));
        } else {
            tf_paid.setText("0");
            tf_discount.setText("0");
        }
    }//GEN-LAST:event_tf_paidFocusLost

    private void cb_monthFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cb_monthFocusGained
        FocusLostOrGained(cb_month);
    }//GEN-LAST:event_cb_monthFocusGained

    private void cb_monthFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cb_monthFocusLost
        FocusLostOrGained(cb_month);
    }//GEN-LAST:event_cb_monthFocusLost

    private void tf_codeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_codeKeyPressed
        if (enter(evt.getKeyCode())) {
            tf_studentName.requestFocus(true);
        }
    }//GEN-LAST:event_tf_codeKeyPressed

    private void tf_discountFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_discountFocusGained
        FocusLostOrGained(tf_discount);
    }//GEN-LAST:event_tf_discountFocusGained

    private void tf_discountFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_discountFocusLost
        FocusLostOrGained(tf_discount);
        if (!tf_paid.getText().equals("") && !tf_discount.getText().equals("")) {
            int total = Integer.parseInt(tf_total.getText());
            int paid = Integer.parseInt(tf_paid.getText());
            int discount = Integer.parseInt(tf_discount.getText());
            int rest = total - (paid + discount);
            tf_rest.setText(String.valueOf(rest));
        }
    }//GEN-LAST:event_tf_discountFocusLost

    private void cb_levelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_levelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_levelActionPerformed

    private void tf_paidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_paidKeyPressed
        if (enter(evt.getKeyCode())) {
            tf_discount.requestFocus();
        }
    }//GEN-LAST:event_tf_paidKeyPressed

    private void tf_discountKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_discountKeyPressed
        if (enter(evt.getKeyCode())) {
            // check that the important field isn't empty
            if (checkEmpty(cb_level) && checkEmpty(cb_month) && checkEmpty(tf_code) && checkEmpty(tf_studentName) && checkEmpty(tf_paid) && checkEmpty(tf_discount)) {
                int student_code = Integer.parseInt(tf_code.getText());
                String student_name = tf_studentName.getText();
                String level_name = cb_level.getSelectedItem().toString();
                String month_name = cb_month.getSelectedItem().toString();
                int amount_paid = Integer.parseInt(tf_paid.getText());
                int discount = Integer.parseInt(tf_discount.getText());
                int rest = Integer.parseInt(tf_rest.getText());
                int total = Integer.parseInt(tf_total.getText());

                // check if the total value entered is bigger than the total or not
                if ((discount == 0 && amount_paid == 0)) {
                    makeRed(tf_paid);
                    makeRed(tf_discount);
                    JOptionPane.showMessageDialog(null, "المبلغ المدفوع و الخصم غير مضافين تاكد من الاضافة");
                    return;
                }
                if ((discount + amount_paid > total)) {
                    makeRed(tf_paid);
                    makeRed(tf_discount);
                    JOptionPane.showMessageDialog(null, "المبلغ المدفوع و الخصم اكبر من المجموع الكلي بفارق " + ((discount + amount_paid) - total));
                } else {
                    String date = getDate();
                    String time = getTime();

                    // adding student information to student table
                    try {
                        PreparedStatement stmt = con.prepareStatement("insert into pay_for_month values(?,?,?,?,?,?,?,?,?)");
                        stmt.setInt(1, student_code);
                        stmt.setString(2, level_name);
                        stmt.setString(3, month_name);
                        stmt.setString(4, student_name);
                        stmt.setInt(5, amount_paid);
                        stmt.setInt(6, discount);
                        stmt.setInt(7, rest);
                        stmt.setString(8, date);
                        stmt.setString(9, time);
                        stmt.execute();
                        recordEvent("اضافة", "اضافة مصاريف", "اضافة مصاريف شهر " + month_name + "للطالب " + student_name + "في الفرقة " + level_name + "بمبلغ قدر " + amount_paid + "و خصم " + discount);
                        addMessage();
                        //functions.printJ(student_name, student_code, level_name, month_name, date, discount, total);
                        cleanAfterAddDeleteUpdateMonth();
                    } catch (SQLException ex) {
                        handleSqlExceptions(ex.getErrorCode());
                    }
                }
            }
        }
    }//GEN-LAST:event_tf_discountKeyPressed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        if (adminAccept()) {
            if (checkEmpty(cb_level) && checkEmpty(tf_code) && checkEmpty(cb_month)) {
                int student_code = Integer.parseInt(tf_code.getText());
                String level_name = cb_level.getSelectedItem().toString();
                String month_name = cb_month.getSelectedItem().toString();
                PreparedStatement stmt;

                try {
                    stmt = con.prepareStatement("delete from pay_for_month where student_code=? and level_name=? and month_name=?");
                    //************************** to delete ******************
                    stmt.setInt(1, student_code);
                    stmt.setString(2, level_name);
                    stmt.setString(3, month_name);
                    stmt.execute();
                    deleteMessage();
                    cleanAfterAddDeleteUpdateMonth();
                } catch (SQLException ex) {
                    handleSqlExceptions(ex.getErrorCode());
                }

            }
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        if (adminAccept()) {
            if (checkEmpty(cb_level) && checkEmpty(cb_month) && checkEmpty(tf_code) && checkEmpty(tf_studentName) && checkEmpty(tf_paid) && checkEmpty(tf_discount)) {
                String level_name = cb_level.getSelectedItem().toString();
                String month_name = cb_month.getSelectedItem().toString();
                int Student_code = Integer.parseInt(tf_code.getText());
                int amount_paid = Integer.parseInt(tf_paid.getText());
                int discount = Integer.parseInt(tf_discount.getText());
                int rest = Integer.parseInt(tf_rest.getText());
                int total = Integer.parseInt(tf_total.getText());

                PreparedStatement stmt;
                if (discount + amount_paid > total) {
                    makeRed(tf_paid);
                    makeRed(tf_discount);
                    JOptionPane.showMessageDialog(null, "المبلغ المدفوع و الخصم اكبر من المجموع الكلي بفارق " + ((discount + amount_paid) - total));
                } else {
                    try {
                        stmt = con.prepareStatement("update pay_for_month set amount_paid=?, discount=?, rest=?  where level_name=? and student_code=? and month_name=?");
                        stmt.setInt(1, amount_paid);
                        stmt.setInt(2, discount);
                        stmt.setInt(3, rest);
                        stmt.setString(4, level_name);
                        stmt.setInt(5, Student_code);
                        stmt.setString(6, month_name);
                        stmt.execute();
                        updateMessage();
                        cleanAfterAddDeleteUpdateMonth();

                    } catch (SQLException ex) {
                        handleSqlExceptions(ex.getErrorCode());
                    }
                }
            }
        }
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_add1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_add1ActionPerformed
        // check that the important field isn't empty
        int student_code;
        String student_name;
        String level_name;
        int amount_paid;
        int discount;
        int rest;
        int total;
        String book_name;
        String date;
        String time;

        if (checkEmpty(cb_level1) && checkEmpty(cb_book1) && checkEmpty(tf_code1) && checkEmpty(tf_studentName1) && checkEmpty(tf_paid1) && checkEmpty(tf_discount1)) {
            // get the selected book
            book_name = cb_book1.getSelectedItem().toString();
            student_code = Integer.parseInt(tf_code1.getText());
            student_name = tf_studentName1.getText();
            level_name = cb_level1.getSelectedItem().toString();
            amount_paid = Integer.parseInt(tf_paid1.getText());
            discount = Integer.parseInt(tf_discount1.getText());
            rest = Integer.parseInt(tf_rest1.getText());
            total = Integer.parseInt(tf_total1.getText());
            date = getDate();
            time = getTime();
            // check if the total value entered is bigger than the total or not
            if (discount + amount_paid > total) {
                makeRed(tf_paid1);
                makeRed(tf_discount1);
                jOptionPaneMessage("المبلغ المدفوع و الخصم اكبر من المجموع الكلي بفارق " + ((discount + amount_paid) - total), 2);
            } else {

                // adding information to pay for book
                try {
                    PreparedStatement stmt = con.prepareStatement("INSERT INTO pay_for_book VALUES (?,?,?,?,?,?,?,?,?,?)");
                    stmt.setInt(1, student_code);
                    stmt.setString(2, level_name);
                    stmt.setString(3, book_name);
                    stmt.setString(4, student_name);
                    stmt.setInt(5, amount_paid);
                    stmt.setInt(6, discount);
                    stmt.setInt(7, rest);
                    stmt.setString(8, date);
                    stmt.setString(9, time);
                    stmt.setString(10, "لم يستلم");
                    stmt.execute();

                    // increase the sold by one
                    PreparedStatement stmt2 = con.prepareStatement("update student_book set sold=sold+1 where level_name=? and book_name=?");
                    stmt2.setString(1, level_name);
                    stmt2.setString(2, book_name);
                    stmt2.executeUpdate();
                    addMessage();
                    recordEvent("اضافة", "بيع مذكرة", "قام الطالب " + student_name + "بشراء المذكرة " + book_name + "في الفرقة " + level_name + "ودفع مبلغ " + amount_paid);
                    cleanAfterAddDeleteUpdateBook();
                } catch (SQLException ex) {
                    handleSqlExceptions(ex.getErrorCode());
                }
            }

        }

    }//GEN-LAST:event_btn_add1ActionPerformed

    private void btn_update1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_update1ActionPerformed
        if (adminAccept()) {
            if (checkEmpty(cb_level1) && checkEmpty(cb_book1) && checkEmpty(tf_code1) && checkEmpty(tf_studentName1) && checkEmpty(tf_paid1) && checkEmpty(tf_discount1)) {
                String level_name = cb_level1.getSelectedItem().toString();
                String book_name = cb_book1.getSelectedItem().toString();
                int Student_code = Integer.parseInt(tf_code1.getText());
                int amount_paid = Integer.parseInt(tf_paid1.getText());
                int discount = Integer.parseInt(tf_discount1.getText());
                int rest = Integer.parseInt(tf_rest1.getText());
                int total = Integer.parseInt(tf_total1.getText());

                PreparedStatement stmt;
                if (discount + amount_paid > total) {
                    makeRed(tf_paid1);
                    makeRed(tf_discount1);
                    jOptionPaneMessage("المبلغ المدفوع و الخصم اكبر من المجموع الكلي بفارق " + ((discount + amount_paid) - total), 2);
                } else {
                    try {
                        stmt = con.prepareStatement("update pay_for_book set amount_paid=?, discount=?, rest=?  where level_name=? and student_code=? and book_name=?");
                        stmt.setInt(1, amount_paid);
                        stmt.setInt(2, discount);
                        stmt.setInt(3, rest);
                        stmt.setString(4, level_name);
                        stmt.setInt(5, Student_code);
                        stmt.setString(6, book_name);
                        stmt.execute();
                        updateMessage();

                        cleanAfterAddDeleteUpdateBook();

                    } catch (SQLException ex) {
                        handleSqlExceptions(ex.getErrorCode());
                    }
                }
            }
        }

    }//GEN-LAST:event_btn_update1ActionPerformed

    private void cb_level1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_level1ItemStateChanged
        tf_code1.setText("");
        tf_studentName1.setText("");
        String level_name = cb_level1.getSelectedItem().toString();
        if (!level_name.equals("اختر الفرقة")) {
            tf_paid1.setEnabled(true);
            tf_discount1.setEnabled(true);
            tf_code1.setEnabled(true);
            tf_studentName1.setEnabled(true);
            cb_book1.setEnabled(true);
            loadBook(cb_book1, cb_level1.getSelectedItem().toString());
        } else {
            tf_paid1.setEnabled(false);
            tf_discount1.setEnabled(false);
            tf_code1.setEnabled(false);
            tf_studentName1.setEnabled(false);
            cb_book1.setEnabled(false);
            loadBook(cb_book1, cb_level1.getSelectedItem().toString());
        }
    }//GEN-LAST:event_cb_level1ItemStateChanged

    private void cb_level1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cb_level1FocusGained
        FocusLostOrGained(cb_level1);
    }//GEN-LAST:event_cb_level1FocusGained

    private void cb_level1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cb_level1FocusLost
        FocusLostOrGained(cb_level1);
    }//GEN-LAST:event_cb_level1FocusLost

    private void tf_code1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_code1FocusGained
        FocusLostOrGained(tf_code1);
    }//GEN-LAST:event_tf_code1FocusGained

    private void tf_code1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_code1FocusLost
        FocusLostOrGained(tf_code1);
        String level = cb_level1.getSelectedItem().toString();
        searchForStudentNameByCode(tf_code1, tf_studentName1, level);
    }//GEN-LAST:event_tf_code1FocusLost

    private void tf_code1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_code1KeyPressed
        if (enter(evt.getKeyChar())) {
            tf_studentName1.requestFocus(true);
        }
    }//GEN-LAST:event_tf_code1KeyPressed

    private void tf_code1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_code1KeyTyped
        textFieldValidation(tf_code1, evt.getKeyChar(), evt);
    }//GEN-LAST:event_tf_code1KeyTyped

    private void tf_studentName1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_studentName1FocusGained
        String level = cb_level1.getSelectedItem().toString();
        searchForStudentCodeByName(tf_code1, tf_studentName1, level);
    }//GEN-LAST:event_tf_studentName1FocusGained

    private void tf_studentName1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_studentName1FocusLost
        String level = cb_level1.getSelectedItem().toString();
        searchForStudentCodeByName(tf_code1, tf_studentName1, level);
    }//GEN-LAST:event_tf_studentName1FocusLost

    private void tf_studentName1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_studentName1KeyTyped
        String level = cb_level1.getSelectedItem().toString();
        loadPredictedNamesDependOnStudentNameAndLevel(tf_studentName1, level, lst_searchNames1, pl_searchNames1);

    }//GEN-LAST:event_tf_studentName1KeyTyped

    private void cb_book1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cb_book1FocusGained
        FocusLostOrGained(cb_book1);
    }//GEN-LAST:event_cb_book1FocusGained

    private void cb_book1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cb_book1FocusLost
        FocusLostOrGained(cb_book1);
    }//GEN-LAST:event_cb_book1FocusLost

    private void tf_discount1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_discount1FocusGained
        FocusLostOrGained(tf_discount1);
    }//GEN-LAST:event_tf_discount1FocusGained

    private void tf_discount1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_discount1FocusLost
        FocusLostOrGained(tf_discount1);
        if (!tf_paid1.getText().equals("") && !tf_discount1.getText().equals("")) {
            int total = Integer.parseInt(tf_total1.getText());
            int paid = Integer.parseInt(tf_paid1.getText());
            int discount = Integer.parseInt(tf_discount1.getText());
            int rest = total - (paid + discount);
            tf_rest1.setText(String.valueOf(rest));
        } else {
            tf_paid1.setText("0");
            tf_discount1.setText("0");
        }
    }//GEN-LAST:event_tf_discount1FocusLost

    private void tf_discount1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_discount1KeyPressed
        if (enter(evt.getKeyChar())) {
            // check that the important field isn't empty
            int student_code;
            String student_name;
            String level_name;
            int amount_paid;
            int discount;
            int rest;
            int total;
            String book_name;
            String date;
            String time;
            if (tf_paid1.getText().equals("") && tf_discount1.getText().equals("")) {
                tf_paid1.setText("0");
                tf_discount1.setText("0");
            }
            if (checkEmpty(cb_level1) && checkEmpty(cb_book1) && checkEmpty(tf_code1) && checkEmpty(tf_studentName1) && checkEmpty(tf_paid1) && checkEmpty(tf_discount1)) {
                // get the selected book
                book_name = cb_book1.getSelectedItem().toString();
                student_code = Integer.parseInt(tf_code1.getText());
                student_name = tf_studentName1.getText();
                level_name = cb_level1.getSelectedItem().toString();
                amount_paid = Integer.parseInt(tf_paid1.getText());
                discount = Integer.parseInt(tf_discount1.getText());
                rest = Integer.parseInt(tf_rest1.getText());
                total = Integer.parseInt(tf_total1.getText());
                date = getDate();
                time = getTime();
                // check if the total value entered is bigger than the total or not
                if (discount + amount_paid > total) {
                    makeRed(tf_paid1);
                    makeRed(tf_discount1);
                    jOptionPaneMessage("المبلغ المدفوع و الخصم اكبر من المجموع الكلي بفارق " + ((discount + amount_paid) - total), 2);
                } else {

                    // adding information to pay for book
                    try {
                        PreparedStatement stmt = con.prepareStatement("INSERT INTO pay_for_book VALUES (?,?,?,?,?,?,?,?,?,?)");
                        stmt.setInt(1, student_code);
                        stmt.setString(2, level_name);
                        stmt.setString(3, book_name);
                        stmt.setString(4, student_name);
                        stmt.setInt(5, amount_paid);
                        stmt.setInt(6, discount);
                        stmt.setInt(7, rest);
                        stmt.setString(8, date);
                        stmt.setString(9, time);
                        stmt.setString(10, "لم يستلم");
                        stmt.execute();

                        // increase the sold by one
                        PreparedStatement stmt2 = con.prepareStatement("update student_book set sold=sold+1 where level_name=? and book_name=?");
                        stmt2.setString(1, level_name);
                        stmt2.setString(2, book_name);
                        stmt2.executeUpdate();
                        addMessage();
                        recordEvent("اضافة", "بيع مذكرة", "قام الطالب " + student_name + "بشراء المذكرة " + book_name + "في الفرقة " + level_name + "ودفع مبلغ " + amount_paid);
                        cleanAfterAddDeleteUpdateBook();
                    } catch (SQLException ex) {
                        handleSqlExceptions(ex.getErrorCode());
                    }
                }
            }
        }
    }//GEN-LAST:event_tf_discount1KeyPressed

    private void tf_discount1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_discount1KeyTyped
        textFieldValidation(tf_discount1, evt.getKeyChar(), evt);
    }//GEN-LAST:event_tf_discount1KeyTyped

    private void tf_paid1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_paid1FocusGained
        FocusLostOrGained(tf_paid1);
        tf_paid1.setText("");
    }//GEN-LAST:event_tf_paid1FocusGained

    private void tf_paid1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_paid1FocusLost
        FocusLostOrGained(tf_paid1);
        if (!tf_paid1.getText().equals("") && !tf_discount1.getText().equals("")) {
            int total = Integer.parseInt(tf_total1.getText());
            int paid = Integer.parseInt(tf_paid1.getText());
            int discount = Integer.parseInt(tf_discount1.getText());
            int rest = total - (paid + discount);
            tf_rest1.setText(String.valueOf(rest));
        } else {
            tf_paid1.setText("0");
            tf_discount1.setText("0");
        }
    }//GEN-LAST:event_tf_paid1FocusLost

    private void tf_paid1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_paid1KeyPressed
        if (enter(evt.getKeyChar())) {
            tf_discount1.requestFocus(true);
        }
    }//GEN-LAST:event_tf_paid1KeyPressed

    private void tf_paid1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_paid1KeyTyped
        textFieldValidation(tf_paid1, evt.getKeyChar(), evt);
    }//GEN-LAST:event_tf_paid1KeyTyped

    private void cb_book1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_book1ItemStateChanged
        PreparedStatement stmt;
        ResultSet resultSet;
        if (checkEmpty(cb_book1) && checkEmpty(cb_level1)) {
            String level_name = cb_level1.getSelectedItem().toString();
            String book_name = cb_book1.getSelectedItem().toString();

            int book_cost = -1;
            try {
                stmt = con.prepareStatement("select book_cost from student_book where level_name=? and book_name=?");
                stmt.setString(1, level_name);
                stmt.setString(2, book_name);
                resultSet = stmt.executeQuery();

                while (resultSet.next()) {
                    book_cost = resultSet.getInt("book_cost");
                }
                tf_total1.setText(String.valueOf(book_cost));

            } catch (SQLException ex) {
                handleSqlExceptions(ex.getErrorCode());
            }
        }

    }//GEN-LAST:event_cb_book1ItemStateChanged

    private void lst_searchNames1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lst_searchNames1ValueChanged
        tf_studentName1.setText(lst_searchNames1.getSelectedValue());
        pl_searchNames1.setVisible(false);
    }//GEN-LAST:event_lst_searchNames1ValueChanged

    private void cb_monthItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_monthItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_monthItemStateChanged

    private void btn_delete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delete1ActionPerformed
        if (adminAccept()) {
            if (checkEmpty(cb_level1) && checkEmpty(tf_code1) && checkEmpty(cb_book1)) {
                int student_code = Integer.parseInt(tf_code1.getText());
                String level_name = cb_level1.getSelectedItem().toString();
                String book_name = cb_book1.getSelectedItem().toString();
                PreparedStatement stmt, stmt2;

                try {
                    stmt = con.prepareStatement("delete from pay_for_book where student_code=? and level_name=? and book_name=?");
                    //************************** to delete ******************
                    stmt.setInt(1, student_code);
                    stmt.setString(2, level_name);
                    stmt.setString(3, book_name);
                    stmt.execute();

                    stmt2 = con.prepareStatement("update student_book set sold=sold-1 where level_name=? and book_name=?");
                    stmt2.setString(1, level_name);
                    stmt2.setString(2, book_name);
                    stmt2.execute();
                    deleteMessage();
                    recordEvent("حذف", "حذف بيع مذكرة", "حذف بيع مذكرة للطالب " + tf_studentName1 + "اسم المذكره " + book_name + "في الفرقة " + level_name);
                    cleanAfterAddDeleteUpdateBook();
                } catch (SQLException ex) {
                    handleSqlExceptions(ex.getErrorCode());
                }

            }
        }

    }//GEN-LAST:event_btn_delete1ActionPerformed

    private void btn_search1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_search1ActionPerformed
        if (checkEmpty(cb_level1) && checkEmpty(cb_book1) && checkEmpty(tf_code1) && checkEmpty(tf_studentName1)) {
            String level_name = cb_level1.getSelectedItem().toString();
            String book_name = cb_book1.getSelectedItem().toString();
            int Student_code = Integer.parseInt(tf_code1.getText());
            int paid = -1;
            int discount = -1;
            int rest = -1;
            String recieve = "";
            PreparedStatement stmt;
            ResultSet resultSet;
            try {
                stmt = con.prepareStatement("select * from pay_for_book where level_name=? and student_code=? and book_name=?");
                stmt.setString(1, level_name);
                stmt.setInt(2, Student_code);
                stmt.setString(3, book_name);
                resultSet = stmt.executeQuery();
                while (resultSet.next()) {
                    paid = (resultSet.getInt("amount_paid"));
                    discount = (resultSet.getInt("discount"));
                    rest = (resultSet.getInt("rest"));
                    recieve = resultSet.getString("recieve");

                }
                if (paid != (-1)) {
                    tf_paid1.setText(String.valueOf(paid));
                    tf_discount1.setText(String.valueOf(discount));
                    tf_rest1.setText(String.valueOf(rest));
                    tf_recieve.setText(recieve);

                    btn_update1.setEnabled(true);
                    btn_delete1.setEnabled(true);
                    btn_recieve.setEnabled(true);
                    btn_add1.setEnabled(false);
                    btn_search1.setEnabled(false);
                    cb_level1.setEnabled(false);
                    cb_book1.setEnabled(false);
                    tf_studentName1.setEnabled(false);
                    tf_code1.setEnabled(false);

                } else {
                    JOptionPane.showMessageDialog(null, "لم يقم هذا الطالب  بشراء هذة المذكرة");
                }
            } catch (SQLException ex) {
                handleSqlExceptions(ex.getErrorCode());
            }
        }
    }//GEN-LAST:event_btn_search1ActionPerformed

    private void btn_clean1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clean1ActionPerformed
        cleanAfterAddDeleteUpdateBook();
    }//GEN-LAST:event_btn_clean1ActionPerformed

    private void btn_search2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_search2ActionPerformed
        if (checkEmpty(cb_level2) && checkEmpty(cb_month1)) {
            String level = cb_level2.getSelectedItem().toString();
            String month = cb_month1.getSelectedItem().toString();
            try {
                PreparedStatement stmt2 = con.prepareStatement("select count(student_code) from student "
                        + "where student_status!=? and level_name=? and student_code not "
                        + "in(select student_code from pay_for_month where month_name=? and level_name=?)");
                stmt2.setString(1, "موقوف");
                stmt2.setString(2, level);
                stmt2.setString(3, month);
                stmt2.setString(4, level);
                ResultSet set2 = stmt2.executeQuery();
                set2.next();

                PreparedStatement stmt = con.prepareStatement("select * from student "
                        + "where student_status!=? and level_name=? and student_code not "
                        + "in(select student_code from pay_for_month where month_name=? and level_name=?)"
                        + " order by student_code asc");
                stmt.setString(1, "موقوف");
                stmt.setString(2, level);
                stmt.setString(3, month);
                stmt.setString(4, level);
                ResultSet set = stmt.executeQuery();

                DefaultTableModel dm = new DefaultTableModel();

                if (chb_address.isSelected()) {
                    dm.addColumn("العنوان");
                }
                if (chb_parentName.isSelected()) {
                    dm.addColumn("اسم ولي الامر");
                }
                if (chb_parentJob.isSelected()) {
                    dm.addColumn("مهنة ولي الامر");
                }
                if (chb_parentPhone.isSelected()) {
                    dm.addColumn("رقم ولي الامر");
                }
                if (chb_studentPhone.isSelected()) {
                    dm.addColumn("رقم الهاتف");
                }
                if (chb_level.isSelected()) {
                    dm.addColumn("الفرقة");
                }
                if (chb_studentName.isSelected()) {
                    dm.addColumn("الاسم");
                }
                dm.addColumn("الكود");

                while (set.next()) {
                    ArrayList<String> r2 = new ArrayList<>();

                    if (chb_address.isSelected()) {
                        r2.add(set.getString(4));
                    }
                    if (chb_parentJob.isSelected()) {
                        r2.add(set.getString(7));
                    }
                    if (chb_parentName.isSelected()) {
                        r2.add(set.getString(5));
                    }
                    if (chb_parentPhone.isSelected()) {
                        r2.add(set.getString(6));
                    }
                    if (chb_studentPhone.isSelected()) {
                        r2.add(set.getString(3));
                    }
                    if (chb_level.isSelected()) {
                        r2.add(set.getString(9));
                    }
                    if (chb_studentName.isSelected()) {
                        r2.add(set.getString(2));
                    }
                    r2.add(set.getString(1));

                    String r[] = r2.toArray(new String[r2.size()]);
                    dm.addRow(r);
                }
                lb_didNotPayNumber.setText(set2.getString(1));
                t_viewStudentData.setModel(dm);
                changeTheWidthOfTableColumn(t_viewStudentData, 5, 175);
                changeTheWidthOfTableColumn(t_viewStudentData, 6, 175);
                changeTheWidthOfTableColumn(t_viewStudentData, 7, 50);

            } catch (SQLException ex) {
                handleSqlExceptions(ex.getErrorCode());
            }

        }
    }//GEN-LAST:event_btn_search2ActionPerformed

    private void cb_level2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cb_level2FocusGained
        FocusLostOrGained(cb_level2);
    }//GEN-LAST:event_cb_level2FocusGained

    private void cb_level2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cb_level2FocusLost
        FocusLostOrGained(cb_level2);
    }//GEN-LAST:event_cb_level2FocusLost

    private void cb_month1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cb_month1FocusGained
        FocusLostOrGained(cb_month1);
    }//GEN-LAST:event_cb_month1FocusGained

    private void cb_month1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cb_month1FocusLost
        FocusLostOrGained(cb_month1);
    }//GEN-LAST:event_cb_month1FocusLost

    private void btn_add2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_add2ActionPerformed
        if (checkEmpty(tf_person) && checkEmpty(tf_reason) && checkEmpty(cb_month2) && checkEmpty(tf_amount)) {
            String person_name = tf_person.getText();
            String date = getDate();
            String month = cb_month2.getSelectedItem().toString();
            String reason = tf_reason.getText();
            int money = Integer.valueOf(tf_amount.getText());

            try {

                PreparedStatement stmt = con.prepareStatement("insert into external_money values(?,?,?,?,?)");

                stmt.setString(1, person_name);
                stmt.setString(2, reason);
                stmt.setInt(3, money);
                stmt.setString(4, date);
                stmt.setString(5, month);

                stmt.executeUpdate();

                addMessage();
                recordEvent("اضافة", "مصاريف خارجية", "تم خروج مبلغ " + money + "للشخص " + person_name + "بسبب " + reason);
                loadExternalMoney(t_externalMoney, month);
                cleanAfterAddOrDeleteExternalMoney();
            } catch (SQLException ex) {
                handleSqlExceptions(ex.getErrorCode());
            }

        }
    }//GEN-LAST:event_btn_add2ActionPerformed

    private void tf_amountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_amountKeyTyped
        textFieldValidation(tf_amount, evt.getKeyChar(), evt);
    }//GEN-LAST:event_tf_amountKeyTyped

    private void cb_month2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cb_month2FocusGained
        FocusLostOrGained(cb_month2);
    }//GEN-LAST:event_cb_month2FocusGained

    private void cb_month2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cb_month2FocusLost
        FocusLostOrGained(cb_month2);
    }//GEN-LAST:event_cb_month2FocusLost

    private void tf_personFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_personFocusGained
        FocusLostOrGained(tf_person);
    }//GEN-LAST:event_tf_personFocusGained

    private void tf_personFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_personFocusLost
        FocusLostOrGained(tf_person);
    }//GEN-LAST:event_tf_personFocusLost

    private void tf_reasonFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_reasonFocusGained
        FocusLostOrGained(tf_reason);
    }//GEN-LAST:event_tf_reasonFocusGained

    private void tf_reasonFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_reasonFocusLost
        FocusLostOrGained(tf_reason);
    }//GEN-LAST:event_tf_reasonFocusLost

    private void tf_amountFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_amountFocusGained
        FocusLostOrGained(tf_amount);
    }//GEN-LAST:event_tf_amountFocusGained

    private void tf_amountFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_amountFocusLost
        FocusLostOrGained(tf_amount);
    }//GEN-LAST:event_tf_amountFocusLost

    private void cb_month2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_month2ItemStateChanged
        String month = cb_month2.getSelectedItem().toString();
        loadExternalMoney(t_externalMoney, month);
    }//GEN-LAST:event_cb_month2ItemStateChanged

    private void tf_personKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_personKeyPressed
        if (enter(evt.getKeyChar())) {
            tf_reason.requestFocus();
        }
    }//GEN-LAST:event_tf_personKeyPressed

    private void tf_reasonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_reasonKeyPressed
        if (enter(evt.getKeyChar())) {
            tf_amount.requestFocus();
        }
    }//GEN-LAST:event_tf_reasonKeyPressed

    private void tf_amountKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_amountKeyPressed
        if (enter(evt.getKeyChar())) {
            String person_name = tf_person.getText();
            String date = getDate();
            String month = cb_month2.getSelectedItem().toString();
            String reason = tf_reason.getText();
            int money = Integer.valueOf(tf_amount.getText());

            try {

                PreparedStatement stmt = con.prepareStatement("insert into external_money values(?,?,?,?,?)");

                stmt.setString(1, person_name);
                stmt.setString(2, reason);
                stmt.setInt(3, money);
                stmt.setString(4, date);
                stmt.setString(5, month);

                stmt.executeUpdate();

                addMessage();
                recordEvent("اضافة", "مصاريف خارجية", "تم خروج مبلغ " + money + "للشخص " + person_name + "بسبب " + reason);
                loadExternalMoney(t_externalMoney, month);
                cleanAfterAddOrDeleteExternalMoney();
            } catch (SQLException ex) {
                handleSqlExceptions(ex.getErrorCode());
            }

        }
    }//GEN-LAST:event_tf_amountKeyPressed

    private void btn_delete2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delete2ActionPerformed
        if (adminAccept()) {
            String month = cb_month2.getSelectedItem().toString();
            String person = tf_person.getText();
            String reason = tf_reason.getText();
            int amount = Integer.parseInt(tf_amount.getText());
            try {
                PreparedStatement stmt = con.prepareStatement("delete from external_money where month=? and person_name=? and reason=? and money=?");
                stmt.setString(1, month);
                stmt.setString(2, person);
                stmt.setString(3, reason);
                stmt.setInt(4, amount);
                stmt.execute();
                recordEvent("حذف", "المصاريف الخارجية", "تم حذف القيمة " + amount + "للشخص " + person + "بسبب " + reason);
                JOptionPane.showMessageDialog(null, "تم الحذف بنجاح");
                loadExternalMoney(t_externalMoney, month);
                cleanAfterAddOrDeleteExternalMoney();
            } catch (SQLException ex) {
                handleSqlExceptions(ex.getErrorCode());
            }
        }
    }//GEN-LAST:event_btn_delete2ActionPerformed

    private void t_externalMoneyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_externalMoneyMouseClicked
        FocusLostOrGained(tf_person);
        FocusLostOrGained(tf_amount);
        FocusLostOrGained(tf_reason);
        FocusLostOrGained(cb_month2);
        btn_delete2.setEnabled(true);
        btn_add2.setEnabled(false);
        tf_amount.setEnabled(false);
        tf_reason.setEnabled(false);
        tf_person.setEnabled(false);
        cb_month2.setEnabled(false);
        TableModel model1 = t_externalMoney.getModel();
        int[] index = t_externalMoney.getSelectedRows();
        for (int i = 0; i < index.length; i++) {
            tf_amount.setText(String.valueOf(model1.getValueAt(index[i], 1)));
            tf_reason.setText(String.valueOf(model1.getValueAt(index[i], 2)));
            tf_person.setText(String.valueOf(model1.getValueAt(index[i], 3)));
        }
    }//GEN-LAST:event_t_externalMoneyMouseClicked

    private void btn_clean2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clean2ActionPerformed
        cleanAfterAddOrDeleteExternalMoney();
    }//GEN-LAST:event_btn_clean2ActionPerformed

    private void btn_search3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_search3ActionPerformed

        // check if choose the day
        if (checkEmpty(dc_day)) {
            String day = ((JTextField) dc_day.getDateEditor().getUiComponent()).getText();                                        // get the last date in the database
            int total_avilable;
            int total_out = 0;
            int total_in = 0;
            int total_book = 0;
            // get the internal money data and total income
            try {
                PreparedStatement stmt = con.prepareStatement("select student_code,level_name,month_name,"
                        + "student_name,amount_paid,discount,rest,paid_date,paid_time"
                        + " from pay_for_month "
                        + "where paid_date between cast(? as Date)and cast(? as Date)");
                stmt.setString(1, day);
                stmt.setString(2, day);
                ResultSet set = stmt.executeQuery();

                DefaultTableModel dm = new DefaultTableModel();
                if (chb_time.isSelected()) {
                    dm.addColumn("الوقت");
                }

                if (chb_day.isSelected()) {
                    dm.addColumn("اليوم");
                }

                if (chb_monthName.isSelected()) {
                    dm.addColumn(" اسم الشهر");
                }

                if (chb_monthRest.isSelected()) {
                    dm.addColumn(" باقي الشهر");
                }

                if (chb_monthDiscount.isSelected()) {
                    dm.addColumn("خصم الشهر");
                }

                if (chb_monthCost.isSelected()) {
                    dm.addColumn(" المبلغ المدفوع");
                }

                if (chb_Level.isSelected()) {
                    dm.addColumn("الفرقة");
                }

                if (chb_name.isSelected()) {
                    dm.addColumn("الاسم");
                }

                if (chb_code.isSelected()) {
                    dm.addColumn("الكود");
                }

                while (set.next()) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    if (chb_time.isSelected()) {
                        arrayList.add(set.getString("paid_time"));
                    }

                    if (chb_day.isSelected()) {
                        arrayList.add(set.getString("paid_date"));
                    }

                    if (chb_monthName.isSelected()) {
                        arrayList.add(set.getString("month_name"));
                    }

                    if (chb_monthRest.isSelected()) {
                        arrayList.add(set.getString("rest"));
                    }

                    if (chb_monthDiscount.isSelected()) {
                        arrayList.add(set.getString("discount"));
                    }

                    if (chb_monthCost.isSelected()) {
                        arrayList.add(set.getString("amount_paid"));
                    }

                    if (chb_Level.isSelected()) {
                        arrayList.add(set.getString("level_name"));
                    }

                    if (chb_name.isSelected()) {
                        arrayList.add(set.getString("student_name"));
                    }

                    if (chb_code.isSelected()) {
                        arrayList.add(set.getString("student_code"));
                    }
                    String r[] = arrayList.toArray(new String[arrayList.size()]);
                    dm.addRow(r);

                    // this to get the sum of the amount paid in specific day "اجمالي المصاريف الوارده" 
                    PreparedStatement stmt2 = con.prepareStatement("select sum(amount_paid)"
                            + " from pay_for_month "
                            + "where paid_date between cast(? as Date)and cast(? as Date)");
                    stmt2.setString(1, day);
                    stmt2.setString(2, day);
                    ResultSet set2 = stmt2.executeQuery();
                    while (set2.next()) {
                        total_in = set2.getInt(1);
                    }
                }

                t_InternalMoney.setModel(dm);
                changeTheWidthOfTableColumn(t_InternalMoney, 8, 50);
                changeTheWidthOfTableColumn(t_InternalMoney, 7, 150);
                tf_totalIncome.setText(String.valueOf(total_in));
                printTableDetermination = 1;

            } catch (SQLException ex) {
                handleSqlExceptions(ex.getErrorCode());
            }

            //************************************************** To show table of external money and total outcome  ******************************
            try {
                PreparedStatement stmt = con.prepareStatement("select person_name,reason,money,month,paid_date from external_money where paid_date between cast(? as Date)and cast(? as Date)");
                stmt.setString(1, day);
                stmt.setString(2, day);
                ResultSet set = stmt.executeQuery();

                DefaultTableModel dm = new DefaultTableModel();
                dm.addColumn("الشهر");
                dm.addColumn("التاريخ");
                dm.addColumn("المبلغ المدفوع");
                dm.addColumn("سبب الدفع");
                dm.addColumn("الشخص المدفوع لة");

                while (set.next()) {
                    String r[] = {set.getString("month"), set.getString("paid_date"), set.getString("money"),
                        set.getString("reason"), set.getString("person_name")};
                    dm.addRow(r);
                }

                // get the total external money     "اجمالي المصاريف الخارجه"
                PreparedStatement stmt2 = con.prepareStatement("select sum(money) from external_money where paid_date between cast(? as Date)and cast(? as Date)");
                stmt2.setString(1, day);
                stmt2.setString(2, day);
                ResultSet set2 = stmt2.executeQuery();
                while (set2.next()) {
                    total_out = set2.getInt(1);
                }
                t_externalMoneyData.setModel(dm);
                tf_totalOutcome.setText(String.valueOf(total_out));

            } catch (SQLException ex) {
                handleSqlExceptions(ex.getErrorCode());
            }

            //************************************** this to get the book money مصاريف المذكرات ****************
            try {
                PreparedStatement stmt = con.prepareStatement("select student_code,level_name,book_name,"
                        + "student_name,amount_paid,discount,rest,paid_date,paid_time"
                        + " from pay_for_book "
                        + "where paid_date between cast(? as Date)and cast(? as Date)");
                stmt.setString(1, day);
                stmt.setString(2, day);
                ResultSet set = stmt.executeQuery();

                DefaultTableModel dm = new DefaultTableModel();
                if (chb_time.isSelected()) {
                    dm.addColumn("الوقت");
                }

                if (chb_day.isSelected()) {
                    dm.addColumn("اليوم");
                }

                if (chb_monthName.isSelected()) {
                    dm.addColumn(" اسم المذكرة");
                }

                if (chb_monthRest.isSelected()) {
                    dm.addColumn(" باقي المذكرة");
                }

                if (chb_monthDiscount.isSelected()) {
                    dm.addColumn("خصم المذكرة");
                }

                if (chb_monthCost.isSelected()) {
                    dm.addColumn(" المبلغ المدفوع");
                }

                if (chb_Level.isSelected()) {
                    dm.addColumn("الفرقة");
                }

                if (chb_name.isSelected()) {
                    dm.addColumn("الاسم");
                }

                if (chb_code.isSelected()) {
                    dm.addColumn("الكود");
                }

                while (set.next()) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    if (chb_time.isSelected()) {
                        arrayList.add(set.getString("paid_time"));
                    }

                    if (chb_day.isSelected()) {
                        arrayList.add(set.getString("paid_date"));
                    }

                    if (chb_monthName.isSelected()) {
                        arrayList.add(set.getString("book_name"));
                    }

                    if (chb_monthRest.isSelected()) {
                        arrayList.add(set.getString("rest"));
                    }

                    if (chb_monthDiscount.isSelected()) {
                        arrayList.add(set.getString("discount"));
                    }

                    if (chb_monthCost.isSelected()) {
                        arrayList.add(set.getString("amount_paid"));
                    }

                    if (chb_Level.isSelected()) {
                        arrayList.add(set.getString("level_name"));
                    }

                    if (chb_name.isSelected()) {
                        arrayList.add(set.getString("student_name"));
                    }

                    if (chb_code.isSelected()) {
                        arrayList.add(set.getString("student_code"));
                    }
                    String r[] = arrayList.toArray(new String[arrayList.size()]);
                    dm.addRow(r);

                    // this to get the sum of the amount paid in specific day "اجمالي المصاريف الوارده" 
                    PreparedStatement stmt2 = con.prepareStatement("select sum(amount_paid)"
                            + " from pay_for_book "
                            + "where paid_date between cast(? as Date)and cast(? as Date)");
                    stmt2.setString(1, day);
                    stmt2.setString(2, day);
                    ResultSet set2 = stmt2.executeQuery();
                    while (set2.next()) {
                        total_book = set2.getInt(1);
                    }
                }

                t_BookMoney.setModel(dm);
                changeTheWidthOfTableColumn(t_BookMoney, 8, 50);
                changeTheWidthOfTableColumn(t_BookMoney, 7, 150);
                tf_BookIncome.setText(String.valueOf(total_book));

            } catch (SQLException ex) {
                handleSqlExceptions(ex.getErrorCode());
            }

            // get the remain money with the secretary "المبلغ الحالي"
            total_avilable = total_in + total_book - total_out;
            tf_totalAvilable.setText(String.valueOf(total_avilable));

            if (tf_totalIncome.getText().equals("0") && tf_totalOutcome.getText().equals("0") && tf_totalAvilable.getText().equals("0")&& tf_BookIncome.getText().equals("0")) {
                DefaultTableModel defaultTableModel = new DefaultTableModel();
                t_InternalMoney.setModel(defaultTableModel);
                t_externalMoneyData.setModel(defaultTableModel);
            }
        }
    }//GEN-LAST:event_btn_search3ActionPerformed

    private void dc_dayFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dc_dayFocusGained
        FocusLostOrGained(dc_day);
    }//GEN-LAST:event_dc_dayFocusGained

    private void dc_dayFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dc_dayFocusLost
        FocusLostOrGained(dc_day);
    }//GEN-LAST:event_dc_dayFocusLost

    private void btn_printInternalMoneyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_printInternalMoneyActionPerformed
        String title = "";
        if (printTableDetermination == -1) {
            jOptionPaneMessage("لا يوجد بيانات لطباعتها الرجاء البحث اولا", 0);
        } else {
            String day = ((JTextField) dc_day.getDateEditor().getUiComponent()).getText();
            if (printTableDetermination == 1) {
                title = "تقرير المصاريف الوارده من المصاريف الشهريه يوم " + " \"" + day + "\"";
            }
            makeReport(t_InternalMoney, title);
        }
    }//GEN-LAST:event_btn_printInternalMoneyActionPerformed

    private void btn_printExternalMoneyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_printExternalMoneyActionPerformed
        String title = "";
        if (printTableDetermination == -1) {
            jOptionPaneMessage("لا يوجد بيانات لطباعتها الرجاء البحث اولا", 0);
        } else {
            String day = ((JTextField) dc_day.getDateEditor().getUiComponent()).getText();
            if (printTableDetermination == 1) {
                title = "تقرير المصاريف الخارجه يوم " + " \"" + day + "\"";
            }
            makeReport(t_externalMoney, title);
        }
    }//GEN-LAST:event_btn_printExternalMoneyActionPerformed

    private void cb_monthKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cb_monthKeyPressed
        if (enter(evt.getKeyChar())) {
            tf_paid.requestFocus(true);
        }
    }//GEN-LAST:event_cb_monthKeyPressed

    private void tf_studentNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_studentNameKeyPressed
        if (enter(evt.getKeyChar())) {
            tf_paid.requestFocus(true);
        }
    }//GEN-LAST:event_tf_studentNameKeyPressed

    private void tf_discountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_discountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_discountActionPerformed

    private void cb_book1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cb_book1KeyPressed
        if (enter(evt.getKeyChar())) {
            tf_paid1.requestFocus(true);
        }
    }//GEN-LAST:event_cb_book1KeyPressed

    private void btn_search5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_search5ActionPerformed
        if (checkEmpty(cb_level3) && checkEmpty(cb_month3)) {
            String level = cb_level3.getSelectedItem().toString();
            String month = cb_month3.getSelectedItem().toString();
            try {
                // get the cound of student paid
                PreparedStatement stmt2 = con.prepareStatement("select count(student_code) from student "
                        + "where level_name=? and student_code "
                        + "in(select student_code from pay_for_month "
                        + "where month_name=? and level_name=?)");
                stmt2.setString(1, level);
                stmt2.setString(2, month);
                stmt2.setString(3, level);
                ResultSet set2 = stmt2.executeQuery();
                set2.next();
                //get the data of student paid
                PreparedStatement stmt = con.prepareStatement("select * from student "
                        + "where level_name=? and student_code "
                        + "in(select student_code from pay_for_month where month_name=? and level_name=?)"
                        + " order by student_code asc");
                stmt.setString(1, level);
                stmt.setString(2, month);
                stmt.setString(3, level);
                ResultSet set = stmt.executeQuery();

                DefaultTableModel dm = new DefaultTableModel();

                if (chb_address1.isSelected()) {
                    dm.addColumn("العنوان");
                }
                if (chb_parentName1.isSelected()) {
                    dm.addColumn("اسم ولي الامر");
                }
                if (chb_parentJob1.isSelected()) {
                    dm.addColumn("مهنة ولي الامر");
                }
                if (chb_parentPhone1.isSelected()) {
                    dm.addColumn("رقم ولي الامر");
                }
                if (chb_studentPhone1.isSelected()) {
                    dm.addColumn("رقم الهاتف");
                }
                if (chb_level1.isSelected()) {
                    dm.addColumn("الفرقة");
                }
                if (chb_studentName1.isSelected()) {
                    dm.addColumn("الاسم");
                }
                dm.addColumn("الكود");

                while (set.next()) {
                    ArrayList<String> r2 = new ArrayList<>();

                    if (chb_address1.isSelected()) {
                        r2.add(set.getString(4));
                    }
                    if (chb_parentJob1.isSelected()) {
                        r2.add(set.getString(7));
                    }
                    if (chb_parentName1.isSelected()) {
                        r2.add(set.getString(5));
                    }
                    if (chb_parentPhone1.isSelected()) {
                        r2.add(set.getString(6));
                    }
                    if (chb_studentPhone1.isSelected()) {
                        r2.add(set.getString(3));
                    }
                    if (chb_level1.isSelected()) {
                        r2.add(set.getString(9));
                    }
                    if (chb_studentName1.isSelected()) {
                        r2.add(set.getString(2));
                    }
                    r2.add(set.getString(1));

                    String r[] = r2.toArray(new String[r2.size()]);
                    dm.addRow(r);
                }
                lb_payNumber.setText(set2.getString(1));
                t_viewStudentData1.setModel(dm);
                changeTheWidthOfTableColumn(t_viewStudentData1, 5, 175);
                changeTheWidthOfTableColumn(t_viewStudentData1, 6, 175);
                changeTheWidthOfTableColumn(t_viewStudentData1, 7, 50);

            } catch (SQLException ex) {
                handleSqlExceptions(ex.getErrorCode());
            }

        }
    }//GEN-LAST:event_btn_search5ActionPerformed

    private void cb_level3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cb_level3FocusGained
        FocusLostOrGained(cb_level3);
    }//GEN-LAST:event_cb_level3FocusGained

    private void cb_level3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cb_level3FocusLost
        FocusLostOrGained(cb_level3);
    }//GEN-LAST:event_cb_level3FocusLost

    private void cb_month3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cb_month3FocusGained
        FocusLostOrGained(cb_month2);
    }//GEN-LAST:event_cb_month3FocusGained

    private void cb_month3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cb_month3FocusLost
        FocusLostOrGained(cb_month2);
    }//GEN-LAST:event_cb_month3FocusLost

    private void btn_printBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_printBillActionPerformed
        if (checkEmpty(cb_level) && checkEmpty(cb_month) && checkEmpty(tf_code) && checkEmpty(tf_studentName) && checkEmpty(tf_paid) && checkEmpty(tf_discount)) {
            int student_code = Integer.parseInt(tf_code.getText());
            String student_name = tf_studentName.getText();
            String level_name = cb_level.getSelectedItem().toString();
            String month_name = cb_month.getSelectedItem().toString();
            int discount = Integer.parseInt(tf_discount.getText());
            int total = Integer.parseInt(tf_total.getText());
            String date = getDate();

            printJ(student_name, student_code, level_name, month_name, date, discount, total);
        }

    }//GEN-LAST:event_btn_printBillActionPerformed

    private void btn_printInternalMoney1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_printInternalMoney1ActionPerformed
        String title;
        String level = cb_level3.getSelectedItem().toString();
        String month = cb_month3.getSelectedItem().toString();
        title = " مصاريف  طلاب الصف" + " \"" + level + " في شهر" + " \"" + month + "\" ";
        makeReport(t_viewStudentData1, title);

    }//GEN-LAST:event_btn_printInternalMoney1ActionPerformed

    private void btn_printInternalMoney2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_printInternalMoney2ActionPerformed
        String title;
        String level = cb_level3.getSelectedItem().toString();
        String month = cb_month3.getSelectedItem().toString();
        title = " المتخلفين عن الدفع في الصف" + " \"" + level + " في شهر" + " \"" + month + "\" ";
        makeReport(t_viewStudentData, title);

    }//GEN-LAST:event_btn_printInternalMoney2ActionPerformed

    private void btn_dialyReportMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_dialyReportMouseEntered
        if (pl_dailyReport.isVisible() != true) {
            hoverInMouseMotion(btn_dialyReport);
        }
    }//GEN-LAST:event_btn_dialyReportMouseEntered

    private void btn_dialyReportMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_dialyReportMouseExited
        if (pl_dailyReport.isVisible() != true) {
            defaultAfterHover(btn_dialyReport);
        }
    }//GEN-LAST:event_btn_dialyReportMouseExited

    private void btn_dialyReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dialyReportActionPerformed
        // view only month Cost panel
        pl_monthCost.setVisible(false);
        pl_bookCost.setVisible(false);
        pl_didNotPayYet.setVisible(false);
        pl_externalMoney.setVisible(false);
        pl_dailyReport.setVisible(true);
        pl_paied.setVisible(false);
        pl_paiedBook.setVisible(false);
        pl_didNotPayYetBook.setVisible(false);

        // hover only Month Cost button
        hoverInMouseClicked(btn_dialyReport);
        defaultAfterHover(btn_monthCost);
        defaultAfterHover(btn_bookCost);
        defaultAfterHover(btn_didNotPayYet);
        defaultAfterHover(btn_externalMoney);
        defaultAfterHover(btn_paied);
        defaultAfterHover(btn_didNotPayYetBook);
        defaultAfterHover(btn_paiedBook);
    }//GEN-LAST:event_btn_dialyReportActionPerformed

    private void btn_externalMoneyMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_externalMoneyMouseEntered
        if (pl_externalMoney.isVisible() != true) {
            hoverInMouseMotion(btn_externalMoney);
        }
    }//GEN-LAST:event_btn_externalMoneyMouseEntered

    private void btn_externalMoneyMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_externalMoneyMouseExited
        if (pl_externalMoney.isVisible() != true) {
            defaultAfterHover(btn_externalMoney);
        }
    }//GEN-LAST:event_btn_externalMoneyMouseExited

    private void btn_externalMoneyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_externalMoneyActionPerformed
        // view only month Cost panel
        pl_monthCost.setVisible(false);
        pl_bookCost.setVisible(false);
        pl_didNotPayYet.setVisible(false);
        pl_externalMoney.setVisible(true);
        pl_dailyReport.setVisible(false);
        pl_paied.setVisible(false);
        pl_paiedBook.setVisible(false);
        pl_didNotPayYetBook.setVisible(false);

        // hover only Month Cost button
        hoverInMouseClicked(btn_externalMoney);
        defaultAfterHover(btn_monthCost);
        defaultAfterHover(btn_bookCost);
        defaultAfterHover(btn_didNotPayYet);
        defaultAfterHover(btn_dialyReport);
        defaultAfterHover(btn_paied);
        defaultAfterHover(btn_didNotPayYetBook);
        defaultAfterHover(btn_paiedBook);
    }//GEN-LAST:event_btn_externalMoneyActionPerformed

    private void btn_didNotPayYetBookMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_didNotPayYetBookMouseEntered
        if (pl_didNotPayYetBook.isVisible() != true) {
            hoverInMouseMotion(btn_didNotPayYetBook);
        }
    }//GEN-LAST:event_btn_didNotPayYetBookMouseEntered

    private void btn_didNotPayYetBookMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_didNotPayYetBookMouseExited
        if (pl_didNotPayYetBook.isVisible() != true) {
            defaultAfterHover(btn_didNotPayYetBook);
        }
    }//GEN-LAST:event_btn_didNotPayYetBookMouseExited

    private void btn_didNotPayYetBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_didNotPayYetBookActionPerformed
        // view only month Cost panel
        pl_monthCost.setVisible(false);
        pl_bookCost.setVisible(false);
        pl_didNotPayYet.setVisible(false);
        pl_externalMoney.setVisible(false);
        pl_dailyReport.setVisible(false);
        pl_paied.setVisible(false);
        pl_paiedBook.setVisible(false);
        pl_didNotPayYetBook.setVisible(true);

        // hover only Month Cost button
        hoverInMouseClicked(btn_didNotPayYetBook);
        defaultAfterHover(btn_monthCost);
        defaultAfterHover(btn_didNotPayYet);
        defaultAfterHover(btn_externalMoney);
        defaultAfterHover(btn_dialyReport);
        defaultAfterHover(btn_paied);
        defaultAfterHover(btn_paiedBook);
        defaultAfterHover(btn_paiedBook);
    }//GEN-LAST:event_btn_didNotPayYetBookActionPerformed

    private void btn_paiedBookMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_paiedBookMouseEntered
        if (pl_paiedBook.isVisible() != true) {
            hoverInMouseMotion(btn_paiedBook);
        }
    }//GEN-LAST:event_btn_paiedBookMouseEntered

    private void btn_paiedBookMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_paiedBookMouseExited
        if (pl_paiedBook.isVisible() != true) {
            defaultAfterHover(btn_paiedBook);
        }
    }//GEN-LAST:event_btn_paiedBookMouseExited

    private void btn_paiedBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_paiedBookActionPerformed

        // view only month Cost panel
        pl_monthCost.setVisible(false);
        pl_bookCost.setVisible(false);
        pl_didNotPayYet.setVisible(false);
        pl_externalMoney.setVisible(false);
        pl_dailyReport.setVisible(false);
        pl_paied.setVisible(false);
        pl_paiedBook.setVisible(true);
        pl_didNotPayYetBook.setVisible(false);

        // hover only Month Cost button
        hoverInMouseClicked(btn_paiedBook);
        defaultAfterHover(btn_monthCost);
        defaultAfterHover(btn_didNotPayYet);
        defaultAfterHover(btn_externalMoney);
        defaultAfterHover(btn_dialyReport);
        defaultAfterHover(btn_paied);
        defaultAfterHover(btn_didNotPayYetBook);
        defaultAfterHover(btn_bookCost);

    }//GEN-LAST:event_btn_paiedBookActionPerformed

    private void btn_bookCostMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_bookCostMouseEntered
        if (pl_bookCost.isVisible() != true) {
            hoverInMouseMotion(btn_bookCost);
        }
    }//GEN-LAST:event_btn_bookCostMouseEntered

    private void btn_bookCostMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_bookCostMouseExited
        if (pl_bookCost.isVisible() != true) {
            defaultAfterHover(btn_bookCost);
        }
    }//GEN-LAST:event_btn_bookCostMouseExited

    private void btn_bookCostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_bookCostActionPerformed

        // view only month Cost panel
        pl_monthCost.setVisible(false);
        pl_bookCost.setVisible(true);
        pl_didNotPayYet.setVisible(false);
        pl_externalMoney.setVisible(false);
        pl_dailyReport.setVisible(false);
        pl_paied.setVisible(false);
        pl_paiedBook.setVisible(false);
        pl_didNotPayYetBook.setVisible(false);

        // hover only Month Cost button
        hoverInMouseClicked(btn_bookCost);
        defaultAfterHover(btn_monthCost);
        defaultAfterHover(btn_didNotPayYet);
        defaultAfterHover(btn_externalMoney);
        defaultAfterHover(btn_dialyReport);
        defaultAfterHover(btn_paied);
        defaultAfterHover(btn_didNotPayYetBook);
        defaultAfterHover(btn_paiedBook);
    }//GEN-LAST:event_btn_bookCostActionPerformed

    private void btn_didNotPayYetMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_didNotPayYetMouseEntered
        if (pl_didNotPayYet.isVisible() != true) {
            hoverInMouseMotion(btn_didNotPayYet);
        }
    }//GEN-LAST:event_btn_didNotPayYetMouseEntered

    private void btn_didNotPayYetMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_didNotPayYetMouseExited
        if (pl_didNotPayYet.isVisible() != true) {
            defaultAfterHover(btn_didNotPayYet);
        }
    }//GEN-LAST:event_btn_didNotPayYetMouseExited

    private void btn_didNotPayYetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_didNotPayYetActionPerformed
        // view only month Cost panel
        pl_monthCost.setVisible(false);
        pl_bookCost.setVisible(false);
        pl_didNotPayYet.setVisible(true);
        pl_externalMoney.setVisible(false);
        pl_dailyReport.setVisible(false);
        pl_paied.setVisible(false);
        pl_paiedBook.setVisible(false);
        pl_didNotPayYetBook.setVisible(false);

        // hover only Month Cost button
        hoverInMouseClicked(btn_didNotPayYet);
        defaultAfterHover(btn_monthCost);
        defaultAfterHover(btn_bookCost);
        defaultAfterHover(btn_externalMoney);
        defaultAfterHover(btn_dialyReport);
        defaultAfterHover(btn_paied);
        defaultAfterHover(btn_didNotPayYetBook);
        defaultAfterHover(btn_paiedBook);
    }//GEN-LAST:event_btn_didNotPayYetActionPerformed

    private void btn_paiedMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_paiedMouseEntered
        if (pl_paied.isVisible() != true) {
            hoverInMouseMotion(btn_paied);
        }
    }//GEN-LAST:event_btn_paiedMouseEntered

    private void btn_paiedMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_paiedMouseExited
        if (pl_paied.isVisible() != true) {
            defaultAfterHover(btn_paied);
        }
    }//GEN-LAST:event_btn_paiedMouseExited

    private void btn_paiedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_paiedActionPerformed
        // view only month Cost panel
        pl_didNotPayYet.setVisible(false);
        pl_dailyReport.setVisible(false);
        pl_monthCost.setVisible(false);
        pl_bookCost.setVisible(false);
        pl_externalMoney.setVisible(false);
        pl_paied.setVisible(true);
        pl_paiedBook.setVisible(false);
        pl_didNotPayYetBook.setVisible(false);

        // hover only Month Cost button
        hoverInMouseClicked(btn_paied);
        defaultAfterHover(btn_dialyReport);
        defaultAfterHover(btn_monthCost);
        defaultAfterHover(btn_bookCost);
        defaultAfterHover(btn_externalMoney);
        defaultAfterHover(btn_didNotPayYet);
        defaultAfterHover(btn_didNotPayYetBook);
        defaultAfterHover(btn_paiedBook);
    }//GEN-LAST:event_btn_paiedActionPerformed

    private void btn_monthCostMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_monthCostMouseEntered
        if (pl_monthCost.isVisible() != true) {
            hoverInMouseMotion(btn_monthCost);
        }
    }//GEN-LAST:event_btn_monthCostMouseEntered

    private void btn_monthCostMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_monthCostMouseExited
        if (pl_monthCost.isVisible() != true) {
            defaultAfterHover(btn_monthCost);
        }
    }//GEN-LAST:event_btn_monthCostMouseExited

    private void btn_monthCostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_monthCostActionPerformed

        // view only month Cost panel
        pl_monthCost.setVisible(true);
        pl_bookCost.setVisible(false);
        pl_didNotPayYet.setVisible(false);
        pl_externalMoney.setVisible(false);
        pl_dailyReport.setVisible(false);
        pl_paied.setVisible(false);
        pl_paiedBook.setVisible(false);
        pl_didNotPayYetBook.setVisible(false);

        // hover only Month Cost button
        hoverInMouseClicked(btn_monthCost);
        defaultAfterHover(btn_bookCost);
        defaultAfterHover(btn_didNotPayYet);
        defaultAfterHover(btn_externalMoney);
        defaultAfterHover(btn_dialyReport);
        defaultAfterHover(btn_paied);
        defaultAfterHover(btn_didNotPayYetBook);
        defaultAfterHover(btn_paiedBook);
    }//GEN-LAST:event_btn_monthCostActionPerformed

    private void btn_search4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_search4ActionPerformed
        if (checkEmpty(cb_level5) && checkEmpty(cb_book5)) {
            String level = cb_level5.getSelectedItem().toString();
            String book = cb_book5.getSelectedItem().toString();
            try {
                PreparedStatement stmt = con.prepareStatement("select * from student "
                        + "where level_name=? and student_code "
                        + "not in(select student_code from pay_for_book where book_name=? and level_name=?)"
                        + " order by student_code asc");
                stmt.setString(1, level);
                stmt.setString(2, book);
                stmt.setString(3, level);
                ResultSet set = stmt.executeQuery();

                DefaultTableModel dm = new DefaultTableModel();

                if (chb_address3.isSelected()) {
                    dm.addColumn("العنوان");
                }
                if (chb_parentName3.isSelected()) {
                    dm.addColumn("اسم ولي الامر");
                }
                if (chb_parentJob3.isSelected()) {
                    dm.addColumn("مهنة ولي الامر");
                }
                if (chb_parentPhone3.isSelected()) {
                    dm.addColumn("رقم ولي الامر");
                }
                if (chb_studentPhone3.isSelected()) {
                    dm.addColumn("رقم الهاتف");
                }
                if (chb_level3.isSelected()) {
                    dm.addColumn("الفرقة");
                }
                if (chb_studentName3.isSelected()) {
                    dm.addColumn("الاسم");
                }
                dm.addColumn("الكود");

                while (set.next()) {
                    ArrayList<String> r2 = new ArrayList<>();

                    if (chb_address3.isSelected()) {
                        r2.add(set.getString(4));
                    }
                    if (chb_parentJob3.isSelected()) {
                        r2.add(set.getString(7));
                    }
                    if (chb_parentName3.isSelected()) {
                        r2.add(set.getString(5));
                    }
                    if (chb_parentPhone3.isSelected()) {
                        r2.add(set.getString(6));
                    }
                    if (chb_studentPhone3.isSelected()) {
                        r2.add(set.getString(3));
                    }
                    if (chb_level3.isSelected()) {
                        r2.add(set.getString(9));
                    }
                    if (chb_studentName3.isSelected()) {
                        r2.add(set.getString(2));
                    }
                    r2.add(set.getString(1));

                    String r[] = r2.toArray(new String[r2.size()]);
                    dm.addRow(r);
                }

                t_viewStudentData3.setModel(dm);
                changeTheWidthOfTableColumn(t_viewStudentData3, 5, 175);
                changeTheWidthOfTableColumn(t_viewStudentData3, 6, 175);
                changeTheWidthOfTableColumn(t_viewStudentData3, 7, 50);

            } catch (SQLException ex) {
                handleSqlExceptions(ex.getErrorCode());
            }

        }
    }//GEN-LAST:event_btn_search4ActionPerformed

    private void cb_level5ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_level5ItemStateChanged
        String level_name = cb_level5.getSelectedItem().toString();
        if (!level_name.equals("اختر الفرقة")) {
            cb_book5.setEnabled(true);
            loadBook(cb_book5, cb_level5.getSelectedItem().toString());
        } else {
            cb_book5.setEnabled(false);
            loadBook(cb_book5, cb_level5.getSelectedItem().toString());
        }
    }//GEN-LAST:event_cb_level5ItemStateChanged

    private void cb_level5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cb_level5FocusGained
        FocusLostOrGained(cb_level5);
    }//GEN-LAST:event_cb_level5FocusGained

    private void cb_level5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cb_level5FocusLost
        FocusLostOrGained(cb_level5);
    }//GEN-LAST:event_cb_level5FocusLost

    private void cb_book5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cb_book5FocusGained
        FocusLostOrGained(cb_book5);
    }//GEN-LAST:event_cb_book5FocusGained

    private void cb_book5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cb_book5FocusLost
        FocusLostOrGained(cb_book5);
    }//GEN-LAST:event_cb_book5FocusLost

    private void btn_printInternalMoney3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_printInternalMoney3ActionPerformed
        makeReport(t_viewStudentData3, "المتخلفين عن دفع المذكرات");
    }//GEN-LAST:event_btn_printInternalMoney3ActionPerformed

    private void btn_search7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_search7ActionPerformed
        if (checkEmpty(cb_level6) && checkEmpty(cb_book6)) {
            String level = cb_level6.getSelectedItem().toString();
            String book = cb_book6.getSelectedItem().toString();
            try {
                PreparedStatement stmt = con.prepareStatement("select * from student "
                        + "where level_name=? and student_code "
                        + "in(select student_code from pay_for_book where book_name=? and level_name=?)"
                        + " order by student_code asc");
                stmt.setString(1, level);
                stmt.setString(2, book);
                stmt.setString(3, level);
                ResultSet set = stmt.executeQuery();

                PreparedStatement stmt2 = con.prepareStatement("select recieve from pay_for_book where book_name=? and level_name=? order by student_code asc");
                stmt2.setString(1, book);
                stmt2.setString(2, level);
                ResultSet set2 = stmt2.executeQuery();
                DefaultTableModel dm = new DefaultTableModel();

                if (chb_recieve.isSelected()) {
                    dm.addColumn("حالة الاستلام");
                }
                if (chb_address4.isSelected()) {
                    dm.addColumn("العنوان");
                }
                if (chb_parentName4.isSelected()) {
                    dm.addColumn("اسم ولي الامر");
                }
                if (chb_parentJob4.isSelected()) {
                    dm.addColumn("مهنة ولي الامر");
                }
                if (chb_parentPhone4.isSelected()) {
                    dm.addColumn("رقم ولي الامر");
                }
                if (chb_studentPhone4.isSelected()) {
                    dm.addColumn("رقم الهاتف");
                }
                if (chb_level4.isSelected()) {
                    dm.addColumn("الفرقة");
                }
                if (chb_studentName4.isSelected()) {
                    dm.addColumn("الاسم");
                }
                dm.addColumn("الكود");

                while (set.next()) {
                    ArrayList<String> r2 = new ArrayList<>();
                    while (set2.next()) {
                        if (chb_recieve.isSelected()) {
                            r2.add(set2.getString("recieve"));
                        }
                        break;
                    }
                    if (chb_address4.isSelected()) {
                        r2.add(set.getString(4));
                    }
                    if (chb_parentJob4.isSelected()) {
                        r2.add(set.getString(7));
                    }
                    if (chb_parentName4.isSelected()) {
                        r2.add(set.getString(5));
                    }
                    if (chb_parentPhone4.isSelected()) {
                        r2.add(set.getString(6));
                    }
                    if (chb_studentPhone4.isSelected()) {
                        r2.add(set.getString(3));
                    }
                    if (chb_level4.isSelected()) {
                        r2.add(set.getString(9));
                    }
                    if (chb_studentName4.isSelected()) {
                        r2.add(set.getString(2));
                    }
                    r2.add(set.getString(1));

                    String r[] = r2.toArray(new String[r2.size()]);
                    dm.addRow(r);
                }

                t_viewStudentData4.setModel(dm);
                changeTheWidthOfTableColumn(t_viewStudentData4, 5, 175);
                changeTheWidthOfTableColumn(t_viewStudentData4, 6, 175);
                changeTheWidthOfTableColumn(t_viewStudentData4, 7, 50);

            } catch (SQLException ex) {
                handleSqlExceptions(ex.getErrorCode());
            }

        }
    }//GEN-LAST:event_btn_search7ActionPerformed

    private void cb_level6ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_level6ItemStateChanged
        String level_name = cb_level6.getSelectedItem().toString();
        if (!level_name.equals("اختر الفرقة")) {
            cb_book6.setEnabled(true);
            loadBook(cb_book6, cb_level6.getSelectedItem().toString());
        } else {
            cb_book6.setEnabled(false);
            loadBook(cb_book6, cb_level6.getSelectedItem().toString());
        }
    }//GEN-LAST:event_cb_level6ItemStateChanged

    private void cb_level6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cb_level6FocusGained
        FocusLostOrGained(cb_level6);
    }//GEN-LAST:event_cb_level6FocusGained

    private void cb_level6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cb_level6FocusLost
        FocusLostOrGained(cb_level6);
    }//GEN-LAST:event_cb_level6FocusLost

    private void cb_book6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cb_book6FocusGained
        FocusLostOrGained(cb_book6);
    }//GEN-LAST:event_cb_book6FocusGained

    private void cb_book6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cb_book6FocusLost
        FocusLostOrGained(cb_book6);
    }//GEN-LAST:event_cb_book6FocusLost

    private void btn_printInternalMoney4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_printInternalMoney4ActionPerformed
        makeReport(t_viewStudentData4, "الدافعين مصاريف المذكرات");
    }//GEN-LAST:event_btn_printInternalMoney4ActionPerformed

    private void tf_studentName1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_studentName1KeyPressed
        if (enter(evt.getKeyChar())) {
            tf_paid1.requestFocus(true);
        }
    }//GEN-LAST:event_tf_studentName1KeyPressed

    private void tf_recieveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_recieveKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_recieveKeyPressed

    private void btn_recieveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_recieveActionPerformed
        String recieve;
        int code;
        String level;
        String bookName;
        if (checkEmpty(tf_code1) && checkEmpty(cb_level1)) {
            code = Integer.parseInt(tf_code1.getText());
            level = cb_level1.getSelectedItem().toString();
            bookName = cb_book1.getSelectedItem().toString();
            if ("لم يستلم".equals(tf_recieve.getText())) {
                recieve = "استلم";
            } else {
                recieve = "لم يستلم";
            }
            try {
                PreparedStatement stmt = con.prepareStatement("update pay_for_book set  recieve=? where student_code=? and level_name=? and book_name=?");
                stmt.setString(1, recieve);
                stmt.setInt(2, code);
                stmt.setString(3, level);
                stmt.setString(4, bookName);

                stmt.execute();
                updateMessage();
                recordEvent(recieve, "استلام مذكره", " من قبل الطالب " + "\"" + tf_studentName1.getText() + "\"" + "كود الطالب " + "\"" + tf_code1.getText() + "\"");
                // empty the textfields
                tf_recieve.setText(recieve);

            } catch (SQLException ex) {
                handleSqlExceptions(ex.getErrorCode());
            }
        }
    }//GEN-LAST:event_btn_recieveActionPerformed

    private void btn_printBookMoneyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_printBookMoneyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_printBookMoneyActionPerformed

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
            java.util.logging.Logger.getLogger(MoneyManagement.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MoneyManagement.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MoneyManagement.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MoneyManagement.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MoneyManagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel LevelGroupHolder;
    private javax.swing.JButton btn_Setting;
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_add1;
    private javax.swing.JButton btn_add2;
    private javax.swing.JButton btn_bookCost;
    private javax.swing.JButton btn_clean;
    private javax.swing.JButton btn_clean1;
    private javax.swing.JButton btn_clean2;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_delete1;
    private javax.swing.JButton btn_delete2;
    private javax.swing.JButton btn_dialyReport;
    private javax.swing.JButton btn_didNotPayYet;
    private javax.swing.JButton btn_didNotPayYetBook;
    private javax.swing.JButton btn_externalMoney;
    private javax.swing.JButton btn_home;
    private javax.swing.JButton btn_monthCost;
    private javax.swing.JButton btn_paied;
    private javax.swing.JButton btn_paiedBook;
    private javax.swing.JButton btn_printBill;
    private javax.swing.JButton btn_printBookMoney;
    private javax.swing.JButton btn_printExternalMoney;
    private javax.swing.JButton btn_printInternalMoney;
    private javax.swing.JButton btn_printInternalMoney1;
    private javax.swing.JButton btn_printInternalMoney2;
    private javax.swing.JButton btn_printInternalMoney3;
    private javax.swing.JButton btn_printInternalMoney4;
    private javax.swing.JButton btn_recieve;
    private javax.swing.JButton btn_search;
    private javax.swing.JButton btn_search1;
    private javax.swing.JButton btn_search2;
    private javax.swing.JButton btn_search3;
    private javax.swing.JButton btn_search4;
    private javax.swing.JButton btn_search5;
    private javax.swing.JButton btn_search7;
    private javax.swing.JButton btn_update;
    private javax.swing.JButton btn_update1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cb_book1;
    private javax.swing.JComboBox<String> cb_book5;
    private javax.swing.JComboBox<String> cb_book6;
    private javax.swing.JComboBox<String> cb_level;
    private javax.swing.JComboBox<String> cb_level1;
    private javax.swing.JComboBox<String> cb_level2;
    private javax.swing.JComboBox<String> cb_level3;
    private javax.swing.JComboBox<String> cb_level5;
    private javax.swing.JComboBox<String> cb_level6;
    private javax.swing.JComboBox<String> cb_month;
    private javax.swing.JComboBox<String> cb_month1;
    private javax.swing.JComboBox<String> cb_month2;
    private javax.swing.JComboBox<String> cb_month3;
    private javax.swing.JCheckBox chb_Level;
    private javax.swing.JCheckBox chb_address;
    private javax.swing.JCheckBox chb_address1;
    private javax.swing.JCheckBox chb_address3;
    private javax.swing.JCheckBox chb_address4;
    private javax.swing.JCheckBox chb_code;
    private javax.swing.JCheckBox chb_day;
    private javax.swing.JCheckBox chb_level;
    private javax.swing.JCheckBox chb_level1;
    private javax.swing.JCheckBox chb_level3;
    private javax.swing.JCheckBox chb_level4;
    private javax.swing.JCheckBox chb_monthCost;
    private javax.swing.JCheckBox chb_monthDiscount;
    private javax.swing.JCheckBox chb_monthName;
    private javax.swing.JCheckBox chb_monthRest;
    private javax.swing.JCheckBox chb_name;
    private javax.swing.JCheckBox chb_parentJob;
    private javax.swing.JCheckBox chb_parentJob1;
    private javax.swing.JCheckBox chb_parentJob3;
    private javax.swing.JCheckBox chb_parentJob4;
    private javax.swing.JCheckBox chb_parentName;
    private javax.swing.JCheckBox chb_parentName1;
    private javax.swing.JCheckBox chb_parentName3;
    private javax.swing.JCheckBox chb_parentName4;
    private javax.swing.JCheckBox chb_parentPhone;
    private javax.swing.JCheckBox chb_parentPhone1;
    private javax.swing.JCheckBox chb_parentPhone3;
    private javax.swing.JCheckBox chb_parentPhone4;
    private javax.swing.JCheckBox chb_recieve;
    private javax.swing.JCheckBox chb_studentName;
    private javax.swing.JCheckBox chb_studentName1;
    private javax.swing.JCheckBox chb_studentName3;
    private javax.swing.JCheckBox chb_studentName4;
    private javax.swing.JCheckBox chb_studentPhone;
    private javax.swing.JCheckBox chb_studentPhone1;
    private javax.swing.JCheckBox chb_studentPhone3;
    private javax.swing.JCheckBox chb_studentPhone4;
    private javax.swing.JCheckBox chb_time;
    private javax.swing.JLabel code;
    private com.toedter.calendar.JDateChooser dc_day;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lb_address5;
    private javax.swing.JLabel lb_address6;
    private javax.swing.JLabel lb_address8;
    private javax.swing.JLabel lb_address9;
    private javax.swing.JLabel lb_amount;
    private javax.swing.JPanel lb_background;
    private javax.swing.JLabel lb_book1;
    private javax.swing.JLabel lb_bookMoney;
    private javax.swing.JLabel lb_classification;
    private javax.swing.JLabel lb_classification1;
    private javax.swing.JLabel lb_classification2;
    private javax.swing.JLabel lb_classification3;
    private javax.swing.JLabel lb_classification5;
    private javax.swing.JLabel lb_code;
    private javax.swing.JLabel lb_code1;
    private javax.swing.JLabel lb_didNotPayNumber;
    private javax.swing.JLabel lb_discount;
    private javax.swing.JLabel lb_discount1;
    private javax.swing.JLabel lb_discount2;
    private javax.swing.JLabel lb_empty3;
    private javax.swing.JLabel lb_empty4;
    private javax.swing.JLabel lb_empty5;
    private javax.swing.JLabel lb_externalMoney;
    private javax.swing.JLabel lb_internalMoney;
    private javax.swing.JLabel lb_level1;
    private javax.swing.JLabel lb_level2;
    private javax.swing.JLabel lb_level4;
    private javax.swing.JLabel lb_level5;
    private javax.swing.JLabel lb_levelName;
    private javax.swing.JLabel lb_levelName1;
    private javax.swing.JLabel lb_month;
    private javax.swing.JLabel lb_month1;
    private javax.swing.JLabel lb_name;
    private javax.swing.JLabel lb_name1;
    private javax.swing.JLabel lb_number1;
    private javax.swing.JLabel lb_number2;
    private javax.swing.JLabel lb_paid;
    private javax.swing.JLabel lb_paid1;
    private javax.swing.JLabel lb_paid2;
    private javax.swing.JLabel lb_paid3;
    private javax.swing.JLabel lb_parentJob2;
    private javax.swing.JLabel lb_parentJob3;
    private javax.swing.JLabel lb_parentJob4;
    private javax.swing.JLabel lb_parentJob5;
    private javax.swing.JLabel lb_parentJob7;
    private javax.swing.JLabel lb_parentName2;
    private javax.swing.JLabel lb_parentName3;
    private javax.swing.JLabel lb_parentName4;
    private javax.swing.JLabel lb_parentName5;
    private javax.swing.JLabel lb_parentName7;
    private javax.swing.JLabel lb_parentName9;
    private javax.swing.JLabel lb_parentPhone11;
    private javax.swing.JLabel lb_parentPhone2;
    private javax.swing.JLabel lb_parentPhone3;
    private javax.swing.JLabel lb_parentPhone4;
    private javax.swing.JLabel lb_parentPhone5;
    private javax.swing.JLabel lb_parentPhone6;
    private javax.swing.JLabel lb_parentPhone9;
    private javax.swing.JLabel lb_payNumber;
    private javax.swing.JLabel lb_person;
    private javax.swing.JLabel lb_reason;
    private javax.swing.JLabel lb_recieve;
    private javax.swing.JLabel lb_rest;
    private javax.swing.JLabel lb_rest1;
    private javax.swing.JLabel lb_star10;
    private javax.swing.JLabel lb_star11;
    private javax.swing.JLabel lb_star12;
    private javax.swing.JLabel lb_star13;
    private javax.swing.JLabel lb_star14;
    private javax.swing.JLabel lb_star15;
    private javax.swing.JLabel lb_star16;
    private javax.swing.JLabel lb_star17;
    private javax.swing.JLabel lb_star18;
    private javax.swing.JLabel lb_star19;
    private javax.swing.JLabel lb_star20;
    private javax.swing.JLabel lb_star21;
    private javax.swing.JLabel lb_star22;
    private javax.swing.JLabel lb_star25;
    private javax.swing.JLabel lb_star26;
    private javax.swing.JLabel lb_star27;
    private javax.swing.JLabel lb_star28;
    private javax.swing.JLabel lb_star6;
    private javax.swing.JLabel lb_star7;
    private javax.swing.JLabel lb_star8;
    private javax.swing.JLabel lb_star9;
    private javax.swing.JLabel lb_status;
    private javax.swing.JLabel lb_studentName;
    private javax.swing.JLabel lb_studentName1;
    private javax.swing.JLabel lb_studentName5;
    private javax.swing.JLabel lb_studentName6;
    private javax.swing.JLabel lb_studentName8;
    private javax.swing.JLabel lb_studentName9;
    private javax.swing.JLabel lb_studentPhone10;
    private javax.swing.JLabel lb_studentPhone5;
    private javax.swing.JLabel lb_studentPhone6;
    private javax.swing.JLabel lb_studentPhone7;
    private javax.swing.JLabel lb_studentPhone9;
    private javax.swing.JLabel lb_total;
    private javax.swing.JLabel lb_total1;
    private javax.swing.JLabel lb_total2;
    private javax.swing.JList<String> lst_searchNames;
    private javax.swing.JList<String> lst_searchNames1;
    private javax.swing.JLayeredPane moneyManagement;
    private javax.swing.JPanel pl_bookCost;
    private javax.swing.JPanel pl_bottomButtonCotrol;
    private javax.swing.JPanel pl_checkBoxForParent;
    private javax.swing.JPanel pl_checkBoxForParent1;
    private javax.swing.JPanel pl_checkBoxForParent2;
    private javax.swing.JPanel pl_checkBoxForParent3;
    private javax.swing.JPanel pl_checkBoxForParent5;
    private javax.swing.JPanel pl_checkBoxForParent7;
    private javax.swing.JPanel pl_checkBoxForStudent;
    private javax.swing.JPanel pl_checkBoxForStudent1;
    private javax.swing.JPanel pl_checkBoxForStudent2;
    private javax.swing.JPanel pl_checkBoxForStudent3;
    private javax.swing.JPanel pl_checkBoxForStudent5;
    private javax.swing.JPanel pl_dailyReport;
    private javax.swing.JPanel pl_didNotPayYet;
    private javax.swing.JPanel pl_didNotPayYetBook;
    private javax.swing.JPanel pl_externalMoney;
    private javax.swing.JPanel pl_externalMoneyData;
    private javax.swing.JPanel pl_holdALlMoney;
    private javax.swing.JPanel pl_horizontalBottomLine1;
    private javax.swing.JPanel pl_horizontalBottomLine2;
    private javax.swing.JPanel pl_level_month;
    private javax.swing.JPanel pl_level_month2;
    private javax.swing.JPanel pl_monthCost;
    private javax.swing.JPanel pl_monthCostData;
    private javax.swing.JPanel pl_monthCostData2;
    private javax.swing.JPanel pl_monthCostData3;
    private javax.swing.JPanel pl_paied;
    private javax.swing.JPanel pl_paiedBook;
    private javax.swing.JPanel pl_parents;
    private javax.swing.JPanel pl_parents1;
    private javax.swing.JPanel pl_parents2;
    private javax.swing.JPanel pl_parents3;
    private javax.swing.JPanel pl_parents5;
    private javax.swing.JPanel pl_parents7;
    private javax.swing.JPanel pl_searchNames;
    private javax.swing.JPanel pl_searchNames1;
    private javax.swing.JPanel pl_seperateLine;
    private javax.swing.JPanel pl_seperateLine1;
    private javax.swing.JPanel pl_student;
    private javax.swing.JPanel pl_student1;
    private javax.swing.JPanel pl_student2;
    private javax.swing.JPanel pl_student3;
    private javax.swing.JPanel pl_student5;
    private javax.swing.JPanel pl_studentDataForSearch;
    private javax.swing.JPanel pl_studentDataForSearch1;
    private javax.swing.JPanel pl_topButtonControl;
    private javax.swing.JPanel pl_verticalSeperateLine;
    private javax.swing.JPanel pl_verticalSeperateLine1;
    private javax.swing.JPanel pl_verticalSeperateLine2;
    private javax.swing.JPanel pl_verticalSeperateLine3;
    private javax.swing.JPanel pl_verticalSeperateLine5;
    private javax.swing.JPanel pl_verticalSeperateLine6;
    private javax.swing.JScrollPane sp_BookMoney;
    private javax.swing.JScrollPane sp_InternalMoney;
    private javax.swing.JScrollPane sp_externalMoney;
    private javax.swing.JScrollPane sp_externalMoneyData;
    private javax.swing.JScrollPane sp_moneyManagement;
    private javax.swing.JScrollPane sp_searchNames;
    private javax.swing.JScrollPane sp_searchNames1;
    private javax.swing.JScrollPane sp_studentData;
    private javax.swing.JScrollPane sp_studentData1;
    private javax.swing.JScrollPane sp_studentData3;
    private javax.swing.JScrollPane sp_studentData4;
    private javax.swing.JTable t_BookMoney;
    private javax.swing.JTable t_InternalMoney;
    private javax.swing.JTable t_externalMoney;
    private javax.swing.JTable t_externalMoneyData;
    private javax.swing.JTable t_viewStudentData;
    private javax.swing.JTable t_viewStudentData1;
    private javax.swing.JTable t_viewStudentData3;
    private javax.swing.JTable t_viewStudentData4;
    private javax.swing.JTextField tf_BookIncome;
    private javax.swing.JTextField tf_amount;
    private javax.swing.JTextField tf_code;
    private javax.swing.JTextField tf_code1;
    private javax.swing.JTextField tf_discount;
    private javax.swing.JTextField tf_discount1;
    private javax.swing.JTextField tf_paid;
    private javax.swing.JTextField tf_paid1;
    private javax.swing.JTextField tf_person;
    private javax.swing.JTextField tf_reason;
    private javax.swing.JTextField tf_recieve;
    private javax.swing.JTextField tf_rest;
    private javax.swing.JTextField tf_rest1;
    private javax.swing.JTextField tf_studentName;
    private javax.swing.JTextField tf_studentName1;
    private javax.swing.JTextField tf_total;
    private javax.swing.JTextField tf_total1;
    private javax.swing.JTextField tf_totalAvilable;
    private javax.swing.JTextField tf_totalIncome;
    private javax.swing.JTextField tf_totalOutcome;
    // End of variables declaration//GEN-END:variables
}
