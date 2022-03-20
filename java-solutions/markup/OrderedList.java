package markup;

import java.util.List;

public class OrderedList extends AnyList {
    public OrderedList(List<ListItem> elements) {
        super(elements);
        OpenTag = "[list=1]";
        CloseTag = "[/list]";
    }

    @Override
    public void toBBCode(StringBuilder stringBuilder) {
        super.toBBCode(stringBuilder);
    }
}
