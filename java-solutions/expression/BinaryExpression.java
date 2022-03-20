package expression;


import java.math.BigInteger;
import java.util.Objects;

abstract class BinaryExpression implements AnyExpression {
    private final Element left;
    private final Element right;
    private final String tag;

    protected abstract boolean hasBrackets();
    protected abstract boolean isAssociative();



    protected abstract int compute(int x, int y);

    abstract protected BigInteger compute(BigInteger x, BigInteger y);

    public BinaryExpression(Element x, Element y, String tag) {
        this.left = x;
        this.right = y;
        this.tag = tag;
    }

    @Override
    public int evaluate(int x) {
        return compute(left.evaluate(x), right.evaluate(x));
    }

    @Override
    public BigInteger evaluate(BigInteger x) {
        return compute(left.evaluate(x), right.evaluate(x));
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return compute(left.evaluate(x, y, z), right.evaluate(x, y, z));
    }

    public boolean equals(Object expression) {
        if (expression == null || expression.getClass() != getClass()) {
            return false;
        }
        BinaryExpression exp = (BinaryExpression) expression;
        return Objects.equals(this.left, exp.left) &&
                Objects.equals(this.right, exp.right);
    }

    public int hashCode() {
        return Objects.hash(left, right, tag);
    }

    public String toString() {
        return "(" + left + " " + tag + " " + right + ")";
    }

    private String appendBrackets(boolean brackets, String exp) {
        if (brackets) {
            return "(" + exp + ")";
        }
        return exp;
    }

    @Override
    public String toMiniString() {
        String left;
        String right;
        if (this.left instanceof BinaryExpression leftExp) {
            left = appendBrackets(leftExp.priority() < priority(), leftExp.toMiniString());
            } else {
            left = this.left.toMiniString();
        }
//        System.err.println(left);
        if (this.right instanceof BinaryExpression rightExp) {
            right = appendBrackets(rightExp.priority() < priority()
                            || (rightExp.priority() == priority() && (!this.isAssociative() || rightExp.hasBrackets())),
                    rightExp.toMiniString());
        } else {
            right = this.right.toMiniString();
        }
//        System.err.println(right);
        return left + " " + tag + " " + right;

    }


}
