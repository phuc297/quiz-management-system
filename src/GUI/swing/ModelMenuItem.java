package GUI.swing;

import java.awt.Color;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ModelMenuItem {

    private String icon;
    private String iconOver;
    private String text;

    private final Color color = Color.white;
    private final Color colorOver = new Color(51, 204, 255);

    public ModelMenuItem(String icon, String iconOver, String text) {
        this.icon = icon;
        this.iconOver = iconOver;
        this.text = text;
    }

    public Icon toIcon() {
        return new ImageIcon("src\\assets\\" + icon + ".png");
    }

    public Icon toIconOver() {
        return new ImageIcon("src\\assets\\" + iconOver + ".png");
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIconOver() {
        return iconOver;
    }

    public void setIconOver(String iconOver) {
        this.iconOver = iconOver;
    }

    public Color getColor() {
        return color;
    }

    public Color getColorOver() {
        return colorOver;
    }

}
