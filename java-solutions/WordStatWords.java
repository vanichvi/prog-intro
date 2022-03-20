import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.TreeMap;

public class WordStatWords {
    public static void main(String[] args) throws IOException {

        String input = args[0];
        String output = args[1];
        Map<String, Integer> words = new TreeMap<>();

        try(FastScanner scanner = new FastScanner(new FileInputStream(input), StandardCharsets.UTF_8)) {

            while (scanner.hasNext()) {
                while (scanner.hasNextWordInLine()) {
                    String word = scanner.nextWord().toLowerCase();

                    words.put(word, words.getOrDefault(word, 0) + 1);
                }
                scanner.toNextLine();
            }
        }
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output), "utf8"))) {

            for (String word : words.keySet()) {
                bw.write(word + " " + words.get(word));
                bw.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

