package name.klamm;

import javax.swing.*;

public class App 
{
    public static void main( String[] args )
    {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Java 24 Swing App");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);

            JLabel label = new JLabel("Hello, Java 24 with Swing!", SwingConstants.CENTER);
            frame.add(label);

            frame.setVisible(true);
        });
    }
}
