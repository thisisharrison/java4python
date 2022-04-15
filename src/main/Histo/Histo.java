import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;

public class Histo {

    public static void main(String[] args) {
        Scanner data = null;
//        list in Java
        ArrayList<Integer> count;
        Integer idx;

        try {
            data = new Scanner(new File("test.dat"));
        }
        catch ( IOException e) {
            System.out.println("Unable to open data file");
            e.printStackTrace();
            System.exit(0);
        }

        count = new ArrayList<Integer>(10);
//        Definite Loops
//        for i in range(10) in python or for (let i = 0; i < 10; i++) in js
        for (Integer i = 0; i < 10; i++) {
            count.add(i,0);
        }

//        while loops
        while(data.hasNextInt()) {
            idx = data.nextInt();
            count.set(idx,count.get(idx)+1);
        }

//        Also a Definite Loop
//        for each loop, for (const i of count) in js
//        Each execution, variable (i) is assigned to the next element of collection
//        This format can be used to loop through all kinds of Collection (ie. Sequence in python)
        idx = 0;
        for(Integer i : count) {
            System.out.println(idx + " occured " + i + " times.");
            idx++;
        }
    }
}

//0 occured 0 times.
//2 occured 1 times.
//1 occured 2 times.
//3 occured 1 times.
//4 occured 0 times.
//5 occured 0 times.
//6 occured 0 times.
//7 occured 0 times.
//8 occured 0 times.
//9 occured 1 times.

