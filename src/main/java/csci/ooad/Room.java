package csci.ooad;

import java.util.ArrayList;

public class Room {
    public int numNeighbors;
    public Entity occupiedBy;
    public String roomType;
    public int roomId;
    public Dictionary neighborDictionary;


    public Room() {
        this.numNeighbors = 0;
        this.occupiedBy = null;
        this.roomType = "Normal Room";
        this.neighborDictionary = null;
        this.roomId = -1;
    }

    public void occupyRoomWithEntity(Entity entity) {
        this.occupiedBy = entity;
    }

    public void generateStartingRoom() {
        //Room startingRoom = new Room();

        String characterName = "Hero";
        int characterHealth = 5;
        String characterType = "Character";
        Entity character = new Entity(characterName, characterHealth, characterType);

        this.occupyRoomWithEntity(character);
        this.roomType = "Starting Room";
    }
}
