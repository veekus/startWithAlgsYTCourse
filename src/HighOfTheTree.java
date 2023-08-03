import java.io.PrintWriter;
import java.util.*;

public class HighOfTheTree {
    Map<Integer, Set<Integer>> tree;

    void solve(Scanner in, PrintWriter out) {
        int valPoints = in.nextInt();
        tree = new HashMap<>();
        int element;
        int root = 0;
        for (int i = 0; i < valPoints; i++) {
            element = in.nextInt();
            if (!tree.containsKey(element)) {
                Set<Integer> children = new HashSet<>();
                if (element == -1) {
                    root = i;
                    if (!tree.containsKey(root)) {
                        tree.put(i, children);
                    }
                    else continue;
                }
                else {
                    children.add(i);
                    tree.put(element, children);
                }
            }
            else tree.get(element).add(i);

        }
        out.println(high(root));


    }

    int high(int r) {
        int height = 1;
        if (tree.containsKey(r)) {
            for (int parent : tree.get(r)) {
                height = Math.max(height, 1 + high(parent));
            }
        }
        return height;
    }


    void run() {
        try (Scanner in = new Scanner(System.in);
             PrintWriter out = new PrintWriter(System.out);) {
            solve(in, out);
        }
    }

    public static void main(String[] args) {
        new HighOfTheTree().run();
    }
}
