package markup;

import java.util.List;

public class ListItem {
    List<Listable> elements;
    String Tag = "[*]";

    public ListItem(List<Listable> elements) {
        this.elements = elements;
    }

    public void toBBCode(StringBuilder stringBuilder) {
        stringBuilder.append(Tag);

        for (Listable el : this.elements) {
            el.toBBCode(stringBuilder);

        }
    }
}
