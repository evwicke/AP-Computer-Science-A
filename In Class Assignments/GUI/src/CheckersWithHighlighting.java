package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// The file is named CheckersWithHighlighting, so the public class must match.
public class CheckersWithHighlighting {

    // Main method to set up the game window
    public static void main(String[] args) {
        JFrame frame = new JFrame("Tic-Tac-Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null); // Center the frame

        // The TicTacToePanel contains all the game logic and drawing.
        TicTacToePanel gamePanel = new TicTacToePanel();
        frame.add(gamePanel);

        frame.setVisible(true);
    }

    // A self-contained panel for the Tic-Tac-Toe game.
    private static class TicTacToePanel extends JComponent {
        private final char[][] board = new char[3][3]; // '\0', 'X', 'O'
        private char currentPlayer = 'X';
        private boolean gameOver = false;

        public TicTacToePanel() {
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (gameOver) return;

                    int cellWidth = getWidth() / 3;
                    int cellHeight = getHeight() / 3;
                    int col = e.getX() / cellWidth;
                    int row = e.getY() / cellHeight;

                    if (col >= 0 && col < 3 && row >= 0 && row < 3 && board[row][col] == '\0') {
                        board[row][col] = currentPlayer;
                        repaint();

                        if (checkWin(row, col)) {
                            gameOver = true;
                            System.out.println("Player " + currentPlayer + " wins!");
                            endGame();
                        } else if (isBoardFull()) {
                            gameOver = true;
                            System.out.println("It's a draw!");
                            endGame();
                        } else {
                            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                        }
                    }
                }
            });
        }

        private void endGame() {
            // Find the top-level frame and dispose of it
            Window window = SwingUtilities.getWindowAncestor(this);
            if (window instanceof JFrame) {
                // Use invokeLater to ensure the window closes cleanly after the final paint
                SwingUtilities.invokeLater(window::dispose);
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int cellWidth = getWidth() / 3;
            int cellHeight = getHeight() / 3;

            // Draw a white background and light gray grid lines
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, getWidth(), getHeight());
            g.setColor(Color.LIGHT_GRAY);
            for (int i = 1; i < 3; i++) {
                g.drawLine(i * cellWidth, 0, i * cellWidth, getHeight());
                g.drawLine(0, i * cellHeight, getWidth(), i * cellHeight);
            }

            // Draw all the X's and O's on the board
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setStroke(new BasicStroke(8)); // Use a thicker stroke for drawing

            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    if (board[row][col] == 'X') {
                        drawX(g2, col * cellWidth, row * cellHeight, cellWidth, cellHeight);
                    } else if (board[row][col] == 'O') {
                        drawO(g2, col * cellWidth, row * cellHeight, cellWidth, cellHeight);
                    }
                }
            }
        }

        private void drawX(Graphics2D g, int x, int y, int width, int height) {
            g.setColor(Color.RED);
            int padding = 25;
            g.drawLine(x + padding, y + padding, x + width - padding, y + height - padding);
            g.drawLine(x + width - padding, y + padding, x + padding, y + height - padding);
        }

        private void drawO(Graphics2D g, int x, int y, int width, int height) {
            g.setColor(Color.BLUE);
            int padding = 25;
            g.drawOval(x + padding, y + padding, width - 2 * padding, height - 2 * padding);
        }

        private boolean checkWin(int lastRow, int lastCol) {
            char player = board[lastRow][lastCol];

            // Check row, column, and both diagonals
            if (board[lastRow][0] == player && board[lastRow][1] == player && board[lastRow][2] == player) return true;
            if (board[0][lastCol] == player && board[1][lastCol] == player && board[2][lastCol] == player) return true;
            if (lastRow == lastCol && board[0][0] == player && board[1][1] == player && board[2][2] == player) return true;
            if (lastRow + lastCol == 2 && board[0][2] == player && board[1][1] == player && board[2][0] == player) return true;

            return false;
        }

        private boolean isBoardFull() {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == '\0') {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}