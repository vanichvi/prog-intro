package expression;

import java.math.BigInteger;

public class Subtract extends BinaryExpression {


    public Subtract(Element x, Element y) {
        super(x, y, "-");
    }

    @Override
    protected int compute(int x, int y) {
        return x - y;
    }

    @Override
    protected BigInteger compute(BigInteger x, BigInteger y) {
        return x.subtract(y);
    }

    @Override
    public int priority() {
        return 1;
    }

    @Override
    public boolean isAssociative() {
        return false;
    }

    @Override
    public boolean hasBrackets() {
        return false;
    }
}
