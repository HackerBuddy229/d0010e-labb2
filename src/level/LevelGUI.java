
package lab2.level;

import lab2.Direction;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class LevelGUI implements Observer {

	private Level lv;
	private Display d;
	
	public LevelGUI(Level level, String name) {
		
		this.lv = level;
		this.lv.addObserver(this);
		
		JFrame frame = new JFrame(name);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// TODO: You should change 200 to a value 
		// depending on the size of the level
		d = new Display(lv,500,500);
		
		frame.getContentPane().add(d);
		frame.pack();
		frame.setLocation(0,0);
		frame.setVisible(true);
	}
	
	
	public void update(Observable arg0, Object arg1) {
		d.repaint();
	}
	
	private class Display extends JPanel {


		private final Level lvl;

		public Display(Level fp, int x, int y) {

			this.lvl = fp;
			
			addKeyListener(new Listener(lvl));
			
			setBackground(Color.GREEN);
			setPreferredSize(new Dimension(x+20,y+20));
			setFocusable(true);




		}
	
		

		public void paintComponent(Graphics g) {
			super.paintComponent(g);

			//Create background
			g.setColor(Color.gray);
			g.fillRect(0, 0, 500, 500);

			//for: create rooms
			for (Room r:this.lvl.rooms) {
				g.setColor(r.color);
				g.fillRect(r.x, r.y, r.dx, r.dy);
			}

			//for: create connections for current room

			g.setColor(Color.GREEN);

			Room cRoom = lvl.currentRoom;
			for (int i = 0; i < 4; i++) {
				try {
					if (cRoom.connections[i] != null) {
						Room r = cRoom.connections[i];
						g.drawLine(cRoom.x, cRoom.y, r.x, r.y);
						//TODO: debug
						System.out.println("DREW A FUCKING LINE MATE!!!");
					}
				} catch (NullPointerException ex) {
					continue;
				}
			}
		}
		

	 	private class Listener implements KeyListener {


			private final Level lvl;

			public Listener(Level level) {
				this.lvl = level;
			}

			public void keyPressed(KeyEvent arg0) {
				switch (arg0.getKeyChar()) {
					case 'w':
						lvl.move(Direction.NORTH);
						break;
					case 'a':
						lvl.move(Direction.WEST);
						break;
					case 's':
						lvl.move(Direction.SOUTH);
						break;
					case 'd':
						lvl.move(Direction.EAST);
						break;
				}
	 		}

	 		public void keyReleased(KeyEvent arg0) {
	 		}

	 		public void keyTyped(KeyEvent event) {
	 		}
	 	}

	}
	
}
