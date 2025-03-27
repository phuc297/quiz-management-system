package GUI.component;

import java.awt.Color;
import javax.swing.JComboBox;
import GUI.swing.ComboBoxRenderer;
import UTILS.Cons;

public class ComboboxGender extends JComboBox<Object> {

    public ComboboxGender() {
        setBorder(null);
        setBackground(Color.WHITE);

        addItem("Nam");
        addItem("Nữ");

        setRenderer(new ComboBoxRenderer(Cons.COLOR_MENU));
    }
}
