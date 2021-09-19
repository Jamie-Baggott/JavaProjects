//Jamie Baggott R00149982

public class Game {
    private String name;
    private String genre;
    private int players;

    public Game(String s, String g, int p) {
        this.name = s;
        this.genre = g;
        this.players = p;
    }

   public void setName(String s) {
        name = s;
    }

    public void play() {
        System.out.println("PLaying Game");
    }

    public void play(int p) {
        System.out.println("PLaying Game with " + p + " friends");
    }

    public String toString(int p) {
         return name;
        }
        public void sayDetails() {
           System.out.println("The game is " + name + ", it is a " + genre + " type game. There are " + players + " number of people playing");

        // }
//}
    }
}