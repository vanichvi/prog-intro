package expression.parser;

import expression.*;

import java.util.Map;

public class ExpressionParser extends BaseParser implements Parser {
    private static final Map<String, Integer> TAGS_PRIORITY = Map.of(
            "min", 0,
            "max", 0,
            "+", 1,
            "-", 1,
            "*", 2,
            "/", 2
    );

    @Override
    public TripleExpression parse(String expression) {
        source= new StringSource(expression);
        take();
        return parse(-1);
    }

    private Element parse(int priority) {
        if (priority > 2) {
            return parseExpression();
        }
        Element first = parse(priority + 1);

        while (TAGS_PRIORITY.containsKey(String.valueOf(ch))
                && TAGS_PRIORITY.get(String.valueOf(ch)) == priority
                || (ch == 'm' && priority == 0)) {
            String operator = getOperator();

            Element second = parse(priority + 1);
            first = parseBinary(first, second, operator);
        }
        return first;

    }

    private Element parseExpression() {
        skipWhitespace();
        Element expression;
        if (take('(')) {
            expression = parse(-1);
            expect(')');

        } else if (between('0', '9')) {
            expression = parseConst("+");

        } else if (take('-')) {
            if (between('0', '9')) {
                expression = parseConst("-");
            } else {
                expression = new Negate(parseExpression());
            }
        } else if (take('t')) {
            expect('0');
            expression = new ZeloesT(parseExpression());

        } else if (take('l')) {
            expect('0');
            expression = new ZeroesL(parseExpression());
        } else {
            expression = parseVariable();
        }
        skipWhitespace();
        return expression;

    }

    private Const parseConst(String sign) {

        StringBuilder constant = new StringBuilder();
        constant.append(sign);
        while (between('0', '9') && !eof()) {
            constant.append(take());

        }
        return new Const(Integer.parseInt(constant.toString()));
    }

    private Variable parseVariable() {
        return new Variable(Character.toString(take()));
    }

    private Element parseBinary(Element left, Element right, String operator) {

        switch (operator) {
            case "max":
                return new Max(left, right);
            case "min":
                return new Min(left, right);
            case "**":
                return new Pow(left, right);
            case "//":
                return new Log(left, right);
            case "+":
                return new Add(left, right);
            case "-":
                return new Subtract(left, right);
            case "*":
                return new Multiply(left, right);
            default:
                return new Divide(left, right);

        }

    }
    
    private String getOperator() {
        String operator = "";
        if (!eof()) {
            Integer value = TAGS_PRIORITY.get(String.valueOf(ch));
            if (value != null || ch == 'm') {
                operator = String.valueOf(ch);
                if (operator.equals("m")) {
                    take();
                    if (take('i')) {

                        expect('n');
                        operator = "min";
                    } else if (take('a')) {
                        expect('x');
                        operator = "max";
                    }
                } else {
                    expect(operator);
                }
            }
        }
        return operator;
    }


    private void skipWhitespace() {
        while (Character.isWhitespace(ch)) {
            take();
            //skip
        }
    }
}

