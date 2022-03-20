package expression;


import java.math.BigInteger;

public class Const implements Element {
    private final Number value;

    public Const(int x) {
        value = x;

    }

    public Const(BigInteger x) {
        value = x;

    }

    public String toString() {
        return value.toString();
    }

    public int evaluate(int x) {
        return (int) value;
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return value.intValue();
    }

    @Override
    public BigInteger evaluate(BigInteger x) {
        return (BigInteger) value;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Const constObject = (Const) object;
        return this.value.equals(constObject.value);
    }

    public int hashCode() {
        return value.hashCode();
    }


}
