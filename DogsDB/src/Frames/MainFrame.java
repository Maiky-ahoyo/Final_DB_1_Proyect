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

public class MainFrame extends JFrame implements ActionListener {
    private JPanel pMain, pTables;
    private JScrollPane spTables;
    private JScrollBar scrollBar;
    private JButton bCreate, bRead, bUpdate, bDelete;
    private JButton b_submit = new JButton("Submit");
    private Font Inter_Semibold = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/Inter-SemiBold.ttf"));
    private Font Inter_Regular = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/Inter-Regular.ttf"));
    private JComboBox cbTables;
    private JLabel lTables, lIcon, lWelcome, lOptions, lTitle, lDescription, lWelcomeMessage, lBrunoGif;
    protected JTable tTables;
    private static String panel, table;
    private Color backgroundGray = new Color(241, 245, 249);
    private Color orange = new Color(248, 127, 39);
    private Color black = new Color(15, 23, 42);
    private Color textGray = new Color(71, 85, 105);
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
    private ImageIcon iLogo = new ImageIcon("Icons/Logo.png");
    private Icon brunoGif = new ImageIcon("Icons/bruno_happy_dance.gif");
    private ImageIcon iMainLogo = new ImageIcon("Icons/MainLogo.png");

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
        lWelcome.setBounds(64, 95, 115, 28);
        pMain.add(lWelcome);

        lIcon = new JLabel();
        lIcon.setIcon(iLogo);
        lIcon.setBounds(64, 123, 270, 120);
        pMain.add(lIcon);

        lOptions = new JLabel("What would you like to do?");
        lOptions.setFont(bodyFont);
        lOptions.setBounds(64, 248, 210, 28);
        lOptions.setForeground(textGray);
        pMain.add(lOptions);

