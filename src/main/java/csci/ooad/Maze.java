package csci.ooad;

import java.util.ArrayList;
import java.util.Random;

// AI Disclosure
// This class was written in collaboration with ChatGPT 4o
// Link to conversation
// https://chatgpt.com/share/031d3869-8056-4776-9e7a-5e828766d669
public class Maze {
    private int gridX;
    private int gridY;
    private int numRooms;
    private String[][] map;
    private ArrayList<Room> rooms;

    // Constructor
    public Maze(int gridX, int gridY, int numRooms) {
        this.gridX = gridX;
        this.gridY = gridY;
        this.numRooms = numRooms;
        this.rooms = new ArrayList<>();
        this.map = new String[gridX][gridY];
    }

    // Getters
    public int getGridX() {
        return gridX;
    }

    public int getGridY() {
        return gridY;
    }

    public int getNumRooms() {
        return numRooms;
    }

    public String[][] getMap() {
        return map;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    // Initialize the map with boundaries and empty spaces
    public void initializeMap() {
        for (int i = 0; i < gridX; i++) {
            for (int j = 0; j < gridY; j++) {
                if (i == 0 || i == gridX - 1 || j == 0 || j == gridY - 1) {
                    map[i][j] = "Boundary"; // Set boundaries
                } else {
                    map[i][j] = null; // Inner area available for rooms
                }
            }
        }
    }

    // Generate the starting room in a random non-boundary position
    public void generateStartingRoom() {
        Random random = new Random();
        int startX, startY;

        // Choose a random non-boundary position for the starting room
        do {
            startX = random.nextInt(gridX - 2) + 1; // Avoid boundary rows
            startY = random.nextInt(gridY - 2) + 1; // Avoid boundary columns
        } while (map[startX][startY] != null);

        Room startingRoom = new Room();
        startingRoom.roomId = 0;
        startingRoom.generateStartingRoom();
        rooms.add(startingRoom);
        map[startX][startY] = "Room 0"; // Place the starting room on the map
    }

    // Generate additional rooms and update neighbor dictionaries
    public void generateAdditionalRooms() {
        Random random = new Random();

        for (int roomId = 1; roomId < numRooms; roomId++) {
            int roomX = -1, roomY = -1;

            // Find an existing room with space for a neighbor
            while (roomX == -1) {
                int existingRoomIndex = random.nextInt(rooms.size());
                Room existingRoom = rooms.get(existingRoomIndex);
                int[] location = findRoomLocation(existingRoom.roomId);

                if (location != null) {
                    int x = location[0];
                    int y = location[1];

                    // Check all four directions for available neighbor spots
                    if (x > 1 && map[x - 1][y] == null) {
                        roomX = x - 1; roomY = y;
                    } else if (x < gridX - 2 && map[x + 1][y] == null) {
                        roomX = x + 1; roomY = y;
                    } else if (y > 1 && map[x][y - 1] == null) {
                        roomX = x; roomY = y - 1;
                    } else if (y < gridY - 2 && map[x][y + 1] == null) {
                        roomX = x; roomY = y + 1;
                    }
                }
            }

            // Generate the new room
            Room newRoom = new Room();
            newRoom.roomId = roomId;
            rooms.add(newRoom);
            map[roomX][roomY] = "Room " + roomId;

            // Update the neighbor dictionaries
            updateNeighborDictionaries(roomX, roomY, roomId);
        }
    }

    // Find the location of a room on the map by its room ID
    private int[] findRoomLocation(int roomId) {
        for (int i = 0; i < gridX; i++) {
            for (int j = 0; j < gridY; j++) {
                if (map[i][j] != null && map[i][j].equals("Room " + roomId)) {
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }

    // Update the neighbor dictionaries when a new room is placed
    private void updateNeighborDictionaries(int x, int y, int newRoomId) {
        Room newRoom = rooms.get(newRoomId);

        // Check all four directions and update the neighbor dictionaries
        if (x > 1 && map[x - 1][y] != null && !map[x - 1][y].equals("Boundary")) {
            updateRoomNeighbor(x - 1, y, "South", newRoomId, "North");
        }
        if (x < gridX - 2 && map[x + 1][y] != null && !map[x + 1][y].equals("Boundary")) {
            updateRoomNeighbor(x + 1, y, "North", newRoomId, "South");
        }
        if (y > 1 && map[x][y - 1] != null && !map[x][y - 1].equals("Boundary")) {
            updateRoomNeighbor(x, y - 1, "East", newRoomId, "West");
        }
        if (y < gridY - 2 && map[x][y + 1] != null && !map[x][y + 1].equals("Boundary")) {
            updateRoomNeighbor(x, y + 1, "West", newRoomId, "East");
        }
    }

    // Helper function to update a room's neighbor dictionary
    private void updateRoomNeighbor(int neighborX, int neighborY, String newRoomDirection, int newRoomId, String neighborDirection) {
        int neighborRoomId = Integer.parseInt(map[neighborX][neighborY].split(" ")[1]);
        Room neighborRoom = rooms.get(neighborRoomId);

        if (neighborRoom.neighborDictionary == null) {
            neighborRoom.neighborDictionary = new Dictionary(new ArrayList<>(), new ArrayList<>());
        }

        // Update the neighbor dictionary for both rooms
        neighborRoom.neighborDictionary.keys.add(neighborDirection);
        neighborRoom.neighborDictionary.values.add(newRoomId);

        Room newRoom = rooms.get(newRoomId);
        if (newRoom.neighborDictionary == null) {
            newRoom.neighborDictionary = new Dictionary(new ArrayList<>(), new ArrayList<>());
        }

        newRoom.neighborDictionary.keys.add(newRoomDirection);
        newRoom.neighborDictionary.values.add(neighborRoomId);
    }
}
