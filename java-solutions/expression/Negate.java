package expression;

import java.math.BigInteger;

public class Negate extends UnaryExpression{

    public Negate(Element expression){
        super(expression, "-");
    }

    @Override
    protected int compute(int x) {
        return -x;
    }

    @Override
    public int priority() {
        return 3;
    }

    @Override
    protected BigInteger compute(BigInteger x) {
        return x.negate();
    }

}
