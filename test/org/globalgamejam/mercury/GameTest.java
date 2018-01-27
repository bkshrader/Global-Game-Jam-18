package org.globalgamejam.mercury;

import org.junit.Test;

public class GameTest {

    @Test(expected = IllegalStateException.class)
    @SuppressWarnings({"unused", "UnusedAssignment"})
    public void testDoubleInitializationException() {
        Game g = new Game();
        g = new Game();
    }
}
