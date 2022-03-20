package markup;

import java.util.List;

public class UnorderedList extends AnyList {
    public UnorderedList(List<ListItem> elements) {
        super(elements);
        OpenTag = "[list]";
        CloseTag = "[/list]";
    }
}
