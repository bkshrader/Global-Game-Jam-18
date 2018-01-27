package org.globalgamejam.mercury.util;

import org.junit.Assert;
import org.junit.Test;
import processing.core.PConstants;

public class MathUtilsTest {
    private float value = 2;
    private float min = 0;
    private float max = 5;
    private float magnitude = 4;
    private float midpoint = (max - min) / 2f;

    @Test
    public void sinInterpolationEndPoints() {
        Assert.assertEquals(0, MathUtils.sinInterpolation(min, min, max, magnitude), 0.0001);
        Assert.assertEquals(0, MathUtils.sinInterpolation(max, min, max, magnitude), 0.0001);
    }

    @Test
    public void sinInterpolationMidPoint() {
        Assert.assertEquals(magnitude, MathUtils.sinInterpolation(midpoint, min, max, magnitude), 0.0001);
    }

    @Test
    public void sinInterpolation30() {
        float theta30 = unmap(PConstants.PI / 6f, min, max, 0, PConstants.PI);
        Assert.assertEquals(magnitude / 2f, MathUtils.sinInterpolation(theta30, min, max, magnitude), 0.0001);
    }

    @Test
    public void cosInterpolationEndPoints() {
        Assert.assertEquals(magnitude, MathUtils.cosInterpolation(min, min, max, magnitude), 0.0001);
        Assert.assertEquals(magnitude, MathUtils.cosInterpolation(max, min, max, magnitude), 0.0001);
    }

    @Test
    public void cosInterpolationMidPoint() {
        Assert.assertEquals(0, MathUtils.cosInterpolation(midpoint, min, max, magnitude), 0.0001);
    }

    @Test
    public void cosInterpolation60() {
        float theta60 = unmap(PConstants.PI / 3f, min, max, 0, PConstants.PI);
        Assert.assertEquals(magnitude / 2f, MathUtils.cosInterpolation(theta60, min, max, magnitude), 0.0001);
    }

    private float unmap(float desiredMapping, float inputMin, float inputMax, float outputMin, float outputMax) {
        return (((desiredMapping - outputMin) * (inputMax - inputMin)) / (outputMax - outputMin)) + inputMin;
    }
}