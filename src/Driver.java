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

		Room r1 = new Room(200,100,Color.BLUE);
		Room r2 = new Room(100,60,Color.RED);
		Room r3 = new Room(70,30,Color.GREEN);
		Room r4 = new Room(170,60,Color.yellow);
		Room r5 = new Room(100,100,Color.white);
		Room r6 = new Room(40,200,Color.gray);
		Room r7 = new Room(270,160,Color.pink);
		Room r8 = new Room(120,70,Color.magenta);
		Room r9 = new Room(110,120,Color.orange);
		Level testLevel = new Level();
		testLevel.place(r1,50,40);
		testLevel.place(r2,30,25);
		testLevel.place(r3,210,20);
		testLevel.place(r4,230,100);
		testLevel.place(r5,20,80);
		testLevel.place(r6,90,10);
		testLevel.place(r7,20,20);
		testLevel.place(r8,80,50);
		testLevel.place(r9,130,100);

		testLevel.firstLocation(r1);
		LevelGUI lvlGUI = new LevelGUI(testLevel, "overlap test");

		//Level lvl = GetLevelDemo1();
		//Level lvl = GetLevelDemo2();

		//LevelGUI gui = new LevelGUI(lvl, "First!!!");


	}

	/**
	 *
	 * @param rooms
	 */
	private static void mazelvl1(Room[] rooms) {
		rooms[0].connectSouthTo(rooms[1]);
		rooms[1].connectNorthTo(rooms[0]);
		rooms[1].connectEastTo(rooms[2]);
		rooms[1].connectWestTo(rooms[3]);
		rooms[2].connectWestTo(rooms[1]);
		rooms[2].connectSouthTo(rooms[4]);
		rooms[3].connectEastTo(rooms[1]);
		rooms[4].connectNorthTo(rooms[2]);
	}
	private static void mazelvl2(Room[] rooms) {
		rooms[0].connectSouthTo(rooms[1]);
		rooms[1].connectNorthTo(rooms[0]);
		rooms[1].connectSouthTo(rooms[2]);
		rooms[2].connectNorthTo(rooms[1]);
		rooms[2].connectSouthTo(rooms[3]);
		rooms[3].connectNorthTo(rooms[2]);
		rooms[3].connectSouthTo(rooms[4]);
		rooms[4].connectNorthTo(rooms[3]);
	}
	private static Level GetLevelDemo1() {
		Room[] rooms = {
				new Room(125, 125, Color.cyan),
				new Room(125, 125, Color.YELLOW),
				new Room(125, 125, Color.green),
				new Room(250, 250, Color.pink),
				new Room(250, 250, Color.blue)
		};

		mazelvl1(rooms);

		Level lvl = new Level();

		lvl.place(rooms[0], 20, 20);
		lvl.place(rooms[1], 360, 200);
		lvl.place(rooms[2], 600, 200);
		lvl.place(rooms[3], 50, 50); // Pink: intersects with cyan and yellow
		lvl.place(rooms[4], 400, 600);

		lvl.firstLocation(rooms[0]);

		return lvl;
	}

	private static Level GetLevelDemo2() {
		Room[] rooms= {
				new Room(250, 250, Color.cyan),
				new Room(250, 250, Color.YELLOW),
				new Room(250, 250, Color.green),
				new Room(250, 250, Color.pink),
				new Room(250, 250, Color.blue)
		};

		mazelvl2(rooms);

		Level lvl = new Level();

		lvl.place(rooms[0], 632, 0);
		lvl.place(rooms[1], 456, 55);
		lvl.place(rooms[2], 171, 200);
		lvl.place(rooms[3], 358, 0);
		lvl.place(rooms[4], 746, 100);

		lvl.firstLocation(rooms[0]);

		return lvl;
	}

}