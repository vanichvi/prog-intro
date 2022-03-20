package markup;

import java.util.List;

public class Emphasis extends Mark {
    public Emphasis(List<Markdownable> elements) {
        super(elements, "*",
                "[i]", "[/i]");

    }

    public void toMarkdown(StringBuilder stringBuilder) {
        super.toMarkdown(stringBuilder, MarkdownSymbol);
    }

    public void toBBCode(StringBuilder stringBuilder) {
        toBBCode(stringBuilder, BBCodeOpen, BBCodeClose);
    }

}
