package expression;

import java.math.BigInteger;

public class Multiply extends BinaryExpression {
    public Multiply(Element x, Element y) {
        super(x, y, "*");
    }

    @Override
    protected int compute(int x, int y) {
        return x * y;
    }

    @Override
    protected BigInteger compute(BigInteger x, BigInteger y) {
        return x.multiply(y);
    }

    @Override
    public int priority() {
        return 2;
    }

    @Override
    public boolean isAssociative() {
        return true;
    }

    @Override
    public boolean hasBrackets() {
        return false;
    }
}
