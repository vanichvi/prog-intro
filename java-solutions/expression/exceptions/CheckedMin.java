package expression.exceptions;

import expression.Element;
import expression.Min;

public class CheckedMin extends Min {
    public CheckedMin(Element left, Element right) {
        super(left, right);
    }

    @Override
    protected int compute(int x, int y) {
        return CheckedMath.min(x,y);
    }
}
