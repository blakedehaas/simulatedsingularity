package csci.ooad;

public class Polymorphia {
    // this is the main driver class for the Polymorphia game.

    public boolean playing = false;


    public void play() {
        playing = true;
        System.out.println("Playing Polymorphia");
        playing = false;


    }

    public boolean isOver() {
        return !playing;
    }

}
