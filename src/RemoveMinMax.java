import java.util.Stack;

public class RemoveMinMax {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(30);
        stack.push(10);
        stack.push(20);
        stack.push(50);
        stack.push(40);

        removeMinMax(stack);
        System.out.println(stack);
    }

    public static void removeMinMax(Stack<Integer> stack) {
        if (stack.isEmpty()) return;

        Stack<Integer> tempStack = new Stack<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        // Encontrar min e max
        for (Integer num : stack) {
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
        }

        // Empilhar elementos, exceto min e max
        while (!stack.isEmpty()) {
            int current = stack.pop();
            if (current != min && current != max) {
                tempStack.push(current);
            }
        }

        // Voltar os elementos à pilha original
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }
}
