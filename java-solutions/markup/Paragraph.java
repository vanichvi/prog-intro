package markup;

import java.util.List;

public class Paragraph implements Listable {

    List<Markdownable> elements;

    public Paragraph(List<Markdownable> elements) {
        this.elements = elements;
    }

    public void toMarkdown(StringBuilder stringBuilder) {
        for (Markdownable element : elements) {
            element.toMarkdown(stringBuilder);

        }
    }

    public void toBBCode(StringBuilder stringBuilder) {
        for (Markdownable element : elements) {
            element.toBBCode(stringBuilder);
        }
    }
}
