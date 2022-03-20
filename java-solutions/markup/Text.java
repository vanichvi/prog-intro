package markup;

public class Text implements Markdownable {
    private final String word;

    public Text(String word) {
        this.word = word;
    }

    public void toMarkdown(StringBuilder stringBuilder) {
        stringBuilder.append(word);
    }

    public void toBBCode(StringBuilder stringBuilder) {
        stringBuilder.append(word);
    }

    public String toString() {
        return this.word;
    }
}
