import java.io.*;
import java.util.*;

class Task263 {

    void solve(Scanner in, PrintWriter out){
        int a = in.nextInt();
        int a2 = in.nextInt();
        int a3 = in.nextInt();
        int max = Math.max(a2, a3);
        int min = Math.min(a2, a3);
        out.println(Math.min(max-min-1, a-max+min-1));
    }

    void run(){
        try(Scanner in = new Scanner(System.in);
            PrintWriter out = new PrintWriter(System.out);){
            solve(in, out);
        }
    }

    public static void main(String[] args){
        new Task263().run();
    }
}