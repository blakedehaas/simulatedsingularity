package csci.ooad;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class DictionaryTest {
    @Test
    // Tests the Dictionary class by simulating a room neighbor dictionary
    public void testDictionary() {
        ArrayList<Object> keys = new ArrayList<>();
        keys.add("North");
        keys.add("South");
        keys.add("West");
        keys.add("East");

        ArrayList<Object> values = new ArrayList<>();
        values.add("Normal Room");
        values.add("Treasure Room");
        values.add("Boss Room");
        values.add("No Room");

        Dictionary dictionary = new Dictionary(keys, values);

        assert(dictionary.keys.size() == dictionary.values.size());
        assert(dictionary.keys.get(3) == "East");
        assert(dictionary.values.get(3) == "No Room");
    }
}
