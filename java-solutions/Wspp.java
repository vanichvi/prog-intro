import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Wspp {
    public static void main(String[] args) {
        String input = args[0];
        String output = args[1];
        HashMap<String, IntList> words = new LinkedHashMap<>();

        try (FastScanner reader = new FastScanner(new FileInputStream(input), StandardCharsets.UTF_8)) {

            int n = 1;
            while (reader.hasNext()) {
                while (reader.hasNextWordInLine()) {
                    String word = reader.nextWord().toLowerCase();
                    IntList position = words.get(word);

                    if (position == null) {
                        words.put(word, new IntList());
                        words.get(word).add(0);
                    }
                    words.get(word).set(0, words.get(word).get(0) + 1);

                    words.get(word).add(n);
                    n++;
                }
                reader.toNextLine();
            }
        } catch (IOException e) {
            System.out.println("Error in reader: " + e.getMessage());
        }

        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output), StandardCharsets.UTF_8))) {

            for (String word : words.keySet()) {
                bw.write(word);
                for (int i = 0; i < words.get(word).getLength(); i++) {
                    if (words.get(word).get(i) != 0) {
                        bw.write(" " + words.get(word).get(i));
                    }
                }
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error in writer: " + e.getMessage());

        }
    }
}

