package expression;

import java.math.BigInteger;

public class ZeroesL extends UnaryExpression{

    public ZeroesL(Element expression){
        super(expression, "l0");
    }
    @Override
    protected int compute(int x) {
        return Integer.numberOfLeadingZeros(x);
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
