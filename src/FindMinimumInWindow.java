import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Stack;

public class FindMinimumInWindow {

    void solve(Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        int head = m;
        int headAr = 0;
        Stack<Integer> popStack = new Stack<Integer>();
        Stack<Integer> putStack = new Stack<Integer>();
        Stack<Integer> putStackMins = new Stack<Integer>();
        Stack<Integer> popStackMins = new Stack<Integer>();
        int[] inArray = new int[n];
        int[] arrayMins = new int[n - m + 1];

        for (int i = 0; i<n; i++) {
            inArray[i] = in.nextInt();
        }

        for (int i=0 ; i<m; i++){
            putStack.push(inArray[i]);
            if (!putStackMins.empty() && putStackMins.peek()<putStack.peek()){
                putStackMins.push(putStackMins.peek());
            }
            else {
                putStackMins.push(putStack.peek());
            }
        }
        while (head<n) {
            while (!putStack.empty()) {
                popStack.push(putStack.pop());
                putStackMins.pop();
                if (!popStackMins.empty() && popStackMins.peek() < popStack.peek() ) {
                    popStackMins.push(popStackMins.peek());
                } else {
                    popStackMins.push(popStack.peek());
                }
            }

            while (!popStack.empty() && head!=n) {
                if (!putStackMins.empty() && popStackMins.peek() > putStackMins.peek() ) {
                    arrayMins[headAr] = putStackMins.peek();
                } else arrayMins[headAr] = popStackMins.peek();
                headAr++;
                popStack.pop();
                popStackMins.pop();
                putStack.push(inArray[head]);
                head++;
                if (!putStackMins.empty() && putStackMins.peek() < putStack.peek()) {
                    putStackMins.push(putStackMins.peek());
                } else {
                    putStackMins.push(putStack.peek());
                }
            }

        }
        if (!popStackMins.empty() && popStackMins.peek()<putStackMins.peek()){
            arrayMins[arrayMins.length - 1] = popStackMins.peek();
        }
        else arrayMins[arrayMins.length - 1] = putStackMins.peek();

        for (int i =0; i<arrayMins.length; i++){
            out.println(arrayMins[i]);
        }

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
