package csci.ooad;

import org.junit.jupiter.api.Test;
// TODO: Implement an abstract room class
public class RoomTest {
    @Test
    public void testGenerateNewStartingRoom() {
        Room startingRoom = new Room();

        // The starting room should be occupied by the Character at start of game
        startingRoom.generateStartingRoom();
        assert(startingRoom.occupiedBy.type.equals("Character"));
        assert(startingRoom.numNeighbors == 0);
        assert(startingRoom.roomType.equals("Starting Room"));
    }

    // TODO: Implement an abstract room class
    @Test
    public void testGenerateNewRoom() {
        Room room = new Room();

        assert(room.numNeighbors == 0);
        assert(room.occupiedBy == null);
        assert(room.roomType.equals("Normal Room"));
        assert(room.neighborDictionary == null);
        assert(room.roomId == -1);
    }

    @Test
    public void testOccupyRoomWithCreatureEntity() {
        Room room = new Room();

        String creatureName = "Ogre";
        int creatureHealth = 5;
        String creatureType = "Creature";
        Entity creature = new Entity(creatureName, creatureHealth, creatureType);

        room.occupyRoomWithEntity(creature);

        assert(room.occupiedBy.type.equals( "Creature"));

    }

    @Test
    public void testOccupyRoomWithCharacterEntity() {
        Room room = new Room();

        String characterName = "Hero";
        int characterHealth = 5;
        String characterType = "Character";
        Entity character = new Entity(characterName, characterHealth, characterType);

        room.occupyRoomWithEntity(character);

        assert(room.occupiedBy.type.equals("Character"));

    }
}


