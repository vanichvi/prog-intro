package expression.exceptions;

import expression.Element;
import expression.Pow;

public class CheckedPow extends Pow {
    public CheckedPow(Element left, Element right) {
        super(left, right);
    }

    @Override
    protected int compute(int x, int y) {
        return CheckedMath.pow(x,y);
    }
}
