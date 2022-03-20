package expression.exceptions;

import expression.Element;
import expression.Divide;

public class CheckedDivide extends Divide {
    public CheckedDivide(Element x, Element y) {
        super(x, y);
    }

    @Override
    protected int compute(int x, int y) {
        return CheckedMath.divide(x,y);
    }
}
