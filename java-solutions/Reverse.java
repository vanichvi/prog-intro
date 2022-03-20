
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Reverse {
    public static void main(String[] args) throws IOException {
        FastScanner scanner = new FastScanner(System.in, StandardCharsets.UTF_8);
        ArrayList<String> sheet = new ArrayList<>();
        while (scanner.hasNext()) {

            sheet.add(System.lineSeparator());

            while (scanner.hasNextIntInLine()) {
                sheet.add(Integer.toString(scanner.nextInt()).concat(" "));
//                System.out.println(sheet);
            }
            scanner.toNextLine();
        }
        for (int i = sheet.size() - 1; i >= 0; i--) {
            System.out.print(sheet.get(i));
        }

    }
}

