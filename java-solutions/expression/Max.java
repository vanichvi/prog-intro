package expression;

import java.math.BigInteger;

public class Max extends BinaryExpression{

    public Max(Element left, Element right){
        super(left, right, "max");

    }
    @Override
    public int priority() {
        return 0;
    }

    @Override
    protected boolean hasBrackets() {
        return false;
    }

    @Override
    protected boolean isAssociative() {
        return true;
    }

    @Override
    protected int compute(int x, int y) {
        return Math.max(x, y);
    }

    @Override
    protected BigInteger compute(BigInteger x, BigInteger y) {
        return x.max(y);
    }
}
