
package lab2.level;

import java.awt.*;


public class Room extends Rectangle {
	/**
	 * North = 0
	 * East = 1
	 * South = 2
	 * West = 3
	 */
	protected Room[] connections = new Room[4];

	protected int dx;
	protected int dy;


	protected Color color;
	
	public Room(int dx, int dy, Color color) {
		this.dx = dx;
		this.dy = dy;

		this.width = dx;
		this.height = dy;

		this.color = color;

		System.out.println(String.format("size: %s*%s color: %s", dx, dy, color.toString()));
	}


	/**
	 *
	 * @param r
	 */
	public void connectNorthTo(Room r) {
		connections[0] = r;
	}
	public void connectEastTo(Room r) {
		connections[1] = r;
	}
	public void connectSouthTo(Room r) {
		connections[2] = r;
	}

	public void connectWestTo(Room r) {
		connections[3] = r;
	}
}
