package name.klamm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DrawingFrame extends JFrame {
    private int rectX = 50, rectY = 50;

    public DrawingFrame() {
        setTitle("Drawing Rectangle Example");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        // Add our custom drawing panel
        add(new DrawingPanel());
    }

    // Custom panel for drawing
    class DrawingPanel extends JPanel {
        private int deltaX = 2;

        public DrawingPanel() {
            addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    rectX = e.getX() - 100; // Center rectangle on click
                    rectY = e.getY() - 50;
                    repaint(); // Trigger redraw
                }
            });

            Timer timer = new Timer(30, e -> {
                rectX += deltaX;
                if (rectX + 200 > getWidth() || rectX < 0) {
                    deltaX = -deltaX;
                }
                repaint();
            });
            timer.start();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.setColor(Color.BLUE);
            g.fillRect(rectX, rectY, 200, 100);
            g.setColor(Color.RED);
            g.drawRect(rectX, rectY, 200, 100);
        }
    }
}