package GUI.swing;

import GUI.events.MenuClickListener;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.SwingUtilities;

public class ListMenu<E extends Object> extends JList<E> {

    private MenuClickListener event;
    private final DefaultListModel model;
    private int selectedIndex = -1;
    private int overIndex = -1;

    public void addMenuClickListener(MenuClickListener event) {
        this.event = event;
    }

    public ListMenu() {
        model = new DefaultListModel();
        setModel(model);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                if (SwingUtilities.isLeftMouseButton(me)) {
                    int index = locationToIndex(me.getPoint());
                    Object o = model.getElementAt(index);
                    if (o instanceof ModelMenuItem) {
                        selectedIndex = index;
                        if (event != null) {
                            event.onMenuClick(index);
                        }
                    } else {
                        selectedIndex = index;
                    }
                    repaint();
                }
            }

            @Override
            public void mouseExited(MouseEvent me) {
                overIndex = -1;
                repaint();
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent me) {
                int index = locationToIndex(me.getPoint());
                if (index != overIndex) {
                    Object o = model.getElementAt(index);
                    if (o instanceof ModelMenuItem) {
                        overIndex = index;
                        repaint();
                    }
                } else {
                    overIndex = -1;
                }
            }
        });
    }

    @Override
    public ListCellRenderer<? super E> getCellRenderer() {
        return new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> jlist, Object o, int index, boolean selected, boolean focus) {
                ModelMenuItem data;
                if (o instanceof ModelMenuItem modelMenuItem) {
                    data = modelMenuItem;
                } else {
                    data = new ModelMenuItem("", "", "");
                }
                MenuItem item = new MenuItem(data);
                item.setSelected(selectedIndex == index);
                item.setOver(overIndex == index);
                return item;
            }

        };
    }

    public void addItem(ModelMenuItem data) {
        model.addElement(data);
    }
}
