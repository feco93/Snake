package hu.snakegame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.Timer;

public class Game {

	public static Timer timer;
	public static List<SnakePart> snake;
	public static SnakePart food;
	public static int direction = 0;
	public static boolean isEated = false;
	public static boolean started = false;
	public static boolean gameOver;
	public static Dimension fieldSize;

	public static int getDirection() {
		return direction;
	}

	public static void setDirection(int direction) {
		if (snake.size() >= 2) {
			switch (direction) {
			case 0:
				if (snake.get(0).getX() + 1 != snake.get(1).getX())
					Game.direction = direction;
				break;
			case 1:
				if (snake.get(0).getY() - 1 != snake.get(1).getY())
					Game.direction = direction;
				break;
			case 2:
				if (snake.get(0).getX() - 1 != snake.get(1).getX())
					Game.direction = direction;
				break;
			case 3:
				if (snake.get(0).getY() + 1 != snake.get(1).getY())
					Game.direction = direction;
				break;

			}
		} else {
			Game.direction = direction;
		}
	}

	public static void checkGameOver() {
		
		for (int j = snake.size() - 1; j > 0; --j) {
			if (snake.get(0).getX() == snake.get(j).getX()
					&& snake.get(0).getY() == snake.get(j).getY()) {
				gameOver = true;
			}
		}
		
		if ( snake.get(0).getX()*SnakePart.getWidth() == fieldSize.getWidth()
			|| snake.get(0).getX()*SnakePart.getWidth() == 0 - SnakePart.getWidth() 
			|| snake.get(0).getY()*SnakePart.getHeight() == fieldSize.getHeight()
			|| snake.get(0).getY()*SnakePart.getHeight() == 0 - SnakePart.getHeight())
				gameOver = true;
	}

	public static void updateSnake() {

		for (int i = snake.size() - 1; i >= 0; --i) {

			if (i == 0) {

				switch (direction) {
				case 0:
					snake.get(0).setX(snake.get(0).getX() + 1);
					break;
				case 1:
					snake.get(0).setY(snake.get(0).getY() - 1);
					break;
				case 2:
					snake.get(0).setX(snake.get(0).getX() - 1);
					break;
				case 3:
					snake.get(0).setY(snake.get(0).getY() + 1);
					break;
				}

				checkGameOver();

				if (snake.get(i).getX() == food.getX()
						&& snake.get(i).getY() == food.getY()) {
					isEated = true;
				}

				if (isEated) {
					SnakePart newSnakePart = new SnakePart(snake.get(
							snake.size() - 1).getX(), snake.get(
							snake.size() - 1).getY());
					newSnakePart.setColor(new Color(255, 0, 0));
					snake.add(newSnakePart);
					Random rand = new Random();
					food = new SnakePart(rand.nextInt(fieldSize.width
							- SnakePart.getWidth())
							/ SnakePart.getWidth(),
							rand.nextInt(fieldSize.height
									- SnakePart.getHeight())
									/ SnakePart.getHeight());
					isEated = false;
				}
			} else {
				snake.get(i).setX(snake.get(i - 1).getX());
				snake.get(i).setY(snake.get(i - 1).getY());
			}
		}

	}

	public static void start() {
		gameOver = false;
		SnakePart.setWidth(20);
		SnakePart.setHeight(20);
		fieldSize = new Dimension(400, 400);
		snake = new ArrayList<SnakePart>();
		SnakePart head = new SnakePart(10, 10);
		head.setColor(new Color(0, 0, 0));
		snake.add(head);
		Random rand = new Random();
		food = new SnakePart(rand.nextInt(fieldSize.width
				- SnakePart.getWidth())
				/ SnakePart.getWidth(), rand.nextInt(fieldSize.height
				- SnakePart.getHeight())
				/ SnakePart.getHeight());

		timer = new Timer(200, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!gameOver) {
					updateSnake();
					Main.panel.repaint();
				} else {
					System.out.println("Game over!");
				}
			}
		});
		timer.start();
		started = true;
	}

	public static void end() {
		if (started)
			timer.stop();
		started = false;
	}

}
