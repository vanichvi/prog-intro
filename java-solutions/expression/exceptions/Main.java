package expression.exceptions;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException{
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        expression.exceptions.ExpressionParser parser =new ExpressionParser();
        System.out.println(parser.parse(expression).toMiniString());
        System.out.println(Integer.MIN_VALUE);
    }
}
