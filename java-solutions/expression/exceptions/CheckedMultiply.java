package expression.exceptions;

import expression.Element;
import expression.Multiply;

public class CheckedMultiply extends Multiply {
    public CheckedMultiply(Element x, Element y) {
        super(x, y);
    }

    @Override
    protected int compute(int x, int y) {
        return CheckedMath.multiply(x,y);
    }

}
