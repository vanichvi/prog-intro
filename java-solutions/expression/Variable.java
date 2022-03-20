package expression;


import java.math.BigInteger;

public class Variable implements Element {
    String varName;

    public Variable(String varName) {
        this.varName = varName;
    }

    @Override
    public String toString() {
        return varName;
    }

    public int evaluate(int value) {
        return value;
    }


    @Override
    public boolean equals(Object object) {
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        Variable variable = (Variable) object;
        return this.varName.equals(variable.varName);
    }



    @Override
    public int hashCode() {
        return varName.hashCode();
    }

    @Override
    public int evaluate(int x, int y, int z) {
        switch (varName) {
            case ("x"):
                return x;
            case ("y"):
                return y;
            case ("z"):
                return z;
        }
        throw new IllegalArgumentException("Variable must be called x, y or z");
    }

    @Override
    public BigInteger evaluate(BigInteger x) {
        return x;
    }

}
