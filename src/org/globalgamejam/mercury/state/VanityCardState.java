/*
 * This work is licensed under the Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-sa/4.0/ or send a letter to
 * Creative Commons, PO Box 1866, Mountain View, CA 94042, USA.
 */

package org.globalgamejam.mercury.state;

import org.globalgamejam.mercury.Game;
import org.globalgamejam.mercury.util.MathUtils;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class VanityCardState implements State {
    private final PApplet host = Game.getInstance();
    private PImage processingSplashImage;
    private PImage gameJamSplashImage;
    private long startTimeMilliseconds;
    private boolean isFinished;

    @Override
    public void init() {
        processingSplashImage = host.loadImage("processing-social.jpg");
        gameJamSplashImage = host.loadImage("game-jam.jpg");
        processingSplashImage.resize(host.width, host.height);
        gameJamSplashImage.resize(host.width, gameJamSplashImage.height / host.width * gameJamSplashImage.width);
    }

    @Override
    public void start() {
        startTimeMilliseconds = host.millis();
    }

    @Override
    public void stop() {
        processingSplashImage = null;
        gameJamSplashImage = null;
    }

    @Override
    public void pause() {
    }

    @Override
    public boolean isRunning() { //TODO: Not sure this is actually ever useful
        return startTimeMilliseconds > 0 && !this.isFinished;
    }

    @Override
    public boolean isFinished() {
        return isFinished;
    }

    @Override
    public State nextState() {
        return null; //TODO: Change to Intro Cutscene
    }

    @Override
    public void render(PApplet window) {
        window.pushStyle();
        window.pushMatrix();
        {
            window.imageMode(PConstants.CORNER);
            window.translate(window.width / 2, window.height / 2);
            { //TODO: Extract as Animation Object
                window.imageMode(window.CENTER);
                float slideDuration = 3000;
                if (this.elapsedTime() < slideDuration) {
                    window.tint(255, MathUtils.sinInterpolation(this.elapsedTime(), 0, slideDuration, 255));
                    window.image(this.processingSplashImage, 0, 0);
                } else if (this.elapsedTime() < 2 * slideDuration) {
                    window.tint(255, MathUtils.sinInterpolation(this.elapsedTime(), slideDuration, 2 * slideDuration, 255));
                    window.image(this.gameJamSplashImage, 0, 0);
                } else {
                    this.isFinished = true;
                }
            }
        }
        window.popMatrix();
        window.popStyle();
    }

    private long elapsedTime() {
        return host.millis() - startTimeMilliseconds;
    }
}
