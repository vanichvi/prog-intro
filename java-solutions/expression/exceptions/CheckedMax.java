package expression.exceptions;

import expression.Element;
import expression.Max;


public class CheckedMax extends Max {
    public CheckedMax(Element left, Element right) {
        super(left, right);
    }

    @Override
    protected int compute(int x, int y){
        return CheckedMath.max(x, y);
    }

}
