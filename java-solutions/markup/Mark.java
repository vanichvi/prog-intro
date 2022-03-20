package markup;

import java.util.List;

abstract class Mark implements Markdownable {
    protected String MarkdownSymbol;
    protected String BBCodeOpen;
    protected String BBCodeClose;

    protected List<Markdownable> elements;

    protected Mark(List<Markdownable> elements, String MarkdownSymbol
            , String BBCodeOpen, String BBCodeClose) {
        this.elements = elements;
        this.MarkdownSymbol = MarkdownSymbol;
        this.BBCodeOpen = BBCodeOpen;
        this.BBCodeClose = BBCodeClose;
    }

    protected void toMarkdown(StringBuilder stringBuilder, String symbol) {
        stringBuilder.append(symbol);
        for (Markdownable element : elements) {
            element.toMarkdown(stringBuilder);

        }
        stringBuilder.append(symbol);
    }

    protected void toBBCode(StringBuilder stringBuilder, String open, String close) {
        stringBuilder.append(open);
        for (Markdownable element : elements) {
            element.toBBCode(stringBuilder);

        }
        stringBuilder.append(close);
    }
}
