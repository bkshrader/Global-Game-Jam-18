/*
 * This work is licensed under the Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-sa/4.0/ or send a letter to
 * Creative Commons, PO Box 1866, Mountain View, CA 94042, USA.
 */

package org.globalgamejam.mercury.state;

import org.globalgamejam.mercury.Renderable;

public interface State extends Renderable {
    void init();

    void start();

    void stop();

    void pause();

    boolean isRunning();

    boolean isFinished();

    State nextState();
}
