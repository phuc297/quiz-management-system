package UTILS;

import java.util.*;
import java.text.*;

import javax.swing.*;

public class JClock extends Thread {

    private SimpleDateFormat sdf;
    private JLabel label;

    public JClock(JLabel label) {
        this.label = label;
        sdf = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
    }

    public String getCurrentTime() {
        return sdf.format(new Date());
    }

    public void run() {
        while (true) {
            label.setText(getCurrentTime());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        JLabel label = new JLabel();
        JClock clock = new JClock(label);
        clock.start();

        JFrame frame = new JFrame();
        frame.add(label);
        frame.pack();
        frame.setVisible(true);
    }
}
