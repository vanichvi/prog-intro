package game;

public class HexBoard extends MnkBoard {
    HexBoard(int m, int k) {
        super(m, m, k);
    }

    @Override
    protected boolean checkWin(Move move) {
        int cnt = 0;
        for (int i = 0; i < getM(); i++) {
            for (int j = 0; j < getN(); j++) {
                for (int l = 0; l < k; l++) {
                    if (field[i][j] == turn) {
                        cnt++;
                    }
                    if (cnt == k) {
                        return true;
                    }
                }
                cnt = 0;
            }
        }
        return false;
    }

//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        int spaces=getM();
//        for (int i = 0; i < getM(); i++) {
//
//            sb.append(String.format("%" + spaces + "s ", " "));
//            spaces-=1;
//            sb.append((i + 1) + " ");
//            sb.append(getDiagUp(i));
//            sb.append((i + 1));
//            sb.append(System.lineSeparator());
//        }
//        spaces+=Integer.toString(getM()).length() +1;
//        for (int j = getM()-2; j >= 0; j--) {
//
//            sb.append(String.format("%" + spaces + "s ", " "));
//            spaces+=1;
//            sb.append((getM() - j) + " ");
//            sb.append(getDiagDown(j));
//            sb.append((getM() - j));
//            sb.append(System.lineSeparator());
//        }
//        return sb.toString();
//    }

//    private String getDiagUp(int i) {
//        StringBuilder sb = new StringBuilder();
//        for (int j = 0; j < i + 1; j++) {
//            sb.append(CELL_TO_STRING.get(field[i-j][j]) + " ");
//        }
//        return sb.toString();
//    }
//
//    private String getDiagDown(int i) {
//        StringBuilder sb = new StringBuilder();
//        for (int j = 0; j < i+1 ; j++) {
//            sb.append(CELL_TO_STRING.get(field[getM()-1-i+j][i-j]) + " ");
//        }
//        return sb.toString();
//    }
}
