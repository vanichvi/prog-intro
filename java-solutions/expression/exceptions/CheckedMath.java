package expression.exceptions;

public class CheckedMath {

    public static int add(int x, int y) {
        if (y > 0 && x > Integer.MAX_VALUE - y || y < 0 && x < Integer.MIN_VALUE - y) {
            throw new ArithmeticException("overflow", x, y, "+");
        }
        return x + y;
    }

    public static int subtract(int x, int y) {
        if (y < 0 && x > Integer.MAX_VALUE + y || y > 0 && x < Integer.MIN_VALUE + y) {
            throw new ArithmeticException("overflow", x, y, "-");
        }
        return x - y;
    }

    public static int multiply(int x, int y) {
        if (x > y) {
            int max = x;
            x = y;
            y = max;
        }
        if (y > 0 && (x > Integer.MAX_VALUE / y || x < Integer.MIN_VALUE / y)
                || y < 0 && (x < Integer.MIN_VALUE / -y || x < Integer.MAX_VALUE / y)) {
            throw new ArithmeticException("overflow", x, y, "*");
        }
        return x * y;
    }

    public static int divide(int x, int y) {
        if (y == 0) {
            throw new ArithmeticException("division by zero", x, y, "/");
        }
        if (x == Integer.MIN_VALUE && y == -1) {
            throw new ArithmeticException("overflow", x, y, "/");
        }
        return x / y;
    }

    public static int max(int x, int y) {
//        if(x!=x || y!=y){
//            return 2%0;
//        }
        if (x > y) {
            return x;
        } else {
            return y;
        }

    }

    public static int min(int x, int y) {
        if (x < y) {
            return x;
        } else {
            return y;
        }
    }

    public static int pow(int x, int y) {
        if (x == 0 && y <= 0) {
            throw new ArithmeticException("unidentified", x, y, "**");
        } else if (x == 0 && y > 0) {
            return 0;
        } else if (x == 1 && y >= 0) {
            return 1;
        } else if (x == -1 && y >= 0) {

            return y % 2 == 0 ? -x : x;
        }
        int res = 1;
        if (y >= 0) {
            for (int i = 0; i < Math.abs(y); i++) {
                if (x > 0 && (res > Integer.MAX_VALUE / x || res < Integer.MIN_VALUE / x)
                        || x < 0 && (res < Integer.MIN_VALUE / -x || res < Integer.MAX_VALUE / x)) {
                    throw new ArithmeticException("overflow", x, y, "**");
                } else {
                    res *= x;
                }


            }
        } else {
            throw new ArithmeticException("unidentified", x, y, "**");
        }
//        System.err.println(res);
        return res;
    }

    public static int log(int x, int y) {
        if (y != 1 && y > 0 && x > 0) {
            int res = 0;
            while (x >= y) {
                x /= y;
                res += 1;
            }
            return res;
        } else {
            throw new ArithmeticException("unidentified", x, y, "**");
        }
    }

    public static int abs(int x) {
        if (x == Integer.MIN_VALUE) {
            throw new ArithmeticException("overflow", x, "abs");
        }
        if (x > 0) {
            return x;
        } else {
            return -x;
        }
    }

    public static int negate(int x) {
        if (x == Integer.MIN_VALUE) {
            throw new ArithmeticException("overflow", x, "-");
        }
        return -x;
    }
}
