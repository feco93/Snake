package hu.snakegame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class Main {
	
	public static JFrame frame;
	private static JMenuBar menuBar;
	public static MyPanel panel;
	
	private static void addMenu() {
		menuBar = new JMenuBar();
		menuBar.setOpaque(true);
		menuBar.setBackground(new Color(154, 165, 127));
		menuBar.setPreferredSize(new Dimension(200, 20));
		JMenu play = new JMenu();
		play.setText("Play");
		JMenu info = new JMenu();
		info.setText("Info");

		JMenuItem newgame = new JMenuItem("New game");
		newgame.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				Game.end();
				Game.start();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		JMenuItem exit = new JMenuItem("Exit");
		exit.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				System.exit(0);
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});

		JMenuItem contributor = new JMenuItem("Contributor");
		contributor.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				JOptionPane.showMessageDialog(frame,
						"The contributor is Ferenc Sipos");				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		info.add(contributor);
		play.add(newgame);
		play.add(exit);

		menuBar.add(play);
		menuBar.add(info);
	}

	private static void addPanel() {
		panel = new MyPanel();
		panel.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent arg0) {
			if ( arg0.getKeyCode() == KeyEvent.VK_RIGHT ) {
				Game.setDirection(0);
			}
			else if ( arg0.getKeyCode() == KeyEvent.VK_UP ) {
				Game.setDirection(1);
			}
			else if ( arg0.getKeyCode() == KeyEvent.VK_LEFT ) {
				Game.setDirection(2);
			}
			else if ( arg0.getKeyCode() == KeyEvent.VK_DOWN ) {
				Game.setDirection(3);
			}
		}});
		frame.getContentPane().add(panel);
	}
	
	private static void createAndShowGUI() {
		frame = new JFrame("Snake");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
		frame.setLocation(x, y);
		
		
		addMenu();
		addPanel();
		
		frame.setMinimumSize(new Dimension(200, 200));
		frame.setResizable(false);
		frame.setJMenuBar(menuBar);
		frame.pack();
		frame.setVisible(true);
		panel.requestFocus();
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}

}