        bCreate = new JButton();
        bCreate.setIcon(iCreate);
        bCreate.setText("Create");
        bCreate.setIconTextGap(10);
        bCreate.setBounds(64,310,270,56);
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
        bRead.setBounds(64,385,270,56);
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
        bUpdate.setBounds(64,460,270,56);
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
        bDelete.setBounds(64,535,270,56);
        bDelete.setBackground(Color.white);
        bDelete.setBorder(new RoundedBorder(backgroundGray, 2, 12));
        bDelete.setFont(buttonFont);
        bDelete.setForeground(black);
        bDelete.addActionListener(this);
        pMain.add(bDelete);

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
        cbTables.addItem("common_problem");
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
        if ((e.getSource() == cbTables)){
            try {
                table = cbTables.getSelectedItem().toString();

                switch (panel){
                    case "create":
                        switch (table) {
                            case "vets":
                                pTables.setPreferredSize(new Dimension (642,700));

                                pTables.removeAll();

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

                                JTextField t_vet_id = new JTextField();
                                t_vet_id.setFont(bodyFont);
                                t_vet_id.setForeground(black);
                                t_vet_id.setBorder(border);
                                t_vet_id.setBounds(64, 298, 265, 40);
                                pTables.add(t_vet_id);

                                JLabel l_vet_name = new JLabel("Vet's Name");
                                l_vet_name.setFont(labelFont);
                                l_vet_name.setForeground(black);
                                l_vet_name.setBounds(353, 274, 80, 20);
                                pTables.add(l_vet_name);

                                JTextField t_vet_name = new JTextField();
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

                                JPlaceholderTextArea t_vet_other_details = new JPlaceholderTextArea("e.g. Specializes on surgery");
                                t_vet_other_details.setLineWrap(true);
                                t_vet_other_details.setFont(bodyFont);
                                t_vet_other_details.setForeground(black);
                                t_vet_other_details.setBorder(border);
                                t_vet_other_details.setBounds(64, 386, 554, 139);
                                pTables.add(t_vet_other_details);

                                b_submit.setBounds(62, 549, 554, 40);
                                pTables.add(b_submit);

                                pTables.updateUI();
                                break;
                            case "dogs":
                                pTables.setPreferredSize(new Dimension (642,895));

                                pTables.removeAll();

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

                                JTextField t_dog_id = new JTextField();
                                t_dog_id.setFont(bodyFont);
                                t_dog_id.setForeground(black);
                                t_dog_id.setBorder(border);
                                t_dog_id.setBounds(64, 272, 265, 40);
                                pTables.add(t_dog_id);

                                JLabel l_dog_dogs_name = new JLabel("Dog's Name");
                                l_dog_dogs_name.setFont(labelFont);
                                l_dog_dogs_name.setForeground(black);
                                l_dog_dogs_name.setBounds(353, 248, 90, 20);
                                pTables.add(l_dog_dogs_name);

                                JTextField t_dog_dogs_name = new JTextField();
                                t_dog_dogs_name.setFont(bodyFont);
                                t_dog_dogs_name.setForeground(black);
                                t_dog_dogs_name.setBorder(border);
                                t_dog_dogs_name.setBounds(353, 272, 265, 40);
                                pTables.add(t_dog_dogs_name);

                                JLabel l_dog_place_of_birth = new JLabel("Place of Birth");
                                l_dog_place_of_birth.setFont(labelFont);
                                l_dog_place_of_birth.setForeground(black);
                                l_dog_place_of_birth.setBounds(64, 336, 275, 20);
                                pTables.add(l_dog_place_of_birth);

                                JTextField t_dog_place_of_birth = new JTextField();
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

                                JDateChooser dc_dog_date_of_birth = new JDateChooser("yyyy-MM-dd", "yyyy-MM-dd", '_');
                                dc_dog_date_of_birth.setFont(bodyFont);
                                dc_dog_date_of_birth.setForeground(black);
                                dc_dog_date_of_birth.setBounds(353, 360, 265, 40);
                                pTables.add(dc_dog_date_of_birth);

                                JLabel l_dog_born_in_litter = new JLabel("Born in Litter");
                                l_dog_born_in_litter.setFont(labelFont);
                                l_dog_born_in_litter.setForeground(black);
                                l_dog_born_in_litter.setBounds(64, 424, 90, 20);
                                pTables.add(l_dog_born_in_litter);

                                JComboBox cb_dog_born_in_litter = new JComboBox();  // falta agregar las litters con la tabla litters
                                cb_dog_born_in_litter.setFont(bodyFont);
                                cb_dog_born_in_litter.setForeground(black);
                                cb_dog_born_in_litter.setBounds(64,448,554,40);
                                cb_dog_born_in_litter.setBackground(Color.WHITE);
                                pTables.add(cb_dog_born_in_litter);

                                JLabel l_dog_gender_mf = new JLabel("Dog's Gender");
                                l_dog_gender_mf.setFont(labelFont);
                                l_dog_gender_mf.setForeground(black);
                                l_dog_gender_mf.setBounds(64, 512, 130, 20);
                                pTables.add(l_dog_gender_mf);

                                ButtonGroup bg_dog_group = new ButtonGroup();

                                JCheckBox c_dog_female = new JCheckBox();
                                c_dog_female.setFont(bodyFont);
                                c_dog_female.setForeground(black);
                                c_dog_female.setBounds(64, 536, 90, 20);
                                c_dog_female.setText("Female");
                                c_dog_female.setBackground(null);
                                bg_dog_group.add(c_dog_female);
                                pTables.add(c_dog_female);

                                JCheckBox c_dog_male = new JCheckBox();
                                c_dog_male.setFont(bodyFont);
                                c_dog_male.setForeground(black);
                                c_dog_male.setBounds(211, 536, 80, 20);
                                c_dog_male.setText("Male");
                                c_dog_male.setBackground(null);
                                bg_dog_group.add(c_dog_male);
                                pTables.add(c_dog_male);

                                JLabel l_dog_other_details = new JLabel("Other Details");
                                l_dog_other_details.setFont(labelFont);
                                l_dog_other_details.setForeground(black);
                                l_dog_other_details.setBounds(64, 584, 95, 20);
                                pTables.add(l_dog_other_details);

                                JPlaceholderTextArea t_dog_other_details = new JPlaceholderTextArea("e.g. Is very playful");
                                t_dog_other_details.setLineWrap(true);
                                t_dog_other_details.setFont(bodyFont);
                                t_dog_other_details.setForeground(black);
                                t_dog_other_details.setBorder(border);
                                t_dog_other_details.setBounds(64, 608, 554, 139);
                                pTables.add(t_dog_other_details);

                                b_submit.setBounds(64, 771, 554, 40);
                                pTables.add(b_submit);

                                pTables.updateUI();
                                break;
                            case "litters":
                                pTables.setPreferredSize(new Dimension (642,820));

                                pTables.removeAll();

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

                                JTextField t_litter_id = new JTextField();
                                t_litter_id.setFont(bodyFont);
                                t_litter_id.setForeground(black);
                                t_litter_id.setBorder(border);
                                t_litter_id.setBounds(64, 252, 554, 40);
                                pTables.add(t_litter_id);

                                JLabel l_litter_sire_dog_id = new JLabel("Sire Dog ID");
                                l_litter_sire_dog_id.setFont(labelFont);
                                l_litter_sire_dog_id.setForeground(black);
                                l_litter_sire_dog_id.setBounds(64, 316, 265, 20);
                                pTables.add(l_litter_sire_dog_id);

                                JComboBox cb_litter_sire_dog_id = new JComboBox();  // falta agregar las dogs con la tabla dogs
                                cb_litter_sire_dog_id.setFont(bodyFont);
                                cb_litter_sire_dog_id.setForeground(black);
                                cb_litter_sire_dog_id.setBounds(64,340,265,40);
                                cb_litter_sire_dog_id.setBackground(Color.WHITE);
                                pTables.add(cb_litter_sire_dog_id);

                                JLabel l_litter_dam_dog_id = new JLabel("Dam Dog ID");
                                l_litter_dam_dog_id.setFont(labelFont);
                                l_litter_dam_dog_id.setForeground(black);
                                l_litter_dam_dog_id.setBounds(353, 316, 269, 20);
                                pTables.add(l_litter_dam_dog_id);

                                JComboBox cb_litter_dam_dog_id = new JComboBox();  // falta agregar las dogs con la tabla dogs
                                cb_litter_dam_dog_id.setFont(bodyFont);
                                cb_litter_dam_dog_id.setForeground(black);
                                cb_litter_dam_dog_id.setBounds(353,340,265,40);
                                cb_litter_dam_dog_id.setBackground(Color.WHITE);
                                pTables.add(cb_litter_dam_dog_id);

                                JLabel l_litter_place_of_birth = new JLabel("Litter's Place of Birth");
                                l_litter_place_of_birth.setFont(labelFont);
                                l_litter_place_of_birth.setForeground(black);
                                l_litter_place_of_birth.setBounds(64, 400, 275, 20);
                                pTables.add(l_litter_place_of_birth);

                                JTextField t_litter_place_of_birth = new JTextField();
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

                                JDateChooser dc_litter_date_of_birth = new JDateChooser("yyyy-MM-dd", "yyyy-MM-dd", '_');
                                dc_litter_date_of_birth.setFont(bodyFont);
                                dc_litter_date_of_birth.setForeground(black);
                                dc_litter_date_of_birth.setBounds(353, 424, 265, 40);
                                pTables.add(dc_litter_date_of_birth);

                                JLabel l_litter_other_details = new JLabel("Other Details");
                                l_litter_other_details.setFont(labelFont);
                                l_litter_other_details.setForeground(black);
                                l_litter_other_details.setBounds(64, 484, 100, 20);
                                pTables.add(l_litter_other_details);

                                JPlaceholderTextArea t_litter_other_details = new JPlaceholderTextArea("e.g. All puppies are healthy, Five puppies in total");
                                t_litter_other_details.setLineWrap(true);
                                t_litter_other_details.setFont(bodyFont);
                                t_litter_other_details.setForeground(black);
                                t_litter_other_details.setBorder(border);
                                t_litter_other_details.setBounds(64, 512, 554, 139);
                                pTables.add(t_litter_other_details);

                                b_submit.setBounds(64, 685, 554, 40);
                                pTables.add(b_submit);

                                pTables.updateUI();
                                break;
                            case "relationships":
                                pTables.setPreferredSize(new Dimension (642,700));

                                pTables.removeAll();

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

                                JTextField t_relationship_id = new JTextField();
                                t_relationship_id.setFont(bodyFont);
                                t_relationship_id.setForeground(black);
                                t_relationship_id.setBorder(border);
                                t_relationship_id.setBounds(64, 248, 265, 40);
                                pTables.add(t_relationship_id);

                                JLabel l_relationship_code = new JLabel("Relationship Code");
                                l_relationship_code.setFont(labelFont);
                                l_relationship_code.setForeground(black);
                                l_relationship_code.setBounds(353, 224, 130, 20);
                                pTables.add(l_relationship_code);

                                JTextField t_relationship_code = new JTextField();
                                t_relationship_code.setFont(bodyFont);
                                t_relationship_code.setForeground(black);
                                t_relationship_code.setBorder(border);
                                t_relationship_code.setBounds(353, 248, 265, 40);
                                pTables.add(t_relationship_code);

                                JLabel l_relationship_sire_dog_id = new JLabel("Dog 1 ID");
                                l_relationship_sire_dog_id.setFont(labelFont);
                                l_relationship_sire_dog_id.setForeground(black);
                                l_relationship_sire_dog_id.setBounds(64, 312, 265, 20);
                                pTables.add(l_relationship_sire_dog_id);

                                JComboBox cb_relationship_sire_dog_id = new JComboBox();  // falta agregar las dogs con la tabla dogs
                                cb_relationship_sire_dog_id.setFont(bodyFont);
                                cb_relationship_sire_dog_id.setForeground(black);
                                cb_relationship_sire_dog_id.setBounds(64,336,265,40);
                                cb_relationship_sire_dog_id.setBackground(Color.WHITE);
                                pTables.add(cb_relationship_sire_dog_id);

                                JLabel l_relationship_dam_dog_id = new JLabel("Dog 2 ID");
                                l_relationship_dam_dog_id.setFont(labelFont);
                                l_relationship_dam_dog_id.setForeground(black);
                                l_relationship_dam_dog_id.setBounds(353, 312, 269, 20);
                                pTables.add(l_relationship_dam_dog_id);

                                JComboBox cb_relationship_dam_dog_id = new JComboBox();  // falta agregar las dogs con la tabla dogs
                                cb_relationship_dam_dog_id.setFont(bodyFont);
                                cb_relationship_dam_dog_id.setForeground(black);
                                cb_relationship_dam_dog_id.setBounds(353,336,265,40);
                                cb_relationship_dam_dog_id.setBackground(Color.WHITE);
                                pTables.add(cb_relationship_dam_dog_id);

                                JLabel l_relationship_other_details = new JLabel("Other Details");
                                l_relationship_other_details.setFont(labelFont);
                                l_relationship_other_details.setForeground(black);
                                l_relationship_other_details.setBounds(64, 400, 100, 20);
                                pTables.add(l_relationship_other_details);

                                JPlaceholderTextArea t_relationship_other_details = new JPlaceholderTextArea("e.g. The dogs are siblings");
                                t_relationship_other_details.setLineWrap(true);
                                t_relationship_other_details.setFont(bodyFont);
                                t_relationship_other_details.setForeground(black);
                                t_relationship_other_details.setBorder(border);
                                t_relationship_other_details.setBounds(64, 424, 554, 139);
                                pTables.add(t_relationship_other_details);

                                b_submit.setBounds(64, 587, 554, 40);
                                pTables.add(b_submit);

                                pTables.updateUI();
                                break;
                            case "relationship_types":
                                pTables.setPreferredSize(new Dimension (642,700));

                                pTables.removeAll();

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

                                JTextField t_relationships_code = new JTextField();
                                t_relationships_code.setFont(bodyFont);
                                t_relationships_code.setForeground(black);
                                t_relationships_code.setBorder(border);
                                t_relationships_code.setBounds(64, 298, 554, 40);
                                pTables.add(t_relationships_code);

                                JLabel l_relationships_description = new JLabel("Relationship Description");
                                l_relationships_description.setFont(labelFont);
                                l_relationships_description.setForeground(black);
                                l_relationships_description.setBounds(64, 362, 200, 20);
                                pTables.add(l_relationships_description);

                                JPlaceholderTextArea t_relationships_description = new JPlaceholderTextArea("e.g. Siblings");
                                t_relationships_description.setLineWrap(true);
                                t_relationships_description.setFont(bodyFont);
                                t_relationships_description.setForeground(black);
                                t_relationships_description.setBorder(border);
                                t_relationships_description.setBounds(64, 386, 554, 139);
                                pTables.add(t_relationships_description);

                                b_submit.setBounds(64, 549, 554, 40);
                                pTables.add(b_submit);

                                pTables.updateUI();
                                break;
                            case "health_records":
                                pTables.setPreferredSize(new Dimension (642,940));

                                pTables.removeAll();

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

                                JTextField t_health_record_id = new JTextField();
                                t_health_record_id.setFont(bodyFont);
                                t_health_record_id.setForeground(black);
                                t_health_record_id.setBorder(border);
                                t_health_record_id.setBounds(64, 272, 265, 40);
                                pTables.add(t_health_record_id);

                                JLabel l_health_record_vet_id = new JLabel("Vet ID");
                                l_health_record_vet_id.setFont(labelFont);
                                l_health_record_vet_id.setForeground(black);
                                l_health_record_vet_id.setBounds(353, 248, 130, 20);
                                pTables.add(l_health_record_vet_id);

                                JComboBox cb_health_record_vet_id = new JComboBox();  // falta agregar las vets con la tabla vets
                                cb_health_record_vet_id.setFont(bodyFont);
                                cb_health_record_vet_id.setForeground(black);
                                cb_health_record_vet_id.setBounds(353,272,265,40);
                                cb_health_record_vet_id.setBackground(Color.WHITE);
                                pTables.add(cb_health_record_vet_id);

                                JLabel l_health_record_dog_id = new JLabel("Dog ID");
                                l_health_record_dog_id.setFont(labelFont);
                                l_health_record_dog_id.setForeground(black);
                                l_health_record_dog_id.setBounds(64, 336, 130, 20);
                                pTables.add(l_health_record_dog_id);

                                JComboBox cb_health_record_dog_id = new JComboBox();  // falta agregar las dogs con la tabla dogs
                                cb_health_record_dog_id.setFont(bodyFont);
                                cb_health_record_dog_id.setForeground(black);
                                cb_health_record_dog_id.setBounds(64,360,554,40);
                                cb_health_record_dog_id.setBackground(Color.WHITE);
                                pTables.add(cb_health_record_dog_id);

                                JLabel l_health_record_summary = new JLabel("Summary");
                                l_health_record_summary.setFont(labelFont);
                                l_health_record_summary.setForeground(black);
                                l_health_record_summary.setBounds(64, 424, 200, 20);
                                pTables.add(l_health_record_summary);

                                JPlaceholderTextArea t_health_record_summary = new JPlaceholderTextArea("e.g. The dog was administered the vaccines");
                                t_health_record_summary.setLineWrap(true);
                                t_health_record_summary.setFont(bodyFont);
                                t_health_record_summary.setForeground(black);
                                t_health_record_summary.setBorder(border);
                                t_health_record_summary.setBounds(64, 448, 554, 139);
                                pTables.add(t_health_record_summary);

                                JLabel l_health_record_other_details = new JLabel("Details");
                                l_health_record_other_details.setFont(labelFont);
                                l_health_record_other_details.setForeground(black);
                                l_health_record_other_details.setBounds(64, 611, 100, 20);
                                pTables.add(l_health_record_other_details);

                                JPlaceholderTextArea t_health_record_other_details = new JPlaceholderTextArea("e.g. The dog is healthy");
                                t_health_record_other_details.setLineWrap(true);
                                t_health_record_other_details.setFont(bodyFont);
                                t_health_record_other_details.setForeground(black);
                                t_health_record_other_details.setBorder(border);
                                t_health_record_other_details.setBounds(64, 635, 554, 139);
                                pTables.add(t_health_record_other_details);

                                b_submit.setBounds(64, 798, 554, 40);
                                pTables.add(b_submit);

                                pTables.updateUI();
                                break;
                            case "common_problem":
                                pTables.setPreferredSize(new Dimension (642,700));

                                pTables.removeAll();

                                lTitle.setBounds(64,90,100,38);
                                pTables.add(lTitle);

                                lDescription.setBounds(64,134,430,28);
                                pTables.add(lDescription);

                                lTables.setBounds(64,186,40 ,20);
                                pTables.add(lTables);

                                cbTables.setBounds(64,210,554,40);
                                cbTables.setSelectedItem("common_problem");
                                pTables.add(cbTables);

                                JLabel l_common_problem_code = new JLabel("Problem Code");
                                l_common_problem_code.setFont(labelFont);
                                l_common_problem_code.setForeground(black);
                                l_common_problem_code.setBounds(64, 274, 130, 20);
                                pTables.add(l_common_problem_code);

                                JTextField t_common_problem_code = new JTextField();
                                t_common_problem_code.setFont(bodyFont);
                                t_common_problem_code.setForeground(black);
                                t_common_problem_code.setBorder(border);
                                t_common_problem_code.setBounds(64, 298, 554, 40);
                                pTables.add(t_common_problem_code);

                                JLabel l_common_problem_description = new JLabel("Problem Description");
                                l_common_problem_description.setFont(labelFont);
                                l_common_problem_description.setForeground(black);
                                l_common_problem_description.setBounds(64, 362, 200, 20);
                                pTables.add(l_common_problem_description);

                                JPlaceholderTextArea t_common_problem_description = new JPlaceholderTextArea("e.g. Fever: The dog has high temperature, coughing, and runny nose");
                                t_common_problem_description.setLineWrap(true);
                                t_common_problem_description.setFont(bodyFont);
                                t_common_problem_description.setForeground(black);
                                t_common_problem_description.setBorder(border);
                                t_common_problem_description.setBounds(64, 386, 554, 139);
                                pTables.add(t_common_problem_description);

                                b_submit.setBounds(64, 549, 554, 40);
                                pTables.add(b_submit);

                                pTables.updateUI();
                                break;
                            case "dog_problems":
                                pTables.setPreferredSize(new Dimension (642,860));

                                pTables.removeAll();

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

                                JComboBox t_dog_problem_code = new JComboBox(); // falta agregar las common_problems con la tabla common_problems
                                t_dog_problem_code.setFont(bodyFont);
                                t_dog_problem_code.setForeground(black);
                                t_dog_problem_code.setBounds(64, 272, 164, 40);
                                t_dog_problem_code.setBackground(Color.WHITE);
                                pTables.add(t_dog_problem_code);

                                JLabel l_dog_problem_health_record_id = new JLabel("Health Record ID");
                                l_dog_problem_health_record_id.setFont(labelFont);
                                l_dog_problem_health_record_id.setForeground(black);
                                l_dog_problem_health_record_id.setBounds(256, 248, 164, 20);
                                pTables.add(l_dog_problem_health_record_id);

                                JComboBox cb_dog_problem_health_record_id = new JComboBox();  // falta agregar las health_records con la tabla health_records
                                cb_dog_problem_health_record_id.setFont(bodyFont);
                                cb_dog_problem_health_record_id.setForeground(black);
                                cb_dog_problem_health_record_id.setBounds(256,272,164,40);
                                cb_dog_problem_health_record_id.setBackground(Color.WHITE);
                                pTables.add(cb_dog_problem_health_record_id);

                                JLabel l_dog_problem_date_of_problem = new JLabel("Date of Problem");
                                l_dog_problem_date_of_problem.setFont(labelFont);
                                l_dog_problem_date_of_problem.setForeground(black);
                                l_dog_problem_date_of_problem.setBounds(449, 248, 164, 20);
                                pTables.add(l_dog_problem_date_of_problem);

                                JDateChooser dc_dog_problem_date_of_problem = new JDateChooser("yyyy-MM-dd", "yyyy-MM-dd", '_');
                                dc_dog_problem_date_of_problem.setFont(bodyFont);
                                dc_dog_problem_date_of_problem.setForeground(black);
                                dc_dog_problem_date_of_problem.setBounds(449, 272, 165, 40);
                                pTables.add(dc_dog_problem_date_of_problem);

                                JLabel l_dog_problem_treatment = new JLabel("Treatment");
                                l_dog_problem_treatment.setFont(labelFont);
                                l_dog_problem_treatment.setForeground(black);
                                l_dog_problem_treatment.setBounds(64, 336, 200, 20);
                                pTables.add(l_dog_problem_treatment);

                                JPlaceholderTextArea t_dog_problem_treatment = new JPlaceholderTextArea("e.g. The dog was given antibiotics");
                                t_dog_problem_treatment.setLineWrap(true);
                                t_dog_problem_treatment.setFont(bodyFont);
                                t_dog_problem_treatment.setForeground(black);
                                t_dog_problem_treatment.setBorder(border);
                                t_dog_problem_treatment.setBounds(64, 360, 554, 139);
                                pTables.add(t_dog_problem_treatment);

                                JLabel l_dog_problem_other_details = new JLabel("Other Details");
                                l_dog_problem_other_details.setFont(labelFont);
                                l_dog_problem_other_details.setForeground(black);
                                l_dog_problem_other_details.setBounds(64, 523, 100, 20);
                                pTables.add(l_dog_problem_other_details);

                                JPlaceholderTextArea t_dog_problem_other_details = new JPlaceholderTextArea("e.g. The dog is healthy");
                                t_dog_problem_other_details.setLineWrap(true);
                                t_dog_problem_other_details.setFont(bodyFont);
                                t_dog_problem_other_details.setForeground(black);
                                t_dog_problem_other_details.setBorder(border);
                                t_dog_problem_other_details.setBounds(64, 547, 554, 139);
                                pTables.add(t_dog_problem_other_details);

                                b_submit.setBounds(64, 710, 554, 40);
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

                                JComboBox cb_vet_id = new JComboBox();  // falta agregar las vets con la tabla vets
                                cb_vet_id.setFont(bodyFont);
                                cb_vet_id.setForeground(black);
                                cb_vet_id.setBounds(64, 328, 265, 40);
                                cb_vet_id.setBackground(Color.WHITE);
                                pTables.add(cb_vet_id);

                                JLabel l_vet_name = new JLabel("Current Vet's Name");
                                l_vet_name.setFont(labelFont);
                                l_vet_name.setForeground(black);
                                l_vet_name.setBounds(353, 304, 160, 20);
                                pTables.add(l_vet_name);

                                JTextField t_vet_name = new JTextField();
                                t_vet_name.setFont(bodyFont);
                                t_vet_name.setForeground(black);
                                t_vet_name.setBorder(border);
                                t_vet_name.setBounds(353, 328, 265, 40);
                                t_vet_name.setEnabled(false);
                                pTables.add(t_vet_name);

                                JLabel l_vet_other_details = new JLabel("Current Details");
                                l_vet_other_details.setFont(labelFont);
                                l_vet_other_details.setForeground(black);
                                l_vet_other_details.setBounds(64, 392, 150, 20);
                                pTables.add(l_vet_other_details);

                                JTextArea t_vet_other_details = new JTextArea();
                                t_vet_other_details.setLineWrap(true);
                                t_vet_other_details.setFont(bodyFont);
                                t_vet_other_details.setForeground(black);
                                t_vet_other_details.setBorder(border);
                                t_vet_other_details.setBounds(64, 416, 554, 139);
                                t_vet_other_details.setEnabled(false);
                                pTables.add(t_vet_other_details);

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

                                JTextField t_vet_name_update = new JTextField();
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

                                JPlaceholderTextArea t_vet_other_details_update = new JPlaceholderTextArea("e.g. Specializes on surgery");
                                t_vet_other_details_update.setLineWrap(true);
                                t_vet_other_details_update.setFont(bodyFont);
                                t_vet_other_details_update.setForeground(black);
                                t_vet_other_details_update.setBorder(border);
                                t_vet_other_details_update.setBounds(64, 747, 554, 139);
                                pTables.add(t_vet_other_details_update);

                                b_submit.setBounds(62, 910, 554, 40);
                                pTables.add(b_submit);

                                pTables.updateUI();
                                break;
                            case "dogs":
                                pTables.setPreferredSize(new Dimension (642,1470));

                                pTables.removeAll();

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

                                JComboBox cb_dog_id = new JComboBox(); // falta agregar las dogs con la tabla dogs
                                cb_dog_id.setFont(bodyFont);
                                cb_dog_id.setForeground(black);
                                cb_dog_id.setBounds(64, 328, 265, 40);
                                cb_dog_id.setBackground(Color.WHITE);
                                pTables.add(cb_dog_id);

                                JLabel l_dog_dogs_name = new JLabel("Current Dog's Name");
                                l_dog_dogs_name.setFont(labelFont);
                                l_dog_dogs_name.setForeground(black);
                                l_dog_dogs_name.setBounds(353, 304, 265, 20);
                                pTables.add(l_dog_dogs_name);

                                JTextField t_dog_dogs_name = new JTextField();
                                t_dog_dogs_name.setFont(bodyFont);
                                t_dog_dogs_name.setForeground(black);
                                t_dog_dogs_name.setBorder(border);
                                t_dog_dogs_name.setBounds(353, 328, 265, 40);
                                t_dog_dogs_name.setEnabled(false);
                                pTables.add(t_dog_dogs_name);

                                JLabel l_dog_place_of_birth = new JLabel("Current Place of Birth");
                                l_dog_place_of_birth.setFont(labelFont);
                                l_dog_place_of_birth.setForeground(black);
                                l_dog_place_of_birth.setBounds(64, 392, 265, 20);
                                pTables.add(l_dog_place_of_birth);

                                JTextField t_dog_place_of_birth = new JTextField();
                                t_dog_place_of_birth.setFont(bodyFont);
                                t_dog_place_of_birth.setForeground(black);
                                t_dog_place_of_birth.setBorder(border);
                                t_dog_place_of_birth.setBounds(64, 416, 265, 40);
                                t_dog_place_of_birth.setEnabled(false);
                                pTables.add(t_dog_place_of_birth);

                                JLabel l_dog_date_of_birth = new JLabel("Current Date of Birth");
                                l_dog_date_of_birth.setFont(labelFont);
                                l_dog_date_of_birth.setForeground(black);
                                l_dog_date_of_birth.setBounds(353, 392, 265, 20);
                                pTables.add(l_dog_date_of_birth);

                                JTextField dc_dog_date_of_birth = new JTextField();
                                dc_dog_date_of_birth.setFont(bodyFont);
                                dc_dog_date_of_birth.setForeground(black);
                                dc_dog_date_of_birth.setBorder(border);
                                dc_dog_date_of_birth.setBounds(353, 416, 265, 40);
                                dc_dog_date_of_birth.setEnabled(false);
                                pTables.add(dc_dog_date_of_birth);

                                JLabel l_dog_born_in_litter = new JLabel("Current Born in Litter");
                                l_dog_born_in_litter.setFont(labelFont);
                                l_dog_born_in_litter.setForeground(black);
                                l_dog_born_in_litter.setBounds(64, 480, 265, 20);
                                pTables.add(l_dog_born_in_litter);

                                JTextField t_dog_born_in_litter = new JTextField();
                                t_dog_born_in_litter.setFont(bodyFont);
                                t_dog_born_in_litter.setForeground(black);
                                t_dog_born_in_litter.setBorder(border);
                                t_dog_born_in_litter.setBounds(64,504,554,40);
                                t_dog_born_in_litter.setEnabled(false);
                                pTables.add(t_dog_born_in_litter);

                                JLabel l_dog_gender_mf = new JLabel("Current Dog's Gender");
                                l_dog_gender_mf.setFont(labelFont);
                                l_dog_gender_mf.setForeground(black);
                                l_dog_gender_mf.setBounds(64, 566, 265, 20);
                                pTables.add(l_dog_gender_mf);

                                ButtonGroup bg_dog_group = new ButtonGroup();

                                JCheckBox c_dog_female = new JCheckBox();
                                c_dog_female.setFont(bodyFont);
                                c_dog_female.setForeground(black);
                                c_dog_female.setBounds(64, 592, 90, 20);
                                c_dog_female.setText("Female");
                                c_dog_female.setBackground(null);
                                c_dog_female.setEnabled(false);
                                bg_dog_group.add(c_dog_female);
                                pTables.add(c_dog_female);

                                JCheckBox c_dog_male = new JCheckBox();
                                c_dog_male.setFont(bodyFont);
                                c_dog_male.setForeground(black);
                                c_dog_male.setBounds(211, 592, 80, 20);
                                c_dog_male.setText("Male");
                                c_dog_male.setBackground(null);
                                c_dog_male.setEnabled(false);
                                bg_dog_group.add(c_dog_male);
                                pTables.add(c_dog_male);

                                JLabel l_dog_other_details = new JLabel("Current Details");
                                l_dog_other_details.setFont(labelFont);
                                l_dog_other_details.setForeground(black);
                                l_dog_other_details.setBounds(64, 640, 265, 20);
                                pTables.add(l_dog_other_details);

                                JTextArea t_dog_other_details = new JTextArea();
                                t_dog_other_details.setLineWrap(true);
                                t_dog_other_details.setFont(bodyFont);
                                t_dog_other_details.setForeground(black);
                                t_dog_other_details.setBorder(border);
                                t_dog_other_details.setBounds(64, 664, 554, 139);
                                t_dog_other_details.setEnabled(false);
                                pTables.add(t_dog_other_details);

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

                                JTextField t_dog_name_update = new JTextField();
                                t_dog_name_update.setFont(bodyFont);
                                t_dog_name_update.setForeground(black);
                                t_dog_name_update.setBorder(border);
                                t_dog_name_update.setBounds(64, 907, 265, 40);
                                pTables.add(t_dog_name_update);

                                JLabel l_dog_place_of_birth_update = new JLabel("New Place of Birth");
                                l_dog_place_of_birth_update.setFont(labelFont);
                                l_dog_place_of_birth_update.setForeground(black);
                                l_dog_place_of_birth_update.setBounds(353, 883, 200, 20);
                                pTables.add(l_dog_place_of_birth_update);

                                JTextField t_dog_place_of_birth_update = new JTextField();
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

                                JDateChooser dc_dog_date_of_birth_update = new JDateChooser("yyyy-MM-dd", "yyyy-MM-dd", '_');
                                dc_dog_date_of_birth_update.setFont(bodyFont);
                                dc_dog_date_of_birth_update.setForeground(black);
                                dc_dog_date_of_birth_update.setBounds(64, 995, 265, 40);
                                pTables.add(dc_dog_date_of_birth_update);

                                JLabel l_dog_born_in_litter_update = new JLabel("New Born in Litter");
                                l_dog_born_in_litter_update.setFont(labelFont);
                                l_dog_born_in_litter_update.setForeground(black);
                                l_dog_born_in_litter_update.setBounds(353, 971, 200, 20);
                                pTables.add(l_dog_born_in_litter_update);

                                JComboBox cb_dog_born_in_litter_update = new JComboBox();  // falta agregar las litters con la tabla litters
                                cb_dog_born_in_litter_update.setFont(bodyFont);
                                cb_dog_born_in_litter_update.setForeground(black);
                                cb_dog_born_in_litter_update.setBounds(353,995,265,40);
                                cb_dog_born_in_litter_update.setBackground(Color.WHITE);
                                pTables.add(cb_dog_born_in_litter_update);

                                JLabel l_dog_gender_mf_update = new JLabel("New Dog's Gender");
                                l_dog_gender_mf_update.setFont(labelFont);
                                l_dog_gender_mf_update.setForeground(black);
                                l_dog_gender_mf_update.setBounds(64, 1059, 130, 20);
                                pTables.add(l_dog_gender_mf_update);

                                ButtonGroup bg_dog_group_update = new ButtonGroup();

                                JCheckBox c_dog_female_update = new JCheckBox();
                                c_dog_female_update.setFont(bodyFont);
                                c_dog_female_update.setForeground(black);
                                c_dog_female_update.setBounds(64,1083,80,20);
                                c_dog_female_update.setText("Female");
                                c_dog_female_update.setBackground(null);
                                bg_dog_group_update.add(c_dog_female_update);
                                pTables.add(c_dog_female_update);

                                JCheckBox c_dog_male_update = new JCheckBox();
                                c_dog_male_update.setFont(bodyFont);
                                c_dog_male_update.setForeground(black);
                                c_dog_male_update.setBounds(211, 1083, 80, 20);
                                c_dog_male_update.setText("Male");
                                c_dog_male_update.setBackground(null);
                                bg_dog_group_update.add(c_dog_male_update);
                                pTables.add(c_dog_male_update);

                                JLabel l_dog_other_details_update = new JLabel("New Details");
                                l_dog_other_details_update.setFont(labelFont);
                                l_dog_other_details_update.setForeground(black);
                                l_dog_other_details_update.setBounds(64, 1127, 95, 20);
                                pTables.add(l_dog_other_details_update);

                                JPlaceholderTextArea t_dog_other_details_update = new JPlaceholderTextArea("e.g. Is very playful");
                                t_dog_other_details_update.setLineWrap(true);
                                t_dog_other_details_update.setFont(bodyFont);
                                t_dog_other_details_update.setForeground(black);
                                t_dog_other_details_update.setBorder(border);
                                t_dog_other_details_update.setBounds(64, 1151, 554, 139);
                                t_dog_other_details_update.setEnabled(false);
                                pTables.add(t_dog_other_details_update);

                                b_submit.setBounds(64, 1314, 554, 40);
                                pTables.add(b_submit);

                                pTables.updateUI();
                                break;
                            case "litters":
                                pTables.setPreferredSize(new Dimension (642,1320));

                                pTables.removeAll();

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

                                JComboBox cb_litter_id = new JComboBox();
                                cb_litter_id.setFont(bodyFont);
                                cb_litter_id.setForeground(black);
                                cb_litter_id.setBounds(64, 328, 554, 40);
                                cb_litter_id.setBackground(Color.WHITE);
                                pTables.add(cb_litter_id);

                                JLabel l_litter_sire_dog_id = new JLabel("Current Sire Dog ID");
                                l_litter_sire_dog_id.setFont(labelFont);
                                l_litter_sire_dog_id.setForeground(black);
                                l_litter_sire_dog_id.setBounds(64, 392, 265, 20);
                                pTables.add(l_litter_sire_dog_id);

                                JTextField t_litter_sire_dog_id = new JTextField();
                                t_litter_sire_dog_id.setFont(bodyFont);
                                t_litter_sire_dog_id.setForeground(black);
                                t_litter_sire_dog_id.setBorder(border);
                                t_litter_sire_dog_id.setBounds(64,415,265,40);
                                t_litter_sire_dog_id.setEnabled(false);
                                pTables.add(t_litter_sire_dog_id);

                                JLabel l_litter_dam_dog_id = new JLabel("Current Dam Dog ID");
                                l_litter_dam_dog_id.setFont(labelFont);
                                l_litter_dam_dog_id.setForeground(black);
                                l_litter_dam_dog_id.setBounds(353, 392, 265, 20);
                                pTables.add(l_litter_dam_dog_id);

                                JTextField t_litter_dam_dog_id = new JTextField();
                                t_litter_dam_dog_id.setFont(bodyFont);
                                t_litter_dam_dog_id.setForeground(black);
                                t_litter_dam_dog_id.setBorder(border);
                                t_litter_dam_dog_id.setBounds(353,415,265,40);
                                t_litter_dam_dog_id.setEnabled(false);
                                pTables.add(t_litter_dam_dog_id);

                                JLabel l_litter_place_of_birth = new JLabel("Current Litter's Place of Birth");
                                l_litter_place_of_birth.setFont(labelFont);
                                l_litter_place_of_birth.setForeground(black);
                                l_litter_place_of_birth.setBounds(64, 479, 265, 20);
                                pTables.add(l_litter_place_of_birth);

                                JTextField t_litter_place_of_birth = new JTextField();
                                t_litter_place_of_birth.setFont(bodyFont);
                                t_litter_place_of_birth.setForeground(black);
                                t_litter_place_of_birth.setBorder(border);
                                t_litter_place_of_birth.setBounds(64, 503, 265, 40);
                                t_litter_place_of_birth.setEnabled(false);
                                pTables.add(t_litter_place_of_birth);

                                JLabel l_litter_date_of_birth = new JLabel("Current Litter's Date of Birth");
                                l_litter_date_of_birth.setFont(labelFont);
                                l_litter_date_of_birth.setForeground(black);
                                l_litter_date_of_birth.setBounds(353, 479, 265, 20);
                                pTables.add(l_litter_date_of_birth);

                                JTextField t_litter_date_of_birth = new JTextField();
                                t_litter_date_of_birth.setFont(bodyFont);
                                t_litter_date_of_birth.setForeground(black);
                                t_litter_date_of_birth.setBorder(border);
                                t_litter_date_of_birth.setBounds(353, 503, 265, 40);
                                t_litter_date_of_birth.setEnabled(false);
                                pTables.add(t_litter_date_of_birth);

                                JLabel l_litter_other_details = new JLabel("Current Details");
                                l_litter_other_details.setFont(labelFont);
                                l_litter_other_details.setForeground(black);
                                l_litter_other_details.setBounds(64, 567, 265, 20);
                                pTables.add(l_litter_other_details);

                                JTextArea t_litter_other_details = new JTextArea();
                                t_litter_other_details.setLineWrap(true);
                                t_litter_other_details.setFont(bodyFont);
                                t_litter_other_details.setForeground(black);
                                t_litter_other_details.setBorder(border);
                                t_litter_other_details.setBounds(64, 591, 554, 139);
                                t_litter_other_details.setEnabled(false);
                                pTables.add(t_litter_other_details);

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

                                JComboBox cb_litter_sire_dog_id_update = new JComboBox();  // falta agregar las dogs con la tabla dogs
                                cb_litter_sire_dog_id_update.setFont(bodyFont);
                                cb_litter_sire_dog_id_update.setForeground(black);
                                cb_litter_sire_dog_id_update.setBounds(64,834,265,40);
                                cb_litter_sire_dog_id_update.setBackground(Color.WHITE);
                                pTables.add(cb_litter_sire_dog_id_update);

                                JLabel l_litter_dam_dog_id_update = new JLabel("New Dam Dog ID");
                                l_litter_dam_dog_id_update.setFont(labelFont);
                                l_litter_dam_dog_id_update.setForeground(black);
                                l_litter_dam_dog_id_update.setBounds(353, 810, 265, 20);
                                pTables.add(l_litter_dam_dog_id_update);

                                JComboBox cb_litter_dam_dog_id_update = new JComboBox();  // falta agregar las dogs con la tabla dogs
                                cb_litter_dam_dog_id_update.setFont(bodyFont);
                                cb_litter_dam_dog_id_update.setForeground(black);
                                cb_litter_dam_dog_id_update.setBounds(353,834,265,40);
                                cb_litter_dam_dog_id_update.setBackground(Color.WHITE);
                                pTables.add(cb_litter_dam_dog_id_update);

                                JLabel l_litter_place_of_birth_update = new JLabel("New Place of Birth");
                                l_litter_place_of_birth_update.setFont(labelFont);
                                l_litter_place_of_birth_update.setForeground(black);
                                l_litter_place_of_birth_update.setBounds(64, 890, 265, 20);
                                pTables.add(l_litter_place_of_birth_update);

                                JTextField t_litter_place_of_birth_update = new JTextField();
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

                                JDateChooser t_litter_date_of_birth_update = new JDateChooser("yyyy-MM-dd", "yyyy-MM-dd", '_');
                                t_litter_date_of_birth_update.setFont(bodyFont);
                                t_litter_date_of_birth_update.setForeground(black);
                                t_litter_date_of_birth_update.setBounds(353,914,265,40);
                                t_litter_date_of_birth_update.setBackground(Color.WHITE);
                                pTables.add(t_litter_date_of_birth_update);

                                JLabel l_litter_other_details_update = new JLabel("New Details");
                                l_litter_other_details_update.setFont(labelFont);
                                l_litter_other_details_update.setForeground(black);
                                l_litter_other_details_update.setBounds(64, 978, 100, 20);
                                pTables.add(l_litter_other_details_update);

                                JPlaceholderTextArea t_litter_other_details_update = new JPlaceholderTextArea("e.g. All puppies are healthy, Five puppies in total");
                                t_litter_other_details_update.setLineWrap(true);
                                t_litter_other_details_update.setFont(bodyFont);
                                t_litter_other_details_update.setForeground(black);
                                t_litter_other_details_update.setBorder(border);
                                t_litter_other_details_update.setBounds(64, 1000, 554, 139);
                                pTables.add(t_litter_other_details_update);

                                b_submit.setBounds(64, 1164, 554, 40);
                                pTables.add(b_submit);

                                pTables.updateUI();
                                break;
                            case "relationships":
                                pTables.setPreferredSize(new Dimension (642,1250));

                                pTables.removeAll();

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

                                JComboBox cb_relationship_id = new JComboBox();  // falta agregar las relationships con la tabla relationships
                                cb_relationship_id.setFont(bodyFont);
                                cb_relationship_id.setForeground(black);
                                cb_relationship_id.setBounds(64,328,265,40);
                                cb_relationship_id.setBackground(Color.WHITE);
                                pTables.add(cb_relationship_id);

                                JLabel l_relationship_code = new JLabel("Current Relationship Code");
                                l_relationship_code.setFont(labelFont);
                                l_relationship_code.setForeground(black);
                                l_relationship_code.setBounds(353, 304, 265, 20);
                                pTables.add(l_relationship_code);

                                JTextField t_relationship_code = new JTextField();
                                t_relationship_code.setFont(bodyFont);
                                t_relationship_code.setForeground(black);
                                t_relationship_code.setBorder(border);
                                t_relationship_code.setBounds(353, 328, 265, 40);
                                t_relationship_code.setEnabled(false);
                                pTables.add(t_relationship_code);

                                JLabel l_relationship_sire_dog_id = new JLabel("Current Dog 1 ID");
                                l_relationship_sire_dog_id.setFont(labelFont);
                                l_relationship_sire_dog_id.setForeground(black);
                                l_relationship_sire_dog_id.setBounds(64, 392, 265, 20);
                                pTables.add(l_relationship_sire_dog_id);

                                JTextField t_relationship_sire_dog_id = new JTextField();
                                t_relationship_sire_dog_id.setFont(bodyFont);
                                t_relationship_sire_dog_id.setForeground(black);
                                t_relationship_sire_dog_id.setBorder(border);
                                t_relationship_sire_dog_id.setBounds(64,416,265,40);
                                t_relationship_sire_dog_id.setEnabled(false);
                                pTables.add(t_relationship_sire_dog_id);

                                JLabel l_relationship_dam_dog_id = new JLabel("Current Dog 2 ID");
                                l_relationship_dam_dog_id.setFont(labelFont);
                                l_relationship_dam_dog_id.setForeground(black);
                                l_relationship_dam_dog_id.setBounds(353, 392, 265, 20);
                                pTables.add(l_relationship_dam_dog_id);

                                JTextField t_relationship_dam_dog_id = new JTextField();
                                t_relationship_dam_dog_id.setFont(bodyFont);
                                t_relationship_dam_dog_id.setForeground(black);
                                t_relationship_dam_dog_id.setBorder(border);
                                t_relationship_dam_dog_id.setBounds(353,416,265,40);
                                t_relationship_dam_dog_id.setEnabled(false);
                                pTables.add(t_relationship_dam_dog_id);

                                JLabel l_relationship_other_details = new JLabel("Current Details");
                                l_relationship_other_details.setFont(labelFont);
                                l_relationship_other_details.setForeground(black);
                                l_relationship_other_details.setBounds(64, 480, 265, 20);
                                pTables.add(l_relationship_other_details);

                                JTextArea t_relationship_other_details = new JTextArea();
                                t_relationship_other_details.setLineWrap(true);
                                t_relationship_other_details.setFont(bodyFont);
                                t_relationship_other_details.setForeground(black);
                                t_relationship_other_details.setBorder(border);
                                t_relationship_other_details.setBounds(64, 504, 554, 139);
                                t_relationship_other_details.setEnabled(false);
                                pTables.add(t_relationship_other_details);

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

                                JComboBox t_relationship_code_update = new JComboBox();  // falta agregar las relationship_types con la tabla relationship_types
                                t_relationship_code_update.setFont(bodyFont);
                                t_relationship_code_update.setForeground(black);
                                t_relationship_code_update.setBounds(64,747,554,40);
                                t_relationship_code_update.setBackground(Color.WHITE);
                                pTables.add(t_relationship_code_update);

                                JLabel l_relationship_sire_dog_id_update = new JLabel("New Dog 1 ID");
                                l_relationship_sire_dog_id_update.setFont(labelFont);
                                l_relationship_sire_dog_id_update.setForeground(black);
                                l_relationship_sire_dog_id_update.setBounds(64, 803, 265, 20);
                                pTables.add(l_relationship_sire_dog_id_update);

                                JComboBox cb_relationship_sire_dog_id_update = new JComboBox();  // falta agregar las dogs con la tabla dogs
                                cb_relationship_sire_dog_id_update.setFont(bodyFont);
                                cb_relationship_sire_dog_id_update.setForeground(black);
                                cb_relationship_sire_dog_id_update.setBounds(64,827,265,40);
                                cb_relationship_sire_dog_id_update.setBackground(Color.WHITE);
                                pTables.add(cb_relationship_sire_dog_id_update);

                                JLabel l_relationship_dam_dog_id_update = new JLabel("New Dog 2 ID");
                                l_relationship_dam_dog_id_update.setFont(labelFont);
                                l_relationship_dam_dog_id_update.setForeground(black);
                                l_relationship_dam_dog_id_update.setBounds(353, 803, 265, 20);
                                pTables.add(l_relationship_dam_dog_id_update);

                                JComboBox cb_relationship_dam_dog_id_update = new JComboBox();  // falta agregar las dogs con la tabla dogs
                                cb_relationship_dam_dog_id_update.setFont(bodyFont);
                                cb_relationship_dam_dog_id_update.setForeground(black);
                                cb_relationship_dam_dog_id_update.setBounds(353,827,265,40);
                                cb_relationship_dam_dog_id_update.setBackground(Color.WHITE);
                                pTables.add(cb_relationship_dam_dog_id_update);

                                JLabel l_relationship_other_details_update = new JLabel("New Details");
                                l_relationship_other_details_update.setFont(labelFont);
                                l_relationship_other_details_update.setForeground(black);
                                l_relationship_other_details_update.setBounds(64, 881, 265, 20);
                                pTables.add(l_relationship_other_details_update);

                                JPlaceholderTextArea t_relationship_other_details_update = new JPlaceholderTextArea("e.g. The dogs are siblings");
                                t_relationship_other_details_update.setLineWrap(true);
                                t_relationship_other_details_update.setFont(bodyFont);
                                t_relationship_other_details_update.setForeground(black);
                                t_relationship_other_details_update.setBorder(border);
                                t_relationship_other_details_update.setBounds(64,905,554,139);
                                pTables.add(t_relationship_other_details_update);

                                b_submit.setBounds(64, 1072, 554, 40);
                                pTables.add(b_submit);

                                pTables.updateUI();
                                break;
                            case "relationship_types":
                                pTables.setPreferredSize(new Dimension (642,970));

                                pTables.removeAll();

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

                                JComboBox cb_relationship_type_id = new JComboBox();  // falta agregar las relationship_types con la tabla relationship_types
                                cb_relationship_type_id.setFont(bodyFont);
                                cb_relationship_type_id.setForeground(black);
                                cb_relationship_type_id.setBounds(64,328,554,40);
                                cb_relationship_type_id.setBackground(Color.WHITE);
                                pTables.add(cb_relationship_type_id);

                                JLabel l_relationship_details = new JLabel("Current Details");
                                l_relationship_details.setFont(labelFont);
                                l_relationship_details.setForeground(black);
                                l_relationship_details.setBounds(64, 392, 265, 20);
                                pTables.add(l_relationship_details);

                                JTextArea t_relationship_details = new JTextArea();
                                t_relationship_details.setLineWrap(true);
                                t_relationship_details.setFont(bodyFont);
                                t_relationship_details.setForeground(black);
                                t_relationship_details.setBorder(border);
                                t_relationship_details.setBounds(64, 416, 554, 139);
                                t_relationship_details.setEnabled(false);
                                pTables.add(t_relationship_details);

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

                                JPlaceholderTextArea t_relationship_details_update = new JPlaceholderTextArea("e.g. Siblings");
                                t_relationship_details_update.setLineWrap(true);
                                t_relationship_details_update.setFont(bodyFont);
                                t_relationship_details_update.setForeground(black);
                                t_relationship_details_update.setBorder(border);
                                t_relationship_details_update.setBounds(64,659,554,139);
                                pTables.add(t_relationship_details_update);

                                b_submit.setBounds(64, 822, 554, 40);
                                pTables.add(b_submit);

                                pTables.updateUI();
                                break;
                            case "health_records":
                                pTables.setPreferredSize(new Dimension (642,1470));

                                pTables.removeAll();

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

                                JComboBox cb_health_record_id = new JComboBox();  // falta agregar las health_records con la tabla health_records
                                cb_health_record_id.setFont(bodyFont);
                                cb_health_record_id.setForeground(black);
                                cb_health_record_id.setBounds(64,328,265,40);
                                cb_health_record_id.setBackground(Color.WHITE);
                                pTables.add(cb_health_record_id);

                                JLabel l_health_record_vet_id = new JLabel("Current Vet ID");
                                l_health_record_vet_id.setFont(labelFont);
                                l_health_record_vet_id.setForeground(black);
                                l_health_record_vet_id.setBounds(353, 304, 265, 20);
                                pTables.add(l_health_record_vet_id);

                                JTextField t_health_record_vet_id = new JTextField();
                                t_health_record_vet_id.setFont(bodyFont);
                                t_health_record_vet_id.setForeground(black);
                                t_health_record_vet_id.setBorder(border);
                                t_health_record_vet_id.setBounds(353,328,265,40);
                                t_health_record_vet_id.setEnabled(false);
                                pTables.add(t_health_record_vet_id);

                                JLabel l_health_record_dog_id = new JLabel("Current Dog ID");
                                l_health_record_dog_id.setFont(labelFont);
                                l_health_record_dog_id.setForeground(black);
                                l_health_record_dog_id.setBounds(64, 392, 265, 20);
                                pTables.add(l_health_record_dog_id);

                                JTextField t_health_record_dog_id = new JTextField();
                                t_health_record_dog_id.setFont(bodyFont);
                                t_health_record_dog_id.setForeground(black);
                                t_health_record_dog_id.setBorder(border);
                                t_health_record_dog_id.setBounds(64,416,554,40);
                                t_health_record_dog_id.setEnabled(false);
                                pTables.add(t_health_record_dog_id);

                                JLabel l_health_record_summary = new JLabel("Current Summary");
                                l_health_record_summary.setFont(labelFont);
                                l_health_record_summary.setForeground(black);
                                l_health_record_summary.setBounds(64, 480, 265, 20);
                                pTables.add(l_health_record_summary);

                                JTextArea t_health_record_summary = new JTextArea();
                                t_health_record_summary.setLineWrap(true);
                                t_health_record_summary.setFont(bodyFont);
                                t_health_record_summary.setForeground(black);
                                t_health_record_summary.setBorder(border);
                                t_health_record_summary.setBounds(64, 504, 554, 139);
                                t_health_record_summary.setEnabled(false);
                                pTables.add(t_health_record_summary);

                                JLabel l_health_record_details = new JLabel("Current Details");
                                l_health_record_details.setFont(labelFont);
                                l_health_record_details.setForeground(black);
                                l_health_record_details.setBounds(64, 658, 265, 20);
                                pTables.add(l_health_record_details);

                                JTextArea t_health_record_details = new JTextArea();
                                t_health_record_details.setLineWrap(true);
                                t_health_record_details.setFont(bodyFont);
                                t_health_record_details.setForeground(black);
                                t_health_record_details.setBorder(border);
                                t_health_record_details.setBounds(64, 680, 554, 139);
                                t_health_record_details.setEnabled(false);
                                pTables.add(t_health_record_details);

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

                                JComboBox cb_health_record_vet_id_update = new JComboBox();  // falta agregar las vets con la tabla vets
                                cb_health_record_vet_id_update.setFont(bodyFont);
                                cb_health_record_vet_id_update.setForeground(black);
                                cb_health_record_vet_id_update.setBounds(64,922,265,40);
                                cb_health_record_vet_id_update.setBackground(Color.WHITE);
                                pTables.add(cb_health_record_vet_id_update);

                                JLabel l_health_record_dog_id_update = new JLabel("New Dog ID");
                                l_health_record_dog_id_update.setFont(labelFont);
                                l_health_record_dog_id_update.setForeground(black);
                                l_health_record_dog_id_update.setBounds(353, 898, 265, 20);
                                pTables.add(l_health_record_dog_id_update);

                                JComboBox cb_health_record_dog_id_update = new JComboBox();  // falta agregar las dogs con la tabla dogs
                                cb_health_record_dog_id_update.setFont(bodyFont);
                                cb_health_record_dog_id_update.setForeground(black);
                                cb_health_record_dog_id_update.setBounds(353,922,265,40);
                                cb_health_record_dog_id_update.setBackground(Color.WHITE);
                                pTables.add(cb_health_record_dog_id_update);

                                JLabel l_health_record_summary_update = new JLabel("New Summary");
                                l_health_record_summary_update.setFont(labelFont);
                                l_health_record_summary_update.setForeground(black);
                                l_health_record_summary_update.setBounds(64, 978, 265, 20);
                                pTables.add(l_health_record_summary_update);

                                JPlaceholderTextArea t_health_record_summary_update = new JPlaceholderTextArea("e.g. The was administered the vaccines");
                                t_health_record_summary_update.setLineWrap(true);
                                t_health_record_summary_update.setFont(bodyFont);
                                t_health_record_summary_update.setForeground(black);
                                t_health_record_summary_update.setBorder(border);
                                t_health_record_summary_update.setBounds(64,1002,554,139);
                                pTables.add(t_health_record_summary_update);

                                JLabel l_health_record_details_update = new JLabel("New Details");
                                l_health_record_details_update.setFont(labelFont);
                                l_health_record_details_update.setForeground(black);
                                l_health_record_details_update.setBounds(64, 1148, 265, 20);
                                pTables.add(l_health_record_details_update);

                                JPlaceholderTextArea t_health_record_details_update = new JPlaceholderTextArea("e.g. The dog is healthy");
                                t_health_record_details_update.setLineWrap(true);
                                t_health_record_details_update.setFont(bodyFont);
                                t_health_record_details_update.setForeground(black);
                                t_health_record_details_update.setBorder(border);
                                t_health_record_details_update.setBounds(64,1172,554,139);
                                pTables.add(t_health_record_details_update);

                                b_submit.setBounds(64, 1336, 554, 40);
                                pTables.add(b_submit);

                                pTables.updateUI();
                                break;
                            case "common_problem":
                                pTables.setPreferredSize(new Dimension (642,960));

                                pTables.removeAll();

                                lTitle.setBounds(64,64,265,38);
                                pTables.add(lTitle);

                                lDescription.setBounds(64,108,554,28);
                                pTables.add(lDescription);

                                lTables.setBounds(64,160,40 ,20);
                                pTables.add(lTables);

                                cbTables.setBounds(64,184,554,40);
                                cbTables.setSelectedItem("common_problem");
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

                                JComboBox cb_common_problem_code = new JComboBox();  // falta agregar las common_problems con la tabla common_problems
                                cb_common_problem_code.setFont(bodyFont);
                                cb_common_problem_code.setForeground(black);
                                cb_common_problem_code.setBounds(64,328,554,40);
                                cb_common_problem_code.setBackground(Color.WHITE);
                                pTables.add(cb_common_problem_code);

                                JLabel l_common_problem_description = new JLabel("Current Description");
                                l_common_problem_description.setFont(labelFont);
                                l_common_problem_description.setForeground(black);
                                l_common_problem_description.setBounds(64, 392, 265, 20);
                                pTables.add(l_common_problem_description);

                                JTextArea t_common_problem_description = new JTextArea();
                                t_common_problem_description.setLineWrap(true);
                                t_common_problem_description.setFont(bodyFont);
                                t_common_problem_description.setForeground(black);
                                t_common_problem_description.setBorder(border);
                                t_common_problem_description.setBounds(64, 416, 554, 139);
                                t_common_problem_description.setEnabled(false);
                                pTables.add(t_common_problem_description);

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

                                JPlaceholderTextArea t_common_problem_description_update = new JPlaceholderTextArea("e.g. Fever: The dog has high temperature, coughing, and runny nose");
                                t_common_problem_description_update.setLineWrap(true);
                                t_common_problem_description_update.setFont(bodyFont);
                                t_common_problem_description_update.setForeground(black);
                                t_common_problem_description_update.setBorder(border);
                                t_common_problem_description_update.setBounds(64,659,554,139);
                                pTables.add(t_common_problem_description_update);

                                b_submit.setBounds(64, 822, 554, 40);
                                pTables.add(b_submit);

                                pTables.updateUI();
                                break;
                            case "dog_problems":
                                pTables.setPreferredSize(new Dimension (642,1400));

                                pTables.removeAll();

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

                                JComboBox cb_dog_problem_problem_code = new JComboBox();  // falta agregar las common_problems con la tabla common_problems
                                cb_dog_problem_problem_code.setFont(bodyFont);
                                cb_dog_problem_problem_code.setForeground(black);
                                cb_dog_problem_problem_code.setBounds(64,328,265,40);
                                cb_dog_problem_problem_code.setBackground(Color.WHITE);
                                pTables.add(cb_dog_problem_problem_code);

                                JLabel l_dog_problem_health_record_id = new JLabel("Current Health Record ID");
                                l_dog_problem_health_record_id.setFont(labelFont);
                                l_dog_problem_health_record_id.setForeground(black);
                                l_dog_problem_health_record_id.setBounds(353, 304, 265, 20);
                                pTables.add(l_dog_problem_health_record_id);

                                JTextField t_dog_problem_health_record_id = new JTextField();
                                t_dog_problem_health_record_id.setFont(bodyFont);
                                t_dog_problem_health_record_id.setForeground(black);
                                t_dog_problem_health_record_id.setBorder(border);
                                t_dog_problem_health_record_id.setBounds(353,328,265,40);
                                t_dog_problem_health_record_id.setEnabled(false);
                                pTables.add(t_dog_problem_health_record_id);

                                JLabel l_dog_problem_treatment = new JLabel("Current Treatment");
                                l_dog_problem_treatment.setFont(labelFont);
                                l_dog_problem_treatment.setForeground(black);
                                l_dog_problem_treatment.setBounds(64, 392, 265, 20);
                                pTables.add(l_dog_problem_treatment);

                                JTextArea t_dog_problem_treatment = new JTextArea();
                                t_dog_problem_treatment.setLineWrap(true);
                                t_dog_problem_treatment.setFont(bodyFont);
                                t_dog_problem_treatment.setForeground(black);
                                t_dog_problem_treatment.setBorder(border);
                                t_dog_problem_treatment.setBounds(64, 416, 554, 139);
                                t_dog_problem_treatment.setEnabled(false);
                                pTables.add(t_dog_problem_treatment);

                                JLabel l_dog_problem_details = new JLabel("Current Details");
                                l_dog_problem_details.setFont(labelFont);
                                l_dog_problem_details.setForeground(black);
                                l_dog_problem_details.setBounds(64, 568, 265, 20);
                                pTables.add(l_dog_problem_details);

                                JTextArea t_dog_problem_details = new JTextArea();
                                t_dog_problem_details.setLineWrap(true);
                                t_dog_problem_details.setFont(bodyFont);
                                t_dog_problem_details.setForeground(black);
                                t_dog_problem_details.setBorder(border);
                                t_dog_problem_details.setBounds(64, 592, 554, 139);
                                t_dog_problem_details.setEnabled(false);
                                pTables.add(t_dog_problem_details);

                                JLabel l_dog_problem_update = new JLabel("New Information");
                                l_dog_problem_update.setFont(subtitleFont);
                                l_dog_problem_update.setForeground(black);
                                l_dog_problem_update.setBounds(64, 754, 250, 32);
                                pTables.add(l_dog_problem_update);

                                JLabel l_dog_problem_health_record_id_update = new JLabel("New Health Record ID");
                                l_dog_problem_health_record_id_update.setFont(labelFont);
                                l_dog_problem_health_record_id_update.setForeground(black);
                                l_dog_problem_health_record_id_update.setBounds(64, 810, 265, 20);
                                pTables.add(l_dog_problem_health_record_id_update);

                                JComboBox cb_dog_problem_health_record_id_update = new JComboBox();  // falta agregar las health_records con la tabla health_records
                                cb_dog_problem_health_record_id_update.setFont(bodyFont);
                                cb_dog_problem_health_record_id_update.setForeground(black);
                                cb_dog_problem_health_record_id_update.setBounds(64,834,554,40);
                                cb_dog_problem_health_record_id_update.setBackground(Color.WHITE);
                                pTables.add(cb_dog_problem_health_record_id_update);

                                JLabel l_dog_problem_treatment_update = new JLabel("New Treatment");
                                l_dog_problem_treatment_update.setFont(labelFont);
                                l_dog_problem_treatment_update.setForeground(black);
                                l_dog_problem_treatment_update.setBounds(64, 890, 265, 20);
                                pTables.add(l_dog_problem_treatment_update);

                                JPlaceholderTextArea t_dog_problem_treatment_update = new JPlaceholderTextArea("e.g. The dog was given antibiotics");
                                t_dog_problem_treatment_update.setLineWrap(true);
                                t_dog_problem_treatment_update.setFont(bodyFont);
                                t_dog_problem_treatment_update.setForeground(black);
                                t_dog_problem_treatment_update.setBorder(border);
                                t_dog_problem_treatment_update.setBounds(64,914,554,139);
                                pTables.add(t_dog_problem_treatment_update);

                                JLabel l_dog_problem_details_update = new JLabel("New Details");
                                l_dog_problem_details_update.setFont(labelFont);
                                l_dog_problem_details_update.setForeground(black);
                                l_dog_problem_details_update.setBounds(64, 1060, 265, 20);
                                pTables.add(l_dog_problem_details_update);

                                JPlaceholderTextArea t_dog_problem_details_update = new JPlaceholderTextArea("e.g. The dog is healthy");
                                t_dog_problem_details_update.setLineWrap(true);
                                t_dog_problem_details_update.setFont(bodyFont);
                                t_dog_problem_details_update.setForeground(black);
                                t_dog_problem_details_update.setBorder(border);
                                t_dog_problem_details_update.setBounds(64,1084,554,139);
                                pTables.add(t_dog_problem_details_update);

                                b_submit.setBounds(64, 1248, 554, 40);
                                pTables.add(b_submit);

                                pTables.updateUI();
                                break;
                        }
                        break;
                    case "delete":
                        switch (table) {
                            case "vets":
                                break;
                            case "dogs":
                                break;
                            case "litters":
                                break;
                            case "relationships":
                                break;
                            case "relationship_types":
                                break;
                            case "health_records":
                                break;
                            case "dog_problems":
                                break;
                            case "common_problem":
                                break;
                        }
                        break;
                }
            } catch (Exception ex) {
            }
        }
        if (e.getSource() == b_submit){

        }
    }
}
