
package lab2.level;

import java.awt.Color;


public class Room {
	/**
	 * North = 0
	 * East = 1
	 * South = 2
	 * West = 3
	 */
	protected Room[] connections = {null, null, null, null};

	protected final int dx;
	protected final int dy;

	protected int x;
	protected int y;

	protected Color color;
	
	public Room(int dx, int dy, Color color) {
		this.dx = dx;
		this.dy = dy;

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
