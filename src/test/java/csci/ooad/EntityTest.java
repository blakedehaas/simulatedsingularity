package csci.ooad;

import org.junit.jupiter.api.Test;

public class EntityTest {
    @Test
    public void testCreateNewCreatureEntity() {
        String creatureName = "Ogre";
        int creatureHealth = 5;
        String creatureType = "Creature";

        Entity creature = new Entity(creatureName, creatureHealth, creatureType);

        assert (creature.name == "Ogre");
        assert (creature.health == 5);
        assert(creature.type == "Creature");
    }

    @Test
    public void testCreateNewCharacterEntity() {
        String characterName = "Hero";
        int characterHealth = 5;
        String characterType = "Character";

        Entity character = new Entity(characterName, characterHealth, characterType);

        assert (character.name == "Hero");
        assert (character.health == 5);
        assert(character.type == "Character");
    }
}
