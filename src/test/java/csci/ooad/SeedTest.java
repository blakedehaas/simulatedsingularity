package csci.ooad;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

// AI Disclosure
// This class was written in collaboration with ChatGPT
public class SeedTest {

    // Human Disclosure
    // This method was written without AI
    @Test
    public void testGenerateSeed() {
        Seed randomGen = new Seed();
         double defaultSeed = 4.6026788191726469E18;
        assertEquals(defaultSeed, randomGen.getSeed(),
                "Generated seed should match the seed in the object.");
    }
    // AI Disclosure
    // The rest of the methods were written in collaboration with ChatGPT 4o
    @Test
    public void testSetSeed() {
        Seed randomGen = new Seed();
        randomGen.setSeed(42);
        assertEquals(42, randomGen.getSeed(),
                "Seed should be set to 42.");
    }

    @Test
    public void testRollDie() {
        Seed randomGen = new Seed();
        randomGen.setSeed(42);
        int roll = randomGen.rollDie(6);
        assertTrue(roll >= 1 && roll <= 6,
                "Die roll should be between 1 and 6.");
    }

    @Test
    public void testGetRandomInt() {
        Seed randomGen = new Seed();
        randomGen.setSeed(42);
        int value = randomGen.getRandomInt(10, 20);
        assertTrue(value >= 10 && value <= 20,
                "Random int should be between 10 and 20.");
    }

    @Test
    public void testGetRandomDouble() {
        Seed randomGen = new Seed();
        randomGen.setSeed(42);
        double value = randomGen.getRandomDouble();
        assertTrue(value >= 0.0 && value < 1.0,
                "Random double should be between 0.0 and 1.0.");
    }

    @Test
    public void testGetRandomBoolean() {
        Seed randomGen = new Seed();
        randomGen.setSeed(42);
        boolean value = randomGen.getRandomBoolean();
        assertNotNull(value, "Random boolean should not be null.");
    }

    @Test
    public void testCoinToss() {
        Seed randomGen = new Seed();
        randomGen.setSeed(42);
        String result = randomGen.coinToss();
        assertTrue(result.equals("Heads") || result.equals("Tails"),
                "Coin toss should return 'Heads' or 'Tails'.");
    }

    @Test
    public void testGetRandomElementFromList() {
        Seed randomGen = new Seed();
        randomGen.setSeed(42);
        List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
        String item = randomGen.getRandomElementFromList(list);
        assertTrue(list.contains(item),
                "Random element should be from the list.");
    }

    @Test
    public void testGetRandomGaussian() {
        Seed randomGen = new Seed();
        randomGen.setSeed(42);
        double mean = 0.0;
        double stdDev = 1.0;
        double value = randomGen.getRandomGaussian(mean, stdDev);
        assertTrue(Double.isFinite(value),
                "Random Gaussian value should be finite.");
    }

    @Test
    public void testShuffleList() {
        Seed randomGen = new Seed();
        randomGen.setSeed(42);
        List<Integer> originalList = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> listToShuffle = Arrays.asList(1, 2, 3, 4, 5);
        randomGen.shuffleList(listToShuffle);
        assertEquals(originalList.size(), listToShuffle.size(),
                "Shuffled list should be the same size.");
        assertTrue(listToShuffle.containsAll(originalList),
                "Shuffled list should contain all original elements.");
        assertNotEquals(originalList, listToShuffle,
                "List order should be shuffled.");
    }

    @Test
    public void testGetRandomWeightedElement() {
        Seed randomGen = new Seed();
        randomGen.setSeed(42);
        List<String> items = Arrays.asList("A", "B", "C");
        List<Double> weights = Arrays.asList(0.5, 0.3, 0.2);
        String item = randomGen.getRandomWeightedElement(items, weights);
        assertTrue(items.contains(item),
                "Weighted random element should be from the list.");
    }
}
