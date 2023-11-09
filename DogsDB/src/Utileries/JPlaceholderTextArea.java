package Utileries;

import javax.swing.*;
import java.awt.*;

public class JPlaceholderTextArea extends JTextArea {
    private String placeholder;

    public JPlaceholderTextArea(String placeholder) {
        this.placeholder = placeholder;
    }

    @Override
    public String getText() {
        String text = super.getText();

        if (text.trim().length() == 0 && placeholder != null) {
            text = placeholder;
        }

        return text;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (super.getText().length() > 0 || placeholder == null) {
            return;
        }
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(super.getDisabledTextColor());
        g2.drawString(placeholder, getInsets().left, g.getFontMetrics().getMaxAscent() + getInsets().top);
    }
}
