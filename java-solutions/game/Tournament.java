package game;

import java.util.List;

public class Tournament {
    private final int[] scoreTable;
    private final int[][] matches;
    private final List<Player> players;
    private final Board board;

    public Tournament(List<Player> players, Board board) {
        scoreTable = new int[players.size()];
        this.board = board;
        this.players = players;

        matches = new int[players.size()][players.size()];
//        printMatches(players);
    }

//    public void printMatches(List<Player> players) {//FIX
//        for (int i = 0; i < players.size(); i++) {
//            System.out.println(Arrays.toString(matches[i]));
//        }
//    }

    public void play(boolean log) {
        for (int i = 0; i < players.size(); i++) {
            for (int j = 0; j < players.size(); j++) {
                if (i != j && matches[i][j] == 0) {
                    playDuel(i, j, log);
                    playDuel(j, i, log);
                }
            }
        }

    }

    private void playDuel(int i, int j, boolean log) {
        TwoPlayerGame game = new TwoPlayerGame(board, players.get(i), players.get(j));
        int result = game.play(log);
//        System.out.println(result);

        matches[i][j] = 1;
        matches[j][i] = 1;

        switch (result) {
            case 1:
                scoreTable[i] += 3;
//                System.err.println("X player won round");
                break;
            case 2:
                scoreTable[j] += 3;
//                System.err.println("O player won round");
                break;
            case 0:
                scoreTable[i] += 1;
                scoreTable[j] += 1;
//                System.err.println("Draw");
                break;
        }
//        System.out.println(Arrays.toString(scoreTable));
//        System.out.println();
//        printMatches(players);
        board.clear();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < players.size(); i++) {

            sb.append("Player " + (i + 1) + "  ").append(scoreTable[i]).append(" ");

            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}
