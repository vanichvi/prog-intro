package game;

import java.util.EmptyStackException;
import java.util.Scanner;

public class HumanPlayer implements Player {
    private final Scanner in;

    public HumanPlayer(Scanner in) {
        if (in == null) {
            throw new IllegalArgumentException("Input IO stream");
        }
        this.in = in;
    }

    private Integer address() {
        if (in.hasNextInt()) {
            return in.nextInt();
        }
        if (in.hasNext()) {
            String str;
            do {
                str = in.nextLine();
            } while (str.isEmpty());
            return null;
        }
        throw new EmptyStackException();
    }

    @Override
    public Move makeMove(Position position) {
        System.out.println();
        System.out.println("Current position");
        System.out.println(position);
        System.out.println("Enter you move for " + position.getTurn());

        Integer row = null;
        Integer col = null;

        while (row == null || col == null) {

            row = address();
            if (row == null) {
                System.err.println("Invalid address, try again ");
                continue;
            }

            col = address();
            if (col == null) {
                System.err.println("Invalid address, try again");
            }
        }
        return new Move(row - 1, col - 1, position.getTurn());
    }
}
