package Frames;

import Utileries.Authentication;
import Utileries.RoundedBorder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Login extends JFrame implements ActionListener{
    private JButton bLogin;
    private JLabel lTitle,lPassword, lUser;
    private JTextField tUser;
    private JPasswordField tPassword;
    private Color backgroundGray = new Color(241, 245, 249);
    private Color orange = new Color(248, 127, 39);
    private Color black = new Color(15, 23, 42);
    private Font Inter_Semibold = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/Inter-SemiBold.ttf"));
    private Font Inter_Regular = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/Inter-Regular.ttf"));
    private Font bodyFont = Inter_Regular.deriveFont(16f);
    private Font buttonFont = Inter_Semibold.deriveFont(16f);
    private ImageIcon iLogo = new ImageIcon("Icons/Logo.png");
    private ImageIcon iMainLogo = new ImageIcon("Icons/MainLogo.png");

    public Login() throws IOException, FontFormatException {
        setLayout(null);
        setTitle("Login");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(490, 390);
        setLocationRelativeTo(null);
        setResizable(false);
        setBackground(backgroundGray);
        setIconImage(iMainLogo.getImage());


        lTitle = new JLabel(iLogo);
        lTitle.setBounds(120,30,270,120);
        add(lTitle);

        lUser = new JLabel("User:");
        lUser.setFont(bodyFont);
        lUser.setForeground(black);
        lUser.setBounds(120,174,50,30);
        add(lUser);

        tUser = new JTextField();
        tUser.setFont(bodyFont);
        tUser.setForeground(black);
        tUser.setBounds(175,174,205,30);
        add(tUser);

        lPassword = new JLabel("Password:");
        lPassword.setFont(bodyFont);
        lPassword.setForeground(black);
        lPassword.setBounds(100,224,100,30);
        add(lPassword);

        tPassword = new JPasswordField();
        tPassword.setFont(bodyFont);
        tPassword.setForeground(black);
        tPassword.setBounds(200,224,200,30);
        add(tPassword);

        bLogin = new JButton("Login");
        bLogin.setFont(buttonFont);
        bLogin.setForeground(Color.WHITE);
        bLogin.setBackground(orange);
        bLogin.setBorder(new RoundedBorder(backgroundGray, 2, 12));
        bLogin.setBounds(175,274,150,30);
        bLogin.addActionListener(this);
        add(bLogin);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== bLogin){
            if(Authentication.authUser(tUser.getText(),String.valueOf(tPassword.getPassword()))){
                dispose();
                try {
                    new MainFrame();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (FontFormatException ex) {
                    throw new RuntimeException(ex);
                }
            } else {
                JOptionPane.showMessageDialog(null,"Wrong user or password");
            }
        }
    }
}
