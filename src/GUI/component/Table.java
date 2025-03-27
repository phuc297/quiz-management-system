package GUI.component;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import UTILS.Cons;

public class Table extends JTable {

    private static final Color SELECTED_COLOR = new Color(0, 204, 0);
    private ArrayList<Integer> selected;
    private boolean multiSelect;

    public Table() {
        selected = new ArrayList<>();
        multiSelect = false;
        setBackground(Color.WHITE);
        setShowGrid(false);
        setIntercellSpacing(new Dimension(0, 0));
        setRowHeight(30);
        setFocusable(false);
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        setBorder(null);
        setHeader();
        setShowHorizontalLines(true);
        setGridColor(new Color(230, 230, 230));
        getTableHeader().setReorderingAllowed(false);
        setRender();
    }

    private void setHeader() {
        Dimension dim = getTableHeader().getPreferredSize();
        dim.height = 50;
        getTableHeader().setPreferredSize(dim);
        getTableHeader().setFont(Cons.FONT);
        getTableHeader().setForeground(Cons.COLOR_MENU);
        getTableHeader().setBorder(null);
        getTableHeader().setFont(Cons.FONT);
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                c.setFont(Cons.FONT_HEADER_TABLE);
                c.setForeground(Cons.COLOR_MENU);

                return c;
            }
        });
    }

    private void setRender() {
        setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                if (isSelected) {
                    c.setBackground(SELECTED_COLOR);
                } else {
                    c.setBackground(table.getBackground());
                }

                return c;
            }
        });
    }

    public void setAddRow(int row) {
        selected.add(row);
    }

    public void setRemoveRow(int row) {
        selected.remove(row);
    }

    public void setMultiSelect(boolean b) {
        this.multiSelect = b;
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

}
