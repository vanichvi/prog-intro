package game;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        Tournament tournament = new Tournament(List.of(
                new HumanPlayer(scanner),
                new RandomPlayer(),
                new RandomPlayer()
                ),
                new MnkBoard(8,18, 6));
        tournament.play(false);
        System.out.println(tournament);

    }

}

