import processing.core.PApplet;

public class Game extends PApplet {

    public static void main(String[] args) {
        new Game().main(Game.class,
                (args.length > 0) ? args :
                        new String[]{
                                //Default runtime arguments
                        }
        );
    }

    @Override
    public void setup() {

    }

    @Override
    public void draw() {

    }
}
