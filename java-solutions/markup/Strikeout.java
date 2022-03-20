package markup;

import java.util.List;

public class Strikeout extends Mark {
    public Strikeout(List<Markdownable> elements) {
        super(elements,"~","[s]","[/s]");


    }

    public void toMarkdown(StringBuilder stringBuilder) {
        super.toMarkdown(stringBuilder, MarkdownSymbol);

    }

    public void toBBCode(StringBuilder stringBuilder) {
        toBBCode(stringBuilder, BBCodeOpen, BBCodeClose);
    }


}
