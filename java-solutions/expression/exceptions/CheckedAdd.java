package expression.exceptions;

import expression.Add;
import expression.Element;

import java.math.BigInteger;

public class CheckedAdd extends Add {
    public CheckedAdd(Element x, Element y) {
        super(x, y);
    }

    @Override
    protected int compute(int x, int y){
        return CheckedMath.add(x,y);
    }

    @Override
    protected BigInteger compute(BigInteger x, BigInteger y){
        throw new ArithmeticException("unsopperted operation", x.intValue(), y.intValue(), "+");
    }
}
