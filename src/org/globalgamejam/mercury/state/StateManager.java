/*
 * This work is licensed under the Creative Commons Attribution-NonCommercial-ShareAlike 3.0
 * United States License. To view a copy of this license, visit
 * http://creativecommons.org/licenses/by-nc-sa/3.0/us/
 * or send a letter to Creative Commons, PO Box 1866, Mountain View, CA 94042, USA.
 */

package org.globalgamejam.mercury.state;

import org.globalgamejam.mercury.Game;
import processing.core.PApplet;

public class StateManager {

    private static StateManager instance;
    private State activeState;
    private State nextState;

    private StateManager() {
    }

    public static StateManager getInstance() {
        if (instance == null)
            instance = new StateManager();
        return instance;
    }

    public void init() { //TODO: This makes testing difficult. Change how this is called.
        this.setNextState(new VanityCardState());
        this.activateNextState();
    }

    private void activateNextState() {
        stopActiveState();
        this.activeState = this.nextState;
        this.nextState = this.hasActiveState() ? this.activeState.nextState() : null;
        startActiveState();
    }

    private void startActiveState() {
        if (!this.hasActiveState())
            Game.getInstance().exit();
        else
            this.activeState.start();
    }

    private void stopActiveState() {
        if (this.activeState != null)
            this.activeState.stop();
    }

    public void setNextState(State nextState) {
        this.nextState = nextState;
        if (this.nextState != null)
            this.nextState.init();
    }

    public void updateActiveState() {
        if (this.isActiveStateFinished() || (!this.hasActiveState() && this.hasNextState())) {
            this.activateNextState();
        }
    }

    public void interruptActiveState() {
        if (this.hasActiveState())
            this.activateNextState();
    }

    public void renderActiveState(PApplet window) {
        if (this.hasActiveState())
            this.activeState.render(window);
    }

    public boolean isActiveStateRunning() {
        if (this.hasActiveState())
            return this.activeState.isRunning();
        return false;
    }

    public boolean isActiveStateFinished() {
        if (this.hasActiveState())
            return this.activeState.isFinished();
        return true;
    }

    public boolean hasActiveState() {
        return this.activeState != null;
    }

    public boolean hasNextState() {
        return this.nextState != null;
    }
}
