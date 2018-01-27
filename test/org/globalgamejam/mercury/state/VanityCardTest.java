package org.globalgamejam.mercury.state;

import org.globalgamejam.mercury.Game;
import org.junit.Test;

public class VanityCardTest {
    @Test
    public void testLoadResources() {
        Game g = new Game(true);

        VanityCardState state = new VanityCardState();
        state.init();
        state.start();
    }
}
