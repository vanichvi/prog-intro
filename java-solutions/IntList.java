import java.util.Arrays;

public class IntList {
    private int[] list = new int[32];
    private int listIndex = 0;

    public IntList() {

    }

    public void add(int value) {
        if (listIndex >= list.length) {
            int[] newList = Arrays.copyOf(list, list.length * 2);
            newList[list.length] = value;
            list = newList;
        } else {
            list[listIndex] = value;
        }
        listIndex++;
    }

    public void set(int index, int value) {
        list[index] = value;

    }

    public int get(int index) {
        return list[index];
    }

    public int getLength() {
        return list.length;
    }

}
