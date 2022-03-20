package expression.exceptions;

import expression.Element;
import expression.Log;

public class CheckedLog extends Log {
    public CheckedLog(Element left, Element right) {
        super(left, right);
    }

    @Override
    protected int compute(int x, int y) {
        return CheckedMath.log(x,y);
    }
}
