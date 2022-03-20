package expression;

import java.math.BigInteger;

public class ZeloesT extends UnaryExpression {

    public ZeloesT(Element expression) {
        super(expression, "t0");
    }

    @Override
    protected int compute(int x) {
        return Integer.numberOfTrailingZeros(x);
    }

    @Override
    protected BigInteger compute(BigInteger x) {
        throw new UnsupportedOperationException("");
    }

    @Override
    public int priority() {
        return 3;
    }
}
