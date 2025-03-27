package GUI.component;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JFrame;
import static UTILS.Cons.ARC_ROUND_RECT;
import GUI.events.MyEventListener;

public class PanelHeader extends javax.swing.JPanel {

    private MyEventListener event;

    public void addLogOutEvent(MyEventListener event) {
        this.event = event;
    }
    private JFrame frame;

    public PanelHeader() {
        initComponents();

        setPreferredSize(new Dimension(getWidth(), 32));
        setBackground(Color.WHITE);
        //setBackground(Color.BLACK);

        svg1.setBackground(getBackground());
        svg2.setBackground(getBackground());
        svg3.setBackground(getBackground());

        svg1.setPreferredSize(new Dimension(32, 32));
        svg2.setPreferredSize(new Dimension(32, 32));
        svg3.setPreferredSize(new Dimension(32, 32));
        svg1.setSvgImage("assets/close.svg", 32, 32);
        svg2.setSvgImage("assets/max.svg", 32, 32);
        svg3.setSvgImage("assets/min.svg", 32, 32);
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    private int x;
    private int y;

    public void setDraggable(JFrame frame) {
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                x = me.getX();
                y = me.getY();
            }

        });
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent me) {
                frame.setLocation(me.getXOnScreen() - x, me.getYOnScreen() - y);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        svg1 = new UTILS.Svg();
        svg2 = new UTILS.Svg();
        svg3 = new UTILS.Svg();

        setBackground(new java.awt.Color(0, 0, 0));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(685, 20));

        svg1.setBackground(new java.awt.Color(255, 102, 102));
        svg1.setMaximumSize(new java.awt.Dimension(32, 32));
        svg1.setMinimumSize(new java.awt.Dimension(32, 32));
        svg1.setPreferredSize(new java.awt.Dimension(32, 32));
        svg1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                svg1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                svg1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                svg1MouseExited(evt);
            }
        });

        svg2.setMaximumSize(new java.awt.Dimension(32, 32));
        svg2.setMinimumSize(new java.awt.Dimension(32, 32));
        svg2.setPreferredSize(new java.awt.Dimension(32, 32));
        svg2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                svg2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                svg2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                svg2MouseExited(evt);
            }
        });

        svg3.setBackground(new java.awt.Color(204, 204, 204));
        svg3.setMaximumSize(new java.awt.Dimension(32, 32));
        svg3.setMinimumSize(new java.awt.Dimension(32, 32));
        svg3.setPreferredSize(new java.awt.Dimension(32, 32));
        svg3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                svg3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                svg3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                svg3MouseExited(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 493, Short.MAX_VALUE)
                .addComponent(svg3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(svg2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(svg1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(svg1, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
            .addComponent(svg3, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
            .addComponent(svg2, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void svg1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_svg1MouseClicked
        event.actionPerformed();
    }//GEN-LAST:event_svg1MouseClicked

    private void svg2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_svg2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_svg2MouseClicked

    private void svg3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_svg3MouseClicked
        frame.setState(JFrame.ICONIFIED);
        svg3.setBackground(getBackground());
    }//GEN-LAST:event_svg3MouseClicked

    private void svg1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_svg1MouseEntered
        svg1.setBackground(new Color(255, 102, 102));
    }//GEN-LAST:event_svg1MouseEntered

    private void svg1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_svg1MouseExited
        svg1.setBackground(getBackground());
    }//GEN-LAST:event_svg1MouseExited

    private void svg2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_svg2MouseEntered
        svg2.setBackground(new Color(204, 204, 204));
    }//GEN-LAST:event_svg2MouseEntered

    private void svg2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_svg2MouseExited
        svg2.setBackground(getBackground());
    }//GEN-LAST:event_svg2MouseExited

    private void svg3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_svg3MouseEntered
        svg3.setBackground(new Color(204, 204, 204));
    }//GEN-LAST:event_svg3MouseEntered

    private void svg3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_svg3MouseExited
        svg3.setBackground(getBackground());
    }//GEN-LAST:event_svg3MouseExited

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), ARC_ROUND_RECT, ARC_ROUND_RECT);
        g2.fillRect(0, 0, 20, getHeight());
        g2.fillRect(getWidth() - 20, 20, 20, getHeight() - 20);
        super.paintComponent(g);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private UTILS.Svg svg1;
    private UTILS.Svg svg2;
    private UTILS.Svg svg3;
    // End of variables declaration//GEN-END:variables
}
