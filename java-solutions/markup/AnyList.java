package markup;

import java.util.List;

public class AnyList implements Listable {
    protected String OpenTag;
    protected String CloseTag;
    protected List<ListItem> elements;

    protected AnyList(List<ListItem> elements) {
        this.elements = elements;
    }

    @Override
    public void toBBCode(StringBuilder stringBuilder) {
        stringBuilder.append(OpenTag);
        for (ListItem elem : elements) {
            elem.toBBCode(stringBuilder);
        }
        stringBuilder.append(CloseTag);

    }
}
