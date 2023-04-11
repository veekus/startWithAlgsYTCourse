import java.io.*;
import java.util.*;

class Task263 {

    void solve(Scanner in, PrintWriter out){
        int k1 = in.nextInt();
        int l1 = in.nextInt();
        int m1 = in.nextInt();
        int k2 = in.nextInt();
        int l2 = in.nextInt();
        int m2 = in.nextInt();

        int currentBolts = k1-k1*l1/100;
        int currentScrews = k2-k2*l2/100;
        int change = (currentBolts - currentScrews) > 0 ? (currentBolts - currentScrews)*m1 : Math.abs(currentBolts - currentScrews)*m2;
        int res = k1*l1*m1/100 + k2*l2*m2/100 + change;
        out.println(res);
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