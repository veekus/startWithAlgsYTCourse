import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;
import java.util.Stack;

public class Second {

    void solve(Scanner in, PrintWriter out) {
        int m = in.nextInt();
        int n = in.nextInt();
        int[] inArray = new int[n];
        int[] arrayMins = new int[n - m + 1];

        for (int i = 0; i<n; i++) {
            inArray[i] = in.nextInt();
        }
        int l;

        for (int i = 0; i<n-m+1; i++) {
            l = inArray[i];
           for (int k = i; k<i+m; k++){
               if (inArray[k]<l){
                   l = inArray[k];
               }
           }
           arrayMins[i] = l;
        }


    }


    void run() {
        try (Scanner in = new Scanner(System.in);
             PrintWriter out = new PrintWriter(System.out);) {
            long d = new Date().getTime();
            solve(in, out);
            long m = new Date().getTime();
            out.println("time is");
            out.println(m-d);
        }
    }

    public static void main(String[] args) {




        new Second().run();


    }
}
