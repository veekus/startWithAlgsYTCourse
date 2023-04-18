import java.io.*;
import java.util.*;

class Task2 {

    void solve(Scanner in, PrintWriter out){
        int a = in.nextInt();
        int n = Math.max(1,a) - (Math.min(1, a)-1);
        out.println(n*(1+a)/2);
    }

    void run(){
        try(Scanner in = new Scanner(System.in);
            PrintWriter out = new PrintWriter(System.out)){
            solve(in, out);
        }
    }

    public static void main(String[] args){
        new Task2().run();
    }
}