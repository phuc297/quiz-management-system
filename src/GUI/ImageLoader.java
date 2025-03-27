package GUI;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class ImageLoader {

    public static void loadImageToJLabel(JLabel label, String imagePath) {
        try {
            ImageIcon icon = new ImageIcon(imagePath);
            Image image = icon.getImage();
            label.setIcon(new ImageIcon(image));
        } catch (Exception e) {
        }
    }

    public static void loadScaledImageToJLabel(JLabel label, int width, int height, String imagePath) {
        try {
            ImageIcon icon = new ImageIcon(imagePath);
            Image image = icon.getImage();
            Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            label.setIcon(new ImageIcon(scaledImage));
        } catch (Exception e) {
        }
    }

    public static void loadImageToJButton(JButton button, int width, int height, String imagePath) {
        try {
            ImageIcon icon = new ImageIcon(imagePath);
            Image image = icon.getImage();
            Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            button.setIcon(new ImageIcon(scaledImage));
        } catch (Exception e) {
        }
    }
}
