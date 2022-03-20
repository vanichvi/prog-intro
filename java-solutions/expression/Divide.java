package expression;

import java.math.BigInteger;

public class Divide extends BinaryExpression {
    public Divide(Element x, Element y) {
        super(x, y, "/");
    }

    @Override
    protected int compute(int x, int y) {
        return x / y;
    }

    @Override
    protected BigInteger compute(BigInteger x, BigInteger y) {
        return x.divide(y);
    }

    @Override
    public int priority() {
        return 2;
    }

    @Override
    public boolean isAssociative() {
        return false;
    }

    @Override
    public boolean hasBrackets() {
        return true;
    }
}
