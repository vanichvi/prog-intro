package expression;

import java.math.BigInteger;

public class Min extends BinaryExpression{

    public Min(Element left, Element right){
        super(left, right, "min");
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
        return Math.min(x,y);
    }



    @Override
    protected BigInteger compute(BigInteger x, BigInteger y) {
        return x.min(y);
    }
}
