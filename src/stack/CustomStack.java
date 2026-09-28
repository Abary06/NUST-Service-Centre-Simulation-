package stack;

public class CustomStack {
    private double[] stackArray;
    private int top;
    private int capacity;

    public CustomStack(int capacity) {
        this.capacity = capacity;
        this.stackArray = new double[capacity];
        this.top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public void push(double value) {
        if (isFull()) {
            double[] newArray = new double[capacity * 2];
            for (int i = 0; i < capacity; i++) {
                newArray[i] = stackArray[i];
            }
            stackArray = newArray;
            capacity = capacity * 2;
        }
        top++;
        stackArray[top] = value;
    }

    public double pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty.");
        }
        double value = stackArray[top];
        top--;
        return value;
    }

    public double peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty.");
        }
        return stackArray[top];
    }

    public void displayStack() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }

        System.out.println("Stack contents from top to bottom:");
        for (int i = top; i >= 0; i--) {
            System.out.println(stackArray[i]);
        }
    }

    public static double evaluatePostfix(String expression) {
        String[] tokens = expression.split("\\s+");
        CustomStack stack = new CustomStack(10);
        for (String token : tokens) {
            if (token.isEmpty()) {
                continue;
            }

            if (isNumber(token)) {
                stack.push(Double.parseDouble(token));
                System.out.println("Push " + token + " -> stack: " + stack.peek());
            } else {
                double operand2 = stack.pop();
                double operand1 = stack.pop();
                double result = applyOperator(operand1, operand2, token);
                stack.push(result);
                System.out.println("Apply " + token + " on " + operand1 + " and " + operand2 + " -> result " + result);
                stack.displayStack();
            }
        }

        return stack.pop();
    }

    private static boolean isNumber(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    private static double applyOperator(double left, double right, String operator) {
        switch (operator) {
            case "+":
                return left + right;
            case "-":
                return left - right;
            case "*":
                return left * right;
            case "/":
                if (right == 0) {
                    throw new ArithmeticException("Division by zero.");
                }
                return left / right;
            default:
                throw new IllegalArgumentException("Unsupported operator: " + operator);
        }
    }
}
