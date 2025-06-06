package name.klamm;

import javax.swing.*;
import java.awt.*;

public class App 
{
    public static void main( String[] args )
    {
        Toolkit.getDefaultToolkit().setDynamicLayout(false);
        System.setProperty("sun.awt.noerasebackground", "true");

        SwingUtilities.invokeLater(() -> {
            DrawingFrame frame = new DrawingFrame();
            frame.setVisible(true);
        });
    }
}
