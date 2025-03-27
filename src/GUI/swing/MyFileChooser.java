package GUI.swing;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MyFileChooser extends JFileChooser {

    public MyFileChooser() {
        FileFilter filter = new FileNameExtensionFilter("Excel files", "xls", "xlsx");
        setFileFilter(filter);
        setCurrentDirectory(new File("Excel"));
    }
}
