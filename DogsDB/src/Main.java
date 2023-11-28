import Frames.Login;
import Frames.MainFrame;
import Utileries.Connect;

import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, FontFormatException {
        Connect.setUser("postgres");
        Connect.setPassword("12345");
        //new Login();
        new MainFrame();
    }
}