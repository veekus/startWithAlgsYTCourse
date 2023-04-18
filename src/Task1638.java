import java.io.*;
import java.util.*;

public class Task1638 {

    void solve(Scanner in, PrintWriter out){
        int book = in.nextInt();
        int cover = in.nextInt();
        int firstBook = in.nextInt();
        int lastBook = in.nextInt();
        int resultBooksRight = 2*cover+(Math.abs(lastBook - firstBook)-1)*(book+2*cover);
        int resultBooksLeft = resultBooksRight + 2*book;
        if (firstBook < lastBook) {
            out.println(resultBooksRight);
        }
        else if (firstBook > lastBook) {

            out.println(resultBooksLeft);
        }
        else out.println(book);
    }

    void run(){
        try(Scanner in = new Scanner(System.in);
            PrintWriter out = new PrintWriter(System.out);){
            solve(in, out);
        }
    }

    public static void main(String[] args){
        new Task1638().run();
    }
}