package markup;

public interface Markdownable {
    void toMarkdown(StringBuilder stringBuilder);

    void toBBCode(StringBuilder stringBuilder);
}

