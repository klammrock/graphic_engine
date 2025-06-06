package name.klamm;

import javax.swing.*;

public class App 
{
    public static void main( String[] args )
    {
        SwingUtilities.invokeLater(() -> {
            DrawingFrame frame = new DrawingFrame();
            frame.setVisible(true);
        });
    }
}
