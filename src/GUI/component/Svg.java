package GUI.component;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

public class Svg extends JLabel {

    private FlatSVGIcon svgIcon;
    private String name = "";

    public Svg() {

    }

    public void setSvgImage(String image, int width, int height) {
        this.name = image;
        svgIcon = new FlatSVGIcon("assets/" + image + ".svg", width, height);
        setIcon(svgIcon);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (isEnabled()) {
                    svgIcon = new FlatSVGIcon("assets/" + name + "1.svg", width, height);
                    setIcon(svgIcon);
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                svgIcon = new FlatSVGIcon("assets/" + name + ".svg", width, height);
                setIcon(svgIcon);
            }

        });
    }
}
