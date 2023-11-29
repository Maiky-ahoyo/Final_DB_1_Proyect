package Frames;

import Utileries.JPlaceholderTextArea;
import Utileries.ModernScrollbar;
import Utileries.RoundedBorder;
import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

import CRUD.*;

public class MainFrame extends JFrame implements ActionListener {
    private JPanel pMain, pTables;
    private JScrollPane spTables;
    private JScrollBar scrollBar;
    private JButton bCreate, bRead, bUpdate, bDelete, bAdopt, bReturn, bBook, bBookAppointment, bCancelAppointment;
    private JButton b_submit = new JButton("Submit");
    private Font Inter_Semibold = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/Inter-SemiBold.ttf"));
    private Font Inter_Regular = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/Inter-Regular.ttf"));
    private JComboBox cbTables;
    private JLabel lTables, lIcon, lWelcome, lOptions, lTitle, lDescription, lWelcomeMessage, lBrunoGif;
    protected JTable tTables;
    private static String panel, table;
    private Color backgroundGray = new Color(241, 245, 249);
    private Color buttonGray = new Color(195, 205, 224);
    private Color orange = new Color(248, 127, 39);
    private Color darkOrange = new Color(185, 90, 8);
    private Color black = new Color(15, 23, 42);
    private Color textGray = new Color(71, 85, 105);
    private Color lockedGray = new Color(30, 36, 44);
    private Color borderGray = new Color(119, 141, 170);
    private Font titleFont = Inter_Semibold.deriveFont(30f);
    private Font subtitleFont = Inter_Semibold.deriveFont(24f);
    private Font welcomeFont = Inter_Semibold.deriveFont(20f);
    private Font buttonFont = Inter_Semibold.deriveFont(16f);
    private Font bodyFont = Inter_Regular.deriveFont(16f);
    private Font labelFont = Inter_Semibold.deriveFont(14f);
    private Border border = BorderFactory.createLineBorder(borderGray, 1);
    private Icon iCreate = new ImageIcon("Icons/Create.png");
    private Icon iRead = new ImageIcon("Icons/Read.png");
    private Icon iUpdate = new ImageIcon("Icons/Update.png");
    private Icon iDelete = new ImageIcon("Icons/Delete.png");
    private Icon brunoGif = new ImageIcon("Icons/Bruno_happy_dance.gif");
    private Icon iAdopt = new ImageIcon("Icons/Adopt.png");
    private Icon iBookAppointment = new ImageIcon("Icons/BookAppointment.png");
    private Icon iSadFace = new ImageIcon("Icons/SadFace.png");
    private Icon iBone = new ImageIcon("Icons/Bone.png");
    private Icon iDog = new ImageIcon("Icons/Dog.png");
    private Icon iSick = new ImageIcon("Icons/Sick.png");
    private Icon iVet = new ImageIcon("Icons/Vet.png");
    private ImageIcon iLogo = new ImageIcon("Icons/Logo.png");

    private ImageIcon iMainLogo = new ImageIcon("Icons/MainLogo.png");
    private JTextField t_vet_id, t_vet_name, t_dog_id, t_dog_name, t_dog_place_of_birth, t_litter_id,
            t_litter_place_of_birth, t_relationship_id, t_relationship_code, t_health_record_id, t_problem_code,
            t_vet_name_update, t_dog_born_in_litter, t_date_of_birth, t_dogs_name_update, t_dog_place_of_birth_update,
            t_sire_dog_id, t_dam_dog_id, t_litter_place_of_birth_update, t_dog_1_id, t_dog_2_id, t_date_of_problem,
            t_owner_update, t_appointment_id, t_appointment_date, t_appointment_time;
    private JPlaceholderTextArea pt_other_details, pt_relationships_description, pt_summary, pt_problem_description,
            pt_other_details_update, pt_relationships_description_update, pt_summary_update, pt_problem_details_update,
            pt_problem_description_update, pt_problem_treatment_update, pt_problem_treatment, pt_appointment_reason;
    private JTextArea t_other_details, t_relationships_description, t_summary, t_problem_description,
            t_problem_treatment, t_problem_details, t_appointment_reason;
    private JDateChooser dc_date_of_birth, dc_date_of_problem, dc_date_of_birth_update, dc_date_of_problem_update,
            dc_appointment_date;
    private ButtonGroup bg_group, bg_group_update;
    private JRadioButton rb_dog_female, rb_dog_male, rb_dog_female_update, rb_dog_male_update;
    private JComboBox cb_dog_born_in_litter, cb_sire_dog_id, cb_dam_dog_id, cb_vet_id, cb_dog_id, cb_health_record_id,
            cb_problem_code, cb_dog_born_in_litter_update, cb_litter_id, cb_sire_dog_id_update, cb_dam_dog_id_update,
            cb_relationship_id, cb_relationship_code, cb_relationship_code_update, cb_vet_id_update, cb_dog_id_update,
            cb_health_record_id_update, cb_dog_1_id, cb_dog_2_id, cb_dog_1_id_update, cb_dog_2_id_update,
            cb_appointment_time, cb_appointment_id;
    private String dogs_name, place_of_birth, dogs_gender, other_details, vet_name, relationship_description, treatment,
            summary, problem_description, owner_name, column1, column2, appointment_reason;
    private ArrayList<String> cb_data;
    private int dog_id, litter_id, sire_dog_id, dam_dog_id, dog_1_id, dog_2_id, vet_id, health_record_id,
            problem_code, relationship_id, relationship_code, appointment_id;
    private java.sql.Date date_of_birth, date_of_problem, appointment_date;
    private java.sql.Time appointment_time;

