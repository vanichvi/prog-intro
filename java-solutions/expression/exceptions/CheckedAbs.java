package expression.exceptions;

import expression.Abs;
import expression.Element;

public class CheckedAbs extends Abs {
    public CheckedAbs(Element expression) {
        super(expression);
    }

    @Override
    protected int compute(int x) {
        return CheckedMath.abs(x);
    }

}
