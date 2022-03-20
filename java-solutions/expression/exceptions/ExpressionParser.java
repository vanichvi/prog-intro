package expression.exceptions;

import expression.*;

import java.util.Map;

public class ExpressionParser extends BaseParser implements Parser {
    private static final Map<String, Integer> TAGS_PRIORITY = Map.of(
            "min", 0,
            "max", 0,
            "+", 1,
            "-", 1,
            "*", 2,
            "/", 2,
            "**", 3,
            "//", 3
    );

    @Override
    public Element parse(String expression) throws ParseException {
        makeSource(expression);
        Element res = parse(0);
        if (!eof() || ch == ')') {
            throw new ParseException("missing bracket or empty expression");
        }
        return res;
    }

    private Element parse(int priority) throws ParseException {
        if (priority > 3) {
            return parseExpression();
        }

        Element left = parse(priority + 1);

        while (isTag(priority)) {
            String operator = getOperator();
            Element right = parse(priority + 1);
            left = parseBinary(left, right, operator);
        }
        return left;
    }


    private Element parseExpression() throws ParseException {
        skipWhitespace();
        Element expression;
        if (take('(')) {
            expression = parse(0);
//            skipWhitespace();
            expect(')');

        } else if (between('0', '9')) {
            expression = parseConst("+");

        } else if (take('-')) {
//            skipWhitespace();
            if (eof() || ch == ')') {
                throw new ParseException("argument for unary operation");
            }
            if (between('0', '9')) {
                expression = parseConst("-");
            } else {
                expression = new CheckedNegate(parseExpression());
            }
        } else if (take('a')) {
            expect("bs");
            return new CheckedAbs(parseExpression());
        } else {
            expression = parseVariable();
        }
        skipWhitespace();

        return expression;

    }

    private Const parseConst(String sign) throws ParseException {

        StringBuilder constant = new StringBuilder();
        constant.append(sign);
        while (between('0', '9') && !eof()) {
            constant.append(take());

        }
        skipWhitespace();
        if (between('0', '9')) {
            throw new ParseException("space in number exception");
        }
        try {
            Integer.parseInt(constant.toString());
        } catch (NumberFormatException e) {
            throw new ParseException("constant overflow");
        }
        return new Const(Integer.parseInt(constant.toString()));
    }

    private Variable parseVariable() throws ParseException {
        StringBuilder sb = new StringBuilder();
        while ((isLetter() || between('0', '9')) && !Character.isWhitespace(ch) && !eof()) {
            sb.append(take());
        }
        String item = sb.toString();
        if (item.equals("x") || item.equals("y") || item.equals("z")) {
            return new Variable(item);
        } else if (item.equals("")) {
            if (ch == ')') {
                throw new ParseException("variable/constant/unary operation inside brackets");
            }
            throw new ParseException(
                    "no argument found");
        } else {
            throw new ParseException("invalid variable name");
        }
    }

    private boolean isTag(Integer priority) {
//        if (ch == '*') {
////            take();
//            if (next() == '*') {
//                return priority == 3;
//            } else {
//                return priority == 2;
//            }
//        } else if (ch == '/') {
////            take();
//            if (next() == '/') {
//                return priority == 3;
//            } else {
//                return priority == 2;
//            }
//        } else {
//            Integer value = TAGS_PRIORITY.get(String.valueOf(ch));
//
//            return value != null && value.equals(priority)
//                    || (ch == 'm' && priority == 0)
//
//                    ;
//        }
        for (var current : TAGS_PRIORITY.entrySet()) {
            if (test(current.getKey())) {
                if (priority == null) {
                    return true;
                }
                return current.getValue().equals(priority);
            }
        }
        return false;

}


    private String getOperator() {
//        String operator = "";
//        if (!eof()) {
//            Integer value = TAGS_PRIORITY.get(String.valueOf(ch));
//            if (value != null || ch == 'm') {
//                operator = String.valueOf(ch);
//                if (operator.equals("m")) {
//                    take();
//                    if (take('i')) {
//
//                        expect('n');
//                        operator = "min";
//                    } else if (take('a')) {
//                        expect('x');
//                        operator = "max";
//                    }
//                } else if (operator.equals("*")) {
//                    take();
//                    if (take('*')) {
//                        operator = "**";
//                    } else {
//                        operator = "*";
//                    }
//                } else if (operator.equals("/")) {
//                    take();
//                    if (take('/')) {
//                        operator = "//";
//                    } else {
//                        operator = "/";
//                    }
//                } else {
//                    expect(operator);
//                }
//            }
//        }
        String operator = "";
        for (var current : TAGS_PRIORITY.entrySet()) {
            if (test(current.getKey())) {
                operator = current.getKey();
                expect(operator);
                break;
            }
        }
        return operator;
    }


    private Element parseBinary(Element left, Element right, String operator) {

        switch (operator) {
            case "max":
                return new CheckedMax(left, right);
            case "min":
                return new CheckedMin(left, right);
            case "**":
                return new CheckedPow(left, right);
            case "//":
                return new CheckedLog(left, right);
            case "+":
                return new CheckedAdd(left, right);
            case "-":
                return new CheckedSubtract(left, right);
            case "*":
                return new CheckedMultiply(left, right);
//                }
            case "/":
//
                return new CheckedDivide(left, right);
//
        }
        throw new UnsupportedOperationException("Unknown operation");
    }


    private void skipWhitespace() {
        while (Character.isWhitespace(ch)) {
            take();
            //skip
        }
    }
}

