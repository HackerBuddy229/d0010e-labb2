
package lab2.level;

import lab2.Direction;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;


public class Level extends Observable {

	protected List<Room> rooms = new ArrayList<Room>();
	protected Room firstRoom = null;

	public Level() {
		setChanged();
	}

	public void setCurrentRoom(Room currentRoom) {
		this.currentRoom = currentRoom;

		notifyObservers();
	}

	protected Room currentRoom;
	
	
	public boolean place(Room r, int x, int y)  {

		for (Room room: this.rooms) {
			int rxCenter, ryCenter;
			rxCenter = x + (r.dx/2);
			ryCenter = y + (r.dy/2);

			if (room.x >= rxCenter && room.x + room.dx <= rxCenter) {
				if (room.y >= ryCenter && room.y + room.dy <= ryCenter) {
					return false;
				}
			}


			if (lineIntersect(r, x, y, room.x, room.y, room.y+room.dy, room.x+room.dx)) 						return false;
			if (lineIntersect(r, x+r.dx, y+r.dy, room.x, room.y, room.y+room.dy, room.x+room.dx)) 	return false;


		}

		//TODO: fix debug
		r.x = x;
		r.y = y;
		rooms.add(r);
		return true;
	}

	/**
	 *
	 * @param r new room
	 * @param x1 new room x
	 * @param y1 new room y
	 * @param x2 compared x
	 * @param y2 compared y	(upper y)
	 * @param y3 compared y + dy (lower y)
	 * @return
	 */
	private static boolean lineIntersect(Room r, int x1, int y1, int x2, int y2, int y3, int x3) {
		if ( x2 <= x1 && x3 >= x1) {
			boolean larger = (y1 > y3);
			boolean smaller = (y1+r.dy < y2);
			if (!(larger||smaller)){
				return true;
			}
		}
		return false;
	}

	public boolean move(Direction direction) {
		try {

			Room newRoom = null;
			switch (direction) {
				case NORTH:
					newRoom = currentRoom.connections[0];
					break;
				case EAST:
					newRoom = currentRoom.connections[1];
					break;
				case SOUTH:
					newRoom = currentRoom.connections[2];
					break;
				case WEST:
					newRoom = currentRoom.connections[3];
					break;
			}

			if (rooms.contains(newRoom))
				setCurrentRoom(newRoom);
		} catch (NullPointerException ex) {
			return false;
		}

		return true;
	}

	public void firstLocation(Room r) {
			if (rooms.contains(r)) {
				this.firstRoom = r;
				this.currentRoom = r;
			}

	}
	
}
