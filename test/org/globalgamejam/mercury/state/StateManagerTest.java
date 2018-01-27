package org.globalgamejam.mercury.state;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import processing.core.PApplet;

public class StateManagerTest {
    /*
    TODO

     */
    @Test
    @Ignore
    @Deprecated
    public void testSetActiveState() {
        StateManager stateManager = StateManager.getInstance();
        stateManager.setNextState(new State() {
            private boolean isStarted;

            @Override
            public void init() {

            }

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
        stateManager.updateActiveState();
        Assert.assertTrue(stateManager.isActiveStateRunning());
    }
}
