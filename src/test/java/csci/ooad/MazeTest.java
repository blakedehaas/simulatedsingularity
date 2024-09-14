package csci.ooad;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

// AI Disclosure
// This class was written in collaboration with ChatGPT 4o
// Link to conversation
// https://chatgpt.com/share/031d3869-8056-4776-9e7a-5e828766d669
public class MazeTest {

    // Test the constructor of the Maze class with grid and room number parameters
    @Test
    public void testMazeConstructor() {
        Maze maze = new Maze(4, 4, 4); // 4x4 grid, 4 rooms to generate
        assertNotNull(maze);
        assertEquals(4, maze.getGridX());
        assertEquals(4, maze.getGridY());
        assertEquals(4, maze.getNumRooms());
    }

    // Test map initialization and boundary setup
    @Test
    public void testMapInitialization() {
        Maze maze = new Maze(4, 4, 4);
        maze.initializeMap();

        String[][] map = maze.getMap();
        // Ensure boundaries are set correctly
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == 0 || i == 3 || j == 0 || j == 3) {
                    assertEquals("Boundary", map[i][j], "Boundaries should be set correctly.");
                } else {
                    assertNull(map[i][j], "Non-boundary spaces should be null initially.");
                }
            }
        }
    }

    // Test starting room generation
    @Test
    public void testStartingRoomGeneration() {
        Maze maze = new Maze(4, 4, 4);
        maze.initializeMap();
        maze.generateStartingRoom();

        String[][] map = maze.getMap();
        boolean startingRoomFound = false;

        // Check if there is a room in the non-boundary space
        for (int i = 1; i < 3; i++) {
            for (int j = 1; j < 3; j++) {
                if (map[i][j] != null) {
                    startingRoomFound = true;
                    assertTrue(map[i][j].contains("Room"), "A room should be generated.");
                }
            }
        }
        assertTrue(startingRoomFound, "The starting room should be generated in a non-boundary spot.");
    }

    // Test room generation and neighbor updates
    @Test
    public void testRoomGenerationAndNeighbors() {
        Maze maze = new Maze(4, 4, 4);
        maze.initializeMap();
        maze.generateStartingRoom();
        maze.generateAdditionalRooms();

        String[][] map = maze.getMap();
        ArrayList<Room> rooms = maze.getRooms();

        // Check neighbor dictionaries for each room
        for (Room room : rooms) {
            if (room.neighborDictionary != null) {
                // Iterate over keys (cast Object to String)
                for (Object directionObj : room.neighborDictionary.keys) {
                    String direction = (String) directionObj; // Cast Object to String

                    // Ensure the neighbor value is not null
                    assertNotNull(room.neighborDictionary.values.get(room.neighborDictionary.keys.indexOf(direction)),
                            "Neighbor room ID should be updated in the dictionary.");
                }
            }
        }
    }


    // Test the number of rooms generated
    @Test
    public void testNumberOfRoomsGenerated() {
        Maze maze = new Maze(4, 4, 4); // Test for 4 rooms
        maze.initializeMap();
        maze.generateStartingRoom();
        maze.generateAdditionalRooms();

        assertEquals(4, maze.getRooms().size(), "4 rooms should be generated.");
    }
}
