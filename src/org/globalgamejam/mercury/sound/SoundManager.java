/*
 * This work is licensed under the Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-sa/4.0/ or send a letter to
 * Creative Commons, PO Box 1866, Mountain View, CA 94042, USA.
 */

package org.globalgamejam.mercury.sound;

public class SoundManager {
    private static SoundManager ourInstance = new SoundManager();

    private SoundManager() {
    }

    public static SoundManager getInstance() {
        return ourInstance;
    }

    /*
    Daniel_Birch_-_05_-_Forgotten_Landscape.mp3 - Ambience
    Komiku_-_62_-_The_Challenge.mp3 - Ambience
    David_Hilowitz_-_01_-_Displaced_Memories.mp3 - Title Theme
    Art_Of_Escapism_-_Return_to_War.mp3 - Victory
    Anonymous420_-_08_-_O_X_L2_X_-_O_R1.mp3 - Defeat
     */

    public void init() {

    }
}
