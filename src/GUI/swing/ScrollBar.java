package GUI.swing;

import java.awt.Dimension;
import javax.swing.JScrollBar;
import UTILS.Cons;

public class ScrollBar extends JScrollBar {

    public ScrollBar() {
        setUI(new ScrollBarUI());
        setPreferredSize(new Dimension(5, 5));
        setBackground(Cons.COLOR_MENU);
        setUnitIncrement(20);
    }
}