    public static String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public MainFrame() throws IOException, FontFormatException {
        setLayout(null);
        setTitle("Pawesome Friends DB");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(1080, 720);
        setLocationRelativeTo(null);
        setResizable(false);
        setIconImage(iMainLogo.getImage());

        pMain = new JPanel();
        pMain.setBounds(0,0,398,720);
        pMain.setBackground(backgroundGray);
        pMain.setLayout(null);

        lWelcome = new JLabel("Welcome to");
        lWelcome.setFont(welcomeFont);
        lWelcome.setForeground(black);
        lWelcome.setBounds(64, 34, 115, 28);
        pMain.add(lWelcome);

        lIcon = new JLabel();
        lIcon.setIcon(iLogo);
        lIcon.setBounds(64, 50, 270, 120);
        pMain.add(lIcon);

        lOptions = new JLabel("What would you like to do?");
        lOptions.setFont(bodyFont);
        lOptions.setBounds(64, 155, 210, 28);
        lOptions.setForeground(textGray);
        pMain.add(lOptions);

        bCreate = new JButton();
        bCreate.setIcon(iCreate);
        bCreate.setText("Create");
        bCreate.setIconTextGap(10);
        bCreate.setBounds(64,209,270,48);
        bCreate.setBackground(Color.white);
        bCreate.setBorder(new RoundedBorder(backgroundGray, 2, 12));
        bCreate.setFont(buttonFont);
        bCreate.setForeground(black);
        bCreate.addActionListener(this);
        pMain.add(bCreate);

        bRead = new JButton();
        bRead.setIcon(iRead);
        bRead.setText("Read");
        bRead.setIconTextGap(10);
        bRead.setBounds(64,273,270,48);
        bRead.setBackground(Color.white);
        bRead.setBorder(new RoundedBorder(backgroundGray, 2, 12));
        bRead.setFont(buttonFont);
        bRead.setForeground(black);
        bRead.addActionListener(this);
        pMain.add(bRead);

        bUpdate = new JButton();
        bUpdate.setIcon(iUpdate);
        bUpdate.setText("Update");
        bUpdate.setIconTextGap(10);
        bUpdate.setBounds(64,337,270,48);
        bUpdate.setBackground(Color.white);
        bUpdate.setBorder(new RoundedBorder(backgroundGray, 2, 12));
        bUpdate.setFont(buttonFont);
        bUpdate.setForeground(black);
        bUpdate.addActionListener(this);
        pMain.add(bUpdate);

        bDelete = new JButton();
        bDelete.setIcon(iDelete);
        bDelete.setText("Delete");
        bDelete.setIconTextGap(10);
        bDelete.setBounds(64,401,270,48);
        bDelete.setBackground(Color.white);
        bDelete.setBorder(new RoundedBorder(backgroundGray, 2, 12));
        bDelete.setFont(buttonFont);
        bDelete.setForeground(black);
        bDelete.addActionListener(this);
        pMain.add(bDelete);

        bAdopt = new JButton();
        bAdopt.setIcon(iAdopt);
        bAdopt.setText("Adopt Puppy");
        bAdopt.setIconTextGap(10);
        bAdopt.setBounds(64,465,270,48);
        bAdopt.setBackground(Color.white);
        bAdopt.setBorder(new RoundedBorder(backgroundGray, 2, 12));
        bAdopt.setFont(buttonFont);
        bAdopt.setForeground(black);
        bAdopt.addActionListener(this);
        pMain.add(bAdopt);

        bReturn = new JButton();
        bReturn.setIcon(iSadFace);
        bReturn.setText("Return Puppy");
        bReturn.setIconTextGap(10);
        bReturn.setBounds(64,529,270,48);
        bReturn.setBackground(Color.white);
        bReturn.setBorder(new RoundedBorder(backgroundGray, 2, 12));
        bReturn.setFont(buttonFont);
        bReturn.setForeground(black);
        bReturn.addActionListener(this);
        pMain.add(bReturn);

        bBook = new JButton();
        bBook.setIcon(iBookAppointment);
        bBook.setText("Book Appointment");
        bBook.setIconTextGap(10);
        bBook.setBounds(64,593,270,48);
        bBook.setBackground(Color.white);
        bBook.setBorder(new RoundedBorder(backgroundGray, 2, 12));
        bBook.setFont(buttonFont);
        bBook.setForeground(black);
        bBook.addActionListener(this);
        pMain.add(bBook);

        lWelcomeMessage = new JLabel("Please select an option from the left to start");
        lWelcomeMessage.setFont(bodyFont);
        lWelcomeMessage.setForeground(textGray);
        lWelcomeMessage.setBounds(571, 195, 335, 20);
        add(lWelcomeMessage);

        lBrunoGif = new JLabel(brunoGif);
        lBrunoGif.setBounds(611, 239, 256, 256);
        add(lBrunoGif);

        lTables = new JLabel("Table");
        lTables.setFont(labelFont);
        lTables.setForeground(black);

        cbTables = new JComboBox();
        cbTables.setBackground(backgroundGray);
        cbTables.setFont(bodyFont);
        cbTables.setForeground(black);
        cbTables.addItem("vets");
        cbTables.addItem("dogs");
        cbTables.addItem("litters");
        cbTables.addItem("relationships");
        cbTables.addItem("relationship_types");
        cbTables.addItem("health_records");
        cbTables.addItem("common_problems");
        cbTables.addItem("dog_problems");
        cbTables.addActionListener(this);

        b_submit.setFont(buttonFont);
        b_submit.setBackground(orange);
        b_submit.setForeground(Color.WHITE);
        b_submit.setBorder(new RoundedBorder(Color.WHITE, 1, 12));

        pTables = new JPanel();
        pTables.setBackground(Color.WHITE);
        pTables.setLayout(null);
        pTables.setVisible(true);

        spTables = new JScrollPane(pTables);
        spTables.setBounds(398,0,669,720);
        spTables.setBackground(Color.WHITE);
        spTables.setBorder(null);
        spTables.setVisible(true);
        spTables.setViewportView(pTables);
        spTables.getVerticalScrollBar().setUnitIncrement(16);
        add(spTables);

        scrollBar = spTables.getVerticalScrollBar();
        scrollBar.setUI(new ModernScrollbar());
        scrollBar.setPreferredSize(new Dimension (16,16));
        scrollBar.setForeground(new Color(119, 141, 170));
        scrollBar.setBackground(Color.WHITE);

        add(pMain);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bCreate) {
            remove(lWelcomeMessage);
            remove(lBrunoGif);

            panel = "create";

            bCreate.setBackground(buttonGray);
            bRead.setBackground(Color.white);
            bUpdate.setBackground(Color.white);
            bDelete.setBackground(Color.white);
            bAdopt.setBackground(Color.white);
            bReturn.setBackground(Color.white);
            bBook.setBackground(Color.white);

            pTables.setPreferredSize(new Dimension (642,700));

            pTables.removeAll();

            lTitle = new JLabel("Create");
            lTitle.setFont(titleFont);
            lTitle.setForeground(black);
            lTitle.setBounds(64,110,100,38);
            pTables.add(lTitle);

            lDescription = new JLabel("Select a table and add new information to the database");
            lDescription.setFont(bodyFont);
            lDescription.setForeground(textGray);
            lDescription.setBounds(64,154,430,28);
            pTables.add(lDescription);

            lTables.setBounds(64,206,40 ,20);
            pTables.add(lTables);

            cbTables.setBounds(64,230,554,40);
            cbTables.setSelectedItem(null);
            pTables.add(cbTables);

            pTables.updateUI();
        }
        if (e.getSource() == bRead) {
            remove(lWelcomeMessage);
            remove(lBrunoGif);

            panel = "read";

            bCreate.setBackground(Color.white);
            bRead.setBackground(buttonGray);
            bUpdate.setBackground(Color.white);
            bDelete.setBackground(Color.white);
            bAdopt.setBackground(Color.white);
            bReturn.setBackground(Color.white);
            bBook.setBackground(Color.white);

            pTables.setPreferredSize(new Dimension (642,700));

            pTables.removeAll();

            lTitle = new JLabel("Read");
            lTitle.setFont(titleFont);
            lTitle.setForeground(black);
            lTitle.setBounds(64,110,100,38);
            pTables.add(lTitle);

            lDescription = new JLabel("Select a table and read information from the database");
            lDescription.setFont(bodyFont);
            lDescription.setForeground(textGray);
            lDescription.setBounds(64,154,430,28);
            pTables.add(lDescription);

            lTables.setBounds(64,206,40 ,20);
            pTables.add(lTables);

            cbTables.setBounds(64,230,554,40);
            cbTables.setSelectedItem(null);
            pTables.add(cbTables);

            tTables = new JTable();
            tTables.setBounds(45,100,900,555);
            pTables.add(tTables);

            pTables.updateUI();
            pTables.setVisible(true);
        }
        if (e.getSource() == bUpdate) {
            remove(lWelcomeMessage);
            remove(lBrunoGif);

            panel = "update";

            bCreate.setBackground(Color.white);
            bRead.setBackground(Color.white);
            bUpdate.setBackground(buttonGray);
            bDelete.setBackground(Color.white);
            bAdopt.setBackground(Color.white);
            bReturn.setBackground(Color.white);
            bBook.setBackground(Color.white);

            pTables.setPreferredSize(new Dimension (642,700));

            pTables.removeAll();

            lTitle = new JLabel("Update");
            lTitle.setFont(titleFont);
            lTitle.setForeground(black);
            lTitle.setBounds(64,110,120,38);
            pTables.add(lTitle);

            lDescription = new JLabel("Select a table where you want to update information from the database");
            lDescription.setFont(bodyFont);
            lDescription.setForeground(textGray);
            lDescription.setBounds(64,154,550,28);
            pTables.add(lDescription);

            lTables.setBounds(64,206,40 ,20);
            pTables.add(lTables);

            cbTables.setBounds(64,230,554,40);
            cbTables.setSelectedItem(null);
            cbTables.setBorder(null);
            pTables.add(cbTables);

            pTables.updateUI();
            pTables.setVisible(true);
        }
        if (e.getSource() == bDelete) {
            remove(lWelcomeMessage);
            remove(lBrunoGif);

            panel = "delete";

            bCreate.setBackground(Color.white);
            bRead.setBackground(Color.white);
            bUpdate.setBackground(Color.white);
            bDelete.setBackground(buttonGray);
            bAdopt.setBackground(Color.white);
            bReturn.setBackground(Color.white);
            bBook.setBackground(Color.white);

            pTables.setPreferredSize(new Dimension (642,700));

            pTables.removeAll();

            lTitle = new JLabel("Delete");
            lTitle.setFont(titleFont);
            lTitle.setForeground(black);
            lTitle.setBounds(64,110,100,38);
            pTables.add(lTitle);

            lDescription = new JLabel("Select a table where you want to delete information from the database");
            lDescription.setFont(bodyFont);
            lDescription.setForeground(textGray);
            lDescription.setBounds(64,154,550,28);
            pTables.add(lDescription);

            lTables.setBounds(64,206,40 ,20);
            pTables.add(lTables);

            cbTables.setBounds(64,230,554,40);
            cbTables.setSelectedItem(null);
            cbTables.setBorder(null);
            pTables.add(cbTables);

            pTables.updateUI();
            pTables.setVisible(true);
        }
        if (e.getSource() == bAdopt) {
            remove(lWelcomeMessage);
            remove(lBrunoGif);

            panel = "adopt";

            bCreate.setBackground(Color.white);
            bRead.setBackground(Color.white);
            bUpdate.setBackground(Color.white);
            bDelete.setBackground(Color.white);
            bAdopt.setBackground(buttonGray);
            bReturn.setBackground(Color.white);
            bBook.setBackground(Color.white);

            pTables.setPreferredSize(new Dimension (642,700));

            pTables.removeAll();

            b_submit.removeActionListener(this);

            lTitle = new JLabel("Adopt Puppy");
            lTitle.setFont(titleFont);
            lTitle.setForeground(black);
            lTitle.setBounds(64,110,200,38);
            pTables.add(lTitle);

            lDescription = new JLabel("Fill in the information to send a puppy to a happy home!");
            lDescription.setFont(bodyFont);
            lDescription.setForeground(textGray);
            lDescription.setBounds(64,154,430,28);
            pTables.add(lDescription);

            JLabel l_dog_id = new JLabel("Dog's ID");
            l_dog_id.setFont(labelFont);
            l_dog_id.setForeground(black);
            l_dog_id.setBounds(64, 206, 265, 20);
            pTables.add(l_dog_id);

            cb_dog_id = new JComboBox();
            cb_dog_id.setFont(bodyFont);
            cb_dog_id.setForeground(black);
            cb_dog_id.setBounds(64, 230, 554, 40);
            cb_dog_id.setBackground(Color.WHITE);
            cb_data = Read.getAdoptedID();
            for (String item : cb_data) {
                cb_dog_id.addItem(item);
            }
            cb_dog_id.setSelectedItem(null);
            cb_dog_id.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dog_id = Integer.parseInt(cb_dog_id.getSelectedItem().toString());
                    ArrayList<String> info = Read.getDogInfo(dog_id);
                    dogs_name = info.get(0);
                    t_dog_name.setText(dogs_name);
                }
            });
            pTables.add(cb_dog_id);

            JLabel l_dog_name = new JLabel("Dog's Name");
            l_dog_name.setFont(labelFont);
            l_dog_name.setForeground(black);
            l_dog_name.setBounds(64, 289, 200, 20);
            pTables.add(l_dog_name);

            t_dog_name = new JTextField();
            t_dog_name.setFont(bodyFont);
            t_dog_name.setForeground(black);
            t_dog_name.setBackground(Color.WHITE);
            t_dog_name.setBorder(border);
            t_dog_name.setBounds(64, 313, 554, 40);
            t_dog_name.setEditable(false);
            pTables.add(t_dog_name);

            JLabel l_owner_update = new JLabel("Owner's Name");
            l_owner_update.setFont(labelFont);
            l_owner_update.setForeground(black);
            l_owner_update.setBounds(64, 377, 200, 20);
            pTables.add(l_owner_update);

            t_owner_update = new JTextField();
            t_owner_update.setFont(bodyFont);
            t_owner_update.setForeground(black);
            t_owner_update.setBorder(border);
            t_owner_update.setBounds(64, 401, 554, 40);
            pTables.add(t_owner_update);

            b_submit.setBounds(62, 549, 554, 40);
            b_submit.addActionListener(this);
            pTables.add(b_submit);

            pTables.updateUI();
        }
        if (e.getSource() == bReturn) {
            remove(lWelcomeMessage);
            remove(lBrunoGif);

            panel = "return";

            bCreate.setBackground(Color.white);
            bRead.setBackground(Color.white);
            bUpdate.setBackground(Color.white);
            bDelete.setBackground(Color.white);
            bAdopt.setBackground(Color.white);
            bReturn.setBackground(buttonGray);
            bBook.setBackground(Color.white);

            pTables.setPreferredSize(new Dimension (642,700));

            pTables.removeAll();

            b_submit.removeActionListener(this);

            lTitle = new JLabel("Return Puppy");
            lTitle.setFont(titleFont);
            lTitle.setForeground(black);
            lTitle.setBounds(64,110,200,38);
            pTables.add(lTitle);

            lDescription = new JLabel("Fill in the information to return a puppy to the shelter!");
            lDescription.setFont(bodyFont);
            lDescription.setForeground(textGray);
            lDescription.setBounds(64,154,430,28);
            pTables.add(lDescription);

            JLabel l_dog_id = new JLabel("Dog's ID");
            l_dog_id.setFont(labelFont);
            l_dog_id.setForeground(black);
            l_dog_id.setBounds(64, 206, 265, 20);
            pTables.add(l_dog_id);

            cb_dog_id = new JComboBox();
            cb_dog_id.setFont(bodyFont);
            cb_dog_id.setForeground(black);
            cb_dog_id.setBounds(64, 230, 554, 40);
            cb_dog_id.setBackground(Color.WHITE);
            cb_data = Read.getReturnID();
            for (String item : cb_data) {
                cb_dog_id.addItem(item);
            }
            cb_dog_id.setSelectedItem(null);
            cb_dog_id.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dog_id = Integer.parseInt(cb_dog_id.getSelectedItem().toString());
                    ArrayList<String> info = Read.getDogInfo(dog_id);
                    dogs_name = info.get(0);
                    t_dog_name.setText(dogs_name);
                }
            });
            pTables.add(cb_dog_id);

            JLabel l_dog_name = new JLabel("Dog's Name");
            l_dog_name.setFont(labelFont);
            l_dog_name.setForeground(black);
            l_dog_name.setBounds(64, 289, 200, 20);
            pTables.add(l_dog_name);

            t_dog_name = new JTextField();
            t_dog_name.setFont(bodyFont);
            t_dog_name.setForeground(black);
            t_dog_name.setBackground(Color.WHITE);
            t_dog_name.setBorder(border);
            t_dog_name.setBounds(64, 313, 554, 40);
            t_dog_name.setEditable(false);
            pTables.add(t_dog_name);

            b_submit.setBounds(62, 549, 554, 40);
            b_submit.addActionListener(this);
            pTables.add(b_submit);

            pTables.updateUI();
        }
        if (e.getSource() == bBook) {
            remove(lWelcomeMessage);
            remove(lBrunoGif);

            bCreate.setBackground(Color.white);
            bRead.setBackground(Color.white);
            bUpdate.setBackground(Color.white);
            bDelete.setBackground(Color.white);
            bAdopt.setBackground(Color.white);
            bReturn.setBackground(Color.white);
            bBook.setBackground(buttonGray);

            pTables.setPreferredSize(new Dimension (642,700));

            pTables.removeAll();

            lTitle = new JLabel("Book/Cancel Appointment");
            lTitle.setFont(titleFont);
            lTitle.setForeground(black);
            lTitle.setBounds(64,110,430,38);
            pTables.add(lTitle);

            lDescription = new JLabel("Fill in the information to book or cancel an appointment.");
            lDescription.setFont(bodyFont);
            lDescription.setForeground(textGray);
            lDescription.setBounds(64,154,500,28);
            pTables.add(lDescription);

            bBookAppointment = new JButton("Book Appointment");
            bBookAppointment.setFont(buttonFont);
            bBookAppointment.setBackground(orange);
            bBookAppointment.setForeground(Color.WHITE);
            bBookAppointment.setBorder(new RoundedBorder(Color.WHITE, 1, 12));
            bBookAppointment.setBounds(64, 202, 265, 40);
            bBookAppointment.addActionListener(this);
            pTables.add(bBookAppointment);

            bCancelAppointment = new JButton("Cancel Appointment");
            bCancelAppointment.setFont(buttonFont);
            bCancelAppointment.setBackground(orange);
            bCancelAppointment.setForeground(Color.WHITE);
            bCancelAppointment.setBorder(new RoundedBorder(Color.WHITE, 1, 12));
            bCancelAppointment.setBounds(353, 202, 265, 40);
            bCancelAppointment.addActionListener(this);
            pTables.add(bCancelAppointment);

            pTables.updateUI();
        }
        if (e.getSource() == bBookAppointment) {
            panel = "book_visit";

            pTables.setPreferredSize(new Dimension (642,780));

            pTables.removeAll();

            b_submit.removeActionListener(this);

            lTitle.setText("Book Appointment");
            lTitle.setBounds(64,44,430,38);
            pTables.add(lTitle);

            lDescription.setText("Fill in the information to book an appointment.");
            lDescription.setBounds(64,88,430,28);
            pTables.add(lDescription);

            bBookAppointment.setBackground(darkOrange);
            bBookAppointment.setForeground(Color.WHITE);
            bBookAppointment.setBorder(new RoundedBorder(Color.WHITE, 1, 12));
            bBookAppointment.setBounds(64, 136, 265, 40);
            pTables.add(bBookAppointment);

            bCancelAppointment.setBackground(orange);
            bCancelAppointment.setForeground(Color.WHITE);
            bCancelAppointment.setBorder(new RoundedBorder(Color.WHITE, 1, 12));
            bCancelAppointment.setBounds(353, 136, 265, 40);
            pTables.add(bCancelAppointment);

            JLabel l_appointment_id = new JLabel("Appointment's ID");
            l_appointment_id.setFont(labelFont);
            l_appointment_id.setForeground(black);
            l_appointment_id.setBounds(64, 200, 265, 20);
            pTables.add(l_appointment_id);

            t_appointment_id = new JTextField("" + Read.getMaxAppointmentID());
            t_appointment_id.setFont(bodyFont);
            t_appointment_id.setForeground(black);
            t_appointment_id.setBackground(backgroundGray);
            t_appointment_id.setBorder(border);
            t_appointment_id.setBounds(64, 224, 554, 40);
            t_appointment_id.setEditable(false);
            pTables.add(t_appointment_id);

            JLabel l_dog_id = new JLabel("Dog's ID");
            l_dog_id.setFont(labelFont);
            l_dog_id.setForeground(black);
            l_dog_id.setBounds(64,288,265,20);
            pTables.add(l_dog_id);

            cb_dog_id = new JComboBox();
            cb_dog_id.setFont(bodyFont);
            cb_dog_id.setForeground(black);
            cb_dog_id.setBounds(64,312,265,40);
            cb_dog_id.setBackground(Color.WHITE);
            cb_data = Read.getDogID();
            for (String item : cb_data) {
                cb_dog_id.addItem(item);
            }
            cb_dog_id.setSelectedItem(null);
            pTables.add(cb_dog_id);

            JLabel l_vet_id = new JLabel("Vet's ID");
            l_vet_id.setFont(labelFont);
            l_vet_id.setForeground(black);
            l_vet_id.setBounds(353, 288, 265, 20);
            pTables.add(l_vet_id);

            cb_vet_id = new JComboBox();
            cb_vet_id.setFont(bodyFont);
            cb_vet_id.setForeground(black);
            cb_vet_id.setBounds(353, 312, 265, 40);
            cb_vet_id.setBackground(Color.WHITE);
            cb_data = Read.getVetID();
            for (String item : cb_data) {
                cb_vet_id.addItem(item);
            }
            cb_vet_id.setSelectedItem(null);
            pTables.add(cb_vet_id);

            JLabel l_date_of_appointment = new JLabel("Appointment's Date");
            l_date_of_appointment.setFont(labelFont);
            l_date_of_appointment.setForeground(black);
            l_date_of_appointment.setBounds(64, 376, 200, 20);
            pTables.add(l_date_of_appointment);

            dc_appointment_date = new JDateChooser("yyyy-MM-dd", "yyyy-MM-dd", '_');
            dc_appointment_date.setFont(bodyFont);
            dc_appointment_date.setForeground(black);
            dc_appointment_date.setBounds(64, 400, 265, 40);
            pTables.add(dc_appointment_date);

            JLabel l_appointment_time = new JLabel("Appointment's Time");
            l_appointment_time.setFont(labelFont);
            l_appointment_time.setForeground(black);
            l_appointment_time.setBounds(353, 376, 200, 20);
            pTables.add(l_appointment_time);

            cb_appointment_time = new JComboBox();
            cb_appointment_time.setFont(bodyFont);
            cb_appointment_time.setForeground(black);
            cb_appointment_time.setBounds(353, 400, 265, 40);
            cb_appointment_time.setBackground(Color.WHITE);
            cb_appointment_time.addItem("08:00:00");
            cb_appointment_time.addItem("08:30:00");
            cb_appointment_time.addItem("09:00:00");
            cb_appointment_time.addItem("09:30:00");
            cb_appointment_time.addItem("10:00:00");
            cb_appointment_time.addItem("10:30:00");
            cb_appointment_time.addItem("11:00:00");
            cb_appointment_time.addItem("11:30:00");
            cb_appointment_time.addItem("12:00:00");
            cb_appointment_time.addItem("12:30:00");
            cb_appointment_time.addItem("13:00:00");
            cb_appointment_time.addItem("13:30:00");
            cb_appointment_time.addItem("14:00:00");
            cb_appointment_time.addItem("14:30:00");
            cb_appointment_time.addItem("15:00:00");
            cb_appointment_time.addItem("15:30:00");
            cb_appointment_time.addItem("16:00:00");
            cb_appointment_time.addItem("16:30:00");
            cb_appointment_time.addItem("17:00:00");
            cb_appointment_time.setSelectedItem(null);
            pTables.add(cb_appointment_time);

            JLabel l_appointment_reason = new JLabel("Appointment's Reason");
            l_appointment_reason.setFont(labelFont);
            l_appointment_reason.setForeground(black);
            l_appointment_reason.setBounds(64, 464, 200, 20);
            pTables.add(l_appointment_reason);

            pt_appointment_reason = new JPlaceholderTextArea("e.g. Puppy has been vomiting for 3 days");
            pt_appointment_reason.setLineWrap(true);
            pt_appointment_reason.setFont(bodyFont);
            pt_appointment_reason.setForeground(black);
            pt_appointment_reason.setBorder(border);
            pt_appointment_reason.setBounds(64, 488, 554, 139);
            pTables.add(pt_appointment_reason);

            b_submit.setBounds(62, 657, 554, 40);
            b_submit.addActionListener(this);
            pTables.add(b_submit);

            pTables.updateUI();
        }
        if (e.getSource() == bCancelAppointment) {
            panel = "cancel_visit";

            pTables.setPreferredSize(new Dimension (642,780));

            pTables.removeAll();

            b_submit.removeActionListener(this);

            lTitle.setText("Cancel Appointment");
            lTitle.setBounds(64,44,430,38);
            pTables.add(lTitle);

            lDescription.setText("Fill in the information to cancel an appointment.");
            lDescription.setBounds(64,88,430,28);
            pTables.add(lDescription);

            bBookAppointment.setBackground(orange);
            bBookAppointment.setForeground(Color.WHITE);
            bBookAppointment.setBorder(new RoundedBorder(Color.WHITE, 1, 12));
            bBookAppointment.setBounds(64, 136, 265, 40);
            pTables.add(bBookAppointment);

            bCancelAppointment.setBackground(darkOrange);
            bCancelAppointment.setForeground(Color.WHITE);
            bCancelAppointment.setBorder(new RoundedBorder(Color.WHITE, 1, 12));
            bCancelAppointment.setBounds(353, 136, 265, 40);
            pTables.add(bCancelAppointment);

            JLabel l_appointment_id = new JLabel("Appointment's ID");
            l_appointment_id.setFont(labelFont);
            l_appointment_id.setForeground(black);
            l_appointment_id.setBounds(64, 200, 265, 20);
            pTables.add(l_appointment_id);

            cb_appointment_id = new JComboBox();
            cb_appointment_id.setFont(bodyFont);
            cb_appointment_id.setForeground(black);
            cb_appointment_id.setBounds(64, 224, 554, 40);
            cb_appointment_id.setBackground(Color.WHITE);
            cb_data = Read.getAppointmentID();
            for (String item : cb_data) {
                cb_appointment_id.addItem(item);
            }
            cb_appointment_id.setSelectedItem(null);
            cb_appointment_id.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    appointment_id = Integer.parseInt(cb_appointment_id.getSelectedItem().toString());
                    ArrayList<String> info = Read.getAppointmentInfo(appointment_id);
                    dog_id = Integer.parseInt(info.get(0));
                    vet_id = Integer.parseInt(info.get(1));
                    appointment_date = Date.valueOf(info.get(2));
                    appointment_time = Time.valueOf(info.get(3));
                    appointment_reason = info.get(4);
                    t_dog_id.setText("" + dog_id);
                    t_vet_id.setText("" + vet_id);
                    t_appointment_date.setText(String.valueOf(appointment_date));
                    t_appointment_time.setText(String.valueOf(appointment_time));
                    t_appointment_reason.setText(appointment_reason);
                }
            });
            pTables.add(cb_appointment_id);

            JLabel l_dog_id = new JLabel("Dog's ID");
            l_dog_id.setFont(labelFont);
            l_dog_id.setForeground(black);
            l_dog_id.setBounds(64, 288, 265, 20);
            pTables.add(l_dog_id);

            t_dog_id = new JTextField();
            t_dog_id.setFont(bodyFont);
            t_dog_id.setForeground(lockedGray);
            t_dog_id.setBackground(backgroundGray);
            t_dog_id.setBorder(border);
            t_dog_id.setBounds(64, 312, 265, 40);
            t_dog_id.setEditable(false);
            pTables.add(t_dog_id);

            JLabel l_vet_id = new JLabel("Vet's ID");
            l_vet_id.setFont(labelFont);
            l_vet_id.setForeground(black);
            l_vet_id.setBounds(353, 288, 265, 20);
            pTables.add(l_vet_id);

            t_vet_id = new JTextField();
            t_vet_id.setFont(bodyFont);
            t_vet_id.setForeground(lockedGray);
            t_vet_id.setBackground(backgroundGray);
            t_vet_id.setBorder(border);
            t_vet_id.setBounds(353, 312, 265, 40);
            t_vet_id.setEditable(false);
            pTables.add(t_vet_id);

            JLabel l_date_of_appointment = new JLabel("Appointment's Date");
            l_date_of_appointment.setFont(labelFont);
            l_date_of_appointment.setForeground(black);
            l_date_of_appointment.setBounds(64, 376, 200, 20);
            pTables.add(l_date_of_appointment);

            t_appointment_date = new JTextField();
            t_appointment_date.setFont(bodyFont);
            t_appointment_date.setForeground(lockedGray);
            t_appointment_date.setBorder(border);
            t_appointment_date.setBounds(64, 400, 265, 40);
            t_appointment_date.setBackground(backgroundGray);
            t_appointment_date.setEditable(false);
            pTables.add(t_appointment_date);

            JLabel l_appointment_time = new JLabel("Appointment's Time");
            l_appointment_time.setFont(labelFont);
            l_appointment_time.setForeground(black);
            l_appointment_time.setBounds(353, 376, 200, 20);
            pTables.add(l_appointment_time);

            t_appointment_time = new JTextField();
            t_appointment_time.setFont(bodyFont);
            t_appointment_time.setForeground(black);
            t_appointment_time.setBackground(backgroundGray);
            t_appointment_time.setBorder(border);
            t_appointment_time.setBounds(353, 400, 265, 40);
            t_appointment_time.setEditable(false);
            pTables.add(t_appointment_time);

            JLabel l_appointment_reason = new JLabel("Appointment's Reason");
            l_appointment_reason.setFont(labelFont);
            l_appointment_reason.setForeground(black);
            l_appointment_reason.setBounds(64, 464, 200, 20);
            pTables.add(l_appointment_reason);

            t_appointment_reason = new JTextArea();
            t_appointment_reason.setLineWrap(true);
            t_appointment_reason.setFont(bodyFont);
            t_appointment_reason.setForeground(black);
            t_appointment_reason.setBackground(backgroundGray);
            t_appointment_reason.setBorder(border);
            t_appointment_reason.setBounds(64, 488, 554, 139);
            t_appointment_reason.setEditable(false);
            pTables.add(t_appointment_reason);

            b_submit.setBounds(62, 657, 554, 40);
            b_submit.addActionListener(this);
            pTables.add(b_submit);

            pTables.updateUI();
        }
        if (e.getSource() == cbTables) {
            try {
                table = cbTables.getSelectedItem().toString();
                switch (panel){
                    case "create":
                        switch (table) {
                            case "vets":
                                pTables.setPreferredSize(new Dimension (642,700));

                                pTables.removeAll();

                                b_submit.removeActionListener(this);

                                lTitle.setBounds(64,90,100,38);
                                pTables.add(lTitle);

                                lDescription.setBounds(64,134,430,28);
                                pTables.add(lDescription);

                                lTables.setBounds(64,186,40 ,20);
                                pTables.add(lTables);

                                cbTables.setBounds(64,210,554,40);
                                cbTables.setSelectedItem("vets");
                                pTables.add(cbTables);

                                JLabel l_vet_id = new JLabel("Vet's ID");
                                l_vet_id.setFont(labelFont);
                                l_vet_id.setForeground(black);
                                l_vet_id.setBounds(64, 274, 80, 20);
                                pTables.add(l_vet_id);

                                t_vet_id = new JTextField("" + Read.getMaxVetID());
                                t_vet_id.setFont(bodyFont);
                                t_vet_id.setForeground(black);
                                t_vet_id.setBorder(border);
                                t_vet_id.setBounds(64, 298, 265, 40);
                                t_vet_id.setEditable(false);
                                pTables.add(t_vet_id);

                                JLabel l_vet_name = new JLabel("Vet's Name");
                                l_vet_name.setFont(labelFont);
                                l_vet_name.setForeground(black);
                                l_vet_name.setBounds(353, 274, 80, 20);
                                pTables.add(l_vet_name);

                                t_vet_name = new JTextField();
                                t_vet_name.setFont(bodyFont);
                                t_vet_name.setForeground(black);
                                t_vet_name.setBorder(border);
                                t_vet_name.setBounds(353, 298, 265, 40);
                                pTables.add(t_vet_name);

                                JLabel l_vet_other_details = new JLabel("Other Details");
                                l_vet_other_details.setFont(labelFont);
                                l_vet_other_details.setForeground(black);
                                l_vet_other_details.setBounds(64, 362, 100, 20);
                                pTables.add(l_vet_other_details);

                                pt_other_details = new JPlaceholderTextArea("e.g. Specializes on surgery");
                                pt_other_details.setLineWrap(true);
                                pt_other_details.setFont(bodyFont);
                                pt_other_details.setForeground(black);
                                pt_other_details.setBorder(border);
                                pt_other_details.setBounds(64, 386, 554, 139);
                                pTables.add(pt_other_details);

                                b_submit.setBounds(62, 549, 554, 40);
                                b_submit.addActionListener(this);
                                pTables.add(b_submit);

                                pTables.updateUI();
                                break;
                            case "dogs":
                                pTables.setPreferredSize(new Dimension (642,895));

                                pTables.removeAll();

                                b_submit.removeActionListener(this);

                                lTitle.setBounds(64,64,100,38);
                                pTables.add(lTitle);

                                lDescription.setBounds(64,108,430,28);
                                pTables.add(lDescription);

                                lTables.setBounds(64,160,40 ,20);
                                pTables.add(lTables);

                                cbTables.setBounds(64,184,554,40);
                                cbTables.setSelectedItem("dogs");
                                pTables.add(cbTables);

                                JLabel l_dog_id = new JLabel("Dog's ID");
                                l_dog_id.setFont(labelFont);
                                l_dog_id.setForeground(black);
                                l_dog_id.setBounds(64, 248, 90, 20);
                                pTables.add(l_dog_id);

                                t_dog_id = new JTextField("" + Read.getMaxDogID());
                                t_dog_id.setFont(bodyFont);
                                t_dog_id.setForeground(black);
                                t_dog_id.setBorder(border);
                                t_dog_id.setBounds(64, 272, 265, 40);
                                t_dog_id.setEditable(false);
                                pTables.add(t_dog_id);

                                JLabel l_dog_dogs_name = new JLabel("Dog's Name");
                                l_dog_dogs_name.setFont(labelFont);
                                l_dog_dogs_name.setForeground(black);
                                l_dog_dogs_name.setBounds(353, 248, 90, 20);
                                pTables.add(l_dog_dogs_name);

                                t_dog_name = new JTextField();
                                t_dog_name.setFont(bodyFont);
                                t_dog_name.setForeground(black);
                                t_dog_name.setBorder(border);
                                t_dog_name.setBounds(353, 272, 265, 40);
                                pTables.add(t_dog_name);

                                JLabel l_dog_place_of_birth = new JLabel("Place of Birth");
                                l_dog_place_of_birth.setFont(labelFont);
                                l_dog_place_of_birth.setForeground(black);
                                l_dog_place_of_birth.setBounds(64, 336, 275, 20);
                                pTables.add(l_dog_place_of_birth);

                                t_dog_place_of_birth = new JTextField();
                                t_dog_place_of_birth.setFont(bodyFont);
                                t_dog_place_of_birth.setForeground(black);
                                t_dog_place_of_birth.setBorder(border);
                                t_dog_place_of_birth.setBounds(64, 360, 265, 40);
                                pTables.add(t_dog_place_of_birth);

                                JLabel l_dog_date_of_birth = new JLabel("Date of Birth");
                                l_dog_date_of_birth.setFont(labelFont);
                                l_dog_date_of_birth.setForeground(black);
                                l_dog_date_of_birth.setBounds(353, 336, 269, 20);
                                pTables.add(l_dog_date_of_birth);

                                dc_date_of_birth = new JDateChooser("yyyy-MM-dd", "yyyy-MM-dd", '_');
                                dc_date_of_birth.setFont(bodyFont);
                                dc_date_of_birth.setForeground(black);
                                dc_date_of_birth.setBounds(353, 360, 265, 40);
                                pTables.add(dc_date_of_birth);

                                JLabel l_dog_born_in_litter = new JLabel("Born in Litter");
                                l_dog_born_in_litter.setFont(labelFont);
                                l_dog_born_in_litter.setForeground(black);
                                l_dog_born_in_litter.setBounds(64, 424, 90, 20);
                                pTables.add(l_dog_born_in_litter);

                                cb_dog_born_in_litter = new JComboBox();
                                cb_dog_born_in_litter.setFont(bodyFont);
                                cb_dog_born_in_litter.setForeground(black);
                                cb_dog_born_in_litter.setBounds(64,448,554,40);
                                cb_dog_born_in_litter.setBackground(Color.WHITE);
                                cb_data = Read.getLitterID();
                                for (String item : cb_data) {
                                    cb_dog_born_in_litter.addItem(item);
                                }
                                cb_dog_born_in_litter.setSelectedItem(null);
                                pTables.add(cb_dog_born_in_litter);

                                JLabel l_dog_gender_mf = new JLabel("Dog's Gender");
                                l_dog_gender_mf.setFont(labelFont);
                                l_dog_gender_mf.setForeground(black);
                                l_dog_gender_mf.setBounds(64, 512, 130, 20);
                                pTables.add(l_dog_gender_mf);

                                bg_group = new ButtonGroup();

                                rb_dog_female = new JRadioButton();
                                rb_dog_female.setFont(bodyFont);
                                rb_dog_female.setForeground(black);
                                rb_dog_female.setBounds(64, 536, 90, 20);
                                rb_dog_female.setText("Female");
                                rb_dog_female.setBackground(null);
                                bg_group.add(rb_dog_female);
                                pTables.add(rb_dog_female);

                                rb_dog_male = new JRadioButton();
                                rb_dog_male.setFont(bodyFont);
                                rb_dog_male.setForeground(black);
                                rb_dog_male.setBounds(211, 536, 80, 20);
                                rb_dog_male.setText("Male");
                                rb_dog_male.setBackground(null);
                                bg_group.add(rb_dog_male);
                                pTables.add(rb_dog_male);

                                JLabel l_dog_other_details = new JLabel("Other Details");
                                l_dog_other_details.setFont(labelFont);
                                l_dog_other_details.setForeground(black);
                                l_dog_other_details.setBounds(64, 584, 95, 20);
                                pTables.add(l_dog_other_details);

                                pt_other_details = new JPlaceholderTextArea("e.g. Is very playful");
                                pt_other_details.setLineWrap(true);
                                pt_other_details.setFont(bodyFont);
                                pt_other_details.setForeground(black);
                                pt_other_details.setBorder(border);
                                pt_other_details.setBounds(64, 608, 554, 139);
                                pTables.add(pt_other_details);

                                b_submit.setBounds(64, 771, 554, 40);
                                b_submit.addActionListener(this);
                                pTables.add(b_submit);

                                pTables.updateUI();
                                break;
                            case "litters":
                                pTables.setPreferredSize(new Dimension (642,820));

                                pTables.removeAll();

                                b_submit.removeActionListener(this);

                                lTitle.setBounds(64,44,100,38);
                                pTables.add(lTitle);

                                lDescription.setBounds(64,88,430,28);
                                pTables.add(lDescription);

                                lTables.setBounds(64,140,40 ,20);
                                pTables.add(lTables);

                                cbTables.setBounds(64,164,554,40);
                                cbTables.setSelectedItem("litters");
                                pTables.add(cbTables);

                                JLabel l_litter_id = new JLabel("Litter ID");
                                l_litter_id.setFont(labelFont);
                                l_litter_id.setForeground(black);
                                l_litter_id.setBounds(64, 228, 60, 20);
                                pTables.add(l_litter_id);

                                t_litter_id = new JTextField("" + Read.getMaxLitterID());
                                t_litter_id.setFont(bodyFont);
                                t_litter_id.setForeground(black);
                                t_litter_id.setBorder(border);
                                t_litter_id.setBounds(64, 252, 554, 40);
                                t_litter_id.setEditable(false);
                                pTables.add(t_litter_id);

                                JLabel l_litter_sire_dog_id = new JLabel("Sire Dog ID");
                                l_litter_sire_dog_id.setFont(labelFont);
                                l_litter_sire_dog_id.setForeground(black);
                                l_litter_sire_dog_id.setBounds(64, 316, 265, 20);
                                pTables.add(l_litter_sire_dog_id);

                                cb_sire_dog_id = new JComboBox();
                                cb_sire_dog_id.setFont(bodyFont);
                                cb_sire_dog_id.setForeground(black);
                                cb_sire_dog_id.setBounds(64,340,265,40);
                                cb_sire_dog_id.setBackground(Color.WHITE);
                                cb_data = Read.getDogID();
                                for (String item : cb_data) {
                                    cb_sire_dog_id.addItem(item);
                                }
                                cb_sire_dog_id.setSelectedItem(null);
                                pTables.add(cb_sire_dog_id);

                                JLabel l_litter_dam_dog_id = new JLabel("Dam Dog ID");
                                l_litter_dam_dog_id.setFont(labelFont);
                                l_litter_dam_dog_id.setForeground(black);
                                l_litter_dam_dog_id.setBounds(353, 316, 269, 20);
                                pTables.add(l_litter_dam_dog_id);

                                cb_dam_dog_id = new JComboBox();
                                cb_dam_dog_id.setFont(bodyFont);
                                cb_dam_dog_id.setForeground(black);
                                cb_dam_dog_id.setBounds(353,340,265,40);
                                cb_dam_dog_id.setBackground(Color.WHITE);
                                cb_data = Read.getDogID();
                                for (String item : cb_data) {
                                    cb_dam_dog_id.addItem(item);
                                }
                                cb_dam_dog_id.setSelectedItem(null);
                                pTables.add(cb_dam_dog_id);

                                JLabel l_litter_place_of_birth = new JLabel("Litter's Place of Birth");
                                l_litter_place_of_birth.setFont(labelFont);
                                l_litter_place_of_birth.setForeground(black);
                                l_litter_place_of_birth.setBounds(64, 400, 275, 20);
                                pTables.add(l_litter_place_of_birth);

                                t_litter_place_of_birth = new JTextField();
                                t_litter_place_of_birth.setFont(bodyFont);
                                t_litter_place_of_birth.setForeground(black);
                                t_litter_place_of_birth.setBorder(border);
                                t_litter_place_of_birth.setBounds(64, 424, 265, 40);
                                pTables.add(t_litter_place_of_birth);

                                JLabel l_litter_date_of_birth = new JLabel("Litter's Date of Birth");
                                l_litter_date_of_birth.setFont(labelFont);
                                l_litter_date_of_birth.setForeground(black);
                                l_litter_date_of_birth.setBounds(353, 400, 269, 20);
                                pTables.add(l_litter_date_of_birth);

                                dc_date_of_birth = new JDateChooser("yyyy-MM-dd", "yyyy-MM-dd", '_');
                                dc_date_of_birth.setFont(bodyFont);
                                dc_date_of_birth.setForeground(black);
                                dc_date_of_birth.setBounds(353, 424, 265, 40);
                                pTables.add(dc_date_of_birth);

                                JLabel l_litter_other_details = new JLabel("Other Details");
                                l_litter_other_details.setFont(labelFont);
                                l_litter_other_details.setForeground(black);
                                l_litter_other_details.setBounds(64, 484, 100, 20);
                                pTables.add(l_litter_other_details);

                                pt_other_details = new JPlaceholderTextArea("e.g. All puppies are healthy, Five puppies in total");
                                pt_other_details.setLineWrap(true);
                                pt_other_details.setFont(bodyFont);
                                pt_other_details.setForeground(black);
                                pt_other_details.setBorder(border);
                                pt_other_details.setBounds(64, 512, 554, 139);
                                pTables.add(pt_other_details);

                                b_submit.setBounds(64, 685, 554, 40);
                                b_submit.addActionListener(this);
                                pTables.add(b_submit);

                                pTables.updateUI();
                                break;
                            case "relationships":
                                pTables.setPreferredSize(new Dimension (642,700));

                                pTables.removeAll();

                                b_submit.removeActionListener(this);

                                lTitle.setBounds(64,40,100,38);
                                pTables.add(lTitle);

                                lDescription.setBounds(64,84,430,28);
                                pTables.add(lDescription);

                                lTables.setBounds(64,136,40 ,20);
                                pTables.add(lTables);

                                cbTables.setBounds(64,160,554,40);
                                cbTables.setSelectedItem("relationships");
                                pTables.add(cbTables);

                                JLabel l_relationship_id = new JLabel("Relationship ID");
                                l_relationship_id.setFont(labelFont);
                                l_relationship_id.setForeground(black);
                                l_relationship_id.setBounds(64, 224, 110, 20);
                                pTables.add(l_relationship_id);

                                t_relationship_id = new JTextField("" + Read.getMaxRelationshipID());
                                t_relationship_id.setFont(bodyFont);
                                t_relationship_id.setForeground(black);
                                t_relationship_id.setBorder(border);
                                t_relationship_id.setBounds(64, 248, 265, 40);
                                t_relationship_id.setEditable(false);
                                pTables.add(t_relationship_id);

                                JLabel l_relationship_code = new JLabel("Relationship Code");
                                l_relationship_code.setFont(labelFont);
                                l_relationship_code.setForeground(black);
                                l_relationship_code.setBounds(353, 224, 130, 20);
                                pTables.add(l_relationship_code);

                                cb_relationship_code = new JComboBox();
                                cb_relationship_code.setFont(bodyFont);
                                cb_relationship_code.setForeground(black);
                                cb_relationship_code.setBounds(353, 248, 265, 40);
                                cb_relationship_code.setBackground(Color.WHITE);
                                cb_data = Read.getRelationshipCode();
                                for (String item : cb_data) {
                                    cb_relationship_code.addItem(item);
                                }
                                cb_relationship_code.setSelectedItem(null);
                                pTables.add(cb_relationship_code);

                                JLabel l_relationship_sire_dog_id = new JLabel("Dog 1 ID");
                                l_relationship_sire_dog_id.setFont(labelFont);
                                l_relationship_sire_dog_id.setForeground(black);
                                l_relationship_sire_dog_id.setBounds(64, 312, 265, 20);
                                pTables.add(l_relationship_sire_dog_id);

                                cb_dog_1_id = new JComboBox();
                                cb_dog_1_id.setFont(bodyFont);
                                cb_dog_1_id.setForeground(black);
                                cb_dog_1_id.setBounds(64,336,265,40);
                                cb_dog_1_id.setBackground(Color.WHITE);
                                cb_data = Read.getDogID();
                                for (String item : cb_data) {
                                    cb_dog_1_id.addItem(item);
                                }
                                cb_dog_1_id.setSelectedItem(null);
                                pTables.add(cb_dog_1_id);

                                JLabel l_relationship_dam_dog_id = new JLabel("Dog 2 ID");
                                l_relationship_dam_dog_id.setFont(labelFont);
                                l_relationship_dam_dog_id.setForeground(black);
                                l_relationship_dam_dog_id.setBounds(353, 312, 269, 20);
                                pTables.add(l_relationship_dam_dog_id);

                                cb_dog_2_id = new JComboBox();
                                cb_dog_2_id.setFont(bodyFont);
                                cb_dog_2_id.setForeground(black);
                                cb_dog_2_id.setBounds(353,336,265,40);
                                cb_dog_2_id.setBackground(Color.WHITE);
                                cb_data = Read.getDogID();
                                for (String item : cb_data) {
                                    cb_dog_2_id.addItem(item);
                                }
                                cb_dog_2_id.setSelectedItem(null);
                                pTables.add(cb_dog_2_id);

                                JLabel l_relationship_other_details = new JLabel("Other Details");
                                l_relationship_other_details.setFont(labelFont);
                                l_relationship_other_details.setForeground(black);
                                l_relationship_other_details.setBounds(64, 400, 100, 20);
                                pTables.add(l_relationship_other_details);

                                pt_other_details = new JPlaceholderTextArea("e.g. The dogs are siblings");
                                pt_other_details.setLineWrap(true);
                                pt_other_details.setFont(bodyFont);
                                pt_other_details.setForeground(black);
                                pt_other_details.setBorder(border);
                                pt_other_details.setBounds(64, 424, 554, 139);
                                pTables.add(pt_other_details);

                                b_submit.setBounds(64, 587, 554, 40);
                                b_submit.addActionListener(this);
                                pTables.add(b_submit);

                                pTables.updateUI();
                                break;
                            case "relationship_types":
                                pTables.setPreferredSize(new Dimension (642,700));

                                pTables.removeAll();

                                b_submit.removeActionListener(this);

                                b_submit.removeActionListener(this);

                                lTitle.setBounds(64,90,100,38);
                                pTables.add(lTitle);

                                lDescription.setBounds(64,134,430,28);
                                pTables.add(lDescription);

                                lTables.setBounds(64,186,40 ,20);
                                pTables.add(lTables);

                                cbTables.setBounds(64,210,554,40);
                                cbTables.setSelectedItem("relationship_types");
                                pTables.add(cbTables);

                                JLabel l_relationships_code = new JLabel("Relationship Code");
                                l_relationships_code.setFont(labelFont);
                                l_relationships_code.setForeground(black);
                                l_relationships_code.setBounds(64, 274, 130, 20);
                                pTables.add(l_relationships_code);

                                t_relationship_code = new JTextField("" + Read.getMaxRelationshipCode());
                                t_relationship_code.setFont(bodyFont);
                                t_relationship_code.setForeground(black);
                                t_relationship_code.setBorder(border);
                                t_relationship_code.setBounds(64, 298, 554, 40);
                                t_relationship_code.setEditable(false);
                                pTables.add(t_relationship_code);

                                JLabel l_relationships_description = new JLabel("Relationship Description");
                                l_relationships_description.setFont(labelFont);
                                l_relationships_description.setForeground(black);
                                l_relationships_description.setBounds(64, 362, 200, 20);
                                pTables.add(l_relationships_description);

                                pt_relationships_description = new JPlaceholderTextArea("e.g. Siblings");
                                pt_relationships_description.setLineWrap(true);
                                pt_relationships_description.setFont(bodyFont);
                                pt_relationships_description.setForeground(black);
                                pt_relationships_description.setBorder(border);
                                pt_relationships_description.setBounds(64, 386, 554, 139);
                                pTables.add(pt_relationships_description);

                                b_submit.setBounds(64, 549, 554, 40);
                                b_submit.addActionListener(this);
                                pTables.add(b_submit);

                                pTables.updateUI();
                                break;
                            case "health_records":
                                pTables.setPreferredSize(new Dimension (642,940));

                                pTables.removeAll();

                                b_submit.removeActionListener(this);

                                lTitle.setBounds(64,64,100,38);
                                pTables.add(lTitle);

                                lDescription.setBounds(64,108,430,28);
                                pTables.add(lDescription);

                                lTables.setBounds(64,160,40 ,20);
                                pTables.add(lTables);

                                cbTables.setBounds(64,184,554,40);
                                cbTables.setSelectedItem("health_records");
                                pTables.add(cbTables);

                                JLabel l_health_record_id = new JLabel("Health Record ID");
                                l_health_record_id.setFont(labelFont);
                                l_health_record_id.setForeground(black);
                                l_health_record_id.setBounds(64, 248, 130, 20);
                                pTables.add(l_health_record_id);

                                t_health_record_id = new JTextField("" + Read.getMaxHealthRecordID());
                                t_health_record_id.setFont(bodyFont);
                                t_health_record_id.setForeground(black);
                                t_health_record_id.setBorder(border);
                                t_health_record_id.setBounds(64, 272, 265, 40);
                                t_health_record_id.setEditable(false);
                                pTables.add(t_health_record_id);

                                JLabel l_health_record_vet_id = new JLabel("Vet ID");
                                l_health_record_vet_id.setFont(labelFont);
                                l_health_record_vet_id.setForeground(black);
                                l_health_record_vet_id.setBounds(353, 248, 130, 20);
                                pTables.add(l_health_record_vet_id);

                                cb_vet_id = new JComboBox();
                                cb_vet_id.setFont(bodyFont);
                                cb_vet_id.setForeground(black);
                                cb_vet_id.setBounds(353,272,265,40);
                                cb_vet_id.setBackground(Color.WHITE);
                                cb_data = Read.getVetID();
                                for (String item : cb_data) {
                                    cb_vet_id.addItem(item);
                                }
                                cb_vet_id.setSelectedItem(null);
                                pTables.add(cb_vet_id);

                                JLabel l_health_record_dog_id = new JLabel("Dog ID");
                                l_health_record_dog_id.setFont(labelFont);
                                l_health_record_dog_id.setForeground(black);
                                l_health_record_dog_id.setBounds(64, 336, 130, 20);
                                pTables.add(l_health_record_dog_id);

                                cb_dog_id = new JComboBox();
                                cb_dog_id.setFont(bodyFont);
                                cb_dog_id.setForeground(black);
                                cb_dog_id.setBounds(64,360,554,40);
                                cb_dog_id.setBackground(Color.WHITE);
                                cb_data = Read.getDogID();
                                for (String item : cb_data) {
                                    cb_dog_id.addItem(item);
                                }
                                cb_dog_id.setSelectedItem(null);
                                pTables.add(cb_dog_id);

                                JLabel l_health_record_summary = new JLabel("Summary");
                                l_health_record_summary.setFont(labelFont);
                                l_health_record_summary.setForeground(black);
                                l_health_record_summary.setBounds(64, 424, 200, 20);
                                pTables.add(l_health_record_summary);

                                pt_summary = new JPlaceholderTextArea("e.g. The dog was administered the vaccines");
                                pt_summary.setLineWrap(true);
                                pt_summary.setFont(bodyFont);
                                pt_summary.setForeground(black);
                                pt_summary.setBorder(border);
                                pt_summary.setBounds(64, 448, 554, 139);
                                pTables.add(pt_summary);

                                JLabel l_health_record_other_details = new JLabel("Details");
                                l_health_record_other_details.setFont(labelFont);
                                l_health_record_other_details.setForeground(black);
                                l_health_record_other_details.setBounds(64, 611, 100, 20);
                                pTables.add(l_health_record_other_details);

                                pt_other_details = new JPlaceholderTextArea("e.g. The dog is healthy");
                                pt_other_details.setLineWrap(true);
                                pt_other_details.setFont(bodyFont);
                                pt_other_details.setForeground(black);
                                pt_other_details.setBorder(border);
                                pt_other_details.setBounds(64, 635, 554, 139);
                                pTables.add(pt_other_details);

                                b_submit.setBounds(64, 798, 554, 40);
                                b_submit.addActionListener(this);
                                pTables.add(b_submit);

                                pTables.updateUI();
                                break;
                            case "common_problems":
                                pTables.setPreferredSize(new Dimension (642,700));

                                pTables.removeAll();

                                b_submit.removeActionListener(this);

                                lTitle.setBounds(64,90,100,38);
                                pTables.add(lTitle);

                                lDescription.setBounds(64,134,430,28);
                                pTables.add(lDescription);

                                lTables.setBounds(64,186,40 ,20);
                                pTables.add(lTables);

                                cbTables.setBounds(64,210,554,40);
                                cbTables.setSelectedItem("common_problems");
                                pTables.add(cbTables);

                                JLabel l_common_problem_code = new JLabel("Problem Code");
                                l_common_problem_code.setFont(labelFont);
                                l_common_problem_code.setForeground(black);
                                l_common_problem_code.setBounds(64, 274, 130, 20);
                                pTables.add(l_common_problem_code);

                                t_problem_code = new JTextField("" + Read.getMaxProblemCode());
                                t_problem_code.setFont(bodyFont);
                                t_problem_code.setForeground(black);
                                t_problem_code.setBorder(border);
                                t_problem_code.setBounds(64, 298, 554, 40);
                                t_problem_code.setEditable(false);
                                pTables.add(t_problem_code);

                                JLabel l_common_problem_description = new JLabel("Problem Description");
                                l_common_problem_description.setFont(labelFont);
                                l_common_problem_description.setForeground(black);
                                l_common_problem_description.setBounds(64, 362, 200, 20);
                                pTables.add(l_common_problem_description);

                                pt_problem_description = new JPlaceholderTextArea("e.g. Fever: The dog has high temperature, coughing, and runny nose");
                                pt_problem_description.setLineWrap(true);
                                pt_problem_description.setFont(bodyFont);
                                pt_problem_description.setForeground(black);
                                pt_problem_description.setBorder(border);
                                pt_problem_description.setBounds(64, 386, 554, 139);
                                pTables.add(pt_problem_description);

                                b_submit.setBounds(64, 549, 554, 40);
                                b_submit.addActionListener(this);
                                pTables.add(b_submit);

                                pTables.updateUI();
                                break;
                            case "dog_problems":
                                pTables.setPreferredSize(new Dimension (642,860));

                                pTables.removeAll();

                                b_submit.removeActionListener(this);

                                lTitle.setBounds(64,64,100,38);
                                pTables.add(lTitle);

                                lDescription.setBounds(64,108,430,28);
                                pTables.add(lDescription);

                                lTables.setBounds(64,160,40 ,20);
                                pTables.add(lTables);

                                cbTables.setBounds(64,184,554,40);
                                cbTables.setSelectedItem("dog_problems");
                                pTables.add(cbTables);

                                JLabel l_dog_problem_code = new JLabel("Problem Code");
                                l_dog_problem_code.setFont(labelFont);
                                l_dog_problem_code.setForeground(black);
                                l_dog_problem_code.setBounds(64, 248, 164, 20);
                                pTables.add(l_dog_problem_code);

                                cb_problem_code = new JComboBox();
                                cb_problem_code.setFont(bodyFont);
                                cb_problem_code.setForeground(black);
                                cb_problem_code.setBounds(64, 272, 164, 40);
                                cb_problem_code.setBackground(Color.WHITE);
                                cb_data = Read.getProblemCode();
                                for (String item : cb_data) {
                                    cb_problem_code.addItem(item);
                                }
                                cb_problem_code.setSelectedItem(null);
                                pTables.add(cb_problem_code);

                                JLabel l_dog_problem_health_record_id = new JLabel("Health Record ID");
                                l_dog_problem_health_record_id.setFont(labelFont);
                                l_dog_problem_health_record_id.setForeground(black);
                                l_dog_problem_health_record_id.setBounds(256, 248, 164, 20);
                                pTables.add(l_dog_problem_health_record_id);

                                cb_health_record_id = new JComboBox();
                                cb_health_record_id.setFont(bodyFont);
                                cb_health_record_id.setForeground(black);
                                cb_health_record_id.setBounds(256,272,164,40);
                                cb_health_record_id.setBackground(Color.WHITE);
                                cb_data = Read.getHealthRecordID();
                                for (String item : cb_data) {
                                    cb_health_record_id.addItem(item);
                                }
                                cb_health_record_id.setSelectedItem(null);
                                pTables.add(cb_health_record_id);

                                JLabel l_dog_problem_date_of_problem = new JLabel("Date of Problem");
                                l_dog_problem_date_of_problem.setFont(labelFont);
                                l_dog_problem_date_of_problem.setForeground(black);
                                l_dog_problem_date_of_problem.setBounds(449, 248, 164, 20);
                                pTables.add(l_dog_problem_date_of_problem);

                                dc_date_of_problem = new JDateChooser("yyyy-MM-dd", "yyyy-MM-dd", '_');
                                dc_date_of_problem.setFont(bodyFont);
                                dc_date_of_problem.setForeground(black);
                                dc_date_of_problem.setBounds(449, 272, 165, 40);
                                pTables.add(dc_date_of_problem);

                                JLabel l_dog_problem_treatment = new JLabel("Treatment");
                                l_dog_problem_treatment.setFont(labelFont);
                                l_dog_problem_treatment.setForeground(black);
                                l_dog_problem_treatment.setBounds(64, 336, 200, 20);
                                pTables.add(l_dog_problem_treatment);

                                pt_problem_treatment = new JPlaceholderTextArea("e.g. The dog was given antibiotics");
                                pt_problem_treatment.setLineWrap(true);
                                pt_problem_treatment.setFont(bodyFont);
                                pt_problem_treatment.setForeground(black);
                                pt_problem_treatment.setBorder(border);
                                pt_problem_treatment.setBounds(64, 360, 554, 139);
                                pTables.add(pt_problem_treatment);

                                JLabel l_dog_problem_other_details = new JLabel("Other Details");
                                l_dog_problem_other_details.setFont(labelFont);
                                l_dog_problem_other_details.setForeground(black);
                                l_dog_problem_other_details.setBounds(64, 523, 100, 20);
                                pTables.add(l_dog_problem_other_details);

                                pt_other_details = new JPlaceholderTextArea("e.g. The dog is healthy");
                                pt_other_details.setLineWrap(true);
                                pt_other_details.setFont(bodyFont);
                                pt_other_details.setForeground(black);
                                pt_other_details.setBorder(border);
                                pt_other_details.setBounds(64, 547, 554, 139);
                                pTables.add(pt_other_details);

                                b_submit.setBounds(64, 710, 554, 40);
                                b_submit.addActionListener(this);
                                pTables.add(b_submit);

                                pTables.updateUI();
                                break;
                        }
                        break;
                    case "read":
                        break;
                    case "update":
                        switch (table) {
                            case "vets":
                                pTables.setPreferredSize(new Dimension (642,1060));

                                pTables.removeAll();

                                b_submit.removeActionListener(this);

                                lTitle.setBounds(64,64,120,38);
                                pTables.add(lTitle);

                                lDescription.setBounds(64,108,554,28);
                                pTables.add(lDescription);

                                lTables.setBounds(64,160,40 ,20);
                                pTables.add(lTables);

                                cbTables.setBounds(64,184,554,40);
                                cbTables.setSelectedItem("vets");
                                pTables.add(cbTables);

                                JLabel l_vet = new JLabel("Current Information");
                                l_vet.setFont(subtitleFont);
                                l_vet.setForeground(black);
                                l_vet.setBounds(64, 248, 280, 32);
                                pTables.add(l_vet);

                                JLabel l_vet_id = new JLabel("Vet's ID");
                                l_vet_id.setFont(labelFont);
                                l_vet_id.setForeground(black);
                                l_vet_id.setBounds(64, 304, 100, 20);
                                pTables.add(l_vet_id);

                                cb_vet_id = new JComboBox();
                                cb_vet_id.setFont(bodyFont);
                                cb_vet_id.setForeground(black);
                                cb_vet_id.setBounds(64, 328, 265, 40);
                                cb_vet_id.setBackground(Color.WHITE);
                                cb_data = Read.getVetID();
                                for (String item : cb_data) {
                                    cb_vet_id.addItem(item);
                                }
                                cb_vet_id.setSelectedItem(null);
                                cb_vet_id.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        try {
                                            vet_id = Integer.parseInt(cb_vet_id.getSelectedItem().toString());
                                            ArrayList<String> info = Read.getVetInfo(vet_id);
                                            t_vet_name.setText(info.get(0));
                                            t_other_details.setText(info.get(1));
                                        }
                                        catch (Exception ex) {
                                        }
                                    }
                                });
                                pTables.add(cb_vet_id);

                                JLabel l_vet_name = new JLabel("Current Vet's Name");
                                l_vet_name.setFont(labelFont);
                                l_vet_name.setForeground(black);
                                l_vet_name.setBounds(353, 304, 160, 20);
                                pTables.add(l_vet_name);

                                t_vet_name = new JTextField();
                                t_vet_name.setFont(bodyFont);
                                t_vet_name.setForeground(lockedGray);
                                t_vet_name.setBorder(border);
                                t_vet_name.setBounds(353, 328, 265, 40);
                                t_vet_name.setBackground(backgroundGray);
                                t_vet_name.setEditable(false);
                                pTables.add(t_vet_name);

                                JLabel l_vet_other_details = new JLabel("Current Details");
                                l_vet_other_details.setFont(labelFont);
                                l_vet_other_details.setForeground(black);
                                l_vet_other_details.setBounds(64, 392, 150, 20);
                                pTables.add(l_vet_other_details);

                                t_other_details = new JTextArea();
                                t_other_details.setLineWrap(true);
                                t_other_details.setFont(bodyFont);
                                t_other_details.setForeground(lockedGray);
                                t_other_details.setBorder(border);
                                t_other_details.setBounds(64, 416, 554, 139);
                                t_other_details.setBackground(backgroundGray);
                                t_other_details.setEditable(false);
                                pTables.add(t_other_details);

                                JLabel l_vet_update = new JLabel("New Information");
                                l_vet_update.setFont(subtitleFont);
                                l_vet_update.setForeground(black);
                                l_vet_update.setBounds(64, 579, 250, 32);
                                pTables.add(l_vet_update);

                                JLabel l_vet_name_update = new JLabel("New Vet's Name");
                                l_vet_name_update.setFont(labelFont);
                                l_vet_name_update.setForeground(black);
                                l_vet_name_update.setBounds(64, 635, 120, 20);
                                pTables.add(l_vet_name_update);

                                t_vet_name_update = new JTextField();
                                t_vet_name_update.setFont(bodyFont);
                                t_vet_name_update.setForeground(black);
                                t_vet_name_update.setBorder(border);
                                t_vet_name_update.setBounds(64, 659, 554, 40);
                                pTables.add(t_vet_name_update);

                                JLabel l_vet_other_details_update = new JLabel("New Details");
                                l_vet_other_details_update.setFont(labelFont);
                                l_vet_other_details_update.setForeground(black);
                                l_vet_other_details_update.setBounds(64, 723, 100, 20);
                                pTables.add(l_vet_other_details_update);

                                pt_other_details_update = new JPlaceholderTextArea("e.g. Specializes on surgery");
                                pt_other_details_update.setLineWrap(true);
                                pt_other_details_update.setFont(bodyFont);
                                pt_other_details_update.setForeground(black);
                                pt_other_details_update.setBorder(border);
                                pt_other_details_update.setBounds(64, 747, 554, 139);
                                pTables.add(pt_other_details_update);

                                b_submit.setBounds(62, 910, 554, 40);
                                b_submit.addActionListener(this);
                                pTables.add(b_submit);

                                pTables.updateUI();
                                break;
                            case "dogs":
                                pTables.setPreferredSize(new Dimension (642,1470));

                                pTables.removeAll();

                                b_submit.removeActionListener(this);

                                lTitle.setBounds(64,64,120,38);
                                pTables.add(lTitle);

                                lDescription.setBounds(64,108,554,28);
                                pTables.add(lDescription);

                                lTables.setBounds(64,160,40 ,20);
                                pTables.add(lTables);

                                cbTables.setBounds(64,184,554,40);
                                cbTables.setSelectedItem("dogs");
                                pTables.add(cbTables);

                                JLabel l_dog = new JLabel("Current Information");
                                l_dog.setFont(subtitleFont);
                                l_dog.setForeground(black);
                                l_dog.setBounds(64, 248, 280, 32);
                                pTables.add(l_dog);

                                JLabel l_dog_id = new JLabel("Current Dog's ID");
                                l_dog_id.setFont(labelFont);
                                l_dog_id.setForeground(black);
                                l_dog_id.setBounds(64, 304, 265, 20);
                                pTables.add(l_dog_id);

                                cb_dog_id = new JComboBox();
                                cb_dog_id.setFont(bodyFont);
                                cb_dog_id.setForeground(black);
                                cb_dog_id.setBounds(64, 328, 265, 40);
                                cb_dog_id.setBackground(Color.WHITE);
                                cb_data = Read.getDogID();
                                for (String item : cb_data) {
                                    cb_dog_id.addItem(item);
                                }
                                cb_dog_id.setSelectedItem(null);
                                cb_dog_id.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        dog_id = Integer.parseInt(cb_dog_id.getSelectedItem().toString());
                                        ArrayList<String> info = Read.getDogInfo(dog_id);
                                        t_dog_name.setText(info.get(0));
                                        t_dog_place_of_birth.setText(info.get(1));
                                        t_date_of_birth.setText(info.get(2));
                                        t_dog_born_in_litter.setText(info.get(3));
                                        if (info.get(4).equals("F")) {
                                            rb_dog_female.setSelected(true);
                                        }
                                        if (info.get(4).equals("M")) {
                                            rb_dog_male.setSelected(true);
                                        }
                                        t_other_details.setText(info.get(5));
                                    }
                                });
                                pTables.add(cb_dog_id);

                                JLabel l_dog_dogs_name = new JLabel("Current Dog's Name");
                                l_dog_dogs_name.setFont(labelFont);
                                l_dog_dogs_name.setForeground(black);
                                l_dog_dogs_name.setBounds(353, 304, 265, 20);
                                pTables.add(l_dog_dogs_name);

                                t_dog_name = new JTextField();
                                t_dog_name.setFont(bodyFont);
                                t_dog_name.setForeground(lockedGray);
                                t_dog_name.setBorder(border);
                                t_dog_name.setBounds(353, 328, 265, 40);
                                t_dog_name.setBackground(backgroundGray);
                                t_dog_name.setEditable(false);
                                pTables.add(t_dog_name);

                                JLabel l_dog_place_of_birth = new JLabel("Current Place of Birth");
                                l_dog_place_of_birth.setFont(labelFont);
                                l_dog_place_of_birth.setForeground(black);
                                l_dog_place_of_birth.setBounds(64, 392, 265, 20);
                                pTables.add(l_dog_place_of_birth);

                                t_dog_place_of_birth = new JTextField();
                                t_dog_place_of_birth.setFont(bodyFont);
                                t_dog_place_of_birth.setForeground(lockedGray);
                                t_dog_place_of_birth.setBorder(border);
                                t_dog_place_of_birth.setBounds(64, 416, 265, 40);
                                t_dog_place_of_birth.setBackground(backgroundGray);
                                t_dog_place_of_birth.setEditable(false);
                                pTables.add(t_dog_place_of_birth);

                                JLabel l_dog_date_of_birth = new JLabel("Current Date of Birth");
                                l_dog_date_of_birth.setFont(labelFont);
                                l_dog_date_of_birth.setForeground(black);
                                l_dog_date_of_birth.setBounds(353, 392, 265, 20);
                                pTables.add(l_dog_date_of_birth);

                                t_date_of_birth = new JTextField();
                                t_date_of_birth.setFont(bodyFont);
                                t_date_of_birth.setForeground(lockedGray);
                                t_date_of_birth.setBorder(border);
                                t_date_of_birth.setBounds(353, 416, 265, 40);
                                t_date_of_birth.setBackground(backgroundGray);
                                t_date_of_birth.setEditable(false);
                                pTables.add(t_date_of_birth);

                                JLabel l_dog_born_in_litter = new JLabel("Current Born in Litter");
                                l_dog_born_in_litter.setFont(labelFont);
                                l_dog_born_in_litter.setForeground(black);
                                l_dog_born_in_litter.setBounds(64, 480, 265, 20);
                                pTables.add(l_dog_born_in_litter);

                                t_dog_born_in_litter = new JTextField();
                                t_dog_born_in_litter.setFont(bodyFont);
                                t_dog_born_in_litter.setForeground(lockedGray);
                                t_dog_born_in_litter.setBorder(border);
                                t_dog_born_in_litter.setBounds(64,504,554,40);
                                t_dog_born_in_litter.setBackground(backgroundGray);
                                t_dog_born_in_litter.setEditable(false);
                                pTables.add(t_dog_born_in_litter);

                                JLabel l_dog_gender_mf = new JLabel("Current Dog's Gender");
                                l_dog_gender_mf.setFont(labelFont);
                                l_dog_gender_mf.setForeground(black);
                                l_dog_gender_mf.setBounds(64, 566, 265, 20);
                                pTables.add(l_dog_gender_mf);

                                bg_group = new ButtonGroup();

                                rb_dog_female = new JRadioButton();
                                rb_dog_female.setFont(bodyFont);
                                rb_dog_female.setForeground(black);
                                rb_dog_female.setBounds(64, 592, 90, 20);
                                rb_dog_female.setText("Female");
                                rb_dog_female.setBackground(null);
                                rb_dog_female.setEnabled(false);
                                bg_group.add(rb_dog_female);
                                pTables.add(rb_dog_female);

                                rb_dog_male = new JRadioButton();
                                rb_dog_male.setFont(bodyFont);
                                rb_dog_male.setForeground(black);
                                rb_dog_male.setBounds(211, 592, 80, 20);
                                rb_dog_male.setText("Male");
                                rb_dog_male.setBackground(null);
                                rb_dog_male.setEnabled(false);
                                bg_group.add(rb_dog_male);
                                pTables.add(rb_dog_male);

                                JLabel l_dog_other_details = new JLabel("Current Details");
                                l_dog_other_details.setFont(labelFont);
                                l_dog_other_details.setForeground(black);
                                l_dog_other_details.setBounds(64, 640, 265, 20);
                                pTables.add(l_dog_other_details);

                                t_other_details = new JTextArea();
                                t_other_details.setLineWrap(true);
                                t_other_details.setFont(bodyFont);
                                t_other_details.setForeground(lockedGray);
                                t_other_details.setBorder(border);
                                t_other_details.setBounds(64, 664, 554, 139);
                                t_other_details.setBackground(backgroundGray);
                                t_other_details.setEditable(false);
                                pTables.add(t_other_details);

                                JLabel l_dog_update = new JLabel("New Information");
                                l_dog_update.setFont(subtitleFont);
                                l_dog_update.setForeground(black);
                                l_dog_update.setBounds(64, 827, 250, 32);
                                pTables.add(l_dog_update);

                                JLabel l_dog_name_update = new JLabel("New Dog's Name");
                                l_dog_name_update.setFont(labelFont);
                                l_dog_name_update.setForeground(black);
                                l_dog_name_update.setBounds(64, 883, 200, 20);
                                pTables.add(l_dog_name_update);

                                t_dogs_name_update = new JTextField();
                                t_dogs_name_update.setFont(bodyFont);
                                t_dogs_name_update.setForeground(black);
                                t_dogs_name_update.setBorder(border);
                                t_dogs_name_update.setBounds(64, 907, 265, 40);
                                pTables.add(t_dogs_name_update);

                                JLabel l_dog_place_of_birth_update = new JLabel("New Place of Birth");
                                l_dog_place_of_birth_update.setFont(labelFont);
                                l_dog_place_of_birth_update.setForeground(black);
                                l_dog_place_of_birth_update.setBounds(353, 883, 200, 20);
                                pTables.add(l_dog_place_of_birth_update);

                                t_dog_place_of_birth_update = new JTextField();
                                t_dog_place_of_birth_update.setFont(bodyFont);
                                t_dog_place_of_birth_update.setForeground(black);
                                t_dog_place_of_birth_update.setBorder(border);
                                t_dog_place_of_birth_update.setBounds(353, 907, 265, 40);
                                pTables.add(t_dog_place_of_birth_update);

                                JLabel l_dog_date_of_birth_update = new JLabel("New Date of Birth");
                                l_dog_date_of_birth_update.setFont(labelFont);
                                l_dog_date_of_birth_update.setForeground(black);
                                l_dog_date_of_birth_update.setBounds(64, 971, 200, 20);
                                pTables.add(l_dog_date_of_birth_update);

                                dc_date_of_birth_update = new JDateChooser("yyyy-MM-dd", "yyyy-MM-dd", '_');
                                dc_date_of_birth_update.setFont(bodyFont);
                                dc_date_of_birth_update.setForeground(black);
                                dc_date_of_birth_update.setBounds(64, 995, 265, 40);
                                pTables.add(dc_date_of_birth_update);

                                JLabel l_dog_born_in_litter_update = new JLabel("New Born in Litter");
                                l_dog_born_in_litter_update.setFont(labelFont);
                                l_dog_born_in_litter_update.setForeground(black);
                                l_dog_born_in_litter_update.setBounds(353, 971, 200, 20);
                                pTables.add(l_dog_born_in_litter_update);

                                cb_dog_born_in_litter_update = new JComboBox();
                                cb_dog_born_in_litter_update.setFont(bodyFont);
                                cb_dog_born_in_litter_update.setForeground(black);
                                cb_dog_born_in_litter_update.setBounds(353,995,265,40);
                                cb_dog_born_in_litter_update.setBackground(Color.WHITE);
                                cb_data = Read.getLitterID();
                                for (String item : cb_data) {
                                    cb_dog_born_in_litter_update.addItem(item);
                                }
                                cb_dog_born_in_litter_update.setSelectedItem(null);
                                pTables.add(cb_dog_born_in_litter_update);

                                JLabel l_dog_gender_mf_update = new JLabel("New Dog's Gender");
                                l_dog_gender_mf_update.setFont(labelFont);
                                l_dog_gender_mf_update.setForeground(black);
                                l_dog_gender_mf_update.setBounds(64, 1059, 130, 20);
                                pTables.add(l_dog_gender_mf_update);

                                bg_group_update = new ButtonGroup();

                                rb_dog_female_update = new JRadioButton();
                                rb_dog_female_update.setFont(bodyFont);
                                rb_dog_female_update.setForeground(black);
                                rb_dog_female_update.setBounds(64,1083,80,20);
                                rb_dog_female_update.setText("Female");
                                rb_dog_female_update.setBackground(null);
                                bg_group_update.add(rb_dog_female_update);
                                pTables.add(rb_dog_female_update);

                                rb_dog_male_update = new JRadioButton();
                                rb_dog_male_update.setFont(bodyFont);
                                rb_dog_male_update.setForeground(black);
                                rb_dog_male_update.setBounds(211, 1083, 80, 20);
                                rb_dog_male_update.setText("Male");
                                rb_dog_male_update.setBackground(null);
                                bg_group_update.add(rb_dog_male_update);
                                pTables.add(rb_dog_male_update);

                                JLabel l_dog_other_details_update = new JLabel("New Details");
                                l_dog_other_details_update.setFont(labelFont);
                                l_dog_other_details_update.setForeground(black);
                                l_dog_other_details_update.setBounds(64, 1127, 95, 20);
                                pTables.add(l_dog_other_details_update);

                                pt_other_details_update = new JPlaceholderTextArea("e.g. Is very playful");
                                pt_other_details_update.setLineWrap(true);
                                pt_other_details_update.setFont(bodyFont);
                                pt_other_details_update.setForeground(black);
                                pt_other_details_update.setBorder(border);
                                pt_other_details_update.setBounds(64, 1151, 554, 139);
                                pTables.add(pt_other_details_update);

                                b_submit.setBounds(64, 1314, 554, 40);
                                b_submit.addActionListener(this);
                                pTables.add(b_submit);

                                pTables.updateUI();
                                break;
                            case "litters":
                                pTables.setPreferredSize(new Dimension (642,1320));

                                pTables.removeAll();

                                b_submit.removeActionListener(this);

                                lTitle.setBounds(64,64,265,38);
                                pTables.add(lTitle);

                                lDescription.setBounds(64,108,554,28);
                                pTables.add(lDescription);

                                lTables.setBounds(64,160,40 ,20);
                                pTables.add(lTables);

                                cbTables.setBounds(64,184,554,40);
                                cbTables.setSelectedItem("litters");
                                pTables.add(cbTables);

                                JLabel l_litter = new JLabel("Current Information");
                                l_litter.setFont(subtitleFont);
                                l_litter.setForeground(black);
                                l_litter.setBounds(64, 248, 280, 32);
                                pTables.add(l_litter);

                                JLabel l_litter_id = new JLabel("Current Litter ID");
                                l_litter_id.setFont(labelFont);
                                l_litter_id.setForeground(black);
                                l_litter_id.setBounds(64, 304, 200, 20);
                                pTables.add(l_litter_id);

                                cb_litter_id = new JComboBox();
                                cb_litter_id.setFont(bodyFont);
                                cb_litter_id.setForeground(black);
                                cb_litter_id.setBounds(64, 328, 554, 40);
                                cb_litter_id.setBackground(Color.WHITE);
                                cb_data = Read.getLitterID();
                                for (String item : cb_data) {
                                    cb_litter_id.addItem(item);
                                }
                                cb_litter_id.setSelectedItem(null);
                                cb_litter_id.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        try {
                                            litter_id = Integer.parseInt(cb_litter_id.getSelectedItem().toString());
                                            ArrayList<String> info = Read.getLitterInfo(litter_id);
                                            t_sire_dog_id.setText(info.get(0));
                                            t_dam_dog_id.setText(info.get(1));
                                            t_litter_place_of_birth.setText(info.get(2));
                                            t_date_of_birth.setText(info.get(3));
                                            t_other_details.setText(info.get(4));
                                        }
                                        catch (Exception ex) {
                                        }
                                    }
                                });
                                pTables.add(cb_litter_id);

                                JLabel l_litter_sire_dog_id = new JLabel("Current Sire Dog ID");
                                l_litter_sire_dog_id.setFont(labelFont);
                                l_litter_sire_dog_id.setForeground(black);
                                l_litter_sire_dog_id.setBounds(64, 392, 265, 20);
                                pTables.add(l_litter_sire_dog_id);

                                t_sire_dog_id = new JTextField();
                                t_sire_dog_id.setFont(bodyFont);
                                t_sire_dog_id.setForeground(lockedGray);
                                t_sire_dog_id.setBorder(border);
                                t_sire_dog_id.setBounds(64,415,265,40);
                                t_sire_dog_id.setBackground(backgroundGray);
                                t_sire_dog_id.setEditable(false);
                                pTables.add(t_sire_dog_id);

                                JLabel l_litter_dam_dog_id = new JLabel("Current Dam Dog ID");
                                l_litter_dam_dog_id.setFont(labelFont);
                                l_litter_dam_dog_id.setForeground(black);
                                l_litter_dam_dog_id.setBounds(353, 392, 265, 20);
                                pTables.add(l_litter_dam_dog_id);

                                t_dam_dog_id = new JTextField();
                                t_dam_dog_id.setFont(bodyFont);
                                t_dam_dog_id.setForeground(lockedGray);
                                t_dam_dog_id.setBorder(border);
                                t_dam_dog_id.setBounds(353,415,265,40);
                                t_dam_dog_id.setBackground(backgroundGray);
                                t_dam_dog_id.setEditable(false);
                                pTables.add(t_dam_dog_id);

                                JLabel l_litter_place_of_birth = new JLabel("Current Litter's Place of Birth");
                                l_litter_place_of_birth.setFont(labelFont);
                                l_litter_place_of_birth.setForeground(black);
                                l_litter_place_of_birth.setBounds(64, 479, 265, 20);
                                pTables.add(l_litter_place_of_birth);

                                t_litter_place_of_birth = new JTextField();
                                t_litter_place_of_birth.setFont(bodyFont);
                                t_litter_place_of_birth.setForeground(lockedGray);
                                t_litter_place_of_birth.setBorder(border);
                                t_litter_place_of_birth.setBounds(64, 503, 265, 40);
                                t_litter_place_of_birth.setBackground(backgroundGray);
                                t_litter_place_of_birth.setEditable(false);
                                pTables.add(t_litter_place_of_birth);

                                JLabel l_litter_date_of_birth = new JLabel("Current Litter's Date of Birth");
                                l_litter_date_of_birth.setFont(labelFont);
                                l_litter_date_of_birth.setForeground(black);
                                l_litter_date_of_birth.setBounds(353, 479, 265, 20);
                                pTables.add(l_litter_date_of_birth);

                                t_date_of_birth = new JTextField();
                                t_date_of_birth.setFont(bodyFont);
                                t_date_of_birth.setForeground(lockedGray);
                                t_date_of_birth.setBorder(border);
                                t_date_of_birth.setBounds(353, 503, 265, 40);
                                t_date_of_birth.setBackground(backgroundGray);
                                t_date_of_birth.setEditable(false);
                                pTables.add(t_date_of_birth);

                                JLabel l_litter_other_details = new JLabel("Current Details");
                                l_litter_other_details.setFont(labelFont);
                                l_litter_other_details.setForeground(black);
                                l_litter_other_details.setBounds(64, 567, 265, 20);
                                pTables.add(l_litter_other_details);

                                t_other_details = new JTextArea();
                                t_other_details.setLineWrap(true);
                                t_other_details.setFont(bodyFont);
                                t_other_details.setForeground(lockedGray);
                                t_other_details.setBorder(border);
                                t_other_details.setBounds(64, 591, 554, 139);
                                t_other_details.setBackground(backgroundGray);
                                t_other_details.setEditable(false);
                                pTables.add(t_other_details);

                                JLabel l_litter_update = new JLabel("New Information");
                                l_litter_update.setFont(subtitleFont);
                                l_litter_update.setForeground(black);
                                l_litter_update.setBounds(64, 754, 250, 32);
                                pTables.add(l_litter_update);

                                JLabel l_litter_sire_dog_id_update = new JLabel("New Sire Dog ID");
                                l_litter_sire_dog_id_update.setFont(labelFont);
                                l_litter_sire_dog_id_update.setForeground(black);
                                l_litter_sire_dog_id_update.setBounds(64, 810, 265, 20);
                                pTables.add(l_litter_sire_dog_id_update);

                                cb_sire_dog_id_update = new JComboBox();
                                cb_sire_dog_id_update.setFont(bodyFont);
                                cb_sire_dog_id_update.setForeground(black);
                                cb_sire_dog_id_update.setBounds(64,834,265,40);
                                cb_sire_dog_id_update.setBackground(Color.WHITE);
                                cb_data = Read.getDogID();
                                for (String item : cb_data) {
                                    cb_sire_dog_id_update.addItem(item);
                                }
                                cb_sire_dog_id_update.setSelectedItem(null);
                                pTables.add(cb_sire_dog_id_update);

                                JLabel l_litter_dam_dog_id_update = new JLabel("New Dam Dog ID");
                                l_litter_dam_dog_id_update.setFont(labelFont);
                                l_litter_dam_dog_id_update.setForeground(black);
                                l_litter_dam_dog_id_update.setBounds(353, 810, 265, 20);
                                pTables.add(l_litter_dam_dog_id_update);

                                cb_dam_dog_id_update = new JComboBox();
                                cb_dam_dog_id_update.setFont(bodyFont);
                                cb_dam_dog_id_update.setForeground(black);
                                cb_dam_dog_id_update.setBounds(353,834,265,40);
                                cb_dam_dog_id_update.setBackground(Color.WHITE);
                                cb_data = Read.getDogID();
                                for (String item : cb_data) {
                                    cb_dam_dog_id_update.addItem(item);
                                }
                                cb_dam_dog_id_update.setSelectedItem(null);
                                pTables.add(cb_dam_dog_id_update);

                                JLabel l_litter_place_of_birth_update = new JLabel("New Place of Birth");
                                l_litter_place_of_birth_update.setFont(labelFont);
                                l_litter_place_of_birth_update.setForeground(black);
                                l_litter_place_of_birth_update.setBounds(64, 890, 265, 20);
                                pTables.add(l_litter_place_of_birth_update);

                                t_litter_place_of_birth_update = new JTextField();
                                t_litter_place_of_birth_update.setFont(bodyFont);
                                t_litter_place_of_birth_update.setForeground(black);
                                t_litter_place_of_birth_update.setBorder(border);
                                t_litter_place_of_birth_update.setBounds(64,914,265,40);
                                pTables.add(t_litter_place_of_birth_update);

                                JLabel l_litter_date_of_birth_update = new JLabel("New Date of Birth");
                                l_litter_date_of_birth_update.setFont(labelFont);
                                l_litter_date_of_birth_update.setForeground(black);
                                l_litter_date_of_birth_update.setBounds(353, 890, 265, 20);
                                pTables.add(l_litter_date_of_birth_update);

                                dc_date_of_birth_update = new JDateChooser("yyyy-MM-dd", "yyyy-MM-dd", '_');
                                dc_date_of_birth_update.setFont(bodyFont);
                                dc_date_of_birth_update.setForeground(black);
                                dc_date_of_birth_update.setBounds(353,914,265,40);
                                dc_date_of_birth_update.setBackground(Color.WHITE);
                                pTables.add(dc_date_of_birth_update);

                                JLabel l_litter_other_details_update = new JLabel("New Details");
                                l_litter_other_details_update.setFont(labelFont);
                                l_litter_other_details_update.setForeground(black);
                                l_litter_other_details_update.setBounds(64, 978, 100, 20);
                                pTables.add(l_litter_other_details_update);

                                pt_other_details_update = new JPlaceholderTextArea("e.g. All puppies are healthy, Five puppies in total");
                                pt_other_details_update.setLineWrap(true);
                                pt_other_details_update.setFont(bodyFont);
                                pt_other_details_update.setForeground(black);
                                pt_other_details_update.setBorder(border);
                                pt_other_details_update.setBounds(64, 1000, 554, 139);
                                pTables.add(pt_other_details_update);

                                b_submit.setBounds(64, 1164, 554, 40);
                                b_submit.addActionListener(this);
                                pTables.add(b_submit);

                                pTables.updateUI();
                                break;
                            case "relationships":
                                pTables.setPreferredSize(new Dimension (642,1250));

                                pTables.removeAll();

                                b_submit.removeActionListener(this);

                                lTitle.setBounds(64,64,265,38);
                                pTables.add(lTitle);

                                lDescription.setBounds(64,108,554,28);
                                pTables.add(lDescription);

                                lTables.setBounds(64,160,40 ,20);
                                pTables.add(lTables);

                                cbTables.setBounds(64,184,554,40);
                                cbTables.setSelectedItem("relationships");
                                pTables.add(cbTables);

                                JLabel l_relationship = new JLabel("Current Information");
                                l_relationship.setFont(subtitleFont);
                                l_relationship.setForeground(black);
                                l_relationship.setBounds(64, 248, 280, 32);
                                pTables.add(l_relationship);

                                JLabel l_relationship_id = new JLabel("Current Relationship ID");
                                l_relationship_id.setFont(labelFont);
                                l_relationship_id.setForeground(black);
                                l_relationship_id.setBounds(64, 304, 200, 20);
                                pTables.add(l_relationship_id);

                                cb_relationship_id = new JComboBox();
                                cb_relationship_id.setFont(bodyFont);
                                cb_relationship_id.setForeground(black);
                                cb_relationship_id.setBounds(64,328,265,40);
                                cb_relationship_id.setBackground(Color.WHITE);
                                cb_data = Read.getRelationshipID();
                                for (String item : cb_data) {
                                    cb_relationship_id.addItem(item);
                                }
                                cb_relationship_id.setSelectedItem(null);
                                cb_relationship_id.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        try {
                                            relationship_id = Integer.parseInt(cb_relationship_id.getSelectedItem().toString());
                                            ArrayList<String> info = Read.getRelationshipInfo(relationship_id);
                                            t_relationship_code.setText(info.get(0));
                                            t_dog_1_id.setText(info.get(1));
                                            t_dog_2_id.setText(info.get(2));
                                            t_other_details.setText(info.get(3));
                                        }
                                        catch (Exception ex) {
                                        }
                                    }
                                });
                                pTables.add(cb_relationship_id);

                                JLabel l_relationship_code = new JLabel("Current Relationship Code");
                                l_relationship_code.setFont(labelFont);
                                l_relationship_code.setForeground(black);
                                l_relationship_code.setBounds(353, 304, 265, 20);
                                pTables.add(l_relationship_code);

                                t_relationship_code = new JTextField();
                                t_relationship_code.setFont(bodyFont);
                                t_relationship_code.setForeground(lockedGray);
                                t_relationship_code.setBorder(border);
                                t_relationship_code.setBounds(353, 328, 265, 40);
                                t_relationship_code.setBackground(backgroundGray);
                                t_relationship_code.setEditable(false);
                                pTables.add(t_relationship_code);

                                JLabel l_relationship_sire_dog_id = new JLabel("Current Dog 1 ID");
                                l_relationship_sire_dog_id.setFont(labelFont);
                                l_relationship_sire_dog_id.setForeground(black);
                                l_relationship_sire_dog_id.setBounds(64, 392, 265, 20);
                                pTables.add(l_relationship_sire_dog_id);

                                t_dog_1_id = new JTextField();
                                t_dog_1_id.setFont(bodyFont);
                                t_dog_1_id.setForeground(lockedGray);
                                t_dog_1_id.setBorder(border);
                                t_dog_1_id.setBounds(64,416,265,40);
                                t_dog_1_id.setBackground(backgroundGray);
                                t_dog_1_id.setEditable(false);
                                pTables.add(t_dog_1_id);

                                JLabel l_relationship_dam_dog_id = new JLabel("Current Dog 2 ID");
                                l_relationship_dam_dog_id.setFont(labelFont);
                                l_relationship_dam_dog_id.setForeground(black);
                                l_relationship_dam_dog_id.setBounds(353, 392, 265, 20);
                                pTables.add(l_relationship_dam_dog_id);

                                t_dog_2_id = new JTextField();
                                t_dog_2_id.setFont(bodyFont);
                                t_dog_2_id.setForeground(lockedGray);
                                t_dog_2_id.setBorder(border);
                                t_dog_2_id.setBounds(353,416,265,40);
                                t_dog_2_id.setBackground(backgroundGray);
                                t_dog_2_id.setEditable(false);
                                pTables.add(t_dog_2_id);

                                JLabel l_relationship_other_details = new JLabel("Current Details");
                                l_relationship_other_details.setFont(labelFont);
                                l_relationship_other_details.setForeground(black);
                                l_relationship_other_details.setBounds(64, 480, 265, 20);
                                pTables.add(l_relationship_other_details);

                                t_other_details = new JTextArea();
                                t_other_details.setLineWrap(true);
                                t_other_details.setFont(bodyFont);
                                t_other_details.setForeground(lockedGray);
                                t_other_details.setBorder(border);
                                t_other_details.setBounds(64, 504, 554, 139);
                                t_other_details.setBackground(backgroundGray);
                                t_other_details.setEditable(false);
                                pTables.add(t_other_details);

                                JLabel l_relationship_update = new JLabel("New Information");
                                l_relationship_update.setFont(subtitleFont);
                                l_relationship_update.setForeground(black);
                                l_relationship_update.setBounds(64, 667, 250, 32);
                                pTables.add(l_relationship_update);

                                JLabel l_relationship_code_update = new JLabel("New Relationship Code");
                                l_relationship_code_update.setFont(labelFont);
                                l_relationship_code_update.setForeground(black);
                                l_relationship_code_update.setBounds(64, 723, 265, 20);
                                pTables.add(l_relationship_code_update);

                                cb_relationship_code_update = new JComboBox();
                                cb_relationship_code_update.setFont(bodyFont);
                                cb_relationship_code_update.setForeground(black);
                                cb_relationship_code_update.setBounds(64,747,554,40);
                                cb_relationship_code_update.setBackground(Color.WHITE);
                                cb_data = Read.getRelationshipCode();
                                for (String item : cb_data) {
                                    cb_relationship_code_update.addItem(item);
                                }
                                cb_relationship_code_update.setSelectedItem(null);
                                pTables.add(cb_relationship_code_update);

                                JLabel l_relationship_sire_dog_id_update = new JLabel("New Dog 1 ID");
                                l_relationship_sire_dog_id_update.setFont(labelFont);
                                l_relationship_sire_dog_id_update.setForeground(black);
                                l_relationship_sire_dog_id_update.setBounds(64, 803, 265, 20);
                                pTables.add(l_relationship_sire_dog_id_update);

                                cb_dog_1_id_update = new JComboBox();
                                cb_dog_1_id_update.setFont(bodyFont);
                                cb_dog_1_id_update.setForeground(black);
                                cb_dog_1_id_update.setBounds(64,827,265,40);
                                cb_dog_1_id_update.setBackground(Color.WHITE);
                                cb_data = Read.getDogID();
                                for (String item : cb_data) {
                                    cb_dog_1_id_update.addItem(item);
                                }
                                cb_dog_1_id_update.setSelectedItem(null);
                                pTables.add(cb_dog_1_id_update);

                                JLabel l_relationship_dam_dog_id_update = new JLabel("New Dog 2 ID");
                                l_relationship_dam_dog_id_update.setFont(labelFont);
                                l_relationship_dam_dog_id_update.setForeground(black);
                                l_relationship_dam_dog_id_update.setBounds(353, 803, 265, 20);
                                pTables.add(l_relationship_dam_dog_id_update);

                                cb_dog_2_id_update = new JComboBox();
                                cb_dog_2_id_update.setFont(bodyFont);
                                cb_dog_2_id_update.setForeground(black);
                                cb_dog_2_id_update.setBounds(353,827,265,40);
                                cb_dog_2_id_update.setBackground(Color.WHITE);
                                cb_data = Read.getDogID();
                                for (String item : cb_data) {
                                    cb_dog_2_id_update.addItem(item);
                                }
                                cb_dog_2_id_update.setSelectedItem(null);
                                pTables.add(cb_dog_2_id_update);

                                JLabel l_relationship_other_details_update = new JLabel("New Details");
                                l_relationship_other_details_update.setFont(labelFont);
                                l_relationship_other_details_update.setForeground(black);
                                l_relationship_other_details_update.setBounds(64, 881, 265, 20);
                                pTables.add(l_relationship_other_details_update);

                                pt_other_details_update = new JPlaceholderTextArea("e.g. The dogs are siblings");
                                pt_other_details_update.setLineWrap(true);
                                pt_other_details_update.setFont(bodyFont);
                                pt_other_details_update.setForeground(black);
                                pt_other_details_update.setBorder(border);
                                pt_other_details_update.setBounds(64,905,554,139);
                                pTables.add(pt_other_details_update);

                                b_submit.setBounds(64, 1072, 554, 40);
                                b_submit.addActionListener(this);
                                pTables.add(b_submit);

                                pTables.updateUI();
                                break;
                            case "relationship_types":
                                pTables.setPreferredSize(new Dimension (642,970));

                                pTables.removeAll();

                                b_submit.removeActionListener(this);

                                lTitle.setBounds(64,64,265,38);
                                pTables.add(lTitle);

                                lDescription.setBounds(64,108,554,28);
                                pTables.add(lDescription);

                                lTables.setBounds(64,160,40 ,20);
                                pTables.add(lTables);

                                cbTables.setBounds(64,184,554,40);
                                cbTables.setSelectedItem("relationship_types");
                                pTables.add(cbTables);

                                JLabel l_relationship_type = new JLabel("Current Information");
                                l_relationship_type.setFont(subtitleFont);
                                l_relationship_type.setForeground(black);
                                l_relationship_type.setBounds(64, 248, 280, 32);
                                pTables.add(l_relationship_type);

                                JLabel l_relationship_type_id = new JLabel("Current Relationship Type ID");
                                l_relationship_type_id.setFont(labelFont);
                                l_relationship_type_id.setForeground(black);
                                l_relationship_type_id.setBounds(64, 304, 200, 20);
                                pTables.add(l_relationship_type_id);

                                cb_relationship_code = new JComboBox();
                                cb_relationship_code.setFont(bodyFont);
                                cb_relationship_code.setForeground(black);
                                cb_relationship_code.setBounds(64,328,554,40);
                                cb_relationship_code.setBackground(Color.WHITE);
                                cb_data = Read.getRelationshipCode();
                                for (String item : cb_data) {
                                    cb_relationship_code.addItem(item);
                                }
                                cb_relationship_code.setSelectedItem(null);
                                cb_relationship_code.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        try {
                                            relationship_code = Integer.parseInt(cb_relationship_code.getSelectedItem().toString());
                                            ArrayList<String> info = Read.getRelationshipTypeInfo(relationship_code);
                                            t_relationships_description.setText(info.get(0));
                                        }
                                        catch (Exception ex) {
                                        }
                                    }
                                });
                                pTables.add(cb_relationship_code);

                                JLabel l_relationship_details = new JLabel("Current Details");
                                l_relationship_details.setFont(labelFont);
                                l_relationship_details.setForeground(black);
                                l_relationship_details.setBounds(64, 392, 265, 20);
                                pTables.add(l_relationship_details);

                                t_relationships_description = new JTextArea();
                                t_relationships_description.setLineWrap(true);
                                t_relationships_description.setFont(bodyFont);
                                t_relationships_description.setForeground(lockedGray);
                                t_relationships_description.setBorder(border);
                                t_relationships_description.setBounds(64, 416, 554, 139);
                                t_relationships_description.setBackground(backgroundGray);
                                t_relationships_description.setEditable(false);
                                pTables.add(t_relationships_description);

                                JLabel l_relationship_type_update = new JLabel("New Information");
                                l_relationship_type_update.setFont(subtitleFont);
                                l_relationship_type_update.setForeground(black);
                                l_relationship_type_update.setBounds(64, 579, 250, 32);
                                pTables.add(l_relationship_type_update);

                                JLabel l_relationship_details_update = new JLabel("New Details");
                                l_relationship_details_update.setFont(labelFont);
                                l_relationship_details_update.setForeground(black);
                                l_relationship_details_update.setBounds(64, 635, 265, 20);
                                pTables.add(l_relationship_details_update);

                                pt_relationships_description_update = new JPlaceholderTextArea("e.g. Siblings");
                                pt_relationships_description_update.setLineWrap(true);
                                pt_relationships_description_update.setFont(bodyFont);
                                pt_relationships_description_update.setForeground(black);
                                pt_relationships_description_update.setBorder(border);
                                pt_relationships_description_update.setBounds(64,659,554,139);
                                pTables.add(pt_relationships_description_update);

                                b_submit.setBounds(64, 822, 554, 40);
                                b_submit.addActionListener(this);
                                pTables.add(b_submit);

                                pTables.updateUI();
                                break;
                            case "health_records":
                                pTables.setPreferredSize(new Dimension (642,1470));

                                pTables.removeAll();

                                b_submit.removeActionListener(this);

                                lTitle.setBounds(64,64,265,38);
                                pTables.add(lTitle);

                                lDescription.setBounds(64,108,554,28);
                                pTables.add(lDescription);

                                lTables.setBounds(64,160,40 ,20);
                                pTables.add(lTables);

                                cbTables.setBounds(64,184,554,40);
                                cbTables.setSelectedItem("health_records");
                                pTables.add(cbTables);

                                JLabel l_health_record = new JLabel("Current Information");
                                l_health_record.setFont(subtitleFont);
                                l_health_record.setForeground(black);
                                l_health_record.setBounds(64, 248, 280, 32);
                                pTables.add(l_health_record);

                                JLabel l_health_record_id = new JLabel("Current Health Record ID");
                                l_health_record_id.setFont(labelFont);
                                l_health_record_id.setForeground(black);
                                l_health_record_id.setBounds(64, 304, 200, 20);
                                pTables.add(l_health_record_id);

                                cb_health_record_id = new JComboBox();
                                cb_health_record_id.setFont(bodyFont);
                                cb_health_record_id.setForeground(black);
                                cb_health_record_id.setBounds(64,328,265,40);
                                cb_health_record_id.setBackground(Color.WHITE);
                                cb_data = Read.getHealthRecordID();
                                for (String item : cb_data) {
                                    cb_health_record_id.addItem(item);
                                }
                                cb_health_record_id.setSelectedItem(null);
                                cb_health_record_id.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        try {
                                            health_record_id = Integer.parseInt(cb_health_record_id.getSelectedItem().toString());
                                            ArrayList<String> info = Read.getHealthRecordInfo(health_record_id);
                                            t_vet_id.setText(info.get(0));
                                            t_dog_id.setText(info.get(1));
                                            t_summary.setText(info.get(2));
                                            t_other_details.setText(info.get(3));
                                        }
                                        catch (Exception ex) {
                                        }
                                    }
                                });
                                pTables.add(cb_health_record_id);

                                JLabel l_health_record_vet_id = new JLabel("Current Vet ID");
                                l_health_record_vet_id.setFont(labelFont);
                                l_health_record_vet_id.setForeground(black);
                                l_health_record_vet_id.setBounds(353, 304, 265, 20);
                                pTables.add(l_health_record_vet_id);

                                t_vet_id = new JTextField();
                                t_vet_id.setFont(bodyFont);
                                t_vet_id.setForeground(lockedGray);
                                t_vet_id.setBorder(border);
                                t_vet_id.setBounds(353,328,265,40);
                                t_vet_id.setBackground(backgroundGray);
                                t_vet_id.setEditable(false);
                                pTables.add(t_vet_id);

                                JLabel l_health_record_dog_id = new JLabel("Current Dog ID");
                                l_health_record_dog_id.setFont(labelFont);
                                l_health_record_dog_id.setForeground(black);
                                l_health_record_dog_id.setBounds(64, 392, 265, 20);
                                pTables.add(l_health_record_dog_id);

                                t_dog_id = new JTextField();
                                t_dog_id.setFont(bodyFont);
                                t_dog_id.setForeground(lockedGray);
                                t_dog_id.setBorder(border);
                                t_dog_id.setBounds(64,416,554,40);
                                t_dog_id.setBackground(backgroundGray);
                                t_dog_id.setEditable(false);
                                pTables.add(t_dog_id);

                                JLabel l_health_record_summary = new JLabel("Current Summary");
                                l_health_record_summary.setFont(labelFont);
                                l_health_record_summary.setForeground(black);
                                l_health_record_summary.setBounds(64, 480, 265, 20);
                                pTables.add(l_health_record_summary);

                                t_summary = new JTextArea();
                                t_summary.setLineWrap(true);
                                t_summary.setFont(bodyFont);
                                t_summary.setForeground(lockedGray);
                                t_summary.setBorder(border);
                                t_summary.setBounds(64, 504, 554, 139);
                                t_summary.setBackground(backgroundGray);
                                t_summary.setEditable(false);
                                pTables.add(t_summary);

                                JLabel l_health_record_details = new JLabel("Current Details");
                                l_health_record_details.setFont(labelFont);
                                l_health_record_details.setForeground(black);
                                l_health_record_details.setBounds(64, 658, 265, 20);
                                pTables.add(l_health_record_details);

                                t_other_details = new JTextArea();
                                t_other_details.setLineWrap(true);
                                t_other_details.setFont(bodyFont);
                                t_other_details.setForeground(lockedGray);
                                t_other_details.setBorder(border);
                                t_other_details.setBounds(64, 680, 554, 139);
                                t_other_details.setBackground(backgroundGray);
                                t_other_details.setEditable(false);
                                pTables.add(t_other_details);

                                JLabel l_health_record_update = new JLabel("New Information");
                                l_health_record_update.setFont(subtitleFont);
                                l_health_record_update.setForeground(black);
                                l_health_record_update.setBounds(64, 842, 250, 32);
                                pTables.add(l_health_record_update);

                                JLabel l_health_record_vet_id_update = new JLabel("New Vet ID");
                                l_health_record_vet_id_update.setFont(labelFont);
                                l_health_record_vet_id_update.setForeground(black);
                                l_health_record_vet_id_update.setBounds(64, 898, 265, 20);
                                pTables.add(l_health_record_vet_id_update);

                                cb_vet_id_update = new JComboBox();
                                cb_vet_id_update.setFont(bodyFont);
                                cb_vet_id_update.setForeground(black);
                                cb_vet_id_update.setBounds(64,922,265,40);
                                cb_vet_id_update.setBackground(Color.WHITE);
                                cb_data = Read.getVetID();
                                for (String item : cb_data) {
                                    cb_vet_id_update.addItem(item);
                                }
                                cb_vet_id_update.setSelectedItem(null);
                                pTables.add(cb_vet_id_update);

                                JLabel l_health_record_dog_id_update = new JLabel("New Dog ID");
                                l_health_record_dog_id_update.setFont(labelFont);
                                l_health_record_dog_id_update.setForeground(black);
                                l_health_record_dog_id_update.setBounds(353, 898, 265, 20);
                                pTables.add(l_health_record_dog_id_update);

                                cb_dog_id_update = new JComboBox();
                                cb_dog_id_update.setFont(bodyFont);
                                cb_dog_id_update.setForeground(black);
                                cb_dog_id_update.setBounds(353,922,265,40);
                                cb_dog_id_update.setBackground(Color.WHITE);
                                cb_data = Read.getDogID();
                                for (String item : cb_data) {
                                    cb_dog_id_update.addItem(item);
                                }
                                cb_dog_id_update.setSelectedItem(null);
                                pTables.add(cb_dog_id_update);

                                JLabel l_health_record_summary_update = new JLabel("New Summary");
                                l_health_record_summary_update.setFont(labelFont);
                                l_health_record_summary_update.setForeground(black);
                                l_health_record_summary_update.setBounds(64, 978, 265, 20);
                                pTables.add(l_health_record_summary_update);

                                pt_summary_update = new JPlaceholderTextArea("e.g. The was administered the vaccines");
                                pt_summary_update.setLineWrap(true);
                                pt_summary_update.setFont(bodyFont);
                                pt_summary_update.setForeground(black);
                                pt_summary_update.setBorder(border);
                                pt_summary_update.setBounds(64,1002,554,139);
                                pTables.add(pt_summary_update);

                                JLabel l_health_record_details_update = new JLabel("New Details");
                                l_health_record_details_update.setFont(labelFont);
                                l_health_record_details_update.setForeground(black);
                                l_health_record_details_update.setBounds(64, 1148, 265, 20);
                                pTables.add(l_health_record_details_update);

                                pt_other_details_update = new JPlaceholderTextArea("e.g. The dog is healthy");
                                pt_other_details_update.setLineWrap(true);
                                pt_other_details_update.setFont(bodyFont);
                                pt_other_details_update.setForeground(black);
                                pt_other_details_update.setBorder(border);
                                pt_other_details_update.setBounds(64,1172,554,139);
                                pTables.add(pt_other_details_update);

                                b_submit.setBounds(64, 1336, 554, 40);
                                b_submit.addActionListener(this);
                                pTables.add(b_submit);

                                pTables.updateUI();
                                break;
                            case "common_problems":
                                pTables.setPreferredSize(new Dimension (642,960));

                                pTables.removeAll();

                                b_submit.removeActionListener(this);

                                lTitle.setBounds(64,64,265,38);
                                pTables.add(lTitle);

                                lDescription.setBounds(64,108,554,28);
                                pTables.add(lDescription);

                                lTables.setBounds(64,160,40 ,20);
                                pTables.add(lTables);

                                cbTables.setBounds(64,184,554,40);
                                cbTables.setSelectedItem("common_problems");
                                pTables.add(cbTables);

                                JLabel l_common_problem = new JLabel("Current Information");
                                l_common_problem.setFont(subtitleFont);
                                l_common_problem.setForeground(black);
                                l_common_problem.setBounds(64, 248, 280, 32);
                                pTables.add(l_common_problem);

                                JLabel l_common_problem_code = new JLabel("Current Problem Code");
                                l_common_problem_code.setFont(labelFont);
                                l_common_problem_code.setForeground(black);
                                l_common_problem_code.setBounds(64, 304, 200, 20);
                                pTables.add(l_common_problem_code);

                                cb_problem_code = new JComboBox();
                                cb_problem_code.setFont(bodyFont);
                                cb_problem_code.setForeground(black);
                                cb_problem_code.setBounds(64,328,554,40);
                                cb_problem_code.setBackground(Color.WHITE);
                                cb_data = Read.getProblemCode();
                                for (String item : cb_data) {
                                    cb_problem_code.addItem(item);
                                }
                                cb_problem_code.setSelectedItem(null);
                                cb_problem_code.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        try {
                                            problem_code = Integer.parseInt(cb_problem_code.getSelectedItem().toString());
                                            ArrayList<String> info = Read.getCommonProblemInfo(problem_code);
                                            t_problem_description.setText(info.get(0));
                                        }
                                        catch (Exception ex) {
                                        }
                                    }
                                });
                                pTables.add(cb_problem_code);

                                JLabel l_common_problem_description = new JLabel("Current Description");
                                l_common_problem_description.setFont(labelFont);
                                l_common_problem_description.setForeground(black);
                                l_common_problem_description.setBounds(64, 392, 265, 20);
                                pTables.add(l_common_problem_description);

                                t_problem_description = new JTextArea();
                                t_problem_description.setLineWrap(true);
                                t_problem_description.setFont(bodyFont);
                                t_problem_description.setForeground(lockedGray);
                                t_problem_description.setBorder(border);
                                t_problem_description.setBounds(64, 416, 554, 139);
                                t_problem_description.setBackground(backgroundGray);
                                t_problem_description.setEditable(false);
                                pTables.add(t_problem_description);

                                JLabel l_common_problem_update = new JLabel("New Information");
                                l_common_problem_update.setFont(subtitleFont);
                                l_common_problem_update.setForeground(black);
                                l_common_problem_update.setBounds(64, 579, 250, 32);
                                pTables.add(l_common_problem_update);

                                JLabel l_common_problem_description_update = new JLabel("New Description");
                                l_common_problem_description_update.setFont(labelFont);
                                l_common_problem_description_update.setForeground(black);
                                l_common_problem_description_update.setBounds(64, 635, 265, 20);
                                pTables.add(l_common_problem_description_update);

                                pt_problem_description_update = new JPlaceholderTextArea("e.g. Fever: The dog has high temperature, coughing, and runny nose");
                                pt_problem_description_update.setLineWrap(true);
                                pt_problem_description_update.setFont(bodyFont);
                                pt_problem_description_update.setForeground(black);
                                pt_problem_description_update.setBorder(border);
                                pt_problem_description_update.setBounds(64,659,554,139);
                                pTables.add(pt_problem_description_update);

                                b_submit.setBounds(64, 822, 554, 40);
                                b_submit.addActionListener(this);
                                pTables.add(b_submit);

                                pTables.updateUI();
                                break;
                            case "dog_problems":
                                pTables.setPreferredSize(new Dimension (642,1488));

                                pTables.removeAll();

                                b_submit.removeActionListener(this);

                                lTitle.setBounds(64,64,265,38);
                                pTables.add(lTitle);

                                lDescription.setBounds(64,108,554,28);
                                pTables.add(lDescription);

                                lTables.setBounds(64,160,40 ,20);
                                pTables.add(lTables);

                                cbTables.setBounds(64,184,554,40);
                                cbTables.setSelectedItem("dog_problems");
                                pTables.add(cbTables);

                                JLabel l_dog_problem = new JLabel("Current Information");
                                l_dog_problem.setFont(subtitleFont);
                                l_dog_problem.setForeground(black);
                                l_dog_problem.setBounds(64, 248, 280, 32);
                                pTables.add(l_dog_problem);

                                JLabel l_dog_problem_problem_code = new JLabel("Current Problem Code");
                                l_dog_problem_problem_code.setFont(labelFont);
                                l_dog_problem_problem_code.setForeground(black);
                                l_dog_problem_problem_code.setBounds(64, 304, 200, 20);
                                pTables.add(l_dog_problem_problem_code);

                                cb_problem_code = new JComboBox();
                                cb_problem_code.setFont(bodyFont);
                                cb_problem_code.setForeground(black);
                                cb_problem_code.setBounds(64,328,265,40);
                                cb_problem_code.setBackground(Color.WHITE);
                                cb_data = Read.getProblemCode();
                                for (String item : cb_data) {
                                    cb_problem_code.addItem(item);
                                }
                                cb_problem_code.setSelectedItem(null);
                                cb_problem_code.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        try {
                                            cb_health_record_id.removeAllItems();
                                            problem_code = Integer.parseInt(cb_problem_code.getSelectedItem().toString());
                                            ArrayList<String> data = Read.getDogProblems_HealthRecordsID(problem_code);
                                            for (String item : data) {
                                                cb_health_record_id.addItem(item);
                                            }
                                            cb_health_record_id.setSelectedItem(null);
                                            cb_health_record_id.setEnabled(true);
                                        }
                                        catch (Exception ex) {
                                        }
                                    }
                                });
                                pTables.add(cb_problem_code);

                                JLabel l_dog_problem_health_record_id = new JLabel("Current Health Record ID");
                                l_dog_problem_health_record_id.setFont(labelFont);
                                l_dog_problem_health_record_id.setForeground(black);
                                l_dog_problem_health_record_id.setBounds(353, 304, 265, 20);
                                pTables.add(l_dog_problem_health_record_id);

                                cb_health_record_id = new JComboBox();
                                cb_health_record_id.setFont(bodyFont);
                                cb_health_record_id.setForeground(black);
                                cb_health_record_id.setBounds(353,328,265,40);
                                cb_health_record_id.setBackground(Color.WHITE);
                                cb_health_record_id.setSelectedItem(null);
                                cb_health_record_id.setEnabled(false);
                                cb_health_record_id.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        try {
                                            if (cb_health_record_id.getSelectedItem() != null) {
                                                problem_code = Integer.parseInt(cb_problem_code.getSelectedItem().toString());
                                                health_record_id = Integer.parseInt(cb_health_record_id.getSelectedItem().toString());
                                                ArrayList<String> info = Read.getDogProblems_HealthRecordsIDInfo(problem_code, health_record_id);
                                                t_date_of_problem.setText(info.get(0));
                                                t_problem_treatment.setText(info.get(1));
                                                t_problem_details.setText(info.get(2));
                                            }
                                            else {
                                                t_date_of_problem.setText("");
                                                t_problem_treatment.setText("");
                                                t_problem_details.setText("");
                                            }
                                        }
                                        catch (Exception ex) {
                                        }
                                    }
                                });
                                pTables.add(cb_health_record_id);

                                JLabel l_dog_problem_date_of_problem = new JLabel("Current Date of Problem");
                                l_dog_problem_date_of_problem.setFont(labelFont);
                                l_dog_problem_date_of_problem.setForeground(black);
                                l_dog_problem_date_of_problem.setBounds(64, 392, 265, 20);
                                pTables.add(l_dog_problem_date_of_problem);

                                t_date_of_problem = new JTextField();
                                t_date_of_problem.setFont(bodyFont);
                                t_date_of_problem.setForeground(lockedGray);
                                t_date_of_problem.setBorder(border);
                                t_date_of_problem.setBounds(64,416,554,40);
                                t_date_of_problem.setBackground(backgroundGray);
                                t_date_of_problem.setEditable(false);
                                pTables.add(t_date_of_problem);

                                JLabel l_dog_problem_treatment = new JLabel("Current Treatment");
                                l_dog_problem_treatment.setFont(labelFont);
                                l_dog_problem_treatment.setForeground(black);
                                l_dog_problem_treatment.setBounds(64, 480, 265, 20);
                                pTables.add(l_dog_problem_treatment);

                                t_problem_treatment = new JTextArea();
                                t_problem_treatment.setLineWrap(true);
                                t_problem_treatment.setFont(bodyFont);
                                t_problem_treatment.setForeground(lockedGray);
                                t_problem_treatment.setBorder(border);
                                t_problem_treatment.setBounds(64, 504, 554, 139);
                                t_problem_treatment.setBackground(backgroundGray);
                                t_problem_treatment.setEditable(false);
                                pTables.add(t_problem_treatment);

                                JLabel l_dog_problem_details = new JLabel("Current Details");
                                l_dog_problem_details.setFont(labelFont);
                                l_dog_problem_details.setForeground(black);
                                l_dog_problem_details.setBounds(64, 656, 265, 20);
                                pTables.add(l_dog_problem_details);

                                t_problem_details = new JTextArea();
                                t_problem_details.setLineWrap(true);
                                t_problem_details.setFont(bodyFont);
                                t_problem_details.setForeground(lockedGray);
                                t_problem_details.setBorder(border);
                                t_problem_details.setBounds(64, 680, 554, 139);
                                t_problem_details.setBackground(backgroundGray);
                                t_problem_details.setEditable(false);
                                pTables.add(t_problem_details);

                                JLabel l_dog_problem_update = new JLabel("New Information");
                                l_dog_problem_update.setFont(subtitleFont);
                                l_dog_problem_update.setForeground(black);
                                l_dog_problem_update.setBounds(64, 842, 250, 32);
                                pTables.add(l_dog_problem_update);

                                JLabel l_dog_problem_health_record_id_update = new JLabel("New Health Record ID");
                                l_dog_problem_health_record_id_update.setFont(labelFont);
                                l_dog_problem_health_record_id_update.setForeground(black);
                                l_dog_problem_health_record_id_update.setBounds(64, 898, 265, 20);
                                pTables.add(l_dog_problem_health_record_id_update);

                                cb_health_record_id_update = new JComboBox();
                                cb_health_record_id_update.setFont(bodyFont);
                                cb_health_record_id_update.setForeground(black);
                                cb_health_record_id_update.setBounds(64,922,265,40);
                                cb_health_record_id_update.setBackground(Color.WHITE);
                                cb_data = Read.getHealthRecordID();
                                for (String item : cb_data) {
                                    cb_health_record_id_update.addItem(item);
                                }
                                cb_health_record_id_update.setSelectedItem(null);
                                pTables.add(cb_health_record_id_update);

                                JLabel l_dog_problem_date_of_problem_update = new JLabel("New Date of Problem");
                                l_dog_problem_date_of_problem_update.setFont(labelFont);
                                l_dog_problem_date_of_problem_update.setForeground(black);
                                l_dog_problem_date_of_problem_update.setBounds(353, 898, 265, 20);
                                pTables.add(l_dog_problem_date_of_problem_update);

                                dc_date_of_problem_update = new JDateChooser("yyyy-MM-dd", "yyyy-MM-dd", '_');
                                dc_date_of_problem_update.setFont(bodyFont);
                                dc_date_of_problem_update.setForeground(black);
                                dc_date_of_problem_update.setBounds(353,922,265,40);
                                dc_date_of_problem_update.setBackground(Color.WHITE);
                                pTables.add(dc_date_of_problem_update);

                                JLabel l_dog_problem_treatment_update = new JLabel("New Treatment");
                                l_dog_problem_treatment_update.setFont(labelFont);
                                l_dog_problem_treatment_update.setForeground(black);
                                l_dog_problem_treatment_update.setBounds(64, 978, 265, 20);
                                pTables.add(l_dog_problem_treatment_update);

                                pt_problem_treatment_update = new JPlaceholderTextArea("e.g. The dog was given antibiotics");
                                pt_problem_treatment_update.setLineWrap(true);
                                pt_problem_treatment_update.setFont(bodyFont);
                                pt_problem_treatment_update.setForeground(black);
                                pt_problem_treatment_update.setBorder(border);
                                pt_problem_treatment_update.setBounds(64,1002,554,139);
                                pTables.add(pt_problem_treatment_update);

                                JLabel l_dog_problem_details_update = new JLabel("New Details");
                                l_dog_problem_details_update.setFont(labelFont);
                                l_dog_problem_details_update.setForeground(black);
                                l_dog_problem_details_update.setBounds(64, 1148, 265, 20);
                                pTables.add(l_dog_problem_details_update);

                                pt_problem_details_update = new JPlaceholderTextArea("e.g. The dog is healthy");
                                pt_problem_details_update.setLineWrap(true);
                                pt_problem_details_update.setFont(bodyFont);
                                pt_problem_details_update.setForeground(black);
                                pt_problem_details_update.setBorder(border);
                                pt_problem_details_update.setBounds(64,1172,554,139);
                                pTables.add(pt_problem_details_update);

                                b_submit.setBounds(64, 1336, 554, 40);
                                b_submit.addActionListener(this);
                                pTables.add(b_submit);

                                pTables.updateUI();
                                break;
                        }
                        break;
                    case "delete":
                        switch (table) {
                            case "vets":
                                pTables.setPreferredSize(new Dimension (642,700));

                                pTables.removeAll();

                                b_submit.removeActionListener(this);

                                lTitle.setBounds(64,64,120,38);
                                pTables.add(lTitle);

                                lDescription.setBounds(64,108,554,28);
                                pTables.add(lDescription);

                                lTables.setBounds(64,160,40 ,20);
                                pTables.add(lTables);

                                cbTables.setBounds(64,184,554,40);
                                cbTables.setSelectedItem("vets");
                                pTables.add(cbTables);

                                JLabel l_vet = new JLabel("Current Information");
                                l_vet.setFont(subtitleFont);
                                l_vet.setForeground(black);
                                l_vet.setBounds(64, 248, 280, 32);
                                pTables.add(l_vet);

                                JLabel l_vet_id = new JLabel("Vet's ID");
                                l_vet_id.setFont(labelFont);
                                l_vet_id.setForeground(black);
                                l_vet_id.setBounds(64, 304, 100, 20);
                                pTables.add(l_vet_id);

                                cb_vet_id = new JComboBox();
                                cb_vet_id.setFont(bodyFont);
                                cb_vet_id.setForeground(black);
                                cb_vet_id.setBounds(64, 328, 265, 40);
                                cb_vet_id.setBackground(Color.WHITE);
                                cb_data = Read.getVetID();
                                for (String item : cb_data) {
                                    cb_vet_id.addItem(item);
                                }
                                cb_vet_id.setSelectedItem(null);
                                cb_vet_id.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        try {
                                            vet_id = Integer.parseInt(cb_vet_id.getSelectedItem().toString());
                                            ArrayList<String> info = Read.getVetInfo(vet_id);
                                            t_vet_name.setText(info.get(0));
                                            t_other_details.setText(info.get(1));
                                        }
                                        catch (Exception ex) {
                                        }
                                    }
                                });
                                pTables.add(cb_vet_id);

                                JLabel l_vet_name = new JLabel("Vet's Name");
                                l_vet_name.setFont(labelFont);
                                l_vet_name.setForeground(black);
                                l_vet_name.setBounds(353, 304, 160, 20);
                                pTables.add(l_vet_name);

                                t_vet_name = new JTextField();
                                t_vet_name.setFont(bodyFont);
                                t_vet_name.setForeground(lockedGray);
                                t_vet_name.setBorder(border);
                                t_vet_name.setBounds(353, 328, 265, 40);
                                t_vet_name.setBackground(backgroundGray);
                                t_vet_name.setEditable(false);
                                pTables.add(t_vet_name);

                                JLabel l_vet_other_details = new JLabel("Details");
                                l_vet_other_details.setFont(labelFont);
                                l_vet_other_details.setForeground(black);
                                l_vet_other_details.setBounds(64, 392, 150, 20);
                                pTables.add(l_vet_other_details);

                                t_other_details = new JTextArea();
                                t_other_details.setLineWrap(true);
                                t_other_details.setFont(bodyFont);
                                t_other_details.setForeground(lockedGray);
                                t_other_details.setBorder(border);
                                t_other_details.setBounds(64, 416, 554, 139);
                                t_other_details.setBackground(backgroundGray);
                                t_other_details.setEditable(false);
                                pTables.add(t_other_details);

                                b_submit.setBounds(64, 576, 554, 40);
                                b_submit.addActionListener(this);
                                pTables.add(b_submit);

                                pTables.updateUI();
                                break;
                            case "dogs":
                                pTables.setPreferredSize(new Dimension (642,980));

                                pTables.removeAll();

                                b_submit.removeActionListener(this);

                                lTitle.setBounds(64,64,120,38);
                                pTables.add(lTitle);

                                lDescription.setBounds(64,108,554,28);
                                pTables.add(lDescription);

                                lTables.setBounds(64,160,40 ,20);
                                pTables.add(lTables);

                                cbTables.setBounds(64,184,554,40);
                                cbTables.setSelectedItem("dogs");
                                pTables.add(cbTables);

                                JLabel l_dog = new JLabel("Current Information");
                                l_dog.setFont(subtitleFont);
                                l_dog.setForeground(black);
                                l_dog.setBounds(64, 248, 280, 32);
                                pTables.add(l_dog);

                                JLabel l_dog_id = new JLabel("Dog's ID");
                                l_dog_id.setFont(labelFont);
                                l_dog_id.setForeground(black);
                                l_dog_id.setBounds(64, 304, 265, 20);
                                pTables.add(l_dog_id);

                                cb_dog_id = new JComboBox();
                                cb_dog_id.setFont(bodyFont);
                                cb_dog_id.setForeground(black);
                                cb_dog_id.setBounds(64, 328, 265, 40);
                                cb_dog_id.setBackground(Color.WHITE);
                                cb_data = Read.getDogID();
                                for (String item : cb_data) {
                                    cb_dog_id.addItem(item);
                                }
                                cb_dog_id.setSelectedItem(null);
                                cb_dog_id.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        dog_id = Integer.parseInt(cb_dog_id.getSelectedItem().toString());
                                        ArrayList<String> info = Read.getDogInfo(dog_id);
                                        t_dog_name.setText(info.get(0));
                                        t_dog_place_of_birth.setText(info.get(1));
                                        t_date_of_birth.setText(info.get(2));
                                        t_dog_born_in_litter.setText(info.get(3));
                                        if (info.get(4).equals("F")) {
                                            rb_dog_female.setSelected(true);
                                        }
                                        if (info.get(4).equals("M")) {
                                            rb_dog_male.setSelected(true);
                                        }
                                        t_other_details.setText(info.get(5));
                                    }
                                });
                                pTables.add(cb_dog_id);

                                JLabel l_dog_dogs_name = new JLabel("Dog's Name");
                                l_dog_dogs_name.setFont(labelFont);
                                l_dog_dogs_name.setForeground(black);
                                l_dog_dogs_name.setBounds(353, 304, 265, 20);
                                pTables.add(l_dog_dogs_name);

                                t_dog_name = new JTextField();
                                t_dog_name.setFont(bodyFont);
                                t_dog_name.setForeground(lockedGray);
                                t_dog_name.setBorder(border);
                                t_dog_name.setBounds(353, 328, 265, 40);
                                t_dog_name.setBackground(backgroundGray);
                                t_dog_name.setEditable(false);
                                pTables.add(t_dog_name);

                                JLabel l_dog_place_of_birth = new JLabel("Place of Birth");
                                l_dog_place_of_birth.setFont(labelFont);
                                l_dog_place_of_birth.setForeground(black);
                                l_dog_place_of_birth.setBounds(64, 392, 265, 20);
                                pTables.add(l_dog_place_of_birth);

                                t_dog_place_of_birth = new JTextField();
                                t_dog_place_of_birth.setFont(bodyFont);
                                t_dog_place_of_birth.setForeground(lockedGray);
                                t_dog_place_of_birth.setBorder(border);
                                t_dog_place_of_birth.setBounds(64, 416, 265, 40);
                                t_dog_place_of_birth.setBackground(backgroundGray);
                                t_dog_place_of_birth.setEditable(false);
                                pTables.add(t_dog_place_of_birth);

                                JLabel l_dog_date_of_birth = new JLabel("Date of Birth");
                                l_dog_date_of_birth.setFont(labelFont);
                                l_dog_date_of_birth.setForeground(black);
                                l_dog_date_of_birth.setBounds(353, 392, 265, 20);
                                pTables.add(l_dog_date_of_birth);

                                t_date_of_birth = new JTextField();
                                t_date_of_birth.setFont(bodyFont);
                                t_date_of_birth.setForeground(lockedGray);
                                t_date_of_birth.setBorder(border);
                                t_date_of_birth.setBounds(353, 416, 265, 40);
                                t_date_of_birth.setBackground(backgroundGray);
                                t_date_of_birth.setEditable(false);
                                pTables.add(t_date_of_birth);

                                JLabel l_dog_born_in_litter = new JLabel("Born in Litter");
                                l_dog_born_in_litter.setFont(labelFont);
                                l_dog_born_in_litter.setForeground(black);
                                l_dog_born_in_litter.setBounds(64, 480, 265, 20);
                                pTables.add(l_dog_born_in_litter);

                                t_dog_born_in_litter = new JTextField();
                                t_dog_born_in_litter.setFont(bodyFont);
                                t_dog_born_in_litter.setForeground(lockedGray);
                                t_dog_born_in_litter.setBorder(border);
                                t_dog_born_in_litter.setBounds(64,504,554,40);
                                t_dog_born_in_litter.setBackground(backgroundGray);
                                t_dog_born_in_litter.setEditable(false);
                                pTables.add(t_dog_born_in_litter);

                                JLabel l_dog_gender_mf = new JLabel("Dog's Gender");
                                l_dog_gender_mf.setFont(labelFont);
                                l_dog_gender_mf.setForeground(black);
                                l_dog_gender_mf.setBounds(64, 566, 265, 20);
                                pTables.add(l_dog_gender_mf);

                                bg_group = new ButtonGroup();

                                rb_dog_female = new JRadioButton();
                                rb_dog_female.setFont(bodyFont);
                                rb_dog_female.setForeground(black);
                                rb_dog_female.setBounds(64, 592, 90, 20);
                                rb_dog_female.setText("Female");
                                rb_dog_female.setBackground(null);
                                rb_dog_female.setEnabled(false);
                                bg_group.add(rb_dog_female);
                                pTables.add(rb_dog_female);

                                rb_dog_male = new JRadioButton();
                                rb_dog_male.setFont(bodyFont);
                                rb_dog_male.setForeground(black);
                                rb_dog_male.setBounds(211, 592, 80, 20);
                                rb_dog_male.setText("Male");
                                rb_dog_male.setBackground(null);
                                rb_dog_male.setEnabled(false);
                                bg_group.add(rb_dog_male);
                                pTables.add(rb_dog_male);

                                JLabel l_dog_other_details = new JLabel("Details");
                                l_dog_other_details.setFont(labelFont);
                                l_dog_other_details.setForeground(black);
                                l_dog_other_details.setBounds(64, 640, 265, 20);
                                pTables.add(l_dog_other_details);

                                t_other_details = new JTextArea();
                                t_other_details.setLineWrap(true);
                                t_other_details.setFont(bodyFont);
                                t_other_details.setForeground(lockedGray);
                                t_other_details.setBorder(border);
                                t_other_details.setBounds(64, 664, 554, 139);
                                t_other_details.setBackground(backgroundGray);
                                t_other_details.setEditable(false);
                                pTables.add(t_other_details);

                                b_submit.setBounds(64, 822, 554, 40);
                                b_submit.addActionListener(this);
                                pTables.add(b_submit);

                                pTables.updateUI();
                                break;
                            case "litters":
                                pTables.setPreferredSize(new Dimension (642,900));

                                pTables.removeAll();

                                b_submit.removeActionListener(this);

                                lTitle.setBounds(64,64,265,38);
                                pTables.add(lTitle);

                                lDescription.setBounds(64,108,554,28);
                                pTables.add(lDescription);

                                lTables.setBounds(64,160,40 ,20);
                                pTables.add(lTables);

                                cbTables.setBounds(64,184,554,40);
                                cbTables.setSelectedItem("litters");
                                pTables.add(cbTables);

                                JLabel l_litter = new JLabel("Current Information");
                                l_litter.setFont(subtitleFont);
                                l_litter.setForeground(black);
                                l_litter.setBounds(64, 248, 280, 32);
                                pTables.add(l_litter);

                                JLabel l_litter_id = new JLabel("Litter ID");
                                l_litter_id.setFont(labelFont);
                                l_litter_id.setForeground(black);
                                l_litter_id.setBounds(64, 304, 200, 20);
                                pTables.add(l_litter_id);

                                cb_litter_id = new JComboBox();
                                cb_litter_id.setFont(bodyFont);
                                cb_litter_id.setForeground(black);
                                cb_litter_id.setBounds(64, 328, 554, 40);
                                cb_litter_id.setBackground(Color.WHITE);
                                cb_data = Read.getLitterID();
                                for (String item : cb_data) {
                                    cb_litter_id.addItem(item);
                                }
                                cb_litter_id.setSelectedItem(null);
                                cb_litter_id.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        try {
                                            litter_id = Integer.parseInt(cb_litter_id.getSelectedItem().toString());
                                            ArrayList<String> info = Read.getLitterInfo(litter_id);
                                            t_sire_dog_id.setText(info.get(0));
                                            t_dam_dog_id.setText(info.get(1));
                                            t_litter_place_of_birth.setText(info.get(2));
                                            t_date_of_birth.setText(info.get(3));
                                            t_other_details.setText(info.get(4));
                                        }
                                        catch (Exception ex) {
                                        }
                                    }
                                });
                                pTables.add(cb_litter_id);

                                JLabel l_litter_sire_dog_id = new JLabel("Sire Dog ID");
                                l_litter_sire_dog_id.setFont(labelFont);
                                l_litter_sire_dog_id.setForeground(black);
                                l_litter_sire_dog_id.setBounds(64, 392, 265, 20);
                                pTables.add(l_litter_sire_dog_id);

                                t_sire_dog_id = new JTextField();
                                t_sire_dog_id.setFont(bodyFont);
                                t_sire_dog_id.setForeground(lockedGray);
                                t_sire_dog_id.setBorder(border);
                                t_sire_dog_id.setBounds(64,415,265,40);
                                t_sire_dog_id.setBackground(backgroundGray);
                                t_sire_dog_id.setEditable(false);
                                pTables.add(t_sire_dog_id);

                                JLabel l_litter_dam_dog_id = new JLabel("Dam Dog ID");
                                l_litter_dam_dog_id.setFont(labelFont);
                                l_litter_dam_dog_id.setForeground(black);
                                l_litter_dam_dog_id.setBounds(353, 392, 265, 20);
                                pTables.add(l_litter_dam_dog_id);

                                t_dam_dog_id = new JTextField();
                                t_dam_dog_id.setFont(bodyFont);
                                t_dam_dog_id.setForeground(lockedGray);
                                t_dam_dog_id.setBorder(border);
                                t_dam_dog_id.setBounds(353,415,265,40);
                                t_dam_dog_id.setBackground(backgroundGray);
                                t_dam_dog_id.setEditable(false);
                                pTables.add(t_dam_dog_id);

                                JLabel l_litter_place_of_birth = new JLabel("Litter's Place of Birth");
                                l_litter_place_of_birth.setFont(labelFont);
                                l_litter_place_of_birth.setForeground(black);
                                l_litter_place_of_birth.setBounds(64, 479, 265, 20);
                                pTables.add(l_litter_place_of_birth);

                                t_litter_place_of_birth = new JTextField();
                                t_litter_place_of_birth.setFont(bodyFont);
                                t_litter_place_of_birth.setForeground(lockedGray);
                                t_litter_place_of_birth.setBorder(border);
                                t_litter_place_of_birth.setBounds(64, 503, 265, 40);
                                t_litter_place_of_birth.setBackground(backgroundGray);
                                t_litter_place_of_birth.setEditable(false);
                                pTables.add(t_litter_place_of_birth);

                                JLabel l_litter_date_of_birth = new JLabel("Litter's Date of Birth");
                                l_litter_date_of_birth.setFont(labelFont);
                                l_litter_date_of_birth.setForeground(black);
                                l_litter_date_of_birth.setBounds(353, 479, 265, 20);
                                pTables.add(l_litter_date_of_birth);

                                t_date_of_birth = new JTextField();
                                t_date_of_birth.setFont(bodyFont);
                                t_date_of_birth.setForeground(lockedGray);
                                t_date_of_birth.setBorder(border);
                                t_date_of_birth.setBounds(353, 503, 265, 40);
                                t_date_of_birth.setBackground(backgroundGray);
                                t_date_of_birth.setEditable(false);
                                pTables.add(t_date_of_birth);

                                JLabel l_litter_other_details = new JLabel("Details");
                                l_litter_other_details.setFont(labelFont);
                                l_litter_other_details.setForeground(black);
                                l_litter_other_details.setBounds(64, 567, 265, 20);
                                pTables.add(l_litter_other_details);

                                t_other_details = new JTextArea();
                                t_other_details.setLineWrap(true);
                                t_other_details.setFont(bodyFont);
                                t_other_details.setForeground(lockedGray);
                                t_other_details.setBorder(border);
                                t_other_details.setBounds(64, 591, 554, 139);
                                t_other_details.setBackground(backgroundGray);
                                t_other_details.setEditable(false);
                                pTables.add(t_other_details);

                                b_submit.setBounds(64, 744, 554, 40);
                                b_submit.addActionListener(this);
                                pTables.add(b_submit);

                                pTables.updateUI();
                                break;
                            case "relationships":
                                pTables.setPreferredSize(new Dimension (642,820));

                                pTables.removeAll();

                                b_submit.removeActionListener(this);

                                lTitle.setBounds(64,64,265,38);
                                pTables.add(lTitle);

                                lDescription.setBounds(64,108,554,28);
                                pTables.add(lDescription);

                                lTables.setBounds(64,160,40 ,20);
                                pTables.add(lTables);

                                cbTables.setBounds(64,184,554,40);
                                cbTables.setSelectedItem("relationships");
                                pTables.add(cbTables);

                                JLabel l_relationship = new JLabel("Current Information");
                                l_relationship.setFont(subtitleFont);
                                l_relationship.setForeground(black);
                                l_relationship.setBounds(64, 248, 280, 32);
                                pTables.add(l_relationship);

                                JLabel l_relationship_id = new JLabel("Relationship ID");
                                l_relationship_id.setFont(labelFont);
                                l_relationship_id.setForeground(black);
                                l_relationship_id.setBounds(64, 304, 200, 20);
                                pTables.add(l_relationship_id);

                                cb_relationship_id = new JComboBox();
                                cb_relationship_id.setFont(bodyFont);
                                cb_relationship_id.setForeground(black);
                                cb_relationship_id.setBounds(64,328,265,40);
                                cb_relationship_id.setBackground(Color.WHITE);
                                cb_data = Read.getRelationshipID();
                                for (String item : cb_data) {
                                    cb_relationship_id.addItem(item);
                                }
                                cb_relationship_id.setSelectedItem(null);
                                cb_relationship_id.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        try {
                                            relationship_id = Integer.parseInt(cb_relationship_id.getSelectedItem().toString());
                                            ArrayList<String> info = Read.getRelationshipInfo(relationship_id);
                                            t_relationship_code.setText(info.get(0));
                                            t_dog_1_id.setText(info.get(1));
                                            t_dog_2_id.setText(info.get(2));
                                            t_other_details.setText(info.get(3));
                                        }
                                        catch (Exception ex) {
                                        }
                                    }
                                });
                                pTables.add(cb_relationship_id);

                                JLabel l_relationship_code = new JLabel("Relationship Code");
                                l_relationship_code.setFont(labelFont);
                                l_relationship_code.setForeground(black);
                                l_relationship_code.setBounds(353, 304, 265, 20);
                                pTables.add(l_relationship_code);

                                t_relationship_code = new JTextField();
                                t_relationship_code.setFont(bodyFont);
                                t_relationship_code.setForeground(lockedGray);
                                t_relationship_code.setBorder(border);
                                t_relationship_code.setBounds(353, 328, 265, 40);
                                t_relationship_code.setBackground(backgroundGray);
                                t_relationship_code.setEditable(false);
                                pTables.add(t_relationship_code);

                                JLabel l_relationship_sire_dog_id = new JLabel("Dog 1 ID");
                                l_relationship_sire_dog_id.setFont(labelFont);
                                l_relationship_sire_dog_id.setForeground(black);
                                l_relationship_sire_dog_id.setBounds(64, 392, 265, 20);
                                pTables.add(l_relationship_sire_dog_id);

                                t_dog_1_id = new JTextField();
                                t_dog_1_id.setFont(bodyFont);
                                t_dog_1_id.setForeground(lockedGray);
                                t_dog_1_id.setBorder(border);
                                t_dog_1_id.setBounds(64,416,265,40);
                                t_dog_1_id.setBackground(backgroundGray);
                                t_dog_1_id.setEditable(false);
                                pTables.add(t_dog_1_id);

                                JLabel l_relationship_dam_dog_id = new JLabel("Dog 2 ID");
                                l_relationship_dam_dog_id.setFont(labelFont);
                                l_relationship_dam_dog_id.setForeground(black);
                                l_relationship_dam_dog_id.setBounds(353, 392, 265, 20);
                                pTables.add(l_relationship_dam_dog_id);

                                t_dog_2_id = new JTextField();
                                t_dog_2_id.setFont(bodyFont);
                                t_dog_2_id.setForeground(lockedGray);
                                t_dog_2_id.setBorder(border);
                                t_dog_2_id.setBounds(353,416,265,40);
                                t_dog_2_id.setBackground(backgroundGray);
                                t_dog_2_id.setEditable(false);
                                pTables.add(t_dog_2_id);

                                JLabel l_relationship_other_details = new JLabel("Details");
                                l_relationship_other_details.setFont(labelFont);
                                l_relationship_other_details.setForeground(black);
                                l_relationship_other_details.setBounds(64, 480, 265, 20);
                                pTables.add(l_relationship_other_details);

                                t_other_details = new JTextArea();
                                t_other_details.setLineWrap(true);
                                t_other_details.setFont(bodyFont);
                                t_other_details.setForeground(lockedGray);
                                t_other_details.setBorder(border);
                                t_other_details.setBounds(64, 504, 554, 139);
                                t_other_details.setBackground(backgroundGray);
                                t_other_details.setEditable(false);
                                pTables.add(t_other_details);

                                b_submit.setBounds(64, 672, 554, 40);
                                b_submit.addActionListener(this);
                                pTables.add(b_submit);

                                pTables.updateUI();
                                break;
                            case "relationship_types":
                                pTables.setPreferredSize(new Dimension (642,700));

                                pTables.removeAll();

                                b_submit.removeActionListener(this);

                                lTitle.setBounds(64,64,265,38);
                                pTables.add(lTitle);

                                lDescription.setBounds(64,108,554,28);
                                pTables.add(lDescription);

                                lTables.setBounds(64,160,40 ,20);
                                pTables.add(lTables);

                                cbTables.setBounds(64,184,554,40);
                                cbTables.setSelectedItem("relationship_types");
                                pTables.add(cbTables);

                                JLabel l_relationship_type = new JLabel("Current Information");
                                l_relationship_type.setFont(subtitleFont);
                                l_relationship_type.setForeground(black);
                                l_relationship_type.setBounds(64, 248, 280, 32);
                                pTables.add(l_relationship_type);

                                JLabel l_relationship_type_id = new JLabel("Relationship Type ID");
                                l_relationship_type_id.setFont(labelFont);
                                l_relationship_type_id.setForeground(black);
                                l_relationship_type_id.setBounds(64, 304, 200, 20);
                                pTables.add(l_relationship_type_id);

                                cb_relationship_code = new JComboBox();
                                cb_relationship_code.setFont(bodyFont);
                                cb_relationship_code.setForeground(black);
                                cb_relationship_code.setBounds(64,328,554,40);
                                cb_relationship_code.setBackground(Color.WHITE);
                                cb_data = Read.getRelationshipCode();
                                for (String item : cb_data) {
                                    cb_relationship_code.addItem(item);
                                }
                                cb_relationship_code.setSelectedItem(null);
                                cb_relationship_code.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        try {
                                            relationship_code = Integer.parseInt(cb_relationship_code.getSelectedItem().toString());
                                            ArrayList<String> info = Read.getRelationshipTypeInfo(relationship_code);
                                            t_relationships_description.setText(info.get(0));
                                        }
                                        catch (Exception ex) {
                                        }
                                    }
                                });
                                pTables.add(cb_relationship_code);

                                JLabel l_relationship_details = new JLabel("Details");
                                l_relationship_details.setFont(labelFont);
                                l_relationship_details.setForeground(black);
                                l_relationship_details.setBounds(64, 392, 265, 20);
                                pTables.add(l_relationship_details);

                                t_relationships_description = new JTextArea();
                                t_relationships_description.setLineWrap(true);
                                t_relationships_description.setFont(bodyFont);
                                t_relationships_description.setForeground(lockedGray);
                                t_relationships_description.setBorder(border);
                                t_relationships_description.setBounds(64, 416, 554, 139);
                                t_relationships_description.setBackground(backgroundGray);
                                t_relationships_description.setEditable(false);
                                pTables.add(t_relationships_description);

                                b_submit.setBounds(64, 576, 554, 40);
                                b_submit.addActionListener(this);
                                pTables.add(b_submit);

                                pTables.updateUI();
                                break;
                            case "health_records":
                                pTables.setPreferredSize(new Dimension (642,1000));

                                pTables.removeAll();

                                b_submit.removeActionListener(this);

                                lTitle.setBounds(64,64,265,38);
                                pTables.add(lTitle);

                                lDescription.setBounds(64,108,554,28);
                                pTables.add(lDescription);

                                lTables.setBounds(64,160,40 ,20);
                                pTables.add(lTables);

                                cbTables.setBounds(64,184,554,40);
                                cbTables.setSelectedItem("health_records");
                                pTables.add(cbTables);

                                JLabel l_health_record = new JLabel("Current Information");
                                l_health_record.setFont(subtitleFont);
                                l_health_record.setForeground(black);
                                l_health_record.setBounds(64, 248, 280, 32);
                                pTables.add(l_health_record);

                                JLabel l_health_record_id = new JLabel("Health Record ID");
                                l_health_record_id.setFont(labelFont);
                                l_health_record_id.setForeground(black);
                                l_health_record_id.setBounds(64, 304, 200, 20);
                                pTables.add(l_health_record_id);

                                cb_health_record_id = new JComboBox();
                                cb_health_record_id.setFont(bodyFont);
                                cb_health_record_id.setForeground(black);
                                cb_health_record_id.setBounds(64,328,265,40);
                                cb_health_record_id.setBackground(Color.WHITE);
                                cb_data = Read.getHealthRecordID();
                                for (String item : cb_data) {
                                    cb_health_record_id.addItem(item);
                                }
                                cb_health_record_id.setSelectedItem(null);
                                cb_health_record_id.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        try {
                                            health_record_id = Integer.parseInt(cb_health_record_id.getSelectedItem().toString());
                                            ArrayList<String> info = Read.getHealthRecordInfo(health_record_id);
                                            t_vet_id.setText(info.get(0));
                                            t_dog_id.setText(info.get(1));
                                            t_summary.setText(info.get(2));
                                            t_other_details.setText(info.get(3));
                                        }
                                        catch (Exception ex) {
                                        }
                                    }
                                });
                                pTables.add(cb_health_record_id);

                                JLabel l_health_record_vet_id = new JLabel("Vet ID");
                                l_health_record_vet_id.setFont(labelFont);
                                l_health_record_vet_id.setForeground(black);
                                l_health_record_vet_id.setBounds(353, 304, 265, 20);
                                pTables.add(l_health_record_vet_id);

                                t_vet_id = new JTextField();
                                t_vet_id.setFont(bodyFont);
                                t_vet_id.setForeground(lockedGray);
                                t_vet_id.setBorder(border);
                                t_vet_id.setBounds(353,328,265,40);
                                t_vet_id.setBackground(backgroundGray);
                                t_vet_id.setEditable(false);
                                pTables.add(t_vet_id);

                                JLabel l_health_record_dog_id = new JLabel("Dog ID");
                                l_health_record_dog_id.setFont(labelFont);
                                l_health_record_dog_id.setForeground(black);
                                l_health_record_dog_id.setBounds(64, 392, 265, 20);
                                pTables.add(l_health_record_dog_id);

                                t_dog_id = new JTextField();
                                t_dog_id.setFont(bodyFont);
                                t_dog_id.setForeground(lockedGray);
                                t_dog_id.setBorder(border);
                                t_dog_id.setBounds(64,416,554,40);
                                t_dog_id.setBackground(backgroundGray);
                                t_dog_id.setEditable(false);
                                pTables.add(t_dog_id);

                                JLabel l_health_record_summary = new JLabel("Summary");
                                l_health_record_summary.setFont(labelFont);
                                l_health_record_summary.setForeground(black);
                                l_health_record_summary.setBounds(64, 480, 265, 20);
                                pTables.add(l_health_record_summary);

                                t_summary = new JTextArea();
                                t_summary.setLineWrap(true);
                                t_summary.setFont(bodyFont);
                                t_summary.setForeground(lockedGray);
                                t_summary.setBorder(border);
                                t_summary.setBounds(64, 504, 554, 139);
                                t_summary.setBackground(backgroundGray);
                                t_summary.setEditable(false);
                                pTables.add(t_summary);

                                JLabel l_health_record_details = new JLabel("Details");
                                l_health_record_details.setFont(labelFont);
                                l_health_record_details.setForeground(black);
                                l_health_record_details.setBounds(64, 658, 265, 20);
                                pTables.add(l_health_record_details);

                                t_other_details = new JTextArea();
                                t_other_details.setLineWrap(true);
                                t_other_details.setFont(bodyFont);
                                t_other_details.setForeground(lockedGray);
                                t_other_details.setBorder(border);
                                t_other_details.setBounds(64, 680, 554, 139);
                                t_other_details.setBackground(backgroundGray);
                                t_other_details.setEditable(false);
                                pTables.add(t_other_details);

                                b_submit.setBounds(64, 842, 554, 40);
                                b_submit.addActionListener(this);
                                pTables.add(b_submit);

                                pTables.updateUI();
                                break;
                            case "common_problems":
                                pTables.setPreferredSize(new Dimension (642,700));

                                pTables.removeAll();

                                b_submit.removeActionListener(this);

                                lTitle.setBounds(64,64,265,38);
                                pTables.add(lTitle);

                                lDescription.setBounds(64,108,554,28);
                                pTables.add(lDescription);

                                lTables.setBounds(64,160,40 ,20);
                                pTables.add(lTables);

                                cbTables.setBounds(64,184,554,40);
                                cbTables.setSelectedItem("common_problems");
                                pTables.add(cbTables);

                                JLabel l_common_problem = new JLabel("Current Information");
                                l_common_problem.setFont(subtitleFont);
                                l_common_problem.setForeground(black);
                                l_common_problem.setBounds(64, 248, 280, 32);
                                pTables.add(l_common_problem);

                                JLabel l_common_problem_code = new JLabel("Problem Code");
                                l_common_problem_code.setFont(labelFont);
                                l_common_problem_code.setForeground(black);
                                l_common_problem_code.setBounds(64, 304, 200, 20);
                                pTables.add(l_common_problem_code);

                                cb_problem_code = new JComboBox();
                                cb_problem_code.setFont(bodyFont);
                                cb_problem_code.setForeground(black);
                                cb_problem_code.setBounds(64,328,554,40);
                                cb_problem_code.setBackground(Color.WHITE);
                                cb_data = Read.getProblemCode();
                                for (String item : cb_data) {
                                    cb_problem_code.addItem(item);
                                }
                                cb_problem_code.setSelectedItem(null);
                                cb_problem_code.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        try {
                                            problem_code = Integer.parseInt(cb_problem_code.getSelectedItem().toString());
                                            ArrayList<String> info = Read.getCommonProblemInfo(problem_code);
                                            t_problem_description.setText(info.get(0));
                                        }
                                        catch (Exception ex) {
                                        }
                                    }
                                });
                                pTables.add(cb_problem_code);

                                JLabel l_common_problem_description = new JLabel("Description");
                                l_common_problem_description.setFont(labelFont);
                                l_common_problem_description.setForeground(black);
                                l_common_problem_description.setBounds(64, 392, 265, 20);
                                pTables.add(l_common_problem_description);

                                t_problem_description = new JTextArea();
                                t_problem_description.setLineWrap(true);
                                t_problem_description.setFont(bodyFont);
                                t_problem_description.setForeground(lockedGray);
                                t_problem_description.setBorder(border);
                                t_problem_description.setBounds(64, 416, 554, 139);
                                t_problem_description.setBackground(backgroundGray);
                                t_problem_description.setEditable(false);
                                pTables.add(t_problem_description);

                                b_submit.setBounds(64, 576, 554, 40);
                                b_submit.addActionListener(this);
                                pTables.add(b_submit);

                                pTables.updateUI();
                                break;
                            case "dog_problems":
                                pTables.setPreferredSize(new Dimension (642,1000));

                                pTables.removeAll();

                                b_submit.removeActionListener(this);

                                lTitle.setBounds(64,64,265,38);
                                pTables.add(lTitle);

                                lDescription.setBounds(64,108,554,28);
                                pTables.add(lDescription);

                                lTables.setBounds(64,160,40 ,20);
                                pTables.add(lTables);

                                cbTables.setBounds(64,184,554,40);
                                cbTables.setSelectedItem("dog_problems");
                                pTables.add(cbTables);

                                JLabel l_dog_problem = new JLabel("Current Information");
                                l_dog_problem.setFont(subtitleFont);
                                l_dog_problem.setForeground(black);
                                l_dog_problem.setBounds(64, 248, 280, 32);
                                pTables.add(l_dog_problem);

                                JLabel l_dog_problem_problem_code = new JLabel("Problem Code");
                                l_dog_problem_problem_code.setFont(labelFont);
                                l_dog_problem_problem_code.setForeground(black);
                                l_dog_problem_problem_code.setBounds(64, 304, 200, 20);
                                pTables.add(l_dog_problem_problem_code);

                                cb_problem_code = new JComboBox();
                                cb_problem_code.setFont(bodyFont);
                                cb_problem_code.setForeground(black);
                                cb_problem_code.setBounds(64,328,265,40);
                                cb_problem_code.setBackground(Color.WHITE);
                                cb_data = Read.getProblemCode();
                                for (String item : cb_data) {
                                    cb_problem_code.addItem(item);
                                }
                                cb_problem_code.setSelectedItem(null);
                                cb_problem_code.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        try {
                                            cb_health_record_id.removeAllItems();
                                            problem_code = Integer.parseInt(cb_problem_code.getSelectedItem().toString());
                                            ArrayList<String> data = Read.getDogProblems_HealthRecordsID(problem_code);
                                            for (String item : data) {
                                                cb_health_record_id.addItem(item);
                                            }
                                            cb_health_record_id.setSelectedItem(null);
                                            cb_health_record_id.setEnabled(true);
                                        }
                                        catch (Exception ex) {
                                        }
                                    }
                                });
                                pTables.add(cb_problem_code);

                                JLabel l_dog_problem_health_record_id = new JLabel("Health Record ID");
                                l_dog_problem_health_record_id.setFont(labelFont);
                                l_dog_problem_health_record_id.setForeground(black);
                                l_dog_problem_health_record_id.setBounds(353, 304, 265, 20);
                                pTables.add(l_dog_problem_health_record_id);

                                cb_health_record_id = new JComboBox();
                                cb_health_record_id.setFont(bodyFont);
                                cb_health_record_id.setForeground(black);
                                cb_health_record_id.setBounds(353,328,265,40);
                                cb_health_record_id.setBackground(Color.WHITE);
                                cb_health_record_id.setSelectedItem(null);
                                cb_health_record_id.setEnabled(false);
                                cb_health_record_id.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        try {
                                            if (cb_health_record_id.getSelectedItem() != null) {
                                                problem_code = Integer.parseInt(cb_problem_code.getSelectedItem().toString());
                                                health_record_id = Integer.parseInt(cb_health_record_id.getSelectedItem().toString());
                                                ArrayList<String> info = Read.getDogProblems_HealthRecordsIDInfo(problem_code, health_record_id);
                                                t_date_of_problem.setText(info.get(0));
                                                t_problem_treatment.setText(info.get(1));
                                                t_problem_details.setText(info.get(2));
                                            }
                                            else {
                                                t_date_of_problem.setText("");
                                                t_problem_treatment.setText("");
                                                t_problem_details.setText("");
                                            }
                                        }
                                        catch (Exception ex) {
                                        }
                                    }
                                });
                                pTables.add(cb_health_record_id);

                                JLabel l_dog_problem_date_of_problem = new JLabel("Date of Problem");
                                l_dog_problem_date_of_problem.setFont(labelFont);
                                l_dog_problem_date_of_problem.setForeground(black);
                                l_dog_problem_date_of_problem.setBounds(64, 392, 265, 20);
                                pTables.add(l_dog_problem_date_of_problem);

                                t_date_of_problem = new JTextField();
                                t_date_of_problem.setFont(bodyFont);
                                t_date_of_problem.setForeground(lockedGray);
                                t_date_of_problem.setBorder(border);
                                t_date_of_problem.setBounds(64,416,554,40);
                                t_date_of_problem.setBackground(backgroundGray);
                                t_date_of_problem.setEditable(false);
                                pTables.add(t_date_of_problem);

                                JLabel l_dog_problem_treatment = new JLabel("Treatment");
                                l_dog_problem_treatment.setFont(labelFont);
                                l_dog_problem_treatment.setForeground(black);
                                l_dog_problem_treatment.setBounds(64, 480, 265, 20);
                                pTables.add(l_dog_problem_treatment);

                                t_problem_treatment = new JTextArea();
                                t_problem_treatment.setLineWrap(true);
                                t_problem_treatment.setFont(bodyFont);
                                t_problem_treatment.setForeground(lockedGray);
                                t_problem_treatment.setBorder(border);
                                t_problem_treatment.setBounds(64, 504, 554, 139);
                                t_problem_treatment.setBackground(backgroundGray);
                                t_problem_treatment.setEditable(false);
                                pTables.add(t_problem_treatment);

                                JLabel l_dog_problem_details = new JLabel("Details");
                                l_dog_problem_details.setFont(labelFont);
                                l_dog_problem_details.setForeground(black);
                                l_dog_problem_details.setBounds(64, 656, 265, 20);
                                pTables.add(l_dog_problem_details);

                                t_problem_details = new JTextArea();
                                t_problem_details.setLineWrap(true);
                                t_problem_details.setFont(bodyFont);
                                t_problem_details.setForeground(lockedGray);
                                t_problem_details.setBorder(border);
                                t_problem_details.setBounds(64, 680, 554, 139);
                                t_problem_details.setBackground(backgroundGray);
                                t_problem_details.setEditable(false);
                                pTables.add(t_problem_details);

                                b_submit.setBounds(64, 842, 554, 40);
                                b_submit.addActionListener(this);
                                pTables.add(b_submit);

                                pTables.updateUI();
                                break;
                        }
                        break;
                }
            } catch (Exception ex) {
            }
        }
        if (e.getSource() == b_submit) {
            try {
                switch (panel) {
                    case "create":
                        switch (table) {
                            case "vets":
                                vet_id = Integer.parseInt(t_vet_id.getText());
                                vet_name = t_vet_name.getText();
                                other_details = pt_other_details.getText();
                                Create.createVet(vet_id, vet_name, other_details);
                                t_vet_id.setText("" + Read.getMaxVetID());
                                t_vet_name.setText(null);
                                pt_other_details.setText(null);
                                break;
                            case "dogs":
                                dog_id = Integer.parseInt(t_dog_id.getText());
                                dogs_name = t_dog_name.getText();
                                place_of_birth = t_dog_place_of_birth.getText();
                                date_of_birth = new java.sql.Date(dc_date_of_birth.getDate().getTime());
                                litter_id = Integer.parseInt(cb_dog_born_in_litter.getSelectedItem().toString());
                                if (rb_dog_female.isSelected()) {
                                    dogs_gender = "F";
                                }
                                if (rb_dog_male.isSelected()) {
                                    dogs_gender = "M";
                                }
                                other_details = pt_other_details.getText();
                                Create.createDog(dog_id, dogs_name, place_of_birth, date_of_birth,
                                        litter_id, dogs_gender, other_details);
                                t_dog_id.setText("" + Read.getMaxDogID());
                                t_dog_name.setText(null);
                                t_dog_place_of_birth.setText(null);
                                dc_date_of_birth.setDate(null);
                                cb_dog_born_in_litter.setSelectedItem(null);
                                rb_dog_female.setSelected(false);
                                rb_dog_male.setSelected(false);
                                pt_other_details.setText(null);
                                break;
                            case "litters":
                                litter_id = Integer.parseInt(t_litter_id.getText());
                                sire_dog_id = Integer.parseInt(cb_sire_dog_id.getSelectedItem().toString());
                                dam_dog_id = Integer.parseInt(cb_dam_dog_id.getSelectedItem().toString());
                                place_of_birth = t_litter_place_of_birth.getText();
                                date_of_birth = new java.sql.Date(dc_date_of_birth.getDate().getTime());
                                other_details = pt_other_details.getText();
                                Create.createLitter(litter_id, sire_dog_id, dam_dog_id, place_of_birth,
                                        date_of_birth, other_details);
                                t_litter_id.setText("" + Read.getMaxLitterID());
                                cb_sire_dog_id.setSelectedItem(null);
                                cb_dam_dog_id.setSelectedItem(null);
                                t_litter_place_of_birth.setText(null);
                                dc_date_of_birth.setDate(null);
                                pt_other_details.setText(null);
                                break;
                            case "relationships":
                                relationship_id = Integer.parseInt(t_relationship_id.getText());
                                relationship_code = Integer.parseInt(cb_relationship_code.getSelectedItem().toString());
                                dog_1_id = Integer.parseInt(cb_dog_1_id.getSelectedItem().toString());
                                dog_2_id = Integer.parseInt(cb_dog_2_id.getSelectedItem().toString());
                                other_details = pt_other_details.getText();
                                Create.createRelationship(relationship_id, relationship_code, dog_1_id, dog_2_id, other_details);
                                t_relationship_id.setText("" + Read.getMaxRelationshipID());
                                cb_relationship_code.setSelectedItem(null);
                                cb_dog_1_id.setSelectedItem(null);
                                cb_dog_2_id.setSelectedItem(null);
                                pt_other_details.setText(null);
                                break;
                            case "relationship_types":
                                relationship_code = Integer.parseInt(t_relationship_code.getText());
                                relationship_description = pt_relationships_description.getText();
                                Create.createRelationshipType(relationship_code, relationship_description);
                                t_relationship_code.setText("" + Read.getMaxRelationshipCode());
                                pt_relationships_description.setText(null);
                                break;
                            case "health_records":
                                health_record_id = Integer.parseInt(t_health_record_id.getText());
                                vet_id = Integer.parseInt(cb_vet_id.getSelectedItem().toString());
                                dog_id = Integer.parseInt(cb_dog_id.getSelectedItem().toString());
                                summary = pt_summary.getText();
                                other_details = pt_other_details.getText();
                                Create.createHealthRecord(health_record_id, vet_id, dog_id, summary, other_details);
                                t_health_record_id.setText("" + Read.getMaxHealthRecordID());
                                cb_vet_id.setSelectedItem(null);
                                cb_dog_id.setSelectedItem(null);
                                pt_summary.setText(null);
                                pt_other_details.setText(null);
                                break;
                            case "common_problems":
                                problem_code = Integer.parseInt(t_problem_code.getText());
                                problem_description = pt_problem_description.getText();
                                Create.createCommonProblem(problem_code, problem_description);
                                t_problem_code.setText("" + Read.getMaxProblemCode());
                                pt_problem_description.setText(null);
                                break;
                            case "dog_problems":
                                problem_code = Integer.parseInt(cb_problem_code.getSelectedItem().toString());
                                health_record_id = Integer.parseInt(cb_health_record_id.getSelectedItem().toString());
                                date_of_problem = new java.sql.Date(dc_date_of_problem.getDate().getTime());
                                treatment = pt_problem_treatment.getText();
                                other_details = pt_other_details.getText();
                                Create.createDogProblems(problem_code, health_record_id, date_of_problem, treatment, other_details);
                                cb_problem_code.setSelectedItem(null);
                                cb_health_record_id.setSelectedItem(null);
                                dc_date_of_problem.setDate(null);
                                pt_problem_treatment.setText(null);
                                pt_other_details.setText(null);
                                break;
                        }
                        break;
                    case "update":
                        switch (table) {
                            case "vets":
                                vet_id = Integer.parseInt(cb_vet_id.getSelectedItem().toString());
                                if (t_vet_name_update.getText().equals("")) {
                                    vet_name = t_vet_name.getText();
                                }
                                else {
                                    vet_name = t_vet_name_update.getText();
                                }
                                if (pt_other_details_update.getText().equals("e.g. Specializes on surgery")) {
                                    other_details = t_other_details.getText();
                                }
                                else {
                                    other_details = pt_other_details_update.getText();
                                }
                                if (Update.updateVet(vet_id, vet_name, other_details)) {
                                    cb_vet_id.setSelectedItem(null);
                                    t_vet_name.setText(null);
                                    t_other_details.setText(null);
                                    t_vet_name_update.setText(null);
                                    pt_other_details_update.setText(null);
                                }
                                break;
                            case "dogs":
                                //error en cb_dog_id
                                dog_id = Integer.parseInt(cb_dog_id.getSelectedItem().toString());
                                if (t_dogs_name_update.getText().equals("")) {
                                    dogs_name = t_dog_name.getText();
                                }
                                else {
                                    dogs_name = t_dogs_name_update.getText();
                                }
                                if (t_dog_place_of_birth_update.getText().equals("")) {
                                    place_of_birth = t_dog_place_of_birth.getText();
                                }
                                else {
                                    place_of_birth = t_dog_place_of_birth_update.getText();
                                }
                                if (dc_date_of_birth_update.getDate() == null || dc_date_of_birth_update.getDate().equals("")) {
                                    date_of_birth = Date.valueOf(t_date_of_birth.getText());
                                }
                                else {
                                    date_of_birth = new java.sql.Date(dc_date_of_birth_update.getDate().getTime());
                                }
                                if (cb_dog_born_in_litter_update.getSelectedItem() == null) {
                                    litter_id = Integer.parseInt(t_dog_born_in_litter.getText());
                                } else {
                                    litter_id = Integer.parseInt(cb_dog_born_in_litter_update.getSelectedItem().toString());

                                }
                                if ((!rb_dog_male_update.isSelected() && (!rb_dog_female_update.isSelected()))) {
                                    if (rb_dog_female.isSelected()) {
                                        dogs_gender = "F";
                                    }
                                    if (rb_dog_male.isSelected()) {
                                        dogs_gender = "M";
                                    }
                                } else {
                                    if (rb_dog_female_update.isSelected()) {
                                        dogs_gender = "F";
                                    }
                                    if (rb_dog_male_update.isSelected()) {
                                        dogs_gender = "M";
                                    }
                                }
                                if (pt_other_details_update.getText().equals("e.g. Is very playful")) {
                                    other_details = t_other_details.getText();
                                }
                                else {
                                    other_details = pt_other_details_update.getText();
                                }
                                if (Update.updateDog(dog_id, dogs_name, place_of_birth, date_of_birth,
                                    litter_id, dogs_gender, other_details)) {
                                    t_dog_name.setText(null);
                                    t_dog_place_of_birth.setText(null);
                                    t_date_of_birth.setText(null);
                                    t_dog_born_in_litter.setText(null);
                                    rb_dog_female.setSelected(false);
                                    rb_dog_male.setSelected(false);
                                    t_other_details.setText(null);
                                    t_dogs_name_update.setText(null);
                                    t_dog_place_of_birth_update.setText(null);
                                    dc_date_of_birth_update.setDate(null);
                                    cb_dog_born_in_litter_update.setSelectedItem(null);
                                    rb_dog_female_update.setSelected(false);
                                    rb_dog_male_update.setSelected(false);
                                    pt_other_details_update.setText(null);
                                    cb_dog_id.setSelectedItem(null);
                                }
                                break;
                            case "litters":
                                litter_id = Integer.parseInt(cb_litter_id.getSelectedItem().toString());
                                if (cb_sire_dog_id_update.getSelectedItem() == null) {
                                    sire_dog_id = Integer.parseInt(t_sire_dog_id.getText());
                                } else {
                                    sire_dog_id = Integer.parseInt(cb_sire_dog_id_update.getSelectedItem().toString());
                                }
                                if (cb_dam_dog_id_update.getSelectedItem() == null) {
                                    dam_dog_id = Integer.parseInt(t_dam_dog_id.getText());
                                } else {
                                    dam_dog_id = Integer.parseInt(cb_dam_dog_id_update.getSelectedItem().toString());
                                }
                                if (t_litter_place_of_birth_update.getText().equals("")) {
                                    place_of_birth = t_litter_place_of_birth.getText();
                                }
                                else {
                                    place_of_birth = t_litter_place_of_birth_update.getText();
                                }
                                if (dc_date_of_birth_update.getDate() == null || dc_date_of_birth_update.getDate().equals("")) {
                                    date_of_birth = Date.valueOf(t_date_of_birth.getText());
                                }
                                else {
                                    date_of_birth = new java.sql.Date(dc_date_of_birth_update.getDate().getTime());
                                }
                                if (pt_other_details_update.getText().equals("e.g. All puppies are healthy, Five puppies in total")) {
                                    other_details = t_other_details.getText();
                                }
                                else {
                                    other_details = pt_other_details_update.getText();
                                }
                                if (Update.updateLitter(litter_id, sire_dog_id, dam_dog_id, place_of_birth,
                                        date_of_birth, other_details)) {
                                    cb_litter_id.setSelectedItem(null);
                                    t_sire_dog_id.setText(null);
                                    t_dam_dog_id.setText(null);
                                    t_litter_place_of_birth.setText(null);
                                    t_date_of_birth.setText(null);
                                    t_other_details.setText(null);
                                    cb_sire_dog_id_update.setSelectedItem(null);
                                    cb_dam_dog_id_update.setSelectedItem(null);
                                    t_litter_place_of_birth_update.setText(null);
                                    dc_date_of_birth_update.setDate(null);
                                    pt_other_details_update.setText(null);
                                }
                                break;
                            case "relationships":
                                relationship_id = Integer.parseInt(cb_relationship_id.getSelectedItem().toString());
                                if (cb_relationship_code_update.getSelectedItem() == null) {
                                    relationship_code = Integer.parseInt(t_relationship_code.getText());
                                } else {
                                    relationship_code = Integer.parseInt(cb_relationship_code_update.getSelectedItem().toString());
                                }
                                if (cb_dog_1_id_update.getSelectedItem() == null) {
                                    dog_1_id = Integer.parseInt(t_dog_1_id.getText());
                                } else {
                                    dog_1_id = Integer.parseInt(cb_dog_1_id_update.getSelectedItem().toString());
                                }
                                if (cb_dog_2_id_update.getSelectedItem() == null) {
                                    dog_2_id = Integer.parseInt(t_dog_2_id.getText());
                                } else {
                                    dog_2_id = Integer.parseInt(cb_dog_2_id_update.getSelectedItem().toString());
                                }
                                if (pt_other_details_update.getText().equals("e.g. The dogs are siblings")) {
                                    other_details = t_other_details.getText();
                                }
                                else {
                                    other_details = pt_other_details_update.getText();
                                }
                                if (Update.updateRelationship(relationship_id, relationship_code, dog_1_id, dog_2_id, other_details)) {
                                    cb_relationship_id.setSelectedItem(null);
                                    t_relationship_code.setText(null);
                                    t_dog_1_id.setText(null);
                                    t_dog_2_id.setText(null);
                                    t_other_details.setText(null);
                                    cb_relationship_code_update.setSelectedItem(null);
                                    cb_dog_1_id_update.setSelectedItem(null);
                                    cb_dog_2_id_update.setSelectedItem(null);
                                    pt_other_details_update.setText(null);
                                }
                                break;
                            case "relationship_types":
                                relationship_code = Integer.parseInt(cb_relationship_code.getSelectedItem().toString());
                                if (pt_relationships_description_update.getText().equals("e.g. Siblings")) {
                                    relationship_description = t_relationships_description.getText();
                                }
                                else {
                                    relationship_description = pt_relationships_description_update.getText();
                                }
                                if (Update.updateRelationshipType(relationship_code, relationship_description)) {
                                    t_relationships_description.setText(null);
                                    pt_relationships_description_update.setText(null);
                                    cb_relationship_code.setSelectedItem(null);
                                }
                                break;
                            case "health_records":
                                health_record_id = Integer.parseInt(cb_health_record_id.getSelectedItem().toString());
                                if (cb_vet_id_update.getSelectedItem() == null) {
                                    vet_id = Integer.parseInt(t_vet_id.getText());
                                } else {
                                    vet_id = Integer.parseInt(cb_vet_id_update.getSelectedItem().toString());
                                }
                                if (cb_dog_id_update.getSelectedItem() == null) {
                                    dog_id = Integer.parseInt(t_dog_id.getText());
                                } else {
                                    dog_id = Integer.parseInt(cb_dog_id_update.getSelectedItem().toString());
                                }
                                if (pt_summary_update.getText().equals("e.g. The was administered the vaccines")) {
                                    summary = t_summary.getText();
                                }
                                else {
                                    summary = pt_summary_update.getText();
                                }
                                if (pt_other_details_update.getText().equals("e.g. The dog is healthy")) {
                                    other_details = t_other_details.getText();
                                }
                                else {
                                    other_details = pt_other_details_update.getText();
                                }
                                if (Update.updateHealthRecord(health_record_id, vet_id, dog_id, summary, other_details)) {
                                    cb_health_record_id.setSelectedItem(null);
                                    t_vet_id.setText(null);
                                    t_dog_id.setText(null);
                                    t_summary.setText(null);
                                    t_other_details.setText(null);
                                    cb_vet_id_update.setSelectedItem(null);
                                    cb_dog_id_update.setSelectedItem(null);
                                    pt_summary_update.setText(null);
                                    pt_other_details_update.setText(null);
                                }
                                break;
                            case "common_problems":
                                problem_code = Integer.parseInt(cb_problem_code.getSelectedItem().toString());
                                if (pt_problem_description_update.getText().equals("e.g. Fever: The dog has high temperature, coughing, and runny nose")) {
                                    problem_description = t_problem_description.getText();
                                }
                                else {
                                    problem_description = pt_problem_description_update.getText();
                                }
                                if (Update.updateCommonProblem(problem_code, problem_description)) {
                                    cb_problem_code.setSelectedItem(null);
                                    t_problem_description.setText(null);
                                    pt_problem_description_update.setText(null);
                                }
                                break;
                            case "dog_problems":
                                problem_code = Integer.parseInt(cb_problem_code.getSelectedItem().toString());
                                if (cb_health_record_id_update.getSelectedItem() == null) {
                                    health_record_id = Integer.parseInt(cb_health_record_id.getSelectedItem().toString());
                                } else {
                                    health_record_id = Integer.parseInt(cb_health_record_id_update.getSelectedItem().toString());
                                }
                                if (dc_date_of_problem_update.getDate() == null || dc_date_of_problem_update.getDate().equals("")) {
                                    date_of_problem = Date.valueOf(t_date_of_problem.getText());
                                }
                                else {
                                    date_of_problem = new java.sql.Date(dc_date_of_problem_update.getDate().getTime());
                                }
                                if (pt_problem_treatment_update.getText().equals("e.g. The dog was given antibiotics")) {
                                    treatment = t_problem_treatment.getText();
                                }
                                else {
                                    treatment = pt_problem_treatment_update.getText();
                                }
                                if (pt_problem_details_update.getText().equals("e.g. The dog is healthy")) {
                                    other_details = t_problem_details.getText();
                                }
                                else {
                                    other_details = pt_problem_details_update.getText();
                                }
                                if (Update.updateDogProblems(problem_code, health_record_id, date_of_problem, treatment, other_details)) {
                                    cb_problem_code.setSelectedItem(null);
                                    cb_health_record_id.setSelectedItem(null);
                                    t_date_of_problem.setText(null);
                                    t_problem_treatment.setText(null);
                                    t_problem_details.setText(null);
                                    cb_health_record_id_update.setSelectedItem(null);
                                    dc_date_of_problem_update.setDate(null);
                                    pt_problem_treatment_update.setText(null);
                                    pt_problem_details_update.setText(null);
                                }
                                break;
                        }
                        break;
                    case "delete":
                        switch (table) {
                            case "vets":
                                vet_id = Integer.parseInt(cb_vet_id.getSelectedItem().toString());
                                column1 = "vet_id";
                                if (Delete.deleteInfo(table, column1, vet_id)) {
                                    cb_vet_id.setSelectedItem(null);
                                    t_vet_name.setText(null);
                                    t_other_details.setText(null);
                                }
                                break;
                            case "dogs":
                                dog_id = Integer.parseInt(cb_dog_id.getSelectedItem().toString());
                                column1 = "dog_id";
                                if (Delete.deleteInfo(table, column1, dog_id)) {
                                    t_dog_name.setText(null);
                                    t_dog_place_of_birth.setText(null);
                                    t_date_of_birth.setText(null);
                                    t_dog_born_in_litter.setText(null);
                                    rb_dog_female.setSelected(false);
                                    rb_dog_male.setSelected(false);
                                    t_other_details.setText(null);
                                    cb_dog_id.setSelectedItem(null);
                                }
                                break;
                            case "litters":
                                litter_id = Integer.parseInt(cb_litter_id.getSelectedItem().toString());
                                column1 = "litter_id";
                                if (Delete.deleteInfo(table, column1, litter_id)) {
                                    cb_litter_id.setSelectedItem(null);
                                    t_sire_dog_id.setText(null);
                                    t_dam_dog_id.setText(null);
                                    t_litter_place_of_birth.setText(null);
                                    t_date_of_birth.setText(null);
                                    t_other_details.setText(null);
                                }
                                break;
                            case "relationships":
                                relationship_id = Integer.parseInt(cb_relationship_id.getSelectedItem().toString());
                                column1 = "relationship_id";
                                if (Delete.deleteInfo(table, column1, relationship_id)) {
                                    cb_relationship_id.setSelectedItem(null);
                                    t_relationship_code.setText(null);
                                    t_dog_1_id.setText(null);
                                    t_dog_2_id.setText(null);
                                    t_other_details.setText(null);
                                }
                                break;
                            case "relationship_types":
                                relationship_code = Integer.parseInt(cb_relationship_code.getSelectedItem().toString());
                                column1 = "relationship_code";
                                if (Delete.deleteInfo(table, column1, relationship_code)) {
                                    cb_relationship_code.setSelectedItem(null);
                                    t_relationships_description.setText(null);
                                }
                                break;
                            case "health_records":
                                health_record_id = Integer.parseInt(cb_health_record_id.getSelectedItem().toString());
                                column1 = "health_record_id";
                                if (Delete.deleteInfo(table, column1, health_record_id)) {
                                    cb_health_record_id.setSelectedItem(null);
                                    t_vet_id.setText(null);
                                    t_dog_id.setText(null);
                                    t_summary.setText(null);
                                    t_other_details.setText(null);
                                }
                                break;
                            case "common_problems":
                                problem_code = Integer.parseInt(cb_problem_code.getSelectedItem().toString());
                                column1 = "problem_code";
                                if (Delete.deleteInfo(table, column1, problem_code)) {
                                    cb_problem_code.setSelectedItem(null);
                                    t_problem_description.setText(null);
                                }
                                break;
                            case "dog_problems":
                                problem_code = Integer.parseInt(cb_problem_code.getSelectedItem().toString());
                                health_record_id = Integer.parseInt(cb_health_record_id.getSelectedItem().toString());
                                column1 = "problem_code";
                                column2 = "health_record_id";
                                if (Delete.deleteInfo(table, column1, problem_code, column2, health_record_id)) {
                                    cb_problem_code.setSelectedItem(null);
                                    cb_health_record_id.setSelectedItem(null);
                                    t_date_of_problem.setText(null);
                                    t_problem_treatment.setText(null);
                                    t_problem_details.setText(null);
                                }
                                break;
                        }
                        break;
                    case "adopt":
                        //error en cb_dog_id
                        dog_id = Integer.parseInt(cb_dog_id.getSelectedItem().toString());
                        owner_name = t_owner_update.getText();
                        if (Update.updateAdopted(dog_id, owner_name)) {
                            t_dog_name.setText(null);
                            t_owner_update.setText(null);
                        }
                        break;
                    case "return":
                        //error en cb_dog_id
                        dog_id = Integer.parseInt(cb_dog_id.getSelectedItem().toString());
                        if (Update.updateReturned(dog_id)) {
                            t_dog_name.setText(null);
                        }
                        break;
                    case "book_visit":
                        appointment_id = Integer.parseInt(t_appointment_id.getText());
                        dog_id = Integer.parseInt(cb_dog_id.getSelectedItem().toString());
                        vet_id = Integer.parseInt(cb_vet_id.getSelectedItem().toString());
                        appointment_date = new java.sql.Date(dc_appointment_date.getDate().getTime());
                        //no da bien el time
                        appointment_time = new java.sql.Time(Time.valueOf(cb_appointment_time.getSelectedItem().toString()).getTime());
                        appointment_reason = pt_appointment_reason.getText();
                        Create.createAppointment(appointment_id, dog_id, vet_id, appointment_date, appointment_time, appointment_reason);
                        t_appointment_id.setText("" + Read.getMaxAppointmentID());
                        cb_vet_id.setSelectedItem(null);
                        cb_dog_id.setSelectedItem(null);
                        dc_appointment_date.setDate(null);
                        cb_appointment_time.setSelectedItem(null);
                        pt_appointment_reason.setText(null);
                        break;
                    case "cancel_visit":
                        appointment_id = Integer.parseInt(cb_appointment_id.getSelectedItem().toString());
                        column1 = "appointment_id";
                        if (Delete.deleteInfo("vet_appointments", column1, appointment_id)) {
                            t_vet_id.setText(null);
                            t_dog_id.setText(null);
                            t_appointment_date.setText(null);
                            t_appointment_time.setText(null);
                            t_appointment_reason.setText(null);
                            cb_appointment_id.removeItem(appointment_id);
                            cb_appointment_id.setSelectedItem(null);
                        }
                        break;
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Please fill in all the required fields.");
            }
        }
    }
}
