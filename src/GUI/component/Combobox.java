package GUI.component;

import GUI.swing.ComboBoxRenderer;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import UTILS.Cons;

public class Combobox extends JComboBox<Object> {

    public Combobox() {
        setBorder(null);
        setBackground(Color.WHITE);
        setModel(new DefaultComboBoxModel<>(new String[]{"Không có dữ liệu"}));
        setRenderer(new ComboBoxRenderer(Cons.COLOR_MENU));
    }

    public void setData(ArrayList<Object> items) {
        if (items.size() > 0) {
            DefaultComboBoxModel model = new DefaultComboBoxModel(items.toArray());
            setModel(model);
        }
    }

    public void removeData() {
        setModel(new DefaultComboBoxModel<>(new String[]{"Không có dữ liệu"}));
    }
}
