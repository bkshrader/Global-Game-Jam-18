package org.globalgamejam.mercury;

import processing.core.PApplet;
import processing.core.PConstants;

public class Game extends PApplet {
    /*
    Wartime Supply Chains

    Play as a wartime supply chain manager where you view the world only as a map showing
    your established territories and supply chains. The only information you receive about
    the combat happening in the world is the effects actions are having on your supply network.

    The combat taking place is conducted by the computer, but the actions of the player determine
    the probability of success or failure. You must work considerately to ensure that all of your
    soldiers have access to the supplies they need, and spreading your resources too thin or
    concentrating too many resources in one area may lead to devastating consequences.

    Types of Supply Chain:
        - Roads
        - Airstrips
        - Radio Antennae

    Types of Supplies:
        - Food and Medicine
        - Commands and Combat Reports
        - Weapons and Ammunition
        - Troops and Vehicles

    Additional Ideas:
        - Command Centers and Bases with different capabilities based on size and cost to make
            - Allow player to set base radius and priority
                - Radius spreads resources or concentrates them
                - Priority determines how many troops will be sent to defend territory when contested
        - Network effectiveness reports to aid in decision making
        - Spy networks to help predict outcomes

    Balance and Mechanics:
        -
     */

    /* TODO
        - Create and manage game states and transitions
            - Determine how/when to transition to another state
            - Game States:
                - Opening Vanity Cards
                - Main Menu
                - Loading Screen
                - Gameplay
                    * Need to consider:
                    * Pause Menu
                    * Info Panel
                    * Action Menu
                - Credits
        - Create a map which can:
            - Render itself and tell its children to render themselves
            - Keep track of combat variables such as unit count and resources
            - Keep track of established supply networks
            - Determine/reflect the outcome of an assault
        - Create Combat Units which can:
            - Determine if an assault is taking place
            - Determine when an assault is completed
        - Create Supply Networks (as a set of paths) which can:
            - Keep track of their path/location/area
            - Keep track of their state
                - capacity
                - occupancy
                - acceptable supply types
            - Render themselves
        - Create a player which can: TODO: Not finished
            - Money:
                - Keep track of their current balance
                - Determine whether or not the player can purchase something

     */
    public static void main(String[] args) {
        PApplet.main(Game.class);
    }

    @Override
    public void settings() {
        this.fullScreen(PConstants.P2D);
    }

    @Override
    public void setup() {
        this.background(0);
    }

    @Override
    public void draw() {

    }
}
