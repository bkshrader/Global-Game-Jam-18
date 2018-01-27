/*
 * This work is licensed under the Creative Commons Attribution-NonCommercial-ShareAlike 3.0
 * United States License. To view a copy of this license, visit
 * http://creativecommons.org/licenses/by-nc-sa/3.0/us/
 * or send a letter to Creative Commons, PO Box 1866, Mountain View, CA 94042, USA.
 */

package org.globalgamejam.mercury;

public class StateManager {

    private static StateManager instance;
    private State activeState;

    private StateManager() {
    }

    public static StateManager getInstance() {
        if (instance == null)
            instance = new StateManager();
        return instance;
    }

    public State getActiveState() {
        return this.activeState;
    }

    public void setActiveState(State activeState) {
        this.activeState.stop();
        this.activeState = activeState;
        this.activeState.start();
    }
}
