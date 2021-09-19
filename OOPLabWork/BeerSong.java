//Jamie Baggott R00149982


import java.util.Scanner;

public class BeerSong {
    public static void main(String[] args) {
        //int beerNum = 99;
        System.out.println("Enter a number: ");
        Scanner scan = new Scanner(System.in);
        int beerNum = scan.nextInt();
        String word = "bottles";

        while (beerNum > 0) {

            System.out.println(beerNum + " " + word + " of beer on the wall, " + beerNum + " " + word + " of beer");
            beerNum = beerNum - 1;

            if (beerNum == 1) {
                word = "bottle";
            }

            if (beerNum > 0) {
                System.out.println("Take one down, pass it round " + beerNum + " " + word + " of beer");
            }
        }

        if (beerNum == 0) {
            System.out.println("No more bottles of beer");
        }
    }
}