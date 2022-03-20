import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;

public class WsppSecondG {
    public static void main(final String[] args) {
        final String input = args[0];
        final String output = args[1];

        final Map<String, IntList> words = new LinkedHashMap<>();
        final Map<String, Integer> numberInLine = new LinkedHashMap<>();

        try (final FastScanner reader = new FastScanner(new FileInputStream(input), StandardCharsets.UTF_8)) {

            int wordsCount = 1;

            while (reader.hasNext()) {

                while (reader.hasNextWordInLine()) {
                    final String word = reader.nextWord().toLowerCase();

                    IntList positions = words.get(word);
                    if (positions == null) {
                        positions = new IntList();
                        words.put(word, positions);
                        positions.add(0);
                    }
                    positions.set(0, positions.get(0) + 1);
                    final int index = numberInLine.getOrDefault(word, 0) + 1;
                    numberInLine.put(word, index);
                    // :NOTE:
                    //Фильтрация
                    if (index % 2 == 0) {
                        positions.add(wordsCount);
                    }

                    wordsCount++;
                }

                reader.toNextLine();
                numberInLine.clear();
            }
        } catch (final IOException e) {
            System.out.println("Error in reader: " + e.getMessage());
        }

        try (final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output), StandardCharsets.UTF_8))) {

            for (final String word : words.keySet()) {
                bw.write(word);
                for (int i = 0; i < words.get(word).getLength(); i++) {
                    if (words.get(word).get(i) != 0) {
                        bw.write(" " + words.get(word).get(i));
                    }

                }

                bw.newLine();
            }
        } catch (final IOException e) {
            System.out.println("Error in writer: " + e.getMessage());

        }
    }
}
