package GUI.component;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JButton;

public class ButtonQuestion extends JButton {

    public ButtonQuestion(String title, Dimension d) {
        setText(title);
        setPreferredSize(d);
        setMaximumSize(d);
        setMinimumSize(d);
        setBackground(Color.WHITE);
        setForeground(new Color(0,204,255));
        setBorder(BorderFactory.createLineBorder(new Color(0,204,255)));
        setFocusable(false);
    }
    
    public void setChosen(){
        setBackground(new Color(0,204,255));
        setForeground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.WHITE));
    }
}
