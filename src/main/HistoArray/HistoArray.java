import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class HistoArray {
    public static void main(String[] args) {
        Scanner data = null;
//        can initialize short arrays like this
        Integer[] count = {0,0,0,0,0,0,0,0,0,0};
        String[] alphabet = {"a", "b", "c"};
        String t = "Hello World";
        Integer idx;
        Integer haha;

        try {
            data = new Scanner(new File("test.dat"));
        }
        catch ( IOException e) {
            System.out.println("Unable to open data file");
            e.printStackTrace();
            System.exit(0);
        }

//        Indefinite Loops
        while(data.hasNextInt()) {
            idx = data.nextInt();
//            can index to them like python, unlike ArrayList -> count.set(idx, count.get(idx) + 1)
            count[idx] = count[idx] + 1;
        }

        idx = 0;
//        All primitive arrays can be used in a for each loop
        for(Integer i : count) {
            System.out.println(idx + " occured " + i + " times.");
            idx++;
        }

        for (String a: alphabet) {
            System.out.println(a);
        }

        for (char a: t.toCharArray()) {
            System.out.println(a);
        }

        haha = 0;
        do {
            System.out.println("Do while: " + haha);
            haha += 1;
        } while (haha <= 10);
    }
}