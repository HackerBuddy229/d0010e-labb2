package lab2;

import lab2.level.Level;
import lab2.level.LevelGUI;
import lab2.level.Room;

import java.awt.*;

public class Driver {

	/**
	 *
	 */
	public void run() {


		Room[] rooms= {
				new Room(50, 50, Color.cyan),
				new Room(50, 50, Color.YELLOW),
				new Room(50, 50, Color.green),
				new Room(50, 50, Color.pink),
				new Room(50, 50, Color.blue)
		};

		maze(rooms);

		Level lvl = new Level();

		lvl.place(rooms[0], 0, 0);
		lvl.place(rooms[1], 20, 55);
		lvl.place(rooms[2], 0, 200);
		lvl.place(rooms[3], 60, 0);
		lvl.place(rooms[4], 60, 100);

		lvl.firstLocation(rooms[0]);

		LevelGUI gui = new LevelGUI(lvl, "First!!!");


	}

	/**
	 *
	 * @param rooms
	 */
	private static void maze(Room[] rooms) {
		rooms[0].connectSouthTo(rooms[1]);
		rooms[1].connectNorthTo(rooms[0]);
		rooms[1].connectSouthTo(rooms[2]);
		rooms[2].connectNorthTo(rooms[1]);
		rooms[2].connectSouthTo(rooms[3]);
		rooms[3].connectNorthTo(rooms[2]);
		rooms[3].connectSouthTo(rooms[4]);
		rooms[4].connectNorthTo(rooms[3]);
	}

}