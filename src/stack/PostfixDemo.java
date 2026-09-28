package stack;

public class PostfixDemo {
    public static void main(String[] args) {
        System.out.println("Postfix evaluation demonstration");
        double result = CustomStack.evaluatePostfix("5 3 + 2 *");
        System.out.println("Final result: " + result);
    }
}
