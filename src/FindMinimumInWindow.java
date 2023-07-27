import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;
import java.util.Stack;

public class FindMinimumInWindow {

    public static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        public int getFirst() {
            return first;
        }


        public int getSecond() {
            return second;
        }

    }

    void solve(Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        Stack<Pair> popStack = new Stack<>();
        Stack<Pair> putStack = new Stack<>();
        int[] arrayMins = new int[n - m + 1];

        for (int i = 0; i < m; i++) {
            pushToStack(putStack, in.nextInt());
        }
        arrayMins[0] = findMin(putStack, popStack);

        for (int i = m; i<n; i++){
            getElement(putStack, popStack);
            pushToStack(putStack, in.nextInt());
            arrayMins[i-m+1] = findMin(putStack, popStack);
        }

        for (int arrayMin : arrayMins) {
            out.println(arrayMin);
        }

    }

    void pushToStack(Stack<Pair> stack, int a){
        int min = stack.empty() ? a : Math.min(a, stack.peek().getSecond());
        stack.push(new Pair(a, min));
    }

    void getElement(Stack<Pair> stack1, Stack<Pair> stack2){
        if (stack2.empty()){
            while (!stack1.empty()){
                int el = stack1.peek().getFirst();
                stack1.pop();
                pushToStack(stack2, el);
            }
        }
        stack2.pop();
    }

    int findMin(Stack<Pair> stack1, Stack<Pair> stack2){
        if (stack1.empty() || stack2.empty()){
            return stack1.empty() ? stack2.peek().getSecond() : stack1.peek().getSecond();
        }
        else return Math.min(stack1.peek().getSecond(), stack2
                .peek().getSecond());
    }


    void run() {
        try (Scanner in = new Scanner(System.in);
             PrintWriter out = new PrintWriter(System.out);) {
            solve(in, out);

        }
    }

    public static void main(String[] args) {

        new FindMinimumInWindow().run();

    }
}
