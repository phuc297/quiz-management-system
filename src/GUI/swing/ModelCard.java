package GUI.swing;

import java.awt.Color;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import UTILS.Cons;

public class ModelCard {

    private String title;
    private String icon;
    private String text;
    private Color color;

    public ModelCard(String icon, String title, String text, Color color) {
        this.title = title;
        this.icon = icon;
        this.text = text;
        this.color = color;
    }

    public Icon toIcon() {
        return new ImageIcon(Cons.IMAGE_PATH + getIcon() + ".png");
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

}
