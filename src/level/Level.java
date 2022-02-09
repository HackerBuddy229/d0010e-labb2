
package lab2.level;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;


public class Level extends Observable {

	protected List<Room> rooms;

	protected Room firstRoom = null;
	protected Room currentRoom = null;

	private boolean hasBegun = false;

	public Level() {
		this.rooms = new ArrayList<Room>();
	}


	/**
	 *	Sets the current room prop and notifies observers
	 * @param currentRoom the new current room
	 */
	private void setCurrentRoom(Room currentRoom) {
		this.currentRoom = currentRoom;

		setChanged();
		notifyObservers(currentRoom);
	}

	/**
	 * sets the has begun prop to true
	 */
	protected void begin() {
		hasBegun = true;
	}


	/**
	 * adds a new room to the level maze if it does not overlap other rooms
	 * @param r the new room
	 * @param x the rooms x coordinate
	 * @param y the rooms y coordinate
	 * @return weather or not the room could be placed
	 */
	public boolean place(Room r, int x, int y)  {
		//check if game has started
		if (hasBegun)
			return false;

		//assigns coordinate props
		r.x = x;
		r.y = y;

		//iterates the existing rooms to check for overlap
		for (Room room: this.rooms)
			if (room.intersects(r)) //checks for intersects
				return false;


		//if the for loop exits then no overlap has been detected


		//adds the room to the level maze
		rooms.add(r);
		return true;
	}


	/**
	 * changes the current room prop in the specified direction
	 * if a connection exists for that direction in the current room
	 * @param direction enum representing the direction corresponding to an index of the connections prop of the rooms
	 * @return a boolean as to indicate wether or not the current room prop was changed
	 */
	protected boolean move(Direction direction) {
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

			//checks that the room is both in the connections array as well as part of the level maze
			if (rooms.contains(newRoom))
				setCurrentRoom(newRoom);
		} catch (NullPointerException ex) {
			//if the direction does not exist in the connections prop then false idicates no change
			return false;
		}

		//if nothing throws an exception, the current room is changed
		return true;
	}


	/**
	 * sets the first room and current room props if r exists as part of the level
	 * @param r the room that is assigned
	 */
	public void firstLocation(Room r) {
			if (rooms.contains(r) && this.firstRoom == null) {
				this.firstRoom = r;
				this.currentRoom = r;
				this.begin();
			}

	}
	
}
