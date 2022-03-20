package markup;

import java.util.List;

public class Strong extends Mark {
    public Strong(List<Markdownable> elements) {
        super(elements, "__",
                "[b]", "[/b]");


    }

    public void toMarkdown(StringBuilder stringBuilder) {
        super.toMarkdown(stringBuilder, MarkdownSymbol);
    }

    public void toBBCode(StringBuilder stringBuilder) {
        toBBCode(stringBuilder, BBCodeOpen, BBCodeClose);
    }


}
