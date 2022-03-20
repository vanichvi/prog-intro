package expression.exceptions;

import expression.Element;
import expression.Negate;

public class CheckedNegate extends Negate {
    public CheckedNegate(Element expression) {
        super(expression);
    }

    @Override
    protected int compute(int x) {
        return CheckedMath.negate(x);
    }
}
