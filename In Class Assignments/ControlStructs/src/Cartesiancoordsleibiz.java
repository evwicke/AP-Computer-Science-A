package ControlStructs.src;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.text.DecimalFormat;

/*
 * Cartesian coordinate plane plotting the convergence of Leibniz's series to PI.
 * Series: pi/4 = 1 - 1/3 + 1/5 - 1/7 + ...
 * This GUI shows partial sums (multiplied by 4) vs. term index n, and connects points smoothly.
 *
 * How to run:
 *  - Run Cartesiancoordsleibiz.main()
 */
public class Cartesiancoordsleibiz {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Leibniz Series Converging to π");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1000, 700);
            frame.setLocationRelativeTo(null);

            PlotPanel panel = new PlotPanel();
            frame.setContentPane(panel);
            frame.setVisible(true);
        });
    }

    static class PlotPanel extends JPanel {
        private static final int PADDING_LEFT = 70;
        private static final int PADDING_RIGHT = 30;
        private static final int PADDING_TOP = 40;
        private static final int PADDING_BOTTOM = 60;
        private static final Color GRID_COLOR = new Color(220, 220, 230);
        private static final Color AXIS_COLOR = new Color(60, 60, 80);
        private static final Color CURVE_COLOR = new Color(30, 120, 255);
        private static final Color POINT_COLOR = new Color(20, 90, 200);
        private static final Color PI_LINE_COLOR = new Color(220, 80, 80);
        private static final Stroke AXIS_STROKE = new BasicStroke(2f);
        private static final Stroke GRID_STROKE = new BasicStroke(1f);
        private static final Stroke CURVE_STROKE = new BasicStroke(2.2f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
        private static final Stroke PI_STROKE = new BasicStroke(1.5f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{6, 6}, 0);

        private int N = 20; // number of terms to plot (domain [0,20])
        private double[] xIdx;   // 0..N
        private double[] yApprox; // 4 * partial sums

        public PlotPanel() {
            setBackground(Color.WHITE);
            computeSeries();
        }

        private void computeSeries() {
            xIdx = new double[N + 1];
            yApprox = new double[N + 1];
            double sum = 0.0; // sum for pi/4
            for (int n = 0; n <= N; n++) {
                if (n > 0) {
                    int k = n - 1; // add the k-th term to move from S_{n-1} to S_n (with our indexing of xIdx)
                    double term = ((k % 2 == 0) ? 1.0 : -1.0) / (2.0 * k + 1.0);
                    sum += term;
                }
                xIdx[n] = n;
                yApprox[n] = 4.0 * sum; // approximate pi
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int w = getWidth();
            int h = getHeight();

            // Plot area
            int x0 = PADDING_LEFT;
            int y0 = PADDING_TOP;
            int x1 = w - PADDING_RIGHT;
            int y1 = h - PADDING_BOTTOM;

            // Draw background grid
            drawGrid(g2, x0, y0, x1, y1);
            // Draw axes and labels
            drawAxes(g2, x0, y0, x1, y1);

            // Value ranges: x in [0, N], y around [pi-0.6, pi+0.6] for visibility
            double xMin = 0;
            double xMax = N;
            double pi = Math.PI;
            // Determine y range based on data to auto fit with margins
            double yMin = Double.POSITIVE_INFINITY;
            double yMax = Double.NEGATIVE_INFINITY;
            for (double v : yApprox) { yMin = Math.min(yMin, v); yMax = Math.max(yMax, v); }
            double yPad = (yMax - yMin) * 0.2 + 0.2; // add some padding
            yMin = Math.min(pi - 0.6, yMin - yPad);
            yMax = Math.max(pi + 0.6, yMax + yPad);

            // Horizontal line at y = pi
            g2.setColor(PI_LINE_COLOR);
            g2.setStroke(PI_STROKE);
            int yPi = toScreenY(pi, yMin, yMax, y0, y1);
            g2.drawLine(x0, yPi, x1, yPi);
            g2.setFont(getFont().deriveFont(Font.PLAIN, 12f));
            g2.drawString("y = π (" + new DecimalFormat("0.00000").format(pi) + ")", x0 + 8, yPi - 6);

            // Draw smooth curve through the points using Catmull–Rom spline converted to cubic Bezier
            g2.setColor(CURVE_COLOR);
            g2.setStroke(CURVE_STROKE);

            // Build screen-space points
            int nPts = xIdx.length;
            Point2D.Double[] pts = new Point2D.Double[nPts];
            for (int i = 0; i < nPts; i++) {
                int sx = toScreenX(xIdx[i], xMin, xMax, x0, x1);
                int sy = toScreenY(yApprox[i], yMin, yMax, y0, y1);
                pts[i] = new Point2D.Double(sx, sy);
            }

            Path2D path = new Path2D.Double();
            if (nPts > 0) {
                path.moveTo(pts[0].x, pts[0].y);
                // tension s in [0,1]; 1 is classic Catmull–Rom
                double s = 1.0;
                for (int i = 0; i < nPts - 1; i++) {
                    Point2D.Double p0 = pts[Math.max(i - 1, 0)];
                    Point2D.Double p1 = pts[i];
                    Point2D.Double p2 = pts[i + 1];
                    Point2D.Double p3 = pts[Math.min(i + 2, nPts - 1)];

                    double c1x = p1.x + (p2.x - p0.x) * (s / 6.0);
                    double c1y = p1.y + (p2.y - p0.y) * (s / 6.0);
                    double c2x = p2.x - (p3.x - p1.x) * (s / 6.0);
                    double c2y = p2.y - (p3.y - p1.y) * (s / 6.0);

                    path.curveTo(c1x, c1y, c2x, c2y, p2.x, p2.y);
                }
            }
            g2.draw(path);

            // Draw points
            g2.setColor(POINT_COLOR);
            for (int i = 0; i < xIdx.length; i += Math.max(1, N / 100)) { // don't draw every point if many
                int sx = toScreenX(xIdx[i], xMin, xMax, x0, x1);
                int sy = toScreenY(yApprox[i], yMin, yMax, y0, y1);
                g2.fillOval(sx - 2, sy - 2, 4, 4);
            }

            // Axis labels
            g2.setColor(Color.DARK_GRAY);
            g2.setFont(getFont().deriveFont(Font.PLAIN, 13f));
            g2.drawString("n (number of terms)", (x0 + x1) / 2 - 60, h - 20);
            Graphics2D g2r = (Graphics2D) g2.create();
            g2r.rotate(-Math.PI / 2);
            g2r.drawString("Approximation of π", -(y0 + y1) / 2 - 40, 20);
            g2r.dispose();

            // Title
            g2.setFont(getFont().deriveFont(Font.BOLD, 16f));
            g2.setColor(new Color(30, 30, 40));
            g2.drawString("Leibniz Series: π ≈ 4 \u2211 (-1)^k/(2k+1)", x0, 24);

            g2.dispose();
        }

        private void drawGrid(Graphics2D g2, int x0, int y0, int x1, int y1) {
            g2.setColor(GRID_COLOR);
            g2.setStroke(GRID_STROKE);

            // vertical grid every ~50px in plot area
            int approxStepPx = 80;
            int plotW = x1 - x0;
            int vCount = Math.max(3, plotW / approxStepPx);
            for (int i = 0; i <= vCount; i++) {
                int x = x0 + i * plotW / vCount;
                g2.drawLine(x, y0, x, y1);
            }
            // horizontal grid
            int plotH = y1 - y0;
            int hCount = Math.max(3, plotH / approxStepPx);
            for (int i = 0; i <= hCount; i++) {
                int y = y0 + i * plotH / hCount;
                g2.drawLine(x0, y, x1, y);
            }
        }

        private void drawAxes(Graphics2D g2, int x0, int y0, int x1, int y1) {
            g2.setColor(AXIS_COLOR);
            g2.setStroke(AXIS_STROKE);
            // x-axis and y-axis border of plot area
            g2.drawRect(x0, y0, x1 - x0, y1 - y0);

            // ticks on x (n)
            g2.setFont(getFont().deriveFont(Font.PLAIN, 11f));
            int ticks = 10;
            for (int i = 0; i <= ticks; i++) {
                int x = x0 + i * (x1 - x0) / ticks;
                g2.drawLine(x, y1, x, y1 + 6);
                int nVal = (int) Math.round(i * (double) N / ticks);
                String s = Integer.toString(nVal);
                int sw = g2.getFontMetrics().stringWidth(s);
                g2.drawString(s, x - sw / 2, y1 + 20);
            }

            // ticks on y around pi
            double yMin = Math.PI - 1.0;
            double yMax = Math.PI + 1.0;
            for (double v = Math.ceil(yMin * 2) / 2.0; v <= yMax; v += 0.5) { // every 0.5
                int y = toScreenY(v, yMin, yMax, y0, y1);
                g2.drawLine(x0 - 6, y, x0, y);
                String s = new DecimalFormat("0.0").format(v);
                int sw = g2.getFontMetrics().stringWidth(s);
                g2.drawString(s, x0 - 10 - sw, y + 4);
            }
        }

        private int toScreenX(double x, double xMin, double xMax, int x0, int x1) {
            double t = (x - xMin) / (xMax - xMin);
            t = Math.max(0, Math.min(1, t));
            return (int) Math.round(x0 + t * (x1 - x0));
        }

        private int toScreenY(double y, double yMin, double yMax, int y0, int y1) {
            double t = (y - yMin) / (yMax - yMin);
            t = Math.max(0, Math.min(1, t));
            return (int) Math.round(y1 - t * (y1 - y0)); // invert y
        }
    }
}
