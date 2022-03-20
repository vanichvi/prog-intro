package expression;

import java.math.BigInteger;

public class Add extends BinaryExpression{


    public Add(Element x, Element y) {
        super(x, y, "+");
    }

    @Override
    protected int compute(int x, int y) {
        return x + y;
    }

    @Override
    protected BigInteger compute(BigInteger x, BigInteger y) {
        return x.add(y);
    }

    @Override
    public int priority() {
        return 1;
    }

    @Override
    public boolean isAssociative() {
        return true;
    }


    public boolean hasBrackets() {
        return false;
    }
}
