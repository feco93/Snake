package hu.snakegame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MyPanel extends JPanel {

	public MyPanel() {
		setBorder(BorderFactory.createLineBorder(Color.black));
	}

	public Dimension getPreferredSize() {
		return new Dimension(400, 400);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		if (Game.started) {
			for (SnakePart snakepart : Game.snake) {
				Rectangle rec = new Rectangle(SnakePart.getWidth(), SnakePart.getHeight());
				rec.setLocation(snakepart.getX() * SnakePart.getWidth(), snakepart.getY() * SnakePart.getHeight());
				g2.setColor(snakepart.getColor());
				g2.fill(rec);
				g2.draw(rec);
			}

			Rectangle rec = new Rectangle(SnakePart.getWidth(), SnakePart.getHeight());
			rec.setLocation(Game.food.getX() * SnakePart.getWidth(), Game.food.getY() * SnakePart.getHeight());
			g2.setColor(Game.food.getColor());
			g2.fill(rec);
			g2.draw(rec);
		}
	}

}
