import java.io.*;
import java.util.*;

class Task1118 {

    void solve(Scanner in, PrintWriter out){
        int h = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int res = ((h-a) + (a-b) -1 ) / (a-b) +1;
        out.println(Math.max(res, 1));
    }

    void run(){
        try(Scanner in = new Scanner(System.in);
            PrintWriter out = new PrintWriter(System.out);){
            solve(in, out);
        }
    }

    public static void main(String[] args){
        new Task1118().run();
    }
}