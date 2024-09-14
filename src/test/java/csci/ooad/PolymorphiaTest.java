package csci.ooad;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class PolymorphiaTest {

    @Test
    public void testGame() {
        Polymorphia game = new Polymorphia();
        game.play();
        assert game.isOver();
    }

}
