package GUI.swing;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class ComboBoxRenderer extends JLabel implements ListCellRenderer{

    private Color selectedColor;

    public ComboBoxRenderer(Color selectedColor) {
        setOpaque(true);
        this.selectedColor = selectedColor;
    }

    public Component getListCellRendererComponent(JList list, Object value, int index,
            boolean isSelected, boolean cellHasFocus) {
        setText(value.toString());
        if (isSelected) {
            setBackground(selectedColor);
            setForeground(Color.white);
        } else {
            setBackground(Color.white);
            setForeground(Color.black);
        }
        return this;
    }
}
