package name.klamm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DrawingFrame extends JFrame {
    private int rectX = 50, rectY = 50;
    private int deltaX = 2;

    public DrawingFrame() {
        setTitle("Drawing Rectangle Example");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        // Add our custom drawing panel
        add(new DrawingPanel());

        Timer timer = new Timer(16, e -> {
            rectX += deltaX;
            if (rectX + 200 > getWidth() || rectX < 0) {
                deltaX = -deltaX;
            }
            repaint();
        });
        timer.start();
    }

    // Custom panel for drawing
    class DrawingPanel extends JPanel {
        public DrawingPanel() {
            if (SwingUtilities.isEventDispatchThread()) {
                System.out.println("Running on EDT - don't block here!");
            }

            setDoubleBuffered(true);

            addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    rectX = e.getX() - 100; // Center rectangle on click
                    rectY = e.getY() - 50;
                    repaint(); // Trigger redraw
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // Enable anti-aliasing for smoother graphics
            Graphics2D g2d = (Graphics2D)g;
            g2d.setRenderingHint(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON
            );

            g.setColor(Color.BLUE);
            g.fillRect(rectX, rectY, 200, 100);
            g.setColor(Color.RED);
            g.drawRect(rectX, rectY, 200, 100);
        }
    }
}