package hu.snakegame;
import java.awt.Color;

public class SnakePart {

	private int x;
	private int y;
	private Color color = new Color(0, 255, 0);

	private static int width = 20;
	private static int height = 20;
	
	public static void setWidth(int width) {
		SnakePart.width = width;
	}
	
	public static int getWidth() {
		return width;
	}
	
	public static void setHeight(int height) {
		SnakePart.height = height;
	}
	
	public static int getHeight() {
		return height;
	}
	
	public SnakePart(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

}
