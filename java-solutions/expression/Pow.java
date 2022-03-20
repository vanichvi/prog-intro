package expression;

import java.math.BigInteger;

public class Pow extends BinaryExpression {
    public Pow(Element left, Element right) {
        super(left, right, "**");
    }

    @Override
    public int priority() {
        return 3;
    }

    @Override
    protected boolean hasBrackets() {
        return false;
    }

    @Override
    protected boolean isAssociative() {
        return false;
    }

    @Override
    protected int compute(int x, int y) {
        return (int) Math.pow(x, y);
    }

    @Override
    protected BigInteger compute(BigInteger x, BigInteger y) {
        throw new UnsupportedOperationException();
    }
}
