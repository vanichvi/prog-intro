package game;

import java.util.Arrays;
import java.util.Map;

public class MnkBoard implements Board, Position {

    protected final int k;
    protected int emptyCells;
    protected Cell[][] field;
    protected Cell turn;

    protected static final Map<Cell, String> CELL_TO_STRING = Map.of(
            Cell.E, ".",
            Cell.X, "X",
            Cell.O, "0"
    );

    MnkBoard(int m, int n, int k) {

        this.k = k;

        if (m <= 0 || n <= 0 || k <= 0) {
            throw new IllegalArgumentException("M, N and k must be positive numbers");
        }
        if (k > Math.max(m, n)) {
            throw new IllegalArgumentException("M or N must be larger than k ");
        }
        field = new Cell[m][n];
        for (Cell[] row : field) {
            Arrays.fill(row, Cell.E);
        }
        turn = Cell.X;
        emptyCells = m * n;

    }

    public int getM() {
        return field.length;
    }

    public int getN() {
        return field[0].length;
    }

    @Override
    public Position getPosition() {
        return this;
    }


    protected boolean checkWin(Move move) {
        int cnt=0;
        for (int i = 0; i < getM(); i++) {
            for (int j = 0; j < getN(); j++) {
                for (int l = 0; l < k; l++) {
                    if (field[i][j]==turn){
                       cnt++;
                    }
                    if(cnt==k){
                        return true;
                    }
                }
                cnt=0;
            }
        }
        return false;
    }


    @Override
    public GameResult makeMove(Move move) {
        if (!isValid(move)) {
            return GameResult.LOOSE;

        }
        emptyCells--;

        field[move.getRow()][move.getCol()] = move.getValue();
        turn = turn == Cell.X ? Cell.O : Cell.X;


        if (checkWin(move)) {
            return GameResult.WIN;
        }

        if (emptyCells == 0) {
            return GameResult.DRAW;
        }

        return GameResult.UNKNOWN;

    }


    @Override
    public void clear() {
        for (int i = 0; i < getM(); i++) {
            for (int j = 0; j < getN(); j++) {
                field[i][j] = Cell.E;
            }
        }
        emptyCells = getM() * getN();
    }

    @Override
    public Cell getTurn() {
        return turn;
    }

    @Override
    public boolean isValid(Move move) {
        int row = move.getRow();
        int col = move.getCol();
        return row >= 0 && col >= 0
                && row < getM()
                && col < getN() && field[row][col] == Cell.E;
    }

    @Override
    public Cell getCell(int row, int column) {
        return field[row][column];
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < getN(); i++) {
            sb.append(Integer.toString(i));
        }
        sb.append(System.lineSeparator());
        for (int r = 0; r < getM(); r++) {
            sb.append(r + 1);
            for (Cell cell : field[r]) {
                sb.append(CELL_TO_STRING.get(cell));
            }
            sb.append(System.lineSeparator());
        }
        sb.setLength(sb.length() - System.lineSeparator().length());
        return sb.toString();
    }
}
