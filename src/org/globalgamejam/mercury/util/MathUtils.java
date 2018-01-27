/*
 * This work is licensed under the Creative Commons Attribution-NonCommercial-ShareAlike 3.0
 * United States License. To view a copy of this license, visit
 * http://creativecommons.org/licenses/by-nc-sa/3.0/us/
 * or send a letter to Creative Commons, PO Box 1866, Mountain View, CA 94042, USA.
 */

package org.globalgamejam.mercury.util;

import processing.core.PApplet;
import processing.core.PConstants;

public class MathUtils {

    public static float sinInterpolation(float value, float valueStart, float valueStop, float magnitude) {
        float theta = PApplet.map(value, valueStart, valueStop, 0, PConstants.PI);
        return PApplet.abs(PApplet.sin(theta)) * magnitude;
    }

    public static float cosInterpolation(float value, float valueStart, float valueStop, float magnitude) {
        float theta = PApplet.map(value, valueStart, valueStop, 0, PConstants.PI);
        return PApplet.abs(PApplet.cos(theta)) * magnitude;
    }
}
