package org.globalgamejam.mercury;

import org.junit.Assert;
import org.junit.Test;
import processing.core.PApplet;

public class StateManagerTest {
    /*
    TODO

     */
    @Test
    public void testSetActiveState() {
        StateManager stateManager = StateManager.getInstance();
        stateManager.setActiveState(new State() {
            private boolean isStarted;

            @Override
            public void start() {
                isStarted = true;
            }

            @Override
            public void stop() {
                isStarted = false;
            }

            @Override
            public void pause() {
            }

            @Override
            public boolean isRunning() {
                return isStarted;
            }

            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public State nextState() {
                return null;
            }

            @Override
            public void render(PApplet window) {
            }
        });

        Assert.assertTrue(stateManager.getActiveState().isRunning());
    }
}
