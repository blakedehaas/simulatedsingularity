package csci.ooad;

import java.util.Random;
import java.util.List;
import java.util.Collections;

// AI Disclosure
// This class was written in collaboration with ChatGPT
public class Seed {
    public long seed;
    private Random randomGenerator;

    // Default constructor with a tutorial seed
    public Seed() {
        // Initialize with a default seed for tutorial purposes
        this.seed = Double.doubleToLongBits(0.5);
        this.randomGenerator = new Random(this.seed);
    }

    // Generates a new seed and updates the random generator
    public int generateSeed() {
        Random seedGenerator = new Random();
        this.seed = seedGenerator.nextLong();
        this.randomGenerator = new Random(this.seed);
        return (int) this.seed;
    }

    // Sets a specific seed for deterministic results
    public void setSeed(long seed) {
        this.seed = seed;
        this.randomGenerator = new Random(this.seed);
    }

    // Gets the current seed
    public long getSeed() {
        return this.seed;
    }

    // Simulates rolling a die with a specified number of faces
    public int rollDie(int numberOfFaces) {
        if (numberOfFaces < 1) {
            throw new IllegalArgumentException(
                    "Number of faces must be at least 1.");
        }
        return randomGenerator.nextInt(numberOfFaces) + 1;
    }

    // Generates a random integer between min and max (inclusive)
    public int getRandomInt(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException(
                    "Min must be less than or equal to max.");
        }
        return randomGenerator.nextInt((max - min) + 1) + min;
    }

    // Generates a random double between 0.0 and 1.0
    public double getRandomDouble() {
        return randomGenerator.nextDouble();
    }

    // Generates a random boolean value
    public boolean getRandomBoolean() {
        return randomGenerator.nextBoolean();
    }

    // Simulates a coin toss, returning "Heads" or "Tails"
    public String coinToss() {
        return randomGenerator.nextBoolean() ? "Heads" : "Tails";
    }

    // Returns a random element from a list
    public <T> T getRandomElementFromList(List<T> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException(
                    "List must not be null or empty.");
        }
        int index = randomGenerator.nextInt(list.size());
        return list.get(index);
    }

    // Generates a random number from a Gaussian distribution
    public double getRandomGaussian(double mean, double stdDev) {
        return mean + randomGenerator.nextGaussian() * stdDev;
    }

    // Shuffles a list in place
    public <T> void shuffleList(List<T> list) {
        if (list == null) {
            throw new IllegalArgumentException("List must not be null.");
        }
        Collections.shuffle(list, randomGenerator);
    }

    // Selects a random element from a list based on weights
    public <T> T getRandomWeightedElement(
            List<T> items, List<Double> weights) {
        if (items == null || weights == null || items.isEmpty()
                || weights.isEmpty()) {
            throw new IllegalArgumentException(
                    "Items and weights must not be null or empty.");
        }
        if (items.size() != weights.size()) {
            throw new IllegalArgumentException(
                    "Items and weights must be of the same size.");
        }

        double totalWeight = 0.0;
        for (double weight : weights) {
            if (weight < 0) {
                throw new IllegalArgumentException(
                        "Weights must be non-negative.");
            }
            totalWeight += weight;
        }
        if (totalWeight == 0) {
            throw new IllegalArgumentException(
                    "Total weight must be greater than zero.");
        }

        double randomValue = randomGenerator.nextDouble() * totalWeight;
        double cumulativeWeight = 0.0;
        for (int i = 0; i < items.size(); i++) {
            cumulativeWeight += weights.get(i);
            if (randomValue <= cumulativeWeight) {
                return items.get(i);
            }
        }
        // Fallback in case of rounding errors
        return items.get(items.size() - 1);
    }
}
