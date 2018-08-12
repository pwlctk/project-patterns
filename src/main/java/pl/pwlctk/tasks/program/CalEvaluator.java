package pl.pwlctk.tasks.program;

public class CalEvaluator implements Evaluator {
    private final String REGEX = "(\\d+)\\s*(.)\\s*(\\d+)";
    private final CalParser calParser;

    CalEvaluator(Instruction instruction) {
        this.calParser = new CalParser(instruction.getArguments(), REGEX);
    }

    @Override
    public void evaluate() {
        calParser.parse();
        int number1 = calParser.getNumber1();
        int number2 = calParser.getNumber2();
        String operator = calParser.getOperator();
        switch (operator) {
            case "+":
                System.out.println(number1 + number2);
                break;
            case "-":
                System.out.println(number1 - number2);
                break;
            case "*":
                System.out.println(number1 * number2);
                break;
            case "/":
                divisionCal(number1, number2);
                break;
            default:
                System.out.println("Nieznany operator");
        }
    }

    private void divisionCal(int number1, int number2) {
        if (number2 == 0) {
            System.out.println("Przez 0 się nie dzieli!");
        } else {
            System.out.println((double) number1 / number2);
        }
    }
}
