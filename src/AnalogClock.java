import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AnalogClock extends JPanel {
    private static final int CLOCK_RADIUS = 90;
    private static final int HOUR_HAND_LENGTH = 40;
    private static final int MINUTE_HAND_LENGTH = 65;
    private static final int SECOND_HAND_LENGTH = 75;
    private static final int HAND_WIDTH = 2;

    private Timer timer;

    public AnalogClock() {
        setPreferredSize(new Dimension(CLOCK_RADIUS * 3, CLOCK_RADIUS * 3));
        setBackground(new Color(193,154,107));
        timer = new Timer(1000, e -> repaint());
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Set antialiasing for smoother rendering
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        // Draw clock face
        g2d.setColor(new Color(234,221,202));
        g2d.fillOval(centerX - CLOCK_RADIUS, centerY - CLOCK_RADIUS, CLOCK_RADIUS * 2, CLOCK_RADIUS * 2);
        g2d.setColor(Color.BLACK);
        g2d.drawOval(centerX - CLOCK_RADIUS, centerY - CLOCK_RADIUS, CLOCK_RADIUS * 2, CLOCK_RADIUS * 2);

        // Draw hour hand
        int hours = getHours();
        double hourAngle = Math.toRadians((hours % 12) * 30 - 90);
        drawClockHand(g2d, centerX, centerY, hourAngle, HOUR_HAND_LENGTH, HAND_WIDTH);

        // Draw minute hand
        int minutes = getMinutes();
        double minuteAngle = Math.toRadians(minutes * 6 - 90);
        drawClockHand(g2d, centerX, centerY, minuteAngle, MINUTE_HAND_LENGTH, HAND_WIDTH);

        // Draw second hand
        int seconds = getSeconds();
        double secondAngle = Math.toRadians(seconds * 6 - 90);
        drawClockHand(g2d, centerX, centerY, secondAngle, SECOND_HAND_LENGTH, HAND_WIDTH);
    }

    private void drawClockHand(Graphics2D g2d, int centerX, int centerY, double angle, int handLength, int handWidth) {
        g2d.setStroke(new BasicStroke(handWidth));
        g2d.draw(new Line2D.Double(centerX, centerY, centerX + handLength * Math.cos(angle), centerY + handLength * Math.sin(angle)));
    }

    private int getHours() {
        return Integer.parseInt(new SimpleDateFormat("HH").format(new Date()));
    }

    private int getMinutes() {
        return Integer.parseInt(new SimpleDateFormat("mm").format(new Date()));
    }

    private int getSeconds() {
        return Integer.parseInt(new SimpleDateFormat("ss").format(new Date()));
    }
}