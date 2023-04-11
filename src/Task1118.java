import java.io.*;
import java.util.*;

class Task1118 {

    void solve(Scanner in, PrintWriter out){
        int h = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int s = 0;
        int days = 0;
        while (s+a<h){
            s = s+a-b;
            days++;
        }
        out.println(days+1);
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