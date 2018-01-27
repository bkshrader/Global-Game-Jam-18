/*
 * This work is licensed under the Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-sa/4.0/ or send a letter to
 * Creative Commons, PO Box 1866, Mountain View, CA 94042, USA.
 */

package org.globalgamejam.mercury;

import org.globalgamejam.mercury.state.StateManager;
import processing.core.PApplet;
import processing.opengl.PJOGL;

public class Game extends PApplet {
    /*
    Wartime Supply Chains

    Play as a wartime supply chain manager in a steampunk alternate reality where as a player,
    you can view the world only as a map showing your established territories and supply chains.
    The only information you receive about the combat happening in the world is the effects
    actions are having on your supply network.

    The combat taking place is conducted by the computer, but the actions of the player determine
    the probability of success or failure. You must work considerately to ensure that all of your
    soldiers have access to the supplies they need, and spreading your resources too thin or
    concentrating too many resources in one area may lead to devastating consequences.

    Types of Supply Chain:
        - Roads
        - Airports (Part of bases)
        - Radio Antennae

    Types of Supplies:
        - Food and Medicine
        - Commands and Combat Reports
        - Weapons and Ammunition
        - Troops and Vehicles

    Additional Ideas / Future Updates:
        - Network effectiveness reports to aid in decision making
        - Spy networks to help predict outcomes

    Mechanics:
        - Structures:
            - Bases
                - Produce Units
                - Restock Zeppelins
            - Outposts
                - Only claim Territory
            * Both claim territory
                - Control Radius
                    - Hold more land and earn more money
                    - Hold less land and have more fortitude
                - Control Priority
                    - Likelihood more units will be sent to defend
                    - Likelihood more units will remain stationed
                - Territory generates revenue based on size
            - Radio Towers
                - Transmit messages instantly when units are in range
                - All bases and outposts are equipped with a corresponding size antenna
                - Consume money at a rate based on broadcast radius
            - Placing Structures
                - Player can place structures at any time
                - Once a structure is placed
                    - Territory is immediately claimed
                    - Structure is delivered via Truck or Zeppelin
                - If territory is contested before Troops or Structure arrive
                    - Territory is lost
                    - Structure placement is cancelled
                    - Portion of funds are refunded
                - For a structure to be built
                    - Level ground / No obstacles
                    - Territory not already owned by enemy
                    - Sufficient Funds
        - Units
            - Trucks
                - Do not conduct combat, but can be destroyed by enemy
                - Can carry anything very quickly, but only on roads
            - Infantry
                - Conduct combat and can carry messages
                - Require constant supply of resources to be effective
            - Zeppelin
                - Conduct combat and can carry both messages and resources
                - Can traverse any terrain including mountains
                - Very slow movement
            - Purchasing Units
                - Allow AI to choose?
                - Player purchases individual units?
                - Player sets unit ratio and budget?
                - Player sets unit count and computer buys?
     */

    private static Game instance;
    private boolean noDisplay; //Used for automated unit testing
    private StateManager stateManager;

    @SuppressWarnings("WeakerAccess")
    public Game() throws IllegalStateException {
        if (instance != null) {
            throw new IllegalStateException("Game is already initialized. Cannot initialize again.");
        }
        instance = this;

        this.noDisplay = false;
        this.stateManager = StateManager.getInstance();
    }

    public Game(boolean noDisplay) throws IllegalStateException {
        this();
        this.noDisplay = noDisplay;
    }

    /* TODO
        - Create and manage game states and transitions
            - Determine how/when to transition to another state
            - Render themselves and tell their children to render themselves
            - Game States:
                - Opening Vanity Cards
                - Opening Cutscene
                - Main Menu
                - Loading Screen
                - Gameplay
                    * Need to consider:
                    * Pause Menu
                    * Info Panel
                    * Action Menu
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
        PApplet.main(Game.class.getCanonicalName());
    }

    public static PApplet getInstance() {
        return instance;
    }

    @Override
    public void settings() {
        this.fullScreen(P2D, SPAN);
        PJOGL.setIcon();
    }

    @Override
    public void setup() {
        this.surface.setVisible(!noDisplay);
        this.stateManager.init();
        this.background(0);
    }

    @Override
    public void draw() {
        this.background(0);
        this.stateManager.renderActiveState(this);
        this.stateManager.updateActiveState();

        this.fill(255);
        this.textAlign(LEFT, TOP);
        this.text(String.format("%.0f", this.frameRate), 5, 5);
    }
}
