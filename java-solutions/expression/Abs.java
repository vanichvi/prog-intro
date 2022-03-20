package expression;

import java.math.BigInteger;

public class Abs extends UnaryExpression {
    public Abs(Element expression) {
        super(expression, "abs");
    }

    @Override
    protected int compute(int x) {
        return Math.abs(x);
    }

    @Override
    public int priority() {
        return 3;
    }

    @Override
    protected BigInteger compute(BigInteger x) {
        return x.abs();
    }
}
