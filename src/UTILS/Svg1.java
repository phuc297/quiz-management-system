package UTILS;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.JLabel;

public class Svg1 extends JLabel {

    private FlatSVGIcon svgIcon;

    public void setSvgImage(String image, int width, int height) {
        svgIcon = new FlatSVGIcon(image, width, height);
        setIcon(svgIcon);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setPreferredSize(new Dimension(32, 32));
    }

}
