import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Stack;

class BracketsTask {
     static class Pair {
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
        String input = in.nextLine();
        int index = 100002;
        char[] result = input.toCharArray();
        Stack<Pair> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            if (result[i] != '(' && result[i] != '[' && result[i] != '{' &&
                    result[i] != ')' && result[i] != ']' && result[i] != '}'){
                continue;
            }
            if (result[i] == '(' || result[i] == '[' || result[i] == '{') {
                stack.push(new Pair(result[i], i));
            } else if (stack.empty() && result[i] != ')' && result[i] != '}' && result[i] != ']'){
                index = 100002;
            }
            else if (!stack.empty() && (result[i] == ')' && stack.peek().getFirst() == '(' ||
                    result[i] == '}' && stack.peek().getFirst() == '{' ||
                    result[i] == ']' && stack.peek().getFirst() == '[' )) {
                stack.pop();
            } else {
                index = i+1;
                break;
            }
        }
        if (index == 100002 ) {
            if (stack.empty()) {
                out.println("Success");
            }
            else {out.println(stack.peek().getSecond()+1);}
        }
        else out.println(index);
    }


    void run() {
        try (Scanner in = new Scanner(System.in);
             PrintWriter out = new PrintWriter(System.out);) {
            solve(in, out);
        }


    }

    public static void main(String[] args) {
        new BracketsTask().run();
    }

}
