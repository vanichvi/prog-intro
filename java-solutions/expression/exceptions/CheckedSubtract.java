package expression.exceptions;

import expression.Element;
import expression.Subtract;

public class CheckedSubtract extends Subtract {
    public CheckedSubtract(Element x, Element y) {
        super(x, y);
    }

    @Override
    protected int compute(int x, int y) {
        return CheckedMath.subtract(x,y);
    }
}
