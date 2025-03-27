package GUI;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import GUI.swing.ScrollBar;

public class ScrollBarTable {

    public static void setScrollBarTable(JScrollPane jScrollPane) {
        jScrollPane.setBorder(BorderFactory.createEmptyBorder());
        jScrollPane.getViewport().setBackground(Color.WHITE);
        jScrollPane.setVerticalScrollBar(new ScrollBar());
        jScrollPane.getVerticalScrollBar().setBackground(Color.WHITE);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        jScrollPane.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
    }
}
