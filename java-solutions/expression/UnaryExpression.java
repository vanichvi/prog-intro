package expression;

import java.math.BigInteger;

abstract class UnaryExpression implements AnyExpression {
    protected final Element expression;

    protected abstract int compute(int x);

    protected abstract BigInteger compute(BigInteger x);

    private final String tag;

    public UnaryExpression(Element exp, String tag) {
        this.expression = exp;
        this.tag = tag;
    }

    @Override
    public int evaluate(int x) {
        return compute(expression.evaluate(x));
    }

    @Override
    public BigInteger evaluate(BigInteger x) {
        return compute(expression.evaluate(x));
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return compute(expression.evaluate(x, y, z));
    }

    @Override
    public String toString() {
        return tag +
                "(" + expression.toString() +
                ")";
    }

    @Override
    public String toMiniString() {
        if (expression instanceof BinaryExpression) {
            return tag + "(" + expression.toMiniString() + ")";
        } else {
            return tag + " " + expression.toMiniString();
        }
    }
}